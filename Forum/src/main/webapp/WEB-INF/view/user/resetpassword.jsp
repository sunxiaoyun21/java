<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/18
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<%@ include file="../include/common.jsp"%>
<div class="container">
    <div class="box">
        <div class="box-header">
            <span class="title"><i class="fa fa-sign-in"></i> 重置密码</span>
        </div>

        <form action="" class="form-horizontal" id="resetForm">
            <input type="hidden" name="id" value="${requestScope.user.id}">
            <input type="hidden" name="token" value="${requestScope.token}">
            <div class="control-group">
                <label class="control-label">新密码</label>
                <div class="controls">
                    <input type="password" name="password" id="password">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">请重复密码</label>
                <div class="controls">
                    <input type="password" name="repassword">
                </div>
            </div>

            <div class="form-actions">
                <button class="btn btn-primary" type="button" id="resetBtn">保存</button>
            </div>

        </form>



    </div>
    <!--box end-->
</div>
<!--container end-->
<script src="//cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="//cdn.bootcss.com/jquery-validate/1.15.0/jquery.validate.min.js"></script>
<script src="/static/js/uesr/resetpassword.js"></script>
</body>
</html>
