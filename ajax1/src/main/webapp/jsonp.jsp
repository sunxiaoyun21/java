<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/14
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button id="btn">JSONP</button>

<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script>
    $(function () {
       $("#btn").click(function () {
           $.getJSON("/jsonp?method=?").done(function (data) {
               alert(data.name+"->"+data.address)
           })
       })
    })
    
    
    
   /* function callback(user) {
        alert("hello,"+user.name);
    }*/
</script>
<%--<script src="/jsonp?method=callback"></script>--%>
</body>
</html>
