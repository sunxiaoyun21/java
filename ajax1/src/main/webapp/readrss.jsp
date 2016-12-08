<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/6
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <input type="text" id="url">
    <button id="btn">on load</button>
    <ul id="newlist"></ul>
    <script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script>
       $(function () {
           $("#btn").click(function () {
               var url=$("#url").val();
               var newlist=$("#newlist").html("");
               $.get("/rss.xml",{"url":url}).done(function (xmlDoc){
                   $(xmlDoc).find("item").each(function () {
                       var title=$(this).find("title").text();
                       var link=$(this).find("link").text();
                       $("<li><a href='"+link+"'>"+title+"</a></li>").appendTo($("#newlist"))
                   })
               }).error(function () {
                   alert("服务端错误");
               })
           })

       })
    </script>
</body>
</html>
