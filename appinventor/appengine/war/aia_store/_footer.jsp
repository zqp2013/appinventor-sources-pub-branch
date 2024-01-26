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


<div class="footer" style="padding-bottom:30px;">
    <div class="row container" style="margin:auto;">
    <div class="col-xl-3">
        <h4><a href="https://www.fun123.cn/?f=asbtn" target="_blank">App Inventor 2 中文网</a></h4>
        <h6><a href="https://www.fun123.cn/aia-store/?f=asbtn" target="_blank">App Inventor 2 aia 源码商店</a></h6>
    </div>
    <div class="col-xl-6 legal text-center">
        <ul>
        <li>
            <a href="https://www.fun123.cn" class="btn btn-link" role="button" target="_blank">© 2023 - <script>document.write(new Date().getFullYear());</script> 跟着学（上海）教育科技有限公司</a>
        </li>
        <li>
            <a><b>源码版权申明</b>：无特别申明的前提下，本站源码版权归原作者所有，<br/>未经原作者书面授权一律不允许包括但不限于二次售卖等商业用途。</a>
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