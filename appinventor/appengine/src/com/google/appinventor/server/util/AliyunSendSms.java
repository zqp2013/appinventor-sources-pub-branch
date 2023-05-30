// 阿里云短信服务
package com.google.appinventor.server.util;

import com.aliyun.tea.*;

public class AliyunSendSms {
    public static String ABD = "L";
    public static String AGC = "dzLrhSsttN8qEK93kEbIWEXuDhCHJ";
    /**
     * 使用AK&SK初始化账号Client
     * @param accessKeyId
     * @param accessKeySecret
     * @return Client
     * @throws Exception
     */
    public static com.aliyun.dysmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                // 必填，您的 AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 必填，您的 AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new com.aliyun.dysmsapi20170525.Client(config);
    }
    public static String ALC = "S";
    /**
    * 使用STS鉴权方式初始化账号Client，推荐此方式。
    * @param accessKeyId
    * @param accessKeySecret
    * @param securityToken
    * @return Client
    * @throws Exception
    */
    // public static com.aliyun.dysmsapi20170525.Client createClientWithSTS(String accessKeyId, String accessKeySecret, String securityToken) throws Exception {
    //     com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
    //             // 必填，您的 AccessKey ID
    //             .setAccessKeyId(accessKeyId)
    //             // 必填，您的 AccessKey Secret
    //             .setAccessKeySecret(accessKeySecret)
    //             // 必填，您的 Security Token
    //             .setSecurityToken(securityToken)
    //             // 必填，表明使用 STS 方式
    //             .setType("sts");
    //     // 访问的域名
    //     config.endpoint = "dysmsapi.aliyuncs.com";
    //     return new com.aliyun.dysmsapi20170525.Client(config);
    // }
    public static String ABC = "TAI5tQaEkHbcJcTAeaUCgQh";
    // 工程代码泄露可能会导致AccessKey泄露，并威胁账号下所有资源的安全性。以下代码示例仅供参考，建议使用更安全的 STS 方式，
    // 更多鉴权访问方式请参见：https://help.aliyun.com/document_detail/378657.html

    public static void Send_Open(final String phoneNumber, final String pwd, final String date) throws Exception {
        com.aliyun.dysmsapi20170525.Client client = AliyunSendSms.createClient(ABD+ABC, AGC+ALC);
        com.aliyun.dysmsapi20170525.models.SendSmsRequest sendSmsRequest = new com.aliyun.dysmsapi20170525.models.SendSmsRequest()
                .setPhoneNumbers(phoneNumber)
                .setSignName("AppInventor2")
                .setTemplateCode("SMS_460925247")
                .setTemplateParam("{\"userid\":\"" + phoneNumber + "\",\"pwd\":\"" + pwd + "\",\"time\":\"" + date + "\"}");
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        com.aliyun.dysmsapi20170525.models.SendSmsResponse resp = client.sendSmsWithOptions(sendSmsRequest, runtime);
        com.aliyun.teaconsole.Client.log(com.aliyun.teautil.Common.toJSONString(resp));
    }

    public static void Send_Renew(final String phoneNumber, final String date) throws Exception {
        com.aliyun.dysmsapi20170525.Client client = AliyunSendSms.createClient(ABD+ABC, AGC+ALC);
        com.aliyun.dysmsapi20170525.models.SendSmsRequest sendSmsRequest = new com.aliyun.dysmsapi20170525.models.SendSmsRequest()
                .setPhoneNumbers(phoneNumber)
                .setSignName("AppInventor2")
                .setTemplateCode("SMS_461025219")
                .setTemplateParam("{\"userid\":\"" + phoneNumber + "\",\"time\":\"" + date + "\"}");
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        com.aliyun.dysmsapi20170525.models.SendSmsResponse resp = client.sendSmsWithOptions(sendSmsRequest, runtime);
        com.aliyun.teaconsole.Client.log(com.aliyun.teautil.Common.toJSONString(resp));
    }
}

