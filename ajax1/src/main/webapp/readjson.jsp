<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/8
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button id="btn">click me</button>
<script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script>
    $(function () {
        $("#btn").click(function () {
            $.getJSON("data.json").done(function (data) {
                for(var i=0;i<data.length;i++){
                    var user=data[i];
                    alert(user.name+"->"+user.address);
                }
            }).error(function () {
                alert("服务端异常")
            })
        })
    })
</script>
</body>
</html>
