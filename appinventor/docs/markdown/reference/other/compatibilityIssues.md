---
title: Android 和App Inventor版本的兼容性问题
layout: documentation
description: Android 和App Inventor版本的兼容性问题
---

[&laquo; 返回首页](index.html)

## Android 和App Inventor版本的兼容性问题

The Android operating system and App Inventor are both evolving systems with frequent updates.  When we update MIT App Inventor, we try to maintain compatibility across Android versions, but this is not always possible.  Here are some notes on issues dealing with changes in App Inventor releases:


App Inventor apps created before 2013 will not work on devices running Android system 4.1 or newer systems.

As of August 2015, MIT App Inventor will no longer work on devices running Android OS version 1.5  (cupcake, API level 3) or earlier.  The minimum supported version is 1.6 (donut, API level 4)

App Inventor Classic was discontinued in July 2015, as announced in App Inventor Classic RIP


***
MIT App Inventor Classic RIP (Jan. 2012 - Jul. 2015)
Today we’re shutting down MIT App Inventor Classic. It’s been a great run. Even here at the end, the system is hosting 3000 active users a week. That’s down from 6500 in May, and vastly down from the peak of 30,000 active users a week in January 2014, when we first began encouraging people to move to App Inventor 2.

App Inventor Classic was adapted from the original Google App Inventor system, whose implementation began in 2009. The Google App Inventor team: Mark Friedman, Sharon Perl, Liz Looney, Ellen Spertus, Debby Wallach, and Karen Parker spent six months refactoring the code so it could be open-sourced. MIT then took over development and spent more months preparing the MIT App Inventor service, which we launched in spring 2012.

Even before the 2012 launch of App Inventor Classic, we knew we had to move to a new system. The App Inventor Classic Blocks Editor is a Java application that must be downloaded to the local machine each time, using a technology called Java Web Start, which was, and still is, a popular way to implement desktop applications, especially those involving graphics. It was a great choice for an implementation platform in 2008-2010 and the Google App Inventor team put a lot of effort into making the installation and startup easy for App Inventor users. But Java’s emerging security issues began to negatively affect the user experience. At the same time, advances in browser Javascript performance were making it increasingly attractive to use browsers themselves for desktop graphics applications. Neil Frasier joined the Google team to develop an in-browser blocks interface for App Inventor, called Blocky, and we happily committed to Blockly as the base from which to build the new MIT system. Blockly rapidly evolved to become a much more general development platform and now supports an extensive assortment of blocks interfaces.

MIT App Inventor Classic has performed admirably as a transition from the Java application-based Google App Inventor implementation of 2010, to the browser-based MIT App Inventor 2 system of 2014. Over its three and a half year lifespan, Classic has welcomed 1.7 million users, who among them created 3.97 million apps.

Let’s raise glass (or a phone!) in salute and carry on with App Inventor 2.