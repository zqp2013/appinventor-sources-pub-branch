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
	<meta name="keywords" content="AppInventor,App Inventor,App Inventor 2,App Inventor 2 中文网,ai2,少儿编程,青少年编程,编程,开心哆来咪编程网">
	<meta name="description" content="App Inventor 2 中文网，专注青少年编程。">
	<meta name="application-name" content="App Inventor 2 中文网"/>
  </head>
<body style="background: url(/static/images/bg.svg);padding-top:5%;">

  <center>
    <h1>${pleaselogin}</h1>
  </center>
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

<center>
<a href="<%= new UriBuilder("/login")
                           .add("locale", "zh_CN")
                           .add("repo", repo)
                           .add("autoload", autoload)
                           .add("galleryId", galleryId)
                           .add("redirect", redirect).build() %>"  style="text-decoration:none;" >中文</a>&nbsp;
<a href="<%= new UriBuilder("/login")
                   .add("locale", "en")
                   .add("repo", repo)
                   .add("autoload", autoload)
                   .add("galleryId", galleryId)
                   .add("ng", newGalleryId)
                   .add("redirect", redirect).build() %>"  style="text-decoration:none;" >English</a>
</center>
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
<p><font style="color:red;">注：试用账号下，项目会不定期进行清理！</font><br/>如需开通正式账号，请添加QQ 348366338 咨询，谢谢！</p>
</center>
<br/>
<br/>


<footer>

<!--
<center>
<%    if (locale != null && locale.equals("zh_CN")) { %>
<a href="http://www.weibo.com/mitappinventor" target="_blank"><img class="img-scale"
                  src="/static/images/mzl.png" width="30" height="30" title="Sina WeiBo"></a>&nbsp;
<%    } %>
<a href="http://www.appinventor.mit.edu" target="_blank"><img class="img-scale"
                src="/static/images/login-app-inventor.jpg" width="50" height="30" title="MIT App Inventor"></a></center>
<p></p>

<p style="text-align: center; clear:both;"><a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/"
                                              target="_blank"><img alt="Creative Commons License" src="/static/images/cc3.png"></a> <br>
  <a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/" target="_blank"></a></p>
-->

<center>
<a href="http://fun123.cn/reference/info/" target="_blank">项目教程</a> &nbsp;&nbsp;
<a href="http://www.fun123.cn/reference/components/" target="_blank">参考文档</a> &nbsp;&nbsp;
<a href="https://bbs.tsingfun.com/forum-147-1.html" target="_blank">交流反馈</a>

<p class="copyright" style="font-size:15px;color:#666;margin-top:10%;">版权所有 &copy; 2023&nbsp;<a href="http://www.fun123.cn"  style="color:#666;text-decoration: none;">fun123.cn</a></p>
</center>

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

