<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/6
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="text" id="name">
<span id="loadding" style="display: none"><img src="../img/1.gif" alt=""></span>
<span id="test"></span>
<script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script>
    $(function () {
        $("#name").blur(function () {
            var name=$(this).val();
            $.get("/ajax",{"name":"ajax"}).done(function (data) {
                alert(data)
            })

          /*  $.post("/ajax",{"name":name,"age":23}).done(function (json) {
                $("#test").text(json)
            }).error(function () {
                alert("服务器异常")
            })*/

           /* $.ajax({
                url:"/ajax",
                type:"post",
                data:{"name":name,"age":23},
                timeout:15000,
                beforeSend:function () {
                    $("#loadding").show();
                    $("#test").text("")
                },
                success:function (json) {
                    $("#test").text(json)
                },
                error:function () {
                    alert("服务器异常")
                },
                complete:function () {
                    $("#loadding").hide()
                }
            });*/
        })

    })
</script>
</body>
</html>
