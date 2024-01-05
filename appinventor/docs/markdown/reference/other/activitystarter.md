---
title: 使用Activity启动器组件
layout: documentation
description: App Inventor 2 使用Activity启动器组件
---

* TOC
{:toc}

[&laquo; 返回首页](index.html)

## 使用Activity启动器组件

Activity Starter 组件允许你通过让一个应用程序启动其他应用程序来组合应用程序。 这是通过利用其他应用程序来扩展 App Inventor 功能的关键方法，无论它们是使用 App Inventor 创建的应用程序还是“外部应用程序”（即不是使用 App Inventor 创建的应用程序）。 这些可以是你或其他人创建的 App Inventor 应用程序。 它们也可以是设备上预安装的相机和地图等应用程序。 或者它们可以是任何应用程序，只要你有必要的信息提供给活动发起者即可。 你还可以在启动应用程序时将值传递给应用程序，以及从应用程序返回结果以用于进一步处理。 此外，使用Android SDK的高级开发人员可以创建可以启动App Inventor应用程序的原始应用程序，并由它们启动。

ActivityStarter 组件文档的链接提供了有关 Activity Starter 组件属性、事件和方法的附加信息。

要使用 Activity Starter 启动应用程序，你必须向 Android 操作系统提供某些控制信息。 你可以通过在调用 ActivityStarter.StartActivity 方法之前设置 Activity Starter 的各种属性来实现此目的。 本节给出了一些示例。

## 启动其他 App Inventor 应用程序

你可以使用 Activity Starter 启动另一个使用 App Inventor 创建的应用程序。 这与在多屏幕应用程序中使用 OpenAnotherScreen 类似，只不过现在我们处理的是两个单独的应用程序，而不是单个应用程序中的两个屏幕。 要打开其他应用程序，你需要知道其包名和类名。 如果你有 App Inventor 应用程序的源代码（aia 文件），你可以按如下方式找到这些名称：

将源代码下载到你的计算机。
使用文件资源管理器或解压缩实用程序，找到名为 youngandroidproject/project.properties 的文件。
第一行以`main=`开头。 之后的所有内容都是包名和类名。

例如，你可能会看到名为 HelloPurr 的应用程序的第一行。

```json
main=appinventor.ai_ElsaArendelle.HelloPurr
```

名称中的 ElsaArendelle 部分来自 App Inventor 用户帐户。


要启动此应用程序，你将使用活动启动器组件并设置以下属性：

```json
ActivityPackage：appinventor.ai_ElsaArendelle.HelloPurr

ActivityClass：appinventor.ai_ElsaArendelle.HelloPurr.Screen
```

调用活动启动器的 StartActivity 方法将启动 HelloPurr。 当 HelloPurr 完成时（如果完成），将调用原始应用程序的 AfterActivity 方法。

如果你要启动另一个 App Inventor 应用程序，请确保使用正确的包名称。 例如，如果有人发布某个应用程序的源代码（aia 文件），并且你重新打包该应用程序，则最终会得到与原始包名称不同的包名称。

## 从 App Inventor 应用程序启动内置 Android 应用程序

Android 设备内置的应用程序可以通过使用包名称和类名称“显式”调用，如上所述。 它们还可以通过指定操作来“隐式”启动，在这种情况下，Android 操作系统可以确定要启动哪个实际应用程序。 用于启动应用程序的信息称为意图，确定启动哪个应用程序的过程称为意图解析。 你可以在有关意图和意图过滤器的 Android 系统文档中找到有关意图的信息。

有些应用程序设计为在启动时接受额外信息。 例如，Android Map 活动可以接受指定要显示的位置的地理信息。 你必须查阅特定应用程序的文档，以了解这些额外信息是什么以及如何指定它。 你还可以找到有关大多数设备上可用的 Google Android 应用程序的 Android Common Intents 的信息。

通常，你可以在使用 StartActivity 启动其他应用程序之前通过设置 ActivityStarter 的属性来指定信息。 你可以使用 ActivityStarter 属性 DataType 和 DataURI 在 App Inventor 中设置这些。 还有一个 Extras 属性，它采用键和值的列表并指定相应键的属性值。 你必须设置的特定值取决于你要启动的活动。

这里有些例子。

警告：这些示例中的值取决于应用程序用户设备上的 Android 操作系统版本。 如果你要创建将在许多不同设备上使用的应用程序，则可以运行 ActivityStarter.ResolveActivity 命令来测试用户设备是否支持你所需的 Activity，如果不支持，则生成相应的错误消息。

### 启动相机

要启动 Android 相机应用程序，请使用具有 IMAGE_CAPTURE Action 属性的活动启动器。 你没有指定 ActivityPackage 或 ActivityClass：

```json
Action：android.media.action.IMAGE_CAPTURE
```

这基本上就是 App Inventor Camera 组件的作用，尽管在构建应用程序时使用 Camera 组件比使用 ActivityStarter 更方便。

### 启动网络搜索

要启动 Web 搜索，请使用带有 WEB_SEARCH 操作的 ActivityStarter。 用户的手机将显示一个菜单，询问要执行哪种搜索：

