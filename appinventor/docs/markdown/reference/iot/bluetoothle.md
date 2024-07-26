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
       目标设备的 MAC 地址，格式为`12:34:56:78:90:ab`。

+ <a name="Disconnect"></a>`Disconnect` – 如果BLE设备已连接，则断开当前的设备连接。

  ![call BluetoothLE1 Disconnect](assets/BluetoothLE.Disconnect.svg)

+ <a name="DisconnectWithAddress"></a>`DisconnectWithAddress` – Disconnects from a connected BluetoothLE device with the given address.

  ![call BluetoothLE1 DisconnectWithAddressaddress](assets/BluetoothLE.DisconnectWithAddress.svg)

  __参数__:

  * <code>address</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The Media Access Control (MAC) address of the device to disconnect, of the form "12:34:56:78:90:ab"

+ <a name="FoundDeviceAddress"></a>`FoundDeviceAddress` – Gets the Media Access Control (MAC) address of the found device at the given index in the
 device list. Index specifies the position in the BluetoothLE device list, starting from 1.

  ![call BluetoothLE1 FoundDeviceAddressindex](assets/BluetoothLE.FoundDeviceAddress.svg)

  __参数__:

  * <code>index</code> (<a href="https://www.fun123.cn/reference/blocks/math.html#number" target="_blank">_number_</a>) &mdash;
       The index of the desired device, which must be between 1 and the length of the device list.

+ <a name="FoundDeviceName"></a>`FoundDeviceName` – Gets the name of the found device at the given index in the device list.

  ![call BluetoothLE1 FoundDeviceNameindex](assets/BluetoothLE.FoundDeviceName.svg)

  __参数__:

  * <code>index</code> (<a href="https://www.fun123.cn/reference/blocks/math.html#number" target="_blank">_number_</a>) &mdash;
       The index of the desired device, which must be between 1 and the length of the device list.

+ <a name="FoundDeviceRssi"></a>`FoundDeviceRssi` – Gets the Received Signal Strength Indicator (RSSI) of the found device at the given index.
 The returned value will be between -100 and 0 indicating the strength of the connection.

  ![call BluetoothLE1 FoundDeviceRssiindex](assets/BluetoothLE.FoundDeviceRssi.svg)

  __参数__:

  * <code>index</code> (<a href="https://www.fun123.cn/reference/blocks/math.html#number" target="_blank">_number_</a>) &mdash;
       The index of the desired device, which must be between 1 and the length of the device list.

