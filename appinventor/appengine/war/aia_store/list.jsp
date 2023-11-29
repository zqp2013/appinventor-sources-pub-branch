<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="com.google.appinventor.server.util.UriBuilder"%>
<%@page import="org.apache.commons.lang3.StringEscapeUtils"%>
<%@page import="java.util.List"%>
<%@page import="com.google.appinventor.shared.rpc.user.AiaStore"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<%
   String error = StringEscapeUtils.escapeHtml4(request.getParameter("error"));
   String phone = (String) request.getAttribute("phone");
   List<AiaStore> aiaList = (List<AiaStore>) request.getAttribute("aiaList");
%>
<!DOCTYPE html>
<html class="devise-layout-html">
<head prefix="og: http://ogp.me/ns#">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Aia 应用商店 · App Inventor 2 中文网</title>
    <meta name="keywords" content="App Inventor 2 中文网,.aia 应用商店,应用商店,App Inventor 2中文网,app inventor中文官网,appinventor网页版,appinventor2网站,appinventor官网,APPinventor2网页最新版,app inventor2中文官网,appinventor2 汉化,搭建appinventor2服务器,app inventor2 论坛,AppInventor,App Inventor,App Inventor 2,AI2中文网,AI2 中文网,ai2,少儿编程,青少年编程">
	<meta name="description" content="App Inventor 2 中文网.aia 应用商店，{{ page.description }}">
	<meta name="application-name" content="App Inventor 2 中文网"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/static/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/static/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
    <link href="/static/css/fonts.css" rel="stylesheet">
    <link href="/static/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="/static/css/mit_app_inventor.css">
    <link rel="stylesheet" type="text/css" href="/static/css/materialdesignicons.min.css">
    <link rel="stylesheet" type="text/css" href="/static/css/docs.css">
    <link rel="stylesheet" type="text/css" href="/static/css/prism.css">
    <script src="/static/js/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="/static/js/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="/static/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="/static/js/docs.js" crossorigin="anonymous"></script>
    <script src="/static/js/prism.js" crossorigin="anonymous"></script>
    <script>
        var _hmt = _hmt || [];
        (function() {
          var hm = document.createElement("script");
          hm.src = "https://hm.baidu.com/hm.js?8d287b854d737bdc880e8ddeac1b309d";
          var s = document.getElementsByTagName("script")[0]; 
          s.parentNode.insertBefore(hm, s);
        })();
    </script>
    <style type="text/css">
    .mit_app_inventor .card-columns {
        column-count: 2;
    }
    .mit_app_inventor .card {
        border-radius: 1rem;
    }
    </style>
</head>

<body class="mit_app_inventor">

<nav class="navbar navbar-expand-xl navbar-light">
    <a class="navbar-brand" href="https://www.fun123.cn/">
	<img src="/static/images/logo.png" alt="Logo" style="height:72px;">
    </a>
    <button type="button" class="btn create-btn" style="margin-right: 20px;" onclick="gotoappinventor();">创建 Apps</button>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarContent"
            aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle Navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarContent">
	<ul class="navbar-nav" style="margin-left: auto;">
		<li class="nav-item">
		<a class="nav-link" href="https://www.fun123.cn/reference/">首页</a>
		</li>
	    <li class="nav-item dropdown">
		<a class="nav-link" href="https://www.fun123.cn" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    关于我们
		</a>
		<div class="dropdown-menu">
		    <a class="dropdown-item" href="https://www.fun123.cn/reference/info/about-us.html?f=ref">关于我们</a>
			<a class="dropdown-item" href="https://www.fun123.cn/reference/info/ReleaseNotes.html?f=ref" target="_blank">发布日志</a>
			<a class="dropdown-item" href="https://www.fun123.cn/Ya_tos_form.html?f=ref" target="_blank">服务条款</a>
		</div>
	    </li>
	    <li class="nav-item dropdown">
		<a class="nav-link" href="https://www.fun123.cn" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    教育
		</a>
		<div class="dropdown-menu">
			<a class="dropdown-item" href="https://www.fun123.cn/reference/info/?f=ref#AppEntry" target="_blank">项目指南</a>
		    <a class="dropdown-item" href="https://bbs.tsingfun.com/forum-147-1.html?f=ref" target="_blank">中文论坛</a>
		    <a class="dropdown-item" href="https://www.fun123.cn/reference/tutorials?f=ref">中文教程</a>
		</div>
	    </li>
		<li class="nav-item dropdown">
		<a class="nav-link" href="https://www.fun123.cn" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			反馈
		</a>
		<div class="dropdown-menu">
			<a class="dropdown-item" href="https://support.qq.com/products/514085" target="_blank">我要反馈</a>
		</div>
		</li>
    </ul>
    </div>
	<div class="collapse navbar-collapse">
		<img src="/static/images/hello.png" alt="你好">
	</div>
