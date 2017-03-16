<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/16
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <table class="table">
            <thead>
            <tr>
                <th>姓名</th>
                <th>地址</th>

            </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${user.username}</td>
                    <td>${user.address}</td>
                </tr>
            </tbody>
        </table>
        <c:forEach items="${user.rolesList}" var="role">
                <h3>${role.role}</h3>
        </c:forEach>


    </div>
</body>
</html>
