package com.google.appinventor.server;

import com.google.appinventor.server.flags.Flag;
import com.google.appinventor.server.storage.StorageIo;
import com.google.appinventor.server.storage.StorageIoInstanceHolder;
import com.google.appinventor.server.storage.StoredData.PWData;
import com.google.appinventor.server.tokens.Token;
import com.google.appinventor.server.tokens.TokenException;
import com.google.appinventor.server.tokens.TokenProto;
import com.google.appinventor.server.util.UriBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;

import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.List;
import com.google.appinventor.shared.rpc.user.AiaStore;
import com.google.appinventor.shared.rpc.user.AiaBuy;
import com.google.appinventor.server.util.PasswordHash;
import com.google.appinventor.shared.rpc.user.User;
import com.google.appinventor.shared.rpc.admin.AdminUser;
import com.google.appinventor.shared.rpc.AdminInterfaceException;
import java.text.SimpleDateFormat;

/**
 * AiaStoreServlet -- 应用商店
 *
 * @author AI2中文网
 */
@SuppressWarnings("unchecked")
public class AiaStoreServlet extends HttpServlet {

  private final StorageIo storageIo = StorageIoInstanceHolder.getInstance();
  private static final Logger LOG = Logger.getLogger(AiaStoreServlet.class.getName());
  private final PolicyFactory sanitizer = new HtmlPolicyBuilder().allowElements("p").toFactory();
  static final SimpleDateFormat expiredFormat = new SimpleDateFormat("yyyy/MM/dd");

  public void init(ServletConfig config) throws ServletException {
    super.init(config);
  }
  public void destroy() {
    super.destroy();
  }

  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    resp.setContentType("text/html; charset=utf-8");

    String [] components = req.getRequestURI().split("/");
    String page = getPage(req);

    String queryString = req.getQueryString();
    HashMap<String, String> params = getQueryMap(queryString);
    String to_page = "list.jsp";

    // 回调返回，开通服务
    if (page.equals("return")) {
      
      //pay_succ(req, resp, phone, period);
    } else if (page.equals("publish")) {
      // 发布页
      to_page = "publish.jsp";
      
    } else if (page.equals("aia-store") || page.equals("")) {
      List<AiaStore> aiaList = storageIo.getAiaStoreList();
      req.setAttribute("aiaList", aiaList);
    } else {
      // 详情页
      AiaStore as = storageIo.getAiaStore(page);
      if (as == null) {
        resp.sendRedirect("/aia_store/aia.jsp?error=" + sanitizer.sanitize("Aia Not Found: " + page));
        return;
      }
      req.setAttribute("aia", as);
      to_page = "aia.jsp";
    }

    OdeAuthFilter.UserInfo userInfo = OdeAuthFilter.getUserInfo(req);
    req.setCharacterEncoding("UTF-8");
    if (userInfo != null) {
      User user = storageIo.getUser(userInfo.getUserId());
      if (user != null && !user.getUserEmail().equals("test@fun123.cn")) {
        req.setAttribute("phone", user.getUserEmail());
      }
    }
    
    try {
      req.getRequestDispatcher("/aia_store/" + to_page).forward(req, resp);
    } catch (ServletException e) {
      throw new IOException(e);
    }
  }

  /**
	 * 生成唯一编号
	 *
	 * @return {String}
	 */
	public static String getNo() {
		SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmssSSS", Locale.getDefault());
		Date date = new Date();
		String key = format.format(date);
		return key;
	}

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(req.getInputStream()));
    String queryString = input.readLine();
    HashMap<String, String> params = getQueryMap(queryString);
    String page = getPage(req);

    if (page.equals("publish")) {
      // 发布页
      String title = params.get("title");
      if (title == null || title.equals("")) {
        fail(req, resp, "Invalid title!");
        return;
      }

      AiaStore podata = new AiaStore();
      podata.asId = getNo();
      podata.title = title;
      podata.phone = params.get("phone");
      podata.aia_path = params.get("aia_path");
      podata.pics = params.get("pics");
      podata.contents = params.get("contents");
      podata.price = params.get("price");
      podata.app_status = "审核中";//审核状态
      podata.ranking = "0";//综合排名
      podata.num_screen = Integer.parseInt(params.get("num_screen"));
      podata.num_blocks = Integer.parseInt(params.get("num_blocks"));
      podata.catalog = params.get("catalog");//aia分类
      podata.quality = params.get("quality");//质量等级
      podata.score = "0";//最新评分
      storageIo.storeAiaStore(podata);

      List<AiaStore> aiaList = storageIo.getAiaStoreList();
      req.setAttribute("aiaList", aiaList);
      resp.sendRedirect("/aia-store/");
    }
  }

  private static HashMap<String, String> getQueryMap(String query)  {
    HashMap<String, String> map = new HashMap<String, String>();
    if (query == null || query.equals("")) {
      return map;               // Empty map
    }
    String[] params = query.split("&");
    for (String param : params)  {
      String [] nvpair = param.split("=");
      if (nvpair.length <= 1) {
        map.put(nvpair[0], "");
      } else
        map.put(nvpair[0], URLDecoder.decode(nvpair[1]));
    }
    return map;
  }

  private String getPage(HttpServletRequest req) {
    String [] components = req.getRequestURI().split("/");
    return components[components.length-1];
  }

  private String getParam(HttpServletRequest req) {
    String [] components = req.getRequestURI().split("/");
    if (components.length < 2)
      return null;
    return components[components.length-2];
  }

  private String trimPage(HttpServletRequest req) {
    String [] components = req.getRequestURL().toString().split("/");
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < components.length-1; i++)
      sb.append(components[i] + "/");
    return sb.toString();
  }

  private void fail(HttpServletRequest req, HttpServletResponse resp, String error) throws IOException {
    String page = getPage(req);
    resp.sendRedirect("/aia_store/" + page + "?error=" + sanitizer.sanitize(error));
    return;
  }

}
