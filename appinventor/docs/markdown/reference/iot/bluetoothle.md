---
title: App Inventor 2 低功耗蓝牙 BlueToothLE 拓展
layout: documentation
description: App Inventor 2 低功耗蓝牙 BlueToothLE 拓展中文文档，函数的中文介绍及使用方法。2种通信方式：扫描和广播的详细接入方式。
---

* TOC
{:toc}

[&laquo; 返回首页](index.html)

最新版拓展下载：

{:.vip}
[edu.mit.appinventor.ble-20230728.aix](assets/edu.mit.appinventor.ble-20230728.aix)

低功耗蓝牙，也称为蓝牙LE 或简称 BLE，是一种类似于经典蓝牙的新通信协议，不同之处在于它旨在消耗更少的功耗和成本，同时保持同等的功能。

因此，低功耗蓝牙是与耗电资源有限的物联网设备进行通信的首选。BluetoothLE 扩展需要 Android 5.0 或更高版本。

## 2种通信方式：扫描和广播

### 扫描

![ble](./assets/ble_connection.jpg)

**详细接入步骤：**

{:.vip}
[开始扫描](#StartScanning) -> [获取BLE设备列表](#DeviceList) -> [连接指定设备](#Connect)（也可[指定MAC地址连接](#ConnectWithAddress)）-> 设备指定服务uuid和特征uuid [发送](#WriteBytes) / [接收](#ReadBytes) 数据。

### 广播

![ble](./assets/ble_broadcast.jpg)

现在常规便宜芯片并无蓝牙协议栈，只能通过人工拼包用最简单的蓝牙广播方式通信，可以做到手机与设备进行简单的交互。

* 无连接的
* 是单向的，可以向任何人或者接收器发送数据。
* 使用广播方式通信没有任何安全措施，任何监听设备都能收到，因此它可能不适合于敏感数据，除非在广播数据中采用某种加密方法。
<!--https://zhuanlan.zhihu.com/p/669108821-->

**详细接入步骤：**

{:.vip}
[设置广播扫描周期](#AdvertisementScanPeriod) -> [广播扫描](#ScanAdvertisements) -> [获取广播设备列表](#AdvertiserAddresses) -> [获取设备服务uuids列表](#AdvertiserServiceUuids) -> 设备指定服务uuid [发送](#StartAdvertising) / [接收](#AdvertisementData) 广播数据。

更深入的通信原理请参考：[《BLE协议—广播和扫描》](https://bbs.tsingfun.com/thread-1692-1-1.html)。

## 属性

+ <a name="AdvertisementScanPeriod"></a>`AdvertisementScanPeriod` – 广播扫描周期：返回广播扫描周期的值（毫秒ms）。

  ![get BluetoothLE1 AdvertisementScanPeriod ](assets/BluetoothLE.AdvertisementScanPeriod_getter.svg)

+ <a name="AdvertiserAddresses"></a>`AdvertiserAddresses` – 广播者设备地址列表：返回在广播扫描期间找到的设备地址列表。

  ![get BluetoothLE1 AdvertiserAddresses ](assets/BluetoothLE.AdvertiserAddresses_getter.svg)

+ <a name="AdvertiserNames"></a>`AdvertiserNames` – 广播者设备名称列表：返回广播扫描期间找到的设备名称列表。

  ![get BluetoothLE1 AdvertiserNames ](assets/BluetoothLE.AdvertiserNames_getter.svg)

+ <a name="AutoReconnect"></a>`AutoReconnect` – 如果为 `真`，App将尝试重连已断开的设备（比如：距离过大导致的连接断开等）。注意：这不适用于通过调用 <a href='#Disconnect'><code>Disconnect</code></a> 方法断开的连接，这类断开连接需要通过调用 <a href='#Connect'><code>Connect</code></a> 或 <a href='#ConnectWithAddress'><code>ConnectWithAddress</code></a> 进行重新连接。

  ![get BluetoothLE1 AutoReconnect ](assets/BluetoothLE.AutoReconnect_getter.svg)

  ![set BluetoothLE1 AutoReconnect  to](assets/BluetoothLE.AutoReconnect_setter.svg)

+ <a name="BatteryValue"></a>`BatteryValue` – 返回电池电量。

  ![get BluetoothLE1 BatteryValue ](assets/BluetoothLE.BatteryValue_getter.svg)

+ <a name="ConnectedDeviceName"></a>`ConnectedDeviceName` – 已连接设备的广播名称。如果没有连接任何设备或不支持低功耗蓝牙，则返回空字符串。

  ![get BluetoothLE1 ConnectedDeviceName ](assets/BluetoothLE.ConnectedDeviceName_getter.svg)

+ <a name="ConnectedDeviceRssi"></a>`ConnectedDeviceRssi` – 返回连接设备的 RSSI（Received Signal Strength Indicator：接收信号强度指示）。

  ![get BluetoothLE1 ConnectedDeviceRssi ](assets/BluetoothLE.ConnectedDeviceRssi_getter.svg)

+ <a name="ConnectionTimeout"></a>`ConnectionTimeout` – 建立连接的超时时间（单位：秒）：调用 <a href='#Connect'><code>Connect</code></a> 或 <a href='#ConnectWithAddress'><code>ConnectWithAddress</code></a> 后，BluetoothLE 组件等待与设备建立连接的时间（以秒为单位），如果在给定的时间内未建立连接，则将中止尝试并触发 <a href='#ConnectionFailed'><code>ConnectionFailed</code></a> 事件。

  ![get BluetoothLE1 ConnectionTimeout ](assets/BluetoothLE.ConnectionTimeout_getter.svg)

  ![set BluetoothLE1 ConnectionTimeout  to](assets/BluetoothLE.ConnectionTimeout_setter.svg)

+ <a name="DeviceCharacteristics"></a>`DeviceCharacteristics` – 已连接设备所广播的每个特征对应的三元组列表，包含服务UUID、特征UUID 和特征名称（如果有）。列表格式为 ((服务 1 特征 1 名称 1) (服务 2 特征 2 名称 2) ...)。如果未连接任何设备或不支持低功耗蓝牙，则将返回空列表。

  ![get BluetoothLE1 DeviceCharacteristics ](assets/BluetoothLE.DeviceCharacteristics_getter.svg)

+ <a name="DeviceList"></a>`DeviceList` – 以字符串形式返回BLE设备的有序列表。

  ![get BluetoothLE1 DeviceList ](assets/BluetoothLE.DeviceList_getter.svg)

+ <a name="DeviceServices"></a>`DeviceServices` – 键值对列表，每个广播服务对应一个键值对：服务UUID 及 服务名称（如果有）。列表的格式为 ((uuid1 name1) (uuid2 name2) ...)。如果没有连接任何设备或不支持低功耗蓝牙，则将返回一个空列表。

  ![get BluetoothLE1 DeviceServices ](assets/BluetoothLE.DeviceServices_getter.svg)

+ <a name="IsDeviceAdvertising"></a>`IsDeviceAdvertising` – 如果设备当前正在广播，则返回 `真`，否则返回 `假`。

  ![get BluetoothLE1 IsDeviceAdvertising ](assets/BluetoothLE.IsDeviceAdvertising_getter.svg)

+ <a name="IsDeviceConnected"></a>`IsDeviceConnected` – 如果BLE设备已连接，则返回 `真`，否则返回 `假`。

  ![get BluetoothLE1 IsDeviceConnected ](assets/BluetoothLE.IsDeviceConnected_getter.svg)

+ <a name="NoLocationNeeded"></a>`NoLocationNeeded` – 启用此选项用以申明你的App**不使用蓝牙来获取位置信息**。如果启用，编译后的App将不需要请求 `ACCESS_FINE_LOCATION` 权限，扩展程序也不会尝试请求这个权限。

  ![BluetoothLE1 NoLocationNeeded ](assets/BluetoothLE.NoLocationNeeded.png)  （此属性仅“界面设计”视图可用）

+ <a name="NullTerminateStrings"></a>`NullTerminateStrings` – 指示 BluetoothLE 组件在向连接的设备发送字符串数据时，是否以`\0`空字节（`真`）或不以`\0`空字节（`假`）结束字符串。

  ![get BluetoothLE1 NullTerminateStrings ](assets/BluetoothLE.NullTerminateStrings_getter.svg)

  ![set BluetoothLE1 NullTerminateStrings  to](assets/BluetoothLE.NullTerminateStrings_setter.svg)

+ <a name="Scanning"></a>`Scanning` – BLE组件的扫描状态。

  ![get BluetoothLE1 Scanning ](assets/BluetoothLE.Scanning_getter.svg)

+ <a name="TxPower"></a>`TxPower` – 返回传输功率。

  ![get BluetoothLE1 TxPower ](assets/BluetoothLE.TxPower_getter.svg)

## 方法

+ <a name="AdvertisementData"></a>`AdvertisementData` – 返回指定地址设备相关的广播数据。

  ![call BluetoothLE1 AdvertisementDatadeviceAddressserviceUuid](assets/BluetoothLE.AdvertisementData.svg)

  __参数__:

  * <code>deviceAddress</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       目标BLE设备的MAC（Media Access Control）地址。

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       广播服务UUID（唯一标识符）。

+ <a name="AdvertiserAddress"></a>`AdvertiserAddress` – 返回指定名称的设备MAC地址。
  
  ![call BluetoothLE1 AdvertiserAddressdeviceName](assets/BluetoothLE.AdvertiserAddress.svg)
  
  __参数__:

  * <code>deviceName</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       目标BLE设备的广播名称。

+ <a name="AdvertiserServiceUuids"></a>`AdvertiserServiceUuids` – 返回广播设备上可用的服务列表。

  ![call BluetoothLE1 AdvertiserServiceUuidsdeviceAddress](assets/BluetoothLE.AdvertiserServiceUuids.svg)

  __参数__:

  * <code>deviceAddress</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       目标BLE设备的MAC地址。

+ <a name="CanReadCharacteristic"></a>`CanReadCharacteristic` – 测试指定的特征是否可以读取。

  ![call BluetoothLE1 CanReadCharacteristicserviceUuidcharacteristicUuid](assets/BluetoothLE.CanReadCharacteristic.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       用于测试读取能力的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       用于测试读取能力的特征UUID。

+ <a name="CanRegisterForCharacteristic"></a>`CanRegisterForCharacteristic` – 测试指定的特征是否可用于注册通知。

  ![call BluetoothLE1 CanRegisterForCharacteristicserviceUuidcharacteristicUuid](assets/BluetoothLE.CanRegisterForCharacteristic.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       用于测试通知功能的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       用于测试通知功能的特征UUID。

+ <a name="CanWriteCharacteristic"></a>`CanWriteCharacteristic` – 测试指定的特征是否可以写入。

  ![call BluetoothLE1 CanWriteCharacteristicserviceUuidcharacteristicUuid](assets/BluetoothLE.CanWriteCharacteristic.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       用于测试写入能力的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       用于测试写入能力的特征UUID。

+ <a name="CanWriteCharacteristicWithResponse"></a>`CanWriteCharacteristicWithResponse` – 测试指定的特征是否可以通过设备确认进行写入。

  ![call BluetoothLE1 CanWriteCharacteristicWithResponseserviceUuidcharacteristicUuid](assets/BluetoothLE.CanWriteCharacteristicWithResponse.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       用于测试具有响应功能的写入服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       用于测试具有响应能力的写入特征UUID。

+ <a name="CharacteristicByIndex"></a>`CharacteristicByIndex` – 从已连接设备支持的特征列表中返回指定索引的特征UUID，索引从 1 开始。

  ![call BluetoothLE1 CharacteristicByIndexindex](assets/BluetoothLE.CharacteristicByIndex.svg)

  __参数__:

  * <code>index</code> (<a href="https://www.fun123.cn/reference/blocks/math.html#number" target="_blank">_number_</a>) &mdash;
       特征的索引，必须介于 1 和特征列表的长度之间。

+ <a name="Connect"></a>`Connect` – 使用 <code>Connect</code> 方法连接到设备列表中指定索引处的BLE设备。

  ![call BluetoothLE1 Connectindex](assets/BluetoothLE.Connect.svg)

  __参数__:

  * <code>index</code> (<a href="https://www.fun123.cn/reference/blocks/math.html#number" target="_blank">_number_</a>) &mdash;
       目标设备的索引，必须介于 1 和列表长度之间。

+ <a name="ConnectToDeviceType"></a>`ConnectToDeviceType` – 连接到使用 <code>name</code> 和 <code>device</code> 指定的已发现的正在广播的第一个设备。

  ![call BluetoothLE1 ConnectToDeviceTypedevicename](assets/BluetoothLE.ConnectToDeviceType.svg)

  __参数__:

   * <code>device</code> (<a href="">_component_</a>) &mdash;
     BLE设备的组件块（组件对象）。
   * <code>name</code> (<a href="">_name_</a>) &mdash;
     设备广播名称。

+ <a name="ConnectToDeviceWithServiceAndName"></a>`ConnectToDeviceWithServiceAndName` – 连接到使用 <code>name</code> 和 <code>serviceUuid</code> 指定的已发现的正在广播的第一个设备。

  ![call BluetoothLE1 ConnectToDeviceWithServiceAndNameserviceUuidname](assets/BluetoothLE.ConnectToDeviceWithServiceAndName.svg)

  __参数__:

   * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
     正在广播设备的服务UUID。
   * <code>name</code> (<a href="">_name_</a>) &mdash;
     设备广播名称。

+ <a name="ConnectWithAddress"></a>`ConnectWithAddress` – 如果已知BLE设备的MAC地址（如：已存储并从微数据库中读取），则使用 <code>ConnectWithAddress</code> 方法连接到该设备。如果设备列表中没有任何设备与给定MAC地址匹配，则将触发 <a href="#ConnectionFailed"><code>ConnectionFailed</code></a> 事件。否则，如果连接成功，则将触发 <a href="#Connected"><code>Connected</code></a> 事件。

  ![call BluetoothLE1 ConnectWithAddressaddress](assets/BluetoothLE.ConnectWithAddress.svg)

  __参数__:

  * <code>address</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       目标设备的 MAC 地址，格式为`12:34:56:78:90:ab`

+ <a name="Disconnect"></a>`Disconnect` – 如果BLE设备已连接，则断开当前的设备连接。

  ![call BluetoothLE1 Disconnect](assets/BluetoothLE.Disconnect.svg)

+ <a name="DisconnectWithAddress"></a>`DisconnectWithAddress` – 断开指定MAC地址的已连接的BLE设备。

  ![call BluetoothLE1 DisconnectWithAddressaddress](assets/BluetoothLE.DisconnectWithAddress.svg)

  __参数__:

  * <code>address</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       要断开连接的设备MAC地址，格式为`12:34:56:78:90:ab`

+ <a name="FoundDeviceAddress"></a>`FoundDeviceAddress` – 获取设备列表中指定索引处设备的MAC地址。索引为BLE设备列表中的位置，从 1 开始。

  ![call BluetoothLE1 FoundDeviceAddressindex](assets/BluetoothLE.FoundDeviceAddress.svg)

  __参数__:

  * <code>index</code> (<a href="https://www.fun123.cn/reference/blocks/math.html#number" target="_blank">_number_</a>) &mdash;
       已发现设备索引，必须介于 1 和设备列表的长度之间。

+ <a name="FoundDeviceName"></a>`FoundDeviceName` – 获取设备列表中指定索引处设备的名称。

  ![call BluetoothLE1 FoundDeviceNameindex](assets/BluetoothLE.FoundDeviceName.svg)

  __参数__:

  * <code>index</code> (<a href="https://www.fun123.cn/reference/blocks/math.html#number" target="_blank">_number_</a>) &mdash;
       已发现设备索引，必须介于 1 和设备列表的长度之间。

+ <a name="FoundDeviceRssi"></a>`FoundDeviceRssi` –获取设备列表中指定索引处设备的接收信号强度指示 (RSSI)。返回值将介于 -100 和 0 之间，表示连接强度。

  ![call BluetoothLE1 FoundDeviceRssiindex](assets/BluetoothLE.FoundDeviceRssi.svg)

  __参数__:

  * <code>index</code> (<a href="https://www.fun123.cn/reference/blocks/math.html#number" target="_blank">_number_</a>) &mdash;
       已发现设备索引，必须介于 1 和设备列表的长度之间。

+ <a name="GetCharacteristicsForService"></a>`GetCharacteristicsForService` – 返回指定服务所支持的特征列表。该列表包含服务UUID 提供的每个特征的 (UUID, 名称) 键值对。

  ![call BluetoothLE1 GetCharacteristicsForServiceserviceUuid](assets/BluetoothLE.GetCharacteristicsForService.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。

+ <a name="ReadBytes"></a>`ReadBytes` – 从连接的BLE设备中读取一个或多个 8-bit （1 字节）整型值。服务UUID和特征UUID是必需的。<code>signed</code> 参数指示在转换为 App Inventor数字 时是否应将字节解释为有符号值。读取字节后，将触发 <a href="#BytesReceived"><code>BytesReceived</code></a> 事件。

  ![call BluetoothLE1 ReadBytesserviceUuidcharacteristicUuidsigned](assets/BluetoothLE.ReadBytes.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       读取或注册调用中特征UUID。
  * <code>signed</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       将字节解释为有符号（`真`）或无符号（`假`）。

+ <a name="ReadConnectedRssi"></a>`ReadConnectedRssi` – 启动对已连接设备的接收信号强度指示 (RSSI) 的读取。结果值将通过 <a href="#RssiChanged"><code>RssiChanged</code></a> 事件中参数给出。

  ![call BluetoothLE1 ReadConnectedRssi](assets/BluetoothLE.ReadConnectedRssi.svg)

+ <a name="ReadFloats"></a>`ReadFloats` – 从连接的BLE设备读取一个或多个 IEEE 754 浮点数。服务UUID和特征UUID是必需的。<code>shortFloat</code> 参数指示浮点数是 16 位半精度浮点数还是 32 位单精度浮点数。读取浮点数后，将触发 <a href="#FloatsReceived"><code>FloatsReceived</code></a> 事件。

  ![call BluetoothLE1 ReadFloatsserviceUuidcharacteristicUuidshortFloat](assets/BluetoothLE.ReadFloats.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       读取或注册调用中特征UUID。
  * <code>shortFloat</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       将浮点数解释为 16 位半精度（`真`）或 32 位单精度（`假`）。

+ <a name="ReadIntegers"></a>`ReadIntegers` – 从连接的BLE设备读取一个或多个 32-bit （4 字节）整型值。服务UUID和特征UUID是必需的。<code>signed</code> 参数指示在转换为 App Inventor数字 时是否应将整数解释为有符号值。读取整数后，将触发 <a href="#IntegersReceived"><code>IntegersReceived</code></a> 事件。

  ![call BluetoothLE1 ReadIntegersserviceUuidcharacteristicUuidsigned](assets/BluetoothLE.ReadIntegers.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       读取或注册调用中特征UUID。
  * <code>signed</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       将整型值解释为有符号（`真`）或无符号（`假`）。

+ <a name="ReadShorts"></a>`ReadShorts` – 从连接的BLE设备读取一个或多个 16-bit （2 字节）短整型值。服务UUID和特征UUID是必需的。<code>signed</code> 参数指示在转换为 App Inventor数字 时是否应将 short短整型值 解释为有符号值。读取 short短整型值 后，将触发 <a href="#ShortsReceived"><code>ShortsReceived</code></a>
事件。

  ![call BluetoothLE1 ReadShortsserviceUuidcharacteristicUuidsigned](assets/BluetoothLE.ReadShorts.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       读取或注册调用中特征UUID。
  * <code>signed</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       将短整型值解释为有符号（`真`）或无符号（`假`）。

+ <a name="ReadStrings"></a>`ReadStrings` – 从连接的BLE设备读取一个或多个 以`\0`空字节结尾的字符串。服务UUID和特征UUID是必需的。<code>utf16</code> 参数指示在转换为 App Inventor字符串 时是否应将内容解码为 UTF-16（`真`）或 UTF-8（`假`）编码格式。读取字符串后，将触发 <a href="#StringsReceived"><code>StringsReceived</code></a> 事件。

  ![call BluetoothLE1 ReadStringsserviceUuidcharacteristicUuidutf16](assets/BluetoothLE.ReadStrings.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       读取或注册调用中特征UUID。
  * <code>utf16</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       将字符串内容解释为 UTF-16（`真`）或 UTF-8（`假`）编码格式。

+ <a name="RegisterForBytes"></a>`RegisterForBytes` – 注册用以在已连接BLE设备的一个或多个 8-bit（单字节）整型值发生变化时接收更新。服务UID 和特性UUID 是必需的。<code>signed</code> 参数指示在转换为 App Inventor数字 时是否应将字节解释为有符号值。每当收到更改时，将触发 <a href="#BytesReceived"><code>BytesReceived</code></a> 事件。

  ![call BluetoothLE1 RegisterForBytesserviceUuidcharacteristicUuidsigned](assets/BluetoothLE.RegisterForBytes.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       读取或注册调用中特征UUID。
  * <code>signed</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       将字节解释为有符号（`真`）或无符号（`假`）。

+ <a name="RegisterForFloats"></a>`RegisterForFloats` – 注册用以在已连接BLE设备的一个或多个 IEEE 754 浮点数发生变化时接收更新。服务UID 和特性UUID 是必需的。<code>shortFloat</code> 参数指示浮点数是 16 位半精度浮点数还是 32 位单精度浮点数。每当收到更改时，就会触发 <a href="#FloatsReceived"><code>FloatsReceived</code></a> 事件。

  ![call BluetoothLE1 RegisterForFloatsserviceUuidcharacteristicUuidshortFloat](assets/BluetoothLE.RegisterForFloats.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       读取或注册调用中特征UUID。
  * <code>shortFloat</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       将浮点数解释为 16 位半精度（`真`）或 32 位单精度（`假`）。

+ <a name="RegisterForIntegers"></a>`RegisterForIntegers` – 注册用以在已连接BLE设备的一个或多个 32-bit （4 字节）整型值发生变化时接收更新。服务UID 和特性UUID 是必需的。<code>signed</code> 参数指示在将整数转换为 App Inventor数字 时是否应将其解释为有符号值。每当收到更改时，都会触发 <a href="#IntegersReceived"><code>IntegersReceived</code></a> 事件。

  ![call BluetoothLE1 RegisterForIntegersserviceUuidcharacteristicUuidsigned](assets/BluetoothLE.RegisterForIntegers.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       读取或注册调用中特征UUID。
  * <code>signed</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       将整型值解释为有符号（`真`）或无符号（`假`）。

+ <a name="RegisterForShorts"></a>`RegisterForShorts` – 注册用以在已连接BLE设备的一个或多个 16-bit （2 字节）短整型值发生变化时接收更新。服务UID 和特性UUID 是必需的。<code>signed</code> 参数指示在转换为 App Inventor数字 时是否应将 short短整型值 解释为有符号值。每当收到更改时，就会触发 <a href="#ShortsReceived"><code>ShortsReceived</code></a> 事件。

  ![call BluetoothLE1 RegisterForShortsserviceUuidcharacteristicUuidsigned](assets/BluetoothLE.RegisterForShorts.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       读取或注册调用中特征UUID。
  * <code>signed</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       将短整型值解释为有符号（`真`）或无符号（`假`）。

+ <a name="RegisterForStrings"></a>`RegisterForStrings` – 注册用以在已连接BLE设备的一个或多个 以`\0`空字节结尾的字符串 发生更改时接收更新。服务UID 和特性UUID 是必需的。<code>utf16</code> 参数指示在转换为 App Inventor字符串 时是否应将内容解码为 UTF-16（`真`）或 UTF-8（`假`）编码格式。每当收到更改时，都会触发 <a href="#StringsReceived"><code>StringsReceived</code></a> 事件。

  ![call BluetoothLE1 RegisterForStringsserviceUuidcharacteristicUuidutf16](assets/BluetoothLE.RegisterForStrings.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       读取或注册调用中特征UUID。
  * <code>utf16</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       将字符串内容解释为 UTF-16（`真`）或 UTF-8（`假`）编码格式。

{:.vip}
+ <a name="RequestMTU"></a>`RequestMTU` – 为 BluetoothLE 连接请求新的最大传输单元 (MTU)。此功能仅在两个设备都支持蓝牙 4.2 或更高版本时才受支持。如果 MTU 更改成功，则 [MTUChanged](#MTUChanged) 事件将被触发。默认 MTU 为 20。

  ![call BluetoothLE1 RequestMTUbytes](assets/BluetoothLE.RequestMTU.svg)

  此块适用于需要更改 BLE 设备之间发送的消息大小的高级应用。大多数开发人员不需要调整此值。

    * MTU: 最大传输单元（MAXIMUM TRANSMISSION UNIT） ， 指在一个PDU （Protocol Data Unit： 协议数据单元，在一个传输单元中的有效传输数据）能够传输的最大数据量（多少字节可以一次性传输到对方）。
    * MTU 交换是为了在主从双方设置一个PDU中最大能够交换的数据量，通过MTU的交换和双方确认（注意这个MTU是不可以协商的，只是通知对方，双方在知道对方的极限后会选择一个较小的值作为以后的MTU，比如说，主设备发出一个150个字节的MTU请求，但是从设备回应MTU是23字节，那么今后双方要以较小的值23字节作为以后的MTU），主从双方约定每次在做数据传输时不超过这个最大数据单元。
    * 更多MTU技术内幕请参考[《一分钟读懂低功耗蓝牙(BLE) MTU交换数据包》](https://bbs.tsingfun.com/thread-1837-1-1.html)。

  __参数__:

  * <code>bytes</code> (<a href="https://www.fun123.cn/reference/blocks/math.html#number" target="_blank">_number_</a>) &mdash;
     期望的 MTU 大小（单位：字节）。

+ <a name="ScanAdvertisements"></a>`ScanAdvertisements` – 扫描广播BLE设备。

  ![call BluetoothLE1 ScanAdvertisementsscanPeriod](assets/BluetoothLE.ScanAdvertisements.svg)

  __参数__:

  * <code>scanPeriod</code> (<a href="https://www.fun123.cn/reference/blocks/math.html#number" target="_blank">_number_</a>) &mdash;
       扫描所需的时间（单位：毫秒 ms）。

+ <a name="ScanForDevice"></a>`ScanForDevice` – 扫描特定类型的设备。设备组件必须实现 BLEDevice 接口才能使此方法正常工作。

  ![call BluetoothLE1 ScanForDevicedevice](assets/BluetoothLE.ScanForDevice.svg)

  __参数__:

  * <code>param</code> (<a href="">_component_</a>) &mdash;
     需要特定服务的组件块。

+ <a name="ScanForService"></a>`ScanForService` – 通过服务UUID扫描 广播特定BLE服务 的设备。

  ![call BluetoothLE1 ScanForServiceserviceUuid](assets/BluetoothLE.ScanForService.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
     目标BLE设备的广播服务UUID。

+ <a name="ServiceByIndex"></a>`ServiceByIndex` – 返回服务列表中给定索引处的服务UUID。

  ![call BluetoothLE1 ServiceByIndexindex](assets/BluetoothLE.ServiceByIndex.svg)

  __参数__:

  * <code>index</code> (<a href="https://www.fun123.cn/reference/blocks/math.html#number" target="_blank">_number_</a>) &mdash;
       所需服务的索引，必须介于 1 和服务列表的长度之间。

+ <a name="StartAdvertising"></a>`StartAdvertising` – 创建并发布蓝牙低功耗广播。

  ![call BluetoothLE1 StartAdvertisinginDataserviceUuid](assets/BluetoothLE.StartAdvertising.svg)

  __参数__:

  * <code>inData</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       要包含在服务广播中的数据。
  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。

+ <a name="StopAdvertising"></a>`StopAdvertising` – 停止蓝牙低功耗广播（之前调用 <a href="#StartAdvertising"><code>StartAdvertising</code></a> 的广播）。

  ![call BluetoothLE1 StopAdvertising](assets/BluetoothLE.StopAdvertising.svg)

+ <a name="StartScanning"></a>`StartScanning` – 开始扫描蓝牙低功耗设备。

  ![call BluetoothLE1 StartScanning](assets/BluetoothLE.StartScanning.svg)

+ <a name="StopScanning"></a>`StopScanning` – 停止扫描蓝牙低功耗设备。

  ![call BluetoothLE1 StopScanning](assets/BluetoothLE.StopScanning.svg)

+ <a name="StopScanningAdvertisements"></a>`StopScanningAdvertisements` – 停止扫描蓝牙低功耗广播。

  ![call BluetoothLE1 StopScanningAdvertisements](assets/BluetoothLE.StopScanningAdvertisements.svg)

+ <a name="SupportedCharacteristics"></a>`SupportedCharacteristics` – 以字符串形式返回所连接设备支持的特征列表。

  ![call BluetoothLE1 SupportedCharacteristics](assets/BluetoothLE.SupportedCharacteristics.svg)

+ <a name="SupportedServices"></a>`SupportedServices` – 以字符串形式返回所连接设备支持的服务列表。

  ![call BluetoothLE1 SupportedServices](assets/BluetoothLE.SupportedServices.svg)

+ <a name="UnregisterForValues"></a>`UnregisterForValues` – 取消注册指定的服务和特征的更新。

  ![call BluetoothLE1 UnregisterForValuesservice_uuidcharacteristic_uuid](assets/BluetoothLE.UnregisterForValues.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       读取或注册调用中特征UUID。

+ <a name="WriteBytes"></a>`WriteBytes` – 将一个或多个 8-bit 整数值写入已连接的BLE设备。服务UID 和特性UUID 是必需的。参数可以是 单个数值 或 数值列表。如果 <code>signed</code> 为`真`，则可接受的值介于 -128 和 127 之间。如果 <code>signed</code> 为`假`，则可接受的值介于 0 和 255 之间。

  ![call BluetoothLE1 WriteBytesserviceUuidcharacteristicUuidsignedvalues](assets/BluetoothLE.WriteBytes.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       读取或注册调用中特征UUID。
  * <code>signed</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       将字节解释为有符号（`真`）或无符号（`假`）。
  * <code>values</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist" target="_blank">_list_</a>) &mdash;
       要写入设备的值列表。

+ <a name="WriteBytesWithResponse"></a>`WriteBytesWithResponse` – 将一个或多个 8-bit 整数值写入已连接的BLE设备，并等待通过 <a href="#BytesWritten"><code>BytesWritten</code></a> 事件确认。服务UID 和特性UUID 是必需的。参数可以是 单个数值 或 数值列表。如果 <code>signed</code> 为`真`，则可接受的值介于 -128 和 127 之间。如果 <code>signed</code> 为`假`，则可接受的值介于 0 和 255 之间。

  ![call BluetoothLE1 WriteBytesWithResponseserviceUuidcharacteristicUuidsignedvalues](assets/BluetoothLE.WriteBytesWithResponse.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       读取或注册调用中特征UUID。
  * <code>signed</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       将字节解释为有符号（`真`）或无符号（`假`）。
  * <code>values</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist" target="_blank">_list_</a>) &mdash;
       要写入设备的值列表。

+ <a name="WriteFloats"></a>`WriteFloats` – 将一个或多个 IEEE 754 浮点数写入已连接的BLE设备。服务UID 和特性UUID 是必需的。参数可以是 单个浮点值 或 浮点值列表。如果 <code>shortFloat</code> 为`真`，则每个数值将被压缩以适合 16 位半精度浮点值。如果 <code>shortFloat</code> 为`假`，则每个数值将作为 32 位单精度浮点值发送。

  ![call BluetoothLE1 WriteFloatsserviceUuidcharacteristicUuidshortFloatvalues](assets/BluetoothLE.WriteFloats.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       读取或注册调用中特征UUID。
  * <code>shortFloat</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       将浮点数解释为 16 位半精度（`真`）或 32 位单精度（`假`）。
  * <code>values</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist" target="_blank">_list_</a>) &mdash;
       要写入设备的值列表。

+ <a name="WriteFloatsWithResponse"></a>`WriteFloatsWithResponse` – 将一个或多个 IEEE 754 浮点值写入已连接的BLE设备，并等待通过 <a href="#FloatsWritten"><code>FloatsWritten</code></a> 事件确认。服务UID 和特性UUID 是必需的。参数可以是 单个浮点值 或 浮点值列表。如果 <code>shortFloat</code> 为`假`，则每个数值将作为 32 位单精度浮点值发送。

  ![call BluetoothLE1 WriteFloatsWithResponseserviceUuidcharacteristicUuidshortFloatvalues](assets/BluetoothLE.WriteFloatsWithResponse.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       读取或注册调用中特征UUID。
  * <code>shortFloat</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       将浮点数解释为 16 位半精度（`真`）或 32 位单精度（`假`）。
  * <code>values</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist" target="_blank">_list_</a>) &mdash;
       要写入设备的值列表。

+ <a name="WriteIntegers"></a>`WriteIntegers` – 将一个或多个 32 位整型值写入已连接的BLE设备。服务UID 和特性UUID 是必需的。参数可以是 单个数值 或 数值列表。如果 <code>signed</code> 为`真`，则可接受的值介于 -2147483648 和 2147483647 之间。如果 <code>signed</code> 为`假`，则可接受的值介于 0 和 4294967295 之间。

  ![call BluetoothLE1 WriteIntegersserviceUuidcharacteristicUuidsignedvalues](assets/BluetoothLE.WriteIntegers.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       读取或注册调用中特征UUID。
  * <code>signed</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       将整型值解释为有符号（`真`）或无符号（`假`）。
  * <code>values</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist" target="_blank">_list_</a>) &mdash;
       要写入设备的值列表。

+ <a name="WriteIntegersWithResponse"></a>`WriteIntegersWithResponse` – 将一个或多个 32 位整型值写入连接的BLE设备，并等待通过 <a href="#IntegersWritten"><code>IntegersWritten</code></a> 事件确认。服务UID 和特性UUID 是必需的。参数可以是 单个数值 或 数值列表。如果 <code>signed</code> 为`真`，则可接受的值介于 -2147483648 和 2147483647 之间。如果 <code>signed</code> 为`假`，则可接受的值介于 0 和 4294967295 之间。

  ![call BluetoothLE1 WriteIntegersWithResponseserviceUuidcharacteristicUuidsignedvalues](assets/BluetoothLE.WriteIntegersWithResponse.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       读取或注册调用中特征UUID。
  * <code>signed</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       将整型值解释为有符号（`真`）或无符号（`假`）。
  * <code>values</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist" target="_blank">_list_</a>) &mdash;
       要写入设备的值列表。

+ <a name="WriteShorts"></a>`WriteShorts` – 将一个或多个 16 位短整型值写入已连接的BLE设备。服务UID 和特性UUID 是必需的。参数可以是 单个数值 或 数值列表。如果 <code>signed</code> 为`真`，则可接受的值介于 -32768 和 32767 之间。如果 <code>signed</code> 为`假`，则可接受的值介于 0 和 65535 之间。
  
  ![call BluetoothLE1 WriteShortsserviceUuidcharacteristicUuidsignedvalues](assets/BluetoothLE.WriteShorts.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       读取或注册调用中特征UUID。
  * <code>signed</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       将短整型值解释为有符号（`真`）或无符号（`假`）。
  * <code>values</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist" target="_blank">_list_</a>) &mdash;
       要写入设备的值列表。

+ <a name="WriteShortsWithResponse"></a>`WriteShortsWithResponse` – 将一个或多个 16 位短整型值写入连接的BLE设备，并等待通过 <a href="#ShortsWritten"><code>ShortsWritten</code></a> 事件确认。服务UID 和特性UUID 是必需的。参数可以是 单个数值 或 数值列表。如果 <code>signed</code> 为`真`，则可接受的值介于 -32768 和 32767 之间。如果 <code>signed</code> 为`假`，则可接受的值介于 0 和 65535 之间。

  ![call BluetoothLE1 WriteShortsWithResponseserviceUuidcharacteristicUuidsignedvalues](assets/BluetoothLE.WriteShortsWithResponse.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       读取或注册调用中特征UUID。
  * <code>signed</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       将短整型值解释为有符号（`真`）或无符号（`假`）。
  * <code>values</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist" target="_blank">_list_</a>) &mdash;
       要写入设备的值列表。

+ <a name="WriteStrings"></a>`WriteStrings` – 将一个或多个字符串写入已连接的BLE设备。服务UID 和特性UUID 是必需的。参数可以是 单个字符串 或 字符串列表。如果 <code>utf16</code> 为`真`，则将使用 UTF-16 小端序（little endian）编码发送字符串。如果 <code>utf16</code> 为`假`，则将使用 UTF-8 编码发送字符串。

  ![call BluetoothLE1 WriteStringsserviceUuidcharacteristicUuidutf16values](assets/BluetoothLE.WriteStrings.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       读取或注册调用中特征UUID。
  * <code>utf16</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       发送以 UTF-16 小端序 (`真`) 或 UTF-8 (`假`) 编码的字符串。
  * <code>values</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist" target="_blank">_list_</a>) &mdash;
       要写入设备的值列表。

+ <a name="WriteStringsWithResponse"></a>`WriteStringsWithResponse` – 将一个或多个字符串写入已连接的BLE设备，并等待通过 <a href="#StringsWritten"><code>StringsWritten</code></a> 事件确认。服务UID 和特性UUID 是必需的。参数可以是 单个字符串 或 字符串列表。如果 <code>utf16</code> 为`真`，则将使用 UTF-16 小端序（little endian）编码发送字符串。如果 <code>utf16</code> 为`假`，则将使用 UTF-8 编码发送字符串。

  ![call BluetoothLE1 WriteStringsWithResponseserviceUuidcharacteristicUuidutf16values](assets/BluetoothLE.WriteStringsWithResponse.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       读取或注册调用中特征UUID。
  * <code>utf16</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       发送以 UTF-16 小端序 (`真`) 或 UTF-8 (`假`) 编码的字符串。
  * <code>values</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist" target="_blank">_list_</a>) &mdash;
       要写入设备的值列表。

## 事件

+ <a name="BytesReceived"></a>`BytesReceived` – 当从连接的蓝牙BLE设备接收到一个或多个字节值时，将触发该事件。根据上次调用 <a href="#ReadBytes"><code>ReadBytes</code></a> 或 <a href="#RegisterForBytes"><code>RegisterForBytes</code></a> 时给定的 <code>serviceUuid</code> 和 <code>characteristicUuid</code> 的 <code>sign</code> 参数，<code>byteValues</code> 列表将包含从 -128 到 127 (<code>signed = true</code>) 或 0 到 255 (<code>signed = false</code>) 的数字。

  ![when BluetoothLE1 BytesReceived serviceUuid characteristicUuid byteValues do](assets/BluetoothLE.BytesReceived.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       读取或注册调用中特征UUID。
  * <code>byteValues</code> (<a href="https://www.fun123.cn/reference/blocks/listsU.html#makealist">_list_</a>) &mdash;
       从设备读取的值列表。每个值的范围取决于先前在读取或注册调用中指定的 <code>sign</code> 标志。

+ <a name="BytesWritten"></a>`BytesWritten` – 当将一个或多个字节值写入连接的蓝牙设备时，将触发该事件。<code>byteValues</code> 将是实际写入设备的值列表。如果原始输入太长而无法放入单个传输单元（通常为 23 个字节），则情况可能会有所不同。

  ![when BluetoothLE1 BytesWritten serviceUuid characteristicUuid byteValues do](assets/BluetoothLE.BytesWritten.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       读取或注册调用中特征UUID。
  * <code>byteValues</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist" target="_blank">_list_</a>) &mdash;
       写入设备的值列表。

+ <a name="Connected"></a>`Connected` – App成功连接到BLE设备后，将触发该事件。这可能是调用 <a href='#Connect'><code>Connect</code></a> 或 <a href='#ConnectWithAddress'><code>ConnectWithAddress</code></a> 的结果，或者如果在请求连接时 <a href='#AutoReconnect'><code>AutoReconnect</code></a> 属性为 `真`，则可能是自动重新连接的结果。

  ![when BluetoothLE1 Connecteddo](assets/BluetoothLE.Connected.svg)

+ <a name="ConnectionFailed"></a>`ConnectionFailed` – 当尝试连接设备失败时，将触发该事件。如果提供了具体的失败原因，则会通过 <code>reason</code> 参数给出。

  ![when BluetoothLE1 ConnectionFailed reason do](assets/BluetoothLE.ConnectionFailed.svg)

  __参数__:

  * <code>reason</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       连接失败的原因（如果有）。

+ <a name="DeviceFound"></a>`DeviceFound` – 当发现新的BLE设备时，将触发该事件。

  ![when BluetoothLE1 DeviceFounddo](assets/BluetoothLE.DeviceFound.svg)

+ <a name="Disconnected"></a>`Disconnected` – 当BLE设备断开连接时，将触发该事件。这可能是由于调用 <a href="#Disconnect"><code>Disconnect</code></a> 或 <a href="#DisconnectWithAddress"><code>DisconnectWithAddress</code></a> 引起的，或者在设备移开或重置以致发生连接丢失后引起的。

  ![when BluetoothLE1 Disconnecteddo](assets/BluetoothLE.Disconnected.svg)

+ <a name="FloatsReceived"></a>`FloatsReceived` – 当从连接的蓝牙设备接收到一个或多个 IEEE 754 浮点值时，将触发该事件。根据上次调用 <a href="#ReadFloats"><code>ReadFloats</code></a> 或 <a href="#RegisterForFloats"><code>RegisterForFloats</code></a> 的 <code>shortFloat</code> 参数（对于给定的 <code>serviceUuid</code> 和 <code>characteristicUuid</code>），<code>floatValues</code> 列表
将包含从 -65504.0 到 65504.0（<code>shortFloat = true</code>）或 -3.402823466E38 到 3.402823466E38（<code>shortFloat = false</code>）的数字。

  ![when BluetoothLE1 FloatsReceived serviceUuid characteristicUuid floatValues do](assets/BluetoothLE.FloatsReceived.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       读取或注册调用中特征UUID。
  * <code>floatValues</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist" target="_blank">_list_</a>) &mdash;
       从设备读取的值列表。每个值的范围取决于先前在读取或注册调用中指定的 <code>sign</code> 标志。

+ <a name="FloatsWritten"></a>`FloatsWritten` – 当将一个或多个 IEEE 754 浮点值写入连接的蓝牙设备时，将触发该事件。<code>floatValues</code> 将是实际写入设备的值列表。如果原始输入太长而无法放入单个传输单元（通常为 11 个短浮点数或 5 个常规浮点数），则情况可能会有所不同。

  ![when BluetoothLE1 FloatsWritten serviceUuid characteristicUuid floatValues do](assets/BluetoothLE.FloatsWritten.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       读取或注册调用中特征UUID。
  * <code>floatValues</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist" target="_blank">_list_</a>) &mdash;
       写入设备的值列表。

+ <a name="IntegersReceived"></a>`IntegersReceived` – 当从连接的蓝牙设备接收到一个或多个 32-bit 整型数值时，将触发该事件。根据上次调用 <a href="#ReadIntegers"><code>ReadIntegers</code></a> 或 <a href="#RegisterForIntegers"><code>RegisterForIntegers</code></a> 时给定 <code>serviceUuid</code> 和 <code>characteristicUuid</code> 的 <code>sign</code> 参数，<code>intValues</code> 列表将包含从 -2147483648 到 2147483647 (<code>signed = true</code>) 或 0 到 4294967296 (<code>signed = false</code>) 的数字。

  ![when BluetoothLE1 IntegersReceived serviceUuid characteristicUuid intValues do](assets/BluetoothLE.IntegersReceived.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       读取或注册调用中特征UUID。
  * <code>intValues</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist" target="_blank">_list_</a>) &mdash;
       从设备读取的值列表。每个值的范围取决于先前在读取或注册调用中指定的 <code>sign</code> 标志。

+ <a name="IntegersWritten"></a>`IntegersWritten` – 当将一个或多个 32-bit 整型数值写入连接的蓝牙设备时，将触发该事件。<code>intValues</code> 将是实际写入设备的值列表。如果原始输入太长而无法放入单个传输单元（通常为 5 个整数），则情况可能会有所不同。

  ![when BluetoothLE1 IntegersWritten serviceUuid characteristicUuid intValues do](assets/BluetoothLE.IntegersWritten.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       读取或注册调用中特征UUID。
  * <code>intValues</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist" target="_blank">_list_</a>) &mdash;
       写入设备的值列表。

+ <a name="MTUChanged"></a>`MTUChanged` – 当BLE设备将其最大传输单元 (MTU) 成功更改为不同的值时，将触发该事件。此事件为 <code>RequestMTU</code> 方法块调用时的响应。

  ![when BluetoothLE1 MTUChanged bytes do](assets/BluetoothLE.MTUChanged.svg)

  __参数__:

  * <code>bytes</code> (<a href="https://www.fun123.cn/reference/blocks/math.html#number" target="_blank">_number_</a>) &mdash;
     新的 MTU 的大小（以字节为单位）。

+ <a name="RssiChanged"></a>`RssiChanged` – 当发现BLE设备的 RSSI（接收信号强度指示）发生变化时触发该事件。

  ![when BluetoothLE1 RssiChanged rssi do](assets/BluetoothLE.RssiChanged.svg)

+ <a name="ShortsReceived"></a>`ShortsReceived` – 当从连接的蓝牙设备接收到一个或多个短整型值时，将触发该事件。根据上次调用 <a href="#ReadShorts"><code>ReadShorts</code></a> 或 <a href="#RegisterForShorts"><code>RegisterForShorts</code></a> 时给定的 <code>serviceUuid</code> 和 <code>characteristicUuid</code> 的 <code>sign</code> 参数，<code>shortValues</code> 列表将包含从 -32768 到 32767 (<code>signed = true</code>) 或 0 到 65535 (<code>signed = false</code>) 的数字。

  ![when BluetoothLE1 ShortsReceived serviceUuid characteristicUuid shortValues do](assets/BluetoothLE.ShortsReceived.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       读取或注册调用中特征UUID。
  * <code>shortValues</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist" target="_blank">_list_</a>) &mdash;
       从设备读取的值列表。每个值的范围取决于先前在读取或注册调用中指定的 <code>sign</code> 标志。

+ <a name="ShortsWritten"></a>`ShortsWritten` – 当将一个或多个短整数值写入连接的蓝牙设备时，将触发该事件。<code>shortValues</code> 将是实际写入设备的值列表。如果原始输入太长而无法放入单个传输单元（通常为 11 个短整数），则情况可能会有所不同。

  ![when BluetoothLE1 ShortsWritten serviceUuid characteristicUuid shortValues do](assets/BluetoothLE.ShortsWritten.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       读取或注册调用中特征UUID。
  * <code>shortValues</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist" target="_blank">_list_</a>) &mdash;
       写入设备的值列表。

+ <a name="StringsReceived"></a>`StringsReceived` – 当从连接的蓝牙设备接收到一个或多个字符串时，将触发该事件。根据上次调用 <a href="#ReadStrings"><code>ReadStrings</code></a> 或 <a href="#RegisterForStrings"><code>RegisterForStrings</code></a> 时给定的 <code>serviceUuid</code> 和 <code>characteristicUuid</code> 的 <code>utf16</code> 参数，<code>stringValues</code> 列表将包含 UTF-16 小端序 (<code>utf16 = true</code>) 或 UTF-8 解码 (<code>utf16 = false</code>) 字符串。字符串长度受蓝牙设备的最大传输单元 (MTU) 限制，通常为 23 个字节。

  ![when BluetoothLE1 StringsReceived serviceUuid characteristicUuid stringValues do](assets/BluetoothLE.StringsReceived.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       读取或注册调用中特征UUID。
  * <code>stringValues</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist" target="_blank">_list_</a>) &mdash;
       从设备读取的值列表。根据先前在读取或注册调用中指定的 <code>utf16</code> 标志，字符串将解码为 UTF-16 或 UTF-8。

+ <a name="StringsWritten"></a>`StringsWritten` – 当将一个或多个字符串写入连接的蓝牙设备时，将触发该事件。<code>stringValues</code> 将是实际写入设备的值列表。如果原始输入太长而无法放入单个传输单元（通常为 22 个字节），则情况可能会有所不同。

  ![when BluetoothLE1 StringsWritten serviceUuid characteristicUuid stringValues do](assets/BluetoothLE.StringsWritten.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       在读取或注册调用中传递的服务UUID。
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       读取或注册调用中特征UUID。
  * <code>stringValues</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist" target="_blank">_list_</a>) &mdash;
       写入设备的值列表。

<!--
***
官方英文原版文档[点此](https://iot.appinventor.mit.edu/#/bluetoothle/bluetoothleintro)。
-->