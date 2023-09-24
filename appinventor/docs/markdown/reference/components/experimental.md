---
layout: documentation
title: App Inventor 2 试验组件
description: App Inventor 2 试验组件参考文档：包括ChatBot（OpenAI ChatGPT聊天机器人），Firebase数据库，ImageBot（OpenAI 绘图机器人）。
---

* TOC
{:toc}

[&laquo; 返回首页](index.html)
# <i class="mdi mdi-bug-outline"></i>  试验组件

目录：

1. <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAAUCAYAAACNiR0NAAACq0lEQVR42p1VPUiyURR+B1fHXFobJRQaKnSKBmc1si0kyrSwSI1agn7oZykjKn/IvyEoRSKwhnAwiCCiQQjEwcGCoKExK32+75zvuxc1i77vgcO97/He5zz33HOuCn7j/PwcfX190Gq16Ozs5FGv16OtrQ1TU1N4enqiZfj4+EC1WuWRrBWUs7MzKIqCkZER+P1+bG5uYnt7G1tbW9jb28Py8jKurq7wFWrVWiNhb28vxsfHWy5+fX1FOp3mIKurq1hbW8P6+jpWVlZwenoq15FqSUjqAoEAf7y9veH9/Z3nDw8PUKlUrL6npwfd3d1sJMBgMLB/fn5eEokUMOHu7m5DjgiLi4u8qVwuSxW1Wk1uPD4+5t9nZ2flHhqZkHJVH4Vgs9n4QpohNmezWSYkm5mZ4WBS4f7+/ifCwcFBTExMSD9tIKO0EMRlCvN6vd8TWq1WTE5Ofkq6UFIqlTA9PQ2fzwePxwPB89+EzaBKUKvV/0YoxpeXF67ThYUFPD8/sy8YDIrjt76UekJSVa/y4OCAm4BI6NgEKr0fE4raJNLDw0Mkk0n+vr29xcDAAM9DodAfQjr3zs7Ot4SESqWC4eFh7pRwOIyTkxPu+fv7e/6dRDFhR0eHVEibBClFdrlcsgWHhoa4Lm9ubri3NRoN8vm8DChzaDQa4XA4Pt2a2WyW/o2NDRmU+pmUFotFKaIhh5lMhid2u50TvbS0hEKhgNHRUfYRqL0SiQTu7u5wdHTU0L/isv7WIBRR9f39/ejq6mJnLpeD2+2G0+nkxY+PjxgbG4PFYsH19bV8SIhMdI68lOY+FTkkApPJhJ+CukWn00FprjHRCZeXlxyRjh6PxxGJRBCLxbgGaYxGo3I+NzfHa1OpVKNC8QAI0ouLC/4rqH8EWll7ezs/Z4RfAarSWV1mICUAAAAASUVORK5CYII=" width="16" height="16">  [ChatBot](#ChatBot)
1. <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAADD0lEQVR42m1TfUzMYRx/iP6wMfNy6tR5iWtdijKsrPOLcBjXpd8Vd9wS4RQtruyuOcqa0fhDa6nMeZlexBhZLZOXESVxRmdI10UvNmzy0v1+18dzna52890+z77PnufzeZ7P9/s8hLhiNHHHOF9C/KU0SaTYTsj4ZOLtwxIyKZLOJw/vI6PISPKSIL+5hPjdNu4Q9zWUhuDllWi01cWj/oIc+1OisEoqwaqogG+EiMrpAcKR3H+nz7h9PT8MeDIbeCMHvhj4Bxfl/IZIAU+IwEHXES8Lwvk8CZhF/mVOBssSLwK4rrKMCa7/0ywDmufbObMS6DGitnIbcnWrcfrQCpzJZQbumKL6+5rE2KvyrXNyBrlDAkqZqA7mxcArGce3KDDQqgI+7QM69cDHA8CHXUC7goMlEDuVwrtuAaNxyMK0cnNVMGBTcbDupWSKz+lAFxXozAKse4COOO73MxEU0VNvuQVYlvVyToJDxMXJO1bilD6KqzUl4vW93Wh/no4Pj1JhqUtCY1UsLh0L4w5nxSBiaeh1J8doNI4mcA40FoX4XbM2qKjvLdyJPDWOGLcgK5NFRrocWboNyMuJR5VJzVufqKHZKG5yN7PSWcnBXggr7C/mA91qDh0Z1IoBDic6M6kdg6sWXck8LGLELfd57hZgGDLGlfkVmK/RGrzbaMdHLSVRYs9BoJfWoYfmNh3wfjPfVjMHgbOFD0cIMIMCy6WS0yePJyAtKcJemLMGVYVKVJ9LQLVJgatFChQdlSF160L+eB4LxfrwxmELla4iBoqmlHxtiUfbUy1Xc1WLCtMunC3chpKCrbhYrMHNsu1ovZ/C/zArsGmtyEIpLuu0jUMWSvtb5tErJ/6i7XOgWz+A3uwBfNFR0Lxb70CXph+vZmGddLqVEIm3Rw2EydVFC9DXEgfH29300VDPtkzXe7AdgON9Bl1LQMPlUEwW+NeQ/4cgduK0mTe06vB3ORnM93xDzJ/8bMaeq1v2M02z+HNIUMBjetNDhMyZ4PkjPWMshQ9FAAX9pUREMcFjzyD5L3bts9I+U7jyAAAAAElFTkSuQmCC" width="16" height="16">  [Firebase数据库](#FirebaseDB)
1. <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAACeUlEQVR42p2TT0gUcRTHVyJUCPagXSSpiMgwpJAZd3ZmdnZczJ0/u7O77o7b0uqmZpuYfyAh6LIIFlkk5SFXhBYr3Dr07xB0kTDNjh281qF/B3XBJEgQ99tbJTP1oP2GBwPz+3zfe9/3xmL5j8NxnMvpdA4JghDZNcyyLOdyuTKJRAKyLE/tCq6srCyTJGk2lUohEAgs8Dx/YSfQXso6SDFDwGwymUQsFvshiuKNbYFQKLRHVdUqw6N2h33KK1kSFyWHI+t2u0ECCAaDSwSPbgF1XT8aNtS06VNnO8M1833R6pWRJh5OOwtN00DfQcIgA5cZhjn/D2x6ld7GgJJ50Cpm33VVIaqcQ2nJBHimAeQ0aiQeDo6FjWWXqJWvJHBzHTZ0XW0PnV7Ige+718KUe2CxABUVlJHRMNbM4m2XDWd8yryiKEc2Zx+mzJgmcLCdR3+nHfebasGUj8JqnQR36i5eX7KvCj9rE7LU5lydoXaTUP6fClquR+VfD9sEHHt+GIVzhdBvn8STuAM9/ggGovp6Zbl402HDtWj1z3pD+UbeHM+5Xmga6pexuIATLw/CQk/ech7artgwTpfvmTzSjdxqhRuF+hurl3weT+taFTS2CPV39TKHiheHUPyhCPEOAbe8POYKCvDRasWQwq6LpFuFrGlonyj5vr9mappYTyMcbpFWUtTORKcNI6YdmYJ85Byd2V+MdDOPx3FhhSr+TB4c2LILXq+3pN6nTbWbtZmnF3lM0WSG3QymS0vwqLwMyQYRtCfft4U3HloYR9ivTp71K/O9UdfiQEzGHYqmOneGFkrY8c/j9/uLPB6PL2hofVTZAL1Lm+/8BuYmMbTdqpuSAAAAAElFTkSuQmCC" width="16" height="16">  [ImageBot](#ImageBot)

