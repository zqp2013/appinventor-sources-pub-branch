---
title: App Inventor 2 实现导出Excel全方案总结
layout: documentation
description: App Inventor 2 实现导出Excel全方案总结，包括导出CSV格式数据、导出原生Excel，支持数据、文本、图片等，编写拓展。
---

* TOC
{:toc}

[&laquo; 返回首页](index.html)

## App Inventor 2 实现导出Excel全方案总结

### 1、导出CSV格式数据

一般情况下，需要将数据导出至Excel的话，优先考虑生成CSV格式文件，这个文件可以使用Excel软件打开，拥有基础的表格排版。

**注意：CSV仅支持文本类型的数据，而图片及特殊格式排版等无法实现。**

导出CSV的步骤参考如下：

{:.vip}
1、待导出的数据存放到列表对象中 <br/>
2、使用列表的`列表转换为CSV表`方法，将列表转成CSV格式文本 <br/>
3、使用`文件管理器`.`存储`方法，将CSV格式文本存储到相应的位置 <br/>

<!--收费数据导出拓展：https://community.kodular.io/t/paid-datatables-extension-create-custom-html-tables-and-export-to-excel-pdf-csv/172431-->

***
### 2、导出原生Excel：支持数据、文本、图片等

对于更高要求的写原生Excel，如指定特殊格式，写入图片，写入特定单元格等，可以明确的是 **App Inventor 2 不支持写原生Excel**，当然可以通过.axi拓展，使用java语音接入Excel实现。

目前没有现成的.aix拓展，需要自己去开发。

如果你需要代为开发Excel拓展，或如果你有写好的Excel拓展，均可页面右侧栏扫码添加客服进行洽谈~

> 附：Java生成Excel的几种方式：
> 
> 1. Apache POI：Apache POI是一个流行的用于处理Microsoft Office文档的Java库。它提供了一组API，可以用于创建、读取和修改Excel文件。可以使用Apache POI来创建新的Excel文件并填充数据，或者将现有的数据导出到Excel文件中。
> 
> 1. JExcelAPI：JExcelAPI是另一个用于处理Excel文件的Java库。它提供了一组简单易用的API，可以用于创建、读取和修改Excel文件。可以使用JExcelAPI来创建新的Excel文件并填充数据，或者将现有的数据导出到Excel文件中。
> 
> 1. EasyExcel：EasyExcel是阿里巴巴开源的一款基于注解的Java处理Excel的工具库。它提供了一组简单易用的API，可以用于快速创建、读取和写入Excel文件。可以使用EasyExcel来创建、读取和写入Excel文件，并且支持大量的数据量高效导入导出。
> 
> 1. Apache POI + Freemarker：结合Apache POI和Freemarker模板引擎，可以实现更加灵活的Excel导出。可以使用Freemarker创建Excel模板，然后使用Apache POI将数据填充到模板中生成最终的Excel文件。
> 
> 1. 使用第三方工具：除了上述的库之外，还有一些第三方工具可以帮助您进行Excel导出，例如：Aspose.Cells、JasperReports等。这些工具通常提供了更丰富的功能和更高级的特性，但可能需要付费或具有一定的学习曲线。
> 
> 参考：https://blog.51cto.com/AmbitionGarden/7062348
