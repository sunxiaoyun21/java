<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/15
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="http://cdn.bootcss.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
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
            <c:if test="${not empty requestScope.message}">
                <div class="alert alert-success">
                        ${requestScope.message}
                </div>
            </c:if>

            <div class="control-group">
                <label class="control-label">账号</label>
                <div class="controls">
                    <input type="text" style="height:30px;" name="username">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">密码</label>
                <div class="controls">
                    <input type="password"  style="height:30px;" name="password" id="password">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label"></label>
                <div class="controls">
                    <a href="/findpassword">忘记密码</a>
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
<script src="/static/js/jquery-1.11.3.min.js"></script>
<script src="/static/js/jquery.validate.min.js"></script>
<script src="/static/js/uesr/login.js"></script>
</body>
</html>
