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

## <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAAUCAYAAACNiR0NAAACq0lEQVR42p1VPUiyURR+B1fHXFobJRQaKnSKBmc1si0kyrSwSI1agn7oZykjKn/IvyEoRSKwhnAwiCCiQQjEwcGCoKExK32+75zvuxc1i77vgcO97/He5zz33HOuCn7j/PwcfX190Gq16Ozs5FGv16OtrQ1TU1N4enqiZfj4+EC1WuWRrBWUs7MzKIqCkZER+P1+bG5uYnt7G1tbW9jb28Py8jKurq7wFWrVWiNhb28vxsfHWy5+fX1FOp3mIKurq1hbW8P6+jpWVlZwenoq15FqSUjqAoEAf7y9veH9/Z3nDw8PUKlUrL6npwfd3d1sJMBgMLB/fn5eEokUMOHu7m5DjgiLi4u8qVwuSxW1Wk1uPD4+5t9nZ2flHhqZkHJVH4Vgs9n4QpohNmezWSYkm5mZ4WBS4f7+/ifCwcFBTExMSD9tIKO0EMRlCvN6vd8TWq1WTE5Ofkq6UFIqlTA9PQ2fzwePxwPB89+EzaBKUKvV/0YoxpeXF67ThYUFPD8/sy8YDIrjt76UekJSVa/y4OCAm4BI6NgEKr0fE4raJNLDw0Mkk0n+vr29xcDAAM9DodAfQjr3zs7Ot4SESqWC4eFh7pRwOIyTkxPu+fv7e/6dRDFhR0eHVEibBClFdrlcsgWHhoa4Lm9ubri3NRoN8vm8DChzaDQa4XA4Pt2a2WyW/o2NDRmU+pmUFotFKaIhh5lMhid2u50TvbS0hEKhgNHRUfYRqL0SiQTu7u5wdHTU0L/isv7WIBRR9f39/ejq6mJnLpeD2+2G0+nkxY+PjxgbG4PFYsH19bV8SIhMdI68lOY+FTkkApPJhJ+CukWn00FprjHRCZeXlxyRjh6PxxGJRBCLxbgGaYxGo3I+NzfHa1OpVKNC8QAI0ouLC/4rqH8EWll7ezs/Z4RfAarSWV1mICUAAAAASUVORK5CYII=" width="20" height="20">  ChatBot（OpenAI ChatGPT聊天机器人）  {#ChatBot}

ChatBot 是一个不可见组件，用于与 AI 聊天的聊天机器人。此版本使用 MIT 运行的代理，该代理又使用 ChatGPT 生成大语言模型。

>来自MIT官方的提醒：人们应该小心聊天机器人。他们经常产生虚假结果。根据我的经验，他们总体上是正确的，但细节可能是错误的。

注：此组件对AI伴侣要求最低版本为v2.67 (旧版本请扫码升级：帮助 -> AI伴侣信息)，编译为apk则不受限制安装后可正常运行。

* demo程序下载：
[chatgpt.aia](demo/chatgpt.aia)

### 属性  {#ChatBot-Properties}

{:.properties}

