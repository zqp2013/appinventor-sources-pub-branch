<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="com.google.appinventor.server.util.UriBuilder"%>
<%@page import="org.apache.commons.lang3.StringEscapeUtils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<%
   String error = StringEscapeUtils.escapeHtml4(request.getParameter("error"));
   String phone = (String) request.getAttribute("phone");
%>
<!DOCTYPE html>
<html class="devise-layout-html">
<head prefix="og: http://ogp.me/ns#">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta HTTP-EQUIV="pragma" CONTENT="no-cache" />
    <meta HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate" />
    <meta HTTP-EQUIV="expires" CONTENT="0" />
    <title>支付 · App Inventor 2 中文网</title>
    <meta name="keywords" content="App Inventor 2 中文网,App Inventor 2中文网,app inventor中文官网,appinventor网页版,appinventor2网站,appinventor官网,APPinventor2网页最新版,app inventor2中文官网,appinventor2 汉化,搭建appinventor2服务器,app inventor2 论坛,AppInventor,App Inventor,App Inventor 2,AI2中文网,AI2 中文网,ai2,少儿编程,青少年编程">
    <meta name="description" content="App Inventor 2 中文网，在MIT官方原版基础上深度中文化定制且与原版同步更新，编程文档及案例本土化。不断开发中文教程并提供中文论坛方便学习交流，陪伴少儿编程成长，做忠实的编程陪伴者。">
    <meta name="application-name" content="App Inventor 2 中文网" />
    <link rel="apple-touch-icon" href="/static/images/logo2.png" />
    <link rel="stylesheet" media="all" href="/static/css/login.css">
    <style type="text/css">
    .title {
        background-clip: text;
        -webkit-background-clip: text;
        -webkit-text-fill-color: transparent;
        margin-bottom: 1.5rem!important;
        background-image: linear-gradient(to right,var(--tw-gradient-stops))!important;
        --tw-gradient-from: #5D67E8 !important;
        --tw-gradient-to: rgb(93 103 232 / 0) !important;
        --tw-gradient-stops: var(--tw-gradient-from), var(--tw-gradient-to) !important;
        --tw-gradient-to: #ef4444 !important;
        font-size: 1.7rem!important;
    }
    </style>
</head>

<body class="login-page" style="overflow:hidden;background:url(/static/images/bgpay.svg) center/cover no-repeat;">

    <div style="position:absolute;width: 100%; top:0;right:0;z-index: 999;">
        <div style="float: right;padding: 15px 30px;">
            <a href="https://www.fun123.cn/reference/info/#AppEntry?f=pay" target="_blank">专享教程</a> & <a href="https://www.fun123.cn/reference/?f=pay" target="_blank">文档</a>&nbsp;&nbsp;&nbsp;
            <img src="/static/images/vip.png" width="14" height="14" style="margin-top: -4px;" />
            <span class="gl-button-text">
                <a href="https://www.fun123.cn/reference/info/vip.html?f=pay" target="_blank" style="color:#9c6521;">查看 VIP 特权</a>
            </span>
        </div>
    </div>


    <div class="page-wrap borderless">

        <div class="container navless-container">
            <div class="content">
                <div class="flash-container flash-container-page sticky" style="padding-bottom: 20px;">
                </div>

                <div class="mt-3">
                    <div class="col-sm-12 text-center">
                        <a href="/"><img alt="fun123.cn" src="/static/images/logo.png?2" style="width: 179px; height: 57px;"></a>
                        <h1 class="mb-3 font-size-h2 title">App Inventor 2 中文网 VIP</h1>