</nav>


<div class="default-page">
    <div class="header" style="background:#009999;">
    <h1 class="font-weight-bold text-center offset-xl-2 col-xl-8">App Inventor 2&nbsp; Aia 应用商店</h1>
    </div>
    <div class="container-fluid">
        




        <a href="/aia-store/publish">+ 发布项目</a>



        <div class="card-columns">



            <c:forEach items="${aiaList}" var="item">
                <div class="card shadow" style="max-height: 1000px;
                                                overflow: auto">
                    <div class="card-body">
                        
                        <h4 class="card-title"><a href='/aia-store/<c:out value="${item.asId}" />'>title:<c:out value="${item.title}" /></h4>
                        <p class="card-text"><i><c:out value="${item.publish_time}" /></i>&nbsp;Likes:&nbsp;<span id="like_841d90c3-42de-4531-969e-6c580b45a154">0</span>
                            <img id="img_841d90c3-42de-4531-969e-6c580b45a154" src="/assets/numLikeHollow.png" onclick="doLike('841d90c3-42de-4531-969e-6c580b45a154', true);">
                            
                        </p>
                        <p class="card-text">
                            
                            <img src="/image/a22e67ab-1d01-45a8-a682-26981990788e/screen.png" width="300px">
                            
                        </p>
                        <p class="card-text"></p><p>This app will help grade 7 student to understand more about livestock production</p><p></p>
                        <p class="card-text">Credit:&nbsp;</p><p>Jolicoeur Jean baptiste</p><p>PGCE P/T Rodrigues 2023</p><br>
                            
                            <p></p>
                        <p class="card-text">
                            <a href="http://ai2.appinventor.mit.edu/?ng=841d90c3-42de-4531-969e-6c580b45a154" target="_blank">Load App Into MIT App Inventor</a>
                            <!-- <a href="http://jisqyvap4.appspot.com/?ng=841d90c3-42de-4531-969e-6c580b45a154" target="_blank">Load App Into MIT App Inventor</a> -->
                            
                            
                            <br>
                            <a href="/byowner/841d90c3-42de-4531-969e-6c580b45a154">Other projects by same author</a>
                            
                            <br><a href="/report/841d90c3-42de-4531-969e-6c580b45a154">Report Project</a><br>
                            Permanent link:&nbsp;<a href="https://gallery.appinventor.mit.edu/?galleryid=841d90c3-42de-4531-969e-6c580b45a154">
                                https://gallery.appinventor.mit.edu/?galleryid=841d90c3-42de-4531-969e-6c580b45a154</a>
                            
                        </p>
                    </div>
                </div>
            </c:forEach>

                
        </div>













    </div>
        
    <div class="footer background-green">
        <div class="row container">
        <div class="col-xl-3">
            <h4>App Inventor 2 中文网</h4>
        </div>
        <div class="col-xl-6 legal text-center">
            <ul>
            <li>
                <a href="https://www.fun123.cn" class="btn btn-link" role="button" target="_blank">© 2023 跟着学（上海）教育科技有限公司</a>
            </li>
            <li>
                <a href="https://www.fun123.cn/Ya_tos_form.html?f=refb"
                        target="_blank" class="btn btn-link" role="button">隐私策略和使用条款</a>
            </li>
            </ul>
        </div>
        <div class="col-xl-3 links">
            <a href="https://bbs.tsingfun.com/forum-147-1.html" target="_blank">技术支持</a><br>
            <a href="mailto:service@fun123.cn">service@fun123.cn</a>
        </div>

        </div>
    </div>
</div>

</body>
</html>