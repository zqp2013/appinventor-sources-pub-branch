---
title: App Inventor 2 从.aia项目文件中提取.aix拓展包
layout: documentation
description: 详解如何从.aia项目文件中提取.aix拓展包文件。
---

[&laquo; 返回首页](index.html)

# 从.aia项目文件中提取.aix拓展包的步骤

1. 如果看到一个项目中，用到了拓展，但拓展的帮助中没有原链接，这时就可以考虑从项目文件中进行提取：

    ![拓展列表](images/extract_aix/拓展列表.png)

1. 导出项目.aia文件：

    ![导出项目](images/extract_aix/导出项目.png)

1. 在电脑的“下载”目录查看.aia项目文件：

    ![导出的aia文件](images/extract_aix/导出的aia文件.png)

1. 将.aia文件的后缀改为.zip压缩包文件：

    ![aia后缀改为zip](images/extract_aix/aia后缀改为zip.png)

1. 解压.zip文件，找到里面的拓展目录 `assets\external_comps`，可以看到所有用到的拓展目录列表：

    ![拓展目录](images/extract_aix/拓展目录.png)

1. 将需要提取的拓展目录进行.zip压缩：

    ![压缩](images/extract_aix/压缩.png)

1. 最后，将拓展的.zip包的后缀改为.aix，即为真正的拓展包文件。经验证，该.aix拓展包重新导入后，能够正常使用。

    ![zip后缀改为aix](images/extract_aix/zip后缀改为aix.png)
