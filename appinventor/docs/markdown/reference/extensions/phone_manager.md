---
title: App Inventor 2 TaifunTM拓展：获取本机手机号码
layout: documentation
description: App Inventor 2 TaifunTM拓展：获取本机手机号码。电话管理器、手机管理器。IMEI获取。
---

* TOC
{:toc}

[&laquo; 返回首页](index.html)

## TaifunTM拓展  {#TaifunTM}
<!--(https://puravidaapps.com/telephonymanager.php)-->

该拓展用于从电话管理器获取一些信息。

  最低 API 级别为 18！
  
  所需权限：`android.permission.READ_PHONE_STATE` 或 `android.permission.READ_PHONE_NUMBERS`。请参阅下面的示例项目，了解如何请求所需的权限。


### 方法

常用方法如下：

***
![ApiLevel](TaifunTM/ApiLevel.png)

返回设备的 API 级别。

***
![DeviceId](TaifunTM/DeviceId.png)

返回设备的 IMEI/MEID。（如果设备是GSM设备，则将返回IMEI，如果设备是CDMA设备，则将返回MEID。如果平板电脑或设备不能充当手机，IMEI将为空）

***
![PhoneNumber](TaifunTM/PhoneNumber.png)

返回设备电话号码。

{:.vip}
其他方法请参考[英文文档](https://puravidaapps.com/telephonymanager.php)。

## 使用示例

参考代码如下：

![参考代码](TaifunTM/参考代码.png)


## 源码下载

.aix 拓展下载：

{:.vip}
[com.puravidaapps.TaifunTM.aix](TaifunTM/com.puravidaapps.TaifunTM.aix)

demo 下载：

{:.vip}
[tm.aia](TaifunTM/tm.aia)
