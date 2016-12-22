$(function () {
    $("#type").change(function () {
        var val=$(this).val();
        if(val=="email"){
            $("#typename").text("电子邮件")
        }else {
            $("#typename").text("手机号码")
        }
    });

    $("#btn").click(function () {
        $("#form").submit();
    })
    $(document).ajaxSend(function () {
        $("#btn").text("提交中。。。").attr("disabled","disabled");
    })
    $(document).ajaxComplete(function () {
        $("#btn").text("提交").removeAttr("disabled");
    })
    $("#form").validate({
        errorElement:"span",
        errorClass:"text-error",
        rules:{
            value:{
                required:true,
            }
        },
        messages:{
            value:{
                required:"该项不能为空",
            }
        },
    submitHandler:function (form) {
        var data=$(form).serialize();
        $.post("/findpassword",data).done(function (data) {
            if(data.state=="success"){
                var type=$("#type").val();
                if("email"==type){
                    alert("请去邮箱进行查收");
                }else {
                    ////
                }
            }else {
                alert(data.message)
            }
        }).error(function () {
            alert("客户端错误")
        })
    }

    })


})