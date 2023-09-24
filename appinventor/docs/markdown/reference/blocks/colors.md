---
title: App Inventor 2 颜色代码块
layout: documentation
description: 颜色代码块参考文档：包括基本颜色、合成颜色、分解颜色。
---

* TOC
{:toc}

颜色代码块主要分为三种类型：

* [基本颜色](#basic)
* [合成颜色](#make)
* [分解颜色](#split)

***
### App Inventor 中的颜色如何发挥作用？

在内部，App Inventor 将每种颜色存储为单个数字。 当你使用`合成颜色`{:.color.block} 并接受一个列表作为参数时，该列表会在内部使用 App Inventor 的配色方案进行转换并存储为数字。 如果你知道颜色的数字，你甚至可以通过将其 Color 属性设置为特定数字来指定你想要的颜色。 如果你想查看颜色与数字的图表，请查看[此页面](http://appinventor.mit.edu/explore/app-inventor-color-chart)。

***
### 基本颜色   {#basic}

![](images/colors/basiccolorblock.png)

这是一个基本色块。 它有一个小正方形形状，中间有一个颜色，代表该块内部存储的颜色。

如果单击中间的颜色，屏幕上会出现一个弹出窗口，其中包含 70 种颜色可供选择。 单击新颜色将更改基本色块的当前颜色。

![](images/colors/colorblock.gif)

从“颜色”面板拖到“代码视图”的每个基本颜色块在单击时都会显示具有相同颜色的表格。

***
### 合成颜色   {#make}

![](images/colors/makecolor.png)

`合成颜色`{:.color.block} 接受 3 或 4 个数字的列表。 此列表中的这些数字表示 RGB 代码中的值。 RGB 代码用于在互联网上生成颜色。 RGB 颜色图表可在[此处](https://sites.google.com/view/metricrat-ai2/scraps/android-and-html-colour-codes)获得。 该列表中的第一个数字代表代码的 R 值，第二个代表 G，第三个代表 B，第四个值是可选的，代表 alpha 值或颜色的饱和度。 默认 alpha 值为 100。尝试不同的值并查看使用此块的颜色如何变化。

***
### 分解颜色   {#split}

![](images/colors/splitcolor.png)

`分解颜色`{:.color.block} 与 `合成颜色`{:.color.block} 相反。 它接受颜色、颜色块、保存颜色的变量或表示颜色的组件之一的属性，并返回该颜色的 RGB 代码中的 R,G,B 值列表。
