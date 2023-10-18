---
title: App Inventor 2 实现上传文件到服务器全方案总结
layout: documentation
description: App Inventor 2 实现上传文件到服务器全方案总结，包括图片base64化，base64编解码，Web客户端POST文件，php及python服务端代码编写。
---

* TOC
{:toc}

[&laquo; 返回首页](index.html)

## App Inventor 2 实现上传文件到服务器全方案总结

### 1、图片Base64化

图片Base64化，然后通过Web客户端POST文本的方式，发送数据，服务端base64解码后，存储文件。下载过程是Web客户端通过网络url下载文件到手机。

类似地，也可以将图片Base64化后分片存储到网络微数据库。下载过程是将分片完整合并，并解码存储到手机上。

比如，百度AI提供物品识别的API就支持待上传的图片为base64编码格式，这种方式也是较为常规的。

***
### 2、通用（二级制）文件上传：通过Web客户端POST文件

参考代码如下：

![上传文件到服务器](../components/images/上传文件到服务器.png)

文件成功上传并写入服务端，参考结果如下：

![文件上传服务器结果](../components/images/文件上传服务器结果.png)

***
php服务端代码参考：

```php
<?php
/* FileName: PicXfer.php
* Simple PHP script to save image file.
*/
echo "We're in the XFER Program...";//phpinfo();

$picDir = "./test/";
$fileName = $_REQUEST['pic'];

$startT = microtime(TRUE);

echo "\nReceiving: $fileName \n";
$dataToWrite = file_get_contents('php://input');

$fileStatus = file_put_contents($picDir.$fileName, $dataToWrite);
$dur = microtime(TRUE) - $startT;

echo "\nBytes written: $fileStatus \nDuration: $dur";
?>
```


***
python服务端参考：

```python
from flask_restful import Api, Resource
from flask import Flask, request

app = Flask(__name__)
api = Api(app)

# 这边的类名是自己定义的
class receive_pic(Resource):
    def put(self):
        #接收二进制流保存为图片
        img = request.get_data()
        with open("test.png", "wb") as f:
            f.write(img)
        return 0
        
# 后面的路径可以自己定义
api.add_resource(receive_pic,'/test')

if __name__ == '__main__':
    app_port = 8081
    app.run(host="0.0.0.0", port=app_port, debug=True)
```