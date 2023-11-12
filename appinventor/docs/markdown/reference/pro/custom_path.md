---
title: App Inventor 2 自定义拍照及录像媒体文件的路径，进行目录规整
layout: documentation
description: App Inventor 2 自定义拍照及录像媒体文件的路径，进行目录规整。包括拍照图片及录像视频的路径定制化。
---

* TOC
{:toc}

[&laquo; 返回首页](index.html)

## App Inventor 2 自定义拍照图片文件的路径

App Inventor 2 拍照后默认的照片路径是其私有目录下，且文件名格式固定。有时我们需要对图片路径及文件名进行个性化定制，并按照一定的逻辑进行规整。

App Inventor 2 原生并未提供路径及文件名的定制方法，只能做其他方式的考虑。

### 思路

拍照完成后的事件中，将照片文件拷贝到指定的个性化目录中，并使用指定的统一命名进行存放，使用`文件管理器`组件的相关方法。

### 处理拍照后的事件

### 将原图片拷贝到指定目录

### 为什么失败？

### 什么是ASD？

ASD(app specific directory)，即App特定目录。

关于Android存储路径更深入请参考《[Android存储系统基础知识：内部存储，外部存储，App特定目录ASD 及 getASD代码实现](../creative/asd.html)》。

拓展：可以考虑使用FileTools或TaifunFile拓展，里面函数直接封装了ASD的概念，提供更傻瓜式的函数供我们使用。

### 开始测试

### 同理，录像视频的定制方式也是一致的
