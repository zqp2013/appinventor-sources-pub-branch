---
title: App Inventor 2 字典代码块
layout: documentation
description: 字典代码块参考文档：包括什么情况下需要使用字典、创建空字典、创建字典、键值对、获取键的值、设置键的值、删除键的条目、获取键路径的值、设置键路径的值、获取键列表、获取值列表、键是否在字典中？、字典的长度、键值对列表转换为字典、字典转换为键值对列表、复制字典（深拷贝）、合并字典、在此层级遍历、遍历键路径列表、是否为字典？、字典遍历,遍历字典。
---

* TOC
{:toc}

目录：

* [介绍](#dictionaries)
* [创建空字典](#create-empty-dictionary)
* [创建字典](#make-a-dictionary)
* [键值对](#pair)
* [获取键的值](#get-value-for-key)
* [设置键的值](#set-value-for-key)
* [删除键的条目](#delete-entry-for-key)
* [获取键路径的值](#get-value-at-key-path)
* [设置键路径的值](#set-value-for-key-path)
* [获取键列表](#get-keys)
* [获取值列表](#get-values)
* [键是否在字典中？](#is-key-in-dictionary)
* [字典的长度](#size-of-dictionary)
* [键值对列表转换为字典](#list-of-pairs-to-dictionary)
* [字典转换为键值对列表](#dictionary-to-list-of-pairs)
* [复制字典（深拷贝）](#copy-dictionary)
* [合并字典](#merge-into-dictionary)
* [在此层级遍历](#walk-all-at-level)
* [遍历键路径列表](#list-by-walking-key-path)
* [是否为字典？](#is-a-dictionary)

***
拓展案例：

1. [*案例：***字典遍历**](#foreachdict)


### 介绍   {#dictionaries}

字典在其他语言中称为映射、关联数组或列表，是一种将一个值（通常称为键）与另一个值关联的数据结构。

**Q：App Inventor 2 什么情况下需要使用字典？**

**A：**列表能完成字典的绝大部分功能，不过字典具有**比列表更好的查找性能**，因此如果要对数据结构执行大量的操作，建议优先使用字典。

显示字典的常见方法是使用 JavaScript 对象表示法 (JSON)，例如：

```json
{
  "id":  1,
  "name":  "Tim the Beaver",
  "school": {
    "name": "Massachusetts Institute of Technology"
  },
  "enrolled": true,
  "classes": ["6.001", "18.01", "8.01"]
}
```

上面的示例显示，在 JSON 中，键（在 `:` 之前引用的文本）可以映射到不同类型的值。

允许的类型包括数字、文本、其他字典、布尔值和列表。在块语言中，可以按如下方式构建该字典：

![字典的块表示](images/dictionaries/example-dictionary-blocks.png)

**图 1**：上面显示的 JSON 代码片段的块表示

***
### 创建空字典   {#create-empty-dictionary}

![](images/dictionaries/create-with.png)

`创建空字典` 块创建一个没有任何键值对的字典。

可以使用 [设置键的值](#set-value-for-key) 块将条目添加到空字典中。

通过使用蓝色块拓展![块扩展图标](../concepts/images/mutatoricon.png)按钮添加`键值对`{:.dictionary.block}。

`创建空字典` 块也可以作为 `创建字典` 块的条目。

***
### 创建字典   {#make-a-dictionary}

![](images/dictionaries/make-a-dictionary.png)

用于创建一个预先带有一组已知 `键值对`{:.dictionary.block} 的字典，可以使用 [设置键的值](#set-value-for-key) 添加其他条目。

***
### 键值对   {#pair}

![](images/dictionaries/pair.png)

`键值对` 块是用于构造字典项的特殊块。

***
### 获取键的值   {#get-value-for-key}

![](images/dictionaries/get-value-for-key2.png)

`获取键的值` 块检查字典是否包含给定键的对应值，如果是，则返回该值；否则，返回“未找到”参数的值。

此代码块的行为类似于[`列表`](lists.html)的 [`在键值对中查找`{:.list.block}](lists.html#lookupinpairs) 。

***
### 设置键的值   {#set-value-for-key}

![](images/dictionaries/set-value-for-key.png)

将 `字典` 中给定 `键` 的对应值设置为 `值`。

**如果`键`不存在映射，则会创建一个新映射；否则，现有值将被新值替换。**

***
### 删除键的条目   {#delete-entry-for-key}

![](images/dictionaries/delete-value-for-key.png)

`删除键的条目` 块删除字典中给定键的键值映射。如果字典中不存在该键的条目，则不会修改字典。

***
### 获取键路径的值   {#get-value-at-key-path}

`获取键路径的值` 块是 `获取键的值` 块的`更高级版本`，它不是获取特定键的值，而是逐层遍历路径，逐层深入数据结构获取值。

`获取键的值` 块等同于`获取键路径的值` 块路径长度为 1。

例如，以下两个块将返回 `"Tim the Beaver"`{:.text.block}：

![](images/dictionaries/get-value-for-key.png) ![](images/dictionaries/get-value-for-key-path.png)

它从初始字典开始，使用提供的“路径”遍历数据结构，以便检索深度嵌套在复杂数据结构中的值。

它最适合处理来自 Web 服务的 JSON 数据，从初始输入开始，它获取“键路径”中的第一个元素，并检查该点是否存在键（如果输入是字典）或索引（如果输入是列表），如果是，它选择该项目作为输入，并继续检查“关键路径”中的下一个元素，继续检查整个路径，此时它返回该位置的内容，或者“未找到”参数的值。

**不明白？看例子最直观！**

{:.vip}
```json
{
  "id":  1,
  "name":  "Tim the Beaver",
  "school": {
    "name": "Massachusetts Institute of Technology"
  },
  "enrolled": true,
  "classes": ["6.001", "18.01", "8.01"]
}
```

例如，给定上面的 JSON 字典，以下使用 `获取键路径的值` 将产生结果 `"Massachusetts Institute of Technology"`{:.text.block}。

![](images/dictionaries/get-value-for-key-path2.png)

`获取键路径的值` 允许路径包含表示混合字典和列表时要遍历的元素索引的数字。

例如，如果我们想知道 Tim 正在上的第二堂课，我们可以执行以下操作：

![](images/dictionaries/get-value-for-key-path-with-index.png)

这将返回值：`"18.01"`

***
### 设置键路径的值   {#set-value-for-key-path}

![](images/dictionaries/set-value-for-key-path.png)

`设置键路径的值` 块更新数据结构中特定 `键路径` 处的值。

它是 [获取键路径的值](#set-value-at-key-path) 的镜像，它检索特定 `键路径` 处的值。路径**必须有效**，最后一个键除外，如果映射不存在，则将创建到新值的映射。否则，现有值将替换为新值。

***
### 获取键列表   {#get-keys}

![](images/dictionaries/get-keys.png)

返回字典中的键列表，是一个`列表`{:.list.block}对象。

***
### 获取值列表   {#get-values}

![](images/dictionaries/get-values.png)

返回一个包含字典中的值的列表，是一个`列表`{:.list.block}对象。

**修改值列表中值的内容也会修改字典中的值。**

***
### 键是否在字典中？   {#is-key-in-dictionary}

![](images/dictionaries/is-key-in.png)

`键是否在字典中？` 测试字典中是否存在该键，如果存在则返回 `真`{:.logic.block}，否则返回 `假`{:.logic.block}。

***
### 字典的长度   {#size-of-dictionary}

![](images/dictionaries/size.png)

`字典的长度` 块返回字典中存在的键值对的数量。

***
### 键值对列表转换为字典   {#list-of-pairs-to-dictionary}

![](images/dictionaries/alist-to-dict.png)

将`((key1 value1) (key2 value2) ...)`形式的键值对列表转换为键映射到其值的字典。

由于字典具有比键值对列表更好的查找性能，因此如果要对数据结构执行大量的操作，建议首先使用此块将键值对列表转换为字典。

***
### 字典转换为键值对列表   {#dictionary-to-list-of-pairs}

![](images/dictionaries/dict-to-alist.png)

将字典转换为键值对列表。此块执行 [键值对列表转换为字典](#list-of-pairs-to-dictionary) 相反的操作。

![Example of how the dictionary to list of pairs block reverses the list of pairs to dictionary block](images/dictionaries/alist-dict-reversability.png)

***
### 复制字典（深拷贝）   {#copy-dictionary}

![](images/dictionaries/copy-dict.png)

`复制字典` 制作给定字典的深层副本（深拷贝），也即是所有值都会递归复制，并且更改副本中的值不会更改原始值。

***
### 合并字典   {#merge-into-dictionary}

![](images/dictionaries/combine-dicts.png)

该块将键值对从一个字典复制到另一个字典中，覆盖目标字典中的任何键。

***
### 在此层级遍历   {#walk-all-at-level}

![](images/dictionaries/walk-all.png)

该块是一个专用块，可以在 `遍历键路径列表` 的键路径中使用。

当在遍历中遇到时，它会导致该级别的每个项目都被探索。对于字典来说，这意味着每个值都会被访问；对于列表，将访问列表中的每个项目。

这可用于聚合字典中的项目列表项数据，例如数据库中由 JSON 对象表示的每个人的名字。有关示例，请参阅 [`遍历键路径列表`](#list-by-walking-key-path) 块。

***
### 遍历键路径列表   {#list-by-walking-key-path}

![](images/dictionaries/walk-tree.png)

`遍历键路径列表` 块的工作方式与 [获取键路径的值](#get-value-at-key-path) 类似，但会创建一个值列表，而不是返回单个值。

它的工作原理是从给定的字典开始，沿着给定的路径沿着对象树走下去。但与 [获取键路径的值](#get-value-at-key-path) 不同，它的路径可以由三种主要类型组成：`字典键`、`列表索引` 和 [`在此层级遍历`](#walk-all-at-level) 块。

如果提供了键或索引，则在树中的该点采用特定路径。如果指定了 [`在此层级遍历`](#walk-all-at-level)，则将连续跟踪该点的每个值（广度优先），此时从路径中的下一个元素继续遍历。与整个路径匹配的任何元素都会添加到输出列表中。

**例子**

参考以下 JSON 和块：

```json
{
  "people": [{
    "first_name": "Tim",
    "last_name": "Beaver"
  },{
    "first_name": "John",
    "last_name": "Smith",
  },{
    "first_name": "Jane",
    "last_name": "Doe"
  }]
}
```

![](images/dictionaries/walk-tree-example.png)

如果 `global data`{:.variable.block} 包含由 JSON 表示的字典，则 `遍历键路径列表` 块将生成列表 `["Tim", "Beaver" ]`{:.list.block}。

首先，选择`“people”`{:.text.block} 标记的值，即人员列表。接下来，选择列表中的第一个元素。

最后，`在此层级遍历` 块选择该点对象中的值，即值 `"Tim"`{:.text.block} 和 `"Beaver"`{:.text.block}。

还可以在包含列表的层级中使用 `在此层级遍历`。例如，以下块选择结构中所有人员的名字，即 `["Tim", "John", "Jane"]`{:.list.block}。

![](images/dictionaries/walk-tree-example2.png)

此块还可以与使用 [`Web.XMLTextDecodeAsDictionary`{:.method.block}](/reference/components/connectivity.html#Web.XMLTextDecodeAsDictionary) 块解析的 XML 一起使用。

参考以下 XML 文档：

```xml
<schedule>
  <day>
    <room name="Hewlitt" />
    <room name="Bleil" />
  </day>
  <day>
    <room name="Kiva" />
    <room name="Star" />
  </day>
</schedule>
```

可以使用以下块来获取第一天的房间名称列表，即`["Hewlitt", "Bleil"]`{:.list.block}。

![](images/dictionaries/walk-tree-xml.png)

***
### 是否为字典？   {#is-a-dictionary}

![](images/dictionaries/is-dict.png)

该块测试给它的 `对象` 是否是一个字典。如果`对象`是字典，它将返回`真`{:.logic.block}，否则返回`假`{:.logic.block}。


***
### 案例：字典遍历  {#foreachdict}

  字典代码块中没有提供遍历的方法，遍历方法在[控制代码块 > 从字典循环](control.html#foreach)中，参考代码如下：

  ![遍历字典_从字典循环](images/control/foreachdict.png)
