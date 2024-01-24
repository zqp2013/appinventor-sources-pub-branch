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
import javax.servlet.*;
import javax.servlet.http.*;
import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;

import java.io.*;
import java.util.Iterator;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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

  // 回调url前缀
  //private String CALLBACK_URL_PRE = "https://www.fun123.cn";
  private String CALLBACK_URL_PRE = "http://192.168.1.11:8088"; //for dev
  
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
  }
  public void destroy() {
    super.destroy();
  }

  // 订单编号规则
  private static String genTradeNo(String phone, String asId) {
		return "A" + phone + asId;
	}

  // 检查是否已经购买
  private boolean ValidateBuy(String phone, String asId) {
    boolean has_buy = false;
    String trade_no = genTradeNo(phone, asId);
    AiaBuy order = storageIo.getAiaBuy(trade_no);
    if (order != null && order.price != null && !"".equals(order.price)) {
      has_buy = true;
    }
    return has_buy;
  }

  // PC支付（来自PayServlet.java）
  protected void pc_pay(HttpServletRequest req, HttpServletResponse resp, String asId, String subject, String owner_phone, String buy_phone, String amount) throws IOException {    
		AlipayTradePagePayModel model = new AlipayTradePagePayModel();
    model.setOutTradeNo(genTradeNo(buy_phone, asId));
    model.setProductCode("FAST_INSTANT_TRADE_PAY");
		model.setSubject(subject);//订单标题
		model.setTotalAmount(amount);//支付金额
		
		try {
      LOG.info("==> pc trade no:" + model.getOutTradeNo());
      AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
      request.setBizModel(model);
      request.setNotifyUrl(CALLBACK_URL_PRE + "/aia-store/notify");
      request.setReturnUrl(CALLBACK_URL_PRE + "/aia-store/return");
      AlipayTradePagePayResponse alipayResp = PayServlet.alipayClient.pageExecute(request);
      LOG.info("==> pc pay resp:" + alipayResp.getBody());

      if (alipayResp.isSuccess()) {

        //==========================生成订单信息===================================
        AiaBuy order = new AiaBuy();
        order.orderId = model.getOutTradeNo();
        order.asId = asId;
        order.owner_phone = owner_phone;
        order.buy_phone = buy_phone;
        storageIo.storeAiaBuy(order);
        //========================================================================

        //处理成功
        String form = alipayResp.getBody();
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write(form);
        out.flush();
        out.close();

      } else {  //其他状态, 表示下单失败
          resp.sendRedirect("/aia_store/aia.jsp?error=" + sanitizer.sanitize("Sorry! Pay Failed, Please contact customer service."));
          return;
      }

		} catch (Exception e) {
      resp.sendRedirect("/aia_store/aia.jsp?error=" + sanitizer.sanitize(e.getMessage()));
      return;
		}
  }

  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    resp.setContentType("text/html; charset=utf-8");

    String [] components = req.getRequestURI().split("/");
    String page = getPage(req);

    String queryString = req.getQueryString();
    HashMap<String, String> params = getQueryMap(queryString);
    String to_page = "list.jsp";

    // 当前用户信息
    OdeAuthFilter.UserInfo userInfo = OdeAuthFilter.getUserInfo(req);
    User user = null;
    req.setCharacterEncoding("UTF-8");
    if (userInfo != null) {
      user = storageIo.getUser(userInfo.getUserId());
      if (user != null && !user.getUserEmail().equals("test@fun123.cn")) {
        req.setAttribute("phone", user.getUserEmail());
        req.setAttribute("is_admin", user.getIsAdmin());
      }
    }

    if (page.equals("return")) {
      // ----回调返回，购买成功----
      String trade_no = params.get("out_trade_no");
      String method = params.get("method");//alipay.trade.page.pay.return 类型
      String total_amount = params.get("total_amount"); //金额

      String phone = trade_no.substring(1, 12);
      String asId = trade_no.substring(12);

      //==========================回填订单信息===================================
      AiaBuy order = storageIo.getAiaBuy(trade_no);
      if (order == null) {
        resp.sendRedirect("/aia_store/aia.jsp?error=" + sanitizer.sanitize("Invalid order: " + trade_no));
        return;
      }
      if (order.price != null && !"".equals(order.price)) {
        resp.sendRedirect("/aia_store/aia.jsp?error=" + sanitizer.sanitize("The order has been paid: " + trade_no));
        return;
      }

      order.price = total_amount;
      order.commission = "0";//TODO：计算佣金
      order.buy_time = new Date();
      storageIo.storeAiaBuy(order);
      //========================================================================

      // 跳到详情页
      AiaStore as = storageIo.getAiaStore(asId);
      if (as == null) {
        resp.sendRedirect("/aia_store/aia.jsp?error=" + sanitizer.sanitize("Aia Not Found: " + asId));
        return;
      }
      req.setAttribute("aia", as);
      req.setAttribute("has_buy", true); //是否已经购买
      to_page = "aia.jsp";

    } else if (page.equals("publish")) {
      // --------发布页----------
      to_page = "publish.jsp";
      
    } else if (page.equals("aia-store") || page.equals("")) {


      //可以查看某人的项目列表
      //String phone = params.get("phone");
      //String order = params.get("order");
      //String desc = params.get("desc");

      List<AiaStore> aiaList = storageIo.getAiaStoreList();
      req.setAttribute("aiaList", aiaList);

    } else if (page.equals("rm")) {
      //--------删除--------
      String asId = params.get("id");
      if (asId == null || "".equals(asId)) {
        resp.sendRedirect("/aia_store/aia.jsp?error=" + sanitizer.sanitize("Invalid param!"));
        return;
      }
      storageIo.deleteAiaStore(asId);

      List<AiaStore> aiaList = storageIo.getAiaStoreList();
      req.setAttribute("aiaList", aiaList);

    } else if (page.equals("update")) {
      //-------更新-------
      String asId = params.get("id");
      if (asId == null || "".equals(asId)) {
        resp.sendRedirect("/aia_store/aia.jsp?error=" + sanitizer.sanitize("Invalid param!"));
        return;
      }
      AiaStore as = storageIo.getAiaStore(asId);
      if (as == null) {
        resp.sendRedirect("/aia_store/aia.jsp?error=" + sanitizer.sanitize("Aia Not Found: " + asId));
        return;
      }
      req.setAttribute("aia", as);
      to_page = "publish.jsp";

    } else if (page.equals("pay")) {
      //--------购买--------
      String asId = params.get("id");
      if (asId == null || "".equals(asId)) {
        resp.sendRedirect("/aia_store/aia.jsp?error=" + sanitizer.sanitize("Invalid id param!"));
        return;
      }
      AiaStore as = storageIo.getAiaStore(asId);
      if (as == null) {
        resp.sendRedirect("/aia_store/aia.jsp?error=" + sanitizer.sanitize("Aia Not Found: " + asId));
        return;
      }
      String subject = params.get("subject");
      String buy_phone = params.get("phone");
      if (subject == null || "".equals(subject) || buy_phone == null || "".equals(buy_phone)) {
        resp.sendRedirect("/aia_store/aia.jsp?error=" + sanitizer.sanitize("Invalid params!"));
        return;
      }
      if (ValidateBuy(buy_phone, asId)) { //重复购买：跳转到验证购买页面
        resp.sendRedirect("/aia-store/validatebuy?phone=" + buy_phone + "&id=" + asId);
        return;
      }
      
      String amount = params.get("amount");  
      pc_pay(req, resp, asId, subject, as.phone, buy_phone, amount);
      return;

    } else if (page.equals("validatebuy")) {
      //--------购买验证--------
      String phone = params.get("phone");
      String asId = params.get("id");
      if (phone == null || "".equals(phone) || asId == null || "".equals(asId)) {
        resp.sendRedirect("/aia_store/aia.jsp?error=" + sanitizer.sanitize("Invalid param!"));
        return;
      }
      AiaStore as = storageIo.getAiaStore(asId);
      if (as == null) {
        resp.sendRedirect("/aia_store/aia.jsp?error=" + sanitizer.sanitize("Aia Not Found: " + asId));
        return;
      }
  
      boolean has_buy = ValidateBuy(phone, asId);
      req.setAttribute("has_buy", has_buy); //是否已经购买
      req.setAttribute("aia", as);
      to_page = "aia.jsp";

    } else {
      // -----详情页-----
      AiaStore as = storageIo.getAiaStore(page);
      if (as == null) {
        resp.sendRedirect("/aia_store/aia.jsp?error=" + sanitizer.sanitize("Aia Not Found: " + page));
        return;
      }
    
      // 检查是否已经购买
      boolean has_buy = false;
      if (user != null && !user.getUserEmail().equals("test@fun123.cn")) {
        has_buy = ValidateBuy(user.getUserEmail(), page);
      }

      req.setAttribute("has_buy", has_buy); //是否已经购买
      req.setAttribute("aia", as);
      to_page = "aia.jsp";
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

  // 发布页
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    HashMap<String, String> params = genFormDataMap(req);
    String title = params.get("title");
    if (title == null || title.equals("")) {
      resp.sendRedirect("/aia_store/publish.jsp?error=" + sanitizer.sanitize("Invalid title!"));
      return;
    }
    String phone = params.get("phone");
    if (phone == null || phone.equals("")) {
      resp.sendRedirect("/aia_store/publish.jsp?error=" + sanitizer.sanitize("Invalid account info!"));
      return;
    }

    AiaStore podata = new AiaStore();
    podata.asId = params.get("asId");
    podata.title = title;
    podata.phone = phone;
    podata.aia_path = params.get("aia_path");
    podata.apk_path = params.get("apk_path");
    podata.pics = params.get("pics");
    podata.contents = params.get("contents");
    podata.price = params.get("price");
    podata.app_status = "审核中";//审核状态
    podata.ranking = "0";//综合排名
    podata.num_screen = Integer.parseInt(params.get("num_screen"));
    podata.num_blocks = Integer.parseInt(params.get("num_blocks"));
    podata.catalog = params.get("catalog");//aia分类
    podata.quality = params.get("quality");//质量等级
    podata.provide_support = params.get("provide_support");//是否提供售后支持
    podata.score = "0";//最新评分
    storageIo.storeAiaStore(podata);

    resp.sendRedirect("/aia-store/" + podata.asId);
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

  private static HashMap<String, String> genFormDataMap(HttpServletRequest req)  {
    String asno = "";
    HashMap<String, String> map = new HashMap<String, String>();
    try {
      //String tempPathDir = "";
      //File tempPathDirFile = new File(tempPathDir);
      // 创建工厂
      DiskFileItemFactory factory = new DiskFileItemFactory();
      // 设置缓冲区大小，这里是400kb
      factory.setSizeThreshold(4096 * 100);
      // 设置缓冲区目录
      //factory.setRepository(tempPathDirFile);
      // Create a new file upload handler
      ServletFileUpload upload = new ServletFileUpload(factory);
      // 设置上传文件的大小 12M
      upload.setSizeMax(4194304 * 3);
      // 创建解析器
      // 得到所有的文件
      List<FileItem> items = upload.parseRequest(req);
      Iterator<FileItem> i = items.iterator();
      while (i.hasNext()) {
        FileItem fi = i.next();
        // false表示文件 否则字段
        if (!fi.isFormField()) {
          String fileName = fi.getName();
          if (fileName != null && !"".equals(fileName)) {
            String savePath = req.getRealPath("reference/oss/") + "/" + asno + "/" + fileName;
            File file = new File(savePath);
            file.getParentFile().mkdirs(); // Will create parent directories if not exists
            file.createNewFile(); // if file already exists will do nothing 

            // 定义图片流
            InputStream fin = fi.getInputStream();
            // 定义图片输出流
            FileOutputStream fout = new FileOutputStream(file, false);
            // 写文件
            byte[] b = new byte[1024];
            int length = 0;
            while ((length = fin.read(b)) > 0) {
              fout.write(b, 0, length);
            }
            // 关闭数据流
            fin.close();
            fout.close();

            map.put(new String(fi.getFieldName()), "/reference/oss/" + asno + "/" + fileName);
          }
        } else {
          //字段
          map.put(new String(fi.getFieldName()), new String(fi.getString("UTF-8")));
          if (fi.getFieldName().equals("asId")) {
            asno = fi.getString("UTF-8");
            if (asno == null || "".equals(asno)) {
              asno = getNo();
              map.put("asId", asno);
            }
          }
        }
      }
    } catch (Exception e) {
      throw CrashReport.createAndLogError(LOG, req, null, e);
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

}
