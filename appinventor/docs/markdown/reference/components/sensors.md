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

1. [加速度传感器](#AccelerometerSensor)
1. [条码扫描器](#BarcodeScanner)
1. [气压传感器](#Barometer)
1. [计时器](#Clock)
1. [陀螺仪传感器](#GyroscopeSensor)
1. [湿度传感器](#Hygrometer)
1. [光线传感器](#LightSensor)
1. [位置传感器](#LocationSensor)
1. [磁场传感器](#MagneticFieldSensor)
1. [NFC](#NearField)
1. [方向传感器](#OrientationSensor)
1. [计步器](#Pedometer)
1. [距离传感器](#ProximitySensor)
1. [温度传感器](#Thermometer)

***
## 加速度传感器  {#AccelerometerSensor}

不可见组件，可检测震动并使用 SI 单位(m/s<sup>2</sup>)在三个维度上近似测量加速度。其组成部分是：

  - **xAccel**：当手机静止在平坦表面上时为 0，当手机倾斜时为正向右（即左侧抬起），当手机倾斜到右侧时为负向左（即，其右侧尺寸升高）。

  - **yAccel**：当手机静止在平坦表面上时为0，当底部抬起时为正，当其顶部升起时为负。

  - **zAccel**：等于 -9.8（当设备处于每秒状态时，地球重力以米每秒为单位）
    
    静止时与地面平行且显示屏朝上，0 时垂直于地面，面朝下时+9.8。 该值也可能受到加速或反对的影响重力。


### 属性  {#AccelerometerSensor-Properties}

{:.properties}

{:id="AccelerometerSensor.Available" .boolean .ro .bo} *Available*
: Returns whether the `AccelerometerSensor` hardware is available on the device.

{:id="AccelerometerSensor.Enabled" .boolean} *Enabled*
: Specifies whether the sensor should generate events.  If `真`{:.logic.block},
 the sensor will generate events.  Otherwise, no events are
 generated even if the device is accelerated or shaken.

{:id="AccelerometerSensor.LegacyMode" .boolean .wo .do} *LegacyMode*
: Prior to the release that added this property the AccelerometerSensor component passed through sensor values directly as received from the Android system. However these values do not compensate for tablets that default to Landscape mode, requiring the MIT App Inventor programmer to compensate. However compensating would result in incorrect results in Portrait mode devices such as phones. We now detect Landscape mode tablets and perform the compensation. However if your project is already compensating for the change, you will now get incorrect results. Although our preferred solution is for you to update your project, you can also just set this property to “true” and our compensation code will be deactivated. Note: We recommend that you update your project as we may remove this property in a future release.

{:id="AccelerometerSensor.MinimumInterval" .number} *MinimumInterval*
: Specifies the minimum interval required between back-to-back [`Shaking`](#AccelerometerSensor.Shaking) events,
 in milliseconds.
 Once the phone starts being shaken, all further [`Shaking`](#AccelerometerSensor.Shaking) events will be ignored
 until the interval has elapsed.

{:id="AccelerometerSensor.Sensitivity" .number} *Sensitivity*
: Specifies the sensitivity of the accelerometer. Valid values are: `1` (weak), `2` (moderate),
 and `3` (strong).

{:id="AccelerometerSensor.XAccel" .number .ro .bo} *XAccel*
: Returns the acceleration in the X-dimension in SI units (m/s²).
 The sensor must be enabled to return meaningful values.

{:id="AccelerometerSensor.YAccel" .number .ro .bo} *YAccel*
: Returns the acceleration in the Y-dimension in SI units (m/s²).
 The sensor must be enabled to return meaningful values.

{:id="AccelerometerSensor.ZAccel" .number .ro .bo} *ZAccel*
: Returns the acceleration in the Z-dimension in SI units (m/s²).
 The sensor must be enabled to return meaningful values.

### 事件  {#AccelerometerSensor-Events}

{:.events}

{:id="AccelerometerSensor.AccelerationChanged"} AccelerationChanged(*xAccel*{:.number},*yAccel*{:.number},*zAccel*{:.number})
: Indicates the acceleration changed in the X, Y, and/or Z dimensions.

{:id="AccelerometerSensor.Shaking"} Shaking()
: Indicates the device started being shaken or continues to be shaken.

### 方法  {#AccelerometerSensor-Methods}

{:.methods}
无

***
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

***
## 气压传感器  {#Barometer}

Physical world component that can measure the ambient air pressure if
 supported by the hardware.



### 属性  {#Barometer-Properties}

{:.properties}

{:id="Barometer.AirPressure" .number .ro .bo} *AirPressure*
: The atmospheric pressure in hPa (millibar), if the sensor is available 
 and enabled.

{:id="Barometer.Available" .boolean .ro .bo} *Available*
: Specifies whether or not the device has the hardware to support the `Barometer` component.

{:id="Barometer.Enabled" .boolean} *Enabled*
: Specifies whether the sensor should generate events.  If `真`{:.logic.block},
 the sensor will generate events.  Otherwise, no events are
 generated.

{:id="Barometer.RefreshTime" .number} *RefreshTime*
: The requested minimum time in milliseconds between changes in readings being reported. Android is not guaranteed to honor the request. Setting this property has no effect on pre-Gingerbread devices.

### 事件  {#Barometer-Events}

{:.events}

{:id="Barometer.AirPressureChanged"} AirPressureChanged(*pressure*{:.number})
: Called when a change is detected in the air pressure (provided in hPa).

### 方法  {#Barometer-Methods}

{:.methods}
无

***
## ![Image of the Clock component](images/clock.png) 计时器  {#Clock}

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

***
## 陀螺仪传感器  {#GyroscopeSensor}

Component providing data from the device's gyroscope sensor.



### 属性  {#GyroscopeSensor-Properties}

{:.properties}

{:id="GyroscopeSensor.Available" .boolean .ro .bo} *Available*
: Indicates whether a gyroscope sensor is available.

{:id="GyroscopeSensor.Enabled" .boolean} *Enabled*
: Enabled property getter method.

{:id="GyroscopeSensor.XAngularVelocity" .number .ro .bo} *XAngularVelocity*
: The angular velocity around the X axis, in degrees per second.

{:id="GyroscopeSensor.YAngularVelocity" .number .ro .bo} *YAngularVelocity*
: The angular velocity around the Y axis, in degrees per second.

{:id="GyroscopeSensor.ZAngularVelocity" .number .ro .bo} *ZAngularVelocity*
: The angular velocity around the Z axis, in degrees per second.

### 事件  {#GyroscopeSensor-Events}

{:.events}

{:id="GyroscopeSensor.GyroscopeChanged"} GyroscopeChanged(*xAngularVelocity*{:.number},*yAngularVelocity*{:.number},*zAngularVelocity*{:.number},*timestamp*{:.number})
: Indicates that the gyroscope sensor data has changed. The timestamp parameter is the time in nanoseconds at which the event occurred.

### 方法  {#GyroscopeSensor-Methods}

{:.methods}
无

***
## 湿度传感器  {#Hygrometer}

Physical world component that can measure the relative ambient air 
 humidity if supported by the hardware.



### 属性  {#Hygrometer-Properties}

{:.properties}

{:id="Hygrometer.Available" .boolean .ro .bo} *Available*
: Specifies whether or not the device has the hardware to support the `Hygrometer` component.

{:id="Hygrometer.Enabled" .boolean} *Enabled*
: Specifies whether the sensor should generate events.  If `真`{:.logic.block},
 the sensor will generate events.  Otherwise, no events are
 generated.

{:id="Hygrometer.Humidity" .number .ro .bo} *Humidity*
: Returns the relative ambient humidity as a percentage.
 The sensor must be enabled and available 
 to return meaningful values.

{:id="Hygrometer.RefreshTime" .number} *RefreshTime*
: The requested minimum time in milliseconds between changes in readings being reported. Android is not guaranteed to honor the request. Setting this property has no effect on pre-Gingerbread devices.

### 事件  {#Hygrometer-Events}

{:.events}

{:id="Hygrometer.HumidityChanged"} HumidityChanged(*humidity*{:.number})
: Indicates the relative humidity changed.

### 方法  {#Hygrometer-Methods}

{:.methods}
无

***
## 光线传感器  {#LightSensor}

Physical world component that can measure the light level.



### 属性  {#LightSensor-Properties}

{:.properties}

{:id="LightSensor.Available" .boolean .ro .bo} *Available*
: Specifies whether or not the device has the hardware to support the `LightSensor` component.

{:id="LightSensor.AverageLux" .number .ro .bo} *AverageLux*
: Returns the brightness in lux by averaging the previous 10 measured values.
 The sensor must be enabled and available to return meaningful values.

{:id="LightSensor.Enabled" .boolean} *Enabled*
: Specifies whether the sensor should generate events.  If `真`{:.logic.block},
 the sensor will generate events.  Otherwise, no events are
 generated.

{:id="LightSensor.Lux" .number .ro .bo} *Lux*
: Returns the last measured brightness in lux.
 The sensor must be enabled and available to return meaningful values.

{:id="LightSensor.RefreshTime" .number} *RefreshTime*
: The requested minimum time in milliseconds between changes in readings being reported. Android is not guaranteed to honor the request. Setting this property has no effect on pre-Gingerbread devices.

### 事件  {#LightSensor-Events}

{:.events}

{:id="LightSensor.LightChanged"} LightChanged(*lux*{:.number})
: Indicates the light level changed.

### 方法  {#LightSensor-Methods}

{:.methods}
无

***
## 位置传感器  {#LocationSensor}

Non-visible component providing location information, including [`Latitude`](#LocationSensor.Latitude),
 [`Longitude`](#LocationSensor.Longitude), [`Altitude`](#LocationSensor.Altitude) (if supported by the device), speed (if supported by
 the device), and address. This can also perform "geocoding", converting a given address (not
 necessarily the current one) to a latitude (with the [`LatitudeFromAddress`](#LocationSensor.LatitudeFromAddress)
 method) and a longitude (with the [`LongitudeFromAddress`](#LocationSensor.LongitudeFromAddress) method).

 In order to function, the component must have its [`Enabled`](#LocationSensor.Enabled) property set to
 `真`{:.logic.block}, and the device must have location sensing enabled through wireless
 networks or GPS satellites (if outdoors).

 Location information might not be immediately available when an app starts. You'll have to wait
 a short time for a location provider to be found and used, or wait for the
 [`LocationChanged`](#LocationSensor.LocationChanged) event.

 The emulator does not emulate sensors on all devices. Code should be tested on a physical device.



### 属性  {#LocationSensor-Properties}

{:.properties}

{:id="LocationSensor.Accuracy" .number .ro .bo} *Accuracy*
: The `LocationSensor` will be able to locate the device with a varying degree of confidence,
 based on the quality of satellite, cell towers, and other data used to estimate location.
 The `Accuracy` value is the radius in meters around the sensor's detected location. The device
 has a 68% chance to be located within this radius. More precise location detection will result
 in a smaller accuracy number, which allows the app to have more confidence where the device
 is actually located.

   If the accuracy is not known, the return value is 0.0

{:id="LocationSensor.Altitude" .number .ro .bo} *Altitude*
: Altitude of the device measured in meters, if available.

   Altitude is measured from the
 [World Geodetic System 84 reference ellipsoid](https://gisgeography.com/wgs84-world-geodetic-system/),
 not sea level.

   Note that it is difficult for devices to accurately sense altitude. Altitude reported on a
 phone/tablet can easily be off by 30 meters or more.

{:id="LocationSensor.AvailableProviders" .list .ro .bo} *AvailableProviders*
: List of available service providers, such as gps or network. This information is provided
 as a list and in text form.

{:id="LocationSensor.CurrentAddress" .text .ro .bo} *CurrentAddress*
: Physical street address of the device from Google's map database.

   The address might not always be available from the provider, and the address reported may not
 always be of the building where the device is located.

   If Google has no address information available for a particular location, this will return
 `No address available`.

{:id="LocationSensor.DistanceInterval" .number} *DistanceInterval*
: Determines the minimum distance interval, in meters, that the sensor will try to use for
 sending out location updates. For example, if this is set to 50, then the sensor will fire a
 [`LocationChanged`](#LocationSensor.LocationChanged) event only after 50 meters have been
 traversed. However, the sensor does not guarantee that an update will be received at exactly
 the distance interval. It may take more than 5 meters to fire an event, for instance.

   It is also useful to check against [`Accuracy`](#LocationSensor.Accuracy) when using this property. When your
 device is moving, the accuracy of the detected location is constantly changing.

{:id="LocationSensor.Enabled" .boolean} *Enabled*
: If `真`{:.logic.block}, the `LocationSensor` will attempt to read location information from
 GPS, WiFi location, or other means available on the device. This setting does not control
 whether location information is actually available. Device location must be enabled or
 disabled in the device settings.

{:id="LocationSensor.HasAccuracy" .boolean .ro .bo} *HasAccuracy*
: If `真`{:.logic.block}, the device can report its accuracy level.

{:id="LocationSensor.HasAltitude" .boolean .ro .bo} *HasAltitude*
: If `真`{:.logic.block}, the device can report its altitude.

{:id="LocationSensor.HasLongitudeLatitude" .boolean .ro .bo} *HasLongitudeLatitude*
: If `真`{:.logic.block}, the device can report longitude and latitude.  It is
 always the case that either both or neither are.

{:id="LocationSensor.Latitude" .number .ro .bo} *Latitude*
: The most recently available latitude value in degrees reported to 5 decimal places.
 If no value is available, 0 will be returned.
 Latitude is a value between 90 (north) and -90 (south), where 0 marks the Equator.

{:id="LocationSensor.Longitude" .number .ro .bo} *Longitude*
: The most recent available longitude value in degrees reported to 5 decimal places.
 If no value is available, 0 will be returned.
 Longitude is a value between 180 (east) and -180 (west), where 0 marks the Prime Meridian.

{:id="LocationSensor.ProviderLocked" .boolean .bo} *ProviderLocked*
: The device will not change the service provider.

   It is possible for a device to switch service providers when the current provider is unable
 to provide adequate location information. `ProviderLocked` is a Boolean value: true/false.
 Set to `真`{:.logic.block} to prevent providers from changing. Set to `假`{:.logic.block}
 to allow for automatic switching when necessary.

{:id="LocationSensor.ProviderName" .text .bo} *ProviderName*
: The current service provider. The provider will most likely be either GPS or network.

{:id="LocationSensor.TimeInterval" .number} *TimeInterval*
: Determines the minimum time interval, in milliseconds, that the sensor will try to use for
 sending out location updates. However, location updates will only be received when the
 location of the phone actually changes, and use of the specified time interval is not
 guaranteed. For example, if 30000 is used as the time interval, location updates will never
 be fired sooner than 30000ms, but they may be fired anytime after.

   Values smaller than 30000ms (30 seconds) are not practical for most devices. Small values
 may drain battery and overwork the GPS.

### 事件  {#LocationSensor-Events}

{:.events}

{:id="LocationSensor.LocationChanged"} LocationChanged(*latitude*{:.number},*longitude*{:.number},*altitude*{:.number},*speed*{:.number})
: Indicates that a new location has been detected. Speed is reported in meters/second
 Other values match their properties.

{:id="LocationSensor.StatusChanged"} StatusChanged(*provider*{:.text},*status*{:.text})
: Indicates that the status of the location provider service has changed, such as when a
 provider is lost or a new provider starts being used.

### 方法  {#LocationSensor-Methods}

{:.methods}

{:id="LocationSensor.LatitudeFromAddress" class="method returns number"} <i/> LatitudeFromAddress(*locationName*{:.text})
: Derives latitude from the given `locationName`.

{:id="LocationSensor.LongitudeFromAddress" class="method returns number"} <i/> LongitudeFromAddress(*locationName*{:.text})
: Derives longitude from the given `locationName`.

***
## 磁场传感器  {#MagneticFieldSensor}

Component for MagneticFieldSensor



### 属性  {#MagneticFieldSensor-Properties}

{:.properties}

{:id="MagneticFieldSensor.AbsoluteStrength" .number .ro .bo} *AbsoluteStrength*
: Indicates the absolute strength of the field.

{:id="MagneticFieldSensor.Available" .boolean .ro .bo} *Available*
: Indicates that there is a magnetic field sensor in the device and it is available.

{:id="MagneticFieldSensor.Enabled" .boolean} *Enabled*
: Indicates whether or not the magnetic field sensor is enabled and working.

{:id="MagneticFieldSensor.MaximumRange" .number .ro .bo} *MaximumRange*
: Indicates the maximum range the magnetic sensor can reach.

{:id="MagneticFieldSensor.XStrength" .number .ro .bo} *XStrength*
: Indicates the field's strength in the X-axis.

{:id="MagneticFieldSensor.YStrength" .number .ro .bo} *YStrength*
: Indicates the field's strength in the Y-axis.

{:id="MagneticFieldSensor.ZStrength" .number .ro .bo} *ZStrength*
: Indicates the field's strength in the Z-axis.

### 事件  {#MagneticFieldSensor-Events}

{:.events}

{:id="MagneticFieldSensor.MagneticChanged"} MagneticChanged(*xStrength*{:.number},*yStrength*{:.number},*zStrength*{:.number},*absoluteStrength*{:.number})
: Triggers when magnetic field has changed, setting the new values in parameters.

### 方法  {#MagneticFieldSensor-Methods}

{:.methods}
无

***
## NFC  {#NearField}

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

***
## 方向传感器  {#OrientationSensor}

![Example of the OrientationSensor icon](images/orientationsensor.png)

 Use an orientation sensor component to determine the phone's spatial orientation.

 An orientation sensor is a non-visible component that reports the following three values, in
 degrees:

  - **Roll** : 0 degree when the device is level, increasing to 90 degrees as the device is
    tilted up onto its left side, and decreasing to −90 degrees when the device is tilted up onto
    its right side.
  - **Pitch** : 0 degree when the device is level, increasing to 90 degrees as the device is
    tilted so its top is pointing down, then decreasing to 0 degree as it gets turned over.
    Similarly, as the device is tilted so its bottom points down, pitch decreases to −90 degrees,
    then increases to 0 degree as it gets turned all the way over.
  - **Azimuth** : 0 degree when the top of the device is pointing north, 90 degrees when it is
    pointing east, 180 degrees when it is pointing south, 270 degrees when it is pointing west,
    etc.

 These measurements assume that the device itself is not moving.



### 属性  {#OrientationSensor-Properties}

{:.properties}

{:id="OrientationSensor.Angle" .number .ro .bo} *Angle*
: Returns an angle that tells the direction in which the device is tiled. That is, it tells the
 direction of the force that would be felt by a ball rolling on the surface of the device.

{:id="OrientationSensor.Available" .boolean .ro .bo} *Available*
: Indicates whether the orientation sensor is present on the device.

{:id="OrientationSensor.Azimuth" .number .ro .bo} *Azimuth*
: Returns the azimuth angle of the device.
 To return meaningful values the sensor must be enabled.

{:id="OrientationSensor.Enabled" .boolean} *Enabled*
: Specifies whether the orientation sensor is enabled.

{:id="OrientationSensor.Magnitude" .number .ro .bo} *Magnitude*
: Returns a number between 0 and 1 indicating how much the device
 is tilted. It gives the magnitude of the force that would be felt
 by a ball rolling on the surface of the device. For the angle of
 tilt, use [`Angle`](#OrientationSensor.Angle).

{:id="OrientationSensor.Pitch" .number .ro .bo} *Pitch*
: Returns the pitch angle of the device.
 To return meaningful values the sensor must be enabled.

{:id="OrientationSensor.Roll" .number .ro .bo} *Roll*
: Returns the roll angle of the device.
 To return meaningful values the sensor must be enabled.

### 事件  {#OrientationSensor-Events}

{:.events}

{:id="OrientationSensor.OrientationChanged"} OrientationChanged(*azimuth*{:.number},*pitch*{:.number},*roll*{:.number})
: The `OrientationChanged` event handler is run when the orientation has changed.

### 方法  {#OrientationSensor-Methods}

{:.methods}
无

***
## 计步器  {#Pedometer}

该组件使用 [加速度传感器](#AccelerometerSensor) 来记录步数。


### 属性  {#Pedometer-Properties}

{:.properties}

{:id="Pedometer.Distance" .number .ro .bo} *Distance*
: Returns the approximate distance traveled in meters.

{:id="Pedometer.ElapsedTime" .number .ro .bo} *ElapsedTime*
: Returns the time elapsed in milliseconds since the pedometer has started.

{:id="Pedometer.SimpleSteps" .number .ro .bo} *SimpleSteps*
: Returns the number of simple steps taken since the pedometer has started.

{:id="Pedometer.StopDetectionTimeout" .number} *StopDetectionTimeout*
: Returns the duration of idleness (no steps detected) after which to go into a "stopped" state.

{:id="Pedometer.StrideLength" .number} *StrideLength*
: Returns the current estimate of stride length in meters, if calibrated, or returns the
 default (0.73 m) otherwise.

{:id="Pedometer.WalkSteps" .number .ro .bo} *WalkSteps*
: Returns the number of walk steps taken since the pedometer has started.

### 事件  {#Pedometer-Events}

{:.events}

{:id="Pedometer.SimpleStep"} SimpleStep(*simpleSteps*{:.number},*distance*{:.number})
: This event is run when a raw step is detected.

{:id="Pedometer.WalkStep"} WalkStep(*walkSteps*{:.number},*distance*{:.number})
: This event is run when a walking step is detected. A walking step is a step that appears to be involved in forward motion.

### 方法  {#Pedometer-Methods}

{:.methods}

{:id="Pedometer.Reset" class="method"} <i/> Reset()
: Resets the step counter, distance measure and time running.

{:id="Pedometer.Save" class="method"} <i/> Save()
: Saves the pedometer state to the phone. Permits permits accumulation of steps and distance between invocations of an App that uses the pedometer. Different Apps will have their own saved state.

{:id="Pedometer.Start" class="method"} <i/> Start()
: Starts the pedometer.

{:id="Pedometer.Stop" class="method"} <i/> Stop()
: Stops the pedometer.

***
## 距离传感器  {#ProximitySensor}

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

***
## 温度传感器  {#Thermometer}

可以测量环境空气温度的物理组件（如果硬件支持）。

### 属性  {#Thermometer-Properties}

{:.properties}

{:id="Thermometer.Available" .boolean .ro .bo} *Available*
: Specifies whether or not the device has the hardware to support the `Thermometer` component.

{:id="Thermometer.Enabled" .boolean} *Enabled*
: Specifies whether the sensor should generate events.  If `真`{:.logic.block},
 the sensor will generate events.  Otherwise, no events are
 generated.

{:id="Thermometer.RefreshTime" .number} *RefreshTime*
: The requested minimum time in milliseconds between changes in readings being reported. Android is not guaranteed to honor the request. Setting this property has no effect on pre-Gingerbread devices.

{:id="Thermometer.Temperature" .number .ro .bo} *Temperature*
: Returns the temperature in degrees Celsius.
 The sensor must be enabled and available 
 to return meaningful values.

### 事件  {#Thermometer-Events}

{:.events}

{:id="Thermometer.TemperatureChanged"} TemperatureChanged(*temperature*{:.number})
: Indicates a change of temperature, provided in degrees Celsius.

### 方法  {#Thermometer-Methods}

{:.methods}
无

