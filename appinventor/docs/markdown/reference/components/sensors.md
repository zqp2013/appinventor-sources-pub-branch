---
layout: documentation
title: 传感器组件
description: 传感器组件参考文档：包括加速度传感器、条码扫描器、气压传感器、计时器、陀螺仪传感器、湿度传感器、光线传感器、位置传感器、磁场传感器、NFC、方向传感器、计步器、距离传感器、温度传感器。
---

* TOC
{:toc}

[&laquo; 返回首页](index.html)
# <i class="mdi mdi-memory"></i>  传感器组件

目录：

1. ![icon](images/accelerometersensor.png)  [加速度传感器](#AccelerometerSensor)
1. ![icon](images/barcodescanner.png)  [条码扫描器](#BarcodeScanner)
1. ![icon](images/barometer.png)  [气压传感器](#Barometer)
1. ![icon](images/clock.png)  [计时器](#Clock)
1. ![icon](images/gyroscopesensor.png)  [陀螺仪传感器](#GyroscopeSensor)
1. ![icon](images/hygrometer.png)  [湿度传感器](#Hygrometer)
1. ![icon](images/lightsensor.png)  [光线传感器](#LightSensor)
1. ![icon](images/locationsensor.png)  [位置传感器](#LocationSensor)
1. ![icon](images/magneticfieldsensor.png)  [磁场传感器](#MagneticFieldSensor)
1. ![icon](images/nearfield.png)  [NFC](#NearField)
1. ![icon](images/orientationsensor.png)  [方向传感器](#OrientationSensor)
1. ![icon](images/pedometer.png)  [计步器](#Pedometer)
1. ![icon](images/proximitysensor.png)  [距离传感器](#ProximitySensor)
1. ![icon](images/thermometer.png)  [温度传感器](#Thermometer)


## ![icon](images/accelerometersensor.png)  加速度传感器  {#AccelerometerSensor}

不可见组件，可检测振动并使用 SI 单位(m/s<sup>2</sup>)在三个维度上近似测量加速度。其组成部分是：

  - **X分量**：当手机静止在平坦表面上时为 0，当手机倾斜时为正向右（即左侧抬起），当手机倾斜到右侧时为负向左（即，其右侧尺寸升高）。

  - **Y分量**：当手机静止在平坦表面上时为0，当底部抬起时为正，当其顶部升起时为负。

  - **Z分量**：等于 -9.8（当设备处于每秒状态时，地球重力以米每秒为单位）
    
    静止时与地面平行且显示屏朝上，0 时垂直于地面，面朝下时+9.8。 该值也可能受到加速或反对的影响重力。


### 属性  {#AccelerometerSensor-Properties}

{:.properties}

{:id="AccelerometerSensor.Available" .boolean .ro .bo} *可用状态*
: 返回`加速度传感器`硬件在设备上是否可用。

{:id="AccelerometerSensor.Enabled" .boolean} *启用*
: 指定传感器是否触发事件。如果`真`{:.logic.block}，传感器将触发事件；否则，即使设备加速或晃动，也不会触发任何事件。

{:id="AccelerometerSensor.LegacyMode" .boolean .wo .do} *兼容模式*
: 在添加此属性的版本之前，`加速度传感器` 组件直接传递从 Android 系统接收到的传感器值。然而，这些值无法补偿默认为横向模式的平板电脑，需要 MIT App Inventor 程序员进行补偿。但是，在手机等纵向模式设备中进行补偿会导致结果不正确。

  我们现在检测横向模式平板电脑并执行补偿。但是，如果你的项目已经补偿了，将会得到不正确的结果。
  
  虽然我们的首选解决方案是让你更新项目，但你也可以将此属性设置为`真`，我们的补偿代码将被停用。
  
  注意：我们建议你更新你的项目，因为我们可能会在将来的版本中删除此属性。

  **中文网注：新建的项目不用关注此属性，无视它就行。**

{:id="AccelerometerSensor.MinimumInterval" .number} *最小间隔（毫秒）*
: 指定连续的 [`被晃动`](#AccelerometerSensor.Shaking) 事件之间所需的最小间隔（以毫秒为单位）。

  一旦手机开始晃动，所有进一步的 [`被晃动`](#AccelerometerSensor.Shaking) 事件都将被忽略，直到间隔结束。

{:id="AccelerometerSensor.Sensitivity" .number} *敏感度*
: 指定`加速度传感器`的灵敏度。

  |有效值|含义|
  |--|--|
  |1|弱|
  |2|中等|
  |3|强|

{:id="AccelerometerSensor.XAccel" .number .ro .bo} *X分量*
: 返回 X 维度的加速度，以 SI 单位 (m/s²) 表示。

  必须启用传感器才能返回有意义的值。

{:id="AccelerometerSensor.YAccel" .number .ro .bo} *Y分量*
: 返回 Y 维度的加速度，以 SI 单位 (m/s²) 表示。
  
  必须启用传感器才能返回有意义的值。

{:id="AccelerometerSensor.ZAccel" .number .ro .bo} *Z分量*
: 返回 Z 维度的加速度，以 SI 单位 (m/s²) 表示。
  
  必须启用传感器才能返回有意义的值。

### 事件  {#AccelerometerSensor-Events}

{:.events}

{:id="AccelerometerSensor.AccelerationChanged"} 加速度变化时(*X分量*{:.number},*Y分量*{:.number},*Z分量*{:.number})
: 指示 X、Y 和/或 Z 维度上的加速度变化。

{:id="AccelerometerSensor.Shaking"} 被晃动时()
: 表示设备开始晃动或持续晃动。

### 方法  {#AccelerometerSensor-Methods}

{:.methods}
无


## ![icon](images/barcodescanner.png)  条码扫描器  {#BarcodeScanner}

用于扫描 QR 码并返回结果字符串的组件。

### 属性  {#BarcodeScanner-Properties}

{:.properties}

{:id="BarcodeScanner.Result" .text .ro .bo} *结果*
: 获取上次扫描的文本结果。

{:id="BarcodeScanner.UseExternalScanner" .boolean} *使用外部扫描仪*
: 设置是否要使用外部扫描程序，例如扫码机。 如果为 `假`，则将会使用已集成到 App Inventor 中的 ZXing 的某个版本（注：ZXing是一个开源Java类库用于解析多种格式的1D/2D条形码）。

### 事件  {#BarcodeScanner-Events}

{:.events}

{:id="BarcodeScanner.AfterScan"} 扫描结束(*返回结果*{:.text})
: 表示扫描仪已读取（文本）结果并提供结果。

### 方法  {#BarcodeScanner-Methods}

{:.methods}

{:id="BarcodeScanner.DoScan" class="method"} <i/> 执行扫描()
: 使用相机开始扫描条形码。扫描完成后，将触发 [扫描结束](#BarcodeScanner.AfterScan) 事件。


## ![icon](images/barometer.png)  气压传感器  {#Barometer}

如果硬件支持，可以测量环境气压的物理世界组件。

### 属性  {#Barometer-Properties}

{:.properties}

{:id="Barometer.AirPressure" .number .ro .bo} *气压*
: 如果传感器可用并已启用，则返回以 hPa（毫巴）为单位的大气压力。

{:id="Barometer.Available" .boolean .ro .bo} *可用状态*
: 指定设备是否具有支持`气压传感器`组件的硬件。

{:id="Barometer.Enabled" .boolean} *启用*
: 指定传感器是否触发事件。 如果为`真`{:.logic.block}，传感器将触发事件；否则，不会触发任何事件。

{:id="Barometer.RefreshTime" .number} *刷新时间*
: 所请求的读数变化之间的最短时间（以毫秒为单位）。

### 事件  {#Barometer-Events}

{:.events}

{:id="Barometer.AirPressureChanged"} 气压改变时(*气压值*{:.number})
: 当检测到气压（以 hPa 为单位）发生变化时触发该事件。

### 方法  {#Barometer-Methods}

{:.methods}
无


## ![icon](images/clock.png) 计时器&nbsp;&nbsp;[<i class="mdi mdi-cursor-default-click-outline"></i>示例](guide/Clock.html)    {#Clock}

不可见组件，使用手机内部时钟提供实时时间。可以设置时间间隔以定期触发计时器，并执行时间计算、操作、和转换。

对日期和时间的操作，比如来自[`日期选择器`](userinterface.html#DatePicker)和[`时间选择器`](userinterface.html#TimePicker)，
通过计时器的方法实现。日期和时间表示为“即时时间” 和“持续时间”。

  - **即时时间**: 由 年、月、日、时、分、秒 组成。 即时时间可以使用 [`由文本建时间点`](#Clock.MakeInstant)、[`由毫秒建时间点`](#Clock.MakeInstantFromMillis)和
  [`由元件建时间点`](#Clock.MakeInstantFromParts)方法。
  - **持续时间**: 即时时间经过的时间（以毫秒为单位），持续时间可以通过[`持续时间`](#Clock.Duration) 方法获得。

即时时间假定在设备的本地时区，当它们被创建就表示它是从1970年1月1日（UTC格林威治标准时间）开始到现在的毫秒数。

通过调用方法可以将即时时间转换为文本，格式可以是空字符串、`MM/dd/YYYY HH:mm:ss a` 或 `MMM d, yyyy HH:mm`。空字符串将提供默认格式，对于 [`格式化日期时间`](#Clock.FormatDateTime)是
`"MMM d, yyyy HH:mm:ss a"`，[`格式化日期`](#Clock.FormatDate)是`"MMM d, yyyy"`。要查看所有可能的格式，
请请参阅[此处](https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html)。

关于合并日期和时间的注意项：为了合并来自另一个即时时间的日期和时间，例如来自[`日期选择器`](userinterface.html#DatePicker)和
[`时间选择器`](userinterface.html#TimePicker)，将部分提取为文本，并使用文本来创建一个新的即时时间。例如：

 ![Example code blocks to combine date and time picker data](images/date_and_time_instant.png)



### 属性  {#Clock-Properties}

{:.properties}

{:id="Clock.TimerAlwaysFires" .boolean} *一直计时*
: 如果为 `真`，即使App未显示在屏幕上也会触发计时。

{:id="Clock.TimerEnabled" .boolean} *启用计时*
: 指定是否运行计时器，触发 [`计时`](#Clock.Timer) 事件。

{:id="Clock.TimerInterval" .number} *计时间隔（毫秒）*
: 指定后续 [`计时`](#Clock.Timer) 事件之间的间隔毫秒数。

   **注意：**随着时间的推移可能会发生漂移，如果手机上的应用程序或其他进程**繁忙**，此处指定的时间间隔**系统可能会不遵守**。

### 事件  {#Clock-Events}

{:.events}

{:id="Clock.Timer"} 计时()
: 计时事件开始运行，直至关闭为止。

### 方法  {#Clock-Methods}

{:.methods}

{:id="Clock.AddDays" class="method returns InstantInTime"} <i/> 增加日(*时刻*{:.InstantInTime},*数量*{:.number})
: 返回给定时刻几天后的某个时刻。

{:id="Clock.AddDuration" class="method returns InstantInTime"} <i/> 增加时段(*时刻*{:.InstantInTime},*数量*{:.number})
: 返回参数指定的一段时间后的时刻。

{:id="Clock.AddHours" class="method returns InstantInTime"} <i/> 增加时(*时刻*{:.InstantInTime},*数量*{:.number})
: 返回给定时刻几小时后的时刻。

{:id="Clock.AddMinutes" class="method returns InstantInTime"} <i/> 增加分(*时刻*{:.InstantInTime},*数量*{:.number})
: 返回给定时刻几分钟后的时刻。

{:id="Clock.AddMonths" class="method returns InstantInTime"} <i/> 增加月(*时刻*{:.InstantInTime},*数量*{:.number})
: 返回给定时刻几个月后的时刻。

{:id="Clock.AddSeconds" class="method returns InstantInTime"} <i/> 增加秒(*时刻*{:.InstantInTime},*数量*{:.number})
: 返回给定时刻几秒后的时刻。

{:id="Clock.AddWeeks" class="method returns InstantInTime"} <i/> 增加周(*时刻*{:.InstantInTime},*数量*{:.number})
: 返回给定时刻几周后的时刻。

{:id="Clock.AddYears" class="method returns InstantInTime"} <i/> 增加年(*时刻*{:.InstantInTime},*数量*{:.number})
: 返回给定时刻几年后的时刻。

{:id="Clock.DayOfMonth" class="method returns number"} <i/> 求日期(*时刻*{:.InstantInTime})
: 返回该月的第几天。

{:id="Clock.Duration" class="method returns number"} <i/> 持续时间(*开始时刻*{:.InstantInTime},*结束时刻*{:.InstantInTime})
: 返回结束与开始之间的毫秒数（正数 或 负数）。

{:id="Clock.DurationToDays" class="method returns number"} <i/> 持续时间为天(*持续时间*{:.number})
: 返回持续时间由毫秒转换为天的数值。

{:id="Clock.DurationToHours" class="method returns number"} <i/> 持续时间为小时(*持续时间*{:.number})
: 返回持续时间由毫秒转换为小时的数值。

{:id="Clock.DurationToMinutes" class="method returns number"} <i/> 持续时间为分钟(*持续时间*{:.number})
: 返回持续时间由毫秒转换为分钟的数值。

{:id="Clock.DurationToSeconds" class="method returns number"} <i/> 持续时间为秒(*持续时间*{:.number})
: 返回持续时间由毫秒转换为秒的数值。

{:id="Clock.DurationToWeeks" class="method returns number"} <i/> 持续时间为周(*持续时间*{:.number})
: 返回持续时间由毫秒转换为周的数值。

{:id="Clock.FormatDate" class="method returns text"} <i/> 日期格式(*时刻*{:.InstantInTime},*格式*{:.text})
: 将即时时间格式化为指定格式的日期字符串。有效的格式请查阅[简单日期格式](https://developer.android.com/reference/java/text/SimpleDateFormat).

{:id="Clock.FormatDateTime" class="method returns text"} <i/> 日期时间格式(*时刻*{:.InstantInTime},*格式*{:.text})
: 将即时时间格式化为指定格式的日期时间字符串。有效的格式请查阅[简单日期格式](https://developer.android.com/reference/java/text/SimpleDateFormat).

{:id="Clock.FormatTime" class="method returns text"} <i/> 时间格式(*时刻*{:.InstantInTime})
: 将即时时间格式化为指定格式的时间字符串。有效的格式请查阅[简单日期格式](https://developer.android.com/reference/java/text/SimpleDateFormat).

{:id="Clock.GetMillis" class="method returns number"} <i/> 获取毫秒数(*时刻*{:.InstantInTime})
: 返回即时时间自 UTC（世界标准时间）1970年以来的毫秒数。

{:id="Clock.Hour" class="method returns number"} <i/> 求小时(*时刻*{:.InstantInTime})
: 返回给定时间中的小时数。

{:id="Clock.MakeDate" class="method returns InstantInTime"} <i/> 创建日期(*年*{:.number},*月*{:.number},*日*{:.number})
: 返回按 UTC（世界标准时间）格式的年、月、日指定的即时时间。月份字段的有效值为 1-12，日期字段的有效值为 1-31。

{:id="Clock.MakeInstant" class="method returns InstantInTime"} <i/> 由文本建时间点(*时间文本*{:.text})
: 返回指定 `MM/dd/YYYY hh:mm:ss` 或 `MM/dd/YYYY` 或 `hh:mm` 格式时间文本的即时时间。

  **注意：**时间文本不是以上3种格式的话，会报错：

  ![时间格式错误](images/时间格式错误.png)

{:id="Clock.MakeInstantFromMillis" class="method returns InstantInTime"} <i/> 由毫秒建时间点(*毫秒数*{:.number})
: 返回 UTC（世界标准时间）1970年指定毫秒数之后的即时时间。

{:id="Clock.MakeInstantFromParts" class="method returns InstantInTime"} <i/> 由元件建时间点(*年*{:.number},*月*{:.number},*日*{:.number},*时*{:.number},*分*{:.number},*秒*{:.number})
: 返回由指定的年、月、日、时、分、秒指定的 UTC（世界标准时间）即时时间。

{:id="Clock.MakeTime" class="method returns InstantInTime"} <i/> 创建时间(*时*{:.number},*分*{:.number},*秒*{:.number})
: 返回按 UTC（世界标准时间）格式的时、分、秒指定的即时时间。

{:id="Clock.Minute" class="method returns number"} <i/> 求分钟(*时刻*{:.InstantInTime})
: 返回给定日期中的分钟数。

{:id="Clock.Month" class="method returns number"} <i/> 求月份(*时刻*{:.InstantInTime})
: 返回给定日期中的月份数。

{:id="Clock.MonthName" class="method returns text"} <i/> 求月份名(*时刻*{:.InstantInTime})
: 返回给定日期中的月份名称。如`“十月”`。

{:id="Clock.Now" class="method returns InstantInTime"} <i/> 求当前时间()
: 返回从`手机时钟`读取的当前时刻。

{:id="Clock.Second" class="method returns number"} <i/> 求秒数(*时刻*{:.InstantInTime})
: 返回给定日期中的秒数。

{:id="Clock.SystemTime" class="method returns number"} <i/> 求系统时间()
: 返回`手机的内部时间`。

{:id="Clock.Weekday" class="method returns number"} <i/> 求星期(*时刻*{:.InstantInTime})
: 返回给定日期中的星期数。对应关系如下：

  | 星期 | 日 | 一 | 二 | 三 | 四 | 五 | 六 |
  |---------|---------|---------|---------|---------|---------|---------|---------|
  | 数值 | 1 | 2 | 3 | 4 | 5 | 6 | 7 |

{:id="Clock.WeekdayName" class="method returns text"} <i/> 求星期名(*时刻*{:.InstantInTime})
: 返回给定日期中的星期名称，如`“星期二”`。

{:id="Clock.Year" class="method returns number"} <i/> 求年份(*时刻*{:.InstantInTime})
: 返回给定日期中的年份数，如 `2023`。


## ![icon](images/gyroscopesensor.png)  陀螺仪传感器  {#GyroscopeSensor}

提供来自设备陀螺仪传感器的数据的组件。

### 属性  {#GyroscopeSensor-Properties}

{:.properties}

{:id="GyroscopeSensor.Available" .boolean .ro .bo} *可用状态*
: 陀螺仪传感器是否可用。

{:id="GyroscopeSensor.Enabled" .boolean} *启用*
: 指定传感器是否触发事件。 如果为`真`{:.logic.block}，传感器将触发事件；否则，不会触发任何事件。

{:id="GyroscopeSensor.XAngularVelocity" .number .ro .bo} *X分量角速度*
: 绕 X 轴的角速度，以 度/秒 为单位。

{:id="GyroscopeSensor.YAngularVelocity" .number .ro .bo} *Y分量角速度*
: 绕 Y 轴的角速度，以 度/秒 为单位。

{:id="GyroscopeSensor.ZAngularVelocity" .number .ro .bo} *Z分量角速度*
: 绕 Z 轴的角速度，以 度/秒 为单位。

### 事件  {#GyroscopeSensor-Events}

{:.events}

{:id="GyroscopeSensor.GyroscopeChanged"} 陀螺仪状态改变时(*x分量角速度*{:.number},*y分量角速度*{:.number},*z分量角速度*{:.number},*时间戳*{:.number})
: 表明陀螺仪传感器数据已更改。 时间戳参数是事件发生的时间（以纳秒为单位）。

### 方法  {#GyroscopeSensor-Methods}

{:.methods}
无


## ![icon](images/hygrometer.png)  湿度传感器  {#Hygrometer}

如果硬件支持，可以测量相对环境空气湿度的物理世界组件。

### 属性  {#Hygrometer-Properties}

{:.properties}

{:id="Hygrometer.Available" .boolean .ro .bo} *可用状态*
: 指定设备是否具有支持`湿度传感器`组件的硬件。

{:id="Hygrometer.Enabled" .boolean} *启用*
: 指定传感器是否触发事件。 如果`真`{:.logic.block}，传感器将触发事件；否则，不会触发任何事件。

{:id="Hygrometer.Humidity" .number .ro .bo} *湿度*
: 以百分比形式返回相对环境湿度。

  传感器必须可用并启用，才能返回有意义的值。

{:id="Hygrometer.RefreshTime" .number} *刷新时间*
: 所请求的读数变化之间的最短时间（以毫秒为单位）。 Android 不保证会满足该请求。

### 事件  {#Hygrometer-Events}

{:.events}

{:id="Hygrometer.HumidityChanged"} 湿度改变时(*湿度值*{:.number})
: 表示相对湿度的变化。

### 方法  {#Hygrometer-Methods}

{:.methods}
无


## ![icon](images/lightsensor.png)  光线传感器  {#LightSensor}

可以测量光水平的物理世界组件。

### 属性  {#LightSensor-Properties}

{:.properties}

{:id="LightSensor.Available" .boolean .ro .bo} *可用状态*
: 指定设备是否具有支持`光线传感器`组件的硬件。

{:id="LightSensor.Lux" .number .ro .bo} *照度*
: 返回最后测量的照度值（以 lux 为单位）。

  传感器必须可用并启用，才能返回有意义的值。

{:id="LightSensor.AverageLux" .number .ro .bo} *平均照度*
: 通过计算前 10 个测量值的平均值，返回照度值（以 lux 为单位）。
  
  传感器必须可用并启用，才能返回有意义的值。

{:id="LightSensor.Enabled" .boolean} *启用*
: 指定传感器是否触发事件。 如果为`真`{:.logic.block}，传感器将触发事件；否则，不会触发任何事件。

{:id="LightSensor.RefreshTime" .number} *刷新时间*
: 所请求的读数变化之间的最短时间（以毫秒为单位）。 Android 不保证会满足该请求。

### 事件  {#LightSensor-Events}

{:.events}

{:id="LightSensor.LightChanged"} 光线变化时(*照度值*{:.number})
: 亮度级别发生变化时触发该事件。

### 方法  {#LightSensor-Methods}

{:.methods}
无


## ![icon](images/locationsensor.png)  位置传感器  {#LocationSensor}

不可见组件，提供位置信息，包括：
  
  [`纬度`](#LocationSensor.Latitude)， [`经度`](#LocationSensor.Longitude)、 [`海拔`](#LocationSensor.Altitude)（如果设备支持）、速度（如果设备支持） 和地址。
  
  也可以执行“地理编码”，转换给定的地址（不限于当前地址）到纬度（使用 [`由地址求纬度`](#LocationSensor.LatitudeFromAddress)方法）和经度（使用 [`由地址求经度`](#LocationSensor.LongitudeFromAddress) 方法）。

  **中文网注：**如果获取不了经纬度，请尝试开启一下定位权限，参考代码如下：

  ![请求定位权限](images/请求定位权限.png)

  为了发挥作用，组件必须将其 [`启用`](#LocationSensor.Enabled) 属性设置为`真`{:.logic.block}，并且设备必须通过无线网络启用定位感应器 或 GPS 卫星（如果在室外）。

  应用程序启动时，位置信息可能无法立即可用。你必须稍微等一下找到并使用位置提供者，或者等待[`位置改变时`](#LocationSensor.LocationChanged) 事件。

  模拟器并不模拟所有设备上的传感器，App应该在物理设备上进行测试。

### 属性  {#LocationSensor-Properties}

{:.properties}

{:id="LocationSensor.Accuracy" .number .ro .bo} *精度*
: `位置传感器`将能够根据卫星、手机信号塔和其他用于估计位置的数据的质量，以不同程度的置信度来定位设备。

  “精度”值是传感器检测到的位置周围的半径（以米为单位）。该设备有 68% 的机会位于该半径内。更精确的位置检测将导致更小的精度数字，这使得应用程序对设备实际所在的位置更有信心。

  如果精度未知，则返回值为 0.0。

{:id="LocationSensor.Altitude" .number .ro .bo} *海拔*
: 设备的海拔高度（以米为单位）（如果有）。

  海拔高度是根据 [世界大地测量系统 84 参考椭球体](https://gisgeography.com/wgs84-world-geodetic-system/) 测量的，而不是海平面。

  请注意，设备很难准确地感知海拔高度。手机/平板电脑上报告的海拔高度很容易偏离 30 米或更多。

{:id="LocationSensor.AvailableProviders" .list .ro .bo} *可用提供者*
: 可用服务提供者的列表，例如 GPS 或网络。 此信息以列表和文本形式提供。

{:id="LocationSensor.CurrentAddress" .text .ro .bo} *当前地址*
: 来自地图数据库的设备的实际街道地址。

  提供者可能并不总是提供该地址，并且报告的地址可能并不总是设备所在建筑物的地址。

  如果没有特定位置的可用地址信息，则会返回“无可用地址”。

{:id="LocationSensor.DistanceInterval" .number} *距离间隔*
: 确定传感器尝试用于发送位置更新的最小距离间隔（以米为单位）。

  例如，如果设置为 50，则传感器仅在穿过 50 米后才会触发 [`位置改变时`](#LocationSensor.LocationChanged) 事件。 然而，传感器不保证在精确的距离间隔处接收到更新。 例如，触发一个事件可能需要超过 5 米。

  使用此属性时，检查 [`精度`](#LocationSensor.Accuracy) 也很有用。 当你的设备移动时，检测到的位置的准确性会不断变化。

{:id="LocationSensor.Enabled" .boolean} *启用*
: 如果为`真`{:.logic.block}，则`位置传感器`将尝试从 GPS、WiFi 位置或设备上可用的其他方式读取位置信息。 此设置不控制位置信息是否实际可用。 必须在设备设置中启用或禁用设备定位。

{:id="LocationSensor.HasAccuracy" .boolean .ro .bo} *拥有精度数据*
: 如果为`真`{:.logic.block}，则设备可以报告其精度级别。

{:id="LocationSensor.HasAltitude" .boolean .ro .bo} *拥有海拔数据*
: 如果为`真`{:.logic.block}，则设备可以报告其海拔高度。

{:id="LocationSensor.HasLongitudeLatitude" .boolean .ro .bo} *拥有经纬度数据*
: 如果为`真`{:.logic.block}，则设备可以报告经度和纬度。它们是一起的，要么两者都报告，要么都不报告。

{:id="LocationSensor.Latitude" .number .ro .bo} *纬度*
: 最近可用的纬度值（以度为单位）报告到小数点后 5 位。
  
  如果没有可用值，则返回 0。
  
  纬度是 90（北）和 -90（南）之间的值，其中 0 表示赤道。

{:id="LocationSensor.Longitude" .number .ro .bo} *经度*
: 最新可用的经度值（以度为单位）报告到小数点后 5 位。
  
  如果没有可用值，则返回 0。
  
  经度是 180（东）和 -180（西）之间的值，其中 0 表示本初子午线。

{:id="LocationSensor.ProviderLocked" .boolean .bo} *锁定提供者*
: 指定设备是否会自动切换服务提供者。

  当当前提供者无法提供足够的位置信息时，设备可以切换服务提供者。
  
  设置为 `真`{:.logic.block} 以防止提供者更改；设置为`假`{:.logic.block} 以允许在必要时自动切换。

{:id="LocationSensor.ProviderName" .text .bo} *提供者名称*
: 当前的服务提供者。提供者很可能是 GPS 或网络。

{:id="LocationSensor.TimeInterval" .number} *时间间隔（毫秒）*
: 确定传感器尝试用于发送位置更新的最小时间间隔（以毫秒为单位）。 但是，只有当手机位置实际发生变化时才会收到位置更新，并且不保证指定时间间隔的使用。 例如，如果使用 30000 作为时间间隔，则位置更新永远不会早于 30000 毫秒触发，但可能会在之后的任何时间触发。

  对于大多数设备来说，小于 30000 毫秒（30 秒）的值不实用。 较小的值可能会耗尽电池电量并使 GPS 过度工作。

### 事件  {#LocationSensor-Events}

{:.events}

{:id="LocationSensor.LocationChanged"} 位置改变时(*纬度*{:.number},*经度*{:.number},*海拔*{:.number},*速度*{:.number})
: 表示已检测到新位置。`速度`以米/秒为单位。

{:id="LocationSensor.StatusChanged"} 状态改变时(*提供者*{:.text},*状态*{:.text})
: 表示位置提供者服务的状态已更改，例如当提供者丢失或开始使用新提供者时。

### 方法  {#LocationSensor-Methods}

{:.methods}

{:id="LocationSensor.LatitudeFromAddress" class="method returns number"} <i/> 由地址求纬度(*位置名称*{:.text})
: 从给定的“位置名称”导出纬度。

{:id="LocationSensor.LongitudeFromAddress" class="method returns number"} <i/> 由地址求经度(*位置名称*{:.text})
: 从给定的“位置名称”导出经度。

## ![icon](images/magneticfieldsensor.png)  磁场传感器  {#MagneticFieldSensor}

`磁场传感器`组件。

### 属性  {#MagneticFieldSensor-Properties}

{:.properties}

{:id="MagneticFieldSensor.AbsoluteStrength" .number .ro .bo} *绝对强度*
: 表示磁场的绝对强度。

{:id="MagneticFieldSensor.Available" .boolean .ro .bo} *可用状态*
: 表示设备中有磁场传感器并且可用。

{:id="MagneticFieldSensor.Enabled" .boolean} *启用*
: 表示磁场传感器是否已启用并工作。

{:id="MagneticFieldSensor.MaximumRange" .number .ro .bo} *最大范围*
: 表示磁传感器可以达到的最大范围。

{:id="MagneticFieldSensor.XStrength" .number .ro .bo} *X分量强度*
: 表示 X 轴上的磁场强度。

{:id="MagneticFieldSensor.YStrength" .number .ro .bo} *Y分量强度*
: 表示 Y 轴上的磁场强度。

{:id="MagneticFieldSensor.ZStrength" .number .ro .bo} *Z分量强度*
: 表示 Z 轴上的磁场强度。

### 事件  {#MagneticFieldSensor-Events}

{:.events}

{:id="MagneticFieldSensor.MagneticChanged"} 磁场改变时(*X分量强度*{:.number},*Y分量强度*{:.number},*Z分量强度*{:.number},*绝对强度*{:.number})
: 当磁场发生变化时触发，在参数中设置新值。

### 方法  {#MagneticFieldSensor-Methods}

{:.methods}
无


## ![icon](images/nearfield.png)  NFC  {#NearField}

提供 NFC 功能的不可见组件。目前该组件**仅支持读写文本标签**（如果设备支持）。

设置 [`启用读值模式`](#NearField.ReadMode) 属性为 `真`{:.logic.block} 是读取模式；设置 `假`{:.logic.block} 则是写入模式。

**注意：** 该组件仅适用于应用程序的 `Screen1` 主屏幕！！


### 属性  {#NearField-Properties}

{:.properties}

{:id="NearField.LastMessage" .text .ro .bo} *最新消息*
: 返回最近接收到的标签的内容。

{:id="NearField.ReadMode" .boolean} *启用读值模式*
: 指定 NFC 硬件是否在读取模式下运行。读取模式 (`真`{:.logic.block}) 或 写入模式（`假`{:.logic.block}）。

{:id="NearField.TextToWrite" .text .bo} *写入文本*
: 指定在写入模式下将要写入标签的内容。如果没有设置 [`启用读值模式`](#NearField.ReadMode) 为`真`{:.logic.block}，则该方法没有效果。

{:id="NearField.WriteType" .number .ro .bo} *写入类型*
: 返回 NFC 组件的写入类型。对于此版本的组件，它始终是`1`。

### 事件  {#NearField-Events}

{:.events}

{:id="NearField.TagRead"} 读标签(*消息*{:.text})
: 表示检测到新标签，目前只支持纯文本标签。

{:id="NearField.TagWritten"} 写标签()
: 表示标签已进入 NFC 传感器的范围并已被写入。

### 方法  {#NearField-Methods}

{:.methods}
无


## ![icon](images/orientationsensor.png)  方向传感器  {#OrientationSensor}

使用方向传感器组件来确定手机的空间方向。

  方向传感器是一个不可见的组件，它报告以下三个值（以度为单位）：

   - **滚动**：设备水平时为 0 度，当设备向左侧向上倾斜时增加至 90 度，当设备向右侧向上倾斜时减少至 -90 度。
   - **俯仰**：设备水平时为 0 度，当设备倾斜时增加到 90 度，使其顶部朝下，然后在翻转时减小到 0 度。
         类似地，当设备倾斜时，其底部朝下，俯仰角减小到 -90 度，然后在完全翻转时增加到 0 度。
   - **方位角**：设备顶部指向北时为 0 度，指向东时为 90 度，指向南时为 180 度，指向西时为 270 度等。

  这些测量假设设备本身没有移动。

### 属性  {#OrientationSensor-Properties}

{:.properties}

{:id="OrientationSensor.Angle" .number .ro .bo} *角度*
: 返回一个角度，指示设备平铺的方向。也就是说，它告诉了在设备表面滚动的球所感受到的力的方向。

{:id="OrientationSensor.Available" .boolean .ro .bo} *可用状态*
: 指示设备上是否存在方向传感器。

{:id="OrientationSensor.Azimuth" .number .ro .bo} *方位角*
: 返回设备的方位角。
  
  要返回有意义的值，必须启用传感器。

{:id="OrientationSensor.Enabled" .boolean} *启用*
: 指定是否启用方向传感器。

{:id="OrientationSensor.Magnitude" .number .ro .bo} *力度*
: 返回 0 到 1 之间的数字，指示设备倾斜的程度。它给出了球在设备表面滚动时感受到的力的大小。

  对于倾斜角度，请使用 [`角度`](#OrientationSensor.Angle)。

{:id="OrientationSensor.Pitch" .number .ro .bo} *倾斜角*
: 返回设备的倾斜角。
  
  要返回有意义的值，必须启用传感器。

{:id="OrientationSensor.Roll" .number .ro .bo} *翻转角*
: 返回设备的滚动角度。

  要返回有意义的值，必须启用传感器。

### 事件  {#OrientationSensor-Events}

{:.events}

{:id="OrientationSensor.OrientationChanged"} 方向改变时(*方位角*{:.number},*倾斜角*{:.number},*翻转角*{:.number})
: 当方向发生变化时，将触发该事件。

### 方法  {#OrientationSensor-Methods}

{:.methods}
无


## ![icon](images/pedometer.png)  计步器  {#Pedometer}

该组件使用 [加速度传感器](#AccelerometerSensor) 来记录步数。


### 属性  {#Pedometer-Properties}

{:.properties}

{:id="Pedometer.Distance" .number .ro .bo} *距离*
: 返回以米为单位的大致行驶距离。

{:id="Pedometer.ElapsedTime" .number .ro .bo} *耗时*
: 返回自计步器启动以来经过的时间（以毫秒为单位）。

{:id="Pedometer.SimpleSteps" .number .ro .bo} *简单步数*
: 返回自计步器启动以来发生的简单步数。

{:id="Pedometer.StopDetectionTimeout" .number} *停止检测超时时间*
: 返回多长时间（以毫秒为单位）未检测到步数之后进入停止检测状态。

{:id="Pedometer.StrideLength" .number} *步幅*
: 如果已校准，则返回步幅长度的当前估计值（以米为单位），否则返回默认值 (0.73 m)。

{:id="Pedometer.WalkSteps" .number .ro .bo} *行走步数*
: 返回自计步器启动以来所走的步数。

### 事件  {#Pedometer-Events}

{:.events}

{:id="Pedometer.SimpleStep"} 检测简单步数时(*简单步数*{:.number},*距离*{:.number})
: 当检测到原始步骤(raw step)时运行此事件。

{:id="Pedometer.WalkStep"} 检测行走步数时(*行走步数*{:.number},*距离*{:.number})
: 当检测到步行步骤(walking step)时触发此事件。步行步骤是看起来涉及向前运动的步骤。

### 方法  {#Pedometer-Methods}

{:.methods}

{:id="Pedometer.Reset" class="method"} <i/> 复位()
: 重置计步器、距离测量和跑步时间。

{:id="Pedometer.Save" class="method"} <i/> 保存()
: 将计步器状态保存至手机。允许累积步数和调用使用计步器的应用程序之间的距离。不同的应用程序将有自己的保存状态。

{:id="Pedometer.Start" class="method"} <i/> 开始()
: 启动计步器。

{:id="Pedometer.Stop" class="method"} <i/> 停止()
: 停止计步器。

## ![icon](images/proximitysensor.png)  距离传感器  {#ProximitySensor}

用于测量物体相对于设备屏幕距离（以cm厘米为单位）的传感器组件。该传感器通常用于检测手机听筒是否处于耳边接听状态。
大多数设备返回绝对距离（以cm厘米为单位），但也有些设备仅返回近值和远值，在这个情况下，传感器通常报告其在远距离状态下的最大范围值 和 近距离状态下较小的值。
它报告以下值：
   - **距离**: 物体到设备之间的距离。

### 属性  {#ProximitySensor-Properties}

{:.properties}

{:id="ProximitySensor.Available" .boolean .ro .bo} *可用状态*
: 报告当前设备是否有距离传感器。

{:id="ProximitySensor.Distance" .number .ro .bo} *距离*
: 返回对象到设备之间的距离。必须启用传感器才能返回有效值。

{:id="ProximitySensor.Enabled" .boolean} *启用*
: 如果为真，传感器将触发事件，否则，不触发事件。

{:id="ProximitySensor.KeepRunningWhenOnPause" .boolean} *暂停时保持运动*
: 返回“暂停时保持运动”属性值。

{:id="ProximitySensor.MaximumRange" .number .ro .bo} *最大范围*
: 确定传感器的最大范围。一些距离传感器返回二进制值代表“近”或“远”，在这种情况下，传感器通常会报告它在远距离状态下的最大范围值 和 近距离状态下较小的值。
  通常，远值是 > 5 cm 的值，但不同的传感器可能有差异。

### 事件  {#ProximitySensor-Events}

{:.events}

{:id="ProximitySensor.ProximityChanged"} 距离改变(*距离*{:.number})
: 当对象与设备的距离（以cm厘米为单位）发生变化时触发该事件。

### 方法  {#ProximitySensor-Methods}

{:.methods}
无


## ![icon](images/thermometer.png)  温度传感器  {#Thermometer}

可以测量环境空气温度的物理组件（如果硬件支持）。

### 属性  {#Thermometer-Properties}

{:.properties}

{:id="Thermometer.Available" .boolean .ro .bo} *可用状态*
: 指定设备是否具有支持“温度计”组件的硬件。

{:id="Thermometer.Enabled" .boolean} *启用*
: 指定传感器是否触发事件。 如果为`真`{:.logic.block}，传感器将触发事件；否则，不会触发任何事件。

{:id="Thermometer.RefreshTime" .number} *刷新时间（毫秒）*
: 所请求的读数变化之间的最短时间（以毫秒为单位）。Android 不保证会满足该请求。

{:id="Thermometer.Temperature" .number .ro .bo} *温度*
: 返回以摄氏度为单位的温度。
  
  传感器必须启用并可返回有意义的值。

### 事件  {#Thermometer-Events}

{:.events}

{:id="Thermometer.TemperatureChanged"} 温度改变时(*温度值*{:.number})
: 表示温度发生变化，以摄氏度为单位。

### 方法  {#Thermometer-Methods}

{:.methods}
无
