---
title: App Inventor 2 连接方式：AI伴侣、模拟器、USB
layout: documentation
description: App Inventor 2 的各种连接方式：AI伴侣、模拟器、USB，以及它们之间的区别。
---

[&laquo; 返回首页](index.html)

## App Inventor 2 连接测试App

从功能上来说大致分为3类，在连接菜单下：

![3种连接方式](images/3种连接方式.png)

但是每种类型下面仍有一些不同的选择，下面开始介绍各种连接方式的特点：

|   连接方式 <img style="width:50px;float:left;"/>     | 测试介质	  | 特点  |
|---------|---------|---------|
|  <i class="mdi mdi-cellphone-wireless"></i>  **AI伴侣**	     |   Android手机	 | `特别适合小朋友，简单高效，所见即所得，还能编译成apk真机测试`。<br/>前提是必须有一部安卓手机，并安装好AI伴侣app |
|         |    幕享App      |    将安卓手机投屏到电脑上，即实际利用手机进行测试，前提也是必须得有一部安卓手机。<br/>好处是真机测试，可以一屏展示，适合教学演示。      |
|         |    商业Android模拟器（Mumu，雷电、逍遥） | 适合有一定的动手能力，没有安卓手机的或手机不在身边，运行速度不错，使用起来体验也很好。<br/>特别适合教学演示，一屏展示效果，而无需电脑手机联合展示。<br/>**缺点**：商业模拟器多少都有一些广告及游戏app，还不能删除，**不适合小朋友**。|
|         |    桌面版AI伴侣	 | 也是搭建一个安卓模拟器，安装AI伴侣。对电脑显卡要求高，一般电脑用不了。<br/>即便电脑显卡支持，但是本身及AI伴侣版本都很旧，维护者几乎不更新了，`这种方式直接放弃就好了`。 |
|  <i class="mdi mdi-cellphone-link"></i>  **模拟器**	      |    [aiStarter](ai2_starter.html) 启动默认模拟器	      |    利用aiStarter自动启动无广告的默认模拟器，全程**自动交互启动及运行**，无需手动操作。<br/>`中文最新版性能优化提升，对电脑要求非常低，虚拟机也可正常使用，用户体验很不错！`[点此下载](ai2_starter.html)。    |
|   <i class="mdi mdi-usb-flash-drive-outline"></i>  **USB**    |     [aiStarter](ai2_starter.html) 启动USB调试	     |    也是利用aiStarter启动USB调试，通过USB连接你的手机，自动启动你手机上的AI伴侣app进行测试。<br/>相当于用你手机扫了一次二维码，只是这里变成USB自动帮你做了这件事。<br/>和第一种方式本质上是一样的，流程变复杂了些，需要一定动手能力。<br/>好处是可以利用手机助手，将手机投屏到电脑上，用于一屏展示效果（倒不如直接第二种方式）。      |


**综上所述：**

1、小朋友编程的话，有条件建议直接使用安卓手机扫二维码测试；否则使用最新版的AIStarter模拟器也可以。

2、对于没有安卓手机的或需要一屏展示效果的，建议第二种：使用商业模拟器，速度快，模拟的场景也较AIStarter模拟器多一些。

3、对于学生教学场景，功能测试要求不高、或不想受游戏App干扰、或商业模拟器安装不了，推荐使用[AI2Starter模拟器](ai2_starter.html)。

## Q & A

### Q：[AI2Starter模拟器](ai2_starter.html)可以调整分辨率吗？

A：不能，目前这个模拟器分辨率固定为 HVGA（320 * 480），不支持调整。需要调分辨率的话，推荐商业模拟器。

### Q：商业模拟器如何使用？

A：步骤如下：

1. 电脑网页上搜索MuMu，下载最新版模拟器。

1. 启动后，在模拟器设置中设置为手机模式，选择适合自己的分辨率。

1. 帮助菜单 --> AI伴侣信息，下载AI伴侣apk安装包到电脑，然后模拟器菜单选择安装apk，完成AI伴侣App的安装并启动它。

1. 开始测试：连接 -->  AI伴侣，复制 6 位字符码，粘贴到模拟器中的AI伴侣中，点“使用编码连接”即可。

## 视频演示

**完整版**

[《App Inventor 2 连接：AI伴侣 + 模拟器 + USB（完整版）》](https://www.bilibili.com/video/BV1Gs4y1u7D5)

**分集介绍**

[《App Inventor 2 连接：AI伴侣（最推荐的测试方式）》](https://www.bilibili.com/video/BV1Ec411A7W2)

[《App Inventor 2 连接：AI伴侣（安卓模拟器，手机测试的替代方案）》](https://www.bilibili.com/video/BV1Yd4y1Z7NS)

[《App Inventor 2 连接：AI伴侣（桌面版AI伴侣，版本过旧不推荐）》](https://www.bilibili.com/video/BV1cM4y1B7hw)

[《App Inventor 2 连接：模拟器（Ai2 Starter启动手机模拟器）》](https://www.bilibili.com/video/BV1YP411974j)

[《App Inventor 2 连接：USB（Ai2 Starter启动手机USB调试）》](https://www.bilibili.com/video/BV1iz4y1b7ky)

