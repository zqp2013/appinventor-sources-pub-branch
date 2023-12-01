---
layout: documentation
title: 多媒体组件
description: 多媒体组件参考文档：包括摄像机、照相机、图像选择器、音频播放器、音效、录音机、语音识别器、文本朗读器、翻译器、视频播放器。
---

* TOC
{:toc}

[&laquo; 返回首页](index.html)
# <i class="mdi mdi-movie-open-outline"></i>  多媒体组件

目录：

1. ![Camcorder icon](images/camcorder.png)  [摄像机](#Camcorder)
1. ![照相机图标](images/camera.png)  [照相机](#Camera)
1. ![文件选择器图标](images/FilePicker.png)  [文件选择器](#FilePicker)
1. ![图像选择器图标](images/imagepicker.png)  [图像选择器](#ImagePicker)
1. ![音频播放器图标](images/player.png)  [音频播放器](#Player)
1. ![音效图标](images/sound.png)  [音效](#Sound)
1. ![录音机图标](images/soundRecorder.png)  [录音机](#SoundRecorder)
1. ![语音识别器图标](images/speechrecognizer.png)  [语音识别器](#SpeechRecognizer)
1. ![文本朗读器图标](images/texttospeech.png)  [文本朗读器](#TextToSpeech)
1. ![翻译器图标](images/translator.png)  [翻译器](#Translator)
1. ![视频播放器图标](images/videoplayer.png)  [视频播放器](#VideoPlayer)


## ![Camcorder icon](images/camcorder.png)  摄像机  {#Camcorder}

 使用设备的摄像机录制视频的组件。录制视频后，手机上包含剪辑的文件的名称可作为参数提供给 [`录制完成`](#Camcorder.AfterRecording) 事件。
 例如，可以使用文件名来设置源 [`视频播放器`](#VideoPlayer) 组件的属性。


### 属性  {#Camcorder-Properties}

{:.properties}
无


### 事件  {#Camcorder-Events}

{:.events}

{:id="Camcorder.AfterRecording"} 录制完成(*clip*{:.text})
: 表示视频是用相机录制的，提供已存储视频的路径。

### 方法  {#Camcorder-Methods}

{:.methods}

{:id="Camcorder.RecordVideo" class="method"} <i/> 开始录制()
: 录制视频，然后触发[`录制完成`](#Camcorder.AfterRecording)事件。


## ![照相机图标](images/camera.png)  照相机  {#Camera}

 使用相机组件在手机上拍照。

 `照相机`是一个不可见的组件，它使用设备的相机拍照。照片拍摄完成后，手机上包含照片的文件路径可用作 [`拍摄完成`](#Camera.AfterPicture) 事件的参数。 
 例如，该路径可以用作 [`图像`](userinterface.html#Image) 的 [`图片`](userinterface.html#Image.Picture) 属性。


### 属性  {#Camera-Properties}

{:.properties}
无


### 事件  {#Camera-Events}

{:.events}

{:id="Camera.AfterPicture"} 拍摄完成(*图像位址*{:.text})
: 拍照完成后调用，文本参数 `图像位址` 是手机上找到图像位置的路径。

### 方法  {#Camera-Methods}

{:.methods}

{:id="Camera.TakePicture" class="method"} <i/> 拍照()
: 拍照，然后触发 [`拍摄完成`](#Camera.AfterPicture) 事件。

## ![文件选择器图标](images/FilePicker.png)  文件选择器  {#FilePicker}

`文件选择器`组件是一个类似按钮的组件。当用户单击该组件时，将提示他们从系统中选择一个文件。
  
  还可以通过调用其 [打开](#FilePicker.Open) 方法以编程方式打开选择器。

  使用文件选择器组件需要 Android 4.4 或更高版本、iOS 11 或更高版本。要求AI伴侣v2.68及以上。

### 属性  {#FilePicker-Properties}

{:.properties}

{:id="FilePicker.Action" .com.google.appinventor.components.common.FileActionEnum} *Action*
: Sets the desired action for the FilePicker. One of:

     - Pick Existing File: Open an existing file
     - Pick Directory: Open an existing directory
     - Pick New File: Create a new file for saving

{:id="FilePicker.BackgroundColor" .color} *背景颜色*
: Specifies the `FilePicker`'s background color as an alpha-red-green-blue
 integer.  If an [`Image`](#FilePicker.Image) has been set, the color
 change will not be visible until the [`Image`](#FilePicker.Image) is removed.

{:id="FilePicker.Enabled" .boolean} *启用*
: Specifies whether the `FilePicker` should be active and clickable.

{:id="FilePicker.FontBold" .boolean} *FontBold*
: Specifies whether the text of the `FilePicker` should be bold.
 Some fonts do not support bold.

{:id="FilePicker.FontItalic" .boolean} *FontItalic*
: Specifies whether the text of the `FilePicker` should be italic.
 Some fonts do not support italic.

{:id="FilePicker.FontSize" .number} *FontSize*
: Specifies the text font size of the `FilePicker`, measured in sp(scale-independent pixels).

{:id="FilePicker.FontTypeface" .text .do} *FontTypeface*
: Specifies the text font face of the `FilePicker` as default, serif, sans
 serif, monospace, or custom font typeface. To add a custom typeface,
 upload a .ttf file to the project's media.

{:id="FilePicker.Height" .number .bo} *Height*
: Specifies the `FilePicker`'s vertical height, measured in pixels.

{:id="FilePicker.HeightPercent" .number .wo .bo} *HeightPercent*
: Specifies the `FilePicker`'s vertical height as a percentage
 of the [`Screen`'s `Height`](userinterface.html#Screen.Height).

{:id="FilePicker.Image" .text} *Image*
: Specifies the path of the `FilePicker`'s image. If there is both an `Image` and a
 [`BackgroundColor`](#FilePicker.BackgroundColor) specified, only the `Image` will be visible.

{:id="FilePicker.MimeType" .text} *MimeType*
: Sets the desired MIME type for picking a file.

{:id="FilePicker.Selection" .text .ro .bo} *Selection*
: Returns the selected file, possibly as a content URI.

{:id="FilePicker.Shape" .number .do} *Shape*
: Specifies the shape of the `FilePicker`. The valid values for this property are `0` (default),
 `1` (rounded), `2` (rectangle), and `3` (oval). The `Shape` will not be visible if an
 [`Image`](#FilePicker.Image) is used.

{:id="FilePicker.ShowFeedback" .boolean} *ShowFeedback*
: Specifies if a visual feedback should be shown when a `FilePicker` with an assigned
 [`Image`](#FilePicker.Image) is pressed.

{:id="FilePicker.Text" .text} *Text*
: Specifies the text displayed by the `FilePicker`.

{:id="FilePicker.TextAlignment" .number .do} *TextAlignment*
: Specifies the alignment of the `FilePicker`'s text. Valid values are:
 `0` (normal; e.g., left-justified if text is written left to right),
 `1` (center), or
 `2` (opposite; e.g., right-justified if text is written left to right).

{:id="FilePicker.TextColor" .color} *TextColor*
: Specifies the text color of the `FilePicker` as an alpha-red-green-blue
 integer.

{:id="FilePicker.Visible" .boolean} *Visible*
: Specifies whether the `FilePicker` should be visible on the screen.  Value is `true`{:.logic.block}
 if the `FilePicker` is showing and `false`{:.logic.block} if hidden.

{:id="FilePicker.Width" .number .bo} *Width*
: Specifies the horizontal width of the `FilePicker`, measured in pixels.

{:id="FilePicker.WidthPercent" .number .wo .bo} *WidthPercent*
: Specifies the horizontal width of the `FilePicker` as a percentage
 of the [`Screen`'s `Width`](userinterface.html#Screen.Width).

### 事件  {#FilePicker-Events}

{:.events}

{:id="FilePicker.AfterPicking"} AfterPicking()
: Event to be raised after the `FilePicker` activity returns its
 result and the properties have been filled in.

{:id="FilePicker.BeforePicking"} BeforePicking()
: Event to raise when the `FilePicker` is clicked or the picker is shown
 using the [`Open`](#FilePicker.Open) method.  This event occurs before the picker is displayed, and
 can be used to prepare the picker before it is shown.

{:id="FilePicker.GotFocus"} GotFocus()
: Indicates the cursor moved over the `FilePicker` so it is now possible
 to click it.

{:id="FilePicker.LostFocus"} LostFocus()
: Indicates the cursor moved away from the `FilePicker` so it is now no
 longer possible to click it.

{:id="FilePicker.TouchDown"} TouchDown()
: Indicates that the `FilePicker` was pressed down.

{:id="FilePicker.TouchUp"} TouchUp()
: Indicates that the `FilePicker` has been released.

### 方法  {#FilePicker-Methods}

{:.methods}

{:id="FilePicker.Open" class="method"} <i/> 打开()
: 打开`文件选择器`，就像用户单击它一样。


## ![图像选择器图标](images/imagepicker.png)  图像选择器  {#ImagePicker}

当用户点击 `图像选择器` 时，打开设备的图片库，用户可以选择图像。选取图像后，[`选中项`](#ImagePicker.Selection) 属性返回选中图像的文件名称。
最多返回10个图像，超过则删除之前旧的图像，按时间从旧到新的顺序排列。

### 属性  {#ImagePicker-Properties}

{:.properties}

{:id="ImagePicker.BackgroundColor" .color} *背景颜色*
: 设置`图像选择器`的背景颜色，使用RGBA数值表示，如果设置了[`图像`](#ImagePicker.Image)属性，则不能显示背景颜色直到删除[`图像`](#ImagePicker.Image)属性为止。

{:id="ImagePicker.Enabled" .boolean} *启用*
: 设置`图像选择器`是否可以被激活和点击。

{:id="ImagePicker.FontBold" .boolean} *粗体*
: 设置`图像选择器`的显示字体是否是粗体。（注：有些字体不支持粗体）。

{:id="ImagePicker.FontItalic" .boolean} *斜体*
: 设置`图像选择器`的显示字体是否是斜体。（注：有些字体不支持斜体）。

{:id="ImagePicker.FontSize" .number} *字体大小*
: 设置`图像选择器`的字体大小，以像素px为单位。

{:id="ImagePicker.FontTypeface" .number .do} *字体*
: 设置`图像选择器`的字体，目前支持的字体有：default,  serif,  sans serif,  和 monospace。

{:id="ImagePicker.Height" .number .bo} *高度*
: 设置`图像选择器`的垂直高度，以像素px为单位。

{:id="ImagePicker.HeightPercent" .number .wo .bo} *高度百分比*
: 设置`图像选择器`的垂直高度相对于整个[`屏幕高度`](userinterface.html#Screen.Height)的百分比。

{:id="ImagePicker.Image" .text} *图像*
: 设置`图像选择器`图像的路径，如果同时设置了`图像`和[`背景颜色`](#ImagePicker.BackgroundColor)，则仅`图像`可见。

{:id="ImagePicker.Selection" .text .ro .bo} *选中项*
: 包含所选图像文件的路径。

{:id="ImagePicker.Shape" .number .do} *形状*
: 设置`图像选择器`的形状，此属性的有效值为：

  `0`（默认）

  `1` （圆形）

  `2`（矩形）

  `3`（椭圆形）。
  
  如果设置了[`图像`](#ImagePicker.Image)，则`形状`将不可见。

{:id="ImagePicker.ShowFeedback" .boolean} *显示交互效果*
: 设置`图像选择器`指定 [`图像`](#ImagePicker.Image)后被按压是否显示视觉反馈。

{:id="ImagePicker.Text" .text} *文本*
: 设置`图像选择器`的显示文本。

{:id="ImagePicker.TextAlignment" .number .do} *文本对齐方式*
: 设置`图像选择器`文本的对齐方式，有效值有： 
`0`（正常；例如，如果文本从左到右书写，则左对齐）、
`1`（居中）或
`2`（相反；例如，如果文本从左到右书写，则右对齐）。

{:id="ImagePicker.TextColor" .color} *文本颜色*
: 设置`图像选择器`的文本颜色，使用RGBA数值表示。

{:id="ImagePicker.Visible" .boolean} *可见性*
: 设置`图像选择器`是否显示在屏幕上，值是`真`{:.logic.block}则`图像选择器`显示，`假`{:.logic.block}则隐藏。

{:id="ImagePicker.Width" .number .bo} *宽度*
: 设置`图像选择器`的水平宽度，以像素px为单位。

{:id="ImagePicker.WidthPercent" .number .wo .bo} *宽度百分比*
: 设置`图像选择器`的水平宽度相对于[`屏幕宽度`](userinterface.html#Screen.Width)的百分比。

### 事件  {#ImagePicker-Events}

{:.events}

{:id="ImagePicker.AfterPicking"} 选择完成()
: 在 `图像选择器` 活动返回其结果和属性时触发该事件。

{:id="ImagePicker.BeforePicking"} 准备选择()
: 单击 `图像选择器` 或使用 [`打开选框`](#ImagePicker.Open) 方法显示选择器时触发该事件，此事件发生在选择器显示之前。

{:id="ImagePicker.GotFocus"} 获得焦点()
: 表示光标移动到 `图像选择器` 上，现在可以点击它。

{:id="ImagePicker.LostFocus"} 失去焦点()
: 表示光标从 `图像选择器` 移开，现在它不可再被点击。

{:id="ImagePicker.TouchDown"} 被按压()
: 表示 `图像选择器` 被按下。

{:id="ImagePicker.TouchUp"} 被松开()
: 表示 `图像选择器` 被松开。

### 方法  {#ImagePicker-Methods}

{:.methods}

{:id="ImagePicker.Open" class="method"} <i/> 打开选框()
: 打开 `图像选择器`，就像用户点击它一样。


## ![音频播放器图标](images/player.png)  音频播放器  {#Player}

播放音频和控制手机振动的多媒体组件。多媒体文件名称在[`源文件`](#Player.Source) 属性中指定，在界面设计和程序设计视图中都可以进行设置。
振动的时长只能在程序设计视图中指定，单位是ms毫秒（千分之一秒）。

有关支持的音频格式，请参阅[Android支持的媒体格式](//developer.android.com/guide/appendix/media-formats.html)。

`音频播放器`组件尤其**适合时间较长的声音文件**（例如歌曲）；而[`音效`](#Sound) 组件播放时间较短的声音文件则更高效（例如音效）。

### 属性  {#Player-Properties}

{:.properties}

{:id="Player.IsPlaying" .boolean .ro .bo} *播放状态*
: 报告`音频播放器`是否正在播放。正在播放返回`真`，没有在播放则返回`假`。

{:id="Player.Loop" .boolean} *循环播放*
: 如果为 `真`，则`音频播放器`播放时将循环播放。正在播放时设置“循环播放”直接对当前播放生效。

{:id="Player.PlayOnlyInForeground" .boolean} *只能在前台运行*
: 如果为 `真`，则`音频播放器`在离开当前屏幕时将暂停播放； 如果为 `假`（默认选项），则无论当前屏幕是否显示，`音频播放器`都会继续播放。

{:id="Player.Source" .text} *源文件*
: 设置音频源文件。

{:id="Player.Volume" .number .wo} *音量*
: 将音量属性设置为 0 到 100 之间的数字。小于 0 的值将被视为 0，大于 100 的值将被视为 100。

### 事件  {#Player-Events}

{:.events}

{:id="Player.Completed"} 已播放完成时()
: 表示媒体播放已结束。

{:id="Player.OtherPlayerStarted"} 其他播放器启动时()
: 当另一个播放器开始播放时（并且当前播放器正在播放或暂停，但未停止），会触发此事件。

### 方法  {#Player-Methods}

{:.methods}

{:id="Player.Pause" class="method"} <i/> 暂停()
: 如果媒体正在播放，则暂停播放。

{:id="Player.Start" class="method"} <i/> 开始()
: 播放媒体。如果之前暂停，则恢复播放。
  
  如果之前已停止，则从头开始播放。

{:id="Player.Stop" class="method"} <i/> 停止()
: 停止播放媒体，播放进度清零（即下次从头开始播放）。

{:id="Player.Vibrate" class="method"} <i/> 振动(*毫秒数*{:.number})
: 手机振动指定的毫秒数。


## ![音效图标](images/sound.png)  音效  {#Sound}

一种多媒体组件，可播放声音文件并根据播放次数选择振动几ms毫秒（千分之一秒），在程序设计视图中指定。声音文件的名称可以在界面设计或程序设计视图中指定。

有关支持的声音文件格式，请参阅[Android支持的媒体格式](//developer.android.com/guide/appendix/media-formats.html)。

`音效`组件**适合播放短声音文件**（例如音效）；而[`音频播放器`](#Player)组件播放较长的声音文件更高效（例如歌曲）。

### 属性  {#Sound-Properties}

{:.properties}

{:id="Sound.MinimumInterval" .number} *最小间隔（毫秒）*
: 指定调用 [`播放`](#Sound.Play) 之间所需的最小间隔（以毫秒为单位）。
  
  一旦声音开始播放，所有后续的 [`播放`](#Sound.Play) 调用都将被忽略，直到间隔结束。

{:id="Sound.Source" .text} *源文件*
: 声音文件的名称。

  仅支持某些格式，请参阅[http://developer.android.com/guide/appendix/media-formats.html](http://developer.android.com/guide/appendix/media-formats.html)。

### 事件  {#Sound-Events}

{:.events}
无


### 方法  {#Sound-Methods}

{:.methods}

{:id="Sound.Pause" class="method"} <i/> 暂停()
: 如果正在播放声音，则暂停播放。

{:id="Sound.Play" class="method"} <i/> 播放()
: 播放声音。

{:id="Sound.Resume" class="method"} <i/> 恢复()
: 暂停后继续播放声音。

{:id="Sound.Stop" class="method"} <i/> 停止()
: 如果正在播放声音，则停止播放。

{:id="Sound.Vibrate" class="method"} <i/> 振动(*毫秒数*{:.number})
: 手机振动指定的毫秒数。


## ![录音机图标](images/soundRecorder.png)  录音机  {#SoundRecorder}

 录制音频的多媒体组件。

### 属性  {#SoundRecorder-Properties}

{:.properties}

{:id="SoundRecorder.SavedRecording" .text} *录音文件路径*
: 指定应存储录音文件的路径。

  如果此属性为空字符串，则开始录制将在适当的位置创建一个文件；如果该属性不是空字符串，则应指定现有目录中文件的完整路径，包括扩展名如 .3gp 的文件名。

### 事件  {#SoundRecorder-Events}

{:.events}

{:id="SoundRecorder.AfterSoundRecorded"} 录制完成时(*录音文件路径*{:.text})
: 表示新创建的录音已完成，`录音文件路径`提供录音文件的存储路径。

{:id="SoundRecorder.StartedRecording"} 开始录制时()
: 表示录音机已启动，可以停止。

{:id="SoundRecorder.StoppedRecording"} 停止录制时()
: 表示录音机已停止，可以重新启动。

### 方法  {#SoundRecorder-Methods}

{:.methods}

{:id="SoundRecorder.Start" class="method"} <i/> 开始()
: 开始录音。

{:id="SoundRecorder.Stop" class="method"} <i/> 停止()
: 停止录音。

## ![语音识别器图标](images/speechrecognizer.png)  语音识别器  {#SpeechRecognizer}

 使用 `语音识别器` 组件来收听用户说话并转换语音，使用设备的语音识别功能转换为文本。

 **中文网拓展**：
 
 - 中文的话，推荐使用“讯飞语音+”识别引擎，识别率较高，[点此下载](https://www.pgyer.com/yyyq)apk安装。
 
 - 安装完成后无需设置，当触发需要识别语音时，系统会弹出对话框让你选择使用哪个识别引擎，这时选择“讯飞语音+”，点“始终”就OK了。

 - 当设置语音改成英语后，读中文的话，不是将你读的中文翻译成英文，而是将你读中文的音调相近的英语内容识别出来，也就是它认为你说的是英文，按英文规则识别。

### 属性  {#SpeechRecognizer-Properties}

{:.properties}

{:id="SpeechRecognizer.Language" .text .bo} *语言*
: 指定用于识别语音的语言，空字符串（默认值）将使用系统的默认语言。
  
  使用 [语言标签](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) 指定语言带有可选的区域后缀，例如 en 或 zh-CN，支持的语言集因设备而异。

{:id="SpeechRecognizer.Result" .text .ro .bo} *结果*
: 返回识别器生成的最后一个文本。

{:id="SpeechRecognizer.UseLegacy" .boolean} *使用兼容模式*
: 如果为真，则使用单独的对话框来识别语音（默认）；如果为假，则语音在后台识别，并在识别新的内容时更新。
  
  `部分结果` 设置为 `真`{:.logic.block} 时，[`识别完成`](#SpeechRecognizer.AfterGettingText) 可能会触发多次。
  
  一旦自上次说话以来经过了足够的时间，或者调用了 `停止识别`，最后一个文本结果将返回，并将 `部分结果` 设置为 `假`{:.logic.block} 以表示它是最终识别的字符串，之后不再会有更多结果返回，除非再次开始识别。更多详细信息请参考[`识别完成`](#SpeechRecognizer.AfterGettingText)。

### 事件  {#SpeechRecognizer-Events}

{:.events}

{:id="SpeechRecognizer.AfterGettingText"} 识别完成(*返回结果*{:.text},*部分结果*{:.boolean})
: 在 `语音识别器` 识别语音后触发该事件。
  
  如果 [`使用兼容模式`](#SpeechRecognizer.UseLegacy) 是`真`{:.logic.block}，那么这个事件在识别的最后只会触发一次；
  
  如果 [`使用兼容模式`](#SpeechRecognizer.UseLegacy) 是`假`{:.logic.block}，那么这个事件将触发多次，因为 `语音识别器` 会逐渐识别语音，在这种情况下，`部分结果` 将是 `真`{:.logic.block} 。
  
  直至语音识别已完成（例如，用户已停止说话），在这种情况下，`部分结果`将是 `假`{:.logic.block}。

{:id="SpeechRecognizer.BeforeGettingText"} 准备识别()
: 在调用 `语音识别器` 之前触发该事件。

### 方法  {#SpeechRecognizer-Methods}

{:.methods}

{:id="SpeechRecognizer.GetText" class="method"} <i/> 识别语音()
: 要求用户说话，并将语音转换为文本。当结果可用时，将触发 [`识别完成`](#SpeechRecognizer.AfterGettingText) 事件。

{:id="SpeechRecognizer.Stop" class="method"} <i/> 停止()
: 用于在 `语音识别器` 无法自动停止的情况下强制停止收听语音的功能。

  仅当 [`使用兼容模式`](#SpeechRecognizer.UseLegacy) 属性设置为 `假`{:.logic.block} 时，此函数才有效。


## ![文本朗读器图标](images/texttospeech.png)  文本朗读器  {#TextToSpeech}

`文本朗读器` 组件会大声朗读给定的文本，你可以设置音高和语速。

  你还可以通过提供语言代码来设置语言，这将改变单词的读法，而不是实际使用的语言。
  
  例如，将 [`语言`](#TextToSpeech.Language) 设置为法语，并且说英语文本，听起来就像有人说带有法国口音的英语 (en)。

  你还可以通过提供 [`国家`](#TextToSpeech.Country) 代码来指定国家/地区，这会影响发音。例如，英国英语 (GBR) 听起来与美国英语 (USA) 不同，并非每个国家/地区代码都会影响每种语言。

  可用的语言和国家/地区取决于特定设备，并且可以使用 [`可用语言`](#TextToSpeech.AvailableLanguages) 和 [`可用国家`](#TextToSpeech.AvailableCountries) 属性列出。

  **中文网拓展：**
  - 经过测试，在“系统设置” — “语言和输入”—“文本转语音” 中将首选引擎**设置为讯飞后，朗读出来的内容完全就是杂乱的**，不知是不是因为版本过旧，还是其他设置问题，经过一系列尝试（包括设置文本朗读器的国家及语言属性）仍然是不行的。最终只得选择“Google文字转语言引擎”（语音设置为”中文“），中文朗读的效果也非常不错。


### 属性  {#TextToSpeech-Properties}

{:.properties}

{:id="TextToSpeech.AvailableCountries" .list .ro .bo} *支持的国家*
: 此设备上可用于 `语音识别器` 的国家/地区代码列表。参考 Android 开发文档以查找这些支持国家缩写的含义。

{:id="TextToSpeech.AvailableLanguages" .list .ro .bo} *支持的语言*
: 此设备上可用于 `语音识别器` 的语言列表。参考 Android 开发文档以查找这些支持语言缩写的含义。

{:id="TextToSpeech.Country" .text} *国家*
: 用于语音生成的国家/地区代码，这会影响发音。例如，英国英语 (GBR) 听起来与美国英语 (USA) 不同。并非每个国家/地区代码都会影响每种语言。

{:id="TextToSpeech.Language" .text} *语言*
: 设置 `语音识别器` 的语言。这改变了单词的发音方式，而不是实际所说的语言。例如，将语言设置为法语并说英语文本听起来就像有人说带有法国口音的英语。

{:id="TextToSpeech.Pitch" .number} *音调*
: 设置 `语音识别器` 的语音音高。

    这些值应介于 0 和 2 之间，其中较小的值会降低合成语音的音调，较大的值会提高合成语音的音调。

    正常音高的默认值为 1.0。

{:id="TextToSpeech.Result" .boolean .ro .bo} *结果*
: 如果文本成功转换为语音，则返回`真`{:.logic.block}，否则返回`假`{:.logic.block}。

{:id="TextToSpeech.SpeechRate" .number} *语速*
: 设置 `语音识别器` 的语音语速。

    这些值应介于 0 和 2 之间，较低的值会减慢音调，较大的值会加快音调。

    正常语速的默认值为 1.0。

### 事件  {#TextToSpeech-Events}

{:.events}

{:id="TextToSpeech.AfterSpeaking"} 念读结束时(*返回结果*{:.boolean})
: 念读消息后触发该事件。如果消息被成功读出，则`返回结果`{:.variable.block}将为`true`{:.logic.block}，否则将为`假`{:.logic.block}。

{:id="TextToSpeech.BeforeSpeaking"} 开始念读时()
: 在调用 `文本朗读器` 念读消息之前触发该事件。

### 方法  {#TextToSpeech-Methods}

{:.methods}

{:id="TextToSpeech.Speak" class="method"} <i/> 念读(*消息*{:.text})
: 念读给定的消息。

## ![翻译器图标](images/translator.png)  翻译器  {#Translator}

使用此组件在不同的语言之间翻译单词和句子。该组件需要 Internet 访问，因为它将从麻省理工学院（MIT）的服务器请求翻译（也可切换成请求商业翻译服务）。

  **中文网注：**最终实际使用的是国外的[Yandex](https://yandex.com/dev/translate/)翻译引擎。
  
  以 `源语言-目标语言` 的形式指定源语言和目标语言使用两个字母的语言代码。因此 `en-zh` 将翻译自`英语翻译成中文`，而 `zh-en` 将从`中文翻译成英语`。 
  
  如果省略源语言，该服务将尝试检测源语言。因此只提供 `zh` 将尝试`检测源语言并将其翻译成中文`。

  **注意：** 翻译在后台异步进行，翻译完成后，[`获取翻译内容`](#Translator.GotTranslation) 事件将被触发。


### 属性  {#Translator-Properties}

{:.properties}

{:id="Translator.ApiKey" .text .wo} *ApiKey*
: 要使用的API密钥，默认会自动填写此内容值，不需要更改它。

  默认情况下无法访问MIT代理服务器，如需有效API密钥请参照[《App Inventor 2 使用MIT代理的组件访问令牌的获取方法》](../creative/token.html)。

### 事件  {#Translator-Events}

{:.events}

{:id="Translator.GotTranslation"} 获得译文(*响应代码*{:.text},*译文*{:.text})
: 请求已完成并已返回数据（翻译）时触发该事件。

### 方法  {#Translator-Methods}

{:.methods}

{:id="Translator.RequestTranslation" class="method"} <i/> 请求翻译(*待翻译至语言*{:.text},*待翻译文本*{:.text})
: 通过提供要翻译的目标语言（例如，西班牙语的“es”、英语的“en”或俄语的“ru”）以及要翻译的单词或句子，此方法将请求翻译。一旦外部服务翻译了文本，事件 [`获得译文`](#Translator.GotTranslation) 将被触发。

  **注意：** 翻译器将尝试检测源语言。你还可以指定将其添加到语言翻译之前，例如 es-ru 将指定西班牙语到俄语的翻译。


## ![视频播放器图标](images/videoplayer.png)  视频播放器  {#VideoPlayer}

能够播放视频的多媒体组件。当应用程序运行时，`视频播放器`将在屏幕上显示为一个矩形。

  如果用户触摸矩形，将在视频中出现播放、暂停、向前跳转和向后跳转控件。
  
  App可以通过调用 [`播放`](#VideoPlayer.Start)、[`暂停`](#VideoPlayer.Pause) 和 [`跳转`](#VideoPlayer.SeekTo) 方法来控制`视频播放器`的行为。

  视频文件应为 3GPP (.3gp) 或 MPEG-4 (.mp4) 格式。更多详细信息格式，见 [Android 支持的媒体格式](//developer.android.com/guide/appendix/media-formats.html)。

  App Inventor 只允许 1 MB 以下的视频文件，并将应用程序的总大小限制为 5 MB，并非所有文件都可用于媒体（视频、音频和声音）文件。如果媒体文件太大，打包或安装应用程序时可能会出错，在这种情况下，你应该减少媒体文件的数量或它们的大小。大多数视频编辑软件，例如 Windows Movie Maker 和 Apple iMovie，可以帮助你减小视频的大小，或将视频重新编码为更紧凑的格式。

  你还可以将媒体源设置为指向流式视频的 URL，但该 URL 必须指向视频文件本身，而不是播放视频的程序。


### 属性  {#VideoPlayer-Properties}

{:.properties}

{:id="VideoPlayer.FullScreen" .boolean .bo} *全屏模式*
: 设置视频是否应全屏显示。

{:id="VideoPlayer.Height" .number .bo} *高度*
: 设置`视频播放器`的垂直高度，以像素px为单位。

{:id="VideoPlayer.HeightPercent" .number .wo .bo} *高度百分比*
: 设置`视频播放器`的垂直高度相对于整个[`屏幕高度`](userinterface.html#Screen.Height)的百分比。

{:id="VideoPlayer.Source" .text .wo} *源文件*
: 设置视频文件的路径。通常，在程序包资源中这将是视频文件的名称。

{:id="VideoPlayer.Visible" .boolean} *可见性*
: 设置`视频播放器`是否显示在屏幕上，值是`真`{:.logic.block}则`视频播放器`显示，`假`{:.logic.block}则隐藏。

{:id="VideoPlayer.Volume" .number .wo} *音量*
: 将音量属性设置为 0 到 100 之间的数字。小于 0 的值将被视为 0，大于 100 的值将被视为 100。

{:id="VideoPlayer.Width" .number .bo} *宽度*
: 设置`视频播放器`的水平宽度，以像素px为单位。

{:id="VideoPlayer.WidthPercent" .number .wo .bo} *宽度百分比*
: 设置`视频播放器`的水平宽度相对于[`屏幕宽度`](userinterface.html#Screen.Width)的百分比。

### 事件  {#VideoPlayer-Events}

{:.events}

{:id="VideoPlayer.Completed"} 已播放完成时()
: 表示视频播放已结束。

### 方法  {#VideoPlayer-Methods}

{:.methods}

{:id="VideoPlayer.GetDuration" class="method returns number"} <i/> 取时长()
: 返回视频的持续时间（以毫秒为单位）。

{:id="VideoPlayer.Pause" class="method"} <i/> 暂停()
: 暂停视频播放。可以通过调用 [`开始`](#VideoPlayer.Start) 方法在同一位置恢复播放。

{:id="VideoPlayer.SeekTo" class="method"} <i/> 跳转到(*毫秒数*{:.number})
: 跳转到视频中的指定时间（以毫秒为单位）。

  如果视频暂停，则显示的帧将不会通过搜索进行更新。播放器只能跳转到视频中的关键帧，因此跳转间隔较短的时间可能实际上不会移动到不同的帧。

{:id="VideoPlayer.Start" class="method"} <i/> 开始()
: 播放 [`源文件`](#VideoPlayer.Source) 指定的媒体。

{:id="VideoPlayer.Stop" class="method"} <i/> 停止()
: 重置为视频开始位置，如果视频正在播放则暂停。