***
## <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAAUCAYAAACNiR0NAAACq0lEQVR42p1VPUiyURR+B1fHXFobJRQaKnSKBmc1si0kyrSwSI1agn7oZykjKn/IvyEoRSKwhnAwiCCiQQjEwcGCoKExK32+75zvuxc1i77vgcO97/He5zz33HOuCn7j/PwcfX190Gq16Ozs5FGv16OtrQ1TU1N4enqiZfj4+EC1WuWRrBWUs7MzKIqCkZER+P1+bG5uYnt7G1tbW9jb28Py8jKurq7wFWrVWiNhb28vxsfHWy5+fX1FOp3mIKurq1hbW8P6+jpWVlZwenoq15FqSUjqAoEAf7y9veH9/Z3nDw8PUKlUrL6npwfd3d1sJMBgMLB/fn5eEokUMOHu7m5DjgiLi4u8qVwuSxW1Wk1uPD4+5t9nZ2flHhqZkHJVH4Vgs9n4QpohNmezWSYkm5mZ4WBS4f7+/ifCwcFBTExMSD9tIKO0EMRlCvN6vd8TWq1WTE5Ofkq6UFIqlTA9PQ2fzwePxwPB89+EzaBKUKvV/0YoxpeXF67ThYUFPD8/sy8YDIrjt76UekJSVa/y4OCAm4BI6NgEKr0fE4raJNLDw0Mkk0n+vr29xcDAAM9DodAfQjr3zs7Ot4SESqWC4eFh7pRwOIyTkxPu+fv7e/6dRDFhR0eHVEibBClFdrlcsgWHhoa4Lm9ubri3NRoN8vm8DChzaDQa4XA4Pt2a2WyW/o2NDRmU+pmUFotFKaIhh5lMhid2u50TvbS0hEKhgNHRUfYRqL0SiQTu7u5wdHTU0L/isv7WIBRR9f39/ejq6mJnLpeD2+2G0+nkxY+PjxgbG4PFYsH19bV8SIhMdI68lOY+FTkkApPJhJ+CukWn00FprjHRCZeXlxyRjh6PxxGJRBCLxbgGaYxGo3I+NzfHa1OpVKNC8QAI0ouLC/4rqH8EWll7ezs/Z4RfAarSWV1mICUAAAAASUVORK5CYII=" width="20" height="20">  ChatBot（OpenAI ChatGPT聊天机器人）  {#ChatBot}

