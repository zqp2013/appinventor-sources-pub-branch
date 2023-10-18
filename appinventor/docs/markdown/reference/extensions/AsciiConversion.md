---
title: App Inventor 2 AsciiConversion 拓展，ASCII编码与解码，Ascii码转换
layout: documentation
description: App Inventor 2 AsciiConversion 拓展，将 Ascii 代码(列表)转换为相应的文本，也可以将指定的字符转换为相应的 Ascii 代码。ASCII编码与解码,ascii转换,ascii码转换。
---

* TOC
{:toc}

[&laquo; 返回首页](index.html)

## <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAIAAACQkWg2AAAACXBIWXMAAAsSAAALEgHS3X78AAAA1klEQVR42mP4/5+BJESa6oHS8OMHG4Tx6RMPPg2bNnlPm5Z+7Zp6UtLsvXsd9uxxrKpqWbEidOHC2KlTM75940DXkJw8y8Nj67Fj5rm5Ezs7S0pKOoGCN26oFhd3FRb2fP7MhaLh7l2F8vK2rq6Sjo7SlpbKurr6ZcvCgeS8efETJ+YARb584UTR8PUr1MYvX7hu31b++ZMVyH70SObvX0agl75/Z//3b0jFAyENrxj+32b4/57h/3OG/y8Y/r9k+P8dvwagoksM/x8w/L8B1gkk31HVSQDpTO7uYTqjvQAAAABJRU5ErkJggg==" style="margin:-4px 5px 0 0">AsciiConversion [*拓展*](https://community.appinventor.mit.edu/t/ascii-conversion-extension/80973)  {#AsciiConversion}

* .aix 拓展下载：

{:.vip}
[AsciiConversion.aix](AsciiConversion/AsciiConversion.aix)

* demo程序下载：

{:.vip}
[test_AsciiConversion.aia](AsciiConversion/test_AsciiConversion.aia)

**此扩展允许用户将 Ascii 代码(列表)转换为相应的文本，也可以将指定的字符转换为相应的 Ascii 代码。**

此扩展提供 3个 函数：

***
### **AsciiCode**: 给出字符，返回它相应的 Ascii码。

![](AsciiConversion/1.png)

用法示例：返回字符“A”的Ascii码，结果将是：65。

![](AsciiConversion/2.png)

***
### **GiveCharacter**: 给出 Ascii码，返回它相应的字符。

![](AsciiConversion/3.png)

用法示例：返回Ascii码 48 的字符，结果将是字符：“0”。

![](AsciiConversion/4.png)

***
### **Conversion**: 给出 Ascii码列表，转换后返回相应的文本。

![](AsciiConversion/5.png)

当您使用UART蓝牙接收数据时，此功能非常有用，因为UART接收到的数据是包含Ascii码的列表，必须将其转换为相应的文本。

用法示例1：

![](AsciiConversion/6.png)

该块将在标签1 中写入文本：“A03”，这是 Ascii 码表列表 [65,48,51] 转换后得到的文本。

用法示例2：: with Bluetooth UART

![](AsciiConversion/7.png)

UART_TX_Field：是包含接收到的字符的 Ascii 代码的列表。

如果 UART_TX_Field 是以下列表： [51,48] ，则最后一个块将在 label_Temperature 中写入文本：“30”。详见：[test_AsciiConversion.aia](AsciiConversion/test_AsciiConversion.aia)


***
附：Ascii表一览

![](../blocks/images/text/ascii.png)
