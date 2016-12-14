<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/14
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button id="btn">click me</button>
 <div id="result">

 </div>
<script src="//cdn.bootcss.com/jquery/2.0.2/jquery.min.js"></script>
<script type="text/template" id="template">
    <div class="num">
        <h3>{{title}}</h3>
        <p>{{text}}</p>
    </div>
</script>
<script>
    $(function () {
        $("#btn").click(function () {
            var html=$("#template").html();
            html=html.replace("{{title}}","hello")
           html= html.replace("{{text}}","do you want")
            $(html).appendTo($("#result"))
        })
    })
    
    
 
    
    
</script>
</body>
</html>
