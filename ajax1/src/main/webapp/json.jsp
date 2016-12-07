<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/6
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <button id="btn">dowload</button>
    <script>
        (function () {
            document.querySelector("#btn").onclick=function () {
                var xmlHttp=new XMLHttpRequest();
                xmlHttp.open("get","/data.json");
                xmlHttp.onreadystatechange=function () {
                    if(xmlHttp.readyState==4){
                        if(xmlHttp.status==200){
                            var result=xmlHttp.responseText;
                            var json=JSON.parse(result);
                            for(var i=0;i<json.length;i++){
                                var names=json[i];
                                alert(names.id+"->"+names.name+"->"+names.address);
                            }
                        }else {
                            alert("服务端异常");
                        }
                    }

                };
                xmlHttp.send();

            }
        })()

    </script>
</body>
</html>
