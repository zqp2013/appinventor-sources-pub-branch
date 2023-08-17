---
title: 实时开发、测试和调试工具
layout: documentation
description: App Inventor 2 实时开发、测试和调试工具
---

[&laquo; 返回首页](index.html)

## 实时开发、测试和调试工具

When you create apps with App Inventor, you are working on the phone live : Drag a button icon to the Viewer and the button appears on the phone right then; change the button's color in the Designer and the color changes; drag out a block that makes something happen when the button is pressed, and you can press the button right then on the phone to see it happen.


This kind of feedback is enormously useful, because it lets you develop and test your apps incrementally, defining each bit of new behavior and testing as you go along. Inexperienced programmers often make the mistake of building a large amount of stuff before they test any of it. Then, when they run into bugs, they're faced with a huge tangle to sort out, where they don't know which pieces are working and which are not. So try to work incrementally. You'll still surely encounter bugs, but incremental development will let you isolate bugs more quickly and fix them more easily.


In addition to letting you try things by interacting with the phone itself, App Inventor includes features to aid in testing and debugging while you are using the Blocks editor. You can see these if you right-click on a block. This will bring up a menu, as shown here for a block that calls the procedure moveMole :

![](images/testing-image1.png)


Not all blocks will offer the same choice in the menu.


You can perform the action for a block with Do It . In debugging a program like MoleMash, you could select Do It for MoveMole and see if the mole moves on the phone.


Do It not only does the block's action, but also puts up a balloon that shows the value returned. The figure below shows the use of Do It on an addition block to show the result of adding two numbers called this and that. This also acts as a comment block, so you can add comments to the Do It result window.


![](images/testing-image2.png)


Result balloons are attached to blocks at a point indicated by a small question mark. You can click on the question mark to hide and show the result. You can also remove the result block and comments completely by right-clicking and choosing Remove Comments.


### Disable Block
Sometimes you want to keep a block around that's not really part of your app. Maybe it's a part of the program that's not yet finished, or a block that's only partially implemented. Right-clicking on a block and then choosing Disable Block from the popup menu will keep the block from becoming part of the app when you package it. Selecting Enable Block restores the disabled block.

### Collapsing blocks
If your app has many blocks, they won't all fit on the screen at once. You'll need to scroll the Blocks Editor window, and that can be awkward. One way to help keep screen real-estate small is to use block collapsing . If you right-click on a procedure block or an event-handler block, you can choose Collapse Block from the popup menu. The block will collapse so that only the title will be visible. Right-clicking again and choosing Expand Block will restore the block to full visibility.

### Comments
Adding comments to blocks is a good way to help others understand your programs. It's also useful for keeping track of your own programs. Selecting Add Comment from the popup block menu brings up a balloon attached to the block, where you can type a comment as shown:

![](images/testing-image3.png)


You can drag the balloon around, or resize it. The comment balloon is attached to the block at a spot with a small question mark, that you can click to hide and show the comment. Or you can remove the comment permanently by right clicking on the block and choosing Remove Comment. Note that this is the same window that the Do It command’s result window.

### Errors
Sometimes the result of doing a block will be an error. In the picture below, we changed the value of this to be the text "apple", and clicked Do It to add this and that. The result is an error, signalled by the red triangle with the exclamation point. If you click on the exclamation point, a popup window appears with the error.


![](images/testing-image4.png)

You can click on the exclamation point to hide and show the error window. You can also remove the error completing by choosing Clear Error from the block popup menu.

### Notifier
Another way to debug your program is to use the Notifier component. If you want to display some information at a particular point in your program, use the Notifier to display that information. It could include just a message, or it could display the values of certain variables. When you have debugged your app and you are sure it works as desired, you would either have to disable the Notifier blocks or remove the component altogether from your app.

### Labels
In the same manner as above, you can have debugging labels set up in your app. You can add blocks to set the label text to a message, or variable value so that you can track changes when they occur. When you have debugged your app and you are sure it works as desired, you can either make the label invisible in the Designer, and/or you can disable the blocks that set the text values. You can also remove the labels altogether, if you are sure you won’t need them again.

***
## System Logs
Besides the debugging tools in the Blocks editor, you can sometimes get information from various logs. This is generally for advanced users only.

### The Android Log and adb(Advanced)
If you have problems on the Android device, you can sometimes get information by inspecting the Android Log. For example, if your application runs out of space, that will be recorded in the log. The messages in the log are not generally intelligible, but you can use the Notifier component to make your app write messages into the log, and this can be of some use in debugging.


You can read the log using the Android Debug Bridge (adb). The adb program is installed on your computer as part of the App Inventor installation process, and you can use the logcat option to view the log. You can launch adb from the terminal on your machine. Go to the directory containing the AppInventor Extras software and run the command adb logcat


This will display the entire (large) system log. If you are debugging, you should open the log, simulate the bug again, and see what appears at the end of the log.

The actual directory for adb depends on your operating system:

* For MacOs it's /Applications/AppInventor/commands-for-Appinventor.
* For GNU/Linux it's /usr/google/appinventor-extras/commands-for-Appinventor
* For Windows, it can be in one of several places, depending on how it was installed. Search on your machine for the \Android\appinventor-extras folder, containing the file adb.exe.
For more information on adb, see the Android Debug Bridge web page.

### The Javascript console log (Advanced)
Not all bugs will be your bugs. App Inventor has bugs, too, and you might encounter them. There's not much you can do here, other than report the bug, but you might get some idea of what's going on — or at least get information for reporting error messages — by using the browser's developer tools to display the console log.

The Blocks editor is a Javascript program, and many of its operations write messages to the Javascript console log. You can see these messages if you run the Blocks editor with the browser's developer tools open.

The details depend on which browser you're using:

* For Firefox, goto Tools -> Web Developer -> Web Console
* For Chrome, goto Tools -> JavaScript console
* For Safari, goto Tools -> Developer -> Web Inspector -> Console

