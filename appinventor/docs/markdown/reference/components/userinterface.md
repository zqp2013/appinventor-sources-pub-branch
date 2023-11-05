---
layout: documentation
title: 用户界面（UI）组件
description: 用户界面（UI）组件参考文档：包括按钮、复选框、日期选择框、图像、标签、列表选择框、列表显示框、对话框（通知器）、密码输入框、屏幕、滑动条、下拉框、切换开关、文本输入框、时间选择框、Web浏览框。
---

* TOC
{:toc}

[&laquo; 返回首页](index.html)
# <i class="mdi mdi-view-split-horizontal"></i>  用户界面（UI）组件

目录：

1. ![icon](images/Screen.png)  [屏幕（Screen）](#Screen)
1. ![icon](images/Button.png)  [按钮（Button）](#Button)
1. ![icon](images/CheckBoxIcon.png)  [复选框（CheckBox）](#CheckBox)
1. ![icon](images/DatePicker.png)   [日期选择框（DatePicker）](#DatePicker)
1. ![icon](images/ImageIcon.png)  [图像（Image）](#Image)
  * [TaifunImage *拓展：图像高级处理*](../extensions/TaifunImage.html)
  * [SimpleBase64 *拓展：图像Base64编解码*](connectivity.html#SimpleBase64)
1. ![icon](images/Label.png)  [标签（Label）](#Label)
1. ![icon](images/ListPicker.png)  [列表选择框（ListPicker）](#ListPicker)
1. ![icon](images/ListView.png)  [列表显示框（ListView）](#ListView)
1. ![icon](images/Notifier.png)  [对话框（Notifier）](#Notifier)
1. ![icon](images/PasswordTextBoxIcon.png)  [密码输入框（PasswordTextBox）](#PasswordTextBox)
1. ![icon](images/slider.png)  [滑动条（Slider）](#Slider)
1. ![icon](images/Spinner.png)  [下拉框（Spinner）](#Spinner)
1. ![icon](images/Switch.png)  [切换开关（Switch）](#Switch)
1. ![icon](images/TextBoxIcon.png)  [文本输入框（TextBox）](#TextBox)
1. ![icon](images/TimePicker.png)  [时间选择框（TimePicker）](#TimePicker)
1. ![icon](images/WebViewer.png)  [Web浏览框（WebViewer）](#WebViewer)



## ![icon](images/Screen.png)  屏幕  {#Screen}

包含程序中所有其他组件的顶层组件。

### 属性  {#Screen-Properties}

{:.properties}

{:id="Screen.AboutScreen" .text} *关于屏幕*
: 有关屏幕的信息，系统菜单 -> “关于此应用程序”选中时出现。它用来向用户介绍你的应用程序，在多屏幕应用程序中，每个屏幕都拥有“关于屏幕”的信息。

{:id="Screen.AccentColor" .color .do} *交互性颜色*
: 这是新版本Android中用于突出显示和其他用户界面交互的交互性颜色。受此属性影响的包括 [`对话框`](#Notifier)、[`日期选择框`](#DatePicker) 等组件**触发的弹出框**。

  > PrimaryColor：  主题颜色。app的主要颜色，即整个屏幕和所有控件的主要颜色，首选颜色。
  >
  > SecondaryColor：提示性颜色。这颜色一般比PrimaryColor亮一些或暗一些，取决于白天模式还是黑暗模式。一般用于提示相关动作或信息，提示性颜色。
  >
  > AccentColor：   交互性颜色。这颜色一般用于交互性的控件颜色，比如FloatingButton、TextField、Cursor、ProgressBar、Selection、Links等具体交互性的颜色。
  >
  > 另外附上Android Material设计图的Color说明：
  >
  > ![Android_Color说明](images/Android_Color说明.png)

{:id="Screen.PrimaryColor" .color .do} *主题颜色*
: 这是用作 Android 主题部分的主要颜色，包括“屏幕”标题栏颜色。

{:id="Screen.PrimaryColorDark" .color .do} *深色主题颜色*
: 这是当 [`主题`](#Screen.Theme) 属性指定为 `深色` 时使用的主要颜色。它适用于许多元素，包括“屏幕”的标题栏。

{:id="Screen.AlignHorizontal" .number} *水平对齐*
: 表示屏幕内容如何水平对齐的数字，含义如下：

  `1` （左对齐）

  `2` （右对齐）

  `3` （水平居中）

{:id="Screen.AlignVertical" .number} *垂直对齐*
: 表示屏幕内容如何垂直对齐的数字，含义如下：

  `1` （顶部对齐）

  `2` （垂直居中）

  `3` （底部对齐）
  
  如果屏幕可滚动，垂直对齐将没有效果。

{:id="Screen.AppName" .text .wo .do} *应用名称*
: 这是手机中安装的应用程序的显示名称。如果“应用名称”为空，则当项目构建时，它将被设置为项目的名称。

{:id="Screen.BackgroundColor" .color} *背景颜色*
: 设置`屏幕`的背景颜色，使用RGBA数值表示，如果设置了[`背景图像`](#Screen.BackgroundImage)属性，则不能显示背景颜色直到删除[`背景图像`](#Screen.BackgroundImage)属性为止。

{:id="Screen.BackgroundImage" .text} *背景图像*
: 设置`屏幕`背景图像的路径，如果同时设置了 `背景图像` 和 `背景颜色`，则只有 `背景图像` 可见。

{:id="Screen.BigDefaultText" .boolean} *文本变大*
: 选中（或设置`真`）后，所有默认大小的文本都会增加大小。

{:id="Screen.BlocksToolkit" .text .wo .do} *块工具包*
: 表示屏幕子集的 JSON 字符串。模板应用程序的作者可以使用它来控制项目中可用的组件、设计器属性和代码块。

{:id="Screen.OpenScreenAnimation" .text} *开屏动画*
: 设置此表单打开的过渡动画类型。

{:id="Screen.CloseScreenAnimation" .text} *关屏动画*
: 设置表单关闭和返回到后面表单的过渡动画类型。

{:id="Screen.DefaultFileScope" .com.google.appinventor.components.common.FileScopeEnum .wo .do} *默认文件范围*
: 设置组件访问文件时使用的默认范围。注意 [`文件管理器`](../storage.html#File) 组件有自己的属性来控制文件范围。

{:id="Screen.Width" .number .ro .bo} *宽度*
: 返回屏幕宽度（以像素px为单位）（x 尺寸）。

{:id="Screen.Height" .number .ro .bo} *高度*
: 返回屏幕高度（以像素px为单位）（y 尺寸）。

{:id="Screen.HighContrast" .boolean} *高对比度*
: 选中（或设置`真`）后，将打开高对比度模式。

{:id="Screen.Icon" .text .wo .do} *图标*
: 设置图像，用于应用程序图标显示，需是方形尺寸 png 或 jpeg 图像，最大分辨率 1024 x 1024 像素。

  **较大的图像可能会导致编译或安装应用程序失败**。
  
  构建服务器将为 Android 设备生成标准尺寸的图像。

{:id="Screen.Platform" .text .ro .bo} *平台*
: 获取运行应用程序的底层平台的名称。目前，这是文本`Android`，将来可能会支持其他平台。

{:id="Screen.PlatformVersion" .text .ro .bo} *平台版本*
: 获取运行应用程序的平台的版本号。这通常是带点的版本数字，例如 10.0，但是，它可以返回任何值，因此需要考虑处理意外的数据。如果平台版本不可用，将返回空文本。

{:id="Screen.ScreenOrientation" .text} *屏幕方向*
: 指定屏幕方向，为文本值。常用的值为：

  * 横向 (`landscape`)

  * 纵向 (`portrait`)

  * 传感器 (`sensor`)

  * 用户 (`user`)

  * 未指定 (`unspecified`)

  查看 Android 开发者可能的完整列表的文档[选项](https://developer.android.com/reference/android/R.attr.html#screenOrientation)。

{:id="Screen.Scrollable" .boolean} *允许滚动*
: 勾选（或设置`真`）后，屏幕上会出现一个垂直滚动条，应用程序高度能超出设备的物理高度。未选中时，应用程序高度受限于设备的高度。

{:id="Screen.ShowListsAsJson" .boolean .do} *以JSON格式显示列表*
: 如果为`真`{:.logic.block}（默认值），列表将显示为 JSON/Python 表示法中的字符串，例如 `[1, "a", true]`。

  如果为`假`{:.logic.block}，则列表将显示在 LISP 中表示法，例如 `(1 a true)`。

    **注意：** 该属性仅出现在 Screen1 中，Screen1 的值决定了应用程序中所有屏幕的行为。

{:id="Screen.ShowStatusBar" .boolean} *显示状态栏*
: 状态栏是屏幕最上面的栏，该属性设置状态栏是否是可见的。

{:id="Screen.Sizing" .text .wo .do} *屏幕大小*
: 如果设置为响应式（默认），屏幕布局将使用设备的实际分辨率。请参阅App中的[响应式设计文档](../other/responsiveDesign.html)了解更多信息。

  如果设置为`固定大小`，将为单个固定尺寸屏幕创建屏幕布局并自动缩放。

    **注意：** 此属性仅出现在 Screen1 上，并控制该应用程序中所有屏幕的大小。

{:id="Screen.Theme" .text .wo .do} *主题*
: 选择应用程序的主题，主题只能在编译时设置，与AI伴侣在实时开发期间会有细微的差别。可选项有：

    * `Classic`（经典），与旧版本的 App Inventor 相同

    * `Device Default`（设备默认），与当前运行的 Android 设备主题一致，可通过[“主题颜色”](#Screen.PrimaryColor)设置。

    * `Black Title Text`（黑色标题），这也是“设备默认”主题，但标题文本为黑色
    
    * `Dark`（深色主题），这是“设备默认”主题的深色版本，可通过[“深色主题颜色”](#Screen.PrimaryColorDark)设置。

{:id="Screen.Title" .text} *标题*
: 设置标题属性，在表单的标题栏为表单设置新的标题。

{:id="Screen.TitleVisible" .boolean} *标题展示*
: 标题栏是屏幕顶部的灰色栏，该属性设置标题栏是否是可见的。

{:id="Screen.TutorialURL" .text .wo .do} *侧边栏教程网址*
: 设置侧边栏中文教程URL地址。

{:id="Screen.VersionCode" .number .wo .do} *版本编号*
: 每次为应用商店创建新的 Android 应用程序包文件(APK)时都必须递增的整数值。

{:id="Screen.VersionName" .text .wo .do} *版本名称*
: 可以更改的字符串，以允许应用商店用户区分不同版本的应用程序。

### 事件  {#Screen-Events}

{:.events}

{:id="Screen.BackPressed"} 回退时()
: 设备后退按钮已按下。

{:id="Screen.ErrorOccurred"} 出现错误时(*组件*{:.component},*函数名称*{:.text},*错误编号*{:.number},*消息*{:.text})
: 发生错误时触发该事件。只有某些错误才会触发，对于这些错误，系统将默认显示通知，可以使用此事件来定制错误处理逻辑。

{:id="Screen.Initialize"} 初始化()
: 初始化事件在屏幕启动时运行，并且每个屏幕**仅运行一次**。

{:id="Screen.OtherScreenClosed"} 关闭其他屏幕时(*其他屏幕名称*{:.text},*返回结果*{:.any})
: 当另一个屏幕关闭并且控制权返回到此屏幕时触发该事件。

{:id="Screen.PermissionDenied"} 权限被拒绝时(*组件*{:.component},*函数名称*{:.text},*权限名称*{:.text})
: 当请求所需权限被用户拒绝时要处理的事件。

{:id="Screen.PermissionGranted"} 权限被授予时(*权限名称*{:.text})
: 当请求所需权限被用户授予时要处理的事件。该事件仅在获得许可时运行，是 [`请求权限`](#Screen.AskForPermission) 方法的响应。

{:id="Screen.ScreenOrientationChanged"} 屏幕方向改变时()
: 屏幕方向已改变时触发此事件。

### 方法  {#Screen-Methods}

{:.methods}

{:id="Screen.AskForPermission" class="method"} <i/> 请求权限(*权限名称*{:.text})
: 请求用户授予对敏感权限的访问权限，例如`精确定位`权限。

  如果用户许可了授权，[`权限被授予时`](#Screen.PermissionGranted) 事件将被触发；如果用户拒绝授权，[`权限被拒绝时`](#Screen.PermissionDenied)事件将被触发。

   **注意：** 最佳做法是仅在需要时请求权限，App Inventor组件将在必要时执行。不建议在[`初始化`](#Screen.Initialize) 事件中使用`请求权限`，除非访问该权限对你的应用是预先需要的，例如导航应用需要定位服务。

{:id="Screen.HideKeyboard" class="method"} <i/> 隐藏键盘()
: 隐藏软键盘。


## ![icon](images/Button.png)  按钮（Button）  {#Button}

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

  `0`（默认）

  `1` （圆形）

  `2`（矩形）

  `3`（椭圆形）。

  如果设置了[`图像`](#Button.Image)，则`形状`将不可见。

{:id="Button.ShowFeedback" .boolean} *显示反馈*
: 设置`按钮`指定 [`图像`](#Button.Image)后被按压是否显示视觉反馈。

{:id="Button.Text" .text} *文本*
: 设置`按钮`的显示文本。

{:id="Button.TextAlignment" .number .do} *文本对齐*
: 设置`按钮`文本的对齐方式，有效值有： 

  `0`（正常；例如，如果文本从左到右书写，则左对齐）

  `1`（居中）

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


## ![icon](images/CheckBoxIcon.png)  复选框  {#CheckBox}

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



## ![icon](images/DatePicker.png)  日期选择框  {#DatePicker}

单击一个按钮弹出对话框以允许用户选择日期(公历)。

  注意：日期和时间可使用 [计时器](sensors.html#Clock) 组件中的方法进行操作。

### 属性  {#DatePicker-Properties}

{:.properties}

{:id="DatePicker.BackgroundColor" .color} *背景颜色*
: 设置`日期选择框`的背景颜色，使用RGBA数值表示，如果设置了[`图像`](#DatePicker.Image)属性，则不能显示背景颜色直到删除[`图像`](#DatePicker.Image)属性为止。

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
: 返回上次使用 `日期选择框` 选择的日期的时间对象。

{:id="DatePicker.Year" .number .ro .bo} *年度*
: 返回上次使用 `日期选择框` 选择的年份。

{:id="DatePicker.Month" .number .ro .bo} *月份*
: 返回上次使用 `日期选择框` 选择的月份数。

{:id="DatePicker.MonthInText" .text .ro .bo} *月份名称*
: 返回上次使用 `日期选择框` 选择的月份名称。

{:id="DatePicker.Day" .number .ro .bo} *日期*
: 返回上次使用 `日期选择框` 选择的日期数字。

{:id="DatePicker.Shape" .number .do} *形状*
: 设置`日期选择框`的形状，此属性的有效值为：

  `0`（默认）

  `1` （圆形）

  `2`（矩形）

  `3`（椭圆形）。
  
  如果设置了[`图像`](#DatePicker.Image)，则`形状`将不可见。

{:id="DatePicker.ShowFeedback" .boolean} *显示反馈*
: 设置`日期选择框`指定 [`图像`](#DatePicker.Image)后被按压是否显示视觉反馈。

{:id="DatePicker.Text" .text} *文本*
: 设置`日期选择框`的显示文本。

{:id="DatePicker.TextAlignment" .number .do} *文本对齐*
: 设置`日期选择框`文本的对齐方式，有效值有： 

  `0`（正常；例如，如果文本从左到右书写，则左对齐）

  `1`（居中）

  `2`（相反；例如，如果文本从左到右书写，则右对齐）。

{:id="DatePicker.TextColor" .color} *文本颜色*
: 设置`日期选择框`的文本颜色，使用RGBA数值表示。

{:id="DatePicker.Visible" .boolean} *可见性*
: 设置`日期选择框`是否显示在屏幕上，值是`真`{:.logic.block}则`日期选择框`显示，`假`{:.logic.block}则隐藏。

{:id="DatePicker.Width" .number .bo} *宽度*
: 设置`日期选择框`的水平宽度，以像素px为单位。

{:id="DatePicker.WidthPercent" .number .wo .bo} *宽度百分比*
: 设置`日期选择框`的水平宽度相对于[`屏幕宽度`](userinterface.html#Screen.Width)的百分比。

### 事件  {#DatePicker-Events}

{:.events}

{:id="DatePicker.AfterDateSet"} 完成日期设定()
: 用户在对话框中选择日期后运行的事件。

{:id="DatePicker.GotFocus"} 获得焦点()
: 表示光标已经移到`日期选择框`上，因此现在可以点击它。

{:id="DatePicker.LostFocus"} 失去焦点()
: 表示光标已从`日期选择框`移开，因此现在不能点击它了。

{:id="DatePicker.TouchDown"} 被按压()
: 表示`日期选择框`按钮被按下。

{:id="DatePicker.TouchUp"} 被松开()
: 表示`日期选择框`按钮被松开。

### 方法  {#DatePicker-Methods}

{:.methods}

{:id="DatePicker.LaunchPicker" class="method"} <i/> 打开选择框()
: 启动日期选择器对话框。在用户确认选择后，[`完成日期设定`](#DatePicker.AfterDateSet) 事件将被触发。

{:id="DatePicker.SetDateToDisplay" class="method"} <i/> 设置日期显示(*年*{:.number},*月*{:.number},*日*{:.number})
: 允许用户设置日期选择器打开时显示的日期。

  月份字段的有效值为 1-12，日期字段的有效值为 1-31。

{:id="DatePicker.SetDateToDisplayFromInstant" class="method"} <i/> 设置显示某时刻的日期(*时刻*{:.InstantInTime})
: 选择器打开时允许用户设置显示指定时刻的日期。

  时刻用于 [`计时器`](sensors.html#Clock)、[`日期选择框`](#DatePicker) 和 [`时间选择框`](#TimePicker) 组件。

## ![icon](images/ImageIcon.png)  图像  {#Image}

用于显示图像和基本动画的组件。要显示的图片以及图像外观的其他方面，可以在“界面设计”视图或“程序设计”视图中进行设置。

### 属性  {#Image-Properties}

{:.properties}

{:id="Image.AlternateText" .text .wo} *替代文本*
: 对图像的描述文本，当无法正确加载图片时，这段文本描述将会被显示。（同HTML中 `alt` 属性 ```<img src="" alt="图片无法正常显示时，显示该文字描述" />```）。

{:id="Image.Animation" .text .wo .bo} *动画形式*
: 一种简单的动画形式，可以将少量动画效果附加到图像上。包括：

  * 向右慢移：`ScrollRightSlow`
  * 向右移动：`ScrollRight`
  * 向右快移：`ScrollRightFast`
  * 向左慢移：`ScrollLeftSlow`
  * 向左移动：`ScrollLeft`
  * 向左快移：`ScrollLeftFast`
  * 停止移动：`Stop`

{:id="Image.Clickable" .boolean} *可点击*
: 设置`图像`是否可点击（即是否触发[`被点击`](#Image.Click)事件，默认不触发）。

{:id="Image.Height" .number .bo} *高度*
: 设置`图像`的垂直高度，以像素px为单位。

{:id="Image.HeightPercent" .number .wo .bo} *高度百分比*
: 设置`图像`的垂直高度相对于整个[`屏幕高度`](userinterface.html#Screen.Height)的百分比。

{:id="Image.Picture" .text} *图片*
: 设置`图像`的图片路径。

{:id="Image.RotationAngle" .number} *旋转角度*
: `图像`显示图片的角度发生了旋转。此旋转不会出现在“界面设计”视图的屏幕上，只会出现在设备上。

{:id="Image.ScalePictureToFit" .boolean .wo} *自动缩放图片*
: 设置是否应自动调整图片大小以匹配`图像`组件的大小。

{:id="Image.Scaling" .number .bo} *缩放模式*
: 此属性确定图片如何根据图像的高度或宽度进行缩放。

  * 比例缩放(0)：可保留图片的宽高比例。
  * 自动缩放(1)：自动调整图片的宽高，与`图像`组件区域匹配。

{:id="Image.Visible" .boolean} *可见性*
: 设置`图像`是否显示在屏幕上，值是`真`{:.logic.block}则`图像`显示，`假`{:.logic.block}则隐藏。

{:id="Image.Width" .number .bo} *宽度*
: 设置`图像`的水平宽度，以像素px为单位。

{:id="Image.WidthPercent" .number .wo .bo} *宽度百分比*
: 设置`图像`的水平宽度相对于[`屏幕宽度`](userinterface.html#Screen.Width)的百分比。

### 事件  {#Image-Events}

{:.events}

{:id="Image.Click"} 被点击()
: 单击图像时触发该事件。**注意：**必须将[`可点击`](#Image.Clickable)属性勾上，或设置属性值为`真`，才能触发此事件！！

### 方法  {#Image-Methods}

{:.methods}
无



## ![icon](images/Label.png)  标签  {#Label}

标签是用于显示文本的组件。

标签显示由 `文本` 属性指定的文本内容，其他属性可以在“界面设计”视图或“程序设计”视图中进行设置，控制文本的外观和位置等。

### 属性  {#Label-Properties}

{:.properties}

{:id="Label.BackgroundColor" .color} *背景颜色*
: 指定`标签`的背景颜色，使用RGBA数值表示。

{:id="Label.FontBold" .boolean .do} *粗体*
: 指定`标签`的文本是否为粗体（有些字体不支持粗体）。

{:id="Label.FontItalic" .boolean .do} *斜体*
: : 指定`标签`的文本是否为斜体（有些字体不支持斜体）。

{:id="Label.FontSize" .number} *字体大小*
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
: 指定`标签`文本的对齐方式，有效值有： 

  `0`（正常；例如，如果文本从左到右书写，则左对齐）

  `1`（居中）

  `2`（相反；例如，如果文本从左到右书写，则右对齐）。

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



## ![icon](images/ListPicker.png)  列表选择框&nbsp;&nbsp;[<i class="mdi mdi-cursor-default-click-outline"></i>示例](guide/ListPicker.html)  {#ListPicker}

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

  `0`（默认）

  `1` （圆形）

  `2`（矩形）

  `3`（椭圆形）。
  
  如果设置了[`图像`](#Button.Image)，则`形状`将不可见。

{:id="ListPicker.ShowFeedback" .boolean} *显示反馈*
: 设置`列表选择框`指定 [`图像`](#ListPicker.Image)后被按压是否显示视觉反馈。

{:id="ListPicker.ShowFilterBar" .boolean} *显示搜索框*
: If `真`{:.logic.block}, the ListPicker will show a search filter bar.

{:id="ListPicker.Text" .text} *文本*
: 设置`列表选择框`的显示文本。

{:id="ListPicker.TextAlignment" .number .do} *文本对齐*
: 设置`列表选择框`文本的对齐方式，有效值有： 

  `0`（正常；例如，如果文本从左到右书写，则左对齐）

  `1`（居中）

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


## ![icon](images/ListView.png)  列表显示框  {#ListView}

可见组件，可在 [`屏幕`](#Screen) 上展示文本和图像元素的列表。

可以使用 [`元素字串`](#ListView.ElementsFromString) 属性设置简单的字符串列表。

可以使用 [`列表数据`](#ListView.ListData) 和 [`布局`](#ListView.ListViewLayout) 属性创建包含多个字符串和/或图像的更复杂的元素列表。[布局信息](../other/advanced-listview.html)

**警告**：如果该组件 [`高度`](#ListView.Height) 设置为填充父级，则在可滚动的屏幕上将无法正常工作。

### 属性  {#ListView-Properties}

{:.properties}

{:id="ListView.BackgroundColor" .color} *背景颜色*
: 设置`列表显示框`的背景颜色。

{:id="ListView.Elements" .list .bo} *元素*
: 设置要显示的选项列表。将列表设置给元素属性，列表显示框即可展示列表内容，多次设置会刷新为最新的列表的内容。

{:id="ListView.ElementsFromString" .text .wo} *元素字串*
: 设置指定列表字符串作为选项列表，其中元素以英文逗号分隔，如：`奶酪,水果,培根,萝卜`。

{:id="ListView.FontSizeDetail" .number} *列表项字体大小*
: 设置`列表显示框`**列表项**的文本字体大小。

{:id="ListView.FontTypeface" .number .do} *字体*
: 设置`列表显示框`的字体，目前支持的字体有：default,  serif,  sans serif,  和 monospace。

{:id="ListView.FontTypefaceDetail" .number .do} *列表项字体*
: 设置`列表显示框`**列表项**的字体，目前支持的字体有：default,  serif,  sans serif,  和 monospace。

{:id="ListView.Height" .number .bo} *高度*
: 设置`列表显示框`的垂直高度，以像素px为单位。

{:id="ListView.HeightPercent" .number .wo .bo} *高度百分比*
: 设置`列表显示框`的垂直高度相对于整个[`屏幕高度`](userinterface.html#Screen.Height)的百分比。

{:id="ListView.ImageHeight" .number} *图像高度*
: 设置布局包含图像的`列表显示框`的图像高度。

{:id="ListView.ImageWidth" .number} *图像宽度*
: 设置布局包含图像的`列表显示框`的图像宽度。

{:id="ListView.ListData" .text .do} *列表数据*
: Specifies data to be displayed in the ListView elements. This property sets the
 elements specified in [`布局`](#ListView.ListViewLayout). For example, if the chosen
 layout is `Image,MainText` this property will allow any number of elements to be
 defined, each containing a filename for Image and a string for MainText.
 Designer only property.

{:id="ListView.ListViewLayout" .number .do} *布局*
: 设置`列表显示框`行的布局类型。该属性仅可在“界面设计”视图设置。

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
: 设置`列表显示框`的文本颜色，使用RGBA数值表示。

{:id="ListView.TextColorDetail" .color} *TextColorDetail*
: Specifies the color of the secondary text in a ListView layout

{:id="ListView.TextSize" .number} *文本大小*
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


## ![icon](images/Notifier.png)  对话框  {#Notifier}

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


## ![icon](images/PasswordTextBoxIcon.png)  密码输入框  {#PasswordTextBox}

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

  `0`（正常；例如，如果文本从左到右书写，则左对齐）

  `1`（居中）

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


## ![icon](images/slider.png)  滑动条  {#Slider}

滑动条是一个添加可拖动滑块的进度条，你可以触摸它并向左右拖动设置滑块的位置。当滑块滑块被拖动时，它将触发[`位置被改变`](#Slider.PositionChanged) 事件，报告 `滑动条` 的滑块位置数值，
  这个数值可用于动态更新另一个组件属性，例如 `文本输入框` 的 [`字体大小`](#TextBox.FontSize) 或 `球形精灵` 的 [半径](animation.html#Ball.Radius)。

  `滑动条` 使用以下默认值，但这些值在“界面设计”和“程序设计”视图中都可以修改：

   * [`最小值`](#Slider.MinValue) = 10
   * [`最大值`](#Slider.MaxValue) = 50
   * [`滑块位置`](#Slider.ThumbPosition) = 30

   **中文网注**：根据会员的反馈，假设值区间设置为 `0 ~ 300`，这时，滑动一个位置变化值是`3`，而`非1`。通过研究源码，因为滑块改变是一个进度整型值控制，它的范围是整数`[0 ~ 100]`，也就是说滑块的**最小控制粒度**是 `1 / 100`，暂时无法实现更高的粒度控制。感谢会员的研究及反馈。

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

{:id="Slider.MaxValue" .number} *最大值*
: 设置滑块的最大值。如果新的最大值小于当前最小值，则最小值和最大值都将设置为该值。
  
  设置最大值会将滑块位置重置为 [`最小值`](#Slider.MinValue) 和 [`最大值`](#Slider.MaxValue) 之间的位置，并触发 [`位置被改变`](#Slider.PositionChanged)` 事件。

{:id="Slider.MinValue" .number} *最小值*
: 设置滑块的最小值。如果新的最小值大于当前最大值，则最小值和最大值都将设置为该值。
  
  设置最小值会将滑块位置重置为 [`最小值`](#Slider.MinValue) 和 [`最大值`](#Slider.MaxValue) 之间的位置，并触发 [`位置被改变`](#Slider.PositionChanged)` 事件。

{:id="Slider.ThumbEnabled" .boolean} *接受滑动*
: 是否显示滑块以允许滑动。

{:id="Slider.ThumbPosition" .number} *滑块位置*
: 设置滑块滑块的位置。如果该值大于 [`最大值`](#Slider.MaxValue)，那么它将被设置为与 [`最大值`](#Slider.MaxValue) 相同的值；如果该值小于[`最小值`](#Slider.MinValue)，那么它将被设置为与 [`最小值`](#Slider.MinValue) 相同的值。

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

{:id="Slider.PositionChanged"} 位置被改变(*滑块位置*{:.number})
: 指示滑块的位置已改变。

### 方法  {#Slider-Methods}

{:.methods}
无


## ![icon](images/Spinner.png)  下拉框  {#Spinner}

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


## ![icon](images/Switch.png)  切换开关（Switch）   {#Switch}

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


## ![icon](images/TextBoxIcon.png)  文本输入框  {#TextBox}

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

  `0`（正常；例如，如果文本从左到右书写，则左对齐）

  `1`（居中）

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


## ![icon](images/TimePicker.png)  时间选择框  {#TimePicker}

点击该按钮会打开一个对话框以允许用户选择时间。

  注意：日期和时间是使用 [`计时器`](sensors.html#Clock) 组件中的方法进行操作的。

### 属性  {#TimePicker-Properties}

{:.properties}

{:id="TimePicker.BackgroundColor" .color} *背景颜色*
: 设置`时间选择框`的背景颜色，使用RGBA数值表示，如果设置了[`图像`](#TimePicker.Image)属性，则不能显示背景颜色直到删除[`图像`](#TimePicker.Image)属性为止。

{:id="TimePicker.Image" .text} *图像*
: 设置`时间选择框`图像的路径，如果同时设置了`图像`和[`背景颜色`](#TimePicker.BackgroundColor)，则仅`图像`可见。

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

{:id="TimePicker.Instant" .InstantInTime .ro .bo} *时刻*
: 返回上次使用`时间选择框`选取的时刻。

{:id="TimePicker.Hour" .number .ro .bo} *时*
: 返回上次使用`时间选择框`选取时间的小时。

  返回的时间**始终采用 24 小时制**。

{:id="TimePicker.Minute" .number .ro .bo} *分*
: 返回上次使用`时间选择框`选取时间的分钟。

{:id="TimePicker.Shape" .number .do} *形状*
: 设置`时间选择框`的形状，此属性的有效值为：

  `0`（默认）

  `1` （圆形）

  `2`（矩形）

  `3`（椭圆形）。
  
  如果设置了[`图像`](#TimePicker.Image)，则`形状`将不可见。

{:id="TimePicker.ShowFeedback" .boolean} *显示反馈*
: 设置`时间选择框`指定 [`图像`](#TimePicker.Image)后被按压是否显示视觉反馈。

{:id="TimePicker.Text" .text} *文本*
: 设置`时间选择框`的显示文本。

{:id="TimePicker.TextAlignment" .number .do} *文本对齐*
: 设置`时间选择框`文本的对齐方式，有效值有： 

  `0`（正常；例如，如果文本从左到右书写，则左对齐）

  `1`（居中）

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

{:id="TimePicker.AfterTimeSet"} 完成时间设定()
: 用户在对话框中选择时间后运行的事件。

{:id="TimePicker.GotFocus"} 获得焦点()
: 表示光标已经移到`时间选择框`上，因此现在可以点击它。

{:id="TimePicker.LostFocus"} 失去焦点()
: 表示光标已从`时间选择框`移开，因此现在不能点击它了。

{:id="TimePicker.TouchDown"} 被按下()
: 表示`时间选择框`按钮被按下。

{:id="TimePicker.TouchUp"} 被松开()
: 表示`时间选择框`按钮被松开。

### 方法  {#TimePicker-Methods}

{:.methods}

{:id="TimePicker.LaunchPicker" class="method"} <i/> 打开选择框()
: 启动时间选择器对话框。在用户确认选择后，[完成时间设定](#TimePicker.AfterTimeSet) 事件将被触发。

{:id="TimePicker.SetTimeToDisplay" class="method"} <i/> 设置时间显示(*时*{:.number},*分*{:.number})
: 允许用户设置`时间选择框`打开时显示的时间。

  小时字段的有效值为 0-23，分钟的有效值为 0-59。

{:id="TimePicker.SetTimeToDisplayFromInstant" class="method"} <i/> 设置显示某时刻的时间(*时刻*{:.InstantInTime})
: 选择器打开时允许用户设置显示指定时刻的时间。

  时刻用于 [`计时器`](sensors.html#Clock)、[`日期选择框`](#DatePicker) 和 [`时间选择框`](#TimePicker) 组件。

## ![icon](images/WebViewer.png)  Web浏览框  {#WebViewer}

Component for viewing Web pages.

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
