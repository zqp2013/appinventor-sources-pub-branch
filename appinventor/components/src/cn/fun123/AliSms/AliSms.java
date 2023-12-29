package cn.fun123.AliSms;

import static android.Manifest.permission.INTERNET;

import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.runtime.util.*;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.aliyun.tea.*;
import java.util.Random;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@DesignerComponent(version = 1,
        versionName = "1.0",
        description = "阿里云短信平台接入，开通短信服务及添加短信模板流程请<a href=\"https://help.aliyun.com/zh/sms/user-guide/usage-notes\" target=\"_blank\">点击这里</a>，填入必要的信息即可调用API直接发送短信。",
        helpUrl = "https://www.fun123.cn/reference/extensions/",
        category = ComponentCategory.EXTENSION,//展示在appinventor的哪个模块下
        nonVisible = true,//不可见
        iconName = "images/extension.png")//这个组件的图标

@SimpleObject(external = true)
@UsesPermissions({INTERNET})
@UsesLibraries(libraries = "tea-1.1.14.jar, tea-openapi-0.2.8.jar, tea-util-0.2.16.jar, tea-console-0.0.1.jar, dysmsapi20170525-2.0.23.jar, credentials-java-0.2.4.jar, openapiutil-0.2.0.jar, okhttp-3.12.13.jar, okio-1.15.0.jar, gson-2.7.jar")
public class AliSms extends AndroidNonvisibleComponent {
    private String accessKeyId = "";
    private String accessKeySecret = "";

