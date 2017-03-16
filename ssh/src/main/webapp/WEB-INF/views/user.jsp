
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
                <c:forEach items="${userList}" var="user">
                    <tr>
                        <td><a href="/user/${user.id}">${user.username}</a></td>
                        <td>${user.address}</td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
    </div>
</body>
</html>
