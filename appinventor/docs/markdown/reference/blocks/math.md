---
title: App Inventor 2 数学代码块
layout: documentation
description: 数学代码块参考文档，包括：基础数字块,进制数字块...
---

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
* [random integer](#randomint)
* [random fraction](#randomfrac)
* [random set seed to](#randomseed)
* [min](#min)
* [max](#max)
* [square root](#sqrt)
* [abs](#abs)
* [neg](#neg)
* [log](#log)
* [e^](#e)
* [round](#round)
* [ceiling](#ceiling)
* [floor](#floor)
* [modulo](#modulo)
* [remainder](#remainder)
* [quotient](#quotient)
* [sin](#sin)
* [cos](#cos)
* [tan](#tan)
* [asin](#asin)
* [acos](#acos)
* [atan](#atan)
* [atan2](#atan2)
* [convert radians to degrees](#convertrad)
* [convert degrees to radians](#convertdeg)
* [format as a decimal](#format)
* [is a number](#isnumber)
* [convert number](#convertnumber)
* [bitwise and](#bitwise_and)
* [bitwise or (inclusive)](#bitwise_ior)
* [bitwise or (exclusive)](#bitwise_xor)

*内置块中找不到你要查找的数学代码块？*

一些数学代码块是下拉列表，它们可以转换为不同的块。以下是每个下拉列表中包含的内容的列表：

* =, ≠, >, ≥, <, ≤

![](images/math/equals.gif)

* min, max

![](images/math/minmax.gif)

* sqrt, abs, -, log, e^, round, ceiling, floor

![](images/math/sqrt.gif)

* modulo of, remainder of, quotient of

![](images/math/modulo.gif)

* sin, cos, tan, asin, acos, atan

![](images/math/sin.gif)

* convert radians to degrees, convert degrees to radians

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
### random integer   {#randomint}

![](images/math/randomint.png)

返回给定值之间（包含首尾）的随机整数值。参数的顺序不限。

***
### random fraction   {#randomfrac}

![](images/math/randomfrac.png)

返回 0 到 1 之间的随机值。

***
### random set seed to   {#randomseed}

![](images/math/randomseed.png)

Use this block to generate repeatable sequences of random numbers. You can generate the same sequence of random numbers by first calling random set seed with the same value. This is useful for testing programs that involve random values.

***
### min   {#min}

![](images/math/min.png)

Returns the smallest value of a set of numbers. If there are unplugged sockets in the block, min will also consider 0 in its set of numbers. This block is a [mutator](../concepts/mutators.html) and a dropdown.

***
### max   {#max}

![](images/math/max.png)

Returns the largest value of a set of numbers. If there are unplugged sockets in the block, max will also consider 0 in its set of numbers. This block is a [mutator](../concepts/mutators.html) and a dropdown.

***
### square root   {#sqrt}

![](images/math/sqrt.png)

Returns the square root of the given number.

***
### abs   {#abs}

![](images/math/abs.png)

Returns the absolute value of the given number.

***
### neg   {#neg}

![](images/math/neg.png)

Returns the negative of a given number.

***
### log   {#log}

![](images/math/log.png)

Returns the natural logarithm of a given number, that is, the logarithm to the base e (2.71828...).

***
### e^   {#e}

![](images/math/e.png)

Returns e (2.71828...) raised to the power of the given number.

***
### round   {#round}

![](images/math/round.png)

Returns the given number rounded to the closest integer. If the fractional part is < .5 it will be rounded down. It it is > .5 it will be rounded up. If it is exactly equal to .5, numbers with an even whole part will be rounded down, and numbers with an odd whole part will be rounded up. (This method is called round to even.)

***
### ceiling   {#ceiling}

![](images/math/ceiling.png)

Returns the smallest integer that's greater than or equal to the given number.

***
### floor   {#floor}

![](images/math/floor.png)

Returns the greatest integer that's less than or equal to the given number.

***
### modulo   {#modulo}

![](images/math/modulo.png)

Modulo(a,b) is the same as remainder(a,b) when a and b are positive. More generally, modulo(a,b) is defined for any a and b so that (floor(a/b)× b) + modulo(a,b) = a. For example, modulo(11, 5) = 1, modulo(-11, 5) = 4, modulo(11, -5) = -4, modulo(-11, -5) = -1. Modulo(a,b) always has the same sign as b, while remainder(a,b) always has the same sign as a.

***
### remainder   {#remainder}

![](images/math/remainder.png)

Remainder(a,b) returns the result of dividing a by b and taking the remainder. The remainder is the fractional part of the result multiplied by b.

For example, remainder(11,5) = 1 because


11 / 5 = 2 <sup>1</sup>⁄<sub>5</sub>


In this case, <sup>1</sup>⁄<sub>5</sub> is the fractional part. We multiply this by b, in this case 5 and we get 1, our remainder.


Other examples are remainder(-11, 5) = -1, remainder(11, -5) = 1, and remainder(-11, -5) = -1.

***
### quotient   {#quotient}

![](images/math/quotient.png)

Returns the result of dividing the first number by the second and discarding any fractional part of the result.

***
### sin   {#sin}

![](images/math/sin.png)

Returns the sine of the given number in degrees.

***
### cos   {#cos}

![](images/math/cos.png)

Returns the cosine of the given number in degrees.

***
### tan   {#tan}

![](images/math/tan.png)

Returns the tangent of the given number in degrees.

***
### asin   {#asin}

![](images/math/asin.png)

Returns the arcsine of the given number in degrees.

***
### acos   {#acos}

![](images/math/acos.png)

Returns the arccosine of the given number in degrees.

***
### atan   {#atan}

![](images/math/atan.png)

Returns the arctangent of the given number in degrees.

***
### atan2   {#atan2}

![](images/math/atan2.png)

Returns the arctangent of y/x, given y and x.

***
### convert radians to degrees   {#convertrad}

![](images/math/convertrad.png)

Returns the value in degrees of the given number in radians. The result will be an angle in the range [0, 360)

***
### convert degrees to radians   {#convertdeg}

![](images/math/convertdeg.png)

Returns the value in radians of the given number in degrees. The result will be an angle in the range [-π , +π)

***
### format as decimal   {#format}

![](images/math/format.png)

Formats a number as a decimal with a given number of places after the decimal point. The number of places must be a non-negative integer. The result is produced by rounding the number (if there were too many places) or by adding zeros on the right (if there were too few).

***
### is a number?   {#isnumber}

![](images/math/isnumber.png)

Returns true if the given object is a number, and false otherwise.

***
### convert number   {#convertnumber}

![](images/math/convertnumber.png)

Takes a text string that represents a positive integer in one base and returns a string that represents the same number is another base. For example, if the input string is 10, then converting from base 10 to binary will produce the string 1010; while if the input string is the same 10, then converting from binary to base 10 will produce the string 2. If the input string is the same 10, then converting from base 10 to hex will produce the string A.

***
### Bitwise And   {#bitwise_and}

![](images/math/bitwise_and.png)

Takes two numbers and compares each pair of bits. Each bit of the result is 1 only if the corresponding bits of both operands are 1.

Example:

|         | Decimal | Binary (internal representation)  |
|---------|---------|---------|
|         |       6 | 0 1 1 0 |
|         |       3 | 0 0 1 1 |
| Result: |       2 | 0 0 1 0 |

***
### Bitwise Or (Inclusive)   {#bitwise_ior}

![](images/math/bitwise_ior.png)

Takes two numbers and compares each pair of bits. Each bit of the result is 1 if either of the corresponding bits in each operand is 1.

Example:

|         | Decimal | Binary (internal representation)  |
|---------|---------|---------|
|         |       6 | 0 1 1 0 |
|         |       3 | 0 0 1 1 |
| Result: |       7 | 0 1 1 1 |

***
### bitwise Or (Exclusive)   {#bitwise_xor}

![](images/math/bitwise_xor.png)

Takes two numbers and compares each pair of bits. Each bit of the result is 1 only if one corresponding bit in the operands is 1 and the other is 0.

Example:

|         | Decimal | Binary (internal representation)  |
|---------|---------|---------|
|         |       6 | 0 1 1 0 |
|         |       3 | 0 0 1 1 |
| Result: |       5 | 0 1 0 1 |

