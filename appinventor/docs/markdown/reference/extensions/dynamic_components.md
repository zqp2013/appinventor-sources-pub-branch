---
title: App Inventor 2 DynamicComponents 拓展：动态创建AI2组件对象
layout: documentation
description: App Inventor 2 DynamicComponents 拓展：动态创建AI2组件对象。
---

* TOC
{:toc}

[&laquo; 返回首页](index.html)

## <img src="DynamicComponents/icon.png" style="width:16px;margin:-4px 5px 0 0">DynamicComponents 拓展  {#DynamicComponents}
<!--(https://community.kodular.io/t/f-os-dynamic-components-extension-for-every-component-2-2-2/50789,https://github.com/ysfchn/DynamicComponents-AI2)-->

* .aix 拓展下载：

{:.vip}
[com.yusufcihan.DynamicComponents.aix](DynamicComponents/com.yusufcihan.DynamicComponents.aix)


**完全支持 App Inventor 2 的动态组件扩展。它基于 Java 的反射功能，因此只需键入类名称即可搜索类来创建组件。因此，它对特定组件的支持不受限制，因为它支持添加到 App Inventor 发行版中的每个组件！**

此扩展可以根据你的选择异步或同步创建组件。如果你不想在创建一堆组件期间阻止主应用程序，请转到设计视图（导入扩展后）并在“UI”（异步）和“Main”（同步）之间进行选择。


<table style="width:100%">
    <tr>
        <th width="30%">Block</th>
        <th>Description</th>
    </tr>
    <!-- CREATE  -->
    <tr>
        <td align="right">
            <img src="DynamicComponents/blocks/method_create.png">
        </td>
        <!--<td>
            <table style="width:100%">
                <tr>
                    <td align="right"><code>in</code></td>
                    <td>The arrangement where component will be created in.</td>
                </tr>
                <tr>
                    <td align="right"><code>componentName</code></td>
                    <td>Specifies which component will be created, it can take these values, use one of these:<br>・ Name of the component. <img src="DynamicComponents/blocks/text.png"><br>・ Block of existing component to create new one from it. <img src="DynamicComponents/blocks/component_block.png"><br>・ Full class name of the component. <img src="DynamicComponents/blocks/class_text.png"></td>
                </tr>
                <tr>
                    <td align="right"><code>id</code></td>
                    <td>An identifier that will be used for other methods. It can be any type of text.</td>
                </tr>
            </table>
        </td>-->
        <td>
            Creates a new dynamic component. It supports all component that added to your current AI2 distribution.
            <code>componentName</code> parameter can have these values:
            <br><br>
            <table>
                <tr>
                    <td><img src="DynamicComponents/other/text.png"></td>
                    <td><b>Name of the component.</b><br>✅ Doesn't require to add existing component.<br> ❌ Only components can be created.</td>
                </tr>
                <tr>
                    <td><img src="DynamicComponents/other/component_block.png"></td>
                    <td><b>Block of existing component to create new one from it.</b><br>❌ Requires a existing component.<br>✅ Extensions can be created also.</td>
                </tr>
                <tr>
                    <td><img src="DynamicComponents/other/class_text.png" href="DynamicComponents/other/class_text_full.png"></td></td>
                    <td><b>Full class name of the component.</b><br>✅ Doesn't require to add existing component.<br>✅ Extensions can be created also.<br><br>To learn the class name of the component use <code>GetName</code> block.</td>
                </tr>
            </table>
        </td>
    </tr>
    <!-- CHANGE ID  -->
    <tr>
        <td align="right">
            <img src="DynamicComponents/blocks/method_changeid.png">
        </td>
        <!--<td>
            <table style="width:100%">
                <tr>
                    <td align="right"><code>id</code></td>
                    <td>The old ID that will be changed.</td>
                </tr>
                <tr>
                    <td align="right"><code>newid</code></td>
                    <td>The new ID that old ID will be changed to.</td>
                </tr>
            </table>
        </td>-->
        <td>
            Changes ID of one of created components to a new one. The old ID must be exist and new ID mustn't exist.<br>
            <blockquote>
                When replacing an ID, it will loop through ALL IDs and replace each one that contains the old ID! Even if the ID you're wanting to replace is "Timmy", but there are IDs like "Timmy-truck". To be clear again, only "Timmy" from "Timmy-truck" will be replaced, the "-truck" part will stay the same!
            </blockquote>
        </td>
    </tr>
    <!-- SCHEMA  -->
    <tr>
        <td align="right">
            <img src="DynamicComponents/blocks/method_schema.png">
        </td>
        <!--<td>
            <table style="width:100%">
                <tr>
                    <td align="right"><code>in</code></td>
                    <td>The arrangement where the root component will the created in.</td>
                </tr>
                <tr>
                    <td align="right"><code>template</code></td>
                    <td>JSON string of your template.</td>
                </tr>
                <tr>
                    <td align="right"><code>parameters</code></td>
                    <td>Parameters that will be used in template.</td>
                </tr>
            </table>
        </td>-->
        <td>
            Creates components from JSON string. Refer to the <a href="https://github.com/ysfchn/DynamicComponents-AI2/wiki/Creating-Templates">Wiki</a> about creating your own templates.
        </td>
    </tr>
    <!-- REMOVE  -->
    <tr>
        <td align="right">
            <img src="DynamicComponents/blocks/method_remove.png">
        </td>
        <!--<td>
            <table style="width:100%">
                <tr>
                    <td align="right"><code>id</code></td>
                    <td>The ID of the component that will be deleted.</td>
                </tr>
            </table>
        </td>-->
        <td>
            Removes the component with specified ID from screen/layout and the component list. So you will able to use its ID again as it will be deleted.
        </td>
    </tr>
    <!-- SET PROPERTY  -->
    <tr>
        <td align="right">
            <img src="DynamicComponents/blocks/method_setproperty.png">
        </td>
        <!--<td>
            <table style="width:100%">
                <tr>
                    <td align="right"><code>component</code></td>
                    <td>The component that will be modified.</td>
                </tr>
                <tr>
                    <td align="right"><code>name</code></td>
                    <td>Name of the property.</td>
                </tr>
                <tr>
                    <td align="right"><code>value</code></td>
                    <td>Value of the property.</td>
                </tr>
            </table>
        </td>-->
        <td>
            Set a property of a component by typing its property name. Can be known as a Setter property block.<br>
            It can be also used to set properties that only exists in Designer. 
            It works for common types. For other values, you should use Any Component blocks.
        </td>
    </tr>
    <!-- SET PROPERTIES  -->
    <tr>
        <td align="right">
            <img src="DynamicComponents/blocks/method_setproperties.png">
        </td>
        <!--<td>
            <table style="width:100%">
                <tr>
                    <td align="right"><code>component</code></td>
                    <td>The component that will be modified.</td>
                </tr>
                <tr>
                    <td align="right"><code>name</code></td>
                    <td>Name of the property.</td>
                </tr>
                <tr>
                    <td align="right"><code>value</code></td>
                    <td>Value of the property.</td>
                </tr>
            </table>
        </td>-->
        <td>
            Same as SetProperty block, but for setting the properties with Dictionary.<br>
            Dictionary keys equal to property names and Dictionary values equal to property value.
        </td>
    </tr>
    <!-- GET COMPONENT  -->
    <tr>
        <td align="right">
            <img src="DynamicComponents/blocks/method_getcomponent.png">
        </td>
        <!--<td>
            <table style="width:100%">
                <tr>
                    <td align="right"><code>id</code></td>
                    <td>The ID of the component that you want to get.</td>
                </tr>
            </table>
        </td>-->
        <td>
            Returns the component's itself for modifying purposes. 
            ID must be a valid ID which is added with Create block.<br>
            ID --> Component
        </td>
    </tr>
    <!-- GET ID  -->
    <tr>
        <td align="right">
            <img src="DynamicComponents/blocks/method_getid.png">
        </td>
        <!--<td>
            <table style="width:100%">
                <tr>
                    <td align="right"><code>component</code></td>
                    <td>The component that you want to get its ID.</td>
                </tr>
            </table>
        </td>-->
        <td>
            Returns the ID of component. Component needs to be created by Create block. 
            Otherwise it will return blank string. Also known as reverse of the GetComponent block.<br>
            Component --> ID
        </td>
    </tr>
    <!-- GET ORDER  -->
    <tr>
        <td align="right">
            <img src="DynamicComponents/blocks/method_getorder.png">
        </td>
        <!--<td>
            <table style="width:100%">
                <tr>
                    <td align="right"><code>component</code></td>
                    <td>The component that property value will get from.</td>
                </tr>
                <tr>
                    <td align="right"><code>name</code></td>
                    <td>Name of the property.</td>
                </tr>
            </table>
        </td>-->
        <td>
            Gets the position of the component according to its parent arrangement.
            Index starts from 1.
        </td>
    </tr>
    <!-- SET ORDER  -->
    <tr>
        <td align="right">
            <img src="DynamicComponents/blocks/method_setorder.png">
        </td>
        <!--<td>
            <table style="width:100%">
                <tr>
                    <td align="right"><code>component</code></td>
                    <td>The component that property value will get from.</td>
                </tr>
                <tr>
                    <td align="right"><code>name</code></td>
                    <td>Name of the property.</td>
                </tr>
            </table>
        </td>-->
        <td>
            Sets the position of the component according to its parent arrangement.
            Index starts from 1.
            Typing 0 (zero) will move the component to the end.
        </td>
    </tr>
    <!-- MOVE  -->
    <tr>
        <td align="right">
            <img src="DynamicComponents/blocks/method_move.png">
        </td>
        <!--<td>
            <table style="width:100%">
                <tr>
                    <td align="right"><code>component</code></td>
                    <td>The component that property value will get from.</td>
                </tr>
                <tr>
                    <td align="right"><code>name</code></td>
                    <td>Name of the property.</td>
                </tr>
            </table>
        </td>-->
        <td>
            Moves the component to an another arrangement.
        </td>
    </tr>
    <!-- GET PROPERTY  -->
    <tr>
        <td align="right">
            <img src="DynamicComponents/blocks/method_getproperty.png">
        </td>
        <!--<td>
            <table style="width:100%">
                <tr>
                    <td align="right"><code>component</code></td>
                    <td>The component that property value will get from.</td>
                </tr>
                <tr>
                    <td align="right"><code>name</code></td>
                    <td>Name of the property.</td>
                </tr>
            </table>
        </td>-->
        <td>
            Get a property value of a component by typing its property name. Can be known as a Getter property block. It can be also used to get properties that only exists in Designer. 
        </td>
    </tr>
    <!-- GET COMPONENT META  -->
    <tr>
        <td align="right">
            <img src="DynamicComponents/blocks/method_getcomponentmeta.png">
        </td>
        <td>
            Get meta data about the specified component.
        </td>
    </tr>
    <!-- GET EVENT META  -->
    <tr>
        <td align="right">
            <img src="DynamicComponents/blocks/method_geteventmeta.png">
        </td>
        <td>
            Get meta data about events for the specified component.
        </td>
    </tr>
    <!-- GET PROPERTY META  -->
    <tr>
        <td align="right">
            <img src="DynamicComponents/blocks/method_getpropertymeta.png">
        </td>
        <td>
            Get meta data about properties for the specified component.
        </td>
    </tr>
    <!-- GET FUNCTION META  -->
    <tr>
        <td align="right">
            <img src="DynamicComponents/blocks/method_getfunctionmeta.png">
        </td>
        <td>
            Get meta data about functions for the specified component.
        </td>
    </tr>
    <!-- LAST USED ID  -->
    <tr>
        <td align="right">
            <img src="DynamicComponents/blocks/method_lastusedid.png">
        </td>
        <td>
            Returns the last component's ID.
        </td>
    </tr>
    <!-- USED IDS  -->
    <tr>
        <td align="right">
            <img src="DynamicComponents/blocks/method_usedids.png">
        </td>
        <td>
            Returns all used IDs of current components as App Inventor list.
        </td>
    </tr>
    <!-- GENERATE ID  -->
    <tr>
        <td align="right">
            <img src="DynamicComponents/blocks/method_generateid.png">
        </td>
        <td>
            Makes a random unique UUID. Use this block in Create block if component ID is not required for you.
        </td>
    </tr>
    <!-- IS DYNAMIC  -->
    <tr>
        <td align="right">
            <img src="DynamicComponents/blocks/method_isdynamic.png">
        </td>
        <td>
            Returns 'true' if component has created by Dynamic Components extension. Otherwise, 'false'.
        </td>
    </tr>
    <!-- INVOKE  -->
    <tr>
        <td align="right">
            <img src="DynamicComponents/blocks/method_invoke.png">
        </td>
        <td>
            Calls a method of any component. If the return value is not important for you, use with <code>evaluate but ignore result</code> block.
        </td>
    </tr>
    <!-- VERSION  -->
    <tr>
        <td align="right">
            <img src="DynamicComponents/blocks/setget_version.png">
        </td>
        <td>
            Returns the version of the extension.
        </td>
    </tr>
    <!-- VERSION NAME  -->
    <tr>
        <td align="right">
            <img src="DynamicComponents/blocks/setget_versionname.png">
        </td>
        <td>
            Returns the version name of the extension.
        </td>
    </tr>
    <!-- SCHEMA CREATED  -->
    <tr>
        <td align="right">
            <img src="DynamicComponents/blocks/event_schemacreated.png">
        </td>
        <td>
            Raises after Schema has been created with Schema block.
        </td>
    </tr>
    <!-- COMPONENT BUILT  -->
    <tr>
        <td align="right">
            <img src="DynamicComponents/blocks/event_componentbuilt.png">
        </td>
        <td>
            Raises after a component has been created.
        </td>
    </tr>
</table>


## FAQ
* How can I set the properties for the blocks?

  You have two options and both does the same job:

`SetProperty`
![](DynamicComponents/1.png)

or `Any Component`

![](DynamicComponents/2.png)

How can I delete all components?
Use a for-each loop for that.

![](DynamicComponents/3.png)

How can I make my own Schema template?
Thanks for being interested in making a JSON template for the extension. You can go to the Wiki section of Dynamic Component’s repository to learn how to create yours.
[Creating Templates - DynamicComponents-AI2 Wiki](https://github.com/ysfchn/DynamicComponents-AI2/wiki/Creating-Templates)

Is extension works asynchronously, or synchronously?
It works synchronously. I explained why it works synchronously in this post.
Now you can toggle between asynchronously or synchronously with the Thread property!

App takes a lot of time to create components that use Image components, how can I fix it?
Replace your existing set Image.Picture components with the Image Utilities component.
If you don’t use Kodular, you can use an extension to load images asynchronously.

How much time it takes to create components?
I created more than 10 000 components and calculated how many seconds will it take to finish creating. [Here are the benchmark results.](https://community.kodular.io/t/free-open-source-dynamic-components-extension-for-every-component/50789/945)

## Test

Just made an test app that creates a lot of Button components with a loop and calculates the execution time with Clock.

Test 1
Platform: Companion / Kodular
Measured with: inbuilt Clock component
Created: “Button” component with default properties

Component Count	Created in (as seconds)	Created in (as milliseconds)
100	0 sec	535 ms
200	1 sec	1387 ms
500	3 secs	3718 ms
1000	6 secs	6992 ms
2000	12 secs	12748 ms
5000	36 secs	36925 ms
10000	73 secs	73849 ms

Test 2
Platform: Exported App / Kodular
Measured with: inbuilt Clock component
Created: “Button” component with default properties

Component Count	Created in (as seconds)	Created in (as milliseconds)
100	0 sec	593 ms
200	1 sec	1079 ms
500	2 secs	2427 ms
1000	6 secs	6023 ms
2000	12 secs	12009 ms
5000	25 secs	25092 ms
10000	64 secs	64520 ms

Note
Of course, the current running apps, available memory at the moment, device type etc can affect the execution time. It is just an amateur benchmark.
