
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="" enctype="application/x-www-form-urlencoded"></form>
<input type="text" id="name" name="name" >
<button id="btn">ssr</button>
<div class="result"></div>
<script>
    (function () {
      function creatxmlHttp() {
          var xmlHttp=null;
          if(window.ActiveXObject){
              xmlHttp=new XMLHttpRequest("Microsoft.XMLHTTP")
          }else{
              xmlHttp=new XMLHttpRequest()
          }
          return xmlHttp;
      }

      document.querySelector("#btn").onclick=function () {
          var name=document.querySelector("#name").value;
         //sendPost(name);
         sendGet(name);
      }
      function sendGet(name) {
          var xml=creatxmlHttp();
          xml.open("get","/ajax?name="+name+"&_="+new Date().getTime());
          xml.send();
      }
      function sendPost(name) {
          var xml=creatxmlHttp();
          xml.open("post","/ajax")
          xml.setRequestHeader("Content-Type","application/x-www-form-urlencoded")

          //配置回调函数
        xml.onreadystatechange=function () {
            var state=xml.readyState;
            if(state==4){
                var httpState=xml.status//获取http状态码
                if(httpState==200){
                    //获取服务端返回的字符串
                    var results=xml.responseText
                    var div=document.querySelector(".result")
                    if(results=="可用"){
                        div.innerText="该账号可用"
                    }else {
                        div.innerText="该账号已被占用"
                    }
                }else {
                    alert("服务器错误"+httpState)
                }
            }
        }
          //发送请求
          xml.send("name="+name);
      }
  })();
</script>
</body>
</html>
