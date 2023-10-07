---
title: Android存储系统基础知识：内部存储，外部存储，App特定目录 ASD(app specific directory) 及 getASD代码实现
layout: documentation
description: Android存储系统基础知识：内部存储，外部存储，App特定目录 ASD(app specific directory) 及 getASD 代码实现。
---

* TOC
{:toc}

[&laquo; 返回首页](index.html)

## Android存储系统基础知识

[英文原版链接→](https://community.kodular.io/t/some-basics-on-android-storage-system/69074)

Android存储系统概览图（图片模糊的话请在图片上右键 → 新标签页打开）：

![Android存储系统概览](images/Android存储系统概览.jpeg)


### 从 Android 的角度来看 → **内部存储**和 → **外部存储**：

1. 内部存储

    内部存储只能通过已取得 root 权限的设备进行访问。

    1. 应用程序包保存在： `/data/data/<packageName>/`

    1. 私有目录在： `/data/user/0/<packageName>/files/`

      私有目录可与文件组件一起使用来保存/读取文本（设置不带斜杠的路径），它只能由您的应用程序访问，并且在卸载应用程序时会自动删除。

1. 外部存储

    外部存储的根目录是：
    
    `/storage/emulated/0/`    or  

    `file:///mnt/sdcard/`     or  

    `file:///storage/emulated/0/`

    要访问外部存储，需要 `READ_` 或 `WRITE_EXTERNAL_STORAGE` 权限。

    1. **App特定目录 ASD**(App-specific directory)

        此外，可能还有一个特定于应用程序的目录（ASD），可以使用以下命令创建

        [Taifun 的文件扩展](https://puravidaapps.com/file.php)

        [FileTools 扩展](../components/storage.html#FileTools)

        ASD的路径是：`/storage/emulated/0/Android/data/<packageName>/files/`

        它位于外部（私有）存储中，但不需要 `READ_` 或 `WRITE_EXTERNAL_STORAGE` 权限，ASD只能由您的应用程序访问，并且在卸载应用程序时会自动删除。

    1. 外部（可移动/微型）SD 卡

        可能还有另一个外部存储：可移动（微型）SD 卡，例如：`/storage/82C3-E96C/`

        只能读取（在 Android ≥ 4.4 / KitKat、API 19 的设备上）。

        注：外部存储的根目录：`/storage/emulated/0/`，在设备上显示为内部存储（不幸的是，这有点含糊）。


### 绝对路径(Absolute path) │ 相对路径(relative path) │ 完整路径(full path)

1. 这是一个 → 绝对路径：`/storage/emulated/0/Android/data/<packageName>/files/`

1. 这是一个 → 相对路径：`/Android/data/<packageName>/files`

    有些组件需要相对路径，有些则需要绝对路径。

1. 最重要的是，某些组件或 Android 版本需要 → 完整路径：`file:///storage/emulated/0/Android/data/<packageName>/files/`

    可以使用这些术语来区分路径，例如：

    |     类型    | 路径  |
    |---------|---------|
    |     相对路径    |  `/Download` |
    |     绝对路径    |  `/storage/emulated/0/Download` |
    |     完整路径    |  `file:///storage/emulated/0/Download` |


### getASD代码实现

使用`文件管理器`组件可以实现ASD目录的获取，代码如下：

![getASD](images/getASD.png)

以上代码可快速导入项目，无需重复造轮子，请看[这里](../other/download-pngs.html)。

### ASD vs 私有目录

|         | **App特定目录 ASD**(App-specific directory)     | 私有目录  |
|---------|---------|---------|
|     存储    |     外部存储 | 内部存储 |
|     目录    |  `/storage/emulated/0/Android/data/<packageName>/files/` | `/data/user/0/<packageName>/files/` |
| 只能由应用程序访问  |      是 | 是 |
| 卸载App时自动删除  |      是 | 是 |