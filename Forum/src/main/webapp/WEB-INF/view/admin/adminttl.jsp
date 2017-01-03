
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>详情页</title>
    <link href="http://cdn.bootcss.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@include file="../include/admincommon.jsp"%>
<!--header-bar end-->

<div>


</div>
<div class="container-fluid" style="margin-top:20px">
    <table class="table">
        <thead>
        <tr>
            <th>日期</th>
            <th>新主题数</th>
            <th>新回复数</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageList.items}" var="count">
            <tr>
                <td>${count.time}</td>
                <td>${count.topicnum}</td>
                <td>${count.replynum}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
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
    </script>
<!--container end-->
</body>
</html>
