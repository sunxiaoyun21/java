<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/15
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="http://cdn.bootcss.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/static/css/style.css">
</head>
<body>
<%@include file="include/common.jsp"%>

<!--header-bar end-->
<div class="container">
    <div class="box">
        <div class="talk-item">
            <ul class="topic-type unstyled inline" style="margin-bottom:0px;">
                <li class="${empty param.nodeid?'active':''}"><a href="/ttl">全部</a></li>
                <c:forEach items="${nodeList}" var="node">
                    <li class="${param.nodeid==node.id?'active':''}"><a href="/ttl?nodeid=${node.id}">${node.nodename}</a></li>
                </c:forEach>
            </ul>
        </div>

       <c:forEach items="${topicPage.items}" var="topic">
            <div class="talk-item">
            <table class="talk-table">
                <tr>
                    <td width="50">
                        <img class="avatar" src="${topic.user.avatar}?imageView2/1/w/40/h/40"  alt="" style="width:40px;height:40px;">
                    </td>
                    <td width="80">
                        <a href="">${topic.user.username}</a>
                    </td>
                    <td width="auto">
                        <a href="/topicdetail?topicid=${topic.id}">${topic.title}</a>
                    </td>
                    <td width="50" align="center">
                        <span class="badge">${topic.replynum}</span>
                    </td>
                </tr>
            </table>
        </div>
       </c:forEach>

        <div class="pagination pagination-mini pagination-centered">
            <ul id="pagination" style="margin-bottom:20px;"></ul>
        </div>

    </div>
    <!--box end-->
</div>
<!--container end-->
<div class="footer">
    <div class="container">
        Copyright © 2016 sxy
    </div>
</div>
<script src="/static/js/jquery-1.11.3.min.js"></script>
<script src="/static/js/jquery.twbsPagination.min.js"></script>
<script src="/static/js/uesr/notify.js"></script>
<script>
    $(function(){
        $("#pagination").twbsPagination({
            totalPages:${topicPage.totalPage},
            visiblePages:5,
            first:'首页',
            last:'末页',
            prev:'上一页',
            next:'下一页',
            href: '?p={{number}}&nodeid=${param.nodeid}'
        });

    });
</script>
</body>
</html>
