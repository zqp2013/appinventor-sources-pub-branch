<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   request.setAttribute("pageTitle", "发布源码 · App Inventor 2 源码商店");
   request.setAttribute("pageDesc", "发布源码");
%>
<%@ include file="_header.jsp" %>


            <ul class="messagelist">
                <% if (error != null) {
                    out.println("<center><font color=red><b>" + error + "</b></font></center>");
                } %>
            </ul>


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


            <form method="POST" action="/aia-store/publish" enctype="multipart/form-data">
                <input type="hidden" name="asId" value="<c:out value="${aia.asId}" />"/>

                
                <c:choose>
                    <c:when test="${aia.phone != null}">
                        <input type="hidden" name="phone" value="${aia.phone}"/>
                    </c:when>
                    <c:otherwise>
                        <input type="hidden" name="phone"
                        <% if (phone != null) {
                            out.println("value=" + phone);
                        } %>
                        />
                    </c:otherwise>
                </c:choose>

                <script>
                    function modify_file(id) {
                        document.getElementById(id).type = 'file';
                    }
                </script>

                <table style="width: 100%;">
                    <tr>
                        <td style="width:100px;">项目名：</td>
                        <td><input class="form-control form-input top" value="<c:out value="${aia.title}" />"
                            autocapitalize="off" autocorrect="off"
                            required="required" title="该字段是必填字段。" type="text" name="title" id="title"></td>
                    </tr>

                    <tr>
                        <td>图片预览：</td>
                        <td>
                            <c:choose>
                                <c:when test="${aia.pics != null}">
                                    <img src="<c:out value="${aia.pics}" />" width="120px"/>
                                    <input type="hidden" name="pics" id="pics" value="<c:out value="${aia.pics}" />"> &nbsp;<a onclick="modify_file('pics')">修改</a>
                                </c:when>
                                <c:otherwise>
                                    <input required="required" title="该字段是必填字段。" type="file" name="pics" id="pics">
                                    用于展示App效果，必填项！
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>

                    <tr>
                        <td>aia文件：</td>
                        <td>
                            <c:choose>
                                <c:when test="${aia.aia_path != null}">
                                    <c:out value="${aia.aia_path}" />
                                    <input type="hidden" name="aia_path" id="aia_path" value="<c:out value="${aia.aia_path}" />"> &nbsp;<a onclick="modify_file('aia_path')">修改</a>
                                </c:when>
                                <c:otherwise>
                                    <input required="required" title="该字段是必填字段。" type="file" name="aia_path" id="aia_path">
                                    源码文件，必填项！
                                </c:otherwise>
                            </c:choose> 
                        </td>
                    </tr>

                    <tr>
                        <td>apk文件：</td>
                        <td>
                            <c:choose>
                                <c:when test="${aia.apk_path != null}">
                                    <c:out value="${aia.apk_path}" />
                                    <input type="hidden" name="apk_path" id="apk_path" value="<c:out value="${aia.apk_path}" />"> &nbsp;<a onclick="modify_file('apk_path')">修改</a>
                                </c:when>
                                <c:otherwise>
                                    <input type="file" name="apk_path" id="apk_path">
                                    apk安装文件，便于用户体验最终效果，非必填项！
                                </c:otherwise>
                            </c:choose> 
                        </td>
                    </tr>

                    <tr>
                        <td>描述：</td>
                        <td><textarea name="contents" id="desc_contents"><c:out value="${aia.contents}" /></textarea></td>
                    </tr>

                    <tr>
                        <td>价格：￥</td>
                        <td><input class="form-control form-input top" oninput="value=value.replace(/[^0-9.]/g,'')"  style="width: 150px;"
                            autocapitalize="off" autocorrect="off" value="<c:out value="${aia.price}" />"
                            required="required" title="该字段是必填字段。" type="text" name="price" id="price"></td>
                    </tr>

                    <tr>
                        <td>屏幕数量：</td>
                        <td><input class="form-control form-input top" oninput="value=value.replace(/[^0-9.]/g,'')" style="width: 150px;"
                            autocapitalize="off" autocorrect="off" value="<c:out value="${aia.num_screen}" />"
                            required="required" title="该字段是必填字段。" type="text" name="num_screen" id="num_screen"></td>
                    </tr>

                    <tr>
                        <td>代码块数量：</td>
                        <td><input class="form-control form-input top" oninput="value=value.replace(/[^0-9.]/g,'')" style="width: 150px;"
                            autocapitalize="off" autocorrect="off" value="<c:out value="${aia.num_blocks}" />"
                            required="required" title="该字段是必填字段。" type="text" name="num_blocks" id="num_blocks"></td>
                    </tr>

                    <tr>
                        <td>分类：</td>
                        <td>
                            
                            <input id="app" name="catalog" value="1" required type="radio" <c:choose><c:when test="${aia.catalog == null || aia.catalog == '1'}">checked</c:when></c:choose> >&nbsp;<label for="app">软件应用App</label>&nbsp;&nbsp;&nbsp;
                            <input id="hardware" name="catalog" value="2" required type="radio" <c:choose><c:when test="${aia.catalog == '2'}">checked</c:when></c:choose>>&nbsp;<label for="hardware">物联网硬件App</label>&nbsp;&nbsp;&nbsp;
                            <input id="game" name="catalog" value="3" required type="radio" <c:choose><c:when test="${aia.catalog == '3'}">checked</c:when></c:choose>>&nbsp;<label for="game">游戏App</label>&nbsp;&nbsp;&nbsp;
                            <input id="other" name="catalog" value="4" required type="radio" <c:choose><c:when test="${aia.catalog == '4'}">checked</c:when></c:choose>>&nbsp;<label for="other">其他App</label>
                        </td>
                    </tr>

                    <tr>
                        <td>等级：</td>
                        <td>
                            <input id="demo" name="quality" value="1" required type="radio" <c:choose><c:when test="${aia.quality == null || aia.quality == '1'}">checked</c:when></c:choose> >&nbsp;<label for="demo">练手级</label>&nbsp;&nbsp;&nbsp;
                            <input id="teach" name="quality" value="2" required type="radio" <c:choose><c:when test="${aia.quality == '2'}">checked</c:when></c:choose> >&nbsp;<label for="teach">教学级</label>&nbsp;&nbsp;&nbsp;
                            <input id="pro" name="quality" value="3" required type="radio" <c:choose><c:when test="${aia.quality == '3'}">checked</c:when></c:choose> >&nbsp;<label for="pro">应用级</label>&nbsp;&nbsp;&nbsp;
                            <input id="biz" name="quality" value="4" required type="radio" <c:choose><c:when test="${aia.quality == '4'}">checked</c:when></c:choose> >&nbsp;<label for="biz">商业级</label>
                        </td>
                    </tr>

                    <tr>
                        <td>技术支持：</td>
                        <td><input type="checkbox" name="provide_support" id="provide_support" value="1" <c:choose><c:when test="${aia.provide_support == '1'}">checked</c:when></c:choose> >&nbsp;<label for="provide_support">是否提供售后技术支持服务</label></td>
                    </tr>

                    <tr>
                        <td></td>
                        <td><br/>
                            <c:choose>
                                <c:when test="${phone != null}">
                                    <button type="submit">发布</button>
                                </c:when>
                                <c:otherwise>
                                    请登<a href="https://www.fun123.cn/" target="_blank">录后</a>发布项目
                                </c:otherwise>
                            </c:choose>
                            
                            <a href="javascript:window.history.back();" style="margin-left:50px;"><< 返回</a>
                        </td>
                    </tr>

                </table>
                
            </form>




<%@ include file="_footer.jsp" %>
