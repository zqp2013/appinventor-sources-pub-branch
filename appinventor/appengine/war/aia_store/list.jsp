<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="_header.jsp" %> 



        <a href="/aia-store/publish">+ 发布项目</a>

        <!--<center>
            <a href="?offset=10">下一页 &gt;&gt;</a>
        </center>-->

        <div class="card-columns">

            <c:forEach items="${aiaList}" var="item">
                <div class="card shadow" style="max-height: 1000px;
                                                overflow: auto">
                    <div class="card-body">
                        
                        <h4 class="card-title"><a href='/aia-store/<c:out value="${item.asId}" />'><c:out value="${item.title}" /></a></h4>
                        <p class="card-text"><i><c:out value="${item.publish_time}" /></i>&nbsp;&nbsp;&nbsp;评分：<c:out value="${item.score}" /></p>
                        <p class="card-text">
                            
                            <img src="<c:out value="${item.pics}" />" width="300px">
                            
                        </p>
                        <p class="card-text">
                            <c:out value="${item.contents}" />
                        </p>
                            
                            <p>作者：<c:out value="${item.phone}" /></p>
                        <p class="card-text">
                            <a href="<c:out value="${item.aia_path}" />" target="_blank">下载源码</a>
                            
                            <!--<br>
                            <a href="">作者其他作品</a>-->
                    
                            
                        </p>
                    </div>
                </div>
            </c:forEach>
            
        </div>


        <!--<center>
            <a href="?offset=10">下一页 &gt;&gt;</a>
        </center>-->




<%@ include file="_footer.jsp" %>