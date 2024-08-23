### Modify by 中文网
runtime\Form.java  关于应用程序相关
runtime\ReplForm.java  ”设置“

build.xml 添加Aliyun短信相关jar
src拓展添加cn目录

### 升级v2.72历程
使用OpenJDK 1.8编译报错（lambda编译问题），查明是由于安卓sdk34 配合升级的core 1.9导致的（老版本core 1.0没问题）
升级OpenJDK 11后搞定。使用最新的d8代替dex。

web，extension没有问题，编译AI伴侣及其他apk报错：
[java] PARSE ERROR:
     [java] InvokeDynamic not supported
     [java] ...while preparsing cst 0047 at offset 00000144
     [java] ...while parsing androidx/core/app/ActivityCompat.class



~/.bashrc
export JAVA_HOME=/home/qpzhou/sources/jdk-11.0.24
export PATH=$JAVA_HOME/bin:$PATH


### getCurrentHost()
appengine/src/com/google/appinventor/server/project/youngandroid/YoungAndroidProjectService.java

