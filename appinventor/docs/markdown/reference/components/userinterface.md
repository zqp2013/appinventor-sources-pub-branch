---
layout: documentation
title: 用户界面（UI）组件
description: 用户界面（UI）组件参考文档：包括按钮、复选框、日期选择框、图像、标签、列表选择框、列表显示框、通知器、密码输入框、屏幕、滑动条、下拉框、切换开关、文本输入框、时间选择框、Web浏览框。
---

[&laquo; 返回首页](index.html)
# 用户界面（UI）组件

目录：

* [按钮（Button）](#Button)
* [复选框（CheckBox）](#CheckBox)
* [日期选择框（DatePicker）](#DatePicker)
* [图像（Image）](#Image)
* [SimpleBase64 *拓展：图像Base64编解码*](connectivity.html#SimpleBase64)
* [标签（Label）](#Label)
* [列表选择框（ListPicker）](#ListPicker)
* [列表显示框（ListView）](#ListView)
* [通知器（Notifier）](#Notifier)
* [密码输入框（PasswordTextBox）](#PasswordTextBox)
* [屏幕（Screen）](#Screen)
* [滑动条（Slider）](#Slider)
* [下拉框（Spinner）](#Spinner)
* [切换开关（Switch）](#Switch)
* [文本输入框（TextBox）](#TextBox)
* [时间选择框（TimePicker）](#TimePicker)
* [Web浏览框（WebViewer）](#WebViewer)

***
## 按钮（Button）  {#Button}

按钮具有检测点击的功能，它的外观可以被改变，比如是否可点击 (`启用`)，可以在“界面设计”视图或“程序设计”视图中修改其属性。

### 属性  {#Button-Properties}

{:.properties}

{:id="Button.BackgroundColor" .color} *背景颜色*
: 设置`按钮`的背景颜色，使用RGBA数值表示，如果设置了[`图像`](#Button.Image)属性，则不能显示背景颜色直到删除[`图像`](#Button.Image)属性为止。

{:id="Button.Enabled" .boolean} *启用*
: 设置`按钮`是否可以被点击。

{:id="Button.FontBold" .boolean} *粗体*
: 设置`按钮`的显示字体是否是粗体。（注：有些字体不支持粗体）。

{:id="Button.FontItalic" .boolean} *斜体*
: 设置`按钮`的显示字体是否是斜体。（注：有些字体不支持斜体）。

{:id="Button.FontSize" .number} *字体大小*
: 设置`按钮`的字体大小，以像素px为单位。

{:id="Button.FontTypeface" .number .do} *字体*
: 设置`按钮`的字体，目前支持的字体有：default,  serif,  sans serif,  和 monospace。

{:id="Button.Height" .number .bo} *高度*
: 设置`按钮`的垂直高度，以像素px为单位。

{:id="Button.HeightPercent" .number .wo .bo} *高度百分比*
: 设置`按钮`的垂直高度相对于整个[`屏幕高度`](userinterface.html#Screen.Height)的百分比。

{:id="Button.Image" .text} *图像*
: 设置`按钮`图像的路径，如果同时设置了`图像`和[`背景颜色`](#Button.BackgroundColor)，则仅`图像`可见。

{:id="Button.Shape" .number .do} *形状*
: 设置`按钮`的形状，此属性的有效值为：
`0`（默认）、 
`1` （圆形）、
`2`（矩形）和
`3`（椭圆形）。如果设置了[`图像`](#Button.Image)，则`形状`将不可见。

{:id="Button.ShowFeedback" .boolean} *显示反馈*
: 设置`按钮`指定 [`图像`](#Button.Image)后被按压是否显示视觉反馈。

{:id="Button.Text" .text} *文本*
: 设置`按钮`的显示文本。

{:id="Button.TextAlignment" .number .do} *文本对齐*
: 设置`按钮`文本的对齐方式，有效值有： 
`0`（正常；例如，如果文本从左到右书写，则左对齐）、
`1`（居中）或
`2`（相反；例如，如果文本从左到右书写，则右对齐）。

{:id="Button.TextColor" .color} *文本颜色*
: 设置`按钮`的文本颜色，使用RGBA数值表示。

{:id="Button.Visible" .boolean} *可见性*
: 设置`按钮`是否显示在屏幕上，值是`真`{:.logic.block}则`按钮`显示，`假`{:.logic.block}则隐藏。

{:id="Button.Width" .number .bo} *宽度*
: 设置`按钮`的水平宽度，以像素px为单位。

{:id="Button.WidthPercent" .number .wo .bo} *宽度百分比*
: 设置`按钮`的水平宽度相对于[`屏幕宽度`](userinterface.html#Screen.Width)的百分比。

### 事件  {#Button-Events}

{:.events}

{:id="Button.Click"} 被点击()
: 表示用户点击并放开了`按钮`。

{:id="Button.GotFocus"} 获得焦点()
: 表示光标移到`按钮`上了，因此现在可以单击它。

{:id="Button.LongClick"} 被慢点击()
: 表示用户按住了`按钮`。

{:id="Button.LostFocus"} 失去焦点()
: 表示光标从`按钮`移开，因此现在无法再单击它。

{:id="Button.TouchDown"} 被按压()
: 表示`按钮`被按下。

{:id="Button.TouchUp"} 被松开()
: 表示按下的`按钮`已被放开。

### 方法  {#Button-Methods}

{:.methods}
无

***
## 复选框  {#CheckBox}

![复选框示例](images/checkbox.png)

 `复选框`组件可以检测用户点击，并更改其布尔状态。

 当用户点击`复选框`组件时会触发事件，有很多属性可以影响其外观，可以在“界面设计”视图或“程序设计”视图中进行设置。

### 属性  {#CheckBox-Properties}

{:.properties}

{:id="CheckBox.BackgroundColor" .color} *背景颜色*
: 设置`复选框`的背景颜色，使用RGBA数值表示。

{:id="CheckBox.Checked" .boolean} *选中*
: 设置`复选框`是否处于选中状态，值是`真`{:.logic.block}则`复选框`选中，`假`{:.logic.block}则未选中。

{:id="CheckBox.Enabled" .boolean} *启用*
: 设置`复选框`是否可以被点击。

{:id="CheckBox.FontBold" .boolean .do} *粗体*
: 设置`复选框`的显示字体是否是粗体。（注：有些字体不支持粗体）。

{:id="CheckBox.FontItalic" .boolean .do} *斜体*
: 设置`复选框`的显示字体是否是斜体。（注：有些字体不支持斜体）。

{:id="CheckBox.FontSize" .number} *字体大小*
: 设置`复选框`的字体大小，以像素px为单位。

{:id="CheckBox.FontTypeface" .number .do} *字体*
: 设置`复选框`的字体，目前支持的字体有：default,  serif,  sans serif,  和 monospace。

{:id="CheckBox.Height" .number .bo} *高度*
: 设置`复选框`的垂直高度，以像素px为单位。

{:id="CheckBox.HeightPercent" .number .wo .bo} *高度百分比*
: 设置`复选框`的垂直高度相对于整个[`屏幕高度`](userinterface.html#Screen.Height)的百分比。

{:id="CheckBox.Text" .text} *文本*
: 设置`复选框`的显示文本。

{:id="CheckBox.TextColor" .color} *文本颜色*
: 设置`复选框`的文本颜色，使用RGBA数值表示。

{:id="CheckBox.Visible" .boolean} *可见性*
: 设置`复选框`是否显示在屏幕上，值是`真`{:.logic.block}则`复选框`显示，`假`{:.logic.block}则隐藏。

{:id="CheckBox.Width" .number .bo} *宽度*
: 设置`复选框`的水平宽度，以像素px为单位。

{:id="CheckBox.WidthPercent" .number .wo .bo} *宽度百分比*
: 设置`复选框`的水平宽度相对于[`屏幕宽度`](userinterface.html#Screen.Width)的百分比。

### 事件  {#CheckBox-Events}

{:.events}

{:id="CheckBox.Changed"} Changed()
: 用户点击，`复选框`选中状态发生改变时触发该事件。

{:id="CheckBox.GotFocus"} GotFocus()
: `复选框`获得焦点时，触发该事件。

{:id="CheckBox.LostFocus"} LostFocus()
: `复选框`失去焦点时，触发该事件。

### 方法  {#CheckBox-Methods}

{:.methods}
无


***
## 日期选择框  {#DatePicker}

单击一个按钮弹出对话框以允许用户选择日期(公历)。

  注意：日期和时间可使用 [计时器](sensors.html#Clock) 组件中的方法进行操作。

### 属性  {#DatePicker-Properties}

{:.properties}

{:id="DatePicker.BackgroundColor" .color} *背景颜色*
: 设置`日期选择框`的背景颜色，使用RGBA数值表示，如果设置了[`图像`](#DatePicker.Image)属性，则不能显示背景颜色直到删除[`图像`](#DatePicker.Image)属性为止。

{:id="DatePicker.Day" .number .ro .bo} *日期*
: Returns the Day of the month that was last picked using the DatePicker.

{:id="DatePicker.Enabled" .boolean} *启用*
: 设置`日期选择框`是否可以被激活和点击。

{:id="DatePicker.FontBold" .boolean} *粗体*
: 设置`日期选择框`的显示字体是否是粗体。（注：有些字体不支持粗体）。

{:id="DatePicker.FontItalic" .boolean} *斜体*
: 设置`日期选择框`的显示字体是否是斜体。（注：有些字体不支持斜体）。

{:id="DatePicker.FontSize" .number} *字体大小*
: 设置`日期选择框`的字体大小，以像素px为单位。

{:id="DatePicker.FontTypeface" .number .do} *字体*
: 设置`日期选择框`的字体，目前支持的字体有：default,  serif,  sans serif,  和 monospace。

{:id="DatePicker.Height" .number .bo} *高度*
: 设置`日期选择框`的垂直高度，以像素px为单位。

{:id="DatePicker.HeightPercent" .number .wo .bo} *高度百分比*
: 设置`日期选择框`的垂直高度相对于整个[`屏幕高度`](userinterface.html#Screen.Height)的百分比。

{:id="DatePicker.Image" .text} *图像*
: 设置`日期选择框`图像的路径，如果同时设置了`图像`和[`背景颜色`](#DatePicker.BackgroundColor)，则仅`图像`可见。

{:id="DatePicker.Instant" .InstantInTime .ro .bo} *时刻*
: Returns instant of the date that was last picked using the DatePicker.

{:id="DatePicker.Month" .number .ro .bo} *月份*
: Returns the number of the Month that was last picked using the DatePicker.

{:id="DatePicker.MonthInText" .text .ro .bo} *月份名称*
: Returns the name of the Month that was last picked using the DatePicker.

{:id="DatePicker.Shape" .number .do} *形状*
: 设置`日期选择框`的形状，此属性的有效值为：
`0`（默认）、 
`1` （圆形）、
`2`（矩形）和
`3`（椭圆形）。如果设置了[`图像`](#DatePicker.Image)，则`形状`将不可见。

{:id="DatePicker.ShowFeedback" .boolean} *显示反馈*
: 设置`日期选择框`指定 [`图像`](#DatePicker.Image)后被按压是否显示视觉反馈。

{:id="DatePicker.Text" .text} *文本*
: 设置`日期选择框`的显示文本。

{:id="DatePicker.TextAlignment" .number .do} *文本对齐*
: 设置`日期选择框`文本的对齐方式，有效值有： 
`0`（正常；例如，如果文本从左到右书写，则左对齐）、
`1`（居中）或
`2`（相反；例如，如果文本从左到右书写，则右对齐）。

{:id="DatePicker.TextColor" .color} *文本颜色*
: 设置`日期选择框`的文本颜色，使用RGBA数值表示。

{:id="DatePicker.Visible" .boolean} *可见性*
: 设置`日期选择框`是否显示在屏幕上，值是`真`{:.logic.block}则`日期选择框`显示，`假`{:.logic.block}则隐藏。

{:id="DatePicker.Width" .number .bo} *宽度*
: 设置`日期选择框`的水平宽度，以像素px为单位。

{:id="DatePicker.WidthPercent" .number .wo .bo} *宽度百分比*
: 设置`日期选择框`的水平宽度相对于[`屏幕宽度`](userinterface.html#Screen.Width)的百分比。

{:id="DatePicker.Year" .number .ro .bo} *年度*
: Returns the Year that was last picked using the DatePicker.

### 事件  {#DatePicker-Events}

{:.events}

{:id="DatePicker.AfterDateSet"} AfterDateSet()
: Event that runs after the user chooses a Date in the dialog.

{:id="DatePicker.GotFocus"} GotFocus()
: Indicates the cursor moved over the `DatePicker` so it is now possible
 to click it.

{:id="DatePicker.LostFocus"} LostFocus()
: Indicates the cursor moved away from the `DatePicker` so it is now no
 longer possible to click it.

{:id="DatePicker.TouchDown"} TouchDown()
: Indicates that the `DatePicker` was pressed down.

{:id="DatePicker.TouchUp"} TouchUp()
: Indicates that the `DatePicker` has been released.

### 方法  {#DatePicker-Methods}

{:.methods}

{:id="DatePicker.LaunchPicker" class="method"} <i/> LaunchPicker()
: Launches the DatePicker dialog. The [`AfterDateSet`](#DatePicker.AfterDateSet) event will be run after the user
 confirms their selection.

{:id="DatePicker.SetDateToDisplay" class="method"} <i/> SetDateToDisplay(*year*{:.number},*month*{:.number},*day*{:.number})
: Allows the user to set the date to be displayed when the date picker opens.
Valid values for the month field are 1-12 and 1-31 for the day field.

{:id="DatePicker.SetDateToDisplayFromInstant" class="method"} <i/> SetDateToDisplayFromInstant(*instant*{:.InstantInTime})
: Allows the user to set the date from the instant to be displayed when the date picker opens.

***
## 图像  {#Image}

用于显示图像和基本动画的组件。要显示的图片以及图像外观的其他方面，可以在“界面设计”视图或“程序设计”视图中进行设置。

### 属性  {#Image-Properties}

{:.properties}

{:id="Image.AlternateText" .text .wo} *AlternateText*
: A written description of what the image looks like.

{:id="Image.Animation" .text .wo .bo} *Animation*
: This is a limited form of animation that can attach a small number of motion types to images.
 The allowable motions are `ScrollRightSlow`, `ScrollRight`, `ScrollRightFast`,
 `ScrollLeftSlow`, `ScrollLeft`, `ScrollLeftFast`, and `Stop`.

{:id="Image.Clickable" .boolean} *Clickable*
: Specifies whether the image should be clickable or not.

{:id="Image.Height" .number .bo} *高度*
: 设置`图像`的垂直高度，以像素px为单位。

{:id="Image.HeightPercent" .number .wo .bo} *高度百分比*
: 设置`图像`的垂直高度相对于整个[`屏幕高度`](userinterface.html#Screen.Height)的百分比。

{:id="Image.Picture" .text} *Picture*
: Specifies the path of the `Image`'s `Picture`.

{:id="Image.RotationAngle" .number} *RotationAngle*
: The angle at which the image picture appears rotated. This rotation does not appear on the designer screen, only on the device.

{:id="Image.ScalePictureToFit" .boolean .wo} *ScalePictureToFit*
: Specifies whether the image should be resized to match the size of the ImageView.

{:id="Image.Scaling" .number .bo} *Scaling*
: This property determines how the picture scales according to the Height or Width of the Image. Scale proportionally (0) preserves the picture aspect ratio. Scale to fit (1) matches the Image area, even if the aspect ratio changes.

{:id="Image.Visible" .boolean} *可见性*
: 设置`图像`是否显示在屏幕上，值是`真`{:.logic.block}则`图像`显示，`假`{:.logic.block}则隐藏。

{:id="Image.Width" .number .bo} *宽度*
: 设置`图像`的水平宽度，以像素px为单位。

{:id="Image.WidthPercent" .number .wo .bo} *宽度百分比*
: 设置`图像`的水平宽度相对于[`屏幕宽度`](userinterface.html#Screen.Width)的百分比。

### 事件  {#Image-Events}

{:.events}

{:id="Image.Click"} Click()
: An event that occurs when an image is clicked.

### 方法  {#Image-Methods}

{:.methods}
无


***
## 标签  {#Label}

标签是用于显示文本的组件。

 ![标签示例](images/label.png)

标签显示由 `文本` 属性指定的文本内容，其他属性可以在“界面设计”视图或“程序设计”视图中进行设置，控制文本的外观和位置等。

### 属性  {#Label-Properties}

{:.properties}

{:id="Label.BackgroundColor" .color} *背景颜色*
: 指定`标签`的背景颜色，使用RGBA数值表示。

{:id="Label.FontBold" .boolean .do} *粗体*
: 指定`标签`的文本是否为粗体（有些字体不支持粗体）。

{:id="Label.FontItalic" .boolean .do} *斜体*
: : 指定`标签`的文本是否为斜体（有些字体不支持斜体）。

{:id="Label.FontSize" .number} *字号*
: 指定`标签`文本的字体大小，以像素px为单位。

{:id="Label.FontTypeface" .number .do} *字体*
: 设置`标签`文本的字体，目前支持的字体有：default,  serif,  sans serif,  和 monospace。

{:id="Label.HTMLContent" .text .ro .bo} *HTML内容*
: 在`HTML格式`为`真`{:.logic.block}时，以 HTML 形式返回`标签`的内容。

{:id="Label.HTMLFormat" .boolean .do} *HTML格式*
: 指定`标签`的文本格式是否是HTML格式。

{:id="Label.HasMargins" .boolean} *具有外边距*
: 指定`标签`是否有外边距。

{:id="Label.Height" .number .bo} *高度*
: 设置`标签`的垂直高度，以像素px为单位。

{:id="Label.HeightPercent" .number .wo .bo} *高度百分比*
: 设置`标签`的垂直高度相对于整个[`屏幕高度`](userinterface.html#Screen.Height)的百分比。

{:id="Label.Text" .text} *文本*
: 设置`标签`的显示文本。

{:id="Label.TextAlignment" .number .do} *文本对齐*
: 指定`标签`文本的对齐方式：居中、正常（例如，如果文本是从左到右书写的，则左对齐），或者相反（例如，如果文本是从左到右书写的，则右对齐）。

{:id="Label.TextColor" .color} *文本颜色*
: 设置`标签`的文本颜色，使用RGBA数值表示。

{:id="Label.Visible" .boolean} *可见性*
: 设置`标签`是否显示在屏幕上，值是`真`{:.logic.block}则`标签`显示，`假`{:.logic.block}则隐藏。

{:id="Label.Width" .number .bo} *宽度*
: 设置`标签`的水平宽度，以像素px为单位。

{:id="Label.WidthPercent" .number .wo .bo} *宽度百分比*
: 设置`标签`的水平宽度相对于[`屏幕宽度`](userinterface.html#Screen.Width)的百分比。

### 事件  {#Label-Events}

{:.events}
无


### 方法  {#Label-Methods}

{:.methods}
无


***
## 列表选择框  {#ListPicker}

一个按钮，单击该按钮会显示文本列表，供用户选择。文本可以在“界面设计”视图或“程序设计”视图中使用[`元素字串`](#ListPicker.ElementsFromString) 属性指定，多个字符串使用**英文的逗号**(',')连接
  （例如，`选择1,选择2,选择3`）或在“程序设计”视图中设置[`元素`](#ListPicker.Elements)属性，是一个列表属性。

[`显示搜索框`](#ListPicker.ShowFilterBar)属性设置为 `真`{:.logic.block}，将生成可搜索列表，其他属性影响按钮的外观 ([`文本对齐`](#ListPicker.TextAlignment),
  [`背景颜色`](#ListPicker.BackgroundColor)等) 以及是否可以被点击（[`启用`](#ListPicker.Enabled)）。

### 属性  {#ListPicker-Properties}

{:.properties}

{:id="ListPicker.BackgroundColor" .color} *背景颜色*
: 设置`列表选择框`的背景颜色，使用RGBA数值表示，如果设置了[`图像`](#ListPicker.Image)属性，则不能显示背景颜色直到删除[`图像`](#ListPicker.Image)属性为止。

{:id="ListPicker.Elements" .list .bo} *元素*
: Specifies the list of choices to display.

{:id="ListPicker.ElementsFromString" .text .wo} *元素字串*
: Set the list of choices from a string of comma-separated values.

{:id="ListPicker.Enabled" .boolean} *启用*
: 设置`列表选择框`是否可以被激活和点击。

{:id="ListPicker.FontBold" .boolean} *粗体*
: 设置`列表选择框`的显示字体是否是粗体。（注：有些字体不支持粗体）。

{:id="ListPicker.FontItalic" .boolean} *斜体*
: 设置`列表选择框`的显示字体是否是斜体。（注：有些字体不支持斜体）。

{:id="ListPicker.FontSize" .number} *字体大小*
: 设置`列表选择框`的字体大小，以像素px为单位。

{:id="ListPicker.FontTypeface" .number .do} *字体*
: 设置`列表选择框`的字体，目前支持的字体有：default,  serif,  sans serif,  和 monospace。

{:id="ListPicker.Height" .number .bo} *高度*
: 设置`列表选择框`的垂直高度，以像素px为单位。

{:id="ListPicker.HeightPercent" .number .wo .bo} *高度百分比*
: 设置`列表选择框`的垂直高度相对于整个[`屏幕高度`](userinterface.html#Screen.Height)的百分比。

{:id="ListPicker.Image" .text} *图像*
: 设置`列表选择框`图像的路径，如果同时设置了`图像`和[`背景颜色`](#ListPicker.BackgroundColor)，则仅`图像`可见。

{:id="ListPicker.ItemBackgroundColor" .color} *ItemBackgroundColor*
: The background color of the `ListPicker` items.

{:id="ListPicker.ItemTextColor" .color} *ItemTextColor*
: The text color of the ListPicker items.

{:id="ListPicker.Selection" .text} *Selection*
: The selected item. When directly changed by the programmer, the [`SelectionIndex`](#ListPicker.SelectionIndex)
 property is also changed to the first item in the [`ListPicker`](#ListPicker) with the given value.
 If the value is not in [`Elements`](#ListPicker.Elements), [`SelectionIndex`](#ListPicker.SelectionIndex) will be set to 0.

{:id="ListPicker.SelectionIndex" .number .bo} *SelectionIndex*
: Selection index property setter method.

{:id="ListPicker.Shape" .number .do} *形状*
: 设置`列表选择框`的形状，此属性的有效值为：
`0`（默认）、 
`1` （圆形）、
`2`（矩形）和
`3`（椭圆形）。如果设置了[`图像`](#Button.Image)，则`形状`将不可见。

{:id="ListPicker.ShowFeedback" .boolean} *显示反馈*
: 设置`列表选择框`指定 [`图像`](#ListPicker.Image)后被按压是否显示视觉反馈。

{:id="ListPicker.ShowFilterBar" .boolean} *显示搜索框*
: If `真`{:.logic.block}, the ListPicker will show a search filter bar.

{:id="ListPicker.Text" .text} *文本*
: 设置`列表选择框`的显示文本。

{:id="ListPicker.TextAlignment" .number .do} *文本对齐*
: 设置`列表选择框`文本的对齐方式，有效值有： 
`0`（正常；例如，如果文本从左到右书写，则左对齐）、
`1`（居中）或
`2`（相反；例如，如果文本从左到右书写，则右对齐）。

{:id="ListPicker.TextColor" .color} *文本颜色*
: 设置`列表选择框`的文本颜色，使用RGBA数值表示。

{:id="ListPicker.Title" .text} *标题*
: 可选标题显示在选项列表的顶部。

{:id="ListPicker.Visible" .boolean} *可见性*
: 设置`列表选择框`是否显示在屏幕上，值是`真`{:.logic.block}则`列表选择框`显示，`假`{:.logic.block}则隐藏。

{:id="ListPicker.Width" .number .bo} *宽度*
: 设置`列表选择框`的水平宽度，以像素px为单位。

{:id="ListPicker.WidthPercent" .number .wo .bo} *宽度百分比*
: 设置`列表选择框`的水平宽度相对于[`屏幕宽度`](userinterface.html#Screen.Width)的百分比。

### 事件  {#ListPicker-Events}

{:.events}

{:id="ListPicker.AfterPicking"} AfterPicking()
: Event to be raised after the `ListPicker` activity returns its
 result and the properties have been filled in.

{:id="ListPicker.BeforePicking"} BeforePicking()
: Event to raise when the `ListPicker` is clicked or the picker is shown
 using the [`Open`](#ListPicker.Open) method.  This event occurs before the picker is displayed, and
 can be used to prepare the picker before it is shown.

{:id="ListPicker.GotFocus"} GotFocus()
: Indicates the cursor moved over the `ListPicker` so it is now possible
 to click it.

{:id="ListPicker.LostFocus"} LostFocus()
: Indicates the cursor moved away from the `ListPicker` so it is now no
 longer possible to click it.

{:id="ListPicker.TouchDown"} TouchDown()
: Indicates that the `ListPicker` was pressed down.

{:id="ListPicker.TouchUp"} TouchUp()
: Indicates that the `ListPicker` has been released.

### 方法  {#ListPicker-Methods}

{:.methods}

{:id="ListPicker.Open" class="method"} <i/> Open()
: Opens the `ListPicker`, as though the user clicked on it.

***
## 列表显示框  {#ListView}

This is a visible component that displays a list of text and image elements in your [`Screen`](#Screen) to
 display. Simple lists of strings may be set using the [`ElementsFromString`](#ListView.ElementsFromString) property.
 More complex lists of elements containing multiple strings and/or images can be created using the
 [`ListData`](#ListView.ListData) and [`ListViewLayout`](#ListView.ListViewLayout) properties.

 [Information on Layouts](../other/advanced-listview.html)

   Warning: This component will not work correctly on Screens that are scrollable if its
 [`Height`](#ListView.Height) is set to Fill Parent.



### 属性  {#ListView-Properties}

{:.properties}

{:id="ListView.BackgroundColor" .color} *背景颜色*
: 设置`列表显示框`的背景颜色。

{:id="ListView.Elements" .list .bo} *Elements*
: Specifies the list of choices to display.

{:id="ListView.ElementsFromString" .text .wo} *ElementsFromString*
: Set the list of choices specified as a string with the elements separated by commas
 such as: Cheese,Fruit,Bacon,Radish.

{:id="ListView.FontSizeDetail" .number} *FontSizeDetail*
: Specifies the `ListView` item's text font size

{:id="ListView.FontTypeface" .number .do} *字体*
: 设置`列表显示框`的字体，目前支持的字体有：default,  serif,  sans serif,  和 monospace。

{:id="ListView.FontTypefaceDetail" .number .do} *FontTypefaceDetail*
: Specifies the label's text's font face as default, serif, sans
 serif, or monospace.

{:id="ListView.Height" .number .bo} *高度*
: 设置`列表显示框`的垂直高度，以像素px为单位。

{:id="ListView.HeightPercent" .number .wo .bo} *高度百分比*
: 设置`列表显示框`的垂直高度相对于整个[`屏幕高度`](userinterface.html#Screen.Height)的百分比。

{:id="ListView.ImageHeight" .number} *ImageHeight*
: Specifies the image height of ListView layouts containing images

{:id="ListView.ImageWidth" .number} *ImageWidth*
: Specifies the image width of ListView layouts containing images

{:id="ListView.ListData" .text .do} *ListData*
: Specifies data to be displayed in the ListView elements. This property sets the
 elements specified in [`ListViewLayout`](#ListView.ListViewLayout). For example, if the chosen
 layout is `Image,MainText` this property will allow any number of elements to be
 defined, each containing a filename for Image and a string for MainText.
 Designer only property.

{:id="ListView.ListViewLayout" .number .do} *ListViewLayout*
: Specifies type of layout for ListView row. Designer only property.

{:id="ListView.Orientation" .number} *Orientation*
: Specifies the layout's orientation. This may be: `Vertical`, which displays elements
 in rows one after the other; or `Horizontal`, which displays one element at a time and
 allows the user to swipe left or right to brows the elements.

{:id="ListView.Selection" .text} *Selection*
: Returns the text in the `ListView` at the position of [`SelectionIndex`](#ListView.SelectionIndex).

{:id="ListView.SelectionColor" .color} *SelectionColor*
: The color of the item when it is selected.

{:id="ListView.SelectionDetailText" .text .ro .bo} *SelectionDetailText*
: Returns the Secondary or Detail text in the ListView at the position set by SelectionIndex

{:id="ListView.SelectionIndex" .number .bo} *SelectionIndex*
: The index of the currently selected item, starting at `1`. If no item is selected, the value
 will be `0`. If an attempt is made to set this to a number less than `1` or greater than the
 number of items in the `ListView`, `SelectionIndex` will be set to `0`, and
 [`Selection`](#ListView.Selection) will be set to the empty text.

{:id="ListView.ShowFilterBar" .boolean} *ShowFilterBar*
: Sets visibility of the filter bar. `真`{:.logic.block} will show the bar,
 `假`{:.logic.block} will hide it.

{:id="ListView.TextColor" .color} *文本颜色*
:: 设置`列表显示框`的文本颜色，使用RGBA数值表示。

{:id="ListView.TextColorDetail" .color} *TextColorDetail*
: Specifies the color of the secondary text in a ListView layout

{:id="ListView.TextSize" .number} *TextSize*
: Specifies the `列表显示框` item's text font size

{:id="ListView.Visible" .boolean} *可见性*
: 设置`列表显示框`是否显示在屏幕上，值是`真`{:.logic.block}则`列表显示框`显示，`假`{:.logic.block}则隐藏。

{:id="ListView.Width" .number .bo} *宽度*
: 设置`列表显示框`的水平宽度，以像素px为单位。

{:id="ListView.WidthPercent" .number .wo .bo} *宽度百分比*
: 设置`列表显示框`的水平宽度相对于[`屏幕宽度`](userinterface.html#Screen.Width)的百分比。

### 事件  {#ListView-Events}

{:.events}

{:id="ListView.AfterPicking"} AfterPicking()
: Simple event to be raised after the an element has been chosen in the list.
 The selected element is available in the [`Selection`](#ListView.Selection) property.

### 方法  {#ListView-Methods}

{:.methods}

{:id="ListView.CreateElement" class="method returns dictionary"} <i/> CreateElement(*mainText*{:.text},*detailText*{:.text},*imageName*{:.text})
: Creates a

{:id="ListView.GetDetailText" class="method returns text"} <i/> GetDetailText(*listElement*{:.dictionary})
: Get the Detail Text of a ListView element.

{:id="ListView.GetImageName" class="method returns text"} <i/> GetImageName(*listElement*{:.dictionary})
: Get the filename of the image of a ListView element that has been uploaded to Media.

{:id="ListView.GetMainText" class="method returns text"} <i/> GetMainText(*listElement*{:.dictionary})
: Get the Main Text of a ListView element.

{:id="ListView.Refresh" class="method"} <i/> Refresh()
: Reload the ListView to reflect any changes in the data.

***
## 通知器  {#Notifier}

The Notifier component displays alert messages and creates Android log entries through
 an assortment of methods.

### 属性  {#Notifier-Properties}

{:.properties}

{:id="Notifier.BackgroundColor" .color .wo} *背景颜色*
: Specifies the background color for alerts (not dialogs).

{:id="Notifier.NotifierLength" .number .do} *NotifierLength*
: Specifies the length of time that the alert is shown -- either "short" or "long".

{:id="Notifier.TextColor" .color} *文本颜色*
: Specifies the text color for alerts (not dialogs).

### 事件  {#Notifier-Events}

{:.events}

{:id="Notifier.AfterChoosing"} AfterChoosing(*choice*{:.text})
: Event after the user has made a selection for
 [`ShowChooseDialog`](#Notifier.ShowChooseDialog).

{:id="Notifier.AfterTextInput"} AfterTextInput(*response*{:.text})
: Event raised after the user has responded to [`ShowTextDialog`](#Notifier.ShowTextDialog).

{:id="Notifier.ChoosingCanceled"} ChoosingCanceled()
: Event raised when the user cancels choosing an option.
 [`ShowChooseDialog`](#Notifier.ShowChooseDialog).

{:id="Notifier.TextInputCanceled"} TextInputCanceled()
: Event raised when the user cancels
 [`ShowPasswordDialog`](#Notifier.ShowPasswordDialog), or
 [`ShowTextDialog`](#Notifier.ShowTextDialog).

### 方法  {#Notifier-Methods}

{:.methods}

{:id="Notifier.DismissProgressDialog" class="method"} <i/> DismissProgressDialog()
: Dismisses the alert created by the ShowProgressDialog block

{:id="Notifier.LogError" class="method"} <i/> LogError(*message*{:.text})
: Writes an error message to the Android system log. See the Google Android documentation for
 how to access the log.

{:id="Notifier.LogInfo" class="method"} <i/> LogInfo(*message*{:.text})
: Writes an information message to the Android log.

{:id="Notifier.LogWarning" class="method"} <i/> LogWarning(*message*{:.text})
: Writes a warning message to the Android log. See the Google Android documentation for how to
 access the log.

{:id="Notifier.ShowAlert" class="method"} <i/> ShowAlert(*notice*{:.text})
: Display a temporary notification.

{:id="Notifier.ShowChooseDialog" class="method"} <i/> ShowChooseDialog(*message*{:.text},*title*{:.text},*button1Text*{:.text},*button2Text*{:.text},*cancelable*{:.boolean})
: Shows a dialog box with two buttons, from which the user can choose. If `cancelable` is
 `真`{:.logic.block} there will be an additional CANCEL button. Pressing a button will raise
 the [`AfterChoosing`](#Notifier.AfterChoosing) event. The "choice" parameter to
 [`AfterChoosing`](#Notifier.AfterChoosing) will be the text on the button that was pressed, or "Cancel" if
 the CANCEL button was pressed. If canceled, the [`TextInputCanceled`](#Notifier.TextInputCanceled) event will also
 run.

{:id="Notifier.ShowMessageDialog" class="method"} <i/> ShowMessageDialog(*message*{:.text},*title*{:.text},*buttonText*{:.text})
: Display an alert dialog with a single button that dismisses the alert.

{:id="Notifier.ShowPasswordDialog" class="method"} <i/> ShowPasswordDialog(*message*{:.text},*title*{:.text},*cancelable*{:.boolean})
: Shows a dialog box where the user can enter password (input is masked), after which the
 [`AfterTextInput`](#Notifier.AfterTextInput) event will be raised. If `cancelable` is `真`{:.logic.block}
 there will be an additional CANCEL button. The [`AfterTextInput`](#Notifier.AfterTextInput) and
 [`TextInputCanceled`](#Notifier.TextInputCanceled) events behave the same way as described in
 [`ShowTextDialog`](#Notifier.ShowTextDialog).

{:id="Notifier.ShowProgressDialog" class="method"} <i/> ShowProgressDialog(*message*{:.text},*title*{:.text})
: Shows a dialog box with an optional title and message (use empty strings if they are not
 wanted). This dialog box contains a spinning artifact to indicate that the program is working.
 It cannot be canceled by the user but must be dismissed by the App Inventor Program by using
 the [`DismissProgressDialog`](#Notifier.DismissProgressDialog) method.

{:id="Notifier.ShowTextDialog" class="method"} <i/> ShowTextDialog(*message*{:.text},*title*{:.text},*cancelable*{:.boolean})
: Shows a dialog box where the user can enter text, after which the
 [`AfterTextInput`](#Notifier.AfterTextInput)  event will be raised. If `cancelable` is `真`{:.logic.block}
 there will be an additional CANCEL button. Entering text will raise the
 [`AfterTextInput`](#Notifier.AfterTextInput) event. The "response" parameter to
 [`AfterTextInput`](#Notifier.AfterTextInput)  will be the text that was entered, or "Cancel" if the CANCEL
 button was pressed. If canceled, the [`TextInputCanceled`](#Notifier.TextInputCanceled) event will also run.

***
## 密码输入框  {#PasswordTextBox}

Users enter passwords in a password text box component, which hides the text that has been typed in it.

 ![Example of a PasswordTextBox](images/passwordtextbox.png)

 A password text box is the same as the ordinary [`TextBox`](#TextBox) component, except that it does
 not display the characters typed by the user.

 You can get or set the value of the text in the box with the [`Text`](#PasswordTextBox.Text) property. If
 [`Text`](#PasswordTextBox.Text) is blank, you can use the [`Hint`](#PasswordTextBox.Hint) property to provide the user
 with a suggestion of what to type. The [`Hint`](#PasswordTextBox.Hint) appears as faint text in the box.

 Password text box components are usually used with a [`Button`](#Button) component. The user taps the
 `Button` after entering text.

### 属性  {#PasswordTextBox-Properties}

{:.properties}

{:id="PasswordTextBox.BackgroundColor" .color} *背景颜色*
: The background color of the `PasswordTextBox``. You can choose a color by name in the Designer or in
 the Blocks Editor. The default background color is 'default' (shaded 3-D look).

{:id="PasswordTextBox.Enabled" .boolean} *启用*
: If set, user can enter text into the `PasswordTextBox`.

{:id="PasswordTextBox.FontBold" .boolean .do} *粗体*
: 设置`密码输入框`的显示字体是否是粗体。（注：有些字体不支持粗体）。

{:id="PasswordTextBox.FontItalic" .boolean .do} *斜体*
: 设置`密码输入框`的显示字体是否是斜体。（注：有些字体不支持斜体）。

{:id="PasswordTextBox.FontSize" .number} *字体大小*
: 设置`密码输入框`的字体大小，以像素px为单位。

{:id="PasswordTextBox.FontTypeface" .number .do} *字体*
: 设置`密码输入框`的字体，目前支持的字体有：`0` (default), `1` (serif), `2` (sansserif), 和 `3` (monospace)。

{:id="PasswordTextBox.Height" .number .bo} *高度*
: 设置`密码输入框`的垂直高度，以像素px为单位。

{:id="PasswordTextBox.HeightPercent" .number .wo .bo} *高度百分比*
: 设置`密码输入框`的垂直高度相对于整个[`屏幕高度`](userinterface.html#Screen.Height)的百分比。

{:id="PasswordTextBox.Hint" .text} *Hint*
: `PasswordTextBox` hint for the user.

{:id="PasswordTextBox.NumbersOnly" .boolean} *NumbersOnly*
: If true, then this `PasswordTextBox`` accepts only numbers as keyboard input. Numbers can include a
 decimal point and an optional leading minus sign. This applies to keyboard input only. Even
 if `NumbersOnly` is true, you can set the text to anything at all using the
 [`Text`](#PasswordTextBox.Text) property.

{:id="PasswordTextBox.PasswordVisible" .boolean .bo} *PasswordVisible*
: Specifies whether the password is hidden (default) or shown.

{:id="PasswordTextBox.Text" .text} *文本*
: The text in the `PasswordTextBox`, which can be set by the programmer in the Designer or Blocks Editor,
 or it can be entered by the user (unless the [`Enabled`](#PasswordTextBox.Enabled) property is false).

{:id="PasswordTextBox.TextAlignment" .number .do} *文本对齐*
: 设置`密码输入框`文本的对齐方式，有效值有： 
`0`（正常；例如，如果文本从左到右书写，则左对齐）、
`1`（居中）或
`2`（相反；例如，如果文本从左到右书写，则右对齐）。

{:id="PasswordTextBox.TextColor" .color} *文本颜色*
: 设置`密码输入框`的文本颜色，使用RGBA数值表示。

{:id="PasswordTextBox.Visible" .boolean} *可见性*
: 设置`密码输入框`是否显示在屏幕上，值是`真`{:.logic.block}则`密码输入框`显示，`假`{:.logic.block}则隐藏。

{:id="PasswordTextBox.Width" .number .bo} *宽度*
: 设置`密码输入框`的水平宽度，以像素px为单位。

{:id="PasswordTextBox.WidthPercent" .number .wo .bo} *宽度百分比*
: 设置`密码输入框`的水平宽度相对于[`屏幕宽度`](userinterface.html#Screen.Width)的百分比。

### 事件  {#PasswordTextBox-Events}

{:.events}

{:id="PasswordTextBox.GotFocus"} GotFocus()
: Event raised when the `PasswordTextBox` is selected for input, such as by
 the user touching it.

{:id="PasswordTextBox.LostFocus"} LostFocus()
: Event raised when the `PasswordTextBox` is no longer selected for input, such
 as if the user touches a different text box.

### 方法  {#PasswordTextBox-Methods}

{:.methods}

{:id="PasswordTextBox.RequestFocus" class="method"} <i/> RequestFocus()
: Request focus to current `PasswordTextBox`.

***
## 屏幕  {#Screen}

Top-level component containing all other components in the program.

### 属性  {#Screen-Properties}

{:.properties}

{:id="Screen.AboutScreen" .text} *AboutScreen*
: Information about the screen. It appears when "About this Application" is selected from the
 system menu. Use it to tell users about your app. In multiple screen apps, each screen has its
 own `AboutScreen` info.

{:id="Screen.AccentColor" .color .do} *AccentColor*
: This is the accent color used for highlights and other user interface accents in newer
 versions of Android. Components affected by this property include dialogs created by the
 [`Notifier`](#Notifier), the [`DatePicker`](#DatePicker), and others.

{:id="Screen.AlignHorizontal" .number} *AlignHorizontal*
: A number that encodes how contents of the screen are aligned horizontally. The choices are:
 `1` (left aligned), `3` (horizontally centered), `2` (right aligned).

{:id="Screen.AlignVertical" .number} *AlignVertical*
: A number that encodes how the contents of the arrangement are aligned vertically. The choices
 are: `1` (aligned at the top), `2` (vertically centered), `3` (aligned at the bottom). Vertical
 alignment has no effect if the screen is scrollable.

{:id="Screen.AppName" .text .wo .do} *AppName*
: This is the display name of the installed application in the phone. If the `AppName` is blank,
 it will be set to the name of the project when the project is built.

{:id="Screen.BackgroundColor" .color} *背景颜色*
: 设置`屏幕`的背景颜色，使用RGBA数值表示，如果设置了[`背景图像`](#Screen.BackgroundImage)属性，则不能显示背景颜色直到删除[`背景图像`](#Screen.BackgroundImage)属性为止。

{:id="Screen.BackgroundImage" .text} *背景图像*
: Specifies the path of the `Screen`'s background image. If there is both an `BackgroundImage`
 and a [`BackgroundColor`](#Screen.BackgroundColor) specified, only the `BackgroundImage` will be visible.

{:id="Screen.BigDefaultText" .boolean} *BigDefaultText*
: When checked, all default size text will be increased in size.

{:id="Screen.BlocksToolkit" .text .wo .do} *BlocksToolkit*
: A JSON string representing the subset for the screen. Authors of template apps can use this to control what components, designer properties, and blocks are available in the project.

{:id="Screen.CloseScreenAnimation" .text} *CloseScreenAnimation*
: Sets the animation type for the transition of this form closing and returning
 to a form behind it in the activity stack.

{:id="Screen.DefaultFileScope" .com.google.appinventor.components.common.FileScopeEnum .wo .do} *DefaultFileScope*
: Specifies the default scope used when components access files. Note that the [`File`](#File)
 component has its own property for controlling file scopes.

{:id="Screen.Height" .number .ro .bo} *高度*
: Returns the Screen height in pixels (y-size).

{:id="Screen.HighContrast" .boolean} *HighContrast*
: When checked, there will be high contrast mode turned on.

{:id="Screen.Icon" .text .wo .do} *Icon*
: The image used for your App's display icon should be a square png or jpeg image with dimensions
 up to 1024x1024 pixels. Larger images may cause compiling or installing the app to fail.
 The build server will generate images of standard dimensions for Android devices.

{:id="Screen.OpenScreenAnimation" .text} *OpenScreenAnimation*
: Sets the animation type for the transition of this form opening.

{:id="Screen.Platform" .text .ro .bo} *Platform*
: Gets the name of the underlying platform running the app. Currently, this is the text
 "Android". Other platforms may be supported in the future.

{:id="Screen.PlatformVersion" .text .ro .bo} *PlatformVersion*
: Gets the version number of the platform running the app. This is typically a dotted version
 number, such as 10.0. Any value can be returned, however, so you should take care to handle
 unexpected data. If the platform version is unavailable, the empty text will be returned.

{:id="Screen.PrimaryColor" .color .do} *PrimaryColor*
: This is the primary color used as part of the Android theme, including coloring the `Screen`'s
 title bar.

{:id="Screen.PrimaryColorDark" .color .do} *PrimaryColorDark*
: This is the primary color used when the Theme property is specified to be Dark. It applies to
 a number of elements, including the `Screen`'s title bar.

{:id="Screen.ScreenOrientation" .text} *ScreenOrientation*
: Declares the requested screen orientation, specified as a text value. Commonly used values are
 `landscape`, `portrait`, `sensor`, `user` and `unspecified`. See the Android developer
 documentation for the complete list of possible
 [options](https://developer.android.com/reference/android/R.attr.html#screenOrientation).

{:id="Screen.Scrollable" .boolean} *Scrollable*
: When checked, there will be a vertical scrollbar on the screen, and the height of the
 application can exceed the physical height of the device. When unchecked, the application
 height is constrained to the height of the device.

{:id="Screen.ShowListsAsJson" .boolean .do} *ShowListsAsJson*
: If `真`{:.logic.block} (the default), lists will be shown as strings in JSON/Python notation
 for example [1, "a", true]. If `假`{:.logic.block}, lists will be shown in the LISP
 notation, for example (1 a true).

   **Note:** This property appears only in Screen1 and the value for Screen1 determines the
 behavior for all screens in the app.

{:id="Screen.ShowStatusBar" .boolean} *ShowStatusBar*
: The status bar is the topmost bar on the screen. This property reports whether the status bar
 is visible.

{:id="Screen.Sizing" .text .wo .do} *Sizing*
: If set to responsive (the default), screen layouts will use the actual resolution of the
 device. See the [documentation on responsive design](../other/responsiveDesign.html) in App
 Inventor for more information.
 If set to fixed, screen layouts will be created for a single fixed-size screen and autoscaled.

   **Note:** This property appears on Screen1 only and controls the sizing for all screens in
 the app.

{:id="Screen.Theme" .text .wo .do} *Theme*
: Selects the theme for the application. Theme can only be set at compile time and the Companion
 will approximate changes during live development. Possible options are:

   * `Classic`, which is the same as older versions of App Inventor;
   * `Device Default`, which gives the same theme as the version of Android running on the
     device and uses PrimaryColor for the Action Bar and has light buttons;
   * `Black Title Text`, which is the `Device Default` theme but with black title text; and
   * `Dark`, which is a dark version of the `Device Default` theme using `PrimaryColorDark` and
     having dark grey components.

{:id="Screen.Title" .text} *Title*
: Title property setter method: sets a new caption for the form in the
 form's title bar.

{:id="Screen.TitleVisible" .boolean} *TitleVisible*
: The title bar is the top gray bar on the screen. This property reports whether the title bar
 is visible.

{:id="Screen.TutorialURL" .text .wo .do} *TutorialURL*
: A URL which will be opened on the left side panel (which can be toggled once it is open). This
 is intended for projects that have an in-line tutorial as part of the project. For security
 reasons, only tutorials hosted on http://appinventor.mit.edu or linked to from our URL
 shortener (http://appinv.us) may be used here. Other URLs will be silently ignored.

{:id="Screen.VersionCode" .number .wo .do} *VersionCode*
: An integer value which must be incremented each time a new Android Application Package File
 (APK) is created for the Google Play Store.

{:id="Screen.VersionName" .text .wo .do} *VersionName*
: A string which can be changed to allow Google Play Store users to distinguish between
 different versions of the App.

{:id="Screen.Width" .number .ro .bo} *宽度*
: Returns the Screen width in pixels (x-size).

### 事件  {#Screen-Events}

{:.events}

{:id="Screen.BackPressed"} BackPressed()
: Device back button pressed.

{:id="Screen.ErrorOccurred"} ErrorOccurred(*component*{:.component},*functionName*{:.text},*errorNumber*{:.number},*message*{:.text})
: Event raised when an error occurs. Only some errors will raise this condition.  For those errors, the system will show a notification by default.  You can use this event handler to prescribe an error behavior different than the default.

{:id="Screen.Initialize"} Initialize()
: The Initialize event is run when the Screen starts and is only run once per screen.

{:id="Screen.OtherScreenClosed"} OtherScreenClosed(*otherScreenName*{:.text},*result*{:.any})
: Event raised when another screen has closed and control has returned to this screen.

{:id="Screen.PermissionDenied"} PermissionDenied(*component*{:.component},*functionName*{:.text},*permissionName*{:.text})
: Event to handle when the app user has denied a needed permission.

{:id="Screen.PermissionGranted"} PermissionGranted(*permissionName*{:.text})
: Event to handle when the app user has granted a needed permission. This event is only run when permission is
 granted in response to the [`请求权限`](#Screen.AskForPermission) method.

{:id="Screen.ScreenOrientationChanged"} ScreenOrientationChanged()
: Screen orientation changed

### 方法  {#Screen-Methods}

{:.methods}

{:id="Screen.AskForPermission" class="method"} <i/> 请求权限(*权限名称*{:.text})
: 要求用户授予对敏感权限的访问权限，例如`精确定位`权限。

 如果用户许可了授权，[`权限被授予时`](#Screen.PermissionGranted) 事件将被触发；如果用户拒绝授权，[`权限被拒绝时`](#Screen.PermissionDenied)事件将被触发。

   **注意：** 最佳做法是仅在需要时请求权限，App Inventor组件将在必要时执行。不建议在[`初始化`](#Screen.Initialize) 事件中使用`请求权限`，除非访问该权限对你的应用是预先需要的，例如导航应用需要定位服务。

{:id="Screen.HideKeyboard" class="method"} <i/> HideKeyboard()
: Hide the soft keyboard

***
## 滑动条  {#Slider}

This class is used to display a `Slider`.

 ![Example Slider icon](images/slider.png)

 A `Slider` is a progress bar that adds a draggable thumb. You can touch the thumb and drag left
 or right to set the slider thumb position. As the Slider thumb is dragged, it will trigger the
 [`PositionChanged`](#Slider.PositionChanged) event, reporting the position of the `Slider` thumb. The
 reported position of the thumb can be used to dynamically update another component attribute,
 such as the [`TextBox`'s `FontSize`](#TextBox.FontSize) of a `TextBox` or the
 [Radius](animation.html#Ball.Radius) of a `Ball`.

 The `Slider` uses the following default values. However these values can be changed through the
 Designer or Blocks editor:

  * [`MinValue`](#Slider.MinValue) = 10
  * [`MaxValue`](#Slider.MaxValue) = 50
  * [`ThumbPosition`](#Slider.ThumbPosition) = 30

### 属性  {#Slider-Properties}

{:.properties}

{:id="Slider.ColorLeft" .color} *ColorLeft*
: Specifies the color of the slider bar to the left of the thumb as an alpha-red-green-blue
 integer, i.e., `0xAARRGGBB`.  An alpha of `00`
 indicates fully transparent and `FF` means opaque.

{:id="Slider.ColorRight" .color} *ColorRight*
: Specifies the color of the slider bar to the right of the thumb as an alpha-red-green-blue
 integer, i.e., `0xAARRGGBB`.  An alpha of `00`
 indicates fully transparent and `FF` means opaque.

{:id="Slider.HeightPercent" .number .wo .bo} *高度百分比*
: Specifies the `Slider`'s vertical height as a percentage
 of the [`屏幕高度`](userinterface.html#Screen.Height).

{:id="Slider.MaxValue" .number} *MaxValue*
: Sets the maximum value of slider. If the new maximum is less than the
 current minimum, then minimum and maximum will both be set to this value.
 Setting `MaxValue` resets the thumb position to halfway between [`MinValue`](#Slider.MinValue)
 and `MaxValue` and signals the [`PositionChanged`](#Slider.PositionChanged)` event.

{:id="Slider.MinValue" .number} *MinValue*
: Sets the minimum value of slider. If the new minimum is greater than the
 current maximum, then minimum and maximum will both be set to this value.
 Setting `MinValue` resets the thumb position to halfway between `MinValue`
 and [`MaxValue`](#Slider.MaxValue) and signals the [`PositionChanged`](#Slider.PositionChanged)`
 event.

{:id="Slider.ThumbEnabled" .boolean} *ThumbEnabled*
: Whether or not the slider thumb is being be shown.

{:id="Slider.ThumbPosition" .number} *ThumbPosition*
: Sets the position of the slider thumb. If this value is greater than [`MaxValue`](#Slider.MaxValue),
 then it will be set to same value as [`MaxValue`](#Slider.MaxValue). If this value is less than
 [`MinValue`](#Slider.MinValue), then it will be set to same value as [`MinValue`](#Slider.MinValue).

{:id="Slider.Visible" .boolean} *可见性*
: Specifies whether the `Slider` should be visible on the screen.  Value is `真`{:.logic.block}
 if the `Slider` is showing and `假`{:.logic.block} if hidden.

{:id="Slider.Width" .number .bo} *宽度*
: Specifies the horizontal width of the `Slider`, measured in pixels.

{:id="Slider.WidthPercent" .number .wo .bo} *宽度百分比*
: Specifies the horizontal width of the `Slider` as a percentage
 of the [`屏幕宽度`](userinterface.html#Screen.Width).

### 事件  {#Slider-Events}

{:.events}

{:id="Slider.PositionChanged"} PositionChanged(*thumbPosition*{:.number})
: Indicates that position of the slider thumb has changed.

### 方法  {#Slider-Methods}

{:.methods}
无

***
## 下拉框  {#Spinner}

A `Spinner` component that displays a dialog with a list of elements. These elements can be set
 in the Designer or Blocks Editor by setting the [`ElementsFromString`](#Spinner.ElementsFromString) property to
 a comma-separated list of values (for example, `choice 1, choice 2, choice 3`) or by setting the
 [`Elements`](#Spinner.Elements) property to a List in the Blocks editor. Spinners are created with
 the first item already selected, so selecting it does not generate an
 [`AfterSelecting`](#Spinner.AfterSelecting) event. Consequently it's useful to make the first `Spinner` item
 be a non-choice like "Select from below...".

### 属性  {#Spinner-Properties}

{:.properties}

{:id="Spinner.Elements" .list .bo} *Elements*
: Specifies the list of choices to display.

{:id="Spinner.ElementsFromString" .text .wo} *ElementsFromString*
: Set the list of choices from a string of comma-separated values.

{:id="Spinner.Height" .number .bo} *高度*
: 设置`下拉框`的垂直高度，以像素px为单位。

{:id="Spinner.HeightPercent" .number .wo .bo} *高度百分比*
: 设置`下拉框`的垂直高度相对于整个[`屏幕高度`](userinterface.html#Screen.Height)的百分比。

{:id="Spinner.Prompt" .text} *Prompt*
: Specifies the text used for the title of the Spinner window.

{:id="Spinner.Selection" .text} *Selection*
: Specifies the current selected item in the `Spinner`.

{:id="Spinner.SelectionIndex" .number .bo} *SelectionIndex*
: Set the `Spinner` selection to the element at the given index.
 If an attempt is made to set this to a number less than `1` or greater than the number of
 items in the `Spinner`, `SelectionIndex` will be set to `0`, and [`Selection`](#Spinner.Selection)
 will be set to the empty text.

{:id="Spinner.Visible" .boolean} *可见性*
: 设置`下拉框`是否显示在屏幕上，值是`真`{:.logic.block}则`下拉框`显示，`假`{:.logic.block}则隐藏。

{:id="Spinner.Width" .number .bo} *宽度*
: 设置`下拉框`的水平宽度，以像素px为单位。

{:id="Spinner.WidthPercent" .number .wo .bo} *宽度百分比*
: 设置`下拉框`的水平宽度相对于[`屏幕宽度`](userinterface.html#Screen.Width)的百分比。

### 事件  {#Spinner-Events}

{:.events}

{:id="Spinner.AfterSelecting"} AfterSelecting(*selection*{:.text})
: Event called after the user selects an item from the dropdown list.

### 方法  {#Spinner-Methods}

{:.methods}

{:id="Spinner.DisplayDropdown" class="method"} <i/> DisplayDropdown()
: Displays the dropdown list for selection, same action as when the user clicks on the spinner.

***
## 切换开关  {#Switch}

`Switch` components can detect user taps and can change their boolean state in response. They
 are identical to [`CheckBox`](#CheckBox)es except in appearance.

 Switches have an on (true) state and an off (false) state. A `Switch` component raises an event
 when the user taps it to toggle between states.

### 属性  {#Switch-Properties}

{:.properties}

{:id="Switch.BackgroundColor" .color} *背景颜色*
: 设置`切换开关`的背景颜色，使用RGBA数值表示。

{:id="Switch.Enabled" .boolean} *启用*
: 设置`切换开关`是否可以被激活和点击。

{:id="Switch.FontBold" .boolean .do} *粗体*
: 设置`切换开关`的显示字体是否是粗体。（注：有些字体不支持粗体）。

{:id="Switch.FontItalic" .boolean .do} *斜体*
: 设置`切换开关`的显示字体是否是斜体。（注：有些字体不支持斜体）。

{:id="Switch.FontSize" .number} *字体大小*
: 设置`切换开关`的字体大小，以像素px为单位。

{:id="Switch.FontTypeface" .number .do} *字体*
: 设置`切换开关`的字体，目前支持的字体有：default,  serif,  sans serif,  和 monospace。

{:id="Switch.Height" .number .bo} *高度*
: 设置`切换开关`的垂直高度，以像素px为单位。

{:id="Switch.HeightPercent" .number .wo .bo} *高度百分比*
: 设置`切换开关`的垂直高度相对于整个[`屏幕高度`](userinterface.html#Screen.Height)的百分比。

{:id="Switch.On" .boolean} *On*
: True if the switch is in the On state, false otherwise.

{:id="Switch.Text" .text} *文本*
: 设置`切换开关`的显示文本。

{:id="Switch.TextColor" .color} *文本颜色*
: 设置`切换开关`的文本颜色，使用RGBA数值表示。

{:id="Switch.ThumbColorActive" .color} *ThumbColorActive*
: Specifies the `Switch`'s thumb color when switch is in the On state.

{:id="Switch.ThumbColorInactive" .color} *ThumbColorInactive*
: Specifies the `Switch`'s thumb color when switch is in the Off state.

{:id="Switch.TrackColorActive" .color} *TrackColorActive*
: Specifies the `Switch`'s track color when in the On state.

{:id="Switch.TrackColorInactive" .color} *TrackColorInactive*
: Specifies the `Switch`'s track color when in the Off state.

{:id="Switch.Visible" .boolean} *可见性*
: 设置`切换开关`是否显示在屏幕上，值是`真`{:.logic.block}则`切换开关`显示，`假`{:.logic.block}则隐藏。

{:id="Switch.Width" .number .bo} *宽度*
: 设置`切换开关`的水平宽度，以像素px为单位。

{:id="Switch.WidthPercent" .number .wo .bo} *宽度百分比*
: 设置`切换开关`的水平宽度相对于[`屏幕宽度`](userinterface.html#Screen.Width)的百分比。

### 事件  {#Switch-Events}

{:.events}

{:id="Switch.Changed"} Changed()
: User change the state of the `Switch` from On to Off or back.

{:id="Switch.GotFocus"} GotFocus()
: `Switch` became the focused component.

{:id="Switch.LostFocus"} LostFocus()
: `Switch` stopped being the focused component.

### 方法  {#Switch-Methods}

{:.methods}
无

***
## 文本输入框  {#TextBox}

Users enter text in a text box component.

 ![Example of a TextBox](images/textbox.png)

 The initial or user-entered text value in a text box component is in the [`Text`](#TextBox.Text)
 property. If [`Text`](#TextBox.Text) is blank, you can use the [`Hint`](#TextBox.Hint) property to provide
 the user with a suggestion of what to type. The [`Hint`](#TextBox.Hint) appears as faint text in the box.

 The [`MultiLine`](#TextBox.MultiLine) property determines if the text can have more than one line.
 For a single line text box, the keyboard will close automatically when the user presses the Done
 key. To close the keyboard for multiline text boxes, the app should use the
 [`HideKeyboard`](#TextBox.HideKeyboard) method or rely on the user to press the Back key.

 The [`NumbersOnly`](#TextBox.NumbersOnly) property restricts the keyboard to accept numeric input only.

 Other properties affect the appearance of the text box
 ([`TextAlignment`](#TextBox.TextAlignment), [`BackgroundColor`](#TextBox.BackgroundColor), etc.) and whether it can be used
 ([`Enabled`](#TextBox.Enabled)).

 Text boxes are usually used with the [`Button`](#Button) component, with the user clicking on the
 `Button` when text entry is complete.

 If the text entered by the user should not be displayed, use [`PasswordTextBox`](#PasswordTextBox) instead.

### 属性  {#TextBox-Properties}

{:.properties}

{:id="TextBox.BackgroundColor" .color} *背景颜色*
: The background color of the `TextBox``. You can choose a color by name in the Designer or in
 the Blocks Editor. The default background color is 'default' (shaded 3-D look).

{:id="TextBox.Enabled" .boolean} *启用*
: If set, user can enter text into the `TextBox`.

{:id="TextBox.FontBold" .boolean .do} *粗体*
: 设置`文本输入框`的显示字体是否是粗体。（注：有些字体不支持粗体）。

{:id="TextBox.FontItalic" .boolean .do} *斜体*
: 设置`文本输入框`的显示字体是否是斜体。（注：有些字体不支持斜体）。

{:id="TextBox.FontSize" .number} *字体大小*
: 设置`文本输入框`的字体大小，以像素px为单位。

{:id="TextBox.FontTypeface" .number .do} *字体*
: 设置`文本输入框`的字体，目前支持的字体有：`0` (default), `1` (serif), `2` (sansserif), 和 `3` (monospace)。

{:id="TextBox.Height" .number .bo} *高度*
: 设置`文本输入框`的垂直高度，以像素px为单位。

{:id="TextBox.HeightPercent" .number .wo .bo} *高度百分比*
: 设置`文本输入框`的垂直高度相对于整个[`屏幕高度`](userinterface.html#Screen.Height)的百分比。

{:id="TextBox.Hint" .text} *Hint*
: `TextBox` hint for the user.

{:id="TextBox.MultiLine" .boolean} *MultiLine*
: If true, then this `TextBox` accepts multiple lines of input, which are entered using the
 return key. For single line text boxes there is a Done key instead of a return key, and
 pressing Done hides the keyboard. The app should call the HideKeyboard method to hide the
 keyboard for a mutiline text box.

{:id="TextBox.NumbersOnly" .boolean} *NumbersOnly*
: If true, then this `TextBox`` accepts only numbers as keyboard input. Numbers can include a
 decimal point and an optional leading minus sign. This applies to keyboard input only. Even
 if `NumbersOnly` is true, you can set the text to anything at all using the
 [`Text`](#TextBox.Text) property.

{:id="TextBox.ReadOnly" .boolean} *ReadOnly*
: Whether the TextBox is read-only. By default, this is `真`{:.logic.block}.

{:id="TextBox.Text" .text} *文本*
: The text in the `TextBox`, which can be set by the programmer in the Designer or Blocks Editor,
 or it can be entered by the user (unless the [`Enabled`](#TextBox.Enabled) property is false).

{:id="TextBox.TextAlignment" .number .do} *文本对齐*
: 设置`文本输入框`文本的对齐方式，有效值有： 
`0`（正常；例如，如果文本从左到右书写，则左对齐）、
`1`（居中）或
`2`（相反；例如，如果文本从左到右书写，则右对齐）。

{:id="TextBox.TextColor" .color} *文本颜色*
: 设置`文本输入框`的文本颜色，使用RGBA数值表示。

{:id="TextBox.Visible" .boolean} *可见性*
: 设置`文本输入框`是否显示在屏幕上，值是`真`{:.logic.block}则`文本输入框`显示，`假`{:.logic.block}则隐藏。

{:id="TextBox.Width" .number .bo} *宽度*
: 设置`文本输入框`的水平宽度，以像素px为单位。

{:id="TextBox.WidthPercent" .number .wo .bo} *宽度百分比*
: 设置`文本输入框`的水平宽度相对于[`屏幕宽度`](userinterface.html#Screen.Width)的百分比。

### 事件  {#TextBox-Events}

{:.events}

{:id="TextBox.GotFocus"} GotFocus()
: Event raised when the `TextBox` is selected for input, such as by
 the user touching it.

{:id="TextBox.LostFocus"} LostFocus()
: Event raised when the `TextBox` is no longer selected for input, such
 as if the user touches a different text box.

### 方法  {#TextBox-Methods}

{:.methods}

{:id="TextBox.HideKeyboard" class="method"} <i/> HideKeyboard()
: Hide the keyboard. Only multiline text boxes need this. Single line text boxes close the
 keyboard when the users presses the Done key.

{:id="TextBox.RequestFocus" class="method"} <i/> RequestFocus()
: Request focus to current `TextBox`.

***
## 时间选择框  {#TimePicker}

A button that, when clicked on, opens a dialog to allow the user to select a time.

 Note: Date and time are manipulated using methods in the [`Clock`](sensors.html#Clock) component.

### 属性  {#TimePicker-Properties}

{:.properties}

{:id="TimePicker.BackgroundColor" .color} *背景颜色*
: Specifies the `TimePicker`'s background color as an alpha-red-green-blue
 integer.  If an [`Image`](#TimePicker.Image) has been set, the color
 change will not be visible until the [`Image`](#TimePicker.Image) is removed.

{:id="TimePicker.Enabled" .boolean} *启用*
: 设置`时间选择框`是否可以被激活和点击。

{:id="TimePicker.FontBold" .boolean} *粗体*
: 设置`时间选择框`的显示字体是否是粗体。（注：有些字体不支持粗体）。

{:id="TimePicker.FontItalic" .boolean} *斜体*
: 设置`时间选择框`的显示字体是否是斜体。（注：有些字体不支持斜体）。

{:id="TimePicker.FontSize" .number} *字体大小*
: 设置`时间选择框`的字体大小，以像素px为单位。

{:id="TimePicker.FontTypeface" .number .do} *字体*
: 设置`时间选择框`的字体，目前支持的字体有：default,  serif,  sans serif,  和 monospace。

{:id="TimePicker.Height" .number .bo} *高度*
: 设置`时间选择框`的垂直高度，以像素px为单位。

{:id="TimePicker.HeightPercent" .number .wo .bo} *高度百分比*
: 设置`时间选择框`的垂直高度相对于整个[`屏幕高度`](userinterface.html#Screen.Height)的百分比。

{:id="TimePicker.Hour" .number .ro .bo} *Hour*
: Returns the hour of the time that was last picked using the `TimePicker``.
 The time returned is always in the 24hour format.

{:id="TimePicker.Image" .text} *Image*
: Specifies the path of the `TimePicker`'s image. If there is both an `Image` and a
 [`BackgroundColor`](#TimePicker.BackgroundColor) specified, only the `Image` will be visible.

{:id="TimePicker.Instant" .InstantInTime .ro .bo} *Instant*
: Returns the instant in time that was last picked using the `TimePicker`.

{:id="TimePicker.Minute" .number .ro .bo} *Minute*
: Returns the hour of the time that was last picked using the `TimePicker`.
 The time returned is always in the 24hour format.

{:id="TimePicker.Shape" .number .do} *Shape*
: Specifies the shape of the `TimePicker`. The valid values for this property are `0` (default),
 `1` (rounded), `2` (rectangle), and `3` (oval). The `Shape` will not be visible if an
 [`Image`](#TimePicker.Image) is used.

{:id="TimePicker.ShowFeedback" .boolean} *ShowFeedback*
: Specifies if a visual feedback should be shown when a `TimePicker` with an assigned
 [`Image`](#TimePicker.Image) is pressed.

{:id="TimePicker.Text" .text} *文本*
: 设置`时间选择框`的显示文本。

{:id="TimePicker.TextAlignment" .number .do} *文本对齐*
: 设置`时间选择框`文本的对齐方式，有效值有： 
`0`（正常；例如，如果文本从左到右书写，则左对齐）、
`1`（居中）或
`2`（相反；例如，如果文本从左到右书写，则右对齐）。

{:id="TimePicker.TextColor" .color} *文本颜色*
: 设置`时间选择框`的文本颜色，使用RGBA数值表示。

{:id="TimePicker.Visible" .boolean} *可见性*
: 设置`时间选择框`是否显示在屏幕上，值是`真`{:.logic.block}则`时间选择框`显示，`假`{:.logic.block}则隐藏。

{:id="TimePicker.Width" .number .bo} *宽度*
: 设置`时间选择框`的水平宽度，以像素px为单位。

{:id="TimePicker.WidthPercent" .number .wo .bo} *宽度百分比*
: 设置`时间选择框`的水平宽度相对于[`屏幕宽度`](userinterface.html#Screen.Width)的百分比。

### 事件  {#TimePicker-Events}

{:.events}

{:id="TimePicker.AfterTimeSet"} AfterTimeSet()
: This event is run when a user has set the time in the popup dialog.

{:id="TimePicker.GotFocus"} GotFocus()
: Indicates the cursor moved over the `TimePicker` so it is now possible
 to click it.

{:id="TimePicker.LostFocus"} LostFocus()
: Indicates the cursor moved away from the `TimePicker` so it is now no
 longer possible to click it.

{:id="TimePicker.TouchDown"} TouchDown()
: Indicates that the `TimePicker` was pressed down.

{:id="TimePicker.TouchUp"} TouchUp()
: Indicates that the `TimePicker` has been released.

### 方法  {#TimePicker-Methods}

{:.methods}

{:id="TimePicker.LaunchPicker" class="method"} <i/> LaunchPicker()
: Launches the `TimePicker` dialog.

{:id="TimePicker.SetTimeToDisplay" class="method"} <i/> SetTimeToDisplay(*hour*{:.number},*minute*{:.number})
: Allows the user to set the time to be displayed when the `TimePicker` opens. Valid values for
 the hour field are 0-23 and 0-59 for the second field.

{:id="TimePicker.SetTimeToDisplayFromInstant" class="method"} <i/> SetTimeToDisplayFromInstant(*instant*{:.InstantInTime})
: Allows the instant to set the hour and minute to be displayed when the `TimePicker` opens.
 Instants are used in [`Clock`](sensors.html#Clock), [`DatePicker`](#DatePicker), and [`TimePicker`](#TimePicker)
 components.

***
## Web浏览框  {#WebViewer}

Component for viewing Web pages.

 ![WebViewer icon](images/webviewer.png)

 The [`HomeUrl`](#WebViewer.HomeUrl) can be specified in the Designer or in the Blocks Editor. The view can be
 set to follow links when they are tapped, and users can fill in Web forms.

 **Warning:** This is not a full browser. For example, pressing the phone's hardware Back key
 will exit the app, rather than move back in the browser history.

 You can use the [`WebViewString`](#WebViewer.WebViewString) property to communicate between your app and
 Javascript code running in the `WebViewer` page. In the app, you get and set
 [`WebViewString`](#WebViewer.WebViewString). In the `WebViewer`, you include Javascript that references the
 `window.AppInventor` object, using the methods `getWebViewString()` and `setWebViewString(text)`.

 For example, if the `WebViewer` opens to a page that contains the Javascript command
 ```javascript
 document.write("The answer is" + window.AppInventor.getWebViewString());
 ```
 and if you set [`WebViewString`](#WebViewer.WebViewString) to "hello", then the web page will show
 ```
 The answer is hello.
 ```
 And if the Web page contains Javascript that executes the command
 ```javascript
 windowAppInventor.setWebViewString("hello from Javascript"),
 ```
 then the value of the [`WebViewString`](#WebViewer.WebViewString) property will be
 ```
 hello from Javascript.
 ```
 Calling `setWebViewString` from JavaScript will also run the [`WebViewStringChange`](#WebViewer.WebViewStringChange)
 event so that the blocks can handle when the [`WebViewString`](#WebViewer.WebViewString) property changes.

 Beginning with release nb184a, you can specify a HomeUrl beginning with `http://localhost/`
 to reference assets both in the Companion and in compiled apps. Previously, apps needed to use
 `file:///android_asset/` in compiled apps and `/sdcard/AppInventor/assets/` in the Companion.
 Both of these options will continue to work but the `http://localhost/` approach will work in
 both scenarios. You may also use "file:///appinventor_asset/" which provides more security by
 preventing the use of asynchronous requests from JavaScript in your assets from going out to the
 web.

### 属性  {#WebViewer-Properties}

{:.properties}

{:id="WebViewer.CurrentPageTitle" .text .ro .bo} *CurrentPageTitle*
: Returns the title of the page currently being viewed

{:id="WebViewer.CurrentUrl" .text .ro .bo} *CurrentUrl*
: Returns the URL currently being viewed. This could be different from the [`HomeUrl`](#WebViewer.HomeUrl)
 if new pages were visited by following links.

{:id="WebViewer.FollowLinks" .boolean} *FollowLinks*
: Determines whether to follow links when they are tapped in the `WebViewer`. If you follow
 links, you can use [`GoBack`](#WebViewer.GoBack) and [`GoForward`](#WebViewer.GoForward) to navigate the browser history.

{:id="WebViewer.Height" .number .bo} *高度*
: 设置`Web浏览框`的垂直高度，以像素px为单位。

{:id="WebViewer.HeightPercent" .number .wo .bo} *高度百分比*
: 设置`Web浏览框`的垂直高度相对于整个[`屏幕高度`](userinterface.html#Screen.Height)的百分比。

{:id="WebViewer.HomeUrl" .text} *HomeUrl*
: Specifies the URL of the page the `WebViewer` should initially open to. Setting this will
 load the page.

{:id="WebViewer.IgnoreSslErrors" .boolean} *IgnoreSslErrors*
: Determine whether or not to ignore SSL errors. Set to `真`{:.logic.block} to ignore errors.
 Use this to accept self signed certificates from websites.

{:id="WebViewer.PromptforPermission" .boolean} *PromptforPermission*
: Determine if the user should be prompted for permission to use the geolocation API while in
 the `WebViewer`. If `真`{:.logic.block}, prompt the user of the `WebViewer` to give
 permission to access the geolocation API. If `假`{:.logic.block}, assume permission is
 granted.

{:id="WebViewer.UsesLocation" .boolean .wo .do} *UsesLocation*
: Specifies whether or not this `WebViewer` can access the JavaScript
 geolocation API.

{:id="WebViewer.Visible" .boolean} *可见性*
: 设置`Web浏览框`是否显示在屏幕上，值是`真`{:.logic.block}则`Web浏览框`显示，`假`{:.logic.block}则隐藏。

{:id="WebViewer.WebViewString" .text .bo} *WebViewString*
: Gets the `WebView`'s String, which is viewable through Javascript in the `WebView` as the
 `window.AppInventor` object.

{:id="WebViewer.Width" .number .bo} *宽度*
: 设置`Web浏览框`的水平宽度，以像素px为单位。

{:id="WebViewer.WidthPercent" .number .wo .bo} *宽度百分比*
: 设置`Web浏览框`的水平宽度相对于[`屏幕宽度`](userinterface.html#Screen.Width)的百分比。

### 事件  {#WebViewer-Events}

{:.events}

{:id="WebViewer.BeforePageLoad"} BeforePageLoad(*url*{:.text})
: When a page is about to load this event is run.

{:id="WebViewer.ErrorOccurred"} ErrorOccurred(*errorCode*{:.number},*description*{:.text},*failingUrl*{:.text})
: When an error occurs this event is run.

{:id="WebViewer.PageLoaded"} PageLoaded(*url*{:.text})
: When a page is finished loading this event is run.

{:id="WebViewer.WebViewStringChange"} WebViewStringChange(*value*{:.text})
: Event that runs when the `AppInventor.setWebViewString` method is called from JavaScript.
 The new [`WebViewString`](#WebViewer.WebViewString) is given by the `value`{:.variable.block} parameter.

### 方法  {#WebViewer-Methods}

{:.methods}

{:id="WebViewer.CanGoBack" class="method returns boolean"} <i/> CanGoBack()
: Returns true if the WebViewer can go back in the history list.

{:id="WebViewer.CanGoForward" class="method returns boolean"} <i/> CanGoForward()
: Returns true if the WebViewer can go forward in the history list.

{:id="WebViewer.ClearCaches" class="method"} <i/> ClearCaches()
: Clear the internal webview cache, both ram and disk. This is useful
 when using the `WebViewer` to poll a page that may not be sending
 appropriate cache control headers.

{:id="WebViewer.ClearCookies" class="method"} <i/> ClearCookies()
: Clear the webview's cookies. This is useful if you want to
 sign the user out of a website that uses them to store logins.

{:id="WebViewer.ClearLocations" class="method"} <i/> ClearLocations()
: Clear Stored Location permissions. When the geolocation API is used in
 the `WebViewer`, the end user is prompted on a per URL basis for whether
 or not permission should be granted to access their location. This
 function clears this information for all locations.

  As the permissions interface is not available on phones older then
  Eclair, this function is a no-op on older phones.

{:id="WebViewer.GoBack" class="method"} <i/> GoBack()
: Go back to the previous page in the history list. Does nothing if there is no previous page.

{:id="WebViewer.GoForward" class="method"} <i/> GoForward()
: Go forward to the next page in the history list. Does nothing if there is no next page.

{:id="WebViewer.GoHome" class="method"} <i/> GoHome()
: Loads the  page from the home URL.  This happens automatically when
 home URL is changed.

{:id="WebViewer.GoToUrl" class="method"} <i/> GoToUrl(*url*{:.text})
: Load the page at the given URL.

{:id="WebViewer.Reload" class="method"} <i/> Reload()
: Reload the current page.

{:id="WebViewer.RunJavaScript" class="method"} <i/> RunJavaScript(*js*{:.text})
: Run JavaScript in the current page.

{:id="WebViewer.StopLoading" class="method"} <i/> StopLoading()
: Stop loading a page.
