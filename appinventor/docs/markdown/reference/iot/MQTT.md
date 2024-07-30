---
title: App Inventor 2 UrsPahoMqttClient 拓展 - 物联网轻量级MQTT协议
layout: documentation
description: App Inventor 2 UrsPahoMqttClient 拓展，MQTT协议，物联网设计的轻量级协议，基于TCP协议实现。
---

* TOC
{:toc}

[&laquo; 返回首页](index.html)

最新版拓展下载：

{:.vip}
[de.ullisroboterseite.ursai2pahomqtt.aix](mqtt/de.ullisroboterseite.ursai2pahomqtt.aix)

<!--https://ullisroboterseite.de/android-AI2-PahoMQTT-en.html-->


## MQTT（Message Queuing Telemetry Transport：消息队列遥测传输）

MQTT 发明于 1999 年，为物联网设计的轻量级协议，基于`TCP`协议实现。

![mqtt](mqtt/model.jpg)

* MQTT 协议文档：[https://mqtt.org/](https://mqtt.org/)

<!--https://blog.csdn.net/INT_TANG/article/details/125834594-->

* 虽然 App Inventor 有现成的 MQTT 扩展，但它们需要额外的 JavaScript 或外部配置文件。此处介绍的 MQTT 客户端组件完全独立工作，不需要任何外部元素。它完全支持 MQTT 协议版本 3.1.1（除了这一点例外：订阅和取消订阅只能指定单个主题，而不能是列表。App Inventor 无法很好地处理此类列表）。

* 此版本的 MQTT 客户端基于 [Eclipse Paho Java 客户端](https://www.eclipse.org/paho/index.php?page=clients/java/index.php)。它与以前的版本不兼容，但允许使用 SSL/TLS 连接以满足更高的安全要求。

* 在 MQTT 客户端连接到 MQTT 服务器之前，必须先设置连接参数，然后使用 `Connect` 方法创建与服务器的连接。`ConnectionStateChanged` 事件报告连接状态的任何变化。工作完成后，可以使用 `Disconnect` 方法断开与服务器的连接。

* 使用 `Publish` 方法的不同变体，将消息发送到服务器。`Subscribe` 方法可用于确定客户端想要接收哪些主题消息的推送。可以使用 `Unsubscribe` 方法取消对主题的订阅。通过 `PublishedReceived` 事件报告收到有关订阅主题的消息。该组件还提供错误处理方法。

## 客户端连接参数

要连接到MQTT消息服务器，组件需要设置连接选项，“界面设计”或“程序设计”视图均可进行设置。

### 连接信息

{:.properties}

{:id="UrsPahoMqttClient.Broker" .text} *Broker - MQTT消息服务器*
: 服务器的主机名或 IP 地址。

{:id="UrsPahoMqttClient.Port" .number} *Port - 端口*
: 连接的端口号。默认值为 1883。

{:id="UrsPahoMqttClient.Protocol" .text} *Protocol - 协议*
: 协议类型：允许的值为`TCP`、`SSL`和`TLS`，其他值将被忽略。

### 身份标识

{:.properties}

{:id="UrsPahoMqttClient.ClientID" .text} *ClientID - 客户端ID*
: 可选：唯一客户端标识。如果未指定任何值，则内部会分配一个随机值 (GUID)。同时连接到同一消息服务器的所有客户端，客户端ID必须是唯一的。

### 认证信息

{:.properties}

{:id="UrsPahoMqttClient.UserName" .text} *UserName - 用户名*
: 可选：用于身份验证的用户名。

{:id="UrsPahoMqttClient.UserPasword" .text} *UserPasword - 用户密码*
: 可选：用于身份验证的用户密码。

**SSL/TLS：服务器身份验证**

使用 受信任的证书文件 和 信任库文件 属性设置服务器身份验证（使用 SSL/TLS 协议）。

|   受信任的证书文件     | 信任库文件	  | 测试  |
|---------|---------|---------|
|   文件名     | X	  | 使用指定的证书。  |
|   空     | 文件名	  | 使用信任库中的证书。如果信任库使用密码保护，则需要 TruststorePassword。  |
|   空     | 空	  | 使用服务器在建立连接时传输的 CA 签名证书。  |

{:.properties}

{:id="UrsPahoMqttClient.TrustedCertFile" .text} *TrustedCertFile - 受信任的证书文件*
: 可选：受信任的证书文件的名称。

{:id="UrsPahoMqttClient.TruststoreFile" .text} *TruststoreFile - 信任库文件*
: 可选：信任库文件的名称。

{:id="UrsPahoMqttClient.TruststorePassword" .text} *TruststorePassword - 信任库的密码*
: 可选：打开信任库的密码。

**SSL/TLS：客户端身份验证**

使用 客户端证书文件 和 密钥库文件 属性设置客户端身份验证（使用 SSL/TLS 协议）。

|   客户端证书文件     | 密钥库文件	  | 测试  |
|---------|---------|---------|
|   文件名     | X	  | ClientKeyFile 中指定的证书和私钥。如果 KeyFile 受密码保护，则需要 ClientKeyPassword。  |
|   空     | 文件名	  | 密钥库中的证书和私钥。如果密钥库受密码保护，则需要 ClientKeystorePassword。  |
|   文件     | 空	  | 无客户端身份验证。  |

密钥库可以采用 PKCS#12 格式（文件扩展名“p12”或“pfx”）或[标准格式](https://docs.oracle.com/javase/7/docs/api/java/security/KeyStore.html#getDefaultType())。

**通过证书文件进行身份验证**

{:.properties}

{:id="UrsPahoMqttClient.ClientCertFile" .text} *ClientCertFile - 客户端证书文件*
: 可选：客户端证书文件的名称。

{:id="UrsPahoMqttClient.ClientKeyFile" .text} *ClientKeyFile - 私钥文件*
: 可选：私钥文件的名称。如果通过证书文件进行身份验证，则为必填项。

{:id="UrsPahoMqttClient.ClientKeyPassword" .text} *ClientKeyPassword - 私钥文件密码*
: 可选：打开私钥文件的密码。

{:id="UrsPahoMqttClient.ClientPemFormatted" .boolean} *ClientPemFormatted - 是否PEM格式*
: 可选：证书和私钥是否是 PEM 格式。

**通过密钥库进行身份验证**

{:.properties}

{:id="UrsPahoMqttClient.ClientKeystoreFile" .text} *ClientKeystoreFile - 密钥库文件*
: 可选：密钥库文件的名称。密钥库可以采用 PKCS#12 格式（文件扩展名为“p12”或“pfx”）或[标准格式](https://docs.oracle.com/javase/7/docs/api/java/security/KeyStore.html#getDefaultType())。

{:id="UrsPahoMqttClient.ClientKeystorePassword" .text} *ClientKeystorePassword - 密钥库的密码*
: 打开密钥库的密码。


### 连接控制

{:.properties}

{:id="UrsPahoMqttClient.ConnectionTimeout" .number} *ConnectionTimeout - 连接超时时间*
: 设置连接超时时间（单位：秒），定义客户端等待与 MQTT 服务器建立网络连接的最大时间间隔。默认超时为 30 秒。值为 0 表示禁用超时处理，这意味着客户端将一直等待，直至网络连接成功或失败。

{:id="UrsPahoMqttClient.TimeToWait" .number} *TimeToWait - 等待时间*
: 设置控制权返回给调用App之前等待操作完成的最长等待时间（单位：秒）。在以下情况下将返回控制权：

  * 操作完成
  * 或超时
  * 或客户端断开/关闭

  默认值为 -1，表示操作不会超时。如果发生超时，操作将继续在后台运行，直到完成。超时用于在操作过程中进行阻塞。

{:id="UrsPahoMqttClient.MaxInflight" .number} *MaxInflight - 最大排队数量*
: 最大排队数量指定我们可以在未收到确认的情况下发送的消息数量。默认值为 10。在高流量环境中，请增加此值。

{:id="UrsPahoMqttClient.KeepAlive" .number} *KeepAlive - 保持活动时间*
: 定义发送或接收消息之间的最大时间间隔（单位：秒）。它使客户端能够检测服务器是否不再可用，而无需等待 TCP/IP 超时。

  客户端将确保在每个保持活动期间至少有一条消息通过网络传输，如果在该时间段内没有与数据相关的消息，客户端将发送一个非常小的“ping”消息，服务器将确认该消息。
  
  值为 0 会禁用客户端中的保持活动处理。默认值为 60 秒。

## 连接到服务器

使用 `Connect` 方法建立与消息服务器的连接，并使用 `Disconnect` 方法终止与服务器的连接。外部事件也会影响与服务器的连接，例如与网络的连接/丢失。

可以通过 `ConnectionState` 属性获取当前的连接状态。如果连接状态发生变化，则会触发 `ConnectionStateChanged` 事件。

### 连接建立和终止方法

`Connect` 方法有两种变体，不带后缀 (`Connect`) 和带“Last Will” (`ConnectWithLastWill`)。

| ![mqtt](mqtt/connect.png)  |  建立连接，不做其他操作。<br/>**boolean CleanSession** 表示是否链接到先前中止的会话。  |
| ![mqtt](mqtt/connectwithlastwill.png)   | 建立连接，当连接建立成功后将发送一次消息。<br/>**boolean CleanSession** 表示是否链接到先前中止的会话。WillTopic、WillQoS、WillRetain 和 WillMessage 与 Publish 方法中描述的相同（请参阅发送消息）。  |

终止连接是通过 `Disconnect` 方法完成的，该方法无参数。

![mqtt](mqtt/disconnect.png)

注意：只有当连接不定期中断时，使用“Last Will”存储的信息才会生效。如果连接是通过 `Disconnect` 终止的，则将丢弃“Last Will”。在这里，客户端负责在调用 `Disconnect` 之前发送适当的消息。

### 连接状态

可以随时通过 `ConnectionState` 属性查询当前连接状态。

![mqtt](mqtt/connectionstate.png) 

可能的状态有：

|   代码     | 状态	  | 含义  |  允许调用方法  |
|---------|---------|---------|---------|
|   0    | `Disconnected`	  | 客户端未连接到服务器。  |  `Connect`  |
|   1    | `Connecting`	  | 客户端尝试连接到服务器。  |  -  |
|   2    | `Connected`	  | 客户端已连接到服务器。  |  `Subscribe`, `Publish`, `Disconnect`  |
|   3    | `Disconnecting`	  | 客户端正在断开与服务器的连接。  |  -  |
|   4    | `ConnectionAborted`	  | 由于错误或中断，无法建立连接。可以通过属性 `LastErrorCode` 和 `LastErrorMessage` 查看错误原因。  |  `Connect`  |

常量属性：

![mqtt](mqtt/connectionstateconstants.png) 

为了简化状态查询，已经实现了 `IsConnected` 和 `IsDisconnected` 属性：

![mqtt](mqtt/isconnected.png) 

下面的状态图解释了连接建立和终止的过程：

![mqtt](mqtt/connectionstatediagram.png) 

* MQTT 客户端以 `Disconnected` (0) 状态启动。调用 `Connect` 方法时，客户端进入 `Connecting` (1) 状态。尝试与 MQTT 服务器建立 TCP 连接，并向服务器发送 CONNECT 类型的 MQTT 消息。如果此操作未成功（错误）或服务器未收到 CONNACK 类型的消息，客户端将进入 `ConnectionAborted` (4) 状态。

* 收到 CONNACK 类型的消息时，将验证服务器是否接受来自客户端的连接请求。如果未接受（CONNACK 错误），则网络连接终止，客户端进入 `ConnectionAborted` (4) 状态。如果服务器接受连接（CONNACK ok），客户端将进入 `Connected` (2) 状态。

* 调用 `Disconnect` 方法时，断开连接开始。客户端进入 `Diconnecting` (3) 状态。首先，向服务器发送 DISCONNECT 消息。如果成功，客户端将进入 `Diconnected` (0) 状态。如果发生错误（Error），状态将变为`ConnectionAborted`（4）。

* 如果在操作过程中发生错误（`ReceiverTreadError`），则网络连接断开，状态将变为`ConnectionAborted`（4）。

### 连接状态变更事件

如果连接状态发生变化，则会触发`ConnectionStateChanged`事件。

![mqtt](mqtt/connectionstatechanged.png) 

* NewState：状态的数值（0..4，见上文）

* StateString：状态的名称（“Disconnected”等）

### 建立连接时出错

* 在尝试建立连接之前，首先会检查客户端的状态是否允许这样做（状态 = `Disconnected` 或 `ConnectionAborted`）。如果不允许，则中止尝试并触发 `ErrorOccurred` 事件，代码为 32300（“无效状态”）。

* 如果状态允许，则客户端将更改为 `Connecting` 状态。现在，所有其他错误都会导致触发 `ConnectionStateChanged` 事件，状态为 `ConnectionAborted`。有关更多详细信息，请参阅错误处理部分。






## 错误处理

以下属性可用于处理错误情况：

![mqtt](mqtt/errorinfo.png) 

* LastAction：最后执行的操作的名称，例如“Connect”

* LastErrorCode：最后错误的错误代码（见下文）。

* LastErrorMessage：错误的文本描述，例如“Unacceptable protocol version”

* LastExceptionCause：触发错误的异常的文本。

重要提示：提到的属性仅包含可能的错误事件的指示。许多操作是异步执行的。对于这些，错误跟踪并不总是可能的。1..32203 是 Paho-Clients 的故障编号。

|   代码     | 含义	  | 文本  |
|---------|---------|---------|---------|
|   0    |    |    |
| 1 | 	The protocol version requested is not supported by the server.	 | Invalid protocol version. |
| 2 | 	The server has rejected the supplied client ID.	 | Invalid client ID. |
| 3 | 	The broker was not available to handle the request.	 | Broker unavailable. |
| 4 | 	Authentication with the server has failed, due to a bad user name or password.	| Bad user name or password. |
| 5 | 	 Not authorized to perform the requested operation.	 | Not authorized to connect. |
| 6 | 	An unexpected error has occurred.	 | Unexpected error. |
| 128 | 	Error from subscribe - returned from the server.	 | Error from subscribe. |
| 32000 | 	Client timed out while waiting for a response from the server. The server is no longer responding to keep-alive messages.	 | Timed out waiting for a response. |
| 32001 | 	 Internal error, caused by no new message IDs being available.	 | No new message ID available |
| 32002 | 	Client timed out while waiting to write messages to the server.	 | Timed out at writing. |
| 32100 | 	The client is already connected.	 | Already connected. |
| 32101 | 	The client is already disconnected.	 | Already disconnected. |
| 32102 | 	The client is currently disconnecting and cannot accept any new work. This can occur when waiting on a token, and then disconnecting the client.	 | Currently disconnecting. |
| 32103 | 	Unable to connect to server.	 | Unable to connect to server. |
| 32104 | 	The client is not connected to the server. The Connect... method must be called first. It is also possible that the connection was lost.	 | Not connected. |
| 32105 | 	Server URI and supplied SocketFactory do not match. URIs beginning "tcp://" must use a javax.net.SocketFactory, and URIs beginning "ssl://" must use a javax.net.ssl.SSLSocketFactory. This error cannot occur due to the implementation of the wrapper.	 | URI and SocketFactory do not match. |
| 32106 | 	SSL configuration error.	 | SSL configuration error. |
| 32107 | 	Disconnect called within the MessageReceived event. This method is called by the client thread and must not be used to control disconnection.	 | Disconnecting not allowed. |
| 32108 | 	Protocol error: the message was not recognized as a valid MQTT packet. Possible reasons for this include connecting to a non-MQTT server, or connecting to an SSL server port when the client isn't using SSL.	 | Unrecognized packet. |
| 32109 | 	The client has been unexpectedly disconnected from the server.	 | Connection lost. |
| 32110 | 	A connect operation in already in progress, only one connect can happen at a time. This error cannot occur due to the implementation of the wrapper.	 | A connect already in progress. |
| 32111 | 	 The client is closed - no operations are permitted on the client in this state. This error cannot occur due to the implementation of the wrapper.	 | The client is closed. |
| 32201 | 	A request has been made to use a token that is already associated with another action. This error cannot occur due to the implementation of the wrapper.	 | Token already in use. |
| 32202 | 	A request has been made to send a message but the maximum number of inflight  messages has already been reached.	 | Too many publishes in progress. |
| 32300 | 	The current state does not allow the desired action. Connection establishment: The state must be Disconnected (Code 0) or ConnectionAborted (Code 4). Sending (Subscribe, Unsubscribe, Publish...): The state must be Connected (Code 2).	 | Invalid State. |
| 32301 | 	The specified topic is empty. With ConnectWithLastWill, Subscribe, Unsubscribe, Publish... the specification of a topic is mandatory.	 | Empty topic. |
| 32302 | 	PublishBinary method: The specified string cannot be converted into binary format. See instructions in the Binary Data section.	 | Invalid binary code. |
| 32303 | 	PublishByteArray method: The ByteArray argument is not of the byte array type (byte[ ]).	 | Not a byte array. |
| 32304 | 	Connect... method: Invalid connection data.	 | Invalid connection parameters. |
| 32305 | 	FromDictionary method: The specified Dictionary does not contain all required fields.	 | Invalid dictionary content. |
| 32306 | 	Connect... method: The file specified for TruststoreFile cannot be loaded.	 | Cannot load truststore file. |
| 32307 | 	Connect... method: The file specified for TrustedCertFile cannot be loaded.	 | Cannot load trusted certificate file. |
| 32308 | 	Connect... method: The file specified for ClientCertFile oder ClientKeyFile cannot be loaded.	 | Cannot load client certificate file or key file. |
| 32309 | 	Connect... method: The file specified for ClientKeystoreFile cannot be loaded.	 | Cannot load client keystore file. |





## MQTT服务质量（QoS）：3个等级

1. QoS0：最低质量等级，最多发送一次消息，在消息发出后，接收者不会发送应答，发送者也不会重发消息，消息可能送达一次、也可能根本没送达。常用于不重要的消息传递，允许消息丢失。
1. QoS1：中等质量等级，最少发送一次消息，消息至少需要送达一次，也可能送达多次，需要接收者返回应答。
1. QoS2：高等质量等级，消息丢失和重复都是不被允许的，要保证此质量等级会有额外的开销，一般用于安全性、可靠性要求高的场景，比如支付。

## 保留消息（RetainFlag）

* 保留消息定义：如果PUBLISH消息的RETAIN标记位被设置为1，则称该消息为“保留消息”。

* Broker对保留消息的处理：Broker会存储每个Topic的最后一条保留消息及其Qos，当订阅该Topic的客户端上线后，Broker需要将该消息投递给它。

* 保留消息作用：可以让新订阅的客户端得到发布方的最新的状态值，而不必要等待发送。

* 保留消息的删除：
  * 方式1：发送空消息体的保留消息；
  * 方式2：发送最新的保留消息覆盖之前的（推荐）；

## 发送消息（发布）

发送消息有三种方法。

| ![mqtt](mqtt/publishex.png)  |  <u>默认发布方式</u><br/><br/>**Topic**: 消息主题。<br/>**Message**: 消息字符串。<br/>**RetainFlag**: 消息是否为保留消息。<br/>**QoS**: 发布消息的服务质量。  |
| ![mqtt](mqtt/publish.png)   | <u>简单发布</u><br/><br/>**Topic**: 消息主题。<br/>**Message**: 消息字符串。<br/>**RetainFlag**: 在内部设置为 false，QoS 为 0。  |
| ![mqtt](mqtt/publishbin.png)  | <u>发布二进制消息</u><br/><br/>**Topic**: 消息主题。<br/>**BinaryMessage**: 编码为字符串的二进制值。<br/>**RetainFlag**: 消息是否为保留消息。<br/>**QoS**: 发布消息的服务质量。  |


***
官方英文原版文档[点此](https://ullisroboterseite.de/android-AI2-PahoMQTT-en.html)。