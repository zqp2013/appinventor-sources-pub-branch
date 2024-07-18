---
title: App Inventor 2 UrsPahoMqttClient 拓展 - 物联网轻量级MQTT协议
layout: documentation
description: App Inventor 2 UrsPahoMqttClient 拓展，MQTT协议，物联网设计的轻量级协议，基于TCP协议实现。
---

[&laquo; 返回首页](index.html)

最新版拓展下载：

{:.vip}
[de.ullisroboterseite.ursai2pahomqtt.aix](mqtt/de.ullisroboterseite.ursai2pahomqtt.aix)

<!--https://ullisroboterseite.de/android-AI2-PahoMQTT-en.html-->


## MQTT（Message Queuing Telemetry Transport：消息队列遥测传输）

MQTT 发明于 1999 年，为物联网设计的轻量级协议，基于`TCP`协议实现。

![mqtt](mqtt/model.jpg)

MQTT协议文档：[https://mqtt.org/](https://mqtt.org/)

<!--https://blog.csdn.net/INT_TANG/article/details/125834594-->



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

