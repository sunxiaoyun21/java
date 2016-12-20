$(function () {
    $("#basicBtn").click(function () {
        $("#basicForm").submit();
    })
    $("#basicForm").validate({
        errorElement:"span",
        errorClass:"text-error",
        rules:{
           email:{
               required:true,
               email:true,
               remote:"/only/email?type=1"
           } 
        },
        messages:{
            email:{
                required:"请输入邮件地址",
                email:"邮件格式错误",
                remote:"该账号已被占用"
            }
        },

        submitHandler:function (form) {
            var data=$(form).serialize();
            $.post("/setting?action=profile",data).done(function (data) {
                if(data.state=="success"){
                    alert("邮件修改成功")
                }
            }).error(function () {
                alert("客户端错误")
            })
        }
    })

    //密码修改
    $("#passwordBtn").click(function () {
        $("#passwordForm").submit();
    })
    $("#passwordForm").validate({
        errorElement:"span",
        errorClass:"text-error",
        rules:{
            oldpassword:{
                required:true,
                rangelength:[6,18],
            },
            newpassword:{
                required:true,
                rangelength:[6,18],
            },
            repassword:{
                required:true,
                rangelength:[6,18],
                equalTo:"#newpassword",
            }
        },
        messages:{
            oldpassword:{
                required:"请输入原始密码",
                rangelength:"密码长度大于6个字符小于18个字符",
            },
            newpassword:{
                required:"请输入密码",
                rangelength:"密码长度大于6个字符小于18个字符",
            },
            repassword:{
                required:"请输入确认密码",
                rangelength:"密码长度大于6个字符小于18个字符",
                equalTo:"两次密码不一致",
            }
        },
        submitHandler:function (form) {
            var data=$(form).serialize();
            $.post("/setting?action=password",data).done(function (data) {
                if(data.state=="success"){
                    alert("修改成功，请重新登录")
                    location.href="/login";
                }else{
                    alert(data.message)
                }
            }).error(function () {
                alert("客户端错误")
            })
        }
    })
})
