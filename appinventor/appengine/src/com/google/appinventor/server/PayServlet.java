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
import com.google.appinventor.shared.rpc.user.PayOrder;
import com.google.appinventor.server.util.PasswordHash;
import com.google.appinventor.shared.rpc.user.User;
import com.google.appinventor.shared.rpc.admin.AdminUser;
import com.google.appinventor.shared.rpc.AdminInterfaceException;
import java.text.SimpleDateFormat;

/**
 * PayServlet -- 支付相关功能
 *
 * @author AI2中文网
 */
@SuppressWarnings("unchecked")
public class PayServlet extends HttpServlet {

  private final StorageIo storageIo = StorageIoInstanceHolder.getInstance();
  private static final Logger LOG = Logger.getLogger(PayServlet.class.getName());
  private final PolicyFactory sanitizer = new HtmlPolicyBuilder().allowElements("p").toFactory();
  static final SimpleDateFormat expiredFormat = new SimpleDateFormat("yyyy/MM/dd");

  // Alipay普通公钥方式
  public static final AlipayClient alipayClient = new DefaultAlipayClient(
    "https://openapi.alipay.com/gateway.do", //支付宝支付网关
    "2021004121618261", //应用编号
    "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCQG+Z+O4gW91TRhkrUTvTwIVfEVII6QyhUjwnHOKgs6R32rA6HmZgwd8kD+uhRH62yQXY5V0IOqkUGgpgOsd/E2Iuh9VVmfoubzqsQyo5EMTFFL/sf1vYEt5iDv5Eo2t+g7pdyUrl4t3B5J1mMecyYNK0tVSZ3eTYcu6e4bB6gIyleeIf1KIhf/xsOcsfN511X4hoQDaYYKwhE92HwN5JIjqnWKavN9Aia3AVy7LS+TOKlsErX72KO2S8sll3+8LmVOWqwbp20f6izykPqcZmzeXnmlx5e1YXS46lDiVWsujJboyDJoWbC4KYXfZhpnrhvqaevsHeYloNMosiOT67TAgMBAAECggEAHE1OdEYu0QvcHZY5Rf8Hvc1ellFejiC4X/sDmZu387IIz3Q1Gk6BBCvST7TMQXpuO479r/9CGu03xzKIuIIYh2lb6v/quMlrk7r//7k4PY5HteXZdQRbpsuD6YQK9zIdL1cMaUhz4pBsR28B+EPHebEGvdt2RYqJpRT5uI+LaDmSsQRnxkAQ3R5OhxJn3hKt/u0J/G4CLx1V1hcIbpUd0cm+A+oPfzgtw128KP7P3OnK1Bi96Cgy7frdpPZeVL6+LBOHKqPsL6mPIcL5iAsKoTS1mvTBS2nemZWmJ+rD8IbfVHG9lVdRmoe5Z9DPGg0XY18Kh2qZH2wu+nPxz1LxOQKBgQDp7aqi599qATWNjFAp96NrI7ujCfePsJMkDhcrkD2eWeU/WZW2lYe5xcbFwzkA6rMRbw/STUmPcC+3wwpgYc+bZjD7ghn4f1grpypkVgWY4B8LOcU8kZ8Db1AJQJdPT81cy/B+H2rjWvamEbYNSdyuduuK9uUSxSvE1+BToIJorwKBgQCdtLnAKdSaR3481ArPUB5abvactJQYplW9SCSF5scWQ4UU2Tj5bnMrk7czLlwmop6TdUmxMHxaXbJI+SuAAhuXGL4aDMFOW5D3rsNUsJga6nprLl/ABo01SZ2dZQr4J+xCoUdjxamixmIsvmQi8dlH/5N9mGld52FO7AodMLIdHQKBgCejZxOdmMTcmZd3nCnQVXeVIXlZ+gH2GKi2XoS6N0a60tauNmku40W+VpUyJFmca2Vb3WF0SS+uAdfwi7STPluFsG0duYrbATS8abmAvggOihQb4OkHf9tUJEq9ECaXTiQYRpMIfdMymbLAM4oC5wsFCZqNhXltwaHkNpXVD+PvAoGAfcrxOzFijukl7XkpYjHC9Fl8RoTXeE39J+0KjPAGr2COH5IhGvyZyxGZWK7K/FpMaMxuSnKlTiNcmU5+/y0vOreWswqnikwJdzckQUJXIWkU2rdz0qSnL/EXUruNI2Ic1wzz98ZryBW7q3r2PtVwfjiDOfQ/X5K3EI/AhYYZHJUCgYAvWkXdwJ5qysO59wHpOH537fitIXxnXcRj9QROz5KwBawcGjbrEpO8PtlBnevPdl3D2Bty+0CPYh+rAwKLi5IMbYyK/AX3jtCT57I3aSDzSd2PMFBxkSLTx/pOB/dFoxEL73WD/189m3ig9rNAzCa9N+OSyY/FNsB/YJzXZqyeVg==", //应用私钥
    "", //为空默认为 JSON
    "", //字符集为空默认为 UTF-8
    "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAz9aj/SzpJTWhaUIbl0JH1hrAVtv+jXbcTYqqQzPMRJgYZxbNc93Ct5D5Dv6PJrd2sWioRi6buMY8B+RtegR/XPDL+ULDGNb8OguIgDRBlYI40kIKSd2IrwQACRwBHMQ6poHptvrDp+ht/sd5f8DGlxh3DIjuBswldaJTDptZjQ+5S3Ti619kjnJO+Yvl5IjSgnDO5Ggzk1d0QT1asg43DlEFAphMOOLM6JIDLm8Us6yI7FCVmfitT+IW9SLeHuiyWeescifZLewxJERktJv+ikIK0SoT1yXiI5UTsNrDTnRTz3SW64JO2yvC8v4gbAEoz67RbWGZe+S3wxlvCvI6uwIDAQAB", //支付宝公钥
    "RSA2"
    );

