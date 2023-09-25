---
title: 使用Activity启动器组件
layout: documentation
description: App Inventor 2 使用Activity启动器组件
---

* TOC
{:toc}

[&laquo; 返回首页](index.html)

## 使用Activity启动器组件

The Activity Starter component lets you combine applications by having one application start up other applications.  It's a key way to extend the capabilities of App Inventor by taking advantage of other  apps, whether they are apps created with App Inventor or whether they are “external apps” (i.e., apps that were not created with App Inventor).  These can be App Inventor apps created by you or others.   They can also be apps like Camera and Maps that are pre-installed on the device.  Or they be any app at all as long as you have the necessary information to provide to the activity starter.  You can also pass values to applications when you start them, as well as get back results from applications to use in further processing.   In addition, advanced developers who work with the Android SDK can create original apps that can start App Inventor apps, and be started by them.



A link to the ActivityStarter Component  documentation provides additional information about the Activity Starter Component  Properties, Events and Methods.



To start an application with the Activity Starter, you must supply certain control information to the Android operating system. You do this by setting various properties of Activity Starter before calling the ActivityStarter.StartActivity method. This section gives some examples.

## Starting Other App Inventor Applications
You can use the Activity Starter to start another app that was created with App Inventor.   This is similar to using OpenAnotherScreen in multiple screen applications, except that now we’re dealing with two separate applications rather than two screens within a single application.  To open the other application, you need to know its package name and class name. If you have the source code of the App Inventor app (aia file), you can find these names as follows:

Download the source code to your computer.
Using a file explorer or unzip utility, find the file called youngandroidproject/project.properties .
The first line will start with " main= ". Everything after that is the package and class name.

For example, here is a first line you might see for an App named HelloPurr.

```
main=appinventor.ai_ElsaArendelle.HelloPurr
```

The ElsaArendelle part of the name comes from the App Inventor user account.


To start this app, you would use an activity starter component and set these properties:

```
ActivityPackage: appinventor.ai_ElsaArendelle.HelloPurr

ActivityClass: appinventor.ai_ElsaArendelle.HelloPurr.Screen
```

Invoking the activity starter's StartActivity method will start HelloPurr. When HelloPurr finishes (if it does), the original app's AfterActivity method will be invoked.


If you are going to start another App Inventor app, make sure you use the correct package name. For example, if someone posts the source code (aia file) for an app, and you repackage that app, you'll end up with a different package name than the original.

***
## Starting a Built-in Android Application from your App Inventor App
Apps that come built in with the Android device can be invoked “explicitly” by using package names and class names, as above.   They can also be started “implicitly” by specifying an Action, in which case the Android operating system can figure out which actual application to start.  The information used to start an app is called an intent, and the process for determining which application to start is called intent resolution.  You can find information about intents in the Android system documentation on intents and intent filters.


Some apps are designed to accept extra information when they are launched. For example, the Android Map activity can accept geographic information that specifies a location to display.   You must consult the documentation for the particular app to learn what this extra information is and how to specify it.  You can also find information on  Android  Common Intents for Google Android applications available on most devices.


Generally, you specify the information by setting the ActivityStarter's properties just before the you launch the other app with StartActivity.  You can set these in App Inventor using the ActivityStarter properties DataType and DataURI.  There is also an Extras property that takes a list of keys and values and specifies the property values for the corresponding keys.  The particular values you have to set depend on the activity you want to launch.


Here are some examples.


        Warning: The values in these examples depend on the version of the Android operating system on the app user’s device.  If you are creating an app that will be used on many different devices, you can run the ActivityStarter.ResolveActivity command to test whether the activity you need is supported on the user’s device and generate an appropriate error message if it is not supported.

### Start the Camera
To launch the Android Camera app, use an activity starter with the IMAGE_CAPTURE Action property. You do not specify an ActivityPackage or an ActivityClass:


Action: android.media.action.IMAGE_CAPTURE

This is basically what the App Inventor Camera component does, although it is more convenient to use the Camera component than to use the ActivityStarter in building your app.

### Launch a Web search
To launch a Web search, use an ActivityStarter with the WEB_SEARCH action.  The user’s phone will display a menu asking what kind of search to perform:

```
Action: android.intent.action.WEB_SEARCH
```

