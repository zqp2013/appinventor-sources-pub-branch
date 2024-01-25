<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="com.google.appinventor.server.util.UriBuilder"%>
<%@page import="org.apache.commons.lang3.StringEscapeUtils"%>
<%@page import="java.util.List"%>
<%@page import="com.google.appinventor.shared.rpc.user.AiaStore"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<%
   java.text.SimpleDateFormat dtfmt = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
   String error = StringEscapeUtils.escapeHtml4(request.getParameter("error"));
   String phone = (String) request.getAttribute("phone");
   Boolean is_admin = (Boolean) request.getAttribute("is_admin");
   List<AiaStore> aiaList = (List<AiaStore>) request.getAttribute("aiaList");
%>
<!DOCTYPE html>
<html class="devise-layout-html">
<head prefix="og: http://ogp.me/ns#">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title><c:out value="${pageTitle}" /></title>
    <meta name="keywords" content="App Inventor 2 中文网,aia源码商店,aia源码下载,.aia 应用商店,应用商店,App Inventor 源码购买,AppInventor源码下载,App Inventor 2源码购买,AppInventor2源码下载">
	<meta name="description" content="App Inventor 2 中文网,.aia 源码商店,.aia 应用商店,aia 源码下载,<c:out value="${pageDesc}" escapeXml="false"/>">
	<meta name="application-name" content="App Inventor 2 中文网"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/static/css/bootstrap.min.css" crossorigin="anonymous">
    <link rel="stylesheet" href="/static/css/all.css" crossorigin="anonymous">
    <link href="/static/css/fonts.css" rel="stylesheet">
    <link href="/static/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="/static/css/mit_app_inventor.css">
    <link rel="stylesheet" type="text/css" href="/static/css/materialdesignicons.min.css">
    <link rel="stylesheet" type="text/css" href="/static/css/prism.css">
    <link rel="stylesheet" type="text/css" href="/static/css/docs.css">
    <link rel="stylesheet" type="text/css" href="/static/css/store.css">
    <script src="/static/js/jquery-3.3.1.slim.min.js" crossorigin="anonymous"></script>
    <script src="/static/js/popper.min.js" crossorigin="anonymous"></script>
    <script src="/static/js/bootstrap.min.js" crossorigin="anonymous"></script>
    <script src="/static/js/prism.js" crossorigin="anonymous"></script>
    <script src="/static/js/docs.js" crossorigin="anonymous"></script>
    <script type="text/javascript" src="/static/js/qrcode.min.js"></script>
    <script>
        var _hmt = _hmt || [];
        (function() {
          var hm = document.createElement("script");
          hm.src = "https://hm.baidu.com/hm.js?8d287b854d737bdc880e8ddeac1b309d";
          var s = document.getElementsByTagName("script")[0]; 
          s.parentNode.insertBefore(hm, s);
        })();
    </script>
<!-- Hotjar Tracking Code for https://www.fun123.cn -->
<script>
    (function(h,o,t,j,a,r){
        h.hj=h.hj||function(){(h.hj.q=h.hj.q||[]).push(arguments)};
        h._hjSettings={hjid:3792684,hjsv:6};
        a=o.getElementsByTagName('head')[0];
        r=o.createElement('script');r.async=1;
        r.src=t+h._hjSettings.hjid+j+h._hjSettings.hjsv;
        a.appendChild(r);
    })(window,document,'https://static.hotjar.com/c/hotjar-','.js?sv=');
</script>
</head>

<body>
<div class="mit_app_inventor">

<nav class="navbar navbar-expand-xl" id="navbar">
    <a class="navbar-brand" href="https://www.fun123.cn/">
	    <img src="/static/images/logo.png" alt="Logo" style="height:55px;">
    </a>
    <a style="color:#888;">beta</a>
    <a style="margin-left:20px;color:#3b3837;font-weight: bold;">App Inventor 2 .aia 源码商店</a>

    <div class="collapse navbar-collapse" id="navbarContent">
	<ul class="navbar-nav" style="margin-left: 120px;">
		<li>
		<a class="nav-link" href="https://www.fun123.cn/reference/">中文网</a>
		</li>
        <li class="dropdown">
            <a class="nav-link" href="https://www.fun123.cn" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                教育
            </a>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="https://www.fun123.cn/reference/info/?f=aiastore#AppEntry" target="_blank">中文教程</a>
                <a class="dropdown-item" href="https://bbs.tsingfun.com/forum-147-1.html?f=aiastore" target="_blank">中文论坛</a>
            </div>
            </li>
	    <li class="dropdown">
		<a class="nav-link" href="https://www.fun123.cn" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    关于
		</a>
		<div class="dropdown-menu">
		    <a class="dropdown-item" href="https://www.fun123.cn/reference/info/about-us.html?f=aiastore">关于我们</a>
			<a class="dropdown-item" href="https://www.fun123.cn/reference/info/ReleaseNotes.html?f=aiastore" target="_blank">发布日志</a>
			<a class="dropdown-item" href="https://www.fun123.cn/Ya_tos_form.html?f=aiastore" target="_blank">服务条款</a>
		</div>
	    </li>
    </ul>
    </div>

    <div class="account">
        <% if (phone != null) {
            out.println("账户信息：" + phone);
        } %>
    </div>
</nav>


<div class="default-page">
    <!--<div class="header" style="background:#009999;">
    <h1 class="font-weight-bold text-center offset-xl-2 col-xl-8">App Inventor 2&nbsp; .aia 源码商店</h1>
    </div>-->
