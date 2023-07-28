---
layout: documentation
title: 绘画动画组件
description: 绘画动画组件参考文档：包括球形精灵、画布、图像精灵。
---

[&laquo; 返回首页](index.html)
# <i class="mdi mdi-draw"></i>  绘画动画组件

目录：

* [球形精灵](#Ball)
* [画布](#Canvas)
* [图像精灵](#ImageSprite)

***
## 球形精灵  {#Ball}

可以放置在 [`画布`](#Canvas) 上的圆形“精灵”，它可以对触摸和拖动做出反应，
与其他精灵（[`图像精灵`](#ImageSprite) 和其他 `球形精灵`）及`画布`的边缘进行交互，并根据其属性值移动。

例如，让一个`球形精灵`每 500 毫秒（半秒）向`画布`的顶部移动 4 个像素，您可以将 [`速度`](#Ball.Speed) 属性设置为 4 [像素]，
[`间隔`](#Ball.Interval) 属性为 500 [毫秒]，[`方向`](#Ball.Heading) 属性为90 [度]，[`启用`](#Ball.Enabled) 属性为`真`{:.logic.block}。 
这些及其他属性可以随时更改。

`球形精灵` 和 `图像精灵` 的区别在于：`图像精灵`可以通过设置图像文件改变它的外观；
而`球形精灵`的外观只能改变其[`画笔颜色`](#Ball.PaintColor) 和 [`半径`](#Ball.Radius) 属性。


### 属性  {#Ball-Properties}

{:.properties}

{:id="Ball.Enabled" .boolean} *启用*
: 控制`球形精灵`在其速度非零时是否移动。

{:id="Ball.Heading" .number} *方向*
: `球形精灵` 在 x 轴方向上以度数表示的方向，图示如下：

 ![方向含义](images/direction.jpg)


{:id="Ball.Interval" .number} *间隔*
: 更新`球形精灵`位置的时间间隔（以毫秒为单位）。例如，如果`间隔` 为 50，[`速度`](#Ball.Speed) 为 10，则`球形精灵`将每50毫秒移动10个像素。

{:id="Ball.OriginAtCenter" .boolean .wo .do} *OriginAtCenter*
: Whether the x- and y-coordinates should represent the center of the `Ball`
 (`真`{:.logic.block}) or its left and top edges (`假`{:.logic.block}).

{:id="Ball.PaintColor" .color} *PaintColor*
: The color of the `Ball`.

{:id="Ball.Radius" .number} *Radius*
: The distance from the center of the `Ball` to its edge.

{:id="Ball.Speed" .number} *速度*
: `球形精灵`移动的速度。如果 [`启用`](#Ball.Enabled) 是`真`{:.logic.block}，`球形精灵`每隔[`间隔`](#Ball.Interval)毫秒移动的像素数量。

{:id="Ball.Visible" .boolean} *Visible*
: Sets whether sprite should be visible.

{:id="Ball.X" .number} *X*
: The horizontal coordinate of the `Ball`, increasing as the `Ball` moves right. If the property
 [`OriginAtCenter`](#Ball.OriginAtCenter) is true, the coordinate is for the center of the `Ball`;
 otherwise, it is for the leftmost point of the `Ball`.

{:id="Ball.Y" .number} *Y*
: The vertical coordinate of the `Ball`, increasing as the `Ball` moves down. If the property
 [`OriginAtCenter`](#Ball.OriginAtCenter) is true, the coordinate is for the center of the `Ball`
 otherwise, it is for the uppermost point of the `Ball`.

{:id="Ball.Z" .number} *Z*
: How the Ball should be layered relative to other Balls and ImageSprites, with higher-numbered layers in front of lower-numbered layers.

### 事件  {#Ball-Events}

{:.events}

{:id="Ball.CollidedWith"} CollidedWith(*other*{:.component})
: Event handler called when two enabled sprites ([`Ball`](#Ball)s or [`ImageSprite`](#ImageSprite)s)
 collide. Note that checking for collisions with a rotated `ImageSprite` currently
 checks against its unrotated position. Therefore, collision
 checking will be inaccurate for tall narrow or short wide sprites that are
 rotated.

{:id="Ball.Dragged"} Dragged(*startX*{:.number},*startY*{:.number},*prevX*{:.number},*prevY*{:.number},*currentX*{:.number},*currentY*{:.number})
: Event handler for Dragged events.  On all calls, the starting coordinates
 are where the screen was first touched, and the "current" coordinates
 describe the endpoint of the current line segment.  On the first call
 within a given drag, the "previous" coordinates are the same as the
 starting coordinates; subsequently, they are the "current" coordinates
 from the prior call. Note that the `Ball` won't actually move
 anywhere in response to the Dragged event unless
 [`MoveTo`](#Ball.MoveTo) is specifically called.

{:id="Ball.EdgeReached"} EdgeReached(*edge*{:.number})
: Event handler called when the `Ball` reaches an `edge`{:.variable.block} of the screen.
 If [`Bounce`](#Ball.Bounce) is then called with that edge, the sprite will appear to bounce off
 of the edge it reached. Edge here is represented as an integer that indicates one of eight
 directions north(1), northeast(2), east(3), southeast(4), south (-1), southwest(-2), west(-3),
 and northwest(-4).

{:id="Ball.Flung"} Flung(*x*{:.number},*y*{:.number},*speed*{:.number},*heading*{:.number},*xvel*{:.number},*yvel*{:.number})
: When a fling gesture (quick swipe) is made on the sprite: provides
 the (x,y) position of the start of the fling, relative to the upper
 left of the canvas. Also provides the speed (pixels per millisecond) and heading
 (0-360 degrees) of the fling, as well as the x velocity and y velocity
 components of the fling's vector.

{:id="Ball.NoLongerCollidingWith"} NoLongerCollidingWith(*other*{:.component})
: Event indicating that a pair of sprites are no longer colliding.

{:id="Ball.TouchDown"} TouchDown(*x*{:.number},*y*{:.number})
: When the user begins touching the sprite (places finger on sprite and
 leaves it there): provides the (x,y) position of the touch, relative
 to the upper left of the canvas

{:id="Ball.TouchUp"} TouchUp(*x*{:.number},*y*{:.number})
: When the user stops touching the sprite (lifts finger after a
 TouchDown event): provides the (x,y) position of the touch, relative
 to the upper left of the canvas.

{:id="Ball.Touched"} Touched(*x*{:.number},*y*{:.number})
: When the user touches the sprite and then immediately lifts finger: provides
 the (x,y) position of the touch, relative to the upper left of the canvas.

### 方法  {#Ball-Methods}

{:.methods}

{:id="Ball.Bounce" class="method"} <i/> Bounce(*edge*{:.number})
: Makes this `Ball` bounce, as if off a wall. For normal bouncing, the `edge` argument should
 be the one returned by [`EdgeReached`](#Ball.EdgeReached).

{:id="Ball.CollidingWith" class="method returns boolean"} <i/> CollidingWith(*other*{:.component})
: Indicates whether a collision has been registered between this `Ball`
 and the passed `other` sprite.

{:id="Ball.MoveIntoBounds" class="method"} <i/> MoveIntoBounds()
: Moves the sprite back in bounds if part of it extends out of bounds,
 having no effect otherwise. If the sprite is too wide to fit on the
 canvas, this aligns the left side of the sprite with the left side of the
 canvas. If the sprite is too tall to fit on the canvas, this aligns the
 top side of the sprite with the top side of the canvas.

{:id="Ball.MoveTo" class="method"} <i/> MoveTo(*x*{:.number},*y*{:.number})
: Sets the `x` and `y` coordinates of the `Ball`. If [`OriginAtCenter`](#Ball.OriginAtCenter) is true,
 the center of the `Ball` will be placed here. Otherwise, the top left edge of the `Ball` will
 be placed at the specified coordinates.

{:id="Ball.MoveToPoint" class="method"} <i/> MoveToPoint(*coordinates*{:.list})
: Moves the Ball so that its origin is at the specified x and y coordinates.

{:id="Ball.PointInDirection" class="method"} <i/> PointInDirection(*x*{:.number},*y*{:.number})
: Turns this `Ball` to point toward the point with the coordinates `(x, y)`.

{:id="Ball.PointTowards" class="method"} <i/> PointTowards(*target*{:.component})
: Turns this `Ball` to point towards a given `target` sprite. The new heading will be parallel
 to the line joining the centerpoints of the two sprites.

***
## 画布  {#Canvas}

A two-dimensional touch-sensitive rectangular panel on which drawing can
 be done and sprites can be moved.

 The [`BackgroundColor`](#Canvas.BackgroundColor), [`PaintColor`](#Canvas.PaintColor), [`BackgroundImage`](#Canvas.BackgroundImage),
 [`Width`](#Canvas.Width), and [`Height`](#Canvas.Height) of the `Canvas` can be set in either the Designer or in
 the Blocks Editor. The `Width` and `Height` are measured in pixels and must be positive.

 Any location on the `Canvas` can be specified as a pair of `(X, Y)` values, where

 * X is the number of pixels away from the left edge of the `Canvas`
 * Y is the number of pixels away from the top edge of the `Canvas`

 There are events to tell when and where a `Canvas` has been touched or a Sprite
 ([`ImageSprite`](#ImageSprite) or [`Ball`](#Ball)) has been dragged. There are also methods for drawing
 points, lines, circles, shapes, arcs, and text.



### 属性  {#Canvas-Properties}

{:.properties}

{:id="Canvas.BackgroundColor" .color} *BackgroundColor*
: Specifies the Canvas's background color as an alpha-red-green-blue
 integer, i.e., `0xAARRGGBB`.  An alpha of `00`
 indicates fully transparent and `FF` means opaque.
 The background color only shows if there is no background image.

{:id="Canvas.BackgroundImage" .text} *BackgroundImage*
: Specifies the name of a file containing the background image for the `Canvas`.

{:id="Canvas.BackgroundImageinBase64" .text .wo .bo} *BackgroundImageinBase64*
: Set the background image in Base64 format. This requires API level >= 8. For devices with API level less than 8, setting this will end up with an empty background.

{:id="Canvas.ExtendMovesOutsideCanvas" .boolean} *ExtendMovesOutsideCanvas*
: Determines whether moves can extend beyond the canvas borders.   Default is false. This should normally be false, and the property is provided for backwards compatibility.

{:id="Canvas.FontSize" .number} *字体大小*
: 指定画布上绘制的文本的字体大小。

{:id="Canvas.Height" .number .bo} *高度*
: 设置`画布`的垂直高度，以像素px为单位。

{:id="Canvas.HeightPercent" .number .wo .bo} *高度百分比*
: 设置`画布`的垂直高度相对于整个[`屏幕高度`](userinterface.html#Screen.Height)的百分比。

{:id="Canvas.LineWidth" .number} *LineWidth*
: Specifies the width of lines drawn on the Canvas.

{:id="Canvas.PaintColor" .color} *PaintColor*
: Specifies the paint color as an alpha-red-green-blue integer,
 i.e., `0xAARRGGBB`.  An alpha of `00` indicates fully
 transparent and `FF` means opaque.

{:id="Canvas.TapThreshold" .number} *TapThreshold*
: Specifies the movement threshold to differentiate a drag from a tap.

{:id="Canvas.TextAlignment" .number} *TextAlignment*
: Specifies the alignment of the canvas's text: center, normal
 (starting at the specified point in [`DrawText`](#Canvas.DrawText) or
 [`DrawTextAtAngle`](#Canvas.DrawTextAtAngle)),
 or opposite (ending at the specified point in
 [`DrawText`](#Canvas.DrawText) or
 [`DrawTextAtAngle`](#Canvas.DrawTextAtAngle)).

{:id="Canvas.Visible" .boolean} *可见性*
: 设置`画布`是否显示在屏幕上，值是`真`{:.logic.block}则`画布`显示，`假`{:.logic.block}则隐藏。

{:id="Canvas.Width" .number .bo} *宽度*
: 设置`画布`的水平宽度，以像素px为单位。

{:id="Canvas.WidthPercent" .number .wo .bo} *宽度百分比*
: 设置`画布`的水平宽度相对于[`屏幕宽度`](userinterface.html#Screen.Width)的百分比。

### 事件  {#Canvas-Events}

{:.events}

{:id="Canvas.Dragged"} Dragged(*startX*{:.number},*startY*{:.number},*prevX*{:.number},*prevY*{:.number},*currentX*{:.number},*currentY*{:.number},*draggedAnySprite*{:.boolean})
: When the user does a drag from one point (prevX, prevY) to
 another (x, y).  The pair (startX, startY) indicates where the
 user first touched the screen, and "draggedAnySprite" indicates whether a
 sprite is being dragged.

{:id="Canvas.Flung"} Flung(*x*{:.number},*y*{:.number},*speed*{:.number},*heading*{:.number},*xvel*{:.number},*yvel*{:.number},*flungSprite*{:.boolean})
: When a fling gesture (quick swipe) is made on the canvas: provides
 the (x,y) position of the start of the fling, relative to the upper
 left of the canvas. Also provides the speed (pixels per millisecond) and heading
 (0-360 degrees) of the fling, as well as the x velocity and y velocity
 components of the fling's vector. The value "flungSprite" is true if a sprite
 was located near the the starting point of the fling gesture.

{:id="Canvas.TouchDown"} TouchDown(*x*{:.number},*y*{:.number})
: When the user begins touching the canvas (places finger on canvas and
 leaves it there): provides the (x,y) position of the touch, relative
 to the upper left of the canvas

{:id="Canvas.TouchUp"} TouchUp(*x*{:.number},*y*{:.number})
: When the user stops touching the canvas (lifts finger after a
 TouchDown event): provides the (x,y) position of the touch, relative
 to the upper left of the canvas

{:id="Canvas.Touched"} Touched(*x*{:.number},*y*{:.number},*touchedAnySprite*{:.boolean})
: When the user touches the canvas and then immediately lifts finger: provides
 the (x,y) position of the touch, relative to the upper left of the canvas.  TouchedAnySprite
 is true if the same touch also touched a sprite, and false otherwise.

### 方法  {#Canvas-Methods}

{:.methods}

{:id="Canvas.Clear" class="method"} <i/> 清除画布()
: 清除画布，但不删除背景图像（如果设置了的话）。

{:id="Canvas.DrawArc" class="method"} <i/> DrawArc(*left*{:.number},*top*{:.number},*right*{:.number},*bottom*{:.number},*startAngle*{:.number},*sweepAngle*{:.number},*useCenter*{:.boolean},*fill*{:.boolean})
: Draw an arc on Canvas, by drawing an arc from a specified oval (specified by left, top, right & bottom).
 Start angle is 0 when heading to the right, and increase when rotate clockwise.
 When useCenter is true, a sector will be drawed instead of an arc.
 When fill is true, a filled arc (or sector) will be drawed instead of just an outline.

{:id="Canvas.DrawCircle" class="method"} <i/> DrawCircle(*centerX*{:.number},*centerY*{:.number},*radius*{:.number},*fill*{:.boolean})
: Draws a circle (filled in) with the given radius centered at the given coordinates on the
 Canvas.

{:id="Canvas.DrawLine" class="method"} <i/> 画线(*x1*{:.number},*y1*{:.number},*x2*{:.number},*y2*{:.number})
: 在画布上给定坐标之间(从x1,y1点到x2,y2点)绘制一条线。

  典型用法参考（实现画笔绘画功能）：

  ![画布画线](images/画布画线.png)

{:id="Canvas.DrawPoint" class="method"} <i/> DrawPoint(*x*{:.number},*y*{:.number})
: Draws a point at the given coordinates on the canvas.

{:id="Canvas.DrawShape" class="method"} <i/> DrawShape(*pointList*{:.list},*fill*{:.boolean})
: Draws a shape on the canvas.
 pointList should be a list contains sub-lists with two number which represents a coordinate.
 The first point and last point does not need to be the same. e.g. ((x1 y1) (x2 y2) (x3 y3))
 When fill is true, the shape will be filled.

{:id="Canvas.DrawText" class="method"} <i/> DrawText(*text*{:.text},*x*{:.number},*y*{:.number})
: Draws the specified text relative to the specified coordinates
 using the values of the [`FontSize`](#Canvas.FontSize) and
 [`TextAlignment`](#Canvas.TextAlignment) properties.

{:id="Canvas.DrawTextAtAngle" class="method"} <i/> DrawTextAtAngle(*text*{:.text},*x*{:.number},*y*{:.number},*angle*{:.number})
: Draws the specified text starting at the specified coordinates
 at the specified angle using the values of the [`FontSize`](#Canvas.FontSize) and
 [`TextAlignment`](#Canvas.TextAlignment) properties.

{:id="Canvas.GetBackgroundPixelColor" class="method returns color"} <i/> GetBackgroundPixelColor(*x*{:.number},*y*{:.number})
: Gets the color of the given pixel, ignoring sprites.

{:id="Canvas.GetPixelColor" class="method returns color"} <i/> GetPixelColor(*x*{:.number},*y*{:.number})
: Gets the color of the given pixel, including sprites.

{:id="Canvas.Save" class="method returns text"} <i/> 保存()
: 将此画布的图片（包括背景图像和绘制内容）保存到设备的外部存储(file:///)中。如果发生错误，屏幕的 ErrorOccurred 事件将被调用。

  此函数的`返回值`是已保存的图片的路径。

{:id="Canvas.SaveAs" class="method returns text"} <i/> 另存为...(*文件名*{:.text})
: 将此画布的图片以指定的文件名保存到设备的外部存储文件中，文件名必须以“.jpg”、“.jpeg”或“.png”之一结尾（文件类型：JPEG 或 PNG）。

{:id="Canvas.SetBackgroundPixelColor" class="method"} <i/> SetBackgroundPixelColor(*x*{:.number},*y*{:.number},*color*{:.color})
: Sets the color of the given pixel.  This has no effect if the
 coordinates are out of bounds.

***
## 图像精灵  {#ImageSprite}

A 'sprite' that can be placed on a [`Canvas`](#Canvas), where it can react to touches and drags,
 interact with other sprites ([`Ball`](#Ball)s and other `ImageSprite`s) and the edge of the
 `Canvas`, and move according to its property values. Its appearance is that of the image
 specified in its [`Picture`](#ImageSprite.Picture) property (unless its [`Visible`](#ImageSprite.Visible) property is
 `假`{:.logic.block}.

 To have an `ImageSprite` move 10 pixels to the left every 1000 milliseconds (one second), for
 example, you would set the [`Speed`](#ImageSprite.Speed) property to 10 [pixels], the [`Interval`](#ImageSprite.Interval)
 property to 1000 [milliseconds], the [`Heading`](#ImageSprite.Heading) property to 180 [degrees], and the
 [`Enabled`](#ImageSprite.Enabled) property to `真`{:.logic.block}. A sprite whose [`Rotates`](#ImageSprite.Rotates)
 property is `真`{:.logic.block} will rotate its image as the sprite's heading changes.
 *Checking for collisions with a rotated sprite currently checks the sprite's unrotated position
 so that collision checking will be inaccurate for tall narrow or short wide sprites that are
 rotated.* Any of the sprite properties can be changed at any time under program control.



### 属性  {#ImageSprite-Properties}

{:.properties}

{:id="ImageSprite.Enabled" .boolean} *Enabled*
: Controls whether the `ImageSprite` moves when its speed is non-zero.

{:id="ImageSprite.Heading" .number} *Heading*
: The `ImageSprite`'s heading in degrees above the positive x-axis. Zero degrees is toward the right
 of the screen; 90 degrees is toward the top of the screen.

{:id="ImageSprite.Height" .number .bo} *Height*
: The height of the ImageSprite in pixels.

{:id="ImageSprite.Interval" .number} *Interval*
: The interval in milliseconds at which the `ImageSprite`'s position is updated. For example, if the
 `Interval` is 50 and the [`Speed`](#ImageSprite.Speed) is 10, then the `ImageSprite` will move 10 pixels
 every 50 milliseconds.

{:id="ImageSprite.Picture" .text} *Picture*
: Specifies the path of the sprite's picture.

{:id="ImageSprite.Rotates" .boolean} *Rotates*
: If true, the sprite image rotates to match the sprite's heading. If false, the sprite image
 does not rotate when the sprite changes heading. The sprite rotates around its centerpoint.

{:id="ImageSprite.Speed" .number} *Speed*
: The speed at which the `ImageSprite` moves. The `ImageSprite` moves this many pixels every
 [`Interval`](#ImageSprite.Interval) milliseconds if [`Enabled`](#ImageSprite.Enabled) is `真`{:.logic.block}.

{:id="ImageSprite.Visible" .boolean} *Visible*
: Sets whether sprite should be visible.

{:id="ImageSprite.Width" .number .bo} *Width*
: The width of the ImageSprite in pixels.

{:id="ImageSprite.X" .number} *X*
: The horizontal coordinate of the left edge of the ImageSprite, increasing as the ImageSprite moves right.

{:id="ImageSprite.Y" .number} *Y*
: The vertical coordinate of the top edge of the ImageSprite, increasing as the ImageSprite moves down.

{:id="ImageSprite.Z" .number} *Z*
: How the ImageSprite should be layered relative to other Balls and ImageSprites, with higher-numbered layers in front of lower-numbered layers.

### 事件  {#ImageSprite-Events}

{:.events}

{:id="ImageSprite.CollidedWith"} CollidedWith(*other*{:.component})
: Event handler called when two enabled sprites ([`Ball`](#Ball)s or [`ImageSprite`](#ImageSprite)s)
 collide. Note that checking for collisions with a rotated `ImageSprite` currently
 checks against its unrotated position. Therefore, collision
 checking will be inaccurate for tall narrow or short wide sprites that are
 rotated.

{:id="ImageSprite.Dragged"} Dragged(*startX*{:.number},*startY*{:.number},*prevX*{:.number},*prevY*{:.number},*currentX*{:.number},*currentY*{:.number})
: Event handler for Dragged events.  On all calls, the starting coordinates
 are where the screen was first touched, and the "current" coordinates
 describe the endpoint of the current line segment.  On the first call
 within a given drag, the "previous" coordinates are the same as the
 starting coordinates; subsequently, they are the "current" coordinates
 from the prior call. Note that the `ImageSprite` won't actually move
 anywhere in response to the Dragged event unless
 [`MoveTo`](#ImageSprite.MoveTo) is specifically called.

{:id="ImageSprite.EdgeReached"} EdgeReached(*edge*{:.number})
: Event handler called when the `ImageSprite` reaches an `edge`{:.variable.block} of the screen.
 If [`Bounce`](#ImageSprite.Bounce) is then called with that edge, the sprite will appear to bounce off
 of the edge it reached. Edge here is represented as an integer that indicates one of eight
 directions north(1), northeast(2), east(3), southeast(4), south (-1), southwest(-2), west(-3),
 and northwest(-4).

{:id="ImageSprite.Flung"} Flung(*x*{:.number},*y*{:.number},*speed*{:.number},*heading*{:.number},*xvel*{:.number},*yvel*{:.number})
: When a fling gesture (quick swipe) is made on the sprite: provides
 the (x,y) position of the start of the fling, relative to the upper
 left of the canvas. Also provides the speed (pixels per millisecond) and heading
 (0-360 degrees) of the fling, as well as the x velocity and y velocity
 components of the fling's vector.

{:id="ImageSprite.NoLongerCollidingWith"} NoLongerCollidingWith(*other*{:.component})
: Event indicating that a pair of sprites are no longer colliding.

{:id="ImageSprite.TouchDown"} TouchDown(*x*{:.number},*y*{:.number})
: When the user begins touching the sprite (places finger on sprite and
 leaves it there): provides the (x,y) position of the touch, relative
 to the upper left of the canvas

{:id="ImageSprite.TouchUp"} TouchUp(*x*{:.number},*y*{:.number})
: When the user stops touching the sprite (lifts finger after a
 TouchDown event): provides the (x,y) position of the touch, relative
 to the upper left of the canvas.

{:id="ImageSprite.Touched"} Touched(*x*{:.number},*y*{:.number})
: When the user touches the sprite and then immediately lifts finger: provides
 the (x,y) position of the touch, relative to the upper left of the canvas.

### 方法  {#ImageSprite-Methods}

{:.methods}

{:id="ImageSprite.Bounce" class="method"} <i/> Bounce(*edge*{:.number})
: Makes this `ImageSprite` bounce, as if off a wall. For normal bouncing, the `edge` argument should
 be the one returned by [`EdgeReached`](#ImageSprite.EdgeReached).

{:id="ImageSprite.CollidingWith" class="method returns boolean"} <i/> CollidingWith(*other*{:.component})
: Indicates whether a collision has been registered between this `ImageSprite`
 and the passed `other` sprite.

{:id="ImageSprite.MoveIntoBounds" class="method"} <i/> MoveIntoBounds()
: Moves the sprite back in bounds if part of it extends out of bounds,
 having no effect otherwise. If the sprite is too wide to fit on the
 canvas, this aligns the left side of the sprite with the left side of the
 canvas. If the sprite is too tall to fit on the canvas, this aligns the
 top side of the sprite with the top side of the canvas.

{:id="ImageSprite.MoveTo" class="method"} <i/> MoveTo(*x*{:.number},*y*{:.number})
: Moves the ImageSprite so that its left top corner is at the specified `x` and `y` coordinates.

{:id="ImageSprite.MoveToPoint" class="method"} <i/> MoveToPoint(*coordinates*{:.list})
: Moves the ImageSprite so that its origin is at the specified x and y coordinates.

{:id="ImageSprite.PointInDirection" class="method"} <i/> PointInDirection(*x*{:.number},*y*{:.number})
: Turns this `ImageSprite` to point toward the point with the coordinates `(x, y)`.

{:id="ImageSprite.PointTowards" class="method"} <i/> PointTowards(*target*{:.component})
: Turns this `ImageSprite` to point towards a given `target` sprite. The new heading will be parallel
 to the line joining the centerpoints of the two sprites.
