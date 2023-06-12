---
layout: documentation
title: 多媒体组件
---

[&laquo; 返回首页](index.html)
# 多媒体组件

目录：

* [摄像机](#Camcorder)
* [照相机](#Camera)
* [图像选择框](#ImagePicker)
* [音频播放器](#Player)
* [音效](#Sound)
* [录音机](#SoundRecorder)
* [语音识别器](#SpeechRecognizer)
* [文本朗读器](#TextToSpeech)
* [翻译器](#Translator)
* [视频播放器](#VideoPlayer)

***
## 摄像机  {#Camcorder}

![Camcorder icon](images/camcorder.png)

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

***
## 照相机  {#Camera}

![照相机图标](images/camera.png)

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

***
## 图像选择框  {#ImagePicker}

![图像选择框图标](images/imagepicker.png)

当用户点击 `图像选择框` 时，打开设备的图片库，用户可以选择图像。选取图像后，[`选中项`](#ImagePicker.Selection) 属性返回选中图像的文件名称。
最多返回10个图像，超过则删除之前旧的图像，按时间从旧到新的顺序排列。

### 属性  {#ImagePicker-Properties}

{:.properties}

{:id="ImagePicker.BackgroundColor" .color} *背景颜色*
: 设置`图像选择框`的背景颜色，使用RGBA数值表示，如果设置了[`图像`](#ImagePicker.Image)属性，则不能显示背景颜色直到删除[`图像`](#ImagePicker.Image)属性为止。

{:id="ImagePicker.Enabled" .boolean} *启用*
: 设置`图像选择框`是否可以被激活和点击。

{:id="ImagePicker.FontBold" .boolean} *粗体*
: 设置`图像选择框`的显示字体是否是粗体。（注：有些字体不支持粗体）。

{:id="ImagePicker.FontItalic" .boolean} *斜体*
: 设置`图像选择框`的显示字体是否是斜体。（注：有些字体不支持斜体）。

{:id="ImagePicker.FontSize" .number} *字体大小*
: 设置`图像选择框`的字体大小，以像素px为单位。

{:id="ImagePicker.FontTypeface" .number .do} *字体*
: 设置`图像选择框`的字体，目前支持的字体有：default,  serif,  sans serif,  和 monospace。

{:id="ImagePicker.Height" .number .bo} *高度*
: 设置`图像选择框`的垂直高度，以像素px为单位。

{:id="ImagePicker.HeightPercent" .number .wo .bo} *高度百分比*
: 设置`图像选择框`的垂直高度相对于整个[`屏幕高度`](userinterface.html#Screen.Height)的百分比。

{:id="ImagePicker.Image" .text} *图像*
: 设置`图像选择框`图像的路径，如果同时设置了`图像`和[`背景颜色`](#ImagePicker.BackgroundColor)，则仅`图像`可见。

{:id="ImagePicker.Selection" .text .ro .bo} *选中项*
: 包含所选图像文件的路径。

{:id="ImagePicker.Shape" .number .do} *形状*
: 设置`图像选择框`的形状，此属性的有效值为：
`0`（默认）、 
`1` （圆形）、
`2`（矩形）和
`3`（椭圆形）。如果设置了[`图像`](#ImagePicker.Image)，则`形状`将不可见。

{:id="ImagePicker.ShowFeedback" .boolean} *显示交互效果*
: 设置`图像选择框`指定 [`图像`](#ImagePicker.Image)后被按压是否显示视觉反馈。

{:id="ImagePicker.Text" .text} *文本*
: 设置`图像选择框`的显示文本。

{:id="ImagePicker.TextAlignment" .number .do} *文本对齐方式*
: 设置`图像选择框`文本的对齐方式，有效值有： 
`0`（正常；例如，如果文本从左到右书写，则左对齐）、
`1`（居中）或
`2`（相反；例如，如果文本从左到右书写，则右对齐）。

{:id="ImagePicker.TextColor" .color} *文本颜色*
: 设置`图像选择框`的文本颜色，使用RGBA数值表示。

{:id="ImagePicker.Visible" .boolean} *可见性*
: 设置`图像选择框`是否显示在屏幕上，值是`真`{:.logic.block}则`图像选择框`显示，`假`{:.logic.block}则隐藏。

{:id="ImagePicker.Width" .number .bo} *宽度*
: 设置`图像选择框`的水平宽度，以像素px为单位。

{:id="ImagePicker.WidthPercent" .number .wo .bo} *宽度百分比*
: 设置`图像选择框`的水平宽度相对于[`屏幕宽度`](userinterface.html#Screen.Width)的百分比。

### 事件  {#ImagePicker-Events}

{:.events}

{:id="ImagePicker.AfterPicking"} 选择完成()
: 在 `图像选择框` 活动返回其结果和属性时触发该事件。

{:id="ImagePicker.BeforePicking"} 准备选择()
: 单击 `图像选择框` 或使用 [`打开选框`](#ImagePicker.Open) 方法显示选择器时触发该事件，此事件发生在选择器显示之前。

{:id="ImagePicker.GotFocus"} 获得焦点()
: 表示光标移动到 `图像选择框` 上，现在可以点击它。

{:id="ImagePicker.LostFocus"} 失去焦点()
: 表示光标从 `图像选择框` 移开，现在它不可再被点击。

{:id="ImagePicker.TouchDown"} 被按压()
: 表示 `图像选择框` 被按下。

{:id="ImagePicker.TouchUp"} 被松开()
: 表示 `图像选择框` 被松开。

### 方法  {#ImagePicker-Methods}

{:.methods}

{:id="ImagePicker.Open" class="method"} <i/> 打开选框()
: 打开 `图像选择框`，就像用户点击它一样。

***
## 音频播放器  {#Player}

![音频播放器图标](images/player.png)

播放音频和控制手机振动的多媒体组件。多媒体文件名称在[`源文件`](#Player.Source) 属性中指定，在界面设计和程序设计视图中都可以进行设置。
振动的时长只能在程序设计视图中指定，单位是ms毫秒（千分之一秒）。

有关支持的音频格式，请参阅[Android支持的媒体格式](//developer.android.com/guide/appendix/media-formats.html)。

`音频播放器`组件尤其适合时间较长的声音文件（例如歌曲）；而[`音效`](#Sound) 组件播放时间较短的声音文件则更高效（例如音效）。

### 属性  {#Player-Properties}

{:.properties}

{:id="Player.IsPlaying" .boolean .ro .bo} *IsPlaying*
: Reports whether the media is playing.

{:id="Player.Loop" .boolean} *Loop*
: If true, the `Player` will loop when it plays. Setting `Loop` while the player is playing will
 affect the current playing.

{:id="Player.PlayOnlyInForeground" .boolean} *PlayOnlyInForeground*
: If true, the `Player` will pause playing when leaving the current screen; if false
 (default option), the `Player` continues playing whenever the current screen is displaying or
 not.

{:id="Player.Source" .text} *Source*
: Sets the audio source.

{:id="Player.Volume" .number .wo} *Volume*
: Sets the volume property to a number between 0 and 100.

### 事件  {#Player-Events}

{:.events}

{:id="Player.Completed"} Completed()
: Indicates that the media has reached the end

{:id="Player.OtherPlayerStarted"} OtherPlayerStarted()
: This event is signaled when another player has started (and the current player is playing or
 paused, but not stopped).

### 方法  {#Player-Methods}

{:.methods}

{:id="Player.Pause" class="method"} <i/> Pause()
: Suspends playing the media if it is playing.

{:id="Player.Start" class="method"} <i/> Start()
: Plays the media.  If it was previously paused, the playing is resumed.
 If it was previously stopped, it starts from the beginning.

{:id="Player.Stop" class="method"} <i/> Stop()
: Stops playing the media and seeks to the beginning of the song.

{:id="Player.Vibrate" class="method"} <i/> Vibrate(*milliseconds*{:.number})
: Vibrates for specified number of milliseconds.

***
## 音效  {#Sound}

![音效图标](images/sound.png)

一种多媒体组件，可播放声音文件并根据播放次数选择振动几ms毫秒（千分之一秒），在程序设计视图中指定。声音文件的名称可以在界面设计或程序设计视图中指定。

有关支持的声音文件格式，请参阅[Android支持的媒体格式](//developer.android.com/guide/appendix/media-formats.html)。

`音效`组件适合播放短声音文件（例如音效）；而[`音频播放器`](#Player)组件播放较长的声音文件更高效（例如歌曲）。

### 属性  {#Sound-Properties}

{:.properties}

{:id="Sound.MinimumInterval" .number} *MinimumInterval*
: Specifies the minimum interval required between calls to [`Play`](#Sound.Play), in
 milliseconds.
 Once the sound starts playing, all further [`Play`](#Sound.Play) calls will be ignored
 until the interval has elapsed.

{:id="Sound.Source" .text} *Source*
: The name of the sound file. Only certain formats are supported.
 See http://developer.android.com/guide/appendix/media-formats.html.

### 事件  {#Sound-Events}

{:.events}
无


### 方法  {#Sound-Methods}

{:.methods}

{:id="Sound.Pause" class="method"} <i/> Pause()
: Pauses playing the sound if it is being played.

{:id="Sound.Play" class="method"} <i/> Play()
: Plays the sound.

{:id="Sound.Resume" class="method"} <i/> Resume()
: Resumes playing the sound after a pause.

{:id="Sound.Stop" class="method"} <i/> Stop()
: Stops playing the sound if it is being played.

{:id="Sound.Vibrate" class="method"} <i/> Vibrate(*millisecs*{:.number})
: Vibrates for the specified number of milliseconds.

***
## 录音机  {#SoundRecorder}

![录音机图标](images/soundRecorder.png)

 Multimedia component that records audio.



### 属性  {#SoundRecorder-Properties}

{:.properties}

{:id="SoundRecorder.SavedRecording" .text} *SavedRecording*
: Specifies the path to the file where the recording should be stored. If this property is the
 empty string, then starting a recording will create a file in an appropriate location. If the
 property is not the empty string, it should specify a complete path to a file in an existing
 directory, including a file name with the extension .3gp.

### 事件  {#SoundRecorder-Events}

{:.events}

{:id="SoundRecorder.AfterSoundRecorded"} AfterSoundRecorded(*sound*{:.text})
: Provides the location of the newly created sound.

{:id="SoundRecorder.StartedRecording"} StartedRecording()
: Indicates that the recorder has started, and can be stopped.

{:id="SoundRecorder.StoppedRecording"} StoppedRecording()
: Indicates that the recorder has stopped, and can be started again.

### 方法  {#SoundRecorder-Methods}

{:.methods}

{:id="SoundRecorder.Start" class="method"} <i/> Start()
: Starts recording.

{:id="SoundRecorder.Stop" class="method"} <i/> Stop()
: Stops recording.

## 语音识别器  {#SpeechRecognizer}

![语音识别器图标](images/speechrecognizer.png)

 使用 `语音识别器` 组件来收听用户说话并转换语音，使用设备的语音识别功能转换为文本。


### 属性  {#SpeechRecognizer-Properties}

{:.properties}

{:id="SpeechRecognizer.Language" .text .bo} *语言*
: 指定用于识别语音的语言，空字符串（默认值）将使用系统的默认语言。
  
  使用 [语言标签](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) 指定语言带有可选的区域后缀，例如 en 或 zh-CN，支持的语言集因设备而异。

{:id="SpeechRecognizer.Result" .text .ro .bo} *结果*
: 返回识别器生成的最后一个文本。

{:id="SpeechRecognizer.UseLegacy" .boolean} *UseLegacy*
: 如果为真，则使用单独的对话框来识别语音（默认）；如果为假，则语音在后台识别，并在识别新的内容时更新。
  
  `部分结果` 设置为 `真`{:.logic.block} 时，[`识别完成`](#SpeechRecognizer.AfterGettingText) 可能会触发多次。
  
  一旦自上次说话以来经过了足够的时间，或者调用了 `停止识别`，最后一个文本结果将返回，并将 `部分结果` 设置为 `假`{:.logic.block} 以表示它是最终识别的字符串，之后不再会有更多结果返回，除非再次开始识别。更多详细信息请参考[`识别完成`](#SpeechRecognizer.AfterGettingText)。

### 事件  {#SpeechRecognizer-Events}

{:.events}

{:id="SpeechRecognizer.AfterGettingText"} 识别完成(*返回结果*{:.text},*部分结果*{:.boolean})
: 在 `语音识别器` 识别语音后触发该事件。
  
  如果 [`UseLegacy`](#SpeechRecognizer.UseLegacy) 是`真`{:.logic.block}，那么这个事件在识别的最后只会触发一次；
  
  如果 [`UseLegacy`](#SpeechRecognizer.UseLegacy) 是`假`{:.logic.block}，那么这个事件将触发多次，因为 `语音识别器` 会逐渐识别语音，在这种情况下，`部分结果` 将是 `真`{:.logic.block} 。
  
  直至语音识别已完成（例如，用户已停止说话），在这种情况下，`部分结果`将是 `假`{:.logic.block}。

{:id="SpeechRecognizer.BeforeGettingText"} 准备识别()
: 在调用 `语音识别器` 之前触发该事件。

### 方法  {#SpeechRecognizer-Methods}

{:.methods}

{:id="SpeechRecognizer.GetText" class="method"} <i/> GetText()
: Asks the user to speak, and converts the speech to text. Signals the
 [`AfterGettingText`](#SpeechRecognizer.AfterGettingText) event when the result is available.

{:id="SpeechRecognizer.Stop" class="method"} <i/> Stop()
: Function used to forcefully stop listening speech in cases where
 SpeechRecognizer cannot stop automatically.
 This function works only when the [`UseLegacy`](#SpeechRecognizer.UseLegacy) property is
 set to `假`{:.logic.block}.

***
## 文本朗读器  {#TextToSpeech}

![文本朗读器图标](images/texttospeech.png)

`文本朗读器` 组件会大声朗读给定的文本，你可以设置音高和语速。

  你还可以通过提供语言代码来设置语言，这将改变单词的读法，而不是实际使用的语言。
  
  例如，将 [`语言`](#TextToSpeech.Language) 设置为法语，并且说英语文本，听起来就像有人说带有法国口音的英语 (en)。

  你还可以通过提供 [`国家`](#TextToSpeech.Country) 代码来指定国家/地区，这会影响发音。例如，英国英语 (GBR) 听起来与美国英语 (USA) 不同，并非每个国家/地区代码都会影响每种语言。

  可用的语言和国家/地区取决于特定设备，并且可以使用 [`可用语言`](#TextToSpeech.AvailableLanguages) 和 [`可用国家`](#TextToSpeech.AvailableCountries) 属性列出。


### 属性  {#TextToSpeech-Properties}

{:.properties}

{:id="TextToSpeech.AvailableCountries" .list .ro .bo} *AvailableCountries*
: List of the country codes available on this device for use with TextToSpeech.  Check the Android developer documentation under supported languages to find the meanings of these abbreviations.

{:id="TextToSpeech.AvailableLanguages" .list .ro .bo} *AvailableLanguages*
: List of the languages available on this device for use with TextToSpeech.  Check the Android developer documentation under supported languages to find the meanings of these abbreviations.

{:id="TextToSpeech.Country" .text} *Country*
: Country code to use for speech generation. This can affect the pronunciation. For example,
 British English (GBR) will sound different from US English (USA). Not every country code will
 affect every language.

{:id="TextToSpeech.Language" .text} *Language*
: Sets the language for TextToSpeech. This changes the way that words are pronounced, not the
 actual language that is spoken. For example, setting the language to French and speaking
 English text will sound like someone speaking English with a French accent.

{:id="TextToSpeech.Pitch" .number} *Pitch*
: Sets the speech pitch for the TextToSpeech.

   The values should be between 0 and 2 where lower values lower the tone of synthesized voice
 and greater values raise it.

   The default value is 1.0 for normal pitch.

{:id="TextToSpeech.Result" .boolean .ro .bo} *Result*
: Returns `真`{:.logic.block} if the text was successfully converted to
 speech, otherwise `假`{:.logic.block}.

{:id="TextToSpeech.SpeechRate" .number} *SpeechRate*
: Sets the SpeechRate for TextToSpeech.

   The values should be between 0 and 2 where lower values slow down the pitch and greater
 values accelerate it.

   The default value is 1.0 for normal speech rate.

### 事件  {#TextToSpeech-Events}

{:.events}

{:id="TextToSpeech.AfterSpeaking"} AfterSpeaking(*result*{:.boolean})
: Event to raise after the message is spoken. The `result`{:.variable.block} will be
 `真`{:.logic.block} if the message is spoken successfully, otherwise it will be
 `假`{:.logic.block}.

{:id="TextToSpeech.BeforeSpeaking"} BeforeSpeaking()
: Event to raise when Speak is invoked, before the message is spoken.

### 方法  {#TextToSpeech-Methods}

{:.methods}

{:id="TextToSpeech.Speak" class="method"} <i/> Speak(*message*{:.text})
: Speaks the given message.

***
## 翻译器  {#Translator}

![翻译器图标](images/translator.png)

使用此组件在不同的语言之间翻译单词和句子。该组件需要 Internet 访问，因为它将从麻省理工学院（MIT）的服务器请求翻译（也可切换成请求商业翻译服务）。
  
  以 `源语言-目标语言` 的形式指定源语言和目标语言使用两个字母的语言代码。因此 `en-es` 将翻译自英语翻译成西班牙语，而 `es-ru` 将从西班牙语翻译成俄语。 
  
  如果省略源语言，该服务将尝试检测源语言。因此只提供 `es` 将尝试检测源语言并将其翻译成西班牙语。

  **注意：** 翻译在后台异步进行，翻译完成后，[`获取翻译内容`](#Translator.GotTranslation) 事件将被触发。


### 属性  {#Translator-Properties}

{:.properties}

{:id="Translator.ApiKey" .text .wo} *ApiKey*
: The API Key to use. MIT App Inventor will automatically fill this
 value in. You should not need to change it.

### 事件  {#Translator-Events}

{:.events}

{:id="Translator.GotTranslation"} GotTranslation(*responseCode*{:.text},*translation*{:.text})
: Event indicating that a request has finished and has returned data (translation).

### 方法  {#Translator-Methods}

{:.methods}

{:id="Translator.RequestTranslation" class="method"} <i/> RequestTranslation(*languageToTranslateTo*{:.text},*textToTranslate*{:.text})
: By providing a target language to translate to (for instance, 'es' for Spanish, 'en' for
 English, or 'ru' for Russian), and a word or sentence to translate, this method will request
 a translation. Once the text is translated by the external
 service, the event [`GotTranslation`](#Translator.GotTranslation) will be executed.

   **Note:** Translator will attempt to detect the source language. You can also specify
 prepending it to the language translation, e.g., es-ru will specify Spanish to Russian
 translation.

***
## 视频播放器  {#VideoPlayer}

![视频播放器图标](images/videoplayer.png)

能够播放视频的多媒体组件。当应用程序运行时，`视频播放器`将在屏幕上显示为一个矩形。

  如果用户触摸矩形，将在视频中出现播放、暂停、向前跳转和向后跳转控件。
  
  App可以通过调用 [`播放`](#VideoPlayer.Start)、[`暂停`](#VideoPlayer.Pause) 和 [`跳转`](#VideoPlayer.SeekTo) 方法来控制`视频播放器`的行为。

  视频文件应为 3GPP (.3gp) 或 MPEG-4 (.mp4) 格式。更多详细信息格式，见 [Android 支持的媒体格式](//developer.android.com/guide/appendix/media-formats.html)。

  App Inventor 只允许 1 MB 以下的视频文件，并将应用程序的总大小限制为 5 MB，并非所有文件都可用于媒体（视频、音频和声音）文件。如果媒体文件太大，打包或安装应用程序时可能会出错，在这种情况下，你应该减少媒体文件的数量或它们的大小。大多数视频编辑软件，例如 Windows Movie Maker 和 Apple iMovie，可以帮助你减小视频的大小，或将视频重新编码为更紧凑的格式。

  你还可以将媒体源设置为指向流式视频的 URL，但该 URL 必须指向视频文件本身，而不是播放视频的程序。


### 属性  {#VideoPlayer-Properties}

{:.properties}

{:id="VideoPlayer.FullScreen" .boolean .bo} *FullScreen*
: Sets whether the video should be shown in fullscreen or not.

{:id="VideoPlayer.Height" .number .bo} *Height*
: Specifies the component's vertical height, measured in pixels.

{:id="VideoPlayer.HeightPercent" .number .wo .bo} *HeightPercent*
: Specifies the `VideoPlayer`'s vertical height as a percentage
 of the [`Screen`'s `Height`](userinterface.html#Screen.Height).

{:id="VideoPlayer.Source" .text .wo} *Source*
: Sets the "path" to the video. Usually, this will be the name of the video file, which should be
 added in the Designer.

{:id="VideoPlayer.Visible" .boolean} *Visible*
: Specifies whether the `VideoPlayer` should be visible on the screen.  Value is `真`{:.logic.block}
 if the `VideoPlayer` is showing and `假`{:.logic.block} if hidden.

{:id="VideoPlayer.Volume" .number .wo} *Volume*
: Sets the volume property to a number between 0 and 100. Values less than 0
 will be treated as 0, and values greater than 100 will be treated as 100.

{:id="VideoPlayer.Width" .number .bo} *Width*
: Specifies the component's horizontal width, measured in pixels.

{:id="VideoPlayer.WidthPercent" .number .wo .bo} *WidthPercent*
: Specifies the horizontal width of the `VideoPlayer` as a percentage
 of the [`Screen`'s `Width`](userinterface.html#Screen.Width).

### 事件  {#VideoPlayer-Events}

{:.events}

{:id="VideoPlayer.Completed"} Completed()
: Indicates that the video has reached the end

### 方法  {#VideoPlayer-Methods}

{:.methods}

{:id="VideoPlayer.GetDuration" class="method returns number"} <i/> GetDuration()
: Returns duration of the video in milliseconds.

{:id="VideoPlayer.Pause" class="method"} <i/> Pause()
: Pauses playback of the video.  Playback can be resumed at the same location by calling the
 [`Start`](#VideoPlayer.Start) method.

{:id="VideoPlayer.SeekTo" class="method"} <i/> SeekTo(*ms*{:.number})
: Seeks to the requested time (specified in milliseconds) in the video. If the video is paused, the frame shown will not be updated by the seek. The player can jump only to key frames in the video, so seeking to times that differ by short intervals may not actually move to different frames.

{:id="VideoPlayer.Start" class="method"} <i/> Start()
: Plays the media specified by the [`Source`](#VideoPlayer.Source).

{:id="VideoPlayer.Stop" class="method"} <i/> Stop()
: Resets to start of video and pauses it if video was playing.
