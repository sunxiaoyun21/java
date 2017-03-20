
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user/save">
    <input type="text" name="user.name">姓名</br>
    <input type="text" name="user.password">密码
    <button>保存</button>
</form>

        <ul>
            <c:forEach items="${list}" var="list">
                <li>${list}</li>
            </c:forEach>

        </ul>



</body>
</html>
