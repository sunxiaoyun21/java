<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/13
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="result">
    
</div>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script>
    $(function () {
        var MaxId=0
        function  call() {
            $.get("/timeline",{"MaxId":MaxId}).done(function (data) {
                    if(data.length){
                        for(var i=0;i<data.length;i++){
                            var item=data[i];
                            var html="<h3>"+item.message+"</h3>"
                            if(MaxId==0){
                                $(html).appendTo($("#result"))
                            }else{
                                $(html).prependTo($("#result"))
                            }
                        }
                        MaxId=data[0].id;
                    }
            }).error(function () {
                alert("客户端错误");
                clearInterval(st);
            })
        }
        call();
       var st= setInterval(call,5000)
    });
</script>
</body>
</html>
