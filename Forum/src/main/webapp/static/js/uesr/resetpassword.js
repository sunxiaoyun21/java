$(function () {
    $("#resetBtn").click(function () {
        $("#resetForm").submit();
    })
    $(document).ajaxSend(function () {
        $("#resetBtn").text("保存中。。。").attr("disable","disable")
    })
    $(document).ajaxComplete(function () {
        $("#resetBtn").text("保存").removeAttr("disable")
    })
    $("#resetForm").validate({
        errorElement:"span",
        errorClass:"text-error",
        rules:{
            password:{
                required:true,
                rangelength:[6,18],
            },
            repassword:{
                required:true,
                rangelength:[6,18],
                equalTo:"#password",
            }
        },
        messages:{
            password:{
                required:"请输入密码",
                rangelength:"密码长度大于6个字符小于18个字符",
            },
            repassword:{
                required:"请输入密码",
                rangelength:"密码长度大于6个字符小于18个字符",
                equalTo :"两次密码不一致",
            }
        },
        submitHandler:function (form) {
            var data=$(form).serialize();
            $.post("/resetpassword",data).done(function (data) {
                if(data.state=="success"){
                    alert("修改成功，请登录")
                    location.href="/login"
                }else {
                    alert(data.message)
                }
            }).error(function () {
                alert("客户端错误")
            })
        }
    })
})