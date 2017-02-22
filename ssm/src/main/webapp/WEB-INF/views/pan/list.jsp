
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>网盘系统</title>
    <%@include file="../include/css.jsp"%>
    <link rel="stylesheet" href="/static/plugins/uploader/webuploader.css">
    <style>
        #picker{
            float: left;
            margin-right:20px;
        }
    </style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../include/header.jsp"%>
    <jsp:include page="../include/sider.jsp">
        <jsp:param name="menu" value="pan"/>
    </jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Main content -->
        <section class="content">

            <!-- Default box -->
            <div class="box box-primary box-solid">
                <div class="box-header with-border">
                    <h3 class="box-title">网盘系统</h3>

                    <div class="box-tools pull-right">
                        <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">
                            <i class="fa fa-minus"></i></button>
                        <button type="button" class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove">
                            <i class="fa fa-times"></i></button>
                    </div>
                </div>
                <div class="box-body">
                    <div id="picker">上传文件</div>
                    <button class="btn btn-primary" id="newFolder">新建文件夹</button>
                    <table class="table">
                        <thead>
                        <tr>
                            <th></th>
                            <th>名称</th>
                            <th>大小</th>
                            <th>创建时间</th>
                            <th>创建人</th>
                            <th>#</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:if test="${empty diskList}">
                                <tr>
                                    <td colspan="6">暂无数据</td>
                                </tr>
                            </c:if>
                            <c:forEach items="${diskList}" var="disk">
                                <tr>
                                    <td>
                                        <c:choose>
                                            <c:when test="${disk.type=='file'}">
                                                <i class="fa fa-file-o"></i>
                                            </c:when>
                                            <c:otherwise>
                                            <i class="fa fa-folder-o"></i> </td>
                                            </c:otherwise>
                                        </c:choose>
                                    <td>
                                        <c:choose>
                                            <c:when test="${disk.type=='file'}">
                                                <a href="/pan/download?id=${disk.id}">${disk.sourceName}</a>
                                            </c:when>
                                            <c:otherwise>
                                                <a href="/pan?path=${disk.id}">${disk.sourceName}</a>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>${disk.size}</td>
                                    <td>${disk.creatTime}</td>
                                    <td>${disk.creatUser}</td>
                                    <td>
                                        <a href="javascript:;"><i class="fa fa-trash text-danger"></i></a>
                                    </td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

</div>

<%@include file="../include/js.jsp"%>
<script src="/static/plugins/layer/layer.js"></script>
<script src="/static/plugins/uploader/webuploader.min.js"></script>
<script>

    $(function () {
        var uploader=WebUploader.create({
            // swf文件路径
            swf: '/static/plugins/uploader/Uploader.swf',
            // 文件接收服务端。
            server: '/pan/upload',
            auto:true,
            pick: '#picker',
            fileVal:'file',
            formData:{"fid":${fid}},
        });

        uploader.on("uploadSuccess", function(file ,resp) {
            if (resp.status=="success"){
                window.history.go(0)
            }else {
                layer.msg(resp.message)
            }
        });

        uploader.on( 'uploadError', function() {
            layer.msg("服务器异常")
        });








        $("#newFolder").click(function () {
            layer.prompt({title:"请输入文件夹的名称"},function (text,index) {
                var fid=${fid};
                layer.close(index);
                $.post("/pan/folder/new",{"fid":fid,"sourceName":text}).done(function (data) {
                    if(data.status=="success"){
                        window.history.go(0)
                    }else {
                        layer.msg(data.message)
                    }
                }).error(function () {
                    layer.msg("服务器繁忙")
                })
            })
        })
    })


</script>
</body>
</html>