  // 回调url前缀
  private String CALLBACK_URL_PRE = "https://www.fun123.cn";
  //private String CALLBACK_URL_PRE = "http://192.168.1.11:8088"; //for dev

  public void init(ServletConfig config) throws ServletException {
    super.init(config);
  }
  public void destroy() {
    super.destroy();
  }


  // 跳转到支付成功页面
  private void pay_succ(HttpServletRequest req, HttpServletResponse resp, String phone, String period) throws IOException {
    try {
      req.setAttribute("phone", phone);
      req.setAttribute("period", period);
      req.getRequestDispatcher("/pay_succ.jsp").forward(req, resp);
    } catch (ServletException e) {
      throw new IOException(e);
    }
  }
  // 跳转到支付失败页面
  private void pay_fail(HttpServletRequest req, HttpServletResponse resp, String phone, String period, String error) throws IOException {
    try {
      req.setAttribute("phone", phone);
      req.setAttribute("period", period);
      req.getRequestDispatcher("/pay_fail.jsp?error=" + sanitizer.sanitize(error)).forward(req, resp);
    } catch (ServletException e) {
      throw new IOException(e);
    }
  }

  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    resp.setContentType("text/html; charset=utf-8");

    String [] components = req.getRequestURI().split("/");
    String page = getPage(req);

    String queryString = req.getQueryString();
    HashMap<String, String> params = getQueryMap(queryString);

