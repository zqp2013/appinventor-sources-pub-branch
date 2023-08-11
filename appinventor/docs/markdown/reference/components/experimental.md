---
layout: documentation
title: App Inventor 2 试验组件
description: App Inventor 2 试验组件参考文档：包括ChatBot（OpenAI ChatGPT聊天机器人），Firebase数据库，ImageBot（OpenAI 绘图机器人）。
---

[&laquo; 返回首页](index.html)
# <i class="mdi mdi-bug-outline"></i>  试验组件

目录：

* [ChatBot](#ChatBot)
* [Firebase数据库](#FirebaseDB)
* [ImageBot](#ImageBot)

***
## ChatBot（OpenAI ChatGPT聊天机器人）  {#ChatBot}

ChatBot 是一个不可见组件，用于与 AI 聊天的聊天机器人。此版本使用 MIT 运行的代理，该代理又使用 ChatGPT 生成大语言模型。

注：此组件对AI伴侣要求最低版本为2.67 ([点此下载](https://www.fun123.cn/reference/info/2.67/MITAI2Companion.apk))，编译为apk则没有限制均能正常运行。

* demo程序下载：
[chatgpt.aia](demo/chatgpt.aia)

### 属性  {#ChatBot-Properties}

{:.properties}

{:id="ChatBot.ApiKey" .text .bo} *ApiKey*
: ChatGPT 的 ApiKey，由用户提供。如果提供，我们将使用它来代替聊天代理服务中的 API 密钥。

  注意：我们不将其作为属性在“界面设计”视图中提供，应在“程序设计”视图中使用代码块设置。最好使用`文本块`中的[`模糊文本`](../blocks/text.html#obfuscatetext)对嵌入在打包应用程序中的密钥提供一些保护（但不是完美的保护）。

{:id="ChatBot.Model" .text} *模型*
: 设置要使用的模型的名称。请参阅 [https://appinv.us/chatbot](https://appinv.us/chatbot) 了解当前支持的模型列表，留空将使用提供商设置的默认模型。

{:id="ChatBot.Provider" .text} *提供商*
: 设置要使用的提供商的名称，如`chatgpt`。请参阅 [https://appinv.us/chatbot](https://appinv.us/chatbot) 了解当前支持的提供商列表。

{:id="ChatBot.System" .text} *系统值*
: 赋予 ChatGPT 的系统值，它用于设定对话的基调，例如：`“你是一个有趣的人。”`

{:id="ChatBot.Token" .text .wo} *访问令牌*
: 要使用的 MIT 访问令牌，默认会自动填写此内容值，不需要更改它。

### 事件  {#ChatBot-Events}

{:.events}

{:id="ChatBot.ErrorOccurred"} 出现错误(*响应代码*{:.number},*响应文本*{:.text})
: 当执行期间发生错误时，将运行 `出现错误` 事件处理，例如是否超过使用配额，或者某些ChatGPT 或 PaLM 发出的其他错误。
  
  看 [https://appinv.us/chatbot](https://appinv.us/chatbot) 了解最新信息。

{:id="ChatBot.GotResponse"} 获取响应(*响应文本*{:.text})
: 指示请求已完成并已返回数据的事件（来自 ChatBot 的输出）。

### 方法  {#ChatBot-Methods}

{:.methods}

{:id="ChatBot.Converse" class="method"} <i/> 对话(*question*{:.text})
: 向聊天机器人询问问题，连续的对话将记住先前对话中的信息，使用 [重置对话](#ChatBot.ResetConversation) 方法重置开始新的对话。

{:id="ChatBot.ResetConversation" class="method"} <i/> 重置对话()
: 重置当前对话，聊天机器人在回复时会忘记之前的任何对话。

***
## Firebase数据库  {#FirebaseDB}

The Firebase component communicates with a Web service to store
 and retrieve information.  The component has methods to
 store a value under a tag and to retrieve the value associated with
 the tag. It also possesses a listener to fire events when stored
 values are changed.

 [Additional Information](../other/firebaseIntro.html)



### 属性  {#FirebaseDB-Properties}

{:.properties}

{:id="FirebaseDB.DeveloperBucket" .text .do} *DeveloperBucket*
: Getter for the DeveloperBucket.

{:id="FirebaseDB.FirebaseToken" .text .do} *FirebaseToken*
: Getter for the FirebaseToken.

{:id="FirebaseDB.FirebaseURL" .text .do} *FirebaseURL*
: Specifies the URL for the Firebase.

 The default value is currently my private Firebase URL, but this will
 eventually changed once the App Inventor Candle plan is activated.

{:id="FirebaseDB.Persist" .boolean .wo .do} *Persist*
: If true, variables will retain their values when off-line and the App exits. Values will be uploaded to Firebase the next time the App is run while connected to the network. This is useful for applications which will gather data while not connected to the network. Note: AppendValue and RemoveFirst will not work correctly when off-line, they require a network connection.<br/><br/> <i>Note</i>: If you set Persist on any Firebase component, on any screen, it makes all Firebase components on all screens persistent. This is a limitation of the low level Firebase library. Also be aware that if you want to set persist to true, you should do so before connecting the Companion for incremental development.

{:id="FirebaseDB.ProjectBucket" .text} *ProjectBucket*
: Getter for the ProjectBucket.

### 事件  {#FirebaseDB-Events}

{:.events}

{:id="FirebaseDB.DataChanged"} DataChanged(*tag*{:.text},*value*{:.any})
: Indicates that the data in the Firebase has changed.
 Launches an event with the tag and value that have been updated.

{:id="FirebaseDB.FirebaseError"} FirebaseError(*message*{:.text})
: Indicates that the communication with the Firebase signaled an error.

{:id="FirebaseDB.FirstRemoved"} FirstRemoved(*value*{:.any})
: Event triggered by the "RemoveFirst" function. The argument "value" is the object that was the first in the list, and which is now removed.

{:id="FirebaseDB.GotValue"} GotValue(*tag*{:.text},*value*{:.any})
: Indicates that a GetValue request has succeeded.

{:id="FirebaseDB.TagList"} TagList(*value*{:.list})
: Event triggered when we have received the list of known tags. Used with the "GetTagList" Function.

### 方法  {#FirebaseDB-Methods}

{:.methods}

{:id="FirebaseDB.AppendValue" class="method"} <i/> AppendValue(*tag*{:.text},*valueToAdd*{:.any})
: Append a value to the end of a list atomically. If two devices use this function simultaneously, both will be appended and no data lost.

{:id="FirebaseDB.ClearTag" class="method"} <i/> ClearTag(*tag*{:.text})
: Asks Firebase to forget (delete or set to "null") a given tag.

{:id="FirebaseDB.GetTagList" class="method"} <i/> GetTagList()
: Get the list of tags for this application. When complete a "TagList" event will be triggered with the list of known tags.

{:id="FirebaseDB.GetValue" class="method"} <i/> GetValue(*tag*{:.text},*valueIfTagNotThere*{:.any})
: GetValue asks Firebase to get the value stored under the given tag.
 It will pass valueIfTagNotThere to GotValue if there is no value stored
 under the tag.

{:id="FirebaseDB.RemoveFirst" class="method"} <i/> RemoveFirst(*tag*{:.text})
: Return the first element of a list and atomically remove it. If two devices use this function simultaneously, one will get the first element and the the other will get the second element, or an error if there is no available element. When the element is available, the "FirstRemoved" event will be triggered.

{:id="FirebaseDB.StoreValue" class="method"} <i/> StoreValue(*tag*{:.text},*valueToStore*{:.any})
: Asks Firebase to store the given value under the given tag.

{:id="FirebaseDB.Unauthenticate" class="method"} <i/> Unauthenticate()
: Unauthenticate from Firebase.

   Firebase keeps track of credentials in a cache in shared_prefs
 It will re-use these credentials as long as they are valid. Given
 That we retrieve a FirebaseToken with a version long life, this will
 effectively be forever. Shared_prefs survive an application update
 and depending on how backup is configured on a device, it might survive
 an application removal and reinstallation.

   Normally this is not a problem, however if we change the credentials
 used, for example the App author is switching from one Firebase account
 to another, or invalided their firebase.secret, this cached credential
 is invalid, but will continue to be used, which results in errors.

   This function permits us to unauthenticate, which tosses the cached
 credentials. The next time authentication is needed we will use our
 current FirebaseToken and get fresh credentials.


***
## ImageBot（OpenAI 绘图机器人）  {#ImageBot}

ImageBot 是一个不可见组件，它使用 DALL-E 2 创建和编辑图像。你必须通过在块中设置其 ApiKey 属性，为此组件提供您自己的 OpenAI API 密钥。

注：此组件对AI伴侣要求最低版本为2.67 ([点此下载](https://www.fun123.cn/reference/info/2.67/MITAI2Companion.apk))，编译为apk则没有限制均能正常运行。

### 属性  {#ImageBot-Properties}

{:.properties}

{:id="ImageBot.ApiKey" .text .wo .bo} *ApiKey*
: 指定用于向 ImageBot 进行身份验证的 ApiKey。

{:id="ImageBot.InvertMask" .boolean} *反转遮罩*
: 指定用于编辑的蒙版是否应反转其 Alpha 通道。

{:id="ImageBot.Size" .number} *图像大小*
: 指定生成图像的大小。 可以是 256、512 或 1024 之一。

{:id="ImageBot.Token" .text .wo} *访问令牌*
: 要使用的 MIT 访问令牌，默认会自动填写此内容值，不需要更改它。

### 事件  {#ImageBot-Events}

{:.events}

{:id="ImageBot.ErrorOccurred"} 出现错误(*responseCode*{:.number},*responseText*{:.text})
: 该事件将在处理过程中发生错误时运行，例如：忘记提供 API 密钥或服务器过载等。

{:id="ImageBot.ImageCreated"} 图像创建完成(*fileName*{:.text})
: 当 ImageBot 成功创建图像时，将运行此事件。

{:id="ImageBot.ImageEdited"} 图像编辑完成(*fileName*{:.text})
: 当 ImageBot 成功编辑图像时，将运行此事件。

### 方法  {#ImageBot-Methods}

{:.methods}

{:id="ImageBot.CreateImage" class="method"} <i/> 创建图像(*description*{:.text})
: 使用给定的描述创建图像。

{:id="ImageBot.EditImage" class="method"} <i/> 编辑图像(*source*{:.any},*description*{:.text})
: 使用给定的描述编辑源图像。图像的可编辑区域应具有透明的Alpha值，源可以是 Canvas 组件、Image 组件或字符串代表文件的路径。

{:id="ImageBot.EditImageWithMask" class="method"} <i/> 使用遮罩编辑图像(*imageSource*{:.any},*遮罩源*{:.any},*提示*{:.text})
: 使用给定的描述编辑 `遮罩源`。图像的可编辑区域应该是由 `遮罩源` 指示。源可以是画布、图像或字符串代表文件的路径。