Open the browser to a designated Web page
Use these ActivityStarter with the VIEW action and a Data Uri  to open the phone’s browser to a designated web page, for example,

```
Action: android.intent.action.VIEW
DataUri: http://mit.edu
```

### Start the mailer with pre-addressed message

January 26, 2020: This example was updated to accommodate a change in android.   The email  sending code shown here will work in the next app inventor release but does not work  yet.



To start the Android mailer application, use the SEND action and use the EmailAddressList property to specify a list of email addresses.  Use the android.intent.extra.SUBJECT property and the android.intent.extra.TEXT properties to specify the subject, and the body of the message. In each case, starting the activity will bring up the Android mailer, and you can complete the message and then press "Send".


For instance, if you specify:

```
Action: android.intent.action.SEND
```

then starting the activity will bring up the mailer.


You can also specify the subject line and the message text with the aid of android.extra.SUBJECT and android.extra.TEXT.  You can specify email addresses for recipients with the list android.intent.extra.EMAIL.  For example, to send email to Santa@northpole.com, you could use:



![](images/activitystarter-image1.png)

Observe how EXTRAS is a list, where each element is itself a 2-item list (a key, value pair).  For the email addresses, the value is a list of addresses (or a list of 1-address is there is only a single address).


### Show a map for a location
If you know a latitude and a longitude, you can use the VIEW action to show a map of the area:

```
Action: android.intent.action.VIEW
DataUri: geo:37.8,-122.23?z=10
```

The DataURI here specifies the latitude and longitude and also a zoom value of 10 (z=10).  Zoom value is optional and ranges from 1 (the entire Earth) to 23.


If you know a zip code of a location, you can set the activity starter properties as follows:

```
Action: android.intent.action.VIEW
DataUri: geo:0,0?q=94043
```

If you have a street address, you can use a DataUri that encodes the address with a scheme called URL encoding :

```
Action: android.intent.action.VIEW
DataUri: geo:0,0?q=77+Massachusetts+Avenue%2C+Cambridge%2C+MA
```

Generally in URL encoding you have to replace spaces (with  %20 or plus sign ) and punctuation marks, such as comma ( %2C ) and period ( %2E ).

### Play a YouTube video
You'll need to know the URI of the YouTube video. Then set the Activity Starter action to VIEW, and set the  Data URI to vnd.youtube followed by the YouTube URI of the video to be played, for example


Action: android.intent.action.VIEW
DataUri: vnd.youtube:nAPk9ycCbfc
### Select a contact
To choose a contact, use an ActivityStarter with the PICK action. The contact will be returned in the form of uri and stored in the Activity Starter’s ResultUri property


Action: android.intent.action.PICK
## Starting other external apps
You can use the Activity Starter to start any activity at all.  You’ll need to  know the package name and class name, or the appropriate intent.  Some third-party application developers document this information. For hints on starting external apps, see the Android API documentation or search the Android developer forums.


## Discovering how to set the ActivityStarter properties
If you want to start an app and you you don't have the source code or documentation, you might still be able figure out the package name and class name (and sometimes the intent) by launching the app and inspecting the Android system log.
For example, if you use the YouTube application to play a video, you'll see in the log:
I/ActivityManager(   86): Starting activity: Intent { act=android.intent.action.VIEW dat=vnd.youtube:nAPk9ycCbfc cmp=com.google.android.youtube/.PlayerActivity }
If you can find the "cmp=" string, then the ActivityPackage is the part before the slash, e.g.,  com.google.android.youtube.  The ActivityClass is is the entire "cmp=" part, without the slash character, e.g., com.google.android.youtube.PlayerActivity.   There may also in general be "dat=" information that should be specify as the DataUri property.
Example: Starting  an external app to pick files
AndExplorer from Lysesoft is an application that lets you pick files from your phone’s file system. You can use AndExplorer with an activity starter to add a file picking capability to your application. If you have AndExplorer installed on your phone, you can pick a file from your App Inventor app by setting the following Activity Starter properties:
Action: android.intent.action.PICK
dataType: vnd.android.cursor.dir/lysesoft.andexplorer.file
dataURI: file:///sdcard

