<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="com.google.appinventor.server.util.UriBuilder"%>
<%@page import="org.apache.commons.lang3.StringEscapeUtils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<%
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
    <meta name="keywords" content="App Inventor 2 中文网,App Inventor 2中文网,app inventor中文官网,appinventor网页版,appinventor2网站,appinventor官网,APPinventor2网页最新版,app inventor2中文官网,appinventor2 汉化,搭建appinventor2服务器,app inventor2 论坛,AppInventor,App Inventor,App Inventor 2,AI2中文网,AI2 中文网,ai2,少儿编程,青少年编程">
    <meta name="description" content="App Inventor 2 中文网，在MIT官方原版基础上深度中文化定制且与原版同步更新，编程文档及案例本土化。不断开发中文教程并提供中文论坛方便学习交流，陪伴少儿编程成长，做忠实的编程陪伴者。">
    <meta name="application-name" content="App Inventor 2 中文网" />
    <link rel="apple-touch-icon" href="/static/images/logo2.png" />
    <link rel="stylesheet" media="all" href="/static/css/login.css">
</head>

<body class="login-page" style="background: url(/static/images/bg.svg);">

    <div style="position:absolute;width: 100%; top:0;right:0;z-index: 999;">
        <div style="float: right;padding: 15px 30px;">
            <img src="/static/images/vip.png" width="14" height="14" style="margin-top: -4px;" />
            <span class="gl-button-text">
                <a href="https://www.fun123.cn/reference/info/vip.html?f=login" target="_blank" style="color:#9c6521;">开通正式账号</a>
            </span>
        </div>
    </div>


    <div class="page-wrap borderless">

        <div class="container navless-container">
            <div class="content">
                <div class="flash-container flash-container-page sticky">
                </div>

                <div class="mt-3">
                    <div class="col-sm-12 text-center">
                        <a href="/"><img alt="fun123.cn" src="/static/images/logo.png?2" style="width: 179px; height: 57px;"></a>
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
                                                    required="required" title="该字段是必填字段。" type="text" name="email" id="email">
                                                <p class="field-error hidden">该字段是必填字段。</p>
                                            </div>
                                            <div class="form-group px-5">
                                                <label class="label-bold mb-1" for="user_password">密码：</label>
                                                <input class="form-control form-input bottom"
                                                    autocomplete="current-password" required="required"
                                                    title="该字段是必填字段。" type="password" name="password" id="password">
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
                                                    <a href="javascript:alert('如您已遗忘密码，请联系客服进行初始重置，谢谢！');">忘记密码？</a>
                                                </div>
                                                
                                            </div>

                                            <div class="submit-container move-submit-down px-5">
                                                <button name="button" type="submit" class="button btn btn-block btn-confirm js-sign-in-button">登录</button>
                                                </form>

                                                <form method=POST action="/login">
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
                                                    <button name="button" type="submit" class="button btn btn-block ">免费试用（试用账户项目会不定期清理）</button>
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
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?8d287b854d737bdc880e8ddeac1b309d";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>
</body>

</html>