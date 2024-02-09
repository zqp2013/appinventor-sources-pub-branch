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
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta HTTP-EQUIV="pragma" CONTENT="no-cache"/>
    <meta HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate"/>
    <meta HTTP-EQUIV="expires" CONTENT="0"/>
    <title>App Inventor 2 中文网</title>
	<meta name="keywords" content="App Inventor 2 中文网,App Inventor 2中文网,app inventor中文官网,appinventor网页版,appinventor2网站,appinventor官网,APPinventor2网页最新版,app inventor2中文官网,appinventor2 汉化,搭建appinventor2服务器,app inventor2 论坛,AppInventor,App Inventor,App Inventor 2,AI2中文网,AI2 中文网,ai2,少儿编程,青少年编程">
	<meta name="description" content="App Inventor 2 中文网，在MIT官方原版基础上深度中文化定制且与原版同步更新，编程文档及案例本土化。不断开发中文教程并提供中文论坛方便学习交流，陪伴少儿编程成长，做忠实的编程陪伴者。">
	<meta name="application-name" content="App Inventor 2 中文网"/>
	<link rel="apple-touch-icon" href="/static/images/logo2.png"/>
  </head>
<body style="background: url(/static/images/bg.svg);padding-top:4%;">
  <center>
   <img src="/static/images/codi_long.png"/>
    <h1>欢迎来到 App Inventor 2 中文网</h1>
  </center>
  <br/>
<% if (error != null) {
out.println("<center><font color=red><b>" + error + "</b></font></center><br/>");
   } %>
<form method=POST action="/login">
<center><table>
<tr><td>${emailAddressLabel}</td><td><input type=text name=email value="" size="35"></td></tr>
<tr><td></td></td>
<tr><td>${passwordLabel}</td><td><input type=password name=password value="" size="35"></td></tr>
</table></center>
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
<p></p>

<br/>

<center><input type=Submit value="${login}" style="font-size: 300%;"></center>
</form>
<p></p>

<!--<center><p><a href="/login/sendlink"  style="text-decoration:none;">${passwordclickhereLabel}</a></p></center>-->

<!--
<%    if (useGoogleLabel != null && useGoogleLabel.equals("true")) { %>
<center><p><a href="<%= new UriBuilder("/login/google")
                              .add("autoload", autoload)
                              .add("repo", repo)
                              .add("galleryId", galleryId)
                              .add("ng", newGalleryId)
                              .add("redirect", redirect).build() %>" style="text-decoration:none;">登陆测试账号</a></p></center>
<%    } %>
-->

<br/>
<center>
<form method=POST action="/login">
<input type=hidden name=email value="test@fun123.cn">
<input type=hidden name=password value="000000">
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
<input type=Submit value="点击试用">
</form>
<p><font style="color:red;">注：试用账号下，项目会不定期进行清理！</font><br/><br/>
<img src="/static/images/weixin.png" width="120" height="120" title="扫码咨询"/><br/>
如需开通正式账号，请扫码咨询！</p>
</center>
<br/>

<footer>

<center>
<a href="https://www.fun123.cn/reference/info/?f=login" target="_blank">关于App Inventor 2</a> &nbsp;&nbsp;
<a href="https://www.fun123.cn/reference/info/about-us.html?f=login" target="_blank">关于我们</a> &nbsp;&nbsp;
<a href="https://www.fun123.cn/reference/?f=login" target="_blank"><i class="mdi mdi-book-open-page-variant-outline" style="font-size: 14px;"></i> 中文文档</a> &nbsp;&nbsp;
<a href="https://www.fun123.cn/aia-store/?f=login" target="_blank"><i class="mdi mdi-shopping-outline" style="font-size: 14px;"></i> Aia Store</a>

<p class="copyright" style="font-size:15px;color:#666;margin-top:4%;line-height:24px;">&copy; <script>document.write(new Date().getFullYear());</script>&nbsp;跟着学（上海）教育科技有限公司&nbsp;&nbsp;<br/>
	<a href="https://beian.miit.gov.cn/" target="_blank" style="color:#666;text-decoration: none;">沪ICP备2020034476号-2</a>&nbsp;&nbsp;
	<a href="https://www.beian.gov.cn/portal/registerSystemInfo?recordcode=31011702008921" target="_blank" style="color:#666;text-decoration: none;"><i></i>沪公网安备31011702008921号</a>&nbsp;
	<%    if (locale != null && locale.equals("zh_CN")) { %>
	<a href="https://weibo.com/tsingfun" target="_blank"><img class="img-scale" src="/static/images/mzl.png" width="19" height="19" title="@AI2中文网" style="position:absolute;"></a>&nbsp;
	<%    } %>
</p>
</center>
<!--
<p style="text-align: center; clear:both;">
	<a href="http://www.appinventor.mit.edu" target="_blank"><img class="img-scale" src="/static/images/login-app-inventor.jpg" width="50" height="30" title="MIT App Inventor"></a>
	<a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/" target="_blank"><img alt="Creative Commons License" src="/static/images/cc3.png"></a>
</p>-->

</footer>
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?8d287b854d737bdc880e8ddeac1b309d";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>
</body></html>