```json
Action：android.intent.action.WEB_SEARCH
```

打开浏览器到指定网页：将这些 ActivityStarter 与 VIEW 操作和数据 Uri 一起使用，将手机浏览器打开到指定的网页，例如，

```json
Action：android.intent.action.VIEW
DataUri：https://www.fun123.cn
```

### 使用预先指定的消息启动邮件程序

2020 年 1 月 26 日：此示例已更新以适应 android 中的更改。 此处显示的电子邮件发送代码将在下一个应用程序发明者版本中运行，但尚未运行。

要启动 Android 邮件程序应用程序，请使用 SEND 操作并使用 EmailAddressList 属性指定电子邮件地址列表。 使用 android.intent.extra.SUBJECT 属性和 android.intent.extra.TEXT 属性指定主题和消息正文。 在每种情况下，启动活动都会弹出 Android 邮件程序，你可以完成消息，然后按“发送”。

例如，如果你指定：

```json
Action：android.intent.action.SEND
```

然后开始活动将显示邮件程序。

你还可以借助 android.extra.SUBJECT 和 android.extra.TEXT 指定主题行和消息文本。 你可以使用列表 android.intent.extra.EMAIL 指定收件人的电子邮件地址。 例如，要将电子邮件发送到 Santa@northpole.com，你可以使用：

![](images/activitystarter-image1.png)

观察 EXTRAS 是如何成为一个列表的，其中每个元素本身就是一个 2 项列表（键、值对）。 对于电子邮件地址，该值是地址列表（如果只有一个地址，则为 1 个地址的列表）。

### 显示某个位置的地图

如果你知道纬度和经度，则可以使用 VIEW 操作来显示该区域的地图：

```json
Action：android.intent.action.VIEW
DataUri：地理：37.8，-122.23?z=10
```

这里的 DataURI 指定纬度和经度以及缩放值 10 (z=10)。 缩放值是可选的，范围从 1（整个地球）到 23。

如果你知道某个位置的邮政编码，则可以按如下方式设置活动启动器属性：

```json
Action：android.intent.action.VIEW
DataUri：地理：0,0?q=94043
```

如果你有街道地址，则可以使用 DataUri 通过称为 URL 编码的方案对地址进行编码：

```json
Action：android.intent.action.VIEW
DataUri：地理：0,0?q=77+马萨诸塞州+大道%2C+剑桥%2C+MA
```

通常，在 URL 编码中，你必须替换空格（用 %20 或加号）和标点符号，例如逗号 (%2C) 和句点 (%2E)。

### 播放在线视频

你需要知道在线视频的 URI。 然后将 Activity Starter 操作设置为 VIEW，并将数据 URI 设置为视频URI，例如

```json
Action：android.intent.action.VIEW
DataUri：xxx/xxx
```

### 选择联系人

要选择联系人，请使用带有 PICK 操作的 ActivityStarter。 联系人将以 uri 的形式返回并存储在 Activity Starter 的 ResultUri 属性中

```json
Action：android.intent.action.PICK
```

## 启动其他外部应用程序

你可以使用活动启动器来启动任何活动。 你需要知道包名称和类名称，或适当的意图。 一些第三方应用程序开发人员记录了此信息。 有关启动外部应用程序的提示，请参阅 Android API 文档或搜索 Android 开发人员论坛。

## 了解如何设置 ActivityStarter 属性
如果你想启动一个应用程序，但没有源代码或文档，你仍然可以通过启动应用程序并检查 Android 系统日志来找出包名称和类名称（有时还包括意图）。
例如，如果你使用 YouTube 应用程序播放视频，你将在日志中看到：

```log
I/ActivityManager(   86): Starting activity: Intent { act=android.intent.action.VIEW dat=vnd.youtube:nAPk9ycCbfc cmp=com.google.android.youtube/.PlayerActivity }
```

如果你可以找到“cmp=”字符串，则 ActivityPackage 就是斜杠之前的部分，例如 com.google.android.youtube。 ActivityClass 是整个“cmp=”部分，没有斜杠字符，例如 com.google.android.youtube.PlayerActivity。 通常还可能有应指定为 DataUri 属性的“dat=”信息。

示例：启动外部应用程序来选择文件

Lysesoft 的 AndExplorer 是一款可让你从手机文件系统中选取文件的应用程序。 你可以将 AndExplorer 与活动启动器一起使用，以向你的应用程序添加文件选取功能。 如果你的手机上安装了 AndExplorer，则可以通过设置以下 Activity Starter 属性从 App Inventor 应用程序中选择文件：

```json
Action：android.intent.action.PICK
数据类型：vnd.android.cursor.dir/lysesoft.andexplorer.file
dataURI：文件:///sdcard
```

当 AndExplorer 运行时，它将显示文件列表并让你选择一个。 当 AndExplorer 完成并且调用 ActivityStarter.AfterActivity 时，生成的文件名将作为 ActivityStarter 的 ResultUri 属性的值提供。 另外，ResultType将给出文件的类型，例如image/jpeg或audio/mpeg。 使用此信息，你可以构建一个 App Inventor 应用程序，该应用程序允许你从文件系统中选择一个文件，并在选择 jpeg 文件时显示图像，或者在选择 mpeg 文件时播放音乐曲目。

