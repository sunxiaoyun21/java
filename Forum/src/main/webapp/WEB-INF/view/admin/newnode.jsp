
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="http://cdn.bootcss.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/static/css/sweetalert.css">
</head>
<body>
<%@include file="../include/admincommon.jsp"%>
<!--header-bar end-->
<div class="container-fluid" style="margin-top:20px">
    <form action="" id="nodeForm">
        <legend>添加新节点</legend>
        <label>节点名称</label>

        <input type="text" name="node">

    </form>
    <div class="form-actions">
        <button class="btn btn-primary" id="nodeBtn">保存</button>
    </div>
</div>
<!--container end-->
<script src="/static/js/jquery-1.11.3.min.js"></script>
<script src="/static/js/jquery.validate.min.js"></script>
<script src="/static/js/sweetalert.min.js"></script>
<script>
    $(function () {
        $("#nodeBtn").click(function () {
            $("#nodeForm").submit();
        })
        $("#nodeForm").validate({
            errorElement:"span",
            errorClass:"text-error",
            rules:{
                node:{
                    required:true,
                    remote:"/firstnode?nodeid"
                }
            },
            messages:{
                node:{
                    required:"请输入节点",
                    remote:"该节点以存在"
                }
            },
            submitHandler:function (form) {
                var data=$(form).serialize()
                $.post("/firstnode",data).done(function (data) {
                    if(data.state=="success"){
                        swal({title:"添加成功"},function () {
                            window.location.href = "/admin/node";
                        });
                    }else {
                        swal(data.message);
                    }
                }).error(function () {
                    swal("服务器异常");
                })
            }

        })
    })
</script>

</body>
</html>