ChatBot 是一个不可见组件，用于与 AI 聊天的聊天机器人。此版本使用 MIT 运行的代理，该代理又使用 ChatGPT 生成大语言模型。

注：此组件对AI伴侣要求最低版本为v2.67 (旧版本请扫码升级：帮助 -> AI伴侣信息)，编译为apk则不受限制安装后可正常运行。

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
## <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAADD0lEQVR42m1TfUzMYRx/iP6wMfNy6tR5iWtdijKsrPOLcBjXpd8Vd9wS4RQtruyuOcqa0fhDa6nMeZlexBhZLZOXESVxRmdI10UvNmzy0v1+18dzna52890+z77PnufzeZ7P9/s8hLhiNHHHOF9C/KU0SaTYTsj4ZOLtwxIyKZLOJw/vI6PISPKSIL+5hPjdNu4Q9zWUhuDllWi01cWj/oIc+1OisEoqwaqogG+EiMrpAcKR3H+nz7h9PT8MeDIbeCMHvhj4Bxfl/IZIAU+IwEHXES8Lwvk8CZhF/mVOBssSLwK4rrKMCa7/0ywDmufbObMS6DGitnIbcnWrcfrQCpzJZQbumKL6+5rE2KvyrXNyBrlDAkqZqA7mxcArGce3KDDQqgI+7QM69cDHA8CHXUC7goMlEDuVwrtuAaNxyMK0cnNVMGBTcbDupWSKz+lAFxXozAKse4COOO73MxEU0VNvuQVYlvVyToJDxMXJO1bilD6KqzUl4vW93Wh/no4Pj1JhqUtCY1UsLh0L4w5nxSBiaeh1J8doNI4mcA40FoX4XbM2qKjvLdyJPDWOGLcgK5NFRrocWboNyMuJR5VJzVufqKHZKG5yN7PSWcnBXggr7C/mA91qDh0Z1IoBDic6M6kdg6sWXck8LGLELfd57hZgGDLGlfkVmK/RGrzbaMdHLSVRYs9BoJfWoYfmNh3wfjPfVjMHgbOFD0cIMIMCy6WS0yePJyAtKcJemLMGVYVKVJ9LQLVJgatFChQdlSF160L+eB4LxfrwxmELla4iBoqmlHxtiUfbUy1Xc1WLCtMunC3chpKCrbhYrMHNsu1ovZ/C/zArsGmtyEIpLuu0jUMWSvtb5tErJ/6i7XOgWz+A3uwBfNFR0Lxb70CXph+vZmGddLqVEIm3Rw2EydVFC9DXEgfH29300VDPtkzXe7AdgON9Bl1LQMPlUEwW+NeQ/4cgduK0mTe06vB3ORnM93xDzJ/8bMaeq1v2M02z+HNIUMBjetNDhMyZ4PkjPWMshQ9FAAX9pUREMcFjzyD5L3bts9I+U7jyAAAAAElFTkSuQmCC" width="20" height="20">  Firebase数据库  {#FirebaseDB}

