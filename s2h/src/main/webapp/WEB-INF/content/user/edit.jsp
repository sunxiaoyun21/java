<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/21
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/repo/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <div class="col-md-7">
            <form action="/user/save" method="post">
                <input type="hidden" name="user.id" value="${user.id}">
            <div class="form-group">
                <label>姓名</label>
                <input type="text" class="form-control" name="user.username" value="${user.username}">
            </div>
            <div class="form-group">
                <label>地址</label>
                <input type="text" class="form-control" name="user.address" value="${user.address}">
            </div>
                <div class="form-group">
                   <button class="btn btn-default">保存</button>
                </div>
        </form>
        </div>
    </div>
</body>
</html>