When AndExplorer runs, it will display lists of files and let you pick one.  When AndExplorer finishes and ActivityStarter.AfterActivity is called, the resulting file name will be available as the value of ActivityStarter’s  ResultUri property.  In addition, ResultType will give the type of the file, for example, image/jpeg or audio/mpeg. Using this information, you can build an App Inventor app that lets you pick a file from the file system and displays the image if you’d picked a jpeg file, or plays a music track if you picked an mpeg file.


This example also illustrates how the external app can return values to the App Inventor app. For more information, see  “Returning results from external apps to App Inventor apps” below.


### Passing values between applications
In the general situation, an App A can start an App B.  App A can also start App B and pass it a startup value, and App B can return a result to App A when it terminates.   The details of how this is accomplished depend on the specific apps, and on whether the App Inventor app is the app that is doing the starting, or the app being started, or both.  See the appendix below for hints on creating external apps that interact with App Inventor apps.

### Using the activity starter with two App Inventor Apps
App Inventor screens are activities, so you can use the Activity Starter to start other App Inventor apps.   The Hello Purr example at the top of this page shows how to do this. This is basically how App Inventor’s multiple screen apps work.  

To pass a startup text value to the App Inventor app you are starting with the Activity Starter, ise EXTRAS to set the KEY property to the string APP_INVENTOR_START and set the VALUE Property to the text you want to pass.  The other app can then retrieve this value with Get Start Plain Text.   To return a value from the other app, use Close Screen With Plain Text. 


For the case of two App Inventor apps, it’s simpler to design the combination as a single multiple screen app, rather than create two separate apps that communicate using the Activity Starter.   But one situation where you might want to have separate apps is where two people are loosely collaborating on a project and want to work separately.  Remember that in order to run the combined app, users must have both applications installed on their devices.

### Is the application available on the device?

If your app tries to start other apps, you'll want to check that those other apps are available on your user's phone before trying to start them. You can determine this using the ActivityStarter.ResolveActivity , which returns the name of the Activity that would be started by ActivityStarter.StartActivity, given the package or other information you've provided. If this name is blank, then the required application is not present, and you can make your app alert the user.

***
## Appendix:  Technical information  for Android developers who are designing external apps for use with  App Inventor apps

If you build Android apps using the Android SDK, you can design external apps that start App Inventor apps and you can also design apps can be started by App Inventor apps.  You can also arrange to pass values between the App Inventor apps and the external apps.

**Returning results from external apps to App Inventor apps**
The AndExplorer example at https://appinventor.mit.edu/explore/content/using-activity-starter.html using Classic App inventor shows how  external apps can make results available as properties of the Activity Starter when the app terminates.    In the case of AndExplorer, the properties were ResultType and ResultUri.   To know this information about AndExplorer, you’d need to find documentation for AndExplorer or see examples of Android code that uses it.


In general when your external app finishes and returns an intent to the App Inventor app that started it, the value of Intent.type() will be available as the ActivityStarter.ResultType property.  Similarly, the will be the value of Intent.getDataString() will be available as the  ResultUri property.


You can also pass back other information in the intent.   Choose a name (Java String) for the result and have the App Inventor apps set that name to be the ResultName property of the activity starter.  To return a desired value from your external app in an intent, use Intent.putextra(chosenResultName, desiredValue).   When your external app finishes, the App Inventor ActivityStarter.AfterActivity() event will be signalled, and the result parameter to event handler will be the desired value.  That same desired value will also be available as the Activity Starter’s Result property.  The desired value must be a string, and you can return only one value using this method.

**Starting App Inventor apps from external apps**
To start an App Inventor activity from an external app, use the Java Android methods startActitvity() or startActivityForResult().  To pass a startup value, include that value in the intent, by invoking the method  Intent.putExtra(tag, value) where tag is the string APP_INVENTOR_START.   The App Inventor app being started can then access the corresponding value with the screen’s Get Start Plain Start Text method.

**Returning results from App Inventor apps to external apps**
When the App Inventor app that you started finishes (more technically, when the current screen closes with CloseScreen), it will signal onActivityResult() to the external app that started it.   The App Inventor app can pass back a text string value by using Close Screen With Plain Text.  That value will be available to the external app through the returned Intent as Intent.getStringExtra(APP_INVENTOR_RESULT).
