---
layout: documentation
title: 任何组件块
description: 编写应用程序时的一个常见概念是“不要重复自己”（或 DRY）。与其制作大量重复代码，例如通过复制和粘贴，不如使用称为“任何组件”块的特殊块。
---

编写应用程序时的一个常见概念是“不要重复自己”（或 DRY）。与其制作大量重复代码，例如通过复制和粘贴，不如使用称为“任何组件”块的特殊块。

“任何组件”块到底是什么？ 

每一个组件块，比如<span class="setter block">设置 按钮1.文本 为</span>，都包含三个部分：
（1）被改变的组件（<span class="component block">按钮1</span>），（2）被操作的组件部分（<span class="setter block">设置 ....文本 为</span>）和 (3) 输入（如果有）。 

在编写应用程序代码时，通常会从组件面板中拖动组件命名为单个组件，但是如果您想对<strong><em>同一类型</em></strong> 的许多不同组件执行操作怎么办？ 
 一种选择是根据需要多次复制和粘贴每个块，但随着您的应用程序扩展，这将变得难以编辑。 
 相反，能够用不同的组件代替单个组件可能是有意义的。 这就是“任何组件”块允许您执行的操作。 
 它们不是将块固定到特定组件，而是允许您通过提供相同类型的任何组件作为输入来使您的代码更通用。 
 例如，这允许您创建一个按钮列表并使用 <span class="control block">for-each</span> 循环一次更新它们的所有属性，例如：

{:.figure}
![隐藏列表中所有按钮](loop-example.png)

{:.caption}
**Figure 1.** 使用循环隐藏列表中所有按钮的例子

Each of the three major component block types, i.e., events, methods, and properties, have corresponding "any component" blocks.

## Properties

The "any component" blocks for properties are the simplest versions of any component blocks. Property getters, like the one shown below, take a single component and return the value of the named property for that component. Property setters take an additional argument, which is the new value of the property.

{:.figure}
![Getter block to get the Text property of a button called ExampleButton](getter.png)
<br />
![Setter block to set the Enabled property of a button called ExampleButton to false](setter.png)

{:.caption}
**Figure 2.** Example blocks for the any property getters and setters.

## Methods

Any component method blocks function similar to the property getters and setters. For any given method on a component, the corresponding any component block will take a component and all of the parameters needed by the method. The block will have the same output as the specific method block (if any). For example, below is a method block to compute the distance from a Marker to the user's current location on a Map.

{:.figure}
![Computes the distance from the user's current location to a marker provided in the variable called feature](method.png)

{:.caption}
**Figure 3.** Example use of a method block that takes any marker and computes the distance to it from the user's current location.

## Events

Any component events are the most complex form of an any component block. For any given event, the corresponding any component event adds two more parameters, <span class="variable block">component</span> and <span class="variable block">notAlreadyHandled</span>, to the existing list of event parameters, if any. The <span class="variable block">component</span> parameter will be the component that triggered the event, such as <span class="component block">Button</span>. The <span class="variable block">notAlreadyHandled</span> parameter is <span class="logic block">true</span> if no other event block specifically handles the event for <span class="variable block">component</span>.

Consider the following pseudocode for event handling to see how this works:

1. An event occurs, such as the user clicks a button called Button1.
2. <span class="variable block">component</span> is initialized to <span class="getter block">Button1</span>.
3. <span class="variable block">notAlreadyHandled</span> is initialized to <span class="logic block">true</span>.
4. App Inventor checks to see if <span class="event block">when Button1.Click</span> exists.
5. If the event block is found:
    1. The event block code is run.
    2. <span class="variable block">notAlreadyHandled</span> is set to <span class="logic block">false</span>.
6. App Inventor checks to see if <span class="event block">when any Button.Click</span> exists.
7. If the any event block is found, the event block code is run with <span class="variable block">component</span> and <span class="variable block">notAlreadyHandled</span> passed to it.


## Tips & Tricks

There are a number of things you can do with any component blocks. Here are some tips and tricks to get the most out of any component blocks.

### Lists of Components

You can <span class="list block">make a list</span> of components using global variables. This makes it easy to reference large sets of components through a single list and apply changes using the <span class="control block">for-each</span> block.

{:.figure}
![Creates a variable called listOfButtons with Button1 through Button5 added](list-of-components.png)

{:.caption}
**Figure 4.** The global variable <span class="variable block">listOfButtons</span> is set to a list of button components.

### Swap Blocks

You can swap between a block for a specific component and the equivalent any component block through the "Make Generic" and "Make Specific" menu items in a block's right click (context) menu. "Make Generic" will convert a block for a specific component, e.g., <span class="setter block">set Button1.Enabled to</span>, into a any component block, e.g., <span class="setter block">set Button.Enabled of component</span> with the corresponding component block, e.g., <span class="component block">Button1</span>. In order to use the "Make Specific" menu item, the "of component" slot must be filled with a specific component, e.g., <span class="component block">Button1</span>, and not another type of block. This feature is available for property setters, property getters, and methods.

{:.figure}
![Right-click on a block to get the context menu, and select Make Generic to turn it into the equivalent any component blocks.](specific-block.png) ![The any component form of the previous block.](setter.png)

{:.caption}
**Figure 5.** A demonstration of how blocks can be transformed from a specific to generic versions using the right click (context) menu.

### Any Component Events

Unlike the operation to turn properties and methods into their any component versions, turning a component event handler into an any component event using "Make Generic" is a one-way operation (it can be undone using the Undo option, however). When using this feature, all references to the component will be replaced with any component versions.

{:.figure}
![An event handler for Button1.Click that changes a number of properties of Button1](any-event-example-a.png)<br>
![A generic event handler for any Button.Click that performs the same operations as above, but to any Button not just Button1](any-event-example-b.png)

{:.caption}
**Figure 6.** Top: A <span class="event block">when Button1.Click</span> event that changes a number of Button1's properties. Bottom: After using the "Make Generic" menu option (bottom), the <span class="event block">when Button1.Click</span> event is replaced with a <span class="event block">when any Button.Click</span> event, and all blocks that reference Button1 are replaced with <span class="variable block">component</span>.

## Examples

### Snow Globe

In a snow globe app, you might use many Ball sprites on a Canvas to represent snowflakes in the snow globe. You may want them to disappear when they reach the edge of the screen. Previously, you would have to create a <span class="event block">when Ball_XX_.EdgeReached</span> for each snowflake to make this happen. With the <span class="event block">when any Ball.EdgeReached</span> event, you only need to write the code once:

![Old code with many event handlers all doing the same thing](snowglobe-specific.png){:.figure width="750px"}<br>
![New code with a single any ball edge reached handler replacing the repetitive code above](snowglobe-generic.png){:.figure}<br>

{:.caption}
**Figure 7.** Top: Repetitive event handlers before the use of the generic event handler. Bottom: All of the code reduces to a single event handler, saving space and time coding.

### Random Button Colors

This event block demonstrates any component events and property setters.

{:.figure}
![An event handler to change any button's background color when it is clicked](random-colors.png)

{:.caption}
**Figure 8.** An event handler to change any button's background color when it is clicked.

### Distance to Nearest Feature

Given a Map with a number of Markers, find the distance to the Marker nearest the user with the <span class="procedure block">call Marker.DistanceToPoint</span> block:

{:.figure}
![Example code to determine the distance to the nearest Marker on a Map given the user's current location](method-example.png)

{:.caption}
**Figure 9.** An example of how to find the closest Marker on a Map to the user's current location.
