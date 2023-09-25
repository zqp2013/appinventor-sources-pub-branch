---
title: App Inventor 2 数学代码块
layout: documentation
description: 数学代码块参考文档，包括：基础数字块,进制数字块,等于,不等于,大于,大于等于,小于,小于等于,加,减,乘,除,幂运算,随机整数,随机小数,设定随机数种子,最小值,最大值,平方根,绝对值,相反数,对数,e^,四舍五入,上取整,下取整,求模,余数,商,正弦,余弦,正切,反正弦,反余弦,反正切,反正切2,将弧度转换为度数,将度数转换为弧度,数字转变为小数形式,是否为数字,进制转换,按位与,按位或,按位异或。
---

* TOC
{:toc}

* [基础数字块 ( 0 )](#number)
* [进制数字块 ( 0 )](#number-radix)
* [等于 ( = )](#eq)
* [不等于 ( ≠ )](#ne)
* [大于 ( > )](#gt)
* [大于等于 ( ≥ )](#gte)
* [小于 ( < )](#lt)
* [小于等于 ( ≤ )](#lte)
* [加 ( + )](#add)
* [减 ( - )](#subtract)
* [乘 ( * )](#multiply)
* [除 ( / )](#divide)
* [幂运算 ( ^ )](#exponent)
* [随机整数 (random integer)](#randomint)
* [随机小数 (random fraction)](#randomfrac)
* [设定随机数种子 (random set seed to)](#randomseed)
* [最小值 (min)](#min)
* [最大值 (max)](#max)
* [平方根 (square root)](#sqrt)
* [绝对值 (abs)](#abs)
* [相反数 (neg)](#neg)
* [对数 (log)](#log)
* [e^](#e)
* [四舍五入 (round)](#round)
* [上取整 (ceiling)](#ceiling)
* [下取整 (floor)](#floor)
* [求模 (modulo)](#modulo)
* [余数 (remainder)](#remainder)
* [商 (quotient)](#quotient)
* [正弦 (sin)](#sin)
* [余弦 (cos)](#cos)
* [正切 (tan)](#tan)
* [反正弦 (asin)](#asin)
* [反余弦 (acos)](#acos)
* [反正切 (atan)](#atan)
* [反正切2 (atan2)](#atan2)
* [将弧度转换为度数 (convert radians to degrees)](#convertrad)
* [将度数转换为弧度 (convert degrees to radians)](#convertdeg)
* [数字转变为小数形式 (format as a decimal)](#format)
* [是否为数字 (is a number)](#isnumber)
* [进制转换 (convert number)](#convertnumber)
* [按位与 (bitwise and)](#bitwise_and)
* [按位或 (bitwise or Inclusive)](#bitwise_ior)
* [按位异或 (bitwise or Exclusive)](#bitwise_xor)
* [列表中出现次数最多的元素 (mode)](#mode)

*内置块中找不到你要查找的数学代码块？*

一些数学代码块是下拉列表，它们可以转换为不同的块。以下是每个下拉列表中包含的内容的列表：

* [等于 ( = )](#eq), [不等于 ( ≠ )](#ne), [大于 ( > )](#gt), [大于等于 ( ≥ )](#gte), [小于 ( < )](#lt), [小于等于 ( ≤ )](#lte)

![](images/math/equals.gif)

* [最小值 (min)](#min), [最大值 (max)](#max)

![](images/math/minmax.gif)

* [平方根 (square)](#sqrt), [绝对值 (abs)](#abs), [相反数 (neg)](#neg), [对数 (log)](#log), [e^](#e), [四舍五入 (round)](#round), [上取整 (ceiling)](#ceiling), [下取整 (floor)](#floor)

![](images/math/sqrt.gif)

* [求模 (modulo)](#modulo), [余数 (remainder)](#remainder), [商 (quotient)](#quotient)

![](images/math/modulo.gif)

* [正弦 (sin)](#sin), [余弦 (cos)](#cos), [正切 (tan)](#tan), [反正弦 (asin)](#asin), [反余弦 (acos)](#acos), [反正切 (atan)](#atan)

![](images/math/sin.gif)

* [将弧度转换为度数 (convert radians to degrees)](#convertrad), [将度数转换为弧度 (convert degrees to radians)](#convertdeg)

![](images/math/convert.gif)

***
### 基础数字块 ( 0 )   {#number}

![](images/math/number.png)

可用作任何正数或负数，单击该块中的“0”将允许更改数字。

该块支持普通的 10 进制（例如：2、12 和 2.12），以及带前缀的其他机制数字，包括：
* Base-2（`二进制`）数字，例如 `0b`10（等于十进制 2）
* Base-8（`八进制`）数字，例如 `0o`14（等于十进制 12）
* Base-16（`十六进制`）数字，例如 `0x`d4（等于十进制 212）

***
### 进制数字块 ( 0 ) {#number-radix}

![](images/math/numberradix.png)

默认表示 10 进制的数字，单击“0”将允许更改数字。点击下拉菜单可以切换 `二进制`、`八进制`、`十进制`、`十六进制` 数字。

例如，这三个块是等效的：

![](images/math/numberradix_equivalent.png)

下拉列表支持：十进制 (base-10)、二进制 (base-2)、八进制 (base-8) 和十六进制 (base-16) 输入格式。

十进制模式允许输入任何正数或负数（例如 2、-12、2.12）。其他模式仅允许您输入整数（也称为任何正数或零）。

***
### 等于 ( = )   {#eq}

![](images/math/equal.png)

测试两个数字是否相等并返回 `真` 或 `假`。

***
### 不等于 ( ≠ )   {#ne}

![](images/math/notequal.png)

测试两个数字是否不相等并返回 `真` 或 `假`。

***
### 大于 ( > )   {#gt}

![](images/math/greater.png)

测试第一个数字是否大于第二个数字并返回 `真` 或 `假`。

***
### 大于等于 ( ≥ )   {#gte}

![](images/math/greaterequal.png)

测试第一个数字是否大于或等于第二个数字并返回 `真` 或 `假`。

***
### 小于 ( < )   {#lt}

![](images/math/less.png)

测试第一个数字是否小于第二个数字并返回 `真` 或 `假`。

***
### 小于等于 ( ≤ )   {#lte}

![](images/math/lessequal.png)

测试第一个数字是否小于或等于第二个数字并返回 `真` 或 `假`。

***
### 加 ( + )   {#add}

![](images/math/plus.png)

返回将任意数量的具有数字值的块相加的结果。带有数字值的块包括基本数字块、列表或文本的长度、带有数字值的变量等。

该块是一个[块拓展](../concepts/mutators.html)，可以扩展以允许更多数字相加。

![](images/math/plus.gif)

***
### 减 ( - )   {#subtract}

![](images/math/minus.png)

返回第一个数字减去第二个数字的结果。

***
### 乘 ( * )   {#multiply}

![](images/math/multiply.png)

返回任意数量的具有数字值的块相乘的结果。

它是一个 [块拓展](../concepts/mutators.html) 块，可以扩展以允许更多数字相乘。

![](images/math/multiply.gif)

***
### 除 ( / )   {#divide}

![](images/math/divide.png)

返回第一个数字除以第二个数字的结果。

***
### 幂运算 ( ^ )   {#exponent}

![](images/math/exponent.png)

返回第一个数字的第二个数字次幂的结果。比如2^3 = 2*2*2 = 8

***
### 随机整数 (random integer)   {#randomint}

![](images/math/randomint.png)

返回给定值之间（包含首尾）的随机整数值。参数的顺序不限，也就是 1~100 和 100~1 效果一样。

***
### 随机小数 (random fraction)   {#randomfrac}

![](images/math/randomfrac.png)

返回 0 到 1 之间的随机值。

***
### 设定随机数种子 (random set seed to)   {#randomseed}

![](images/math/randomseed.png)

使用此块生成可重复的随机数序列。你可以通过使用相同值调用随机集种子来生成相同的随机数序列，这对于测试涉及随机值的程序很有用。

> 在科学技术和机器学习等其他算法相关任务中，我们经常需要用到随机数，为了把握随机数的生成特性，从随机数的随机无序中获得确定和秩序。我们可以利用 `随机数种子(random seed)` 来实现这一目标，随机数种子可以使得引入了随机数的整个程序，在多次运行中得到确定的、一致的结果。

***
### 最小值 (min)   {#min}

![](images/math/min.png)

返回一组数字的最小值。如果代码块中有未插入的槽，会被当做数字 0 进行计算。该块是一个 [块拓展](../concepts/mutators.html) ，有一个下拉列表。

***
### 最大值 (max)   {#max}

![](images/math/max.png)

返回一组数字的最大值。如果代码块中有未插入的槽，会被当做数字 0 进行计算。该块是一个 [块拓展](../concepts/mutators.html) ，有一个下拉列表。

***
### 平方根 (square root)   {#sqrt}

![](images/math/sqrt.png)

返回给定数字的平方根。如：9 的平方根将返回 3。

***
### 绝对值 (abs)   {#abs}

![](images/math/abs.png)

返回给定数字的绝对值。如：-3.3 的绝对值是 3.3，5 的绝对值是 5，0 的绝对值是 0。

***
### 相反数 (neg)   {#neg}

![](images/math/neg.png)

返回给定数字的负数，若给定负数则返回正数。如：8 返回 -8，-0.7 返回 0.7，0 则仍然返回 0。

***
### 对数 (log)   {#log}

![](images/math/log.png)

返回给定数字的自然对数，即以 e (2.71828...) 为底的对数。

***
### e^   {#e}

![](images/math/e.png)

返回 e (2.71828...) 的给定数次方。

***
### 四舍五入 (round)   {#round}

![](images/math/round.png)

返回给定数字四舍五入到最接近的整数。如果小数部分 < .5，则会向下舍入；如果 > .5，则会向上舍入。

如果它恰好等于 0.5，则整数部分为偶数的数字将向下舍入，整数部分为奇数的数字将向上舍入（此方法称为舍入到偶数）。

***
### 上取整 (ceiling)   {#ceiling}

![](images/math/ceiling.png)

返回大于或等于给定数字的最小整数。如：3.01 返回 4。

***
### 下取整 (floor)   {#floor}

![](images/math/floor.png)

返回小于或等于给定数字的最大整数。如：3.88 返回 3。

***
### 求模 (modulo)   {#modulo}

![](images/math/modulo.png)

当 a 和 b 为正数时，求模(a,b) 与 余数(a,b) 相同。

更一般地，对任意 a 和 b 定义：求模(a,b)，使得 ( 下取整(a/b) × b ) + 求模(a,b) = a。

例如，求模(11, 5) = 1、求模(-11, 5) = 4、求模(11, -5) = -4、求模(-11, -5) = -1。

求模(a,b) 始终与 b 具有相同的符号，而 余数(a,b) 始终与 a 具有相同的符号。

***
### 余数 (remainder)   {#remainder}

![](images/math/remainder.png)

余数(a,b) 返回 a 除以 b 并取余数的结果。余数是结果乘以 b 的小数部分。

例如，余数(11,5) = 1，因为11 / 5 = 2 <sup>1</sup>⁄<sub>5</sub>，在本例中，<sup>1</sup>⁄<sub>5</sub> 是小数部分。我们将其乘以 b（在本例中为 5），得到余数 1。

其他示例包括余数(-11, 5) = -1、余数(11, -5) = 1 和余数(-11, -5) = -1。

***
### 商 (quotient)   {#quotient}

![](images/math/quotient.png)

返回第一个数字除以第二个数字的结果并丢弃结果全部的小数部分。

***
### 正弦 (sin)   {#sin}

![](images/math/sin.png)

返回给定数字的正弦值（以度为单位）。

***
### 余弦 (cos)   {#cos}

![](images/math/cos.png)

返回给定数字的余弦（以度为单位）。

***
### 正切 (tan)   {#tan}

![](images/math/tan.png)

返回给定数字的正切值（以度为单位）。

***
### 反正弦 (asin)   {#asin}

![](images/math/asin.png)

返回给定数字的反正弦值（以度为单位）。

***
### 反余弦 (acos)   {#acos}

![](images/math/acos.png)

返回给定数字的反余弦值（以度为单位）。

***
### 反正切 (atan)   {#atan}

![](images/math/atan.png)

返回给定数字的反正切值（以度为单位）。

***
### 反正切2 (atan2)   {#atan2}

![](images/math/atan2.png)

给定 y 和 x，返回 y/x 的反正切值。

***
### 将弧度转换为度数 (convert radians to degrees)   {#convertrad}

![](images/math/convertrad.png)

返回给定数字（以弧度表示）的度数值。结果将是 [0, 360) 范围内的角度。

***
### 将度数转换为弧度 (convert degrees to radians)   {#convertdeg}

![](images/math/convertdeg.png)

返回给定数字（以度为单位）的弧度值。结果将是 [-π , +π) 范围内的角度。

***
### 数字转变为小数形式 (format as a decimal)   {#format}

![](images/math/format.png)

将数字格式化为小数，小数点后指定位数。位数必须是非负整数，如果位置太多结果是通过对数字进行四舍五入生成的；如果位置太少，则右侧补零。

***
### 是否为数字 (is a number)   {#isnumber}

![](images/math/isnumber.png)

如果给定对象是数字，则返回 `真`，否则返回 `假`。

***
### 进制转换 (convert number)   {#convertnumber}

![](images/math/convertnumber.png)

获取一个表示一个基数的正整数的文本字符串，并返回一个表示另一个基数的相同数字的字符串。

例如，如果输入字符串为 10，则从 10 进制转换为二进制将产生字符串 1010； 如果输入字符串相同为 10，则从二进制转换为基数 10 将生成字符串 2。如果输入字符串相同为 10，则从基数 10 转换为十六进制将生成字符串 A。

***
### 按位与 (bitwise and)   {#bitwise_and}

![](images/math/bitwise_and.png)

对两个数字每一位进行 `与操作`。仅当两个操作数的相应位都为 1 时，结果的每一位才为 1。

例子：

|         | 十进制   | 二进制 (内部展示)  |
|---------|---------|---------|
|         |       6 | 0 1 1 0 |
|         |       3 | 0 0 1 1 |
| 结果:   |       2 | 0 0 1 0 |

***
### 按位或 (bitwise or Inclusive)   {#bitwise_ior}

![](images/math/bitwise_ior.png)

对两个数字每一位进行 `或操作`。如果每个操作数中的任一对应位为 1，则结果的每个位为 1。

例子：

|         | 十进制  | 二进制 (内部展示)  |
|---------|---------|---------|
|         |       6 | 0 1 1 0 |
|         |       3 | 0 0 1 1 |
| 结果:   |       7 | 0 1 1 1 |

***
### 按位异或 (bitwise or Exclusive)   {#bitwise_xor}

![](images/math/bitwise_xor.png)

对两个数字每一位进行 `异或操作`。仅当操作数中对应的一位为 1、另一位为 0 时，结果的每一位才为 1。

例子：

|         | 十进制  | 二进制 (内部展示)  |
|---------|---------|---------|
|         |       6 | 0 1 1 0 |
|         |       3 | 0 0 1 1 |
| 结果:   |       5 | 0 1 0 1 |

***
### 列表中出现次数最多的元素 (mode)   {#mode}

![](images/math/mode.png)

返回列表中出现次数最多的元素。