{:id="ChatBot.ApiKey" .text .bo} *ApiKey*
: ChatGPT 的 ApiKey，由用户提供。如果提供，我们将使用它来代替聊天代理服务中的 API 密钥。

  注意：我们不将其作为属性在“界面设计”视图中提供，应在“程序设计”视图中使用代码块设置。最好使用`文本块`中的[`模糊文本`](../blocks/text.html#obfuscatetext)对嵌入在打包应用程序中的密钥提供一些保护（但不是完美的保护）。

  >**如果提供你自己从 OpenAI 获取的 ApiKey，则不受 MIT 施加的限制**。不过，为了方便轻松访问这些组件，如果没有获取ApiKey，那么将会使用MIT获取的ApiKey。由于这需要花钱，因此目前每天的使用次数受到限制。 注意：如果您打包应用程序并分发它，则您应用程序的所有使用都将受到相同的配额限制。 如果您希望分发使用这些服务的应用程序，建议使用MIT的 ApiKey 进行测试，但最终发布时使用你自己的 ApiKey。

{:id="ChatBot.Model" .text} *模型*
: 设置要使用的模型的名称。留空将使用提供商设置的默认模型，目前，模型供将来使用，不执行任何操作。

{:id="ChatBot.Provider" .text} *提供商*
: 设置要使用的提供商的名称，默认值是`chatgpt`。请参阅 [https://appinv.us/chatbot](https://appinv.us/chatbot) 了解当前支持的提供商列表。

  >除了ChatGPT，你还可以选择 Google 的 PaLM 大语言模型。要使用 PaLM，请将“提供商”属性设置为“palm”（注意，全部小写）。但是，Google 对谁可以使用 PaLM 有限制，如果你获得自己的 ApiKey 则不受任何限制。

{:id="ChatBot.System" .text} *系统值*
: 赋予 ChatGPT 的系统值，它用于设定对话的基调，例如：`“你是一个有趣的人。”`

{:id="ChatBot.Token" .text .wo} *访问令牌*
: 要使用的 MIT 访问令牌，默认会自动填写此内容值，不需要更改它。

  默认情况下，令牌是无法访问MIT代理服务器的，如需有效令牌请参照[《App Inventor 2 使用MIT代理的组件访问令牌的获取方法》](../creative/token.html)。

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

## <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAADD0lEQVR42m1TfUzMYRx/iP6wMfNy6tR5iWtdijKsrPOLcBjXpd8Vd9wS4RQtruyuOcqa0fhDa6nMeZlexBhZLZOXESVxRmdI10UvNmzy0v1+18dzna52890+z77PnufzeZ7P9/s8hLhiNHHHOF9C/KU0SaTYTsj4ZOLtwxIyKZLOJw/vI6PISPKSIL+5hPjdNu4Q9zWUhuDllWi01cWj/oIc+1OisEoqwaqogG+EiMrpAcKR3H+nz7h9PT8MeDIbeCMHvhj4Bxfl/IZIAU+IwEHXES8Lwvk8CZhF/mVOBssSLwK4rrKMCa7/0ywDmufbObMS6DGitnIbcnWrcfrQCpzJZQbumKL6+5rE2KvyrXNyBrlDAkqZqA7mxcArGce3KDDQqgI+7QM69cDHA8CHXUC7goMlEDuVwrtuAaNxyMK0cnNVMGBTcbDupWSKz+lAFxXozAKse4COOO73MxEU0VNvuQVYlvVyToJDxMXJO1bilD6KqzUl4vW93Wh/no4Pj1JhqUtCY1UsLh0L4w5nxSBiaeh1J8doNI4mcA40FoX4XbM2qKjvLdyJPDWOGLcgK5NFRrocWboNyMuJR5VJzVufqKHZKG5yN7PSWcnBXggr7C/mA91qDh0Z1IoBDic6M6kdg6sWXck8LGLELfd57hZgGDLGlfkVmK/RGrzbaMdHLSVRYs9BoJfWoYfmNh3wfjPfVjMHgbOFD0cIMIMCy6WS0yePJyAtKcJemLMGVYVKVJ9LQLVJgatFChQdlSF160L+eB4LxfrwxmELla4iBoqmlHxtiUfbUy1Xc1WLCtMunC3chpKCrbhYrMHNsu1ovZ/C/zArsGmtyEIpLuu0jUMWSvtb5tErJ/6i7XOgWz+A3uwBfNFR0Lxb70CXph+vZmGddLqVEIm3Rw2EydVFC9DXEgfH29300VDPtkzXe7AdgON9Bl1LQMPlUEwW+NeQ/4cgduK0mTe06vB3ORnM93xDzJ/8bMaeq1v2M02z+HNIUMBjetNDhMyZ4PkjPWMshQ9FAAX9pUREMcFjzyD5L3bts9I+U7jyAAAAAElFTkSuQmCC" width="20" height="20">  Firebase数据库  {#FirebaseDB}

Firebase 组件与 Web 服务通信以存储并获取数据。 该组件可以在标签下存储值并检索与标签关联的值。 它还拥有一个监听器，可以在存储值改变时触发事件。

 [更多信息](../other/firebaseIntro.html)

 [FirebaseDB vs TinyWebDB 区别](../other/firebaseIntro.html#FirebaseDB_vs_TinyWebDB)

| 区别 |Firebase数据库 | 网络微数据库 |
|--|--|--|
|区别在于来自不同应用程序的变量是否会干扰 | 每个应用程序都有其单独的数据存储，因此其他应用程序的变量**不会干扰** | 任何应用程序都可以更改值，前提是它使用相同的标签 |


### 属性  {#FirebaseDB-Properties}

{:.properties}

{:id="FirebaseDB.DeveloperBucket" .text .do} *开发者桶*
: 获取开发者桶(bucket)。

{:id="FirebaseDB.FirebaseToken" .text .do} *Firebase令牌*
: 获取Firebase访问令牌。

{:id="FirebaseDB.FirebaseURL" .text .do} *Firebase URL地址*
: 指定 Firebase 的 URL地址。当前默认值是MIT私有 Firebase URL地址，目前选择默认即可。

{:id="FirebaseDB.Persist" .boolean .wo .do} *持久化*
: 如果为 `真`，则变量在离线且应用程序退出时将保留其值。下次应用程序在连接到网络时运行时，值将上传到 Firebase。这对于在未连接到网络时收集数据的应用程序非常有用。

  **注意：**
  
  - [追加值](#FirebaseDB.AppendValue) 和 [删除第一项](#FirebaseDB.RemoveFirst) 在离线时无法正常工作，它们需要网络连接。
  
  - 如果你在任何 Firebase 组件、任何屏幕上设置 持久化， 它使所有屏幕上的所有 Firebase 组件保持不变。这是 Firebase 底层库的限制。

{:id="FirebaseDB.ProjectBucket" .text} *项目桶*
: 获取项目桶(bucket)。

### 事件  {#FirebaseDB-Events}

{:.events}

{:id="FirebaseDB.DataChanged"} 数据改变时(*标签*{:.text},*值*{:.any})
: 表示 Firebase 中的数据已更改。
  
  使用已更新的标签和值启动事件。

{:id="FirebaseDB.FirebaseError"} Firebase错误时(*消息*{:.text})
: 表示与 Firebase 的通信发出错误信号。

{:id="FirebaseDB.FirstRemoved"} 第一项已删除时(*值*{:.any})
: 由 [删除第一项](#FirebaseDB.RemoveFirst) 函数触发的事件。参数“值”是列表中第一个对象，现在已被删除。

{:id="FirebaseDB.GotValue"} 以获得值时(*标签*{:.text},*值*{:.any})
: 表示 [获取值](#FirebaseDB.GetValue) 请求已成功。

{:id="FirebaseDB.TagList"} 收到标签列表时(*值*{:.list})
: 当我们收到已知标签列表时触发事件。与 [获取标签列表](#FirebaseDB.GetTagList) 函数一起使用。

### 方法  {#FirebaseDB-Methods}

{:.methods}

{:id="FirebaseDB.AppendValue" class="method"} <i/> 追加值(*标签*{:.text},*待追加值*{:.any})
: 以原子(Atomic)方式将值附加到列表末尾。如果两个设备同时使用此功能，两个设备都会被追加并且不会丢失数据。

{:id="FirebaseDB.ClearTag" class="method"} <i/> 清除标签(*标签*{:.text})
: 要求 Firebase 清除（删除或设置为“null”）给定标签。

{:id="FirebaseDB.GetTagList" class="method"} <i/> 获取标签列表()
: 获取此应用程序的标签列表。完成后，将使用已知标签列表触发 [收到标签列表时](#FirebaseDB.TagList) 事件。

{:id="FirebaseDB.GetValue" class="method"} <i/> 获取值(*标签*{:.text},*无标签时返回值*{:.any})
: 获取值 要求 Firebase 获取存储在给定标签下的值。
  
  如果标签下没有存储值，它将把 “无标签时返回值” 传递给事件 [以获得值时](FirebaseDB.GotValue)。

{:id="FirebaseDB.RemoveFirst" class="method"} <i/> 删除第一项(*标签*{:.text})
: 返回列表的第一个元素并自动删除它。如果两个设备同时使用此功能，一个将获取第一个元素，另一个将获取第二个元素，如果没有可用元素，则会出现错误。当元素可用时，将触发[删除第一项](#FirebaseDB.RemoveFirst)事件。

{:id="FirebaseDB.StoreValue" class="method"} <i/> 存储值(*标签*{:.text},*待存储值*{:.any})
: 要求 Firebase 将给定值存储在给定标签下。

{:id="FirebaseDB.Unauthenticate" class="method"} <i/> 取消身份验证()
: 从 Firebase 取消身份验证。

    Firebase 会跟踪共享首选项中缓存中的凭据，只要这些凭据有效，它就会重复使用这些凭据。 鉴于我们获取的 Firebase令牌有效期较长，这实际上将是永久的。 Shared_prefs 在应用程序更新后仍然存在，并且根据设备上备份的配置方式，它可能在应用程序删除和重新安装后仍然存在。

    通常这不是问题，但是如果我们更改使用的凭据，例如应用程序作者从一个 Firebase 帐户切换到另一个帐户，或者使他们的 firebase.secret 无效，则此缓存的凭据无效，但将继续使用，这将导致错误。

    此函数允许我们取消身份验证，从而丢弃缓存的凭据。下次需要身份验证时，我们将使用当前的 Firebase令牌 并获取新的凭据。

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

  默认情况下，令牌是无法访问MIT代理服务器的，如需有效令牌请参照[《App Inventor 2 使用MIT代理的组件访问令牌的获取方法》](../creative/token.html)。

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
