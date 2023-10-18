// Handle redirection to documentation based on locale query parameter (if specified)
(function() {
  var locale = window.location.search.match('[&?]locale=([a-zA-Z-]*)');
  if (locale) {
      if (locale[1].indexOf('en') === 0) {
          // English needs to stay at the top level to not break existing links
          var page = window.location.pathname.split('/');
          if (page.length === 5) {
              page.splice(2, 1);
          } else {
              // already on english
              return;
          }
          window.location.href = page.join('/');
      } else {
          var page = window.location.pathname.split('/');
          if (page.length === 4) {
              page.splice(2, 0, locale[1]);
          } else if (page[2].toLowerCase() != locale[1].toLowerCase()) {
              page[2] = locale[1];
          } else {
              return;  // already on the desired language
          }
          // Test that the page exists before redirecting.
          var xhr = new XMLHttpRequest();
          xhr.open('HEAD', page.join('/'), false);
          xhr.onreadystatechange = function() {
              if (xhr.readyState == 4) {
                  if ((xhr.status == 200 || xhr.status == 204)) {
                      window.location.href = page.join('/');
                  } else if (xhr.status  >= 400) {
                      page.splice(2, 1);  // go to english version
                      window.location.href = page.join('/');
                  }
              }
          };
          xhr.send();
      }
  }
})();

// Handle embedded documentation in help by removing website template
if (window.self !== window.top) {
  setTimeout(function() {
      var videos = document.querySelectorAll('video');
      for (var i = 0; i < videos.length; i++) {
          if (parseInt(videos[i].getAttribute('width')) > 360) {
              var aspect = parseInt(videos[i].getAttribute('height')) / parseInt(videos[i].getAttribute('width'));
              videos[i].setAttribute('width', '360');
              videos[i].setAttribute('height', '' + (360 * aspect));
          }
      }
      var h1 = document.querySelector('h1');
      var article = document.querySelector('article');
      article.insertBefore(h1, article.firstElementChild);
      document.body.innerHTML = article.outerHTML;
  });
}


function animate(elem, sty, timeout, callback){
	var f = j = 0,//j动画总数
		tween = function(t,b,c,d) { return -c*(t/=d)*(t-2) + b; },
		execution = function(key, val, px, t){
			var s = (new Date()).getTime(),
			d = t || 500,
			b = parseInt(elem.style[key] || elem[key]) || 0,//当前值
			c = val - b;					 				//变化差值
			(function(){
				var t = (new Date()).getTime() - s;
				var styleAttr = (typeof(elem.style[key]) != 'undefined');
				if(t > d)
				{
					t = d;
					if (styleAttr)
						elem.style[key] = px ? (tween(t,b,c,d) + 'px') : tween(t,b,c,d);
					else
						elem[key] = px ? (tween(t,b,c,d) + 'px') : tween(t,b,c,d);
					++f==j && callback && callback.apply(elem);
					return;
				}
				if (styleAttr)
					elem.style[key] = px ? (tween(t,b,c,d) + 'px') : tween(t,b,c,d);
				else
					elem[key] = px ? (tween(t,b,c,d) + 'px') : tween(t,b,c,d);
				setTimeout(arguments.callee, 10); //arguments.callee 匿名函数递归调用
			})();
		};
	for(var i in sty)
	{
		j++;
		execution(i, parseInt(sty[i]), sty[i].toString().indexOf('px') > 0, timeout);
	}
}
function fadeIn(id){
	if (document.getElementById(id) == null) return;
	document.getElementById(id).style.display = 'block';
	if (document.getElementById(id).style.opacity != 0) return;
	animate(document.getElementById(id), {opacity: 1}, 700);
}
function fadeOut(id){
	var obj = document.getElementById(id);
	if (obj == null) return;
	if (obj.style.opacity == '')
		obj.style.opacity = 1;
	if (obj.style.opacity != 1) return;
	animate(obj, {opacity: 0}, 700);
	setTimeout(function(){obj.style.display = 'none';}, 700);
}
// window.onscroll = function (){
// 	var d = document.body.scrollTop||document.documentElement.scrollTop;
// 	if (d > 60) {
// 		fadeIn('float_scrolltop');
// 	} else {
// 		fadeOut('float_scrolltop');
// 	}
// };
function scroll2Top(){
	var ie = document.documentElement;
	var chrome = document.body;
	if (ie.scrollTop == 0 && chrome.scrollTop == 0)
		return;
	
	animate(ie.scrollTop > chrome.scrollTop ? ie : chrome, {scrollTop: 0}, 700);
}


/**
* TOC highlight with the corresponding content
*/
function locateCatelogList() {
  /*获取文章目录集合,可通过：header过滤器*/
  var alis = $('article :header');
  /*获取侧边栏目录列表集合**/
  var sidebar_alis = $('#markdown-toc').find('a');
  /*获取滚动条到顶部的距离*/
  var scroll_height = $(window).scrollTop();
  if (scroll_height > 0) {
      $('.g-header').addClass('headerUp');
  }
  // 返回顶部按钮
  if (scroll_height > 60) {
    fadeIn('float_scrolltop');
  } else {
    fadeOut('float_scrolltop');
  }

  var active_obj = null;
  for (var i = 0; i < alis.length; i++) {
      /*获取锚点集合中的元素分别到顶点的距离*/
      var a_height = $(alis[i]).offset().top - 100;
      if (a_height < scroll_height) {
          /*高亮显示*/
          $(sidebar_alis).removeClass('active');
          $(sidebar_alis[i]).addClass('active');
          active_obj = sidebar_alis[i];
      }
  }

  if (active_obj != null) {
    //console.log(active_obj.offsetTop);
    $('#markdown-toc').scrollTop(active_obj.offsetTop - 200);
  }
}

locateCatelogList();
$(window).bind('scroll', locateCatelogList);


$().ready(function(){
    if ($("#markdown-toc").length > 0) {
        $('#float_menu_btn').show();
    }

    //禁用鼠标右键
    $(document).bind("contextmenu",function(){return false;});

    //vip控制
//--------------------VIP start------------------------
    function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i].trim();
        if (c.indexOf(name)==0) return c.substring(name.length,c.length);
    }
    return "";
    }
    function hasVip() {
    var user = getCookie("auth");
    if (user=="" || user=="591f53a4-62c5-43ff-893d-2acb2f76d3fe") {
        return false;
    } else {
        return true;
    }
    }

    //no vip
    if (!hasVip()) {
    var vipElems = document.getElementsByClassName('vip');
    for (var i = vipElems.length - 1; i >= 0; i--) {
        var newDiv = document.createElement("div");
        newDiv.className = "locked";

        var url = "https://www.fun123.cn/reference/info/vip.html?f=doc&url=" + window.location.href.substring(window.location.href.lastIndexOf('/') + 1);
        var alertText = document.createElement("span");
        alertText.innerHTML = '开通VIP会员后查看此处隐藏内容！ <a target="_blank" href="' + url + '">点此开通VIP</a>';
        newDiv.appendChild(alertText);

        $(newDiv).insertBefore(vipElems[i]);
        $(newDiv).next().remove();
    }
    }
//--------------------VIP end------------------------
});

//显示，隐藏菜单
function HideORDispMenu() {
    $("#markdown-toc").toggle();
}
