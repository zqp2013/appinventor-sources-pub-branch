---
layout: documentation
title: 图表组件
description: 图表组件参考文档：包括图表、二维图表数据。
---

* TOC
{:toc}

[&laquo; 返回首页](index.html)
# <i class="mdi mdi-chart-line"></i>  图表组件

目录：

* [图表](#Chart)
* [二维图表数据](#ChartData2D)

***
## 图表  {#Chart}

图表组件用于绘制其附加数据（如[`二维图表数据`](#ChartData2D)组件）的组件。有五种不同的图表类型，包括折线图、面积图、散点图、条形图和饼图，可通过[`类型`](#Chart.Type) 属性修改。

图表组件有其他可以更改外观的属性，例如 [`描述`](#Chart.Description)、[`启用网格`](#Chart.GridEnabled)。


### 属性  {#Chart-Properties}

{:.properties}

{:id="Chart.BackgroundColor" .color} *背景颜色*
: 设置`图表`的背景颜色，使用RGBA数值表示。

{:id="Chart.Description" .text} *描述*
: 指定图表内描述标签显示的文本。指定空字符串 ("") 将不会显示标签。

{:id="Chart.GridEnabled" .boolean} *启用网格*
: 更改图表网格的可见性，如果图表类型设置为带轴的图表（适用于面积图、条形图、折线图、散点图类型，*饼图不适用*）。

{:id="Chart.Height" .number .bo} *高度*
: 设置`图表`的垂直高度，以像素px为单位。

{:id="Chart.HeightPercent" .number .wo .bo} *高度百分比*
: 设置`图表`的垂直高度相对于整个[`屏幕高度`](userinterface.html#Screen.Height)的百分比。

{:id="Chart.Labels" .list .bo} *标签列表*
: 将图表的 x 轴标签更改为指定的列表，如果图表类型设置为带轴图表。

  列表的第一个条目对应于数据的最小 x 值，第二个为最小 x 值 + 1，依此类推。

  如果没有为 x 值指定标签，则使用默认值使用（该位置的轴刻度的 x 值）。

{:id="Chart.LabelsFromString" .text .wo .do} *CSV字符串标签*
: 指定要设置到图表 x 轴的标签，如果当前是一个带有 x 轴的图表。

  标签被指定为逗号分隔（CSV格式）的值字符串，类似的用法参考[`标签列表`](#Chart.Labels)。

{:id="Chart.LegendEnabled" .boolean} *启用图例*
: 更改图表图例的可见性。

{:id="Chart.PieRadius" .number .wo .do} *饼图半径*
: 设置图表的饼图半径，如果当前类型是不是饼图，该值则没有效果。

{:id="Chart.Type" .com.google.appinventor.components.common.ChartTypeEnum .do} *类型*
: 指定图表的类型，它决定如何可视化数据。

{:id="Chart.Visible" .boolean} *可见性*
: 设置`图表`是否显示在屏幕上，值是`真`{:.logic.block}则`图表`显示，`假`{:.logic.block}则隐藏。

{:id="Chart.Width" .number .bo} *宽度*
: 设置`图表`的水平宽度，以像素px为单位。

{:id="Chart.WidthPercent" .number .wo .bo} *宽度百分比*
: 设置`图表`的水平宽度相对于[`屏幕宽度`](userinterface.html#Screen.Width)的百分比。

### 事件  {#Chart-Events}

{:.events}

{:id="Chart.EntryClick"} 数据点被点击时(*数据序列*{:.component},*x坐标*{:.any},*y坐标*{:.number})
: 指示用户单击`图表`中的数据点，返回指定点的 x轴 和 y轴值。

### 方法  {#Chart-Methods}

{:.methods}
无

***
## 二维图表数据  {#ChartData2D}

二维图表数据组件表示图表组件中的单个二维数据序列。例如：如果是折线图，则为一条线；如果是条形图，则为一条条形图图表。

数据组件负责处理图表的数据，数据组件的点对应 x 和 y 值。**可以将该组件拖到图表上，也就是将其直接附加到图表组件上。**

### 属性  {#ChartData2D-Properties}

{:.properties}

{:id="ChartData2D.Color" .color} *颜色*
: 指定数据序列的颜色，使用RGBA数值表示。

{:id="ChartData2D.Colors" .list .bo} *颜色列表*
: 指定数据序列的RGBA颜色数值列表。

  如果数据多于颜色，颜色将交替显示。例如，如果有红色和蓝色两种颜色，则颜色顺序为：红、蓝、红、蓝...

{:id="ChartData2D.DataFileXColumn" .text .wo .do} *数据文件x列*
: 从 [`数据文件`](storage.html#DataFile) 组件导入数据时， [`数据源`](#ChartData2D.Source) 使用的值。

  这个值表示数据文件中用于 x 条目的列数据序列。例如，如果列的第一个值是“时间”，并且指定了“时间”列值，将使用该列用于 x 值。
  
  如果未指定值，则使用默认值生成 x 值。

{:id="ChartData2D.DataFileYColumn" .text .wo .do} *数据文件y列*
: 从 [`数据文件`](storage.html#DataFile) 组件导入数据时， [`数据源`](#ChartData2D.Source) 使用的值。

  这个值表示数据文件中用于 y 条目的列数据序列。例如，如果列的第一个值为“温度”，并且指定了“温度”列值，将使用该列 y 值。
  
  如果未指定值，则使用默认值生成 y 值。

{:id="ChartData2D.DataSourceKey" .text .wo .do} *数据源键标识符*
: 为附加数据源导入的值设置键标识符。类似 [`微数据库`](storage.html#TinyDB) 组件的标签，使用它标识具体的值。

  该属性是“界面设计”视图专用的属性，应在设置图表数据组件的数据源后修改成相应的标识值。

  每种兼容数据源的适用值的完整列表如下：

    * 对于 [`微数据库`](storage.html#TinyDB) 和 [`云数据库`](storage.html#CloudDB)，这是标签值。
    * 对于 [`加速度传感器`](sensors.html#AccelerometerSensor)，该值应为以下之一：X Y 或 Z
    * 对于 [`陀螺仪传感器`](sensors.html#GyroscopeSensor)，该值应为以下之一：X Y 或 Z
    * 对于 [`位置传感器`](sensors.html#LocationSensor)，该值应为以下之一：纬度、经度、高度或速度
    * 对于 [`方向传感器`](sensors.html#OrientationSensor)，该值应为以下之一：俯仰角、方位角或横滚角
    * 对于 [`计步器`](sensors.html#Pedometer)，该值应为以下之一：行走步数、简单步数或距离
    * 对于 [`距离传感器`](sensors.html#ProximitySensor)，该值应为距离。
    * 对于 [`蓝牙客户端`](connectivity.html#BluetoothClient)，该值表示要从该值中删除的前缀。
      
      例如，如果值的格式为“t:12”，则前缀可以指定为“t:”，然后前缀将从数据中删除。如果是纯数值的话，则不能指定任何值。

{:id="ChartData2D.ElementsFromPairs" .text .wo .do} *元素来自键值对*
: 用于数据序列的逗号分隔（CSV）元素列表。值格式化如下：x1,y1,x2,y2,x3,y3。值成对获取， x 和 y 值形成一个条目。

{:id="ChartData2D.Label" .text} *标签*
: 指定数据序列标签的文本。

{:id="ChartData2D.LineType" .com.google.appinventor.components.common.LineTypeEnum .wo .do} *线型*
: 更改数据序列的线的类型，前提是数据组件附加到基于折线的图表（适用于`面积图`和`折线图`）。

  有效类型包括`折线`、`曲线`、`阶梯`。

{:id="ChartData2D.PointShape" .com.google.appinventor.components.common.PointStyleEnum .wo .do} *点型*
: 更改数据序列的点的形状，前提是数据组件附加到`散点图`的图表。

  有效类型包括`圆形`、`方形`、`三角`、`十字`、`叉号`。

{:id="ChartData2D.Source" .component .wo .do} *数据源*
: 设置数据组件的数据源。有效的选择包括：[`加速度传感器`](sensors.html#AccelerometerSensor)、[`蓝牙客户端`](connectivity.html#BluetoothClient)、[`云数据库`](storage.html#CloudDB)、[`数据文件`](storage.html#DataFile)、[`陀螺仪传感器`](sensors.html#GyroscopeSensor)、[`位置传感器`](sensors.html#LocationSensor)、[`方向传感器`](sensors.html#OrientationSensor)、[`计步器`](sensors.html#Pedometer)、[`距离传感器`](sensors.html#ProximitySensor)、[`微数据库`](storage.html#TinyDB) 和 [`Web客户端`](connectivity.html#Web)。 
  
  `数据源` 值还需要有效的 DataSourceValue、WebColumn 或 DataFileColumn 属性，取决于附加的数据源的类型（更改数据源后，所需的属性会显示在“属性”菜单中）。

  如果 [`数据源键标识符`](#ChartData2D.DataSourceKey) 标识的数据在附加的数据源组件中更新，然后数据也会在图表数据组件中更新。

{:id="ChartData2D.SpreadsheetUseHeaders" .boolean .wo .do} *SpreadsheetUseHeaders*
: If checked, the first row of the spreadsheet will be used to interpret the x and y column
 values. Otherwise, the x and y columns should be a column reference, such as A or B.

{:id="ChartData2D.SpreadsheetXColumn" .text .wo .do} *SpreadsheetXColumn*
: Sets the column to parse from the attached Spreadsheet component for the x values. If a
 column is not specified, default values for the x values will be generated instead.

{:id="ChartData2D.SpreadsheetYColumn" .text .wo .do} *SpreadsheetYColumn*
: Sets the column to parse from the attached Spreadsheet component for the y values. If a
 column is not specified, default values for the y values will be generated instead.

{:id="ChartData2D.WebXColumn" .text .wo .do} *WebXColumn*
: Value used when importing data from a Web component Source. The
 value represents the column to use from the Web for the x entries
 of the Data Series. For instance, if the contents of the Web are
 retrieved in JSON format, and an array with the "Time" tag exists,
 the "Time" column value can be specified to use that array.

{:id="ChartData2D.WebYColumn" .text .wo .do} *WebYColumn*
: Value used when importing data from a Web component Source. The
 value represents the column to use from the Web for the y entries
 of the Data Series. For instance, if the contents of the Web are
 retrieved in JSON format, and an array with the "Temperature" tag exists,
 the "Temperature" column value can be specified to use that array.

### 事件  {#ChartData2D-Events}

{:.events}

{:id="ChartData2D.EntryClick"} 数据点被点击时(*x坐标*{:.any},*y坐标*{:.number})
: 指示用户单击`图表`中的数据点，返回指定点的 x轴 和 y轴值。

### 方法  {#ChartData2D-Methods}

{:.methods}

{:id="ChartData2D.AddEntry" class="method"} <i/> 添加数据点(*x*{:.text},*y*{:.text})
: Adds an entry with the specified x and y value. Values can be specified as text,
 or as numbers. For Line, Scatter, Area and Bar Charts, both values should represent a number.
 For Bar charts, the x value is rounded to the nearest integer.
 For Pie Charts, the x value is a text value.

{:id="ChartData2D.ChangeDataSource" class="method"} <i/> 改变数据源(*source*{:.component},*keyValue*{:.text})
: Changes the Data Source of the component to the specified component Source with the
 specified key value. See the [`Source`](#ChartData2D.Source) property for
 applicable components. See the [`DataSourceKey`](#ChartData2D.DataSourceKey) property for the interpretation
 of the keyValue. In the case of the DataFile and Web components, the keyValue is expected to
 be a CSV formatted string, where the first value corresponds to the x column, and the second
 value corresponds to the y value.

{:id="ChartData2D.Clear" class="method"} <i/> 清除数据序列()
: Removes all the entries from the Data Series.

{:id="ChartData2D.DoesEntryExist" class="method returns boolean"} <i/> 数据点是否存在(*x*{:.text},*y*{:.text})
: Returns a boolean value specifying whether an entry with the specified x and y
 values exists. The boolean value of true is returned if the value exists,
 and a false value otherwise. See [`AddEntry`](#ChartData2D.AddEntry)
 for an explanation of the valid entry values.

{:id="ChartData2D.GetAllEntries" class="method returns list"} <i/> 获取所有数据点()
: Returns all entries of the data series.
 The returned value is a list, where each element of the list
 is a list containing the values of the entry in order.

{:id="ChartData2D.GetEntriesWithXValue" class="method returns list"} <i/> 获取X值数据点(*x*{:.text})
: Returns all entries of the data series matching the specified x value.
 For a description of the format of the returned List, see [`GetAllEntries`](#ChartData2D.GetAllEntries)

{:id="ChartData2D.GetEntriesWithYValue" class="method returns list"} <i/> 获取Y值数据点(*y*{:.text})
: Returns all entries of the data series matching the specified y value.
 For a description of the format of the returned List, see [`GetAllEntries`](#ChartData2D.GetAllEntries)

{:id="ChartData2D.ImportFromCloudDB" class="method"} <i/> 从云数据库导入(*云数据库*{:.component},*标签*{:.text})
: Imports data from the specified CloudDB component by taking the value
 identified by the specified tag value.

   The expected CloudDB value is a list formatted in the same way as described in
 [`ImportFromList`](#ChartData2D.ImportFromList).

   Does not overwrite any data.

{:id="ChartData2D.ImportFromDataFile" class="method"} <i/> ImportFromDataFile(*dataFile*{:.component},*xValueColumn*{:.text},*yValueColumn*{:.text})
: Imports data from the specified DataFile component by taking the specified x column
 for the x values, and the specified y column for the y values. The DataFile's source file
 is expected to be either a CSV or a JSON file.

   Passing in empty test for any of the column parameters will result in the usage of
 default values which are the indices of the entries. For the first entry, the default
 value would be the 1, for the second it would be 2, and so on.

{:id="ChartData2D.ImportFromList" class="method"} <i/> ImportFromList(*list*{:.list})
: Imports the data from the specified list parameter to the data series.
 The list is expected to contain element which are also lists. Each
 list element is expected to have 2 values, the first one being
 the x value, and the second one being the y value.
 Invalid list entries are simply skipped. Existing data are not cleared.

{:id="ChartData2D.ImportFromSpreadsheet" class="method"} <i/> ImportFromSpreadsheet(*sheet*{:.component},*xColumn*{:.text},*yColumn*{:.text},*useHeaders*{:.boolean})
: Imports data from the specified Spreadsheet component by taking the specified x column
 for the x values, and the specified y column for the y values. Prior to calling this function,
 the Spreadsheet component's ReadSheet method has to be called to load the data. The usage of
 the GotSheet event in the Spreadsheet component is unnecessary.

   Empty columns are filled with default values (1, 2, 3, ... for Entry 1, 2, 3, ...).

{:id="ChartData2D.ImportFromTinyDB" class="method"} <i/> ImportFromTinyDB(*tinyDB*{:.component},*tag*{:.text})
: Imports data from the specified TinyDB component by taking the value
 identified by the specified tag value.

   The expected TinyDB value is a list formatted in the same way as described in
 [`ImportFromList`](#ChartData2D.ImportFromList).

   Does not overwrite any data.

{:id="ChartData2D.ImportFromWeb" class="method"} <i/> ImportFromWeb(*web*{:.component},*xValueColumn*{:.text},*yValueColumn*{:.text})
: Imports data from the specified Web component by taking the specified x column
 for the x values, and the specified y column for the y values. Prior to calling this function,
 the Web component's Get method has to be called to load the data. The usage of the gotValue
 event in the Web component is unnecessary.

   The expected response of the Web component is a JSON or CSV formatted
 file for this function to work.

   Empty columns are filled with default values (1, 2, 3, ... for Entry 1, 2, 3, ...).

{:id="ChartData2D.RemoveDataSource" class="method"} <i/> RemoveDataSource()
: Removes the currently attached Data Source from the Chart Data component.
 Doing so will result in no more updates from the Data Source being sent, however,
 the current data will not be removed.

{:id="ChartData2D.RemoveEntry" class="method"} <i/> RemoveEntry(*x*{:.text},*y*{:.text})
: Removes an entry with the specified x and y value, provided it exists.
 See [`AddEntry`](#ChartData2D.AddEntry) for an explanation of the valid entry values.