此示例还说明了外部应用程序如何将值返回到 App Inventor 应用程序。 有关更多信息，请参阅下面的“将结果从外部应用程序返回到 App Inventor 应用程序”。

### 在应用程序之间传递值

一般情况下，App A 可以启动 App B。App A 也可以启动 App B 并向其传递启动值，App B 终止时可以将结果返回给 App A。 如何完成此操作的详细信息取决于特定的应用程序，以及 App Inventor 应用程序是正在启动的应用程序，还是正在启动的应用程序，或两者兼而有之。 请参阅下面的附录，了解有关创建与 App Inventor 应用程序交互的外部应用程序的提示。

### 将活动启动器与两个 App Inventor 应用程序一起使用

App Inventor 屏幕是活动，因此你可以使用活动启动器来启动其他 App Inventor 应用程序。 本页顶部的 Hello Purr 示例展示了如何执行此操作。 这基本上就是 App Inventor 的多屏幕应用程序的工作原理。

要将启动文本值传递到你使用 Activity Starter 启动的 App Inventor 应用程序，请使用 EXTRAS 将 KEY 属性设置为字符串 APP_INVENTOR_START，并将 VALUE 属性设置为要传递的文本。 然后，其他应用程序可以使用 Get Start Plain Text 检索此值。 要从其他应用程序返回值，请使用“使用纯文本关闭屏幕”。

对于两个 App Inventor 应用程序的情况，将组合设计为单个多屏幕应用程序更简单，而不是创建两个使用 Activity Starter 进行通信的单独应用程序。 但你可能希望拥有单独的应用程序的一种情况是，两个人在一个项目上松散地协作并希望单独工作。 请记住，为了运行组合应用程序，用户必须在其设备上安装这两个应用程序。

### 该应用程序在设备上可用吗？

如果你的应用尝试启动其他应用，你需要在尝试启动之前检查这些其他应用在用户的手机上是否可用。 你可以使用 ActivityStarter.ResolveActivity 来确定这一点，根据你提供的包或其他信息，它返回将由 ActivityStarter.StartActivity 启动的活动的名称。 如果此名称为空，则所需的应用程序不存在，你可以让你的应用程序提醒用户。


## 附录：为设计与 App Inventor 应用程序一起使用的外部应用程序的 Android 开发人员提供的技术信息

如果你使用 Android SDK 构建 Android 应用程序，则可以设计启动 App Inventor 应用程序的外部应用程序，也可以设计可以由 App Inventor 应用程序启动的应用程序。 你还可以安排在 App Inventor 应用程序和外部应用程序之间传递值。

**将结果从外部应用程序返回到 App Inventor 应用程序**
https://appinventor.mit.edu/explore/content/using-activity-starter.html 上的 AndExplorer 示例使用经典应用程序inventor，展示了外部应用程序如何在应用程序终止时将结果作为活动启动器的属性提供。 对于 AndExplorer，属性是 ResultType 和 ResultUri。 要了解有关 AndExplorer 的信息，你需要查找 AndExplorer 的文档或查看使用它的 Android 代码示例。

一般来说，当你的外部应用程序完成并向启动它的 App Inventor 应用程序返回意图时，Intent.type() 的值将作为 ActivityStarter.ResultType 属性提供。 同样，Intent.getDataString() 的值将作为 ResultUri 属性提供。

你还可以在意图中传回其他信息。 为结果选择一个名称（Java 字符串），并让 App Inventor 应用程序将该名称设置为活动启动器的 ResultName 属性。 要在 Intent 中从外部应用程序返回所需值，请使用 Intent.putextra(chosenResultName,desiredValue)。 当你的外部应用程序完成时，将发出 App Inventor ActivityStarter.AfterActivity() 事件信号，并且事件处理程序的结果参数将是所需的值。 同样的期望值也可用作活动启动器的结果属性。 所需的值必须是字符串，并且使用此方法只能返回一个值。

**从外部应用程序启动 App Inventor 应用程序**
要从外部应用程序启动 App Inventor 活动，请使用 Java Android 方法 startActivity() 或 startActivityForResult()。 要传递启动值，请通过调用方法 Intent.putExtra(tag, value) 将该值包含在意图中，其中 tag 是字符串 APP_INVENTOR_START。 然后，正在启动的 App Inventor 应用程序可以使用屏幕的 Get Start Plain Start Text 方法访问相应的值。

**将结果从 App Inventor 应用程序返回到外部应用程序**
当你启动的 App Inventor 应用程序完成时（更技术地说，当当前屏幕通过 CloseScreen 关闭时），它将向启动它的外部应用程序发出 onActivityResult() 信号。 App Inventor 应用程序可以使用“使用纯文本关闭屏幕”传回文本字符串值。 该值将通过返回的 Intent 作为 Intent.getStringExtra(APP_INVENTOR_RESULT) 提供给外部应用程序。
