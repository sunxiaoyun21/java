<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/15
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="http://cdn.bootcss.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/bootstrap/2.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/static/css/style.css">
</head>
<body>
<%@include file="../include/common.jsp"%>
<div class="container">
    <div class="box">
        <div class="box-header">
            <span class="title"><i class="fa fa-sign-in"></i> 登录</span>
        </div>

        <form action="" class="form-horizontal" id="LoginForm">
            <div class="control-group">
                <label class="control-label">账号</label>
                <div class="controls">
                    <input type="text" style="height:30px;" name="username">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">密码</label>
                <div class="controls">
                    <input type="password"  style="height:30px;" name="password">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label"></label>
                <div class="controls">
                    <a href="#">忘记密码</a>
                </div>
            </div>

            <div class="form-actions">
                <button class="btn btn-primary" id="LoginBtn">登录</button>

                <a class="pull-right" href="/reg">注册账号</a>
            </div>

        </form>

    </div>
    <!--box end-->
</div>
<!--container end-->
<script src="//cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="//cdn.bootcss.com/jquery-validate/1.15.0/jquery.validate.min.js"></script>
<script src="/static/js/uesr/login.js"></script>
</body>
</html>
