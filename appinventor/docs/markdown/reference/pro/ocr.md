---
title: App Inventor 2 OCR 图片文字识别全方案总结
layout: documentation
description: App Inventor 2 OCR 图片文字识别全方案总结，包括使用云api、OCR拓展、OCR开源库本地识别。
---

* TOC
{:toc}

[&laquo; 返回首页](index.html)

## 1、使用百度api进行识别

使用百度api，每日免费调用100次，超过的话是收费的。根据相关文档、使用`Web客户端`组件进行通信。这里只讨论技术方案，暂不提供具体的步骤及代码。

当然类似的api不光能识别文字，还能识别物品等，AI相关的功能几乎都能找到云端的解决方案，比较方便快捷，不过这类**api往往都是收费**的。

## 2、使用现有OCR拓展

网上找到了2款OCR拓展，不过测下来都是利用api进行云识别的封装，参考价值不大，有兴趣的可以研究一下。

### [> NMD OCR 官网](https://community.kodular.io/t/does-the-ocr-extension-support-jpg-format/138676)
<!--https://sourceforge.net/projects/released/files/-->

.aix 拓展下载：

[com.NMD.Ocr.aix.aix](ocr/com.NMD.Ocr.aix.aix)

demo 下载：

[OcrTestExample.aia.aia](ocr/OcrTestExample.aia.aia)


### [> OCRSpace 官网](https://community.appinventor.mit.edu/t/ocr-space-extension/63873)

.aix 拓展下载：

[OCRSpace.aix](ocr/OCRSpace.aix)

demo 下载：

[OCRSpace.aia](ocr/OCRSpace.aia)

## 3、Java开源库写拓展，实现本地OCR识别

因为文字识别比较常规，不像物品识别需要AI模型训练，文本识别有成熟的OCR开源库支持，直接就能本地识别不依赖云服务。

这时只能通过Java写拓展了，使用开源库 Tess4j，官网：[https://tess4j.sourceforge.net](https://tess4j.sourceforge.net)。

目前没有现成的相关拓展，需要自己去开发。

如果你需要代为开发本地OCR拓展，或如果你有写好的OCR本地拓展，均可页面右侧栏扫码添加客服进行洽谈~

> 参考：https://blog.csdn.net/qq_35132089/article/details/127450854
