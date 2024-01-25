<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   AiaStore aia = (AiaStore) request.getAttribute("aia");
   if (aia != null) {
      request.setAttribute("pageTitle", aia.title + " · App Inventor 2 源码商店");
      request.setAttribute("pageDesc", aia.contents);
   } else {
      request.setAttribute("pageTitle", "App Inventor 2 源码商店");
   }

   Boolean has_buy = (Boolean) request.getAttribute("has_buy");
%>
<%@ include file="_header.jsp" %>


<% if (error != null) {
    out.println("<center><font color=red><b>" + error + "</b></font></center>");
} %>


<a href="/aia-store/"><< 返回列表</a>&nbsp;&nbsp;


        <c:choose>
            <c:when test="${is_admin || aia.phone == phone}">
                <a href="/aia-store/update?id=<c:out value="${aia.asId}" />">编辑</a>&nbsp;&nbsp;
                <a href="/aia-store/rm?id=<c:out value="${aia.asId}" />">删除</a>
            </c:when>
        </c:choose>



                    <div class="card-body">
                        
                        <h4 class="card-title"><c:out value="${aia.title}" /></h4>
                        <p class="card-text">
                            <i>
                                <% if (aia.publish_time != null) {
                                    out.println(dtfmt.format(aia.publish_time));
                                } %>
                            </i>
                            <!--&nbsp;&nbsp;&nbsp;评分：<c:out value="${aia.score}" />-->

                                &nbsp;&nbsp;&nbsp;&nbsp;购买信息：
                                <c:choose>
                                    <c:when test="${aia.price == '0'}">免费</c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${has_buy != null && has_buy}">已购买</c:when>
                                            <c:otherwise>未购买</c:otherwise>
                                        </c:choose>
                                    </c:otherwise>                                    
                                </c:choose>
                        </p>
                        <p class="card-text">
                            
                            <img src="<c:out value="${aia.pics}" />" width="300px"/>
                            
                            <br/>屏幕数量：<c:out value="${aia.num_screen}" />
                            <br/>代码块数量：<c:out value="${aia.num_blocks}" />
                            <br/>分类：
                            <c:choose>
                                <c:when test="${aia.catalog == null || aia.catalog == '1'}">软件应用App</c:when>
                                <c:when test="${aia.catalog == '2'}">物联网硬件App</c:when>
                                <c:when test="${aia.catalog == '3'}">游戏App</c:when>
                                <c:when test="${aia.catalog == '4'}">其他App</c:when>
                            </c:choose>
                            
                            <br/>等级：
                            <c:choose>
                                <c:when test="${aia.quality == null || aia.quality == '1'}">练手级</c:when>
                                <c:when test="${aia.quality == '2'}">教学级</c:when>
                                <c:when test="${aia.quality == '3'}">应用级</c:when>
                                <c:when test="${aia.quality == '4'}">商业级</c:when>
                            </c:choose>
                            
                            <br/>技术支持：
                            <c:choose>
                                <c:when test="${aia.provide_support == '1'}">提供</c:when>
                                <c:otherwise>不提供</c:otherwise>
                            </c:choose>
                        </p>

                        <c:if test="${fn:length(aia.apk_path) > 0}">
                            提供安卓apk供预览最终效果：
                            <a href="<c:out value="${aia.apk_path}" />" target="_blank">下载apk</a> 或扫码下载
                            <div id="qrcode"></div>
                            
                            <script type="text/javascript">
                            var qrcode = new QRCode("qrcode", {  
                                text: window.location.href + "?f=share",   //URL地址
                                width: 150,
                                height: 150,
                                colorDark: '#000000',  //二维码颜色
                                colorLight: "#ffffff"  //背景颜色
                            });
                            </script>
                        </c:if>

                        <p class="card-text">
                            <c:out value="${aia.contents}" escapeXml="false"/>
                        </p>

                        <p>作者：<c:out value="${aia.phone}" />
                        <!--<br>
                            <a href="">作者其他作品</a>--></p>



<c:set var="NoNeedBuy" value="${(has_buy != null && has_buy) || aia.price == '0' || is_admin || aia.phone == phone}"/>
<c:choose>

    <c:when test="${NoNeedBuy}">
        <!--已购买或免费-->
        <p class="card-text">
            售价：￥ <c:out value="${aia.price}" /><br/>
            <a href="<c:out value="${aia.aia_path}" />" target="_blank">下载源码</a> 
        </p>
    </c:when>

    <c:otherwise>
        <!--购买-->
        <p class="card-text">
            


            <c:choose>
                <c:when test="${phone != null}">
                    <!--已登录-->
                    ￥ <del><c:out value="${aia.price}" /></del> <c:out value="${aia.price * 0.5}" /> &nbsp;&nbsp;会员价5折
                    <form action="/aia-store/pay/" method="get">
                        <input type="hidden" name="id" value="<c:out value="${aia.asId}" />">
                        <input type="hidden" name="subject" value="App Inventor 2 中文网 aia 源码">
                        <input type="hidden" name="phone" value="<% out.println(phone); %>">
                        <input type="hidden" name="amount" value="<c:out value="${aia.price * 0.5}" />"><!--折扣-->
                        <button name="button" type="submit">会员购买</button>
                    </form>
                </c:when>
                <c:otherwise>
                    <!--未登录-->
                    ￥ <c:out value="${aia.price}" />&nbsp;&nbsp;
                    <a href="https://www.fun123.cn/" target="_blank">未登录，点此登录以会员折扣价购买</a>


                    <br/><br/>
                    <form action="/aia-store/pay/" method="get">
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
                document.getElementById('validatebuy').disabled = true;
            } else {
                document.getElementById('paybtn').disabled = false; 
                document.getElementById('error_msg').style.visibility = 'hidden'; 
                document.getElementById('validatebuy').href = '/aia-store/validatebuy?phone=' + value + '&id=<c:out value='${aia.asId}' />'; 
                document.getElementById('validatebuy').disabled = false;
            } " 
                            autocapitalize="off" autocorrect="off" placeholder="请输入手机号码，作为购买凭证"
                            required="required" title="该字段是必填字段。" type="text" name="phone" id="phone">
        
        
                        <input type="hidden" name="amount" value="<c:out value="${aia.price}" />">
                        <button name="button" type="submit" id="paybtn" disabled>非会员购买</button>  
                        &nbsp;&nbsp;<a id="validatebuy">非会员已购买点此验证</a>
                    </form>

                </c:otherwise>
            </c:choose>
            
        </p>
    </c:otherwise>

</c:choose>

                    </div>



<%@ include file="_footer.jsp" %>