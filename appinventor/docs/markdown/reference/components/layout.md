---
layout: documentation
title: 界面布局组件
description: 界面布局组件参考文档：包括水平布局、水平滚动条布局、表格布局、垂直布局、垂直滚动条布局。
---

[&laquo; 返回首页](index.html)
# <i class="mdi mdi-view-split-horizontal"/>&nbsp;&nbsp;界面布局组件

目录：

* [水平布局](#HorizontalArrangement)
* [水平滚动条布局](#HorizontalScrollArrangement)
* [表格布局](#TableArrangement)
* [垂直布局](#VerticalArrangement)
* [垂直滚动条布局](#VerticalScrollArrangement)

***
## 水平布局  {#HorizontalArrangement}

![HorizontalArrangement icon](images/horizontalarrangement.png)

 使用水平布局组件来展示一组从左到右排列的组件，你可以在其中从左到右放置应该显示的组件。如果你想让组件显示在另一个上面，使用 [`垂直布局`](#VerticalArrangement) 代替。
 
 在`水平布局`中，组件沿水平轴排列，垂直居中对齐。

 If a `水平布局`'s [`Height`](#HorizontalArrangement.Height) property is set to `Automatic`, the actual
 height of the arrangement is determined by the tallest component in the arrangement whose
 [`Height`](#HorizontalArrangement.Height) property is not set to `Fill Parent`. If a `HorizontalArrangment`'s
 [`Height`](#HorizontalArrangement.Height) property is set to `Automatic` and it contains only components whose `Height`
 properties are set to `Fill Parent`, the actual height of the arrangement is calculated using
 the automatic heights of the components. If a `水平布局`'s [`Height`](#HorizontalArrangement.Height)
 property is set to `Automatic` and it is empty, the [`Height`](#HorizontalArrangement.Height) will be 100.

 If a `水平布局`'s [`Width`](#HorizontalArrangement.Width) property is set to `Automatic`, the actual width
 of the arrangement is determined by the sum of the widths of the components. **If a
 `水平布局`'s [`Width`](#HorizontalArrangement.Width) property is set to `Automatic`, any components whose
 [`Width`](#HorizontalArrangement.Width) properties are set to `Fill Parent` will behave as if they were set to
 `Automatic`.**

 If a `水平布局`'s [`Width`](#HorizontalArrangement.Width) properties are set to `Fill Parent` will equally
 take up the width not occupied by other components.



### 属性  {#HorizontalArrangement-Properties}

{:.properties}

{:id="HorizontalArrangement.AlignHorizontal" .number} *AlignHorizontal*
: A number that encodes how contents of the `水平布局` are aligned horizontally. The choices
 are: `1` = left aligned, `2` = right aligned, `3` = horizontally centered. Alignment has no
 effect if the `水平布局`'s [`Width`](#HorizontalArrangement.Width) is `Automatic`.

{:id="HorizontalArrangement.AlignVertical" .number} *AlignVertical*
: A number that encodes how the contents of the `水平布局` are aligned vertically. The choices
 are: `1` = aligned at the top, `2` = vertically centered, `3` = aligned at the bottom.
 Alignment has no effect if the `水平布局`'s [`Height`](#HorizontalArrangement.Height) is `Automatic`.

{:id="HorizontalArrangement.BackgroundColor" .color} *BackgroundColor*
: Specifies the background color of the HorizontalArrangement as an alpha-red-green-blue
 integer.  If an Image has been set, the color change will not be visible
 until the Image is removed.

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

***
## 水平滚动条布局  {#HorizontalScrollArrangement}

A formatting element in which to place components that should be displayed from left to right.
 If you wish to have components displayed one over another, use [`VerticalScrollArrangement`](#VerticalScrollArrangement)
 instead.

 This version is scrollable.



### 属性  {#HorizontalScrollArrangement-Properties}

{:.properties}

{:id="HorizontalScrollArrangement.AlignHorizontal" .number} *AlignHorizontal*
: A number that encodes how contents of the `水平滚动条布局` are aligned horizontally. The choices
 are: `1` = left aligned, `2` = right aligned, `3` = horizontally centered. Alignment has no
 effect if the `水平滚动条布局`'s [`Width`](#HorizontalScrollArrangement.Width) is `Automatic`.

{:id="HorizontalScrollArrangement.AlignVertical" .number} *AlignVertical*
: A number that encodes how the contents of the `HorizontalScrollArrangement` are aligned vertically. The choices
 are: `1` = aligned at the top, `2` = vertically centered, `3` = aligned at the bottom.
 Alignment has no effect if the `水平滚动条布局`'s [`Height`](#HorizontalScrollArrangement.Height) is `Automatic`.

{:id="HorizontalScrollArrangement.BackgroundColor" .color} *BackgroundColor*
: Specifies the background color of the HorizontalScrollArrangement as an alpha-red-green-blue
 integer.  If an Image has been set, the color change will not be visible
 until the Image is removed.

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

***
## 表格布局  {#TableArrangement}

Use a table arrangement component to display a group of components in a tabular fashion.

 This component is a formatting element in which you place components that should be displayed
 in tabular form.

 In a `TableArrangement`, components are arranged in a grid of rows and columns, with not more
 than one component visible in each cell. **If multiple components occupy the same cell, only the
 last one will be visible.**

 Within each row, components are vertically center-aligned.

 The width of a column is determined by the widest component in that column. When calculating
 column width, the automatic width is used for components whose [`Width`](#TableArrangement.Width) property is set
 to `Fill Parent`. **However, each component will always fill the full width of the column that it
 occupies.**

 The height of a row is determined by the tallest component in that row whose [`Height`](#TableArrangement.Height)
 property is not set to `Fill Parent`. If a row contains only components whose [`Height`](#TableArrangement.Height)
 properties are set to `Fill Parent`, the height of the row is calculated using the automatic
 heights of the components.



### 属性  {#TableArrangement-Properties}

{:.properties}

{:id="TableArrangement.Columns" .number .do} *Columns*
: Determines the number of columns in the table.

{:id="TableArrangement.Height" .number .bo} *高度*
: 设置`表格布局`的垂直高度，以像素px为单位。

{:id="TableArrangement.HeightPercent" .number .wo .bo} *高度百分比*
: 设置`表格布局`的垂直高度相对于整个[`屏幕高度`](userinterface.html#Screen.Height)的百分比。

{:id="TableArrangement.Rows" .number .do} *Rows*
: Determines the number of rows in the table.

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

***
## 垂直布局  {#VerticalArrangement}

![VerticalArrangement icon](images/verticalarrangement.png)

 Use a `VerticalArrangement` component to display a group of components laid out from top to
 bottom, left-aligned.

 This component is a formatting element in which you place components that should be displayed
 one below another. The first child component is stored on top, the second beneath it, and so on.
 If you want to have components displayed next to one another, use [`HorizontalArrangement`](#HorizontalArrangement)
 instead.

 In a `VerticalArrangement`, components are arranged along the vertical axis, left-aligned.

 If a `VerticalArrangement`'s [`Width`](#VerticalArrangement.Width) property is set to `Automatic`, the actual width
 of the arrangement is determined by the widest component in the arrangement whose
 [`Width`](#VerticalArrangement.Width) property is not set to `Fill Parent`. If a `VerticalArrangement`'s
 [`Width`](#VerticalArrangement.Width) property is set to `Automatic` and it contains only components whose
 [`Width`](#VerticalArrangement.Width) properties are set to `Fill Parent`, the actual width of the arrangement is
 calculated using the automatic widths of the components. If a `VerticalArrangement`'s
 [`Width`](#VerticalArrangement.Width) property is set to `Automatic` and it is empty, the width will be 100.

 If a `VerticalArrangement`'s [`Height`](#VerticalArrangement.Height) property is set to `Automatic`, the actual height
 of the arrangement is determined by the sum of the heights of the components. **If a
 `VerticalArrangement`'s [`Height`](#VerticalArrangement.Height) property is set to `Automatic`, any components whose
 `Height` properties are set to `Fill Parent` will behave as if they were set to `Automatic`.**

 If a `VerticalArrangement`'s [`Height`](#VerticalArrangement.Height) property is set to `Fill Parent` or specified in
 pixels, any components whose Height properties are set to `Fill Parent` will equally take up the
 height not occupied by other components.



### 属性  {#VerticalArrangement-Properties}

{:.properties}

{:id="VerticalArrangement.AlignHorizontal" .number} *AlignHorizontal*
: A number that encodes how contents of the `VerticalArrangement` are aligned horizontally. The choices
 are: `1` = left aligned, `2` = right aligned, `3` = horizontally centered. Alignment has no
 effect if the `VerticalArrangement`'s [`Width`](#VerticalArrangement.Width) is `Automatic`.

{:id="VerticalArrangement.AlignVertical" .number} *AlignVertical*
: A number that encodes how the contents of the `VerticalArrangement` are aligned vertically. The choices
 are: `1` = aligned at the top, `2` = vertically centered, `3` = aligned at the bottom.
 Alignment has no effect if the `VerticalArrangement`'s [`Height`](#VerticalArrangement.Height) is `Automatic`.

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

***
## 垂直滚动条布局  {#VerticalScrollArrangement}

A formatting element in which to place components that should be displayed one below another.
 (The first child component is stored on top, the second beneath it, etc.) If you wish to have
 components displayed next to one another, use [`HorizontalScrollArrangement`](#HorizontalScrollArrangement) instead.

 This version is scrollable.



### 属性  {#VerticalScrollArrangement-Properties}

{:.properties}

{:id="VerticalScrollArrangement.AlignHorizontal" .number} *AlignHorizontal*
: A number that encodes how contents of the `VerticalScrollArrangement` are aligned horizontally. The choices
 are: `1` = left aligned, `2` = right aligned, `3` = horizontally centered. Alignment has no
 effect if the `VerticalScrollArrangement`'s [`Width`](#VerticalScrollArrangement.Width) is `Automatic`.

{:id="VerticalScrollArrangement.AlignVertical" .number} *AlignVertical*
: A number that encodes how the contents of the `VerticalScrollArrangement` are aligned vertically. The choices
 are: `1` = aligned at the top, `2` = vertically centered, `3` = aligned at the bottom.
 Alignment has no effect if the `VerticalScrollArrangement`'s [`Height`](#VerticalScrollArrangement.Height) is `Automatic`.

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

