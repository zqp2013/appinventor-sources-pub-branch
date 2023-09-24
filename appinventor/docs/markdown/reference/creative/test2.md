---
title: App Inventor 2 测试文档
layout: documentation
description: 
---


<style type="text/css">
#markdown-toc {
    border-left: 2px solid #efefef;
    position: -webkit-sticky;
    position: sticky;
    float:right;
    top: 100px;
    padding-bottom: 20px;
    height: fit-content;
    overflow: hidden;
    background-color: #fff;
    z-index: 1000;
    min-width:200px;
    max-height:400px;
}
#markdown-toc ul {
    margin-left: -20px;
    list-style-type: revert;
    font-size: 14px;
    line-height: 24px;
}
#markdown-toc li {
    color: #656565;
    font-size: 14px;
    line-height: 24px;
}

#markdown-toc::before {
    content: "目录";
    font-size: 16px;
    color: rgb(27, 126, 255);
    margin-left:-18px;
    line-height:40px;
}
#markdown-toc a {
    color: #4E4E4E;
    background-color: transparent;
    text-decoration: none;
    cursor: pointer;
    transition: 0.2s;
    font-size:14px;
}
#markdown-toc li:hover, #markdown-toc a:hover, #markdown-toc .active {
    color: rgb(27, 126, 255);
    /*background-color:#f8f8f8;*/
}

/*选中项提升*/
.arrow {
    position: absolute;
    z-index: 2;
    top: 5px;
    height: 0;
    width: 0;
    border-top: 6px solid transparent;
    border-left: 9px solid #5e94fa;
    border-bottom: 6px solid transparent;
    border-right: 0;
    cursor: pointer;
}

/*鼠标经过，出现滚动条*/
#markdown-toc:hover{
    overflow: auto;
    transition: 0.2s;
}

/*滚动条*/
#markdown-toc::-webkit-scrollbar {
	width: 8px;
	height: 8px;
	background: transparent;
}
/*bar*/
#markdown-toc::-webkit-scrollbar-thumb {
	box-shadow: inset 0 0 5px 5px #ddd;
	border-radius: 30px;
	border: solid 3px transparent;
	background: transparent;
	color: transparent;

    background: #eee;
	border-radius: 30px;
}
/*bg*/
#markdown-toc::-webkit-scrollbar-track {
	box-shadow: inset 0 0 10px 10px transparent;
	border: solid 3px transparent;
	background: transparent;

    box-shadow: inset 0 0 5px #ccc;
    border-radius: 30px;
}

</style>


<script src="https://code.jquery.com/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
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
    for (var i = 0; i < alis.length; i++) {
        /*获取锚点集合中的元素分别到顶点的距离*/
        var a_height = $(alis[i]).offset().top - 100;
        if (a_height < scroll_height) {
            /*高亮显示*/
            $(sidebar_alis).removeClass('active');
            $(sidebar_alis[i]).addClass('active');
        }
    }
}

locateCatelogList();
$(window).bind('scroll', locateCatelogList);
</script>




* TOC
{:toc}





[&laquo; 返回首页](index.html)


* [基础数字块 ( 0 )](#number)
* [进制数字块 ( 0 )](#number-radix)
* [等于 ( = )](#eq)
* [不等于 ( ≠ )](#ne)
* [大于 ( > )](#gt)
* [大于等于 ( ≥ )](#gte)
* [小于 ( < )](#lt)
* [小于等于 ( ≤ )](#lte)
* [加 ( + )](#add)
* [减 ( - )](#subtract)
* [乘 ( * )](#multiply)
* [除 ( / )](#divide)



***
### 基础数字块 ( 0 )   {#number}

![](images/math/number.png)

可用作任何正数或负数，单击该块中的“0”将允许更改数字。

该块支持普通的 10 进制（例如：2、12 和 2.12），以及带前缀的其他机制数字，包括：
* Base-2（`二进制`）数字，例如 `0b`10（等于十进制 2）
* Base-8（`八进制`）数字，例如 `0o`14（等于十进制 12）
* Base-16（`十六进制`）数字，例如 `0x`d4（等于十进制 212）

***
### 进制数字块 ( 0 ) {#number-radix}

![](images/math/numberradix.png)

默认表示 10 进制的数字，单击“0”将允许更改数字。点击下拉菜单可以切换 `二进制`、`八进制`、`十进制`、`十六进制` 数字。

例如，这三个块是等效的：

![](images/math/numberradix_equivalent.png)

下拉列表支持：十进制 (base-10)、二进制 (base-2)、八进制 (base-8) 和十六进制 (base-16) 输入格式。

十进制模式允许输入任何正数或负数（例如 2、-12、2.12）。其他模式仅允许您输入整数（也称为任何正数或零）。

***
### 等于 ( = )   {#eq}

![](images/math/equal.png)

测试两个数字是否相等并返回 `真` 或 `假`。

***
### 不等于 ( ≠ )   {#ne}

![](images/math/notequal.png)

测试两个数字是否不相等并返回 `真` 或 `假`。

***
### 大于 ( > )   {#gt}

![](images/math/greater.png)

测试第一个数字是否大于第二个数字并返回 `真` 或 `假`。

***
### 大于等于 ( ≥ )   {#gte}

![](images/math/greaterequal.png)

测试第一个数字是否大于或等于第二个数字并返回 `真` 或 `假`。

***
### 小于 ( < )   {#lt}

![](images/math/less.png)

测试第一个数字是否小于第二个数字并返回 `真` 或 `假`。

***
### 小于等于 ( ≤ )   {#lte}

![](images/math/lessequal.png)

测试第一个数字是否小于或等于第二个数字并返回 `真` 或 `假`。

***
### 加 ( + )   {#add}

![](images/math/plus.png)

返回将任意数量的具有数字值的块相加的结果。带有数字值的块包括基本数字块、列表或文本的长度、带有数字值的变量等。

该块是一个[块拓展](../concepts/mutators.html)，可以扩展以允许更多数字相加。

![](images/math/plus.gif)

# 访问MIT code服务器

网址：`code.appinventor.mit.edu`，正常情况下访问非常非常的慢，甚至大概率访问不了，有条件使用DL的话请使用DL。VIP会员可联系客服免费获取！

# 新建一个项目，拖

aaa

## 测试

从

### 测试2

选中组件，在右侧的属性栏中查看“访问令牌” 或 “Token”属性，拷贝到中文网相应组件的“访问令牌” 或 “Token” 属性中，回车，保存项目即可。

例如：

![访问令牌](images/访问令牌.png)



# 1111

adfasdf
asdfa
sdf
as

adf


asdf
asdf


asdf

asdf


asdf


asdf


asdf

asdf

asd
f
a
sdf
as
df

as
d

## 222


dfdf



df



d
f



df


# 123

### 3333


df
dsafa
sdaf


df

fd
fd


df
d
f
d
fd


#### 4444

df
d
f
df
df
df


