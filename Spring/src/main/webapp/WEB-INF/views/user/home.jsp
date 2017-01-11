<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<a href="/user/save" class="btn btn-primary">添加</a>

<div class="container">
    <c:if test="${not empty message}">
        <div class="alert alert-success">添加成功</div>
    </c:if>

    <table class="table">
        <tr>
            <th>姓名</th>
            <th>密码</th>
        </tr>
        <c:forEach items="${accountList}" var="account">
        <tr>
            <th>${account.username}</th>
            <th>${account.password}</th>
        </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
