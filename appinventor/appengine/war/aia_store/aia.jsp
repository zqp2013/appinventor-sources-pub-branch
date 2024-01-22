<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="_header.jsp" %> 

<%
   Boolean has_buy = (Boolean) request.getAttribute("has_buy");
%>
<% if (error != null) {
    out.println("<center><font color=red><b>" + error + "</b></font></center>");
} %>


<a href="/aia-store/"><< 返回列表</a>&nbsp;&nbsp;
<a href="/aia-store/update?id=<c:out value="${aia.asId}" />">编辑</a>&nbsp;&nbsp;
<a href="/aia-store/rm?id=<c:out value="${aia.asId}" />">删除</a>

            <div class="card shadow" style="max-height: 1000px;
                                                overflow: auto">
                    <div class="card-body">
                        
                        <h4 class="card-title"><c:out value="${aia.title}" /></h4>
                        <p class="card-text"><i><c:out value="${aia.publish_time}" /></i>&nbsp;&nbsp;&nbsp;评分：<c:out value="${aia.score}" />
                                &nbsp;&nbsp;&nbsp;&nbsp;购买信息：
                                <% if (has_buy) {
                                    out.println("<font color=green>已购买</font>");
                                } else {
                                    out.println("<font>未购买</font>");
                                } %>
                        </p>
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

                        <p class="card-text">
                            ￥ <c:out value="${aia.price}" />

                            
                            <form action="/aia-store/pay/" method="post">
                                <input type="hidden" name="id" value="<c:out value="${aia.asId}" />">
                                <input type="hidden" name="subject" value="App Inventor 2 中文网 aia 源码">
                                <input type="hidden" name="phone" value="<% if (phone != null) {
                                        out.println(phone);
                                    } %>">
                                <input type="hidden" name="amount" value="<c:out value="${aia.price}" />">
                                <button name="button" type="submit">会员购买</button>
                            </form>

                            <br/><br/>

                            <form action="/aia-store/pay/" method="post">
                                <input type="hidden" name="id" value="<c:out value="${aia.asId}" />">
                                <input type="hidden" name="subject" value="App Inventor 2 中文网 aia 源码">


                                <div>
                                    <span style="color: red; visibility: hidden;" id="error_msg">手机号码输入有误，请检查！</span>
                                </div>

                                <input class="form-control form-input top js-username-field" style="width:300px"
oninput="value=value.replace(/[^0-9.]/g,'')" 
onblur="javascript:if(value.length!=11){
    document.getElementById('paybtn').disabled = true;
    if (value.length > 0) document.getElementById('error_msg').style.visibility = 'visible';
} else {document.getElementById('paybtn').disabled = false; document.getElementById('error_msg').style.visibility = 'hidden'; } " 
                                    autocapitalize="off" autocorrect="off" placeholder="请输入手机号码，作为购买凭证"
                                    required="required" title="该字段是必填字段。" type="text" name="phone" id="phone">
  

                                <input type="hidden" name="amount" value="<c:out value="${aia.price}" />">
                                <button name="button" type="submit" id="paybtn">非会员购买</button>
                            </form>


                            &nbsp;&nbsp;&nbsp;&nbsp;<a href="/aia-store/validatebuy?phone=&id=">非会员已购买验证</a>
                        </p>
                    </div>
            </div>



<%@ include file="_footer.jsp" %>