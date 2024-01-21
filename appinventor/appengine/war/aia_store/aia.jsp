<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="_header.jsp" %> 




<a href="/aia-store/"><< 返回列表</a>&nbsp;&nbsp;
<a href="/aia-store/update?id=<c:out value="${aia.asId}" />">编辑</a>&nbsp;&nbsp;
<a href="/aia-store/rm?id=<c:out value="${aia.asId}" />">删除</a>

            <div class="card shadow" style="max-height: 1000px;
                                                overflow: auto">
                    <div class="card-body">
                        
                        <h4 class="card-title"><c:out value="${aia.title}" /></h4>
                        <p class="card-text"><i><c:out value="${aia.publish_time}" /></i>&nbsp;&nbsp;&nbsp;评分：<c:out value="${aia.score}" /></p>
                        <p class="card-text">
                            
                            <img src="<c:out value="${aia.pics}" />" width="300px">
                            
                        </p>
                        <p class="card-text">
                            <c:out value="${aia.contents}" />
                        </p>
                            
                            <p>作者：<c:out value="${aia.phone}" /></p>
                        <p class="card-text">
                            <a href="<c:out value="${aia.aia_path}" />" target="_blank">下载源码</a>
                            
                            <!--<br>
                            <a href="">作者其他作品</a>-->
                        
                            
                        </p>
                    </div>
            </div>






<%@ include file="_footer.jsp" %>