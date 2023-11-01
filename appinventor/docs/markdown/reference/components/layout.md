---
layout: documentation
title: 界面布局组件
description: 界面布局组件参考文档：包括水平布局、水平滚动条布局、表格布局、垂直布局、垂直滚动条布局。
---

* TOC
{:toc}

[&laquo; 返回首页](index.html)
# <i class="mdi mdi-layers-outline"></i>  界面布局组件

目录：

1. ![icon](images/HorizontalArrangement.png)  [水平布局](#HorizontalArrangement)
1. ![icon](images/HorizontalScrollArrangement.png)  [水平滚动条布局](#HorizontalScrollArrangement)
1. ![icon](images/TableArrangement.png)  [表格布局](#TableArrangement)
1. ![icon](images/VerticalArrangement.png)  [垂直布局](#VerticalArrangement)
1. ![icon](images/VerticalScrollArrangement.png)  [垂直滚动条布局](#VerticalScrollArrangement)

## ![icon](images/HorizontalArrangement.png)  水平布局  {#HorizontalArrangement}

  使用水平布局组件来展示一组从左到右排列的组件，你可以在其中从左到右放置应该显示的组件。如果你想让组件显示在另一个上面，使用 [`垂直布局`](#VerticalArrangement) 代替。
 
  在`水平布局`中，组件沿水平轴排列，垂直居中对齐。

  * 如果`水平布局`的 [`高度`](#HorizontalArrangement.Height) 属性设置为`自动`，则实际布局的高度由布局中 未设置[`高度`](#HorizontalArrangement.Height) 属性为`填充父级`的最高的组件决定。 
  
  * 如果`水平布局`的 [`高度`](#HorizontalArrangement.Height) 属性设置为 `自动`，并且它仅包含 `高度`属性设置为`填充父级` 的组件，布局的实际高度是使用组件的自动高度计算的。
  
  * 如果`水平布局`的 [`高度`](#HorizontalArrangement.Height) 属性设置为`自动`且其中没有任何组件，则 [`高度`](#HorizontalArrangement.Height) 将是 100%。

  * 如果`水平布局`的 [`宽度`](#HorizontalArrangement.Width) 属性设置为`自动`，则实际布局的宽度由组件的宽度之和确定。 
  
  * **如果一个 `水平布局` 的 [`宽度`](#HorizontalArrangement.Width) 属性设置为 `自动`，任何组件[`宽度`](#HorizontalArrangement.Width) 属性设置为`填充父级`的，就类似它们自己的宽度设为`自动`。**

  * 如果`水平布局`的 [`宽度`](#HorizontalArrangement.Width) 属性设置为`填充父级`，将占用其他组件未占用的宽度。

### 属性  {#HorizontalArrangement-Properties}

{:.properties}

{:id="HorizontalArrangement.AlignHorizontal" .number} *水平对齐*
: 一个数字，用于表示`水平布局`的内容如何水平对齐。选择分别是：

  `1` （左对齐）
  
  `2` （右对齐）
  
  `3` （水平居中）
  
  如果`水平布局`的[`宽度`](#HorizontalArrangement.Width)是`自动`，则对齐方式无效。

{:id="HorizontalArrangement.AlignVertical" .number} *垂直对齐*
: 一个数字，用于表示`水平布局`的内容如何垂直对齐。 选择分别是：

  `1` （顶部对齐）
  
  `2` （垂直居中）
  
  `3` （底部对齐）

  如果`水平布局`的[`高度`](#HorizontalArrangement.Height)是`自动`，则对齐方式无效。

{:id="HorizontalArrangement.BackgroundColor" .color} *背景颜色*
: 设置`水平布局`的背景颜色，使用RGBA数值表示，如果设置了[`图像`](#HorizontalArrangement.Image)属性，则不能显示背景颜色直到删除[`图像`](#HorizontalArrangement.Image)属性为止。

{:id="HorizontalArrangement.Height" .number .bo} *高度*
: 设置`水平布局`的垂直高度，以像素px为单位。

{:id="HorizontalArrangement.HeightPercent" .number .wo .bo} *高度百分比*
: 设置`水平布局`的垂直高度相对于整个[`屏幕高度`](userinterface.html#Screen.Height)的百分比。

{:id="HorizontalArrangement.Image" .text} *图像*
: 设置`水平布局`背景图片路径。

{:id="HorizontalArrangement.Visible" .boolean} *可见性*
: 设置`水平布局`是否显示在屏幕上，值是`真`{:.logic.block}则`水平布局`显示，`假`{:.logic.block}则隐藏。

{:id="HorizontalArrangement.Width" .number .bo} *宽度*
: 设置`水平布局`的水平宽度，以像素px为单位。

{:id="HorizontalArrangement.WidthPercent" .number .wo .bo} *宽度百分比*
: 设置`水平布局`的水平宽度相对于[`屏幕宽度`](userinterface.html#Screen.Width)的百分比。

### 事件  {#HorizontalArrangement-Events}

{:.events}
无


### 方法  {#HorizontalArrangement-Methods}

{:.methods}
无

## ![icon](images/HorizontalScrollArrangement.png)  水平滚动条布局  {#HorizontalScrollArrangement}

一个格式化元素、用于放置应从左到右显示的组件。

如果你希望组件一个一个地显示，请使用 [`垂直滚动条布局`](#VerticalScrollArrangement)。

这个版本是可滚动的。

### 属性  {#HorizontalScrollArrangement-Properties}

{:.properties}

{:id="HorizontalScrollArrangement.AlignHorizontal" .number} *水平对齐*
: 一个数字，用于表示`水平滚动条布局`的内容如何水平对齐。选择分别是：

  `1` （左对齐）
  
  `2` （右对齐）
  
  `3` （水平居中）
  
  如果`水平滚动条布局`的[`宽度`](#HorizontalScrollArrangement.Width)是`自动`，则对齐方式无效。

{:id="HorizontalScrollArrangement.AlignVertical" .number} *垂直对齐*
: 一个数字，用于表示`水平滚动条布局`的内容如何垂直对齐。 选择分别是：

  `1` （顶部对齐）
  
  `2` （垂直居中）
  
  `3` （底部对齐）

  如果`水平滚动条布局`的[`高度`](#HorizontalScrollArrangement.Height)是`自动`，则对齐方式无效。

{:id="HorizontalScrollArrangement.BackgroundColor" .color} *背景颜色*
: 设置`水平布局`的背景颜色，使用RGBA数值表示，如果设置了[`图像`](#HorizontalScrollArrangement.Image)属性，则不能显示背景颜色直到删除[`图像`](#HorizontalScrollArrangement.Image)属性为止。

{:id="HorizontalScrollArrangement.Height" .number .bo} *高度*
: 设置`水平滚动条布局`的垂直高度，以像素px为单位。

{:id="HorizontalScrollArrangement.HeightPercent" .number .wo .bo} *高度百分比*
: 设置`水平滚动条布局`的垂直高度相对于整个[`屏幕高度`](userinterface.html#Screen.Height)的百分比。

{:id="HorizontalScrollArrangement.Image" .text} *图像*
: 设置`水平滚动条布局`背景图片路径。

{:id="HorizontalScrollArrangement.Visible" .boolean} *可见性*
: 设置`水平滚动条布局`是否显示在屏幕上，值是`真`{:.logic.block}则`水平滚动条布局`显示，`假`{:.logic.block}则隐藏。

{:id="HorizontalScrollArrangement.Width" .number .bo} *宽度*
: 设置`水平滚动条布局`的水平宽度，以像素px为单位。

{:id="HorizontalScrollArrangement.WidthPercent" .number .wo .bo} *宽度百分比*
: 设置`水平滚动条布局`的水平宽度相对于[`屏幕宽度`](userinterface.html#Screen.Width)的百分比。

### 事件  {#HorizontalScrollArrangement-Events}

{:.events}
无


### 方法  {#HorizontalScrollArrangement-Methods}

{:.methods}
无

## ![icon](images/TableArrangement.png)  表格布局  {#TableArrangement}

  使用表格排列组件，以表格方式显示一组组件。

  * 该组件是一个格式化元素，你可以以表格形式在其中放置需要显示的组件。

  * 在`表格布局`中，组件排列在行和列的网格中，每个单元格中可见的组件不超过一个。**如果多个组件占据同一个单元格，则只有最后一个可见。**

  * 在每一行中，组件垂直居中对齐。
  
  * 列的宽度由该列中最宽的组件确定。 计算列宽时，自动宽度用于 [`宽度`](#TableArrangement.Width) 属性设置为 `填充父级` 的组件。**但是，每个组件将始终填充其占据的列的整个宽度。**

  * 行的高度由该行中[`高度`](#TableArrangement.Height) 属性未设置为 `填充父级`的最高的组件决定。如果行仅包含 [`高度`](#TableArrangement.Height) 属性设置为 `填充父级` 的组件，则使用组件的自动高度计算行的高度。

### 属性  {#TableArrangement-Properties}

{:.properties}

{:id="TableArrangement.Columns" .number .do} *列数*
: 确定表中的列数。

{:id="TableArrangement.Height" .number .bo} *高度*
: 设置`表格布局`的垂直高度，以像素px为单位。

{:id="TableArrangement.HeightPercent" .number .wo .bo} *高度百分比*
: 设置`表格布局`的垂直高度相对于整个[`屏幕高度`](userinterface.html#Screen.Height)的百分比。

{:id="TableArrangement.Rows" .number .do} *行数*
: 确定表中的行数。

{:id="TableArrangement.Visible" .boolean} *可见性*
: 设置`表格布局`是否显示在屏幕上，值是`真`{:.logic.block}则`表格布局`显示，`假`{:.logic.block}则隐藏。

{:id="TableArrangement.Width" .number .bo} *宽度*
: 设置`表格布局`的水平宽度，以像素px为单位。

{:id="TableArrangement.WidthPercent" .number .wo .bo} *宽度百分比*
: 设置`表格布局`的水平宽度相对于[`屏幕宽度`](userinterface.html#Screen.Width)的百分比。

### 事件  {#TableArrangement-Events}

{:.events}
无


### 方法  {#TableArrangement-Methods}

{:.methods}
无

## ![icon](images/VerticalArrangement.png)  垂直布局  {#VerticalArrangement}

  使用垂直布局组件来显示一组从上到下、左对齐的组件。该组件是一种格式设置元素，你可以在其中放置应逐个显示的组件。 第一个子组件存储在顶部，第二个子组件存储在其下面，依此类推。
  如果你希望组件彼此相邻显示，请使用 [`水平布局`](#HorizontalArrangement)。
 
  在`垂直布局`中，组件沿垂直轴左对齐排列。

  * 如果`垂直布局`的 [`宽度`](#VerticalArrangement.Width) 属性设置为`自动`，则实际布局的宽度由布局中 未设置[`宽度`](#VerticalArrangement.Width) 属性为`填充父级`的最宽的组件决定。 
  
  * 如果`垂直布局`的 [`宽度`](#VerticalArrangement.Width) 属性设置为 `自动`，并且它仅包含 `宽度`属性设置为`填充父级` 的组件，布局的实际宽度是使用组件的自动宽度计算的。
  
  * 如果`垂直布局`的 [`宽度`](#VerticalArrangement.Width) 属性设置为`自动`且其中没有任何组件，则 [`宽度`](#VerticalArrangement.Width) 将是 100%。

  * 如果`垂直布局`的 [`高度`](#VerticalArrangement.Height) 属性设置为`自动`，则实际布局的高度由组件的高度之和确定。 
  
  * **如果一个 `垂直布局` 的 [`高度`](#VerticalArrangement.Height) 属性设置为 `自动`，任何组件[`高度`](#VerticalArrangement.Width) 属性设置为`填充父级`的，就类似它们自己的高度设为`自动`。**

  * 如果`垂直布局`的 [`高度`](#VerticalArrangement.Height) 属性设置为`填充父级`，将占用其他组件未占用的高度。

### 属性  {#VerticalArrangement-Properties}

{:.properties}

{:id="VerticalArrangement.AlignHorizontal" .number} *水平对齐*
: 一个数字，用于表示`垂直布局`的内容如何水平对齐。选择分别是：

  `1` （左对齐）
  
  `2` （右对齐）
  
  `3` （水平居中）
  
  如果`垂直布局`的[`宽度`](#VerticalArrangement.Width)是`自动`，则对齐方式无效。

{:id="VerticalArrangement.AlignVertical" .number} *垂直对齐*
: 一个数字，用于表示`垂直布局`的内容如何垂直对齐。 选择分别是：

  `1` （顶部对齐）
  
  `2` （垂直居中）
  
  `3` （底部对齐）

  如果`垂直布局`的[`高度`](#VerticalArrangement.Height)是`自动`，则对齐方式无效。

{:id="VerticalArrangement.BackgroundColor" .color} *背景颜色*
: 设置`垂直布局`的背景颜色，使用RGBA数值表示，如果设置了[`图像`](#VerticalArrangement.Image)属性，则不能显示背景颜色直到删除[`图像`](#VerticalArrangement.Image)属性为止。

{:id="VerticalArrangement.Height" .number .bo} *高度*
: 设置`垂直布局`的垂直高度，以像素px为单位。

{:id="VerticalArrangement.HeightPercent" .number .wo .bo} *高度百分比*
: 设置`垂直布局`的垂直高度相对于整个[`屏幕高度`](userinterface.html#Screen.Height)的百分比。

{:id="VerticalArrangement.Image" .text} *图像*
: 设置`垂直布局`背景图片路径。

{:id="VerticalArrangement.Visible" .boolean} *可见性*
: 设置`垂直布局`是否显示在屏幕上，值是`真`{:.logic.block}则`垂直布局`显示，`假`{:.logic.block}则隐藏。

{:id="VerticalArrangement.Width" .number .bo} *宽度*
: 设置`垂直布局`的水平宽度，以像素px为单位。

{:id="VerticalArrangement.WidthPercent" .number .wo .bo} *宽度百分比*
: 设置`垂直布局`的水平宽度相对于[`屏幕宽度`](userinterface.html#Screen.Width)的百分比。

### 事件  {#VerticalArrangement-Events}

{:.events}
无


### 方法  {#VerticalArrangement-Methods}

{:.methods}
无

## ![icon](images/VerticalScrollArrangement.png)  垂直滚动条布局  {#VerticalScrollArrangement}

  一种格式元素，用于放置应逐个显示的组件。（第一个子组件在顶部，第二个子组件在其下面，依此类推）
  
  如果希望相邻显示的组件，请改用 [`水平滚动条布局`](#HorizontalScrollArrangement)。
  
  这个组件是可滚动的。

### 属性  {#VerticalScrollArrangement-Properties}

{:.properties}

{:id="VerticalScrollArrangement.AlignHorizontal" .number} *水平对齐*
: 一个数字，用于表示`垂直滚动条布局`的内容如何水平对齐。选择分别是：

  `1` （左对齐）
  
  `2` （右对齐）
  
  `3` （水平居中）
  
  如果`垂直滚动条布局`的[`宽度`](#VerticalScrollArrangement.Width)是`自动`，则对齐方式无效。

{:id="VerticalScrollArrangement.AlignVertical" .number} *垂直对齐*
: 一个数字，用于表示`垂直滚动条布局`的内容如何垂直对齐。 选择分别是：

  `1` （顶部对齐）
  
  `2` （垂直居中）
  
  `3` （底部对齐）

  如果`垂直滚动条布局`的[`高度`](#VerticalScrollArrangement.Height)是`自动`，则对齐方式无效。

{:id="VerticalScrollArrangement.BackgroundColor" .color} *背景颜色*
: 设置`垂直滚动条布局`的背景颜色，使用RGBA数值表示，如果设置了[`图像`](#VerticalScrollArrangement.Image)属性，则不能显示背景颜色直到删除[`图像`](#VerticalScrollArrangement.Image)属性为止。

{:id="VerticalScrollArrangement.Height" .number .bo} *高度*
: 设置`垂直滚动条布局`的垂直高度，以像素px为单位。

{:id="VerticalScrollArrangement.HeightPercent" .number .wo .bo} *高度百分比*
: 设置`垂直滚动条布局`的垂直高度相对于整个[`屏幕高度`](userinterface.html#Screen.Height)的百分比。

{:id="VerticalScrollArrangement.Image" .text} *图像*
: 设置`垂直滚动条布局`背景图片路径。

{:id="VerticalScrollArrangement.Visible" .boolean} *可见性*
: 设置`垂直滚动条布局`是否显示在屏幕上，值是`真`{:.logic.block}则`垂直滚动条布局`显示，`假`{:.logic.block}则隐藏。

{:id="VerticalScrollArrangement.Width" .number .bo} *宽度*
: 设置`垂直滚动条布局`的水平宽度，以像素px为单位。

{:id="VerticalScrollArrangement.WidthPercent" .number .wo .bo} *宽度百分比*
: 设置`垂直滚动条布局`的水平宽度相对于[`屏幕宽度`](userinterface.html#Screen.Width)的百分比。

### 事件  {#VerticalScrollArrangement-Events}

{:.events}
无


### 方法  {#VerticalScrollArrangement-Methods}

{:.methods}
无

