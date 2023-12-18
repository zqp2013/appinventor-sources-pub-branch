<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="_header.jsp" %> 



            <ul class="messagelist">
                <% if (error != null) {
                    out.println("<center><font color=red><b>" + error + "</b></font></center>");
                } %>
            </ul>


            <% if (phone != null) {
                out.println("账户信息：" + phone);
            } %>


<script src="https://cdn.ckeditor.com/ckeditor5/16.0.0/classic/ckeditor.js"></script><!--40.2.0-->
<script src="https://cdn.ckeditor.com/ckeditor5/16.0.0/classic/translations/zh-cn.js"></script>
<script type="text/javascript">
    ClassicEditor
    .create( document.querySelector( '#editor' ) )
    .catch( error => {
        console.error( error );
    } );

    class MyUploadAdapter {
        constructor( loader ) {
            // 上载期间要使用的文件加载器实例
            this.loader = loader;
        }
    
        // 启动上传过程
        upload() {
            return this.loader.file
                .then( file => new Promise( ( resolve, reject ) => {
                    //this._initRequest();
                    //this._initListeners( resolve, reject, file );
                    //this._sendRequest( file );
                } ) );
        }
    
        // 中止上传过程
        abort() {
            if ( this.xhr ) {
                this.xhr.abort();
            }
        }
    
        // 初始化 XMLHttpRequest 对象使用URL传递给构造函数
        _initRequest() {
            const xhr = this.xhr = new XMLHttpRequest();
            // *使用JSON作为数据结构的POST请求,url根据实际情况配置
            xhr.open( 'POST', 'admin/upload/rest/files', true );
            xhr.responseType = 'json';
        }
    
        // 初始化XMLHttpRequest监听器
        _initListeners( resolve, reject, file ) {
            const xhr = this.xhr;
            const loader = this.loader;
            const genericErrorText = `无法上传文件: ${ file.name }.`;
    
            xhr.addEventListener( 'error', () => reject( genericErrorText ) );
            xhr.addEventListener( 'abort', () => reject() );
            xhr.addEventListener( 'load', () => {
                const response = xhr.response;
                // 当响应上传失败时，调用reject()函数
                if ( !response || response.error ) {
                    return reject( response && response.error ? response.error.message : genericErrorText );
                }
    
                // 上传成功的处理
                resolve( {
                    default: response.url
                } );
            } );
    
            // 编辑器用户界面中显示上传进度条
            if ( xhr.upload ) {
                xhr.upload.addEventListener( 'progress', evt => {
                    if ( evt.lengthComputable ) {
                        loader.uploadTotal = evt.total;
                        loader.uploaded = evt.loaded;
                    }
                } );
            }
        }
    
        // 准备数据并发送请求
        _sendRequest( file ) {
            // 准备表单数据
            const data = new FormData();
            data.append( 'uploadFiles', file );
            // 实现认证和CSRF保护等安全机制
            // 发送请求.
            this.xhr.send( data );
        }
    }
    
    function MyCustomUploadAdapterPlugin( editor ) {
        editor.plugins.get( 'FileRepository' ).createUploadAdapter = ( loader ) => {
            // 配置上传脚本的后端URL
            return new MyUploadAdapter( loader );
        };
    }

    // 初始化内容富文本
    var thisAdEditor;
    $(function() {
        ClassicEditor
            .create(document.querySelector("#desc_contents"), {
                language: 'zh-cn',													// 中文
                extraPlugins: [ MyCustomUploadAdapterPlugin ], 						// 参考官方文档自定义Adapter实现图片上传
            })
            .then(editor => {
                thisAdEditor = editor;
               
            })
            .catch(error => {
                console.error(error);
            });
    });
    </script>
    <style type="text/css">
.ck-editor__editable_inline {
    height: 200px !important;
}
    </style>


            <form method="POST" action="/aia-store/publish">
                <input type="hidden" name="phone"
                <% if (phone != null) {
                    out.println("value=" + phone);
                } %>
                />

                <table style="width: 100%;">
                    <tr>
                        <td style="width:100px;">项目名：</td>
                        <td><input class="form-control form-input top"
                            autofocus="autofocus" autocapitalize="off" autocorrect="off"
                            required="required" title="该字段是必填字段。" type="text" name="title" id="title"></td>
                    </tr>

                    <tr>
                        <td>aia文件：</td>
                        <td><input class="form-control form-input top"
                            autofocus="autofocus" autocapitalize="off" autocorrect="off"
                            required="required" title="该字段是必填字段。" type="text" name="aia_path" id="aia_path"></td>
                    </tr>

                    <tr>
                        <td>图片预览：</td>
                        <td><input class="form-control form-input top"
                            autofocus="autofocus" autocapitalize="off" autocorrect="off"
                            required="required" title="该字段是必填字段。" type="text" name="pics" id="pics"></td>
                    </tr>

                    <tr>
                        <td>描述：</td>
                        <td><textarea name="contents" id="desc_contents"></textarea></td>
                    </tr>

                    <tr>
                        <td>价格：</td>
                        <td><input class="form-control form-input top"
                            autofocus="autofocus" autocapitalize="off" autocorrect="off"
                            required="required" title="该字段是必填字段。" type="text" name="price" id="price"></td>
                    </tr>

                    <tr>
                        <td>屏幕数量：</td>
                        <td><input class="form-control form-input top"
                            autofocus="autofocus" autocapitalize="off" autocorrect="off"
                            required="required" title="该字段是必填字段。" type="text" name="num_screen" id="num_screen"></td>
                    </tr>

                    <tr>
                        <td>代码块数量：</td>
                        <td><input class="form-control form-input top"
                            autofocus="autofocus" autocapitalize="off" autocorrect="off"
                            required="required" title="该字段是必填字段。" type="text" name="num_blocks" id="num_blocks"></td>
                    </tr>

                    <tr>
                        <td>分类：</td>
                        <td><input class="form-control form-input top"
                            autofocus="autofocus" autocapitalize="off" autocorrect="off"
                            required="required" title="该字段是必填字段。" type="text" name="catalog" id="catalog"></td>
                    </tr>

                    <tr>
                        <td>等级：</td>
                        <td><input class="form-control form-input top"
                            autofocus="autofocus" autocapitalize="off" autocorrect="off"
                            required="required" title="该字段是必填字段。" type="text" name="quality" id="quality"></td>
                    </tr>

                    <tr>
                        <td></td>
                        <td><br/><button type="submit">发布</button></td>
                    </tr>

                </table>
                
            </form>




<%@ include file="_footer.jsp" %>
