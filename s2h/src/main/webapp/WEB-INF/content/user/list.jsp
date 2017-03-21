<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/repo/css/bootstrap.min.css">
</head>
<body>
<div class="container">

    <form action="/user/list" method="post" class="form-inline">
        <input type="text" name="q_like_s_username"><button class="btn btn-default">搜索</button>
    </form>

    <table class="table">
        <a href="/user/new"><button class="btn btn-default">添加</button></a>
        <thead>
            <tr>
                <th>姓名</th>
                <th>地址</th>
                <th>#</th>
            </tr>
        </thead>
        <tbody>
        <s:iterator value="userList" var="user">
            <tr>
                <td>${user.username}</td>
                <td>${user.address}</td>
                <td>
                    <a href="/user/del?id=${user.id}">删除</a>
                    <a href="/user/edit?id=${user.id}">修改</a>
                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>

</div>


</body>
</html>