Firebase 组件与 Web 服务通信以存储并获取数据。 该组件可以在标签下存储值并检索与标签关联的值。 它还拥有一个监听器，可以在存储值改变时触发事件。

 [更多信息](../other/firebaseIntro.html)

 [FirebaseDB vs TinyWebDB 区别](../other/firebaseIntro.html#FirebaseDB_vs_TinyWebDB)


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
## <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAACeUlEQVR42p2TT0gUcRTHVyJUCPagXSSpiMgwpJAZd3ZmdnZczJ0/u7O77o7b0uqmZpuYfyAh6LIIFlkk5SFXhBYr3Dr07xB0kTDNjh281qF/B3XBJEgQ99tbJTP1oP2GBwPz+3zfe9/3xmL5j8NxnMvpdA4JghDZNcyyLOdyuTKJRAKyLE/tCq6srCyTJGk2lUohEAgs8Dx/YSfQXso6SDFDwGwymUQsFvshiuKNbYFQKLRHVdUqw6N2h33KK1kSFyWHI+t2u0ECCAaDSwSPbgF1XT8aNtS06VNnO8M1833R6pWRJh5OOwtN00DfQcIgA5cZhjn/D2x6ld7GgJJ50Cpm33VVIaqcQ2nJBHimAeQ0aiQeDo6FjWWXqJWvJHBzHTZ0XW0PnV7Ige+718KUe2CxABUVlJHRMNbM4m2XDWd8yryiKEc2Zx+mzJgmcLCdR3+nHfebasGUj8JqnQR36i5eX7KvCj9rE7LU5lydoXaTUP6fClquR+VfD9sEHHt+GIVzhdBvn8STuAM9/ggGovp6Zbl402HDtWj1z3pD+UbeHM+5Xmga6pexuIATLw/CQk/ech7artgwTpfvmTzSjdxqhRuF+hurl3weT+taFTS2CPV39TKHiheHUPyhCPEOAbe8POYKCvDRasWQwq6LpFuFrGlonyj5vr9mappYTyMcbpFWUtTORKcNI6YdmYJ85Byd2V+MdDOPx3FhhSr+TB4c2LILXq+3pN6nTbWbtZmnF3lM0WSG3QymS0vwqLwMyQYRtCfft4U3HloYR9ivTp71K/O9UdfiQEzGHYqmOneGFkrY8c/j9/uLPB6PL2hofVTZAL1Lm+/8BuYmMbTdqpuSAAAAAElFTkSuQmCC" width="20" height="20">  ImageBot（OpenAI 绘图机器人）  {#ImageBot}

ImageBot 是一个不可见组件，它使用 DALL-E 2 创建和编辑图像。你必须通过在块中设置其 ApiKey 属性，为此组件提供您自己的 OpenAI API 密钥。

注：此组件对AI伴侣要求最低版本为v2.67 (旧版本请扫码升级：帮助 -> AI伴侣信息)，编译为apk则不受限制安装后可正常运行。

* demo程序下载：
[AI绘图.aia](demo/AI绘图.aia)

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