    public AliSms(ComponentContainer container) {
        super(container.$form());
    }

    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_STRING,
      defaultValue = "")
    @SimpleProperty(category = PropertyCategory.APPEARANCE,
      description = "AccessKey ID")
    public void AccessKeyId(String text) {
        this.accessKeyId = text;
    }

    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_STRING,
      defaultValue = "")
    @SimpleProperty(category = PropertyCategory.APPEARANCE,
      description = "AccessKey Secret")
    public void AccessKeySecret(String text) {
        this.accessKeySecret = text;
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

    @SimpleFunction(description = "发送短信并返回发送结果。参数：手机号，签名名称，模板CODE，模板参数JSON")
    public void SendSms(String phoneNumber, String signName, String templateCode, String templateParam) throws Exception {
        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        df.setTimeZone(new java.util.SimpleTimeZone(0, "GMT"));
        java.util.Map<String, String> paras = new java.util.HashMap<String, String>();
        paras.put("SignatureMethod", "HMAC-SHA1");
        paras.put("SignatureNonce", java.util.UUID.randomUUID().toString());
        paras.put("AccessKeyId", this.accessKeyId);
        paras.put("SignatureVersion", "1.0");
        paras.put("Timestamp", df.format(new java.util.Date()));
        paras.put("Format", "XML");
        paras.put("Action", "SendSms");
        paras.put("Version", "2017-05-25");
        paras.put("RegionId", "cn-hangzhou");
        paras.put("PhoneNumbers", phoneNumber);
        paras.put("SignName", signName);
        paras.put("TemplateParam", templateParam);
        paras.put("TemplateCode", templateCode);
        //paras.put("OutId", "123");
        if (paras.containsKey("Signature"))
            paras.remove("Signature");
        java.util.TreeMap<String, String> sortParas = new java.util.TreeMap<String, String>();
        sortParas.putAll(paras);
        java.util.Iterator<String> it = sortParas.keySet().iterator();
        StringBuilder sortQueryStringTmp = new StringBuilder();
        while (it.hasNext()) {
            String key = it.next();
            sortQueryStringTmp.append("&").append(specialUrlEncode(key)).append("=").append(specialUrlEncode(paras.get(key)));
        }
        String sortedQueryString = sortQueryStringTmp.substring(1);
        StringBuilder stringToSign = new StringBuilder();
        stringToSign.append("GET").append("&");
        stringToSign.append(specialUrlEncode("/")).append("&");
        stringToSign.append(specialUrlEncode(sortedQueryString));
        String sign = sign(this.accessKeySecret + "&", stringToSign.toString());
        String signature = specialUrlEncode(sign);
        final String u = "http://dysmsapi.aliyuncs.com/?Signature=" + signature + sortQueryStringTmp;
        //System.out.println(u);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(u);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.connect();
                    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
                    String line;
                    StringBuilder sb = new StringBuilder();
                    while ((line = br.readLine()) != null) {
                        sb.append(line);
                    }
                    br.close();
                    connection.disconnect();
                    //System.out.println(sb.toString());
                } catch (Exception e) {
                    //return "发生异常：" + e.toString() + ":" + e.getMessage();
                }
            }
        }).start();
    }
    
    private String specialUrlEncode(String value) throws Exception {
        return java.net.URLEncoder.encode(value, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
    }
    
    private String sign(String accessSecret, String stringToSign) throws Exception {
        javax.crypto.Mac mac = javax.crypto.Mac.getInstance("HmacSHA1");
        mac.init(new javax.crypto.spec.SecretKeySpec(accessSecret.getBytes("UTF-8"), "HmacSHA1"));
        byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
        return new sun.misc.BASE64Encoder().encode(signData);
    }
    


    /**
     * 使用AK&SK初始化账号Client
     * @param accessKeyId
     * @param accessKeySecret
     * @return Client
     * @throws Exception
     */
    private com.aliyun.dysmsapi20170525.Client createClient() throws Exception {
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                // 必填，您的 AccessKey ID
                .setAccessKeyId(this.accessKeyId)
                // 必填，您的 AccessKey Secret
                .setAccessKeySecret(this.accessKeySecret);
        // 访问的域名
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new com.aliyun.dysmsapi20170525.Client(config);
    }

    //@SimpleFunction(description = "发送短信并返回发送结果。参数：手机号，签名名称，模板CODE，模板参数JSON")
    //根据阿里云工单沟通及实际测试下来，发现sdk并不支持前端场景，前端只能用上面的方法自己拼协议
    private String SendSms_SDK(String phoneNumber, String signName, String templateCode, String templateParam) throws Exception {
        if (this.accessKeyId == "" || this.accessKeySecret == "")
            return "AccessKey ID or Secret 未设置！";
        if (!IsPhoneNum(phoneNumber))
            return "手机号码格式不正确，请检查！";
        if (signName == "" || signName == null || templateCode == "" || templateCode == null || templateParam == "" || templateParam == null)
            return "短信模板及参数不能为空！";

        try {
            com.aliyun.dysmsapi20170525.Client client = createClient();
            com.aliyun.dysmsapi20170525.models.SendSmsRequest sendSmsRequest = new com.aliyun.dysmsapi20170525.models.SendSmsRequest()
                    .setPhoneNumbers(phoneNumber)
                    .setSignName(signName)
                    .setTemplateCode(templateCode)
                    .setTemplateParam(templateParam);

            com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
            com.aliyun.dysmsapi20170525.models.SendSmsResponse resp = client.sendSmsWithOptions(sendSmsRequest, runtime);
            com.aliyun.teaconsole.Client.log(com.aliyun.teautil.Common.toJSONString(resp));

            String code = resp.body.code;
            if(code != null && code.equals("OK")) {
                return "短信发送成功！";
            }else {
                return "！！！短信发送失败：" + com.aliyun.teautil.Common.toJSONString(resp);
            }
        } catch (com.aliyun.tea.TeaUnretryableException e) {
            return "发生异常1：" + e.toString() + ":" + e.getMessage() + ":" + e.getLastRequest();
        } catch (Exception e) {
            return "发生异常：" + e.toString() + ":" + e.getMessage();
        }
    }

    @SimpleFunction(description = "返回一个指定位数随机数字码。")
    public String RandomNumCode(int length) {
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(10); // 生成0-9之间的随机数
            code.append(digit);
        }
        return code.toString();
    }
}
