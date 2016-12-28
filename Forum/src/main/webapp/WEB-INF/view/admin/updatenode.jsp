
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="http://cdn.bootcss.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/bootstrap/2.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/static/css/sweetalert.css">
</head>
<body>
<%@include file="../include/admincommon.jsp"%>
<!--header-bar end-->
<div class="container-fluid" style="margin-top:20px">
    <form action="" id="nodeForm">
        <legend>编辑节点</legend>
        <label>节点名称</label>
        <input type="hidden" name="nodeid" value="${node.id}">
        <input type="text" name="nodename" value="${node.nodename}">
        <div class="form-actions">
            <button class="btn btn-primary" id="nodeBtn">保存</button>
        </div>
    </form>
</div>
<!--container end-->
<script src="//cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="//cdn.bootcss.com/jquery-validate/1.15.0/jquery.validate.min.js"></script>
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
                nodename:{
                    required:true,
                    remote:"/onenode?nodeid=${node.id}"
                }
            },
            messages:{
                nodename:{
                    required:"请输入节点",
                    remote:"该节点以存在"
                }
            },
            submitHandler:function (form) {
                var data=$(form).serialize()
                $.post("/updatenode",data).done(function (data) {
                    if(data.state=="success"){
                        swal({title:"修改成功"},function () {
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
</body>
</html>
