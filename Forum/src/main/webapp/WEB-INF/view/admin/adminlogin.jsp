
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
    <link href="http://cdn.bootcss.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/bootstrap/2.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/static/css/style.css">
</head>
<body>
<div class="header-bar">
    <div class="container">
        <a href="#" class="brand">
            <i class="fa fa-reddit-alien"></i>
        </a>
    </div>
</div>
<!--header-bar end-->
<div class="container">
    <div class="box">
        <div class="box-header">
            <span class="title"><i class="fa fa-sign-in"></i> 管理员登录</span>
        </div>
        <c:if test="${not empty requestScope.message}">
            <div class="alert alert-success">
                    ${requestScope.message}
            </div>
        </c:if>
        <form action="" class="form-horizontal" id="LoginForm">
            <div class="control-group">
                <label class="control-label">账号</label>
                <div class="controls">
                    <input type="text" id="username" name="adminname">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">密码</label>
                <div class="controls">
                    <input type="password" id="password" name="password">
                </div>
            </div>

            <div class="form-actions">
                <button class="btn btn-primary" id="LoginBtn">登录</button>
            </div>

        </form>



    </div>
    <!--box end-->
</div>
<!--container end-->
<script src="//cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="//cdn.bootcss.com/jquery-validate/1.15.0/jquery.validate.min.js"></script>
<script src="/static/js/admin/adminlogin.js"></script>
</body>
</html>
