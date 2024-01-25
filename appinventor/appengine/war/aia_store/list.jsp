<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   request.setAttribute("pageTitle", "App Inventor 2 源码商店");
   request.setAttribute("pageDesc", "aia源码一览,源码列表,App Inventor 2 源码列表,aia专业源码,aia学习源码");
%>
<%@ include file="_header.jsp" %> 

<div class="container-fluid">

        <c:choose>
            <c:when test="${is_admin}">
                <div class="op_area">
                    <a href="/aia-store/publish">+ 源码发布</a>
                </div>
            </c:when>
        </c:choose>

        <!--<a href="/aia-store/?order=publish_time&desc=1" style="margin-left:300px;">新发布优先</a>
        <a href="/aia-store/?order=score&desc=1">评分高优先</a>
        <c:choose>
            <c:when test="${phone != null}">
                <a href="/aia-store/">全部</a>
                <a href="/aia-store/?phone=${phone}">我的</a>
            </c:when>
        </c:choose>
        -->


        <!--<center>
            <a href="?offset=10">下一页 &gt;&gt;</a>
        </center>-->

        <div class="card-columns">

            <c:forEach items="${aiaList}" var="item">
                <div class="card shadow" style="max-height: 1000px;
                                                overflow: auto">
                    <div class="card-body">
                        
                        <h4 class="card-title"><c:out value="${item.title}" /></h4>
                        <!--<p class="card-text">
                            <i>
                            </i>
                            &nbsp;&nbsp;&nbsp;评分：<c:out value="${item.score}" />
                        </p>-->
                        <p class="card-text">
                            
                            <img src="<c:out value="${item.pics}" />" width="300px"/>
                            
                        </p>
                        <p class="card-text">
                            <c:choose>
                                <c:when test="${ fn:length(item.contents) > 100 }">
                                    <c:out value="${ fn:replace(fn:replace(fn:substring(item.contents, 1 ,100), '<', ''), 'p>','' ) } ..." escapeXml="false"/>
                                </c:when>
                                <c:otherwise>
                                    <c:out value="${item.contents}" escapeXml="false"/>
                                </c:otherwise>
                            </c:choose>
                        </p>

                        <p class="card-author">作者：
                            <c:choose>
                                <c:when test="${ fn:length(item.phone) == 11 }">
                                    <c:out value="${ fn:substring(item.phone, 0, 3) } "/>****<c:out value="${ fn:substring(item.phone, 7, 11) } "/>
                                </c:when>
                                <c:otherwise>
                                    <c:out value="${item.phone}" />
                                </c:otherwise>
                            </c:choose>
                        </p>
                        <p class="card-text">
                            <a href='/aia-store/<c:out value="${item.asId}" />'>查看详情</a>
                        </p>
                    </div>
                </div>
            </c:forEach>
            
        </div>


        <!--<center>
            <a href="?offset=10">下一页 &gt;&gt;</a>
        </center>-->




<%@ include file="_footer.jsp" %>