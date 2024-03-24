---
title: App Inventor 2 TaifunImage 拓展，图像高级处理功能，剪裁，压缩，翻转等
layout: documentation
description: App Inventor 2 TaifunImage 拓展，图像高级处理，剪裁，压缩，翻转等。
---

* TOC
{:toc}

[&laquo; 返回首页](index.html)

## ![logo](TaifunImage/logo.png)  TaifunImage 拓展  {#TaifunImage}
<!--(https://puravidaapps.com/image.php)-->

* .aix 拓展下载：

{:.vip}
[com.puravidaapps.TaifunImage.aix](TaifunImage/com.puravidaapps.TaifunImage.aix)

* demo程序下载：

{:.vip}
<div>
    <a class="ext" href="https://downloads.sourceforge.net/project/puravidaapps/Resize.aia" target="_blank">Download Resize test project (aia file)</a><br>
    <a class="ext" href="https://downloads.sourceforge.net/project/puravidaapps/chunks.aia" target="_blank">Download Create Chunks test project (aia file)</a><br>
    <a class="ext" href="https://downloads.sourceforge.net/project/puravidaapps/crop.aia" target="_blank">Download Crop test project (aia file)</a><br>
    <a class="ext" href="https://downloads.sourceforge.net/project/puravidaapps/rotate.aia" target="_blank">Download Rotate test project (aia file)</a><br>
    <a class="ext" href="https://downloads.sourceforge.net/project/puravidaapps/overlay.aia" target="_blank">Download Scale &amp; Overlay test project (aia file)</a><br>
</div>

* [*案例分享1：*图片压缩](#image-compress)

***

用于基本图像处理的图像扩展。

所需权限：`android.permission.READ_EXTERNAL_STORAGE`、`android.permission.WRITE_EXTERNAL_STORAGE`

### 属性  {#TaifunImage-Properties}

{:.properties}

<p><img class="noscale" src="./TaifunImage/getSuppress.JPG" width="306" height="37" alt="" title=""><br>
    返回是否隐藏警告。
</p>

<p><img class="noscale" src="./TaifunImage/setSuppress.JPG" width="355" height="45" alt="" title=""><br>
    设置是否隐藏警告。
</p>

### 方法  {#TaifunImage-Methods}

{:.methods}

<p><img class="noscale" src="./TaifunImage/resize.JPG" width="236" height="122" alt="" title=""><br>
Resize a jpg image file in the ASD - application specific directory.<br>
<b>Thank you Tanja</b> for being the sponsor of this block!
</p>

<p><img class="noscale" src="./TaifunImage/rotate.JPG" width="244" height="97" alt="" title=""><br>
Rotate a jpg image file  in the ASD - application specific directory by 0, 90, 180 or 270 degrees in clockwise direction.<br>
<b>Thank you <a class="ext" href="http://www.teen-code.com/" target="_blank">teen-code.com</a></b> for your generous donation!
</p>

<p><img class="noscale" src="./TaifunImage/crop.JPG" width="210" height="156" alt="" title=""><br>
Crop Image. Enter the distance in pixel for left, top, right and bottom.<br>
<b>Thank you Husain</b> for being the sponsor of this block!
</p>

<p><img class="noscale" src="./TaifunImage/createChunks.JPG" width="281" height="121" alt="" title=""><br>
Create chunks of a jpg image file in the ASD - application specific directory.<br>
</p>

<div class="row">
<div class="eight columns">
    <p>For example rows=4 and columns=3 will create 12 chunks of the original image, see screenshot<br><br>

    The chunks will also be stored in the ASD - application specific directory.
    The following name convention will be used: imageFileName_rowNumber_columnNumber.jpg.<br><br>
    </p>
</div> <!-- end: 8 columns -->
<div class="four columns">
    <img src="./TaifunImage/chunk.png" alt="" title=""><br>
</div> <!-- end: 4 columns -->
</div> <!-- end: row -->

<p>
<img class="noscale" src="./TaifunImage/isLandscape.JPG" width="281" height="67" alt="" title=""><br>
Return true if image in the ASD - application specific directory is in landscape format, else return false.
</p>

<p>
<img class="noscale" src="./TaifunImage/scale.JPG" width="242" height="150" alt="" title=""><br>
Scale a jpg image file in the ASD - application specific directory.<br>
The parameter scalingLogic expects the value FIT or CROP.
CROP keeps the aspect ratio, resulting either in the width or the height of the source image being cropped.<br>
<b>Thank you Andreas</b> for the <a class="ext" href="https://developer.sonymobile.com/2011/06/27/how-to-scale-images-for-your-android-application/" target="_blank">scaling tutorial and the image scaling code sample project</a>.
</p>

<p>
<img class="noscale" src="./TaifunImage/overlay.JPG" width="256" height="91" alt="" title=""><br>
Overlay images in the ASD - application specific directory.<br>
The second image should be an image in png format with transparency to get the overlay effect.<br>
<b>Thank you Christian</b> for being the sponsor of this block!<br><br>

<b>Note:</b> Both images must be available in the ASD - application specific directory.
</p>

### 事件  {#TaifunImage-Events}

{:.events}

<p><img class="noscale" src="./TaifunImage/chunksCreated.JPG" width="296" height="101" alt="" title=""><br>
Event indicating that chunks have been created. A list of filenames will be provided as result.
</p>

<p><img class="noscale" src="./TaifunImage/rotated.JPG" width="255" height="106" alt="" title=""><br>
Event indicating that image has been rotated.<br>
Parameter successful is indicating true (successful) or false. Parameter result provides error message in case of error or filename in case of success.
</p>

<p>
<img class="noscale" src="./TaifunImage/scaled.JPG" width="254" height="111" alt="" title=""><br>
Event indicating that image has been scaled.<br>
Parameter successful is indicating true (successful) or false. Parameter result provides error message in case of error or filename in case of success.
</p>


<h3>Example Use: Resize</h3>
<div class="row">
<div class="four columns">
    <p><b>before resize</b><br><br><img class="noscale" src="./TaifunImage/screen2.jpg" alt="" title=""></p>
</div> <!-- end: 4 columns -->
<div class="four columns">
    <p><b>after resize</b><br><br><img class="noscale" src="./TaifunImage/screen3.jpg" alt="" title=""></p>
</div> <!-- end: 4 columns -->
<div class="four columns">
</div> <!-- end: 4 columns -->
</div> <!-- end: row -->

<p>
Note: the larger image (on the left) looks like it is smaller compared to the shrinked image (on the right).
I currently do not know why this happens, actually the same size in the image component should be displayed...<br><br>

<img class="noscale" src="./TaifunImage/resize1.JPG" width="595" height="648" alt="" title=""><br>
Some more blocks to get the current image size, width and height using the <a class="info" href="https://puravidaapps.com/metadata.php" target="_top">Image Metadata Extension</a><br>
<img class="noscale" src="./TaifunImage/resize2.JPG" width="615" height="510" alt="" title=""><br>
<img class="noscale" src="./TaifunImage/resize3.JPG" width="937" height="308" alt="" title=""><br>
</p>

<h3>Example Use: Create Chunks</h3>
<div class="row">
<div class="eight columns">
    <p>
    <img src="./TaifunImage/chunk1.JPG" alt="" title=""><br>
    <img src="./TaifunImage/chunk2.JPG" alt="" title=""><br>
    </p>
</div> <!-- end: 8 columns -->
<div class="four columns">
    <p>displaying chunk # 5 out of 12 chunks created (4 rows and 3 columns)
    <img class="noscale" src="./TaifunImage/screen1.jpg" alt="" title="">
    </p>
</div> <!-- end: 4 columns -->
</div> <!-- end: row -->

<p>
<img class="noscale" src="./TaifunImage/chunk3.JPG" width="980" height="474" alt="" title=""><br>
</p>

<h3>Example Use: Crop</h3>
<div class="row">
<div class="four columns">
    <p><img class="noscale" src="./TaifunImage/cropScreen1.jpg" alt="" title=""></p>
</div> <!-- end: 4 columns -->
<div class="four columns">
    <p><img class="noscale" src="./TaifunImage/cropScreen2.jpg" alt="" title=""></p>
</div> <!-- end: 4 columns -->
<div class="four columns">
</div> <!-- end: 4 columns -->
</div> <!-- end: row -->


<p>
<img class="noscale" src="./TaifunImage/cropExample.JPG" width="483" height="326" alt="" title=""><br>
</p>

<h3>Example Use: Rotate</h3>
<div class="row">
<div class="four columns">
    <p><img class="noscale" src="./TaifunImage/rotate2.jpg" alt="" title=""></p>
</div> <!-- end: 4 columns -->
<div class="four columns">
    <p><img class="noscale" src="./TaifunImage/rotate3.jpg" alt="" title=""></p>
</div> <!-- end: 4 columns -->
<div class="four columns">
    <p><img class="noscale" src="./TaifunImage/rotate1.jpg" alt="" title=""></p>
</div> <!-- end: 4 columns -->
</div> <!-- end: row -->

<p>
<img class="noscale" src="./TaifunImage/rotateExample.JPG" width="933" height="381" alt="" title=""><br>
</p>

<h3>Example Use: Scale and Overlay</h3>
<div class="row">
<div class="four columns">
    <p>An example overlay image in png format, here size 1200x1800 (portrait), transparent background.<br>
    <img class="noscale" src="./TaifunImage/overlay1.png" alt="" title=""></p>
</div> <!-- end: 4 columns -->
<div class="four columns">
    <p><img class="noscale" src="./TaifunImage/overlay2.png" alt="" title=""></p>
</div> <!-- end: 4 columns -->
<div class="four columns">
    <p><img class="noscale" src="./TaifunImage/overlay3.png" alt="" title=""></p>
</div> <!-- end: 4 columns -->
</div> <!-- end: row -->

<p>Scale an image exactly to the size you need and at the same time crop the image to keep the aspect ratio, then add an overlay image (could be for example a watermark or similar).<br>
<img class="noscale" src="./TaifunImage/overlayExample.JPG" width="1026" height="616" alt="" title=""><br>
</p>

***
### 图片分辨率压缩   {#image-compress}

参考代码如下：

{:.vip}
![图片分辨率压缩](TaifunImage/图片压缩.png)
