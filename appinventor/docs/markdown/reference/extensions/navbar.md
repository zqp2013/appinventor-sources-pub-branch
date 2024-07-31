---
title: App Inventor 2 打造个性化酷炫的底部导航条
layout: documentation
description: 虽说 App Inventor 2 是简单的积木式开发手机 App，但是通过众多拓展它也能实现很多酷炫的功能，比如本文介绍的2款酷炫导航条，函数代码块用法超级简单，效果不错。当然还有更复杂更个性化的导航条拓展。
---

* TOC
{:toc}

[&laquo; 返回首页](index.html)

## <img src="navbar/BubbleTabBar.png" style="width:16px;margin:-4px 5px 0 0">BubbleTabBar 【用法简单，效果不错，可定制字体】  {#BubbleTabBar}

### 导航条效果

![导航条效果](navbar/导航条效果.gif)

### 从零开始完整的视频教程

<iframe width="800" height="500" src="//player.bilibili.com/player.html?bvid=BV1iC4y1e7DF&high_quality=1&autoplay=0" frameborder="no" allowfullscreen="true"></iframe>

### 步骤总结如下

1. 导入并添加拓展，添加一个水平布局，宽度充满，屏幕底部对齐

1. 代码块：添加按钮及图标，id从1开始，最后初始化即可

1. 可以在事件中指定某个Tab选中

1. 可在属性中设置facetype，定制字体

注：可以在导航条的切换事件中通过**同一屏幕组件的显示和隐藏来完成UI的切换**，多屏幕通信较为复杂且导航条必须每个屏幕都要有，因此还是推荐同一屏幕模拟完成多屏操作，更多请参考[《构建具有多个屏幕的应用程序》](../other/manyscreens.html?f=navbar)。

## 源码下载

.aix 拓展下载：

{:.vip}
[com.dreamers.bubbletabbar.aix](navbar/com.dreamers.bubbletabbar.aix)

demo 下载：

{:.vip}
[tabui_demo.aia](navbar/tabui_demo.aia)


## <img src="navbar/ButtonBar.png" style="width:16px;margin:-4px 5px 0 0">ButtonBar 【功能更强大，定制方法更多，效果更酷】  {#ButtonBar}

### 导航条效果

![导航条效果](navbar/ButtonBar.gif)

### 从零开始完整的视频教程

<iframe width="800" height="500" src="//player.bilibili.com/player.html?bvid=BV1kU421Z7TM&high_quality=1&autoplay=0" frameborder="no" allowfullscreen="true"></iframe>

### 步骤总结如下

1. 导入并添加拓展，添加一个水平布局，宽度充满，屏幕底部对齐

1. 代码块：**和上面BubbleTabBar刚好相反，先创建TabBar对象，再添加按钮及图标**，id从1开始。

1. 可以在事件中指定某个Tab选中

1. 可在属性中设置facetype，定制字体

## 源码下载

.aix 拓展下载：

{:.vip}
[com.dreamers.bottombar.aix](navbar/com.dreamers.bottombar.aix)

demo 下载：

{:.vip}
[安卓导航条.aia](navbar/安卓导航条.aia)