    // 回调返回，开通服务
    if (page.equals("return")) {
      String trade_no = params.get("out_trade_no");
      String method = params.get("method");//alipay.trade.page.pay.return 类型
      String total_amount = params.get("total_amount"); //金额

      String phone = trade_no.substring(1, 12);
      String period = trade_no.substring(12, 14);
      int iperiod = 0;
      try {
        iperiod = Integer.parseInt(period);
      } catch (NumberFormatException e) {
        pay_fail(req, resp, phone, period, "Period parse Error! Please contact customer service." + trade_no);
        return;
      }
      if (iperiod <= 0 || iperiod > 96) {
        pay_fail(req, resp, phone, period, "Period Error! Please contact customer service." + trade_no);
        return;
      }

      //==========================回填订单信息===================================
      PayOrder order = storageIo.getPayOrder(trade_no);
      if (order == null) {
        pay_fail(req, resp, phone, period, "Invalid order:" + trade_no);
        return;
      }
      LOG.info("==> order.status:" + order.status);
      if (order.status.equals("支付成功")) {
        pay_fail(req, resp, phone, period, "The order has been paid:" + trade_no);
        return;
      }

      // ---------------------开通服务----------------------
      AdminUser user = storageIo.getAdminUserFromEmail(phone);
      if (user == null) {
        user = new AdminUser(null, phone, phone, false, false, null, null, null, null);
      }

      // 原有的来源，不覆盖
      if (user.getFrom() == null || user.getFrom().equals(""))
        user.setFrom("PCPay");

      // 原密码为空才设置初始密码，否则留空不修改密码
      if (user.getPassword() == null || user.getPassword().equals(""))
        user.setPassword(phone.substring(5));
      else 
        user.setPassword(null);

      if (user.getRemark() == null || user.getRemark().equals(""))
        user.setRemark(trade_no);
      else
        user.setRemark(user.getRemark() + ";" + trade_no);

      // 只有上次的日期比当天新，才以新日期为基准
      Date lastExpiredDate = new Date();
      try {
        lastExpiredDate = expiredFormat.parse(expiredFormat.format(new Date()));
      } catch (Exception e) { 
      }

      if (user.getExpired() != null && user.getExpired().after(lastExpiredDate))
        lastExpiredDate = user.getExpired();

      // 基准日期延长几个月
      lastExpiredDate.setMonth(lastExpiredDate.getMonth() + iperiod);
      user.setExpired(lastExpiredDate);
      
      String password = user.getPassword();
      //LOG.info("==> password:" + password);
      String hashedPassword = "";
      if (password != null && !password.equals("")) {
        try {
          hashedPassword = PasswordHash.createHash(password);
          user.setPassword(hashedPassword);
          //LOG.info("==> password:" + hashedPassword);
        } catch (NoSuchAlgorithmException e) {
          throw new IllegalArgumentException("Error hashing password");
        } catch (InvalidKeySpecException e) {
          throw new IllegalArgumentException("Error hashing password");
        }
      }
      try {
        storageIo.storeUser(user, password);
      } catch (AdminInterfaceException e) {
        pay_fail(req, resp, phone, period, "Vip open failed! Please contact customer service." + e.getMessage());
        return;
      }
      // -------------------------------------------

      //order.phone = phone;
      //order.period = period;
      //order.amount = amount;
      order.status = "支付成功";
      order.userId = user.getId();
      order.method = method;
      storageIo.storePayOrder(order);
      //========================================================================

      //PrintWriter out = resp.getWriter();
      //out.write(total_amount + "---" + phone + "---" + period);
      //out.flush();
      //out.close();
      pay_succ(req, resp, phone, period);
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
      req.getRequestDispatcher("/pay.jsp").forward(req, resp);
    } catch (ServletException e) {
      throw new IOException(e);
    }
  }

  /**
	 * 生成唯一订单号
	 *
	 * @return {String}
	 */
	public static String getOutTradeNo(String phone, int period) {
		SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmssSSS", Locale.getDefault());
		Date date = new Date();
		String key = phone + String.format("%02d", period) + format.format(date);
		return key;
	}

  private static boolean isNumericZidai(String str) {
    for (int i = 0; i < str.length(); i++) {
        System.out.println(str.charAt(i));
        if (!Character.isDigit(str.charAt(i))) {
            return false;
        }
    }
    return true;
  }
  // 检查手机号码正确性
  private boolean IsPhoneNum(String phone) {
    return phone.length() == 11 && isNumericZidai(phone);
  }

  // PC支付
  protected void pc_pay(HttpServletRequest req, HttpServletResponse resp, String subject, String phone, int period, String amount) throws IOException {    
		AlipayTradePagePayModel model = new AlipayTradePagePayModel();
    model.setOutTradeNo("P" + getOutTradeNo(phone, period));
    model.setProductCode("FAST_INSTANT_TRADE_PAY");
    //model.setPassbackParams("passback_params"); //自定义参数，url编码
		model.setSubject(subject);//订单标题
    //model.setBody("pc test desc..."); //订单描述信息
		model.setTotalAmount(amount);//支付金额
		
		try {
      LOG.info("==> pc trade no:" + model.getOutTradeNo());
      AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
      request.setBizModel(model);
      request.setNotifyUrl(CALLBACK_URL_PRE + "/pay/notify");
      request.setReturnUrl(CALLBACK_URL_PRE + "/pay/return");
      AlipayTradePagePayResponse alipayResp = alipayClient.pageExecute(request);
      LOG.info("==> pc pay resp:" + alipayResp.getBody());

      if (alipayResp.isSuccess()) {

        //==========================生成订单信息===================================
        PayOrder order = new PayOrder();
        order.orderId = model.getOutTradeNo();
        order.phone = phone;
        order.period = period;
        order.amount = amount;
        order.status = "待支付";
        storageIo.storePayOrder(order);
        //========================================================================

        //处理成功
        String form = alipayResp.getBody();
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write(form);
        out.flush();
        out.close();

      } else {  //其他状态, 表示下单失败
          fail(req, resp, "Sorry! Pay Failed, Please contact customer service.");
          return;
      }

		} catch (Exception e) {
      fail(req, resp, e.getMessage());
      return;
		}
  }

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(req.getInputStream()));
    String queryString = input.readLine();
    HashMap<String, String> params = getQueryMap(queryString);
    //String page = getPage(req);

    String subject = params.get("subject");
    String phone = params.get("phone");
    if (!IsPhoneNum(phone)) {
      fail(req, resp, "Invalid phone number!");
      return;
    }

    String period = params.get("period");
    String amount = params.get("amount");
    int iperiod = 0;
    try {
      iperiod = Integer.parseInt(period);
    } catch (NumberFormatException e) {
      fail(req, resp, "Data Error! Please contact customer service.");
      return;
    }

    if (iperiod <= 0 || iperiod > 96) {
      fail(req, resp, "Invalid period!");
      return;
    }

    // 简单的金额检查，防止客户端篡改
    double peramount = 0.0;
    try {
      peramount = Double.parseDouble(amount) / iperiod;
    } catch (NumberFormatException e) {
      fail(req, resp, "Invalid amount!");
      return;
    }

    if (peramount < 6) {
      fail(req, resp, "Invalid order !!!");
      return;
    }

    pc_pay(req, resp, subject, phone, iperiod, amount);
  }


  // protected void qr_pay(HttpServletRequest req, HttpServletResponse resp, String subject, String phone, int period, String amount) throws IOException {
  //   String subject = "支付宝扫码支付测试";
	// 	String totalAmount = "0.1";
	// 	String notifyUrl = "https://www.fun123.cn/pay/notify";

	// 	AlipayTradePrecreateModel model = new AlipayTradePrecreateModel();
	// 	model.setSubject(subject);//订单标题
  //   model.setBody("test desc..."); //订单描述信息
	// 	model.setTotalAmount(totalAmount);//支付金额
	// 	//model.setStoreId(storeId);//门店id
	// 	model.setTimeoutExpress("5m");// 订单超时时间
	// 	model.setOutTradeNo("Q" + getOutTradeNo(phone, period));
	// 	try {
  //     AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
  //     request.setBizModel(model);
  //     request.setNotifyUrl(notifyUrl);

  //     LOG.info("==> qr trade no:" + model.getOutTradeNo());
  //     //调起支付宝 （如果异常， 将直接抛出ChannelException ）
  //     AlipayTradePrecreateResponse alipayResp = alipayClient.execute(request);

  //     LOG.info("==> qr pay resp:" + alipayResp.getBody());
  //     // ↓↓↓↓↓↓ 调起接口成功后业务判断务必谨慎！！ 避免因代码编写bug，导致不能正确返回订单状态信息  ↓↓↓↓↓↓
  //     if(alipayResp.isSuccess()){ //处理成功

  //         fail(req, resp, alipayResp.getQrCode());
  //         return;

  //     } else {  //其他状态, 表示下单失败
  //         fail(req, resp, "QRPay Failed");
  //         return;
  //     }

	// 	} catch (Exception e) {
  //     fail(req, resp, e.getMessage());
  //     return;
	// 	}
  // }

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
    resp.sendRedirect("/pay/?error=" + sanitizer.sanitize(error));
    return;
  }

}
