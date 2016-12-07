
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="" enctype="application/x-www-form-urlencoded"></form>
    <button id="btn">ajax</button>
    <input type="text" id="name">
    <script src="jq/ajax.js"></script>
    <script>
        (function () {
            document.querySelector("#btn").onclick=function () {
              var name=document.querySelector("#name").value;
                ajax.sendPost({
                    url:"/ajax",
                    data:{"name":name,"age":23},
                    success:function (data) {
                        alert(data)
                    },
                    error:function () {
                        alert("客户端异常")
                    }
                })
            }
        })()
    </script>
</body>
</html>
