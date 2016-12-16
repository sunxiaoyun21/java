$(function () {
    $(document).ajaxSend(function () {
        $("#regBtn").text("注册中。。。").attr("disable","disable")
    })
    $(document).ajaxComplete(function () {
        $("#regBtn").html("注册").removeAttr("disable")
    })
    $("#regBtn").click(function () {
        $("#regForm").submit();
    })
    $("#regForm").validate({
        errorElement:"span",
        errorClass:"text-error",
        rules:{
            username:{
                required:true,
                minlength:3,
                remote:"/only/user",
            },
            password:{
                required:true,
                rangelength:[6,18],
            },
            repassword:{
                required:true,
                rangelength:[6,18],
                equalTo:"#password",
            },
            email:{
                required:true,
                email:true,
                remote:"/only/email",
            },
            phone:{
                required:true,
                rangelength:[11,11],
                digits:true,
            }

        },
        messages:{
            username:{
                required:"请输入账号",
                minlength:"账号至少三个字符",
                remote:"该账号已被占用"
            },
            password:{
                required:"请输入密码",
                rangelength:"密码长度大于6个字符小于18个字符",
            },
            repassword:{
                required:"请输入密码",
                rangelength:"密码长度大于6个字符小于18个字符",
                equalTo:"两次密码不一致",
            },
            email:{
                required:"请输入邮件地址",
                email:"邮件格式不正确",
                remote:"该邮件地址以存在",
            },
            phone:{
                required:"请输入手机号",
                rangelength:"手机号格式不对",
                digits:"手机号格式不对",
            }

        },
        submitHandler:function () {
            var data=$("#regForm").serialize();
            $.post("/reg",data).done(function (data) {
                if(data.state=="success"){
                    alert("注册成功,请去邮箱激活你的账户");
                    
                }else {
                    alert(data.messages)
                }
            }).error(function () {
                alert("服务端错误")
            })

        }
    })
})