
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <form action="" class="form-inline">
            <input type="text" name="q_eq_username" class="form-control" placeholder="请输入姓名">
            <button class="btn btn-default">搜索</button>
        </form>
        <table class="table">
            <thead>
                <tr>
                    <th>姓名</th>
                    <th>地址</th>

                </tr>
            </thead>
            <tbody>
                <c:forEach items="${items}" var="user">
                    <tr>
                        <td><a href="/user/${user.id}">${user.username}</a></td>
                        <td>${user.address}</td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <ul class="pagination pull-right" id="page"></ul>
    </div>
    <script src="/static/js/jquery-1.11.3.min.js"></script>
    <script src="/static/js/jquery.twbsPagination.min.js"></script>
    <script>
        $(function () {
            $("#page").twbsPagination({
                totalPages:${page.totalPages},
                visiblePages:5,
                first:'首页',
                prev:'上一页',
                next:'下一页',
                last:'末页',
                href:'?p={{number}}'
            });
        });
    </script>
</body>
</html>
