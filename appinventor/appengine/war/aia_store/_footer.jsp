<%@page contentType="text/html" pageEncoding="UTF-8"%>







    </div>




<div class="cndns-right">
    <div class="cndns-right-menu menu-common">
        <a href="javascript:" class="cndns-right-btn">
            <span class="fa fa-wechat"></span>
            <p>
                在线<br />
                客服
            </p>
        </a>
        <div class="cndns-right-box">
            <div class="box-border">
                <div class="sev-t">
                    <img src="/static/images/weixin.png" />
                    <i>扫码添加客服咨询</i>
                </div>
                <span class="arrow-right"></span>
            </div>
        </div>
    </div>
    <div class="cndns-right-menu menu-common">
        <a href="javascript:" class="cndns-right-btn">
            <span class="fa fa-share"></span>
            <p>
                我要<br />
                分享
            </p>
        </a>
        <div class="cndns-right-box">
            <div class="box-border">
                <div class="sev-t">
                    <div id="qrcode"></div>
                    <i style="margin-top:8px;color:#07C160">扫码分享到朋友圈</i>
                </div>
                <span class="arrow-right"></span>
            </div>
        </div>
    </div>
    <div class="cndns-right-menu menu-top" style="display:none" id="float_scrolltop">
        <a href="javascript:scroll2Top();" class="cndns-right-btn">
            <span class="fa fa-angle-up"></span>
            <i>顶部</i>
        </a>
    </div>
</div>

<script type="text/javascript">
var qrcode = new QRCode("qrcode", {  
    text: window.location.href + "?f=share",   //URL地址
    width: 150,
    height: 150,
    colorDark: '#000000',  //二维码颜色
    colorLight: "#ffffff"  //背景颜色
});
</script>

        
    
    </div>
</div>


<div class="footer" style="padding-bottom:0;">
    <div class="row container" style="margin:auto;">
    <div class="col-xl-3">
        <h4><a>App Inventor 2 中文网</a></h4>
    </div>
    <div class="col-xl-6 legal text-center">
        <ul>
        <li>
            <a href="https://www.fun123.cn" class="btn btn-link" role="button" target="_blank">© 2023 - <script>document.write(new Date().getFullYear());</script> 跟着学（上海）教育科技有限公司</a>
        </li>
        <li>
            <a href="https://www.fun123.cn/Ya_tos_form.html?f=refb"
                    target="_blank" class="btn btn-link" role="button">隐私策略和使用条款</a>
        </li>
        <li>
            &nbsp;
        </li>
        </ul>
    </div>
    <div class="col-xl-3 links">
        <a href="https://bbs.tsingfun.com/forum-147-1.html" target="_blank">技术支持</a><br>
        <a href="mailto:service@fun123.cn">service@fun123.cn</a>
    </div>

    </div>
</div>

</body>
</html>