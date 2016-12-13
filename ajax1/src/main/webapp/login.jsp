<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/8
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="//cdn.bootcss.com/bootstrap/4.0.0-alpha.4/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <form id="forms">
            <div class="form-group">
                <label for>账号</label>
                <input type="text" id="username" name="username" class="form-control">
            </div>
            <div class="form-group">
                <label for>密码</label>
                <input type="password" id="password" name="password"  class="form-control">
            </div>
            <div>
                <button type="button" class="btn btn-default" id="btn">登录</button>
            </div>
        </form>
      </div>

    <%--<script src="js/jquery-3.1.1.min.js"></script>--%>
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/jquery-validate/1.16.0/jquery.validate.min.js"></script>


    <script>
        $(function () {
            $(document).ajaxSend(function(){
                $("#btn").text("登录中。。。。。").attr("disable","disable");
            });
            $(document).ajaxComplete(function(){
                $("#btn").html("登录").removeAttr("disable");
            });
            $("#btn").click(function () {
                $("#forms").submit();
            });

            $("#forms").validate({

                errorElement:"span",
                errorClass:"text-danger",
                rules:{
                    username:{
                        required:true
                    },
                    password:{
                        required:true
                    }
                },
                messages:{
                    username:{
                        required:"请输入账号"
                    },
                    password:{
                        required:"请输入密码"
                    }
                },

                 submitHandler:function() {
                    var data=$("#forms").serialize()

                  $.post("/login",data).done(function(data){
                        if(data.state == "error") {
                            alert(data.message);
                        } else {
                            window.location.href = "index.jsp";
                        }
                    }).error(function(){
                        alert("服务器异常");
                    });
                },
            });
        })
    </script>
</body>
</html>
