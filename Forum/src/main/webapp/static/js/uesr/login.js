$(function () {

    $(document).ajaxSend(function () {
        $("#LoginBtn").text("登录中。。。").attr("disable","disable");
    })
    $(document).ajaxComplete(function () {
        $("#LoginBtn").text("登录").removeAttr("disable");
    })
    $("#LoginBtn").click(function () {
        $("#LoginForm").submit();
    })
    $("#LoginForm").validate({
        errorElement:"span",
        errorClass:"text-error",
        rules:{
           username:{
               required:true,
               minlength:3
           },
           password:{
               required:true,
               rangelength:[6,18]
           }
        },
        messages:{
            username:{
                required:"请输入账号",
                minlength:"账号至少为三个字符"
            },
            password:{
                required:"请输入密码",
                rangelength:"密码至少3个字符，不超过8个字符"
            }
        },
        submitHandler:function (form) {
            var data=$(form).serialize();
            $.post("/login",data).done(function (data) {
                if(data.state=="success"){
                    alert("登录成功");
                    location.href="/ttl"
                }else {
                    alert(data.messages)
                }
            }).error(function () {
                alert("客户端错误");
            })
        }
    })
})