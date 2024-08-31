<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="com.google.appinventor.server.util.UriBuilder"%>
<%@page import="org.apache.commons.lang3.StringEscapeUtils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<%
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);

   String error = StringEscapeUtils.escapeHtml4(request.getParameter("error"));
   String useGoogleLabel = (String) request.getAttribute("useGoogleLabel");
   String locale = StringEscapeUtils.escapeHtml4(request.getParameter("locale"));
   String redirect = StringEscapeUtils.escapeHtml4(request.getParameter("redirect"));
   String repo = StringEscapeUtils.escapeHtml4((String) request.getAttribute("repo"));
   String autoload = StringEscapeUtils.escapeHtml4((String) request.getAttribute("autoload"));
   String galleryId = StringEscapeUtils.escapeHtml4((String) request.getAttribute("galleryId"));
   String newGalleryId = StringEscapeUtils.escapeHtml4(request.getParameter("ng"));
   if (locale == null) {
       locale = "zh_CN";
   }
%>
<!DOCTYPE html>
<html class="devise-layout-html">
<head prefix="og: http://ogp.me/ns#">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta HTTP-EQUIV="pragma" CONTENT="no-cache" />
    <meta HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate" />
    <meta HTTP-EQUIV="expires" CONTENT="0" />
    <title>App Inventor 2 中文网</title>
    <meta name="keywords" content="App Inventor 2 中文网,App Inventor 2中文网,app inventor中文官网,appinventor网页版,appinventor2网站,appinventor官网,APPinventor2网页最新版,app inventor2中文官网,appinventor2 汉化,搭建appinventor2服务器,app inventor2 社区,中文社区,appinventor2中文社区,AppInventor,App Inventor,App Inventor 2,AI2中文网,AI2 中文网,ai2,少儿编程,青少年编程">
    <meta name="description" content="App Inventor 2 中文网，在MIT官方原版基础上深度中文化定制且与原版同步更新，编程文档及案例本土化。不断开发中文教程并提供中文社区方便学习交流，陪伴少儿编程成长，做忠实的编程陪伴者。">
    <meta name="application-name" content="App Inventor 2 中文网" />
    <link rel="apple-touch-icon" href="/static/images/logo2.png" />
    <link rel="stylesheet" media="all" href="/static/css/login.css">
    <link type="text/css" rel="stylesheet" href="/static/css/materialdesignicons.min.css">
</head>