<% if (error != null) {
out.println("<center><font color=red><b>" + error + "</b></font></center>");
   } %>
                    </div>
                </div>
                <div class="mb-3">
                    <div class="w-half ml-auto mr-auto">

                        <div id="signin-container">
                            <div class="tab-content">
                                <div class="login-box tab-pane active" id="login-pane">
                                    <div class="login-body">
                                        <form action="/pay" method="post">
                                            <input type="hidden" name="subject" value="App Inventor 2 中文网 VIP 会员">
                                            <div class="form-group px-5 pt-5">
                                                <label class="label-bold">手机号：</label>
                                                <div class="float-right">
                                                    <span style="color: red; visibility: hidden;" id="error_msg">手机号码输入有误，请检查！</span>
                                                </div>

                                                <input class="form-control form-input top js-username-field"
            oninput="value=value.replace(/[^0-9.]/g,'')" 
            onblur="javascript:if(value.length!=11){
                    document.getElementById('paybtn').disabled = true;
                    if (value.length > 0) document.getElementById('error_msg').style.visibility = 'visible';
            } else {document.getElementById('paybtn').disabled = false; document.getElementById('error_msg').style.visibility = 'hidden'; } " 
        <% if (phone != null) {
            out.println("value=" + phone);
        } %>
                                                    autofocus="autofocus" autocapitalize="off" autocorrect="off" placeholder="请输入手机号码，作为登录账号，接收短信通知"
                                                    required="required" title="该字段是必填字段。" type="text" name="phone" id="phone">
                                                <p class="field-error hidden">该字段是必填字段。</p>
                                            </div>

                                            <div class="form-group px-5">
                                                <label class="label-bold mb-1">开通/续期时长：</label>
                                                
    <input id="month" name="period" value="1" required type="radio" 
    onclick="javascript:document.getElementById('amount').value=29.98;document.getElementById('amount_label').innerHTML=29.98;document.getElementById('perday').innerHTML=(29.98/30).toFixed(2);document.getElementById('delprc').innerHTML=39;">
    <label for="month">1个月</label>&nbsp;&nbsp;

    <input id="halfyear" name="period" value="6" required type="radio" checked="true"
        onclick="javascript:document.getElementById('amount').value=89.98;document.getElementById('amount_label').innerHTML=89.98;document.getElementById('perday').innerHTML=(89.98/180).toFixed(2);document.getElementById('delprc').innerHTML=199;">
    <label for="halfyear">6个月</label>&nbsp;&nbsp;
    
    <input id="year" name="period" value="12" required type="radio"
        onclick="javascript:document.getElementById('amount').value=169.98;document.getElementById('amount_label').innerHTML=169.98;document.getElementById('perday').innerHTML=(169.98/365).toFixed(2);document.getElementById('delprc').innerHTML=299;">
    <label for="year">1年</label>
                                            </div>

                                            <div class="form-group px-5">
                                                <label class="label-bold mb-1">支付金额： 
                                                    <div>
                                                        <h1 style="float:left;">¥ <span style="color:green" id="amount_label">89.98</span></h1>
                                                        <del style="color: #888;float:left;margin-top: 20px;margin-left: 20px;"><h3>原价：<span id="delprc">199</span></h3></del>
                                                        <span style="position: absolute;color:#FF8E21;float:left;margin-top: 36px;margin-left: 20px;">低至 <span id="perday">0.5</span> 元/天！</span>
                                                    </div>
                                                </label>
                                                <input type="hidden" id="amount" name="amount" value="89.98">

                                                <div class="float-right">
                                                    <span>免费赠送 <i>基础版</i>* <a href="https://www.fun123.cn/reference/info/#qa" target="_blank">技术支持服务</a></span>
                                                </div>
                                            </div>

                                            <div class="form-group px-5">
                                                <label class="label-bold mb-1">支付方式：<b style="color:#1574F7">支付宝</b></label>

                                                <div class="float-right">
                                                    <span>支付成功后请稍等页面返回，待短信通知！</span>
                                                </div>
                                            </div>

                                            <div class="submit-container move-submit-down px-5">
                                                <button name="button" type="submit" class="button btn btn-block btn-confirm js-sign-in-button" id="paybtn">立即支付</button>
                                            </form>
                                            <a href="/"><< 返回首页</a>
                                            <div class="float-right">
                                                <span style="color: #999;">* 不支持7天无理由退货&nbsp;&nbsp;</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            
                            <div class="omniauth-provider-divider display-flex align-items-center" style="margin-top: 30px;">
                                官方平台
                            </div>
                            <div class="clearfix">
                                <div class="omniauth-container mt-5 p-5 text-center w-90p ml-auto mr-auto restyle-login-page">

                                    
                                    <div class="service_info">
                                        <img src="/static/images/weixin.png" loading="lazy">
                                        <div>微信客服</div>
                                    </div>
                                    <div class="service_info">
                                        <img src="/static/images/gzh.jpg" loading="lazy">
                                        <div>公众号 </div>
                                    </div>
                                    <div class="service_info">
                                        <img src="/static/images/weibo.png" loading="lazy">
                                        <div>微博</div> 
                                    </div>

                                </div>

                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        
        <hr class="footer-fixed">
        
        <div class="container footer-container lg-display-flex align-items-center glass">
            <div class="footer-links display-flex">
                <a href="https://www.fun123.cn/reference/info/?f=login" target="_blank">关于App Inventor 2</a> &nbsp;&nbsp;
                <a href="https://www.fun123.cn/reference/info/about-us.html?f=login" target="_blank">关于我们</a> &nbsp;&nbsp;
                <a href="https://www.fun123.cn/reference/?f=login" target="_blank">参考文档</a> &nbsp;&nbsp;
                <a href="https://space.bilibili.com/3493106345314902" target="_blank">bilibili 视频教程</a>
            </div>
            <div class="records display-none md-display-flex footer-links">
                <span class="record-item display-flex align-items-center">
                    &copy; 2023&nbsp;跟着学（上海）教育科技有限公司&nbsp;&nbsp;&nbsp;
                </span>                
                <span class="record-item display-flex align-items-center">
                    <a href="https://beian.miit.gov.cn/" target="_blank">沪ICP备2020034476号-2</a>
                </span>
                <span class="record-item display-flex align-items-center">
                    <img class="mr-2 js-lazy-loaded" src="/static/images/gongan.svg" loading="lazy">
                    <a href="https://www.beian.gov.cn/portal/registerSystemInfo?recordcode=31011702008921" target="_blank">沪公网安备31011702008921号</a>
                </span>
            </div>
        </div>
    </div>
<script src="/static/js/jquery-3.3.1.slim.min.js"></script>
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?8d287b854d737bdc880e8ddeac1b309d";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
$(document).bind("contextmenu",function(){return false;});
$(document).bind("selectstart",function(){return false;});
$(document).keydown(function(){return key(arguments[0])});
function key(e){
    var keynum;
    if(window.event){
        keynum = e.keyCode;
    }else if(e.which){
        keynum = e.which;
    }
    if(keynum == 17){return false;}
}
</script>
</body>

</html>