+ <a name="GetCharacteristicsForService"></a>`GetCharacteristicsForService` – Returns the list of supported characteristics for the given service. The list will contain
 (UUID, name) pairs for each characteristic provided by the service UUID.

  ![call BluetoothLE1 GetCharacteristicsForServiceserviceUuid](assets/BluetoothLE.GetCharacteristicsForService.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.

+ <a name="ReadBytes"></a>`ReadBytes` – Reads one or more 8-bit integer values from a connected BluetoothLE device. Service Unique ID
 and Characteristic UniqueID are required. The <code>signed</code> parameter indicates whether
 the bytes should be interpreted as signed values or not when being converted into App Inventor
 numbers. After the bytes are read, the <a href="#BytesReceived"><code>BytesReceived</code></a>
 event will be run.

  ![call BluetoothLE1 ReadBytesserviceUuidcharacteristicUuidsigned](assets/BluetoothLE.ReadBytes.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
  * <code>signed</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the bytes as signed (true) or unsigned (false).

+ <a name="ReadConnectedRssi"></a>`ReadConnectedRssi` – Initiates a read of the connected device's Received Signal Strength Indicator (RSSI). The
 resulting value will be reported via the RssiChanged event.

  ![call BluetoothLE1 ReadConnectedRssi](assets/BluetoothLE.ReadConnectedRssi.svg)

+ <a name="ReadFloats"></a>`ReadFloats` – Reads one or more IEEE 754 floating point numbers from a connected BluetoothLE device. Service Unique ID
 and Characteristic UniqueID are required. The <code>shortFloat</code> parameter indicates whether
 the floats are either 16-bit half-precision floating point or 32-bit single precision floating point
 numbers. After the floats are read, the <a href="#FloatsReceived"><code>FloatsReceived</code></a>
 event will be run.

  ![call BluetoothLE1 ReadFloatsserviceUuidcharacteristicUuidshortFloat](assets/BluetoothLE.ReadFloats.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
  * <code>shortFloat</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the floats as 16-bit half-precision (true) or 32-bit single-precision (false).

+ <a name="ReadIntegers"></a>`ReadIntegers` – Reads one or more 32-bit integer values from a connected BluetoothLE device. Service Unique ID
 and Characteristic UniqueID are required. The <code>signed</code> parameter indicates whether
 the integers should be interpreted as signed values or not when being converted into App Inventor
 numbers. After the integers are read, the
 <a href="#IntegersReceived"><code>IntegersReceived</code></a> event will be run.

  ![call BluetoothLE1 ReadIntegersserviceUuidcharacteristicUuidsigned](assets/BluetoothLE.ReadIntegers.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
  * <code>signed</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the integers as signed (true) or unsigned (false).

+ <a name="ReadShorts"></a>`ReadShorts` – Reads one or more 16-bit integer values from a connected BluetoothLE device. Service Unique ID
 and Characteristic UniqueID are required. The <code>signed</code> parameter indicates whether
 the shorts should be interpreted as signed values or not when being converted into App Inventor
 numbers. After the shorts are read, the <a href="#ShortsReceived"><code>ShortsReceived</code></a>
 event will be run.

  ![call BluetoothLE1 ReadShortsserviceUuidcharacteristicUuidsigned](assets/BluetoothLE.ReadShorts.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
  * <code>signed</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the shorts as signed (true) or unsigned (false).

+ <a name="ReadStrings"></a>`ReadStrings` – Reads one or more null-terminated strings from a connected BluetoothLE device. Service Unique ID
 and Characteristic Unique ID are required. The <code>utf16</code> parameter indicates whether
 the content should be decoded as UTF-16 (true) or UTF-8 (false) code points when converting to
 App Inventor strings. After the strings are read, the
 <a href="#StringsReceived"><code>StringsReceived</code></a> event will be run.

  ![call BluetoothLE1 ReadStringsserviceUuidcharacteristicUuidutf16](assets/BluetoothLE.ReadStrings.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
  * <code>utf16</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the string content as UTF-16 (true) or UTF-8 (false) code points.

+ <a name="RegisterForBytes"></a>`RegisterForBytes` – Registers to receive updates when one or more 8-bit integer values from a connected BluetoothLE
 device are changed. Service Unique ID and Characteristic Unique ID are required. The
 <code>signed</code> parameter indicates whether the bytes should be interpreted as signed
 values or not when being converted into App Inventor numbers. Whenever a change is received,
 the <a href="#BytesReceived"><code>BytesReceived</code></a> event will be run.

  ![call BluetoothLE1 RegisterForBytesserviceUuidcharacteristicUuidsigned](assets/BluetoothLE.RegisterForBytes.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
  * <code>signed</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the bytes as signed (true) or unsigned (false).

+ <a name="RegisterForFloats"></a>`RegisterForFloats` – Registers to receive updates when one or more IEEE 754 floating point numbers from a connected
 BluetoothLE device are changed. Service Unique ID and Characteristic Unique ID are required. The
 <code>shortFloat</code> parameter indicates whether the floats are either 16-bit half-precision
 floating point or 32-bit single precision floating point numbers. Whenever a change is received,
 the <a href="#FloatsReceived"><code>FloatsReceived</code></a> event will be run.

  ![call BluetoothLE1 RegisterForFloatsserviceUuidcharacteristicUuidshortFloat](assets/BluetoothLE.RegisterForFloats.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
  * <code>shortFloat</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the floats as 16-bit half-precision (true) or 32-bit single-precision (false).

+ <a name="RegisterForIntegers"></a>`RegisterForIntegers` – Registers to receive updates when one or more 32-bit integer values from a connected BluetoothLE
 device are changed. Service Unique ID and Characteristic Unique ID are required. The
 <code>signed</code> parameter indicates whether the integers should be interpreted as signed
 values or not when being converted into App Inventor numbers. Whenever a change is received,
 the <a href="#IntegersReceived"><code>IntegersReceived</code></a> event will be run.

  ![call BluetoothLE1 RegisterForIntegersserviceUuidcharacteristicUuidsigned](assets/BluetoothLE.RegisterForIntegers.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
  * <code>signed</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the integers as signed (true) or unsigned (false).

+ <a name="RegisterForShorts"></a>`RegisterForShorts` – Registers to receive updates when one or more 16-bit integer values from a connected BluetoothLE
 device are changed. Service Unique ID and Characteristic Unique ID are required. The
 <code>signed</code> parameter indicates whether the shorts should be interpreted as signed
 values or not when being converted into App Inventor numbers. Whenever a change is received,
 the <a href="#ShortsReceived"><code>ShortsReceived</code></a> event will be run.

  ![call BluetoothLE1 RegisterForShortsserviceUuidcharacteristicUuidsigned](assets/BluetoothLE.RegisterForShorts.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
  * <code>signed</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the shorts as signed (true) or unsigned (false).

+ <a name="RegisterForStrings"></a>`RegisterForStrings` – Registers to receive updates when one or more null-terminated strings from a connected
 BluetoothLE device are changed. Service Unique ID and Characteristic Unique ID are required. The
 <code>utf16</code> parameter indicates whether the content should be decoded as UTF-16 (true)
 or UTF-8 (false) code points when converting to App Inventor strings. Whenever a change is
 received, the <a href="#StringsReceived"><code>StringsReceived</code></a> event will be run.

  ![call BluetoothLE1 RegisterForStringsserviceUuidcharacteristicUuidutf16](assets/BluetoothLE.RegisterForStrings.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
  * <code>utf16</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the string content as UTF-16 (true) or UTF-8 (false) code points.

+ <a name="RequestMTU"></a>`RequestMTU` – 为 BluetoothLE 连接请求新的最大传输单元 (MTU)。此功能仅在两个设备都支持蓝牙 4.2 或更高版本时才受支持。如果 MTU 更改成功，则 [MTUChanged](#MTUChanged) 事件将被触发。默认 MTU 为 20。

  ![call BluetoothLE1 RequestMTUbytes](assets/BluetoothLE.RequestMTU.svg)

  此块适用于需要更改 BLE 设备之间发送的消息大小的高级应用。大多数开发人员不需要调整此值。

    * MTU: 最大传输单元（MAXIMUM TRANSMISSION UNIT） ， 指在一个PDU （Protocol Data Unit： 协议数据单元，在一个传输单元中的有效传输数据）能够传输的最大数据量（多少字节可以一次性传输到对方）。
    * MTU 交换是为了在主从双方设置一个PDU中最大能够交换的数据量，通过MTU的交换和双方确认（注意这个MTU是不可以协商的，只是通知对方，双方在知道对方的极限后会选择一个较小的值作为以后的MTU，比如说，主设备发出一个150个字节的MTU请求，但是从设备回应MTU是23字节，那么今后双方要以较小的值23字节作为以后的MTU），主从双方约定每次在做数据传输时不超过这个最大数据单元。
    * 更多MTU技术内幕请参考[《一分钟读懂低功耗蓝牙(BLE) MTU交换数据包》](https://bbs.tsingfun.com/thread-1837-1-1.html)。

  __参数__:

  * <code>bytes</code> (<a href="">_number_</a>) &mdash;
     期望的 MTU 大小（单位：字节）。

+ <a name="ScanAdvertisements"></a>`ScanAdvertisements` – Scans for advertising Bluetooth low energy devices.

  ![call BluetoothLE1 ScanAdvertisementsscanPeriod](assets/BluetoothLE.ScanAdvertisements.svg)

  __参数__:

  * <code>scanPeriod</code> (<a href="https://www.fun123.cn/reference/blocks/math.html#number" target="_blank">_number_</a>) &mdash;
       The amount of time to spend scanning, in milliseconds.

+ <a name="ScanForDevice"></a>`ScanForDevice` – Scans for a particular type of device. The device component must implement
 the BLEDevice interface in order for this method to work.

  ![call BluetoothLE1 ScanForDevicedevice](assets/BluetoothLE.ScanForDevice.svg)

  __参数__:

  * <code>param</code> (<a href="">_component_</a>) &mdash;
     A component block that expects a particular service.

+ <a name="ScanForService"></a>`ScanForService` – Scans for devices advertising a particular Bluetooth low energy service
 by UUID.

  ![call BluetoothLE1 ScanForServiceserviceUuid](assets/BluetoothLE.ScanForService.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
     The unique identifier of the service being broadcast by the device(s)
     of interest.

+ <a name="ServiceByIndex"></a>`ServiceByIndex` – Returns the Unique ID of the service at the given index in the service list.

  ![call BluetoothLE1 ServiceByIndexindex](assets/BluetoothLE.ServiceByIndex.svg)

  __参数__:

  * <code>index</code> (<a href="https://www.fun123.cn/reference/blocks/math.html#number" target="_blank">_number_</a>) &mdash;
       The index of the desired service, which must be between 1 and the length of the service list.

+ <a name="StartAdvertising"></a>`StartAdvertising` – Creates and publishes a Bluetooth low energy advertisement.

  ![call BluetoothLE1 StartAdvertisinginDataserviceUuid](assets/BluetoothLE.StartAdvertising.svg)

  __参数__:

  * <code>inData</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The data to be included in the service advertisement.
  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.

+ <a name="StartScanning"></a>`StartScanning` – Starts scanning for Bluetooth low energy devices.

  ![call BluetoothLE1 StartScanning](assets/BluetoothLE.StartScanning.svg)

+ <a name="StopAdvertising"></a>`StopAdvertising` – Stops Bluetooth low energy advertisement from a previous call to
 <a href="#StartAdvertising"><code>StartAdvertising</code></a>.

  ![call BluetoothLE1 StopAdvertising](assets/BluetoothLE.StopAdvertising.svg)

+ <a name="StopScanning"></a>`StopScanning` – Stops scanning for Bluetooth low energy devices.

  ![call BluetoothLE1 StopScanning](assets/BluetoothLE.StopScanning.svg)

+ <a name="StopScanningAdvertisements"></a>`StopScanningAdvertisements` – Stops scanning for Bluetooth low energy advertisements.

  ![call BluetoothLE1 StopScanningAdvertisements](assets/BluetoothLE.StopScanningAdvertisements.svg)

+ <a name="SupportedCharacteristics"></a>`SupportedCharacteristics` – Returns a list of supported characteristic for the connected device as a string.

  ![call BluetoothLE1 SupportedCharacteristics](assets/BluetoothLE.SupportedCharacteristics.svg)

+ <a name="SupportedServices"></a>`SupportedServices` – Returns the list of supported service for the connected device as a string.

  ![call BluetoothLE1 SupportedServices](assets/BluetoothLE.SupportedServices.svg)

+ <a name="UnregisterForValues"></a>`UnregisterForValues` – Unregisters for updates from the given service and characteristic.

  ![call BluetoothLE1 UnregisterForValuesservice_uuidcharacteristic_uuid](assets/BluetoothLE.UnregisterForValues.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.

+ <a name="WriteBytes"></a>`WriteBytes` – Writes one or more 8-bit integer values to a connected BluetoothLE device. Service Unique ID
 and Characteristic Unique ID are required. The values parameter can either be a single numeric
 value or a list of values. If <code>signed</code> is true, the acceptable values are
 between -128 and 127. If <code>signed</code> is false, the acceptable values are
 between 0 and 255.

  ![call BluetoothLE1 WriteBytesserviceUuidcharacteristicUuidsignedvalues](assets/BluetoothLE.WriteBytes.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
  * <code>signed</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the bytes as signed (true) or unsigned (false).
  * <code>values</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values to write to the device.

+ <a name="WriteBytesWithResponse"></a>`WriteBytesWithResponse` – Writes one or more 8-bit integer values to a connected BluetoothLE device and waits for an
 acknowledgement via the <a href="#BytesWritten"><code>BytesWritten</code></a> event.
 Service Unique ID and Characteristic Unique ID are required. The values parameter can either
 be a single numeric value or a list of values. If <code>signed</code> is true, the acceptable
 values are between -128 and 127. If <code>signed</code> is false, the acceptable values are
 between 0 and 255.

  ![call BluetoothLE1 WriteBytesWithResponseserviceUuidcharacteristicUuidsignedvalues](assets/BluetoothLE.WriteBytesWithResponse.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
  * <code>signed</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the bytes as signed (true) or unsigned (false).
  * <code>values</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values to write to the device.

+ <a name="WriteFloats"></a>`WriteFloats` – Writes one or more IEEE 754 floating point numbers to a connected BluetoothLE device. Service Unique ID
 and Characteristic Unique ID are required. The values parameter can either be a single numeric
 value or a list of values. If <code>shortFloat</code> is true, then each numeric value will be
 compressed to fit into a 16-bit half-precision floating point value. If <code>shortFloat</code>
 is false, then each numeric value will be sent as a 32-bit single precision floating point value.

  ![call BluetoothLE1 WriteFloatsserviceUuidcharacteristicUuidshortFloatvalues](assets/BluetoothLE.WriteFloats.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
  * <code>shortFloat</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the floats as 16-bit half-precision (true) or 32-bit single-precision (false).
  * <code>values</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values to write to the device.

+ <a name="WriteFloatsWithResponse"></a>`WriteFloatsWithResponse` – Writes one or more IEEE 754 floating point values to a connected BluetoothLE device and waits for an
 acknowledgement via the <a href="#FloatsWritten"><code>FloatsWritten</code></a> event.
 Service Unique ID and Characteristic Unique ID are required. The values parameter can either
 be a single numeric value or a list of values. If <code>shortFloat</code> is false,
 then each numeric value will be sent as a 32-bit single precision floating point value.

  ![call BluetoothLE1 WriteFloatsWithResponseserviceUuidcharacteristicUuidshortFloatvalues](assets/BluetoothLE.WriteFloatsWithResponse.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
  * <code>shortFloat</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the floats as 16-bit half-precision (true) or 32-bit single-precision (false).
  * <code>values</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values to write to the device.

+ <a name="WriteIntegers"></a>`WriteIntegers` – Writes one or more 32-bit integer values to a connected BluetoothLE device. Service Unique ID
 and Characteristic Unique ID are required. The values parameter can either be a single numeric
 value or a list of values. If <code>signed</code> is true, the acceptable values are
 between -2147483648 and 2147483647. If <code>signed</code> is false, the acceptable values are
 between 0 and 4294967295.

  ![call BluetoothLE1 WriteIntegersserviceUuidcharacteristicUuidsignedvalues](assets/BluetoothLE.WriteIntegers.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
  * <code>signed</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the integers as signed (true) or unsigned (false).
  * <code>values</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values to write to the device.

+ <a name="WriteIntegersWithResponse"></a>`WriteIntegersWithResponse` – Writes one or more 32-bit integer values to a connected BluetoothLE device and waits for an
 acknowledgement via the <a href="#IntegersWritten"><code>IntegersWritten</code></a> event.
 Service Unique ID and Characteristic Unique ID are required. The values parameter can either
 be a single numeric value or a list of values. If <code>signed</code> is true, the acceptable
 values are between -2147483648 and 2147483647. If <code>signed</code> is false, the acceptable
 values are between 0 and 4294967295.

  ![call BluetoothLE1 WriteIntegersWithResponseserviceUuidcharacteristicUuidsignedvalues](assets/BluetoothLE.WriteIntegersWithResponse.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
  * <code>signed</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the integers as signed (true) or unsigned (false).
  * <code>values</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values to write to the device.

+ <a name="WriteShorts"></a>`WriteShorts` – Writes one or more 16-bit integer values to a connected BluetoothLE device. Service Unique ID
 and Characteristic Unique ID are required. The values parameter can either be a single numeric
 value or a list of values. If <code>signed</code> is true, the acceptable values are
 between -32768 and 32767. If <code>signed</code> is false, the acceptable values are
 between 0 and 65535.

  ![call BluetoothLE1 WriteShortsserviceUuidcharacteristicUuidsignedvalues](assets/BluetoothLE.WriteShorts.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
  * <code>signed</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the shorts as signed (true) or unsigned (false).
  * <code>values</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values to write to the device.

+ <a name="WriteShortsWithResponse"></a>`WriteShortsWithResponse` – Writes one or more 16-bit integer values to a connected BluetoothLE device and waits for an
 acknowledgement via the <a href="#ShortsWritten"><code>ShortsWritten</code></a> event.
 Service Unique ID and Characteristic Unique ID are required. The values parameter can either
 be a single numeric value or a list of values. If <code>signed</code> is true, the acceptable
 values are between -32768 and 32767. If <code>signed</code> is false, the acceptable values
 are between 0 and 65535.

  ![call BluetoothLE1 WriteShortsWithResponseserviceUuidcharacteristicUuidsignedvalues](assets/BluetoothLE.WriteShortsWithResponse.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
  * <code>signed</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the shorts as signed (true) or unsigned (false).
  * <code>values</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values to write to the device.

+ <a name="WriteStrings"></a>`WriteStrings` – Writes one or more strings to a connected BluetoothLE device. Service Unique ID and
 Characteristic Unique ID are required. The values parameter can either be a single string or a
 list of strings. If <code>utf16</code> is true, the string(s) will be sent using UTF-16 little
 endian encoding. If <code>utf16</code> is false, the string(s) will be sent using UTF-8
 encoding.

  ![call BluetoothLE1 WriteStringsserviceUuidcharacteristicUuidutf16values](assets/BluetoothLE.WriteStrings.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
  * <code>utf16</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Send the string encoded as UTF-16 little endian (true) or UTF-8 (false) code points.
  * <code>values</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values to write to the device.

+ <a name="WriteStringsWithResponse"></a>`WriteStringsWithResponse` – Writes one or more strings to a connected BluetoothLE device and waits for an acknowledgement
 via the <a href="#StringsWritten"><code>StringsWritten</code></a> event. Service Unique ID and
 Characteristic Unique ID are required. The values parameter can either be a single string or a
 list of values. If <code>utf16</code> is true, the string(s) will be sent using UTF-16 little
 endian encoding. If <code>utf16</code> is false, the string(s) will be sent using UTF-8
 encoding.

  ![call BluetoothLE1 WriteStringsWithResponseserviceUuidcharacteristicUuidutf16values](assets/BluetoothLE.WriteStringsWithResponse.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
  * <code>utf16</code> (<a href="https://www.fun123.cn/reference/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Send the string encoded as UTF-16 little endian (true) or UTF-8 (false) code points.
  * <code>values</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values to write to the device.

## 事件

+ <a name="BytesReceived"></a>`BytesReceived` – The <code>BytesReceived</code> event is run when one or more byte values are received from a
 connected Bluetooth device. Depending on the <code>sign</code> parameter of the last call to
 <a href="#ReadBytes"><code>ReadBytes</code></a> or
 <a href="#RegisterForBytes"><code>RegisterForBytes</code></a> for the given
 <code>serviceUuid</code> and <code>characteristicUuid</code>, the <code>byteValues</code> list
 will contain numbers ranging from -128 to 127 (<code>signed = true</code>)
 or 0 to 255 (<code>signed = false</code>).

  ![when BluetoothLE1 BytesReceived serviceUuid characteristicUuid byteValues do](assets/BluetoothLE.BytesReceived.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
  * <code>byteValues</code> (<a href="https://www.fun123.cn/reference/blocks/listsU.html#makealist">_list_</a>) &mdash;
       A list of values read from the device. The range of each value will depend on the <code>sign</code> flag previously specified in the call to read or register.

+ <a name="BytesWritten"></a>`BytesWritten` – The <code>BytesWritten</code> event is run when one or more byte values are written to a
 connected Bluetooth device. <code>byteValues</code> will be a list of values actually written
 to the device. This may be different if the original input was too long to fit into a single
 transmission unit (typically 23 bytes).

  ![when BluetoothLE1 BytesWritten serviceUuid characteristicUuid byteValues do](assets/BluetoothLE.BytesWritten.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
  * <code>byteValues</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values written to the device.

+ <a name="Connected"></a>`Connected` – The <code>Connected</code> event is run after the application successfully connects to a
 Bluetooth low energy device. This can be the result of a call to
 <a href='#Connect'><code>Connect</code></a> or
 <a href='#ConnectWithAddress'><code>ConnectWithAddress</code></a>, or as a result of an
 automatic reconnect if the <a href='#AutoReconnect'><code>AutoReconnect</code></a> property
 was true at the time a connection was requested.

  ![when BluetoothLE1 Connecteddo](assets/BluetoothLE.Connected.svg)

+ <a name="ConnectionFailed"></a>`ConnectionFailed` – The <code>ConnectionFailed</code> event is run when an attempt to connect to a device does not
 succeed. If a reason is provided by the Bluetooth low energy stack it will be reported via the
 <code>reason</code> parameter.

  ![when BluetoothLE1 ConnectionFailed reason do](assets/BluetoothLE.ConnectionFailed.svg)

  __参数__:

  * <code>reason</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The reason the connection failed, if known.

+ <a name="DeviceFound"></a>`DeviceFound` – The <code>DeviceFound</code> event is run when a new Bluetooth low energy device is found.

  ![when BluetoothLE1 DeviceFounddo](assets/BluetoothLE.DeviceFound.svg)

+ <a name="Disconnected"></a>`Disconnected` – The <code>Disconnected</code> event is run when a Bluetooth low energy device is disconnected.
 This can be caused by a call to <a href="#Disconnect"><code>Disconnect</code></a> or
 <a href="#DisconnectWithAddress"><code>DisconnectWithAddress</code></a>, or after a device
 is moved away or reset such that a loss of connection occurs.

  ![when BluetoothLE1 Disconnecteddo](assets/BluetoothLE.Disconnected.svg)

+ <a name="FloatsReceived"></a>`FloatsReceived` – The <code>FloatsReceived</code> event is run when one or more IEEE 754 floating point values are received from a
 connected Bluetooth device. Depending on the <code>shortFloat</code> parameter of the last call to
 <a href="#ReadFloats"><code>ReadFloats</code></a> or
 <a href="#RegisterForFloats"><code>RegisterForFloats</code></a> for the given
 <code>serviceUuid</code> and <code>characteristicUuid</code>, the <code>floatValues</code> list
 will contain numbers ranging from -65504.0 to 65504.0 (<code>shortFloat = true</code>)
 or -3.402823466E38 to 3.402823466E38 (<code>shortFloat = false</code>).

  ![when BluetoothLE1 FloatsReceived serviceUuid characteristicUuid floatValues do](assets/BluetoothLE.FloatsReceived.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
  * <code>floatValues</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values read from the device. The range of each value will depend on the <code>sign</code> flag previously specified in the call to read or register.

+ <a name="FloatsWritten"></a>`FloatsWritten` – The <code>FloatsWritten</code> event is run when one or more IEEE 754 floating point values are written to a
 connected Bluetooth device. <code>floatValues</code> will be a list of values actually written
 to the device. This may be different if the original input was too long to fit into a single
 transmission unit (typically 11 short floats or 5 regular floats).

  ![when BluetoothLE1 FloatsWritten serviceUuid characteristicUuid floatValues do](assets/BluetoothLE.FloatsWritten.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
  * <code>floatValues</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values written to the device.

+ <a name="IntegersReceived"></a>`IntegersReceived` – The <code>IntegersReceived</code> event is run when one or more 32-bit integer values are received from a
 connected Bluetooth device. Depending on the <code>sign</code> parameter of the last call to
 <a href="#ReadIntegers"><code>ReadIntegers</code></a> or
 <a href="#RegisterForIntegers"><code>RegisterForIntegers</code></a> for the given
 <code>serviceUuid</code> and <code>characteristicUuid</code>, the <code>intValues</code> list
 will contain numbers ranging from -2147483648 to 2147483647 (<code>signed = true</code>)
 or 0 to 4294967296 (<code>signed = false</code>).

  ![when BluetoothLE1 IntegersReceived serviceUuid characteristicUuid intValues do](assets/BluetoothLE.IntegersReceived.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
  * <code>intValues</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values read from the device. The range of each value will depend on the <code>sign</code> flag previously specified in the call to read or register.

+ <a name="IntegersWritten"></a>`IntegersWritten` – The <code>IntegersWritten</code> event is run when one or more 32-bit integers values are written to a
 connected Bluetooth device. <code>intValues</code> will be a list of values actually written
 to the device. This may be different if the original input was too long to fit into a single
 transmission unit (typically 5 integers).

  ![when BluetoothLE1 IntegersWritten serviceUuid characteristicUuid intValues do](assets/BluetoothLE.IntegersWritten.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
  * <code>intValues</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values written to the device.

+ <a name="MTUChanged"></a>`MTUChanged` – The MTUChanged event is run when the two BluetoothLE devices have successfully changed their
 maximum transmission unit (MTU) to a different value. This event will only run in response
 to a call to the method block RequestMTU.

  ![when BluetoothLE1 MTUChanged bytes do](assets/BluetoothLE.MTUChanged.svg)

  __参数__:

  * <code>bytes</code> (<a href="">_number_</a>) &mdash;
     The new size, in bytes, of the new MTU.

+ <a name="RssiChanged"></a>`RssiChanged` – Trigger event when RSSI (Received Signal Strength Indicator) of found BluetoothLE device changes

  ![when BluetoothLE1 RssiChanged rssi do](assets/BluetoothLE.RssiChanged.svg)

+ <a name="ShortsReceived"></a>`ShortsReceived` – The <code>ShortsReceived</code> event is run when one or more short integer values are received from a
 connected Bluetooth device. Depending on the <code>sign</code> parameter of the last call to
 <a href="#ReadShorts"><code>ReadShorts</code></a> or
 <a href="#RegisterForShorts"><code>RegisterForShorts</code></a> for the given
 <code>serviceUuid</code> and <code>characteristicUuid</code>, the <code>shortValues</code> list
 will contain numbers ranging from -32768 to 32767 (<code>signed = true</code>)
 or 0 to 65535 (<code>signed = false</code>).

  ![when BluetoothLE1 ShortsReceived serviceUuid characteristicUuid shortValues do](assets/BluetoothLE.ShortsReceived.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
  * <code>shortValues</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values read from the device. The range of each value will depend on the <code>sign</code> flag previously specified in the call to read or register.

+ <a name="ShortsWritten"></a>`ShortsWritten` – The <code>ShortsWritten</code> event is run when one or more short integers values are written to a
 connected Bluetooth device. <code>shortValues</code> will be a list of values actually written
 to the device. This may be different if the original input was too long to fit into a single
 transmission unit (typically 11 shorts).

  ![when BluetoothLE1 ShortsWritten serviceUuid characteristicUuid shortValues do](assets/BluetoothLE.ShortsWritten.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
  * <code>shortValues</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values written to the device.

+ <a name="StringsReceived"></a>`StringsReceived` – The <code>StringsReceived</code> event is run when one or more strings are received from a
 connected Bluetooth device. Depending on the <code>utf16</code> parameter of the last call to
 <a href="#ReadStrings"><code>ReadStrings</code></a> or
 <a href="#RegisterForStrings"><code>RegisterForStrings</code></a> for the given
 <code>serviceUuid</code> and <code>characteristicUuid</code>, the <code>stringValues</code> list
 will contain either a UTF-16 little endian decoded (<code>utf16 = true</code>) or UTF-8
 decoded (<code>utf16 = false</code>) strings. The string length is limited by the maximum
 transmission unit (MTU) of the Bluetooth device, which is typically 23 bytes.

  ![when BluetoothLE1 StringsReceived serviceUuid characteristicUuid stringValues do](assets/BluetoothLE.StringsReceived.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
  * <code>stringValues</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values read from the device. The strings will be decoded as UTF-16 or UTF-8 based on the <code>utf16</code> flag previously specified in the call to read or register.

+ <a name="StringsWritten"></a>`StringsWritten` – The <code>StringsWritten</code> event is run when one or more strings are written to a
 connected Bluetooth device. <code>stringValues</code> will be a list of values actually written
 to the device. This may be different if the original input was too long to fit into a single
 transmission unit (typically 22 bytes).

  ![when BluetoothLE1 StringsWritten serviceUuid characteristicUuid stringValues do](assets/BluetoothLE.StringsWritten.svg)

  __参数__:

  * <code>serviceUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
  * <code>characteristicUuid</code> (<a href="https://www.fun123.cn/reference/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
  * <code>stringValues</code> (<a href="https://www.fun123.cn/reference/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values written to the device.


***
官方英文原版文档[点此](https://iot.appinventor.mit.edu/#/bluetoothle/bluetoothleintro)。
