---
layout: documentation
title: 数据科学组件
description: 数据科学组件参考文档：包括异常检测、回归、最佳拟合线。
---

* TOC
{:toc}

[&laquo; 返回首页](index.html)
# <i class="mdi mdi-function-variant"></i>  数据科学组件

目录：

1. ![icon](images/AnomalyDetection.png)  [异常检测](#AnomalyDetection)
1. ![icon](images/Regression.png)  [回归](#Regression)

## ![icon](images/AnomalyDetection.png)  异常检测  {#AnomalyDetection}

非可视组件，应用不同异常检测模型的数据科学组件。（要求AI伴侣v2.68及以上）

  该组件只需要一个数据源来应用模型。

  异常检测模型仅返回异常列表。
  
  需要 [二维图表数据](charts.html#ChartData2D) 组件来突出显示图表上的异常情况。

### 属性  {#AnomalyDetection-Properties}

{:.properties}
无


### 事件  {#AnomalyDetection-Events}

{:.events}
无


### 方法  {#AnomalyDetection-Methods}

{:.methods}

{:id="AnomalyDetection.CleanData" class="method returns list"} <i/> 清洗数据(*anomaly*{:.list},*xList*{:.list},*yList*{:.list})
: 给定单个异常：[(异常指数，异常值)]

  1. 迭代 xList 并删除异常索引处的值

  1. 迭代 yList 并删除与异常值相同的异常索引处的值

  1. 将修改后的 xList 和 yList 组合成x和y对的列表

  我们假设 x 和 y 列表大小相同并且是有序的。

{:id="AnomalyDetection.DetectAnomalies" class="method returns list"} <i/> 检测异常(*dataList*{:.list},*threshold*{:.number})
: 计算数据的平均值和标准差，然后根据阈值检查每个数据点的 Z 分数。 如果数据点的 Z 分数大于阈值，则该数据点被标记为异常。

## ![icon](images/Regression.png)  回归  {#Regression}

非可视组件，应用不同回归模型的数据科学组件。（要求AI伴侣v2.68及以上）

  该组件只需要一个数据源来应用模型。

  该组件仅负责统计计算，并为最佳拟合线提供以下属性：“斜率”、“Y截距”、“相关系数”和“预测”。
  
  要绘制最佳拟合线，请使用 [二维图表数据](charts.html#ChartData2D) 组件中的绘图块。

### 属性  {#Regression-Properties}

{:.properties}
无


### 事件  {#Regression-Events}

{:.events}
无


### 方法  {#Regression-Methods}

{:.methods}

{:id="Regression.CalculateLineOfBestFitValue" class="method returns any"} <i/> 计算最佳拟合线值(*xList*{:.list},*yList*{:.list},*value*{:.text})
: 返回最佳拟合线值之一。当指定“所有值”时，值可以是“斜率”、“截距”、“相关系数”、“预测”或字典。
