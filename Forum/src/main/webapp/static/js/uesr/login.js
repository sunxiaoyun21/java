$(function () {
    function getParameterByName(name, url) {
        if (!url) {
            url = window.location.href;
        }
        name = name.replace(/[\[\]]/g, "\\$&");
        var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
            results = regex.exec(url);
        if (!results) return null;
        if (!results[2]) return '';
        return decodeURIComponent(results[2].replace(/\+/g, " "));
    }

    $(document).ajaxSend(function () {
        $("#LoginBtn").text("登录中。。。").attr("disabled","disabled");
    })
    $(document).ajaxComplete(function () {
        $("#LoginBtn").text("登录").removeAttr("disabled");
    })
    $("#LoginBtn").click(function () {

    })

    $("#password").keydown(function () {
        if(event.keyCode=="13"){
            $("#LoginForm").submit();
        }
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
                    var url=getParameterByName("redirect");
                    if(url){
                        var hash=location.hash;
                        if(hash){
                            location.href=url+hash;
                        }else {
                            location.href=url;
                        }
                    }else {
                        location.href="/ttl"
                    }
                }else {
                    alert(data.message)
                }
            }).error(function () {
                alert("客户端错误");
            })
        }
    })
})