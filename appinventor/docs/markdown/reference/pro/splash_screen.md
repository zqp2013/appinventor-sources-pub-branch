---
title: App Inventor 2 实现商业级APP启动屏幕效果(SplashScreen)
layout: documentation
description: App Inventor 2 实现商业级APP启动屏幕效果(SplashScreen)。实现的功能包括：启动App时展示启动屏，右上角展示5秒倒计时，中途可点击跳过。倒计时结束或点击跳过，则跳转到主界面。代码逻辑：每隔1秒触发后，将倒计时秒数变量 -1，并更新到文本中；当倒计时秒数为0，则跳转主界面。
---

* TOC
{:toc}

[&laquo; 返回首页](index.html)

## 启动屏幕效果

实现的功能包括：启动App时展示启动屏，右上角展示5秒倒计时，中途可点击跳过。倒计时结束或点击跳过，则跳转到主界面。效果如下：

![App启动屏效果](splash_screen/App启动屏效果.gif)

## 实现原理

App启动屏效果的实现原理及详细步骤要点如下：

{:.vip}

* Screen1作为启动屏幕使用，新增其他屏幕作为主界面。

* 界面布局比较常规，右上角放一个按钮，用于显示倒计时和跳过文本，注意：**按钮文本颜色设置为白色，背景颜色黑色透明**（参考：#0000004a）。

* 倒计时使用“传感器 -> 计时器”组件，设置计时间隔为1000ms，即1秒。

* 代码逻辑：每隔1秒触发后，将倒计时秒数变量 -1，并更新到文本中；当倒计时秒数为0，则跳转主界面：

  ![计时](splash_screen/计时.png)

* 点击“跳过”按钮，直接停止计时，立即跳到主界面：

  ![跳过](splash_screen/跳过.png)

## 源码下载

{:.vip}
[splash_screen.aia](splash_screen/com.splash_screen.aia)
