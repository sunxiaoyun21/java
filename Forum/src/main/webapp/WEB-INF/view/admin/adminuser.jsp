
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="http://cdn.bootcss.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@include file="../include/admincommon.jsp"%>
<!--header-bar end-->
<div class="container-fluid" style="margin-top:20px">
    <table class="table">
        <thead>
        <tr>
            <th>账号</th>
            <th>注册时间</th>
            <th>最后登录时间</th>
            <th>最后登录IP</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageList.items}" var="user">
            <tr>
                <td>${user.username}</td>
                <td>${user.creattime}</td>
                <td>${user.login.logintime}</td>
                <td>${user.login.ip}</td>
                <td><a href="javascript:;" class="update" onClick="update(${user.id},${user.status})" rel="${user.id},${user.status}">${user.status=='1'?'禁用':'恢复'}</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
        <div class="pagination pagination-mini pagination-centered">
            <ul id="pagination" style="margin-bottom:20px;"></ul>
        </div>
<script src="/static/js/jquery-1.11.3.min.js"></script>
    <script src="/static/js/jquery.twbsPagination.min.js"></script>
    <script src="/static/js/uesr/notify.js"></script>
    <script src="/static/js/sweetalert.min.js"></script>
    <script>
        $(function(){
            $("#pagination").twbsPagination({
                totalPages:${pageList.totalPage},
                visiblePages:5,
                first:'首页',
                last:'末页',
                prev:'上一页',
                next:'下一页',
                href: '?p={{number}}&nodeid'
            })
            });
        function update(id,status) {
            $.post("/admin/user",{"id":id,"status":status},function (json) {
                if(json.state=="success"){
                    alert("修改成功");
                    window.history.go(0);
                }else {
                    alert(json.message)
                }
            });
        }
    </script>
<!--container end-->
</body>
</html>

