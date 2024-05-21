---
title: App Inventor 2 串口组件：App使用OTG数据线进行串口通信
layout: documentation
description: 详解App Inventor 2 串口组件：App使用OTG数据线进行串口通信。
---

* TOC
{:toc}

[&laquo; 返回串口通信器](../connectivity.html#Serial)

![serial](images/serial_component.png)

通过“串口通信器”组件，App 可以通过手机串口进行通信，不过使用蓝牙/ble 通信可能是目前更主流的方案！（详见[<font style="margin-left:10px;color:#F88D34;font-weight:bold;"><i class="mdi mdi-bluetooth-audio" style="font-size: 18px;"/> Iot 专题</font>](../../iot/?f=serial)）

手机串口通信模型如下：

![serial](images/serial_app.jpg)

视频介绍了App Inventor 2 串口组件的使用方法，以及如何利用手机串口与Arduino硬件进行通信。串口通信波特率：9600。英文原版视频如下：

<iframe width="930" height="500" src="//player.bilibili.com/player.html?bvid=BV1Ns421A7rs&high_quality=1&autoplay=0" frameborder="no" allowfullscreen="true"></iframe>

可以看到，手机串口连接时，没有像PC那样指定“COM3”等端口，而是直接使用默认的USB设备：

![serial](images/serial_usb.jpg)