<body class="login-page" style="background:url(/static/images/bg.svg) center/cover no-repeat;">

    <div style="position:absolute;width: 100%; top:0;right:0;z-index: 999;">
        <div style="float: right;padding: 15px 30px;">
            <!--<span class="gl-button-text">
                <a id="dacu"><img src="/static/images/618.png" alt="img" height="20" style="margin-top: -3px; cursor: pointer;"/>
                                <img src="/static/images/618.gif" alt="img" style="margin-top: -4px; cursor: pointer;" height="30">
                </a>
                <div id="qrcode" style="display: none;
                                text-align: center;
                                color: #9c6521;
                                position: absolute;
                                padding: 6px;
                                background-color: #fff;
                                border-radius: 6px;
                                border: 1px solid #ddd;">618<br/><img src="/static/images/weixin.png" style="width:180px;height:180px;"/></div>
                <script type="text/javascript">
                document.getElementById("dacu").addEventListener("mouseenter", function() {
                document.getElementById("qrcode").style.display = "block";
                });
                
                document.getElementById("dacu").addEventListener("mouseleave", function() {
                document.getElementById("qrcode").style.display = "none";
                });
            </script>
            </span>
            &nbsp;&nbsp;&nbsp;-->
            <span class="gl-button-text">
                <a href="https://www.fun123.cn/reference/info/paper.html?f=login" target="_blank"><img src="/static/images/fire.png" alt="img" width="16" height="16" style="margin:-3px 3px 0 0;"/>有奖征文</a>
            </span>
            &nbsp;&nbsp;&nbsp;
            <span class="gl-button-text">
                <a href="https://www.fun123.cn/reference/info/?f=login#AppEntry" target="_blank"><i class="mdi mdi-school-outline" style="font-size: 15px;"></i> 手把手入门教程</a>
            </span>
            &nbsp;&nbsp;&nbsp;
            <span class="gl-button-text">
                <a href="https://www.fun123.cn/reference/iot/?f=login" target="_blank"><i class="mdi mdi-bluetooth-audio" style="font-size: 15px;"></i> IoT专题</a>
            </span>
            &nbsp;&nbsp;&nbsp;
            <span class="gl-button-text">
                <a href="https://www.fun123.cn/reference/info/guide.pdf?f=login" target="_blank">新手必读！</a>
            </span>
            &nbsp;
            <span class="nav-vip-title" style="font-weight: 600;">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="14" viewBox="0 0 16 14" fill="none" style="margin-right: 5px; vertical-align: top;margin-top:4px;">
                    <path fill-rule="evenodd" clip-rule="evenodd" d="M7.82386 0.389956C7.76894 0.41651 7.72074 0.455136 7.68287 0.502944L4.34927 4.71193C4.29413 4.78157 4.21758 4.83111 4.13145 4.85293C4.04533 4.87474 3.95442 4.86761 3.87275 4.83262L0.622686 3.44054C0.554706 3.41143 0.48004 3.40149 0.406806 3.41183C0.333573 3.42216 0.264575 3.45236 0.207316 3.49916C0.150057 3.54595 0.106728 3.60753 0.0820398 3.67722C0.0573518 3.7469 0.0522501 3.82202 0.0672893 3.8944L1.86697 12.561C1.94259 12.9251 2.14142 13.2521 2.42998 13.4868C2.71855 13.7215 3.07922 13.8496 3.45125 13.8496H12.5488C12.9208 13.8496 13.2815 13.7215 13.57 13.4868C13.8586 13.2521 14.0574 12.9251 14.133 12.561L15.9327 3.8944C15.9478 3.82199 15.9427 3.74684 15.918 3.67713C15.8933 3.60742 15.8499 3.54581 15.7927 3.49901C15.7354 3.45222 15.6663 3.42202 15.5931 3.41171C15.5198 3.4014 15.4451 3.41137 15.3771 3.44054L12.1273 4.83262C12.0456 4.86761 11.9547 4.87474 11.8686 4.85293C11.7824 4.83111 11.7059 4.78157 11.6507 4.71193L8.31714 0.502944C8.27927 0.455136 8.23107 0.41651 8.17615 0.389956C8.12123 0.363403 8.06101 0.349609 8 0.349609C7.939 0.349609 7.87878 0.363403 7.82386 0.389956ZM5.64736 6.51935C5.32706 6.12651 4.74879 6.06758 4.35576 6.38774C3.96274 6.70789 3.90378 7.28588 4.22409 7.67872L7.38471 11.5551C7.70247 11.9448 8.29787 11.9448 8.61564 11.5551L11.7763 7.67873C12.0966 7.28589 12.0377 6.7079 11.6447 6.38774C11.2516 6.06759 10.6734 6.12651 10.3531 6.51934L8.00018 9.40499L5.64736 6.51935Z" fill="url(#paint0_linear_6256_99744)"></path><defs><linearGradient id="paint0_linear_6256_99744" x1="8.00001" y1="0.349609" x2="8.00001" y2="13.8496" gradientUnits="userSpaceOnUse"><stop stop-color="#DA6600"></stop><stop offset="1" stop-color="#D46300"></stop></linearGradient></defs>
                </svg>
                <span class="btn-list-group">
                    <a href="https://www.fun123.cn/reference/info/vip.html?f=login" target="_blank" style="color:#D46300;font-size: 14px;" title="点击查看VIP特权">账户开通</a>
                    <span class="btn-list-area">
                        <a class="menuBtn subMenu" href="https://www.fun123.cn/pay?f=login-vip" target="_blank" title="立即享受优质的编程体验，实用的文档教程，无忧的技术保障！">开通VIP会员</a>
                        <a class="menuBtn subMenu" href="https://www.fun123.cn/reference/info/tuan.html?f=login-tuan" target="_blank" title="10个及以上账号，5折优惠超划算！">团购更优惠</a>
                        <a class="menuBtn subMenu" href="https://www.fun123.cn/reference/info/tuan.html?f=login-deploy" target="_blank" title="适合学校、机构等需要大量账号，且账号长期使用的情况！">私有化部署</a>
                        <a class="menuBtn subMenu" href="https://bbs.tsingfun.com/plugin.php?id=keke_group" target="_blank" title="适合使用其他编程平台，但需要技术支持服务的用户！">社区SVIP</a>
                    </span>
                </span>
            </span>
            <style>
            .btn-list-area {
                display: none;
                position: absolute;
                background: #fff;
                border-radius: 5px;
                width: 100px;
                z-index: 9999;
                right: 16px;
                padding:3px 0 5px 0;
                margin-top:-2px;
            }
            .btn-list-group:hover .btn-list-area {
                display: block
            }
            .menuBtn {
                display: inline-block;
                padding: 5px;
                font-size: 14px;
                font-weight: 400;
                color: rgba(108, 117, 125, 1);
                text-align: center;
                line-height: 1.5;
                cursor: pointer;
            }
            .subMenu {
                width: 100px;
            }
            </style>

            <!--<img src="/static/images/vip.png" width="14" height="14" style="margin-top: -4px;" />
            <span class="gl-button-text">
                <a href="https://www.fun123.cn/reference/info/vip.html?f=login" target="_blank" style="color:#9c6521;">开通正式账号</a>
            </span>-->
        </div>
    </div>


    <div class="page-wrap borderless">

        <div class="container navless-container">
            <div class="content">
                <div class="flash-container flash-container-page sticky">
                </div>

                <div class="mt-3">
                    <div class="col-sm-12 text-center">
                        <a href="/"><img alt="fun123.cn" src="https://www.fun123.cn/static/images/logo.png" style="width: 179px; height: 57px;"></a>
                        <h1 class="mb-3 font-size-h2">欢迎来到 App Inventor 2 中文网</h1>
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
                                        <form action="/login" method="post">
