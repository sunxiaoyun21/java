<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/19
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="http://cdn.bootcss.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/bootstrap/2.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/static/js/uploader/webuploader.css">
    <link rel="stylesheet" href="/static/css/style.css">
    <link rel="stylesheet" href="/static/js/upload/webuploader.css">
</head>
<body>
<%@ include file="../include/common.jsp"%>
<div class="container">
    <div class="box">
        <div class="box-header">
            <span class="title"><i class="fa fa-cog"></i> 基本设置</span>
        </div>

        <form action="" class="form-horizontal" id="basicForm">
            <div class="control-group">
                <label class="control-label">账号</label>
                <div class="controls">
                    <input type="text" value="${sessionScope.curr.username}" readonly>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">电子邮件</label>
                <div class="controls">
                    <input type="text" name="email" value="${sessionScope.curr.email}">
                </div>
            </div>
            <div class="form-actions">
                <button type="button" class="btn btn-primary" id="basicBtn">保存</button>
            </div>

        </form>

    </div>
    <!--box end-->
    <div class="box">
        <div class="box-header">
            <span class="title"><i class="fa fa-key"></i> 密码设置</span>
            <span class="pull-right muted" style="font-size: 12px">如果你不打算更改密码，请留空以下区域</span>
        </div>

        <form action="" class="form-horizontal" id="passwordForm">
            <div class="control-group">
                <label class="control-label">原始密码</label>
                <div class="controls">
                    <input type="password" name="oldpassword">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">新密码</label>
                <div class="controls">
                    <input type="password" name="newpassword" id="newpassword">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">重复密码</label>
                <div class="controls">
                    <input type="password" name="repassword">
                </div>
            </div>
            <div class="form-actions">
                <button type="button" id="passwordBtn" class="btn btn-primary">保存</button>
            </div>

        </form>

    </div>
    <!--box end-->

    <div class="box">
        <div class="box-header">
            <span class="title"><i class="fa fa-user"></i> 头像设置</span>
        </div>

        <form action="" class="form-horizontal">
            <div class="control-group">
                <label class="control-label">当前头像</label>
                <div class="controls">
                    <img id="avatar" src="http://ohwn2cnss.bkt.clouddn.com/${sessionScope.curr.avatar}?imageView2/1/w/40/h/40" class="img-circle" alt="">
                </div>
            </div>
            <hr>
            <p style="padding-left: 20px">关于头像的规则</p>
            <ul>
                <li>禁止使用任何低俗或者敏感图片作为头像</li>
                <li>如果你是男的，请不要用女人的照片作为头像，这样可能会对其他会员产生误导</li>
            </ul>
            <div class="form-actions">
                <div id="picker">上传新头像</div>
            </div>


        </form>

    </div>
    <!--box end-->
</div>
<script src="//cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="//cdn.bootcss.com/jquery-validate/1.15.0/jquery.validate.min.js"></script>
<script src="/static/js/uesr/setting.js"></script>
<script src="/static/js/upload/webuploader.min.js"></script>
<script>
    $(function () {
        var upload=WebUploader.create({
            swf:"/static/js/upload/Uploader.swf",
            server:"http://up-z1.qiniu.com",
            pick:"#picker",
            auto:true,
            fileVal:'file',
            formData:{'token':'${token}'},
            accept: {
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/*'
            }
        });
        //上传成功
        upload.on("uploadSuccess",function (file,data) {
            var filekey=data.key;
            $.post("/setting?action=avatar",{"filekey":filekey}).done(function (data) {
                if(data.state=="success"){
                    var url="http://ohwn2cnss.bkt.clouddn.com/"+filekey;
                    $("#avatar").attr("src",url+"?imageView2/1/w/40/h/40")
                    $("#navbar-avatar").attr("src",url+"?imageView2/1/w/30/h/30")
                }
            }).error(function () {
                alert("头像上传失败");
                
            })
        });
        //上传失败
        upload.on("uploadError",function () {
            alert("文件上传失败，请稍后再试")
        });
    })
</script>
</body>
</html>
