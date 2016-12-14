<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/13
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/js/webupload/webuploader.css">
    <link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div id="picker">选择文件</div><button id="starBtn">开始上传</button>
<ul id="filelist"></ul>

<script src="/js/jquery-3.1.1.min.js"></script>
<script src="/js/webupload/webuploader.min.js"></script>
<script type="text/template" id="bar">
    <div class="progress">
        <div class="progress-bar" id="{{id}}" style="width:0% ;">
            <span class="sr-only"></span>
        </div>
    </div>
</script>
<script>
    $(function () {
         var upload=WebUploader.create({
             //swf文件路径
             swf:"/js/webupload/Uploader.swf",
             server:"/upload",
             pick:"#picker",
             fileVal:"file"
         })
        //选择文件放入上传队列，调用一次
        upload.on("fileQueued", function (file) {
                var html="<li id='"+file.id+"'>"+file.name+"</li>"
               $("#filelist").append($(html));
        })
        //文件上传进度,上传过程中调用多次
        upload.on("uploadProgress",function (file,percentage) {
            var num=parseInt(percentage*100);
            var $bar=$("#"+file.id).find("#bar_"+file.id);
            if(!$bar[0]){
                var template=$("#bar").html();
                template=template.replace("{{id}}","bar_"+file.id);
                $("#"+file.id).append($(template));
            }else {
               $bar.css("width",num+"%");
            }

        })
        //上传成功
        upload.on("uploadSuccess",function (file) {
            $("#"+file.id).css("color","green")
        })
        //文件上传失败
        upload.on("uploadError",function (file) {
            $("#"+file.id).css("color","red")
        })
        //文件上传失败或成功都调用
        upload.on("uploadComplete",function (file) {
            $("#"+file.id).find("#bar_"+file.id).parent().remove();
        })
        $("#starBtn").click(function () {
           upload.upload();
        })

    })
</script>
</body>
</html>