<% if (locale != null && !locale.equals("zh_CN")) {
   %>
<input type=hidden name=locale value="<%= locale %>">
<% }
   if (repo != null && !repo.equals("")) {
   %>
<input type=hidden name=repo value="<%= repo %>">
<% }
   if (autoload != null && !autoload.equals("")) {
   %>
<input type=hidden name=autoload value="<%= autoload %>">
<% }
   if (galleryId != null && !galleryId.equals("")) {
   %>
<input type=hidden name=galleryId value="<%= galleryId %>">
<% }
   if (newGalleryId != null && !newGalleryId.equals("")) {
   %>
<input type=hidden name=ng value="<%= newGalleryId %>">
<% } %>
<% if (redirect != null && !redirect.equals("")) {
   %>
<input type=hidden name=redirect value="<%= redirect %>">
<% } %>
                                            
                                            <div class="form-group px-5 pt-5">
                                                <label for="user_login" class="label-bold">用户名 / 手机号：</label>

                                                <input class="form-control form-input top js-username-field"
                                                    autofocus="autofocus" autocapitalize="off" autocorrect="off"
                                                    required="required" title="该字段是必填字段。" type="text" name="email" id="email" maxlength="30">
                                                <p class="field-error hidden">该字段是必填字段。</p>
                                            </div>
                                            <div class="form-group px-5">
                                                <label class="label-bold mb-1" for="user_password">密码：</label>
                                                <input class="form-control form-input bottom"
                                                    autocomplete="current-password" required="required"
                                                    title="该字段是必填字段。" type="password" name="password" id="password" maxlength="30">
                                                <p class="field-error hidden">该字段是必填字段。</p>
                                            </div>
                                            
                                            <div class="px-5">
                                                
                                                <div class="display-inline-block">
                                                    <div class="form-checkbox custom-control custom-checkbox" style="padding-left:0;">
                                                        <p>
                                                            登入即代表您同意并接受<a href="/Ya_tos_form.html" target="_blank">《服务条款和账号规范》</a>
                                                        </p>
                                                    </div>
                                                </div>
                                                <div class="float-right">
                                                    <a href="javascript:alert('如您已遗忘密码，请联系客服进行初始密码重置，谢谢！');">忘记密码？</a>
                                                </div>
                                                
                                            </div>

                                            <div class="submit-container move-submit-down px-5">
                                                <button name="button" type="submit" class="button btn btn-block btn-confirm js-sign-in-button">登录</button>
                                                </form>

                                                <form method=POST action="https://sy.fun123.cn/login">
