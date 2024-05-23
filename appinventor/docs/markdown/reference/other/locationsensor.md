---
title: 使用位置传感器
layout: documentation
description: App Inventor 2 使用位置传感器
---

[&laquo; 返回首页](index.html)

[位置传感器](../components/sensors.html#LocationSensor) 组件可以确定手机的经纬度以及街道地址。你可以使用它与他人分享你的位置，记录旅途或寻宝过程中的“足迹”，或将其作为课堂点名的方式（只要学生有 Android 设备！）

下面的示例应用程序很简单，但说明了确定位置的基本方法。这两个应用程序都会在手机显示屏上报告当前的经纬度和地址，并且为了好玩，还会大声说出地址。

第一个应用程序会在传感器获取数据后立即报告位置，并且每次手机位置发生变化时都会报告位置；第二个应用程序仅在响应事件时调用位置传感器（当用户单击按钮时）。

## 示例App 1：位置读取器

一旦传感器读取位置数据并发生更改，就会报告位置数据。

[AI1源码下载](LocationSensorAssets/LocationTest.zip)

这是App的用户界面和组件：

![App design view](LocationSensorAssets/designer.png)

以下是App的代码块，带有注释：

![App blocks](LocationSensorAssets/locationChangedBlocks.png)

## 示例App 2：获取单击按钮时的位置

此应用说明了如何仅在发生某些事件时访问位置信息。[位置传感器](../components/sensors.html#LocationSensor) 开始时处于禁用状态，然后在单击按钮时启用，并在确定位置时再次禁用。

[AI1源码下载](LocationSensorAssets/LocationOnClickTest.zip)

这是App的用户界面和组件：

![App design view](LocationSensorAssets/locationOnClickDesigner.png)

以下是App的代码块，带有注释：

![App blocks](LocationSensorAssets/locationOnClickBlocks.png)

## 变化

* 第二个应用程序演示了如何使用位置数据来响应事件。编写一个应用程序，通过发送一条文本来响应任何收到的文本，该文本说：“我现在正在开车，稍后再回复您。我的位置是...”，并填写当前位置。
* 编写一个“足迹”应用程序，通过记录每个位置变化来跟踪你（手机）的行踪。一个有趣的改进是，仅当位置发生了一定变化时才记录新的“足迹”。