<% if (locale != null && !locale.equals("zh_CN")) {
   %>
<input type=hidden name=locale value="<%= locale %>">
<% }
   if (repo != null && !repo.equals("")) {
   %>
<input type=hidden name=repo value="<%= repo %>">
<% }
   if (autoload != null && !autoload.equals("")) {
   %>
<input type=hidden name=autoload value="<%= autoload %>">
<% }
   if (galleryId != null && !galleryId.equals("")) {
   %>
<input type=hidden name=galleryId value="<%= galleryId %>">
<% }
   if (newGalleryId != null && !newGalleryId.equals("")) {
   %>
<input type=hidden name=ng value="<%= newGalleryId %>">
<% } %>
<% if (redirect != null && !redirect.equals("")) {
   %>
<input type=hidden name=redirect value="<%= redirect %>">
<% } %>
                                                    <input type=hidden name=email value="test@fun123.cn">
                                                    <input type=hidden name=password value="000000">
                                                    <button name="button" type="submit" class="button btn btn-block ">免费试用（试用账户有时间限制且项目会不定期清理）</button>
                                                </form>
                                            </div>
                                    </div>
                                </div>

                            </div>
                            
                            <div class="omniauth-provider-divider display-flex align-items-center" style="margin-top: 50px;">
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
                                    <!--<div class="service_info" title="官方QQ群：483928335">
                                        <img src="/static/images/qqq.jpg" loading="lazy">
                                        <div>官方QQ群</div> 
                                    </div>-->
                                    <a href="https://bbs.tsingfun.com/forum-147-1.html?f=login" target="_blank">
                                        <div class="service_info">
                                            <img src="https://bbs.tsingfun.com/static/image/common/qr_bbs.png" loading="lazy">
                                            <div>移动中文社区</div> 
                                        </div>
                                    </a>

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
                <a href="https://www.fun123.cn/reference/?f=login" target="_blank"><i class="mdi mdi-book-open-page-variant-outline" style="font-size: 14px;"></i> 中文文档</a> &nbsp;&nbsp;
                <a href="https://www.fun123.cn/aia-store/?f=login" target="_blank"><i class="mdi mdi-shopping-outline" style="font-size: 14px;"></i> Aia Store</a>
            </div>
            <div class="records display-none md-display-flex footer-links">
                <span class="record-item display-flex align-items-center">
                    &copy; <script>document.write(new Date().getFullYear());</script>&nbsp;跟着学（上海）教育科技有限公司&nbsp;&nbsp;&nbsp;
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
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?8d287b854d737bdc880e8ddeac1b309d";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>

<!--AI助理-->
<script>
window.difyChatbotConfig = {
    token: 'xHV026xryabhSDSI',
    baseUrl: 'https://ai.fun123.cn'
}
</script>
<script
src="https://ai.fun123.cn/embed.min.js"
id="xHV026xryabhSDSI"
defer>
</script>
<style>
#dify-chatbot-bubble-button {
    background-color: #B6D38E !important;
    bottom: 40px !important;
}
</style>

</body>
</html>