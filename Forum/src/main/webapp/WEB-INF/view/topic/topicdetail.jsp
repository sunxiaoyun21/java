<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/21
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${topic.title}</title>
    <link href="http://cdn.bootcss.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/bootstrap/2.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/static/css/style.css">
    <link rel="stylesheet" href="/static/js/editer/styles/simditor.css">
    <link rel="stylesheet" href="/static/css/styles/atom-one-dark.css">
    <style>
        body{
            background-image: url(/static/img/1.jpg);
        }
        .simditor .simditor-body {
            min-height: 100px;
        }
        .topic-body pre{
            border: none;
            background-color:transparent ;
        }
    </style>
</head>
<body>
<%@include file="../include/common.jsp"%>
<!--header-bar end-->
<div class="container">
    <div class="box">
        <ul class="breadcrumb" style="background-color: #fff;margin-bottom: 0px;">
            <li><a href="#">首页</a> <span class="divider">/</span></li>
            <li class="active">${requestScope.topic.node.nodename}</li>
        </ul>
        <div class="topic-head">
            <img class="img-circle avatar" src="${requestScope.topic.user.avatar}?imageView2/1/w/70/h/70" alt="">
            <h3 class="title">${requestScope.topic.title}</h3>
            <p class="topic-msg muted"><a href="">${requestScope.topic.user.username}</a> .<span id="topictime"> ${requestScope.topic.creattime}</span></p>
        </div>
        <div class="topic-body">
            ${requestScope.topic.content} </div>
        <div class="topic-toolbar">
            <c:if test="${not empty sessionScope.curr}">
                <ul class="unstyled inline pull-left">
                    <c:choose>
                        <c:when test="${not empty collect}">
                            <li><a href="javascript:;" id="collecttopic">取消收藏</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="javascript:;" id="collecttopic">加入收藏</a></li>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${not empty thank}">
                            <li><a href="" id="thanktopic">取消感谢</a></li>
                        </c:when>
                       <c:otherwise>
                           <li><a href="" id="thanktopic">感谢</a></li>
                       </c:otherwise>
                    </c:choose>

                    <c:if test="${sessionScope.curr.id==topic.user_id and topic.change }">
                        <li><a href="/topicChange?topicid=${topic.id}">编辑</a></li>
                    </c:if>
                </ul>
            </c:if>
            <ul class="unstyled inline pull-right muted">
                <li>${topic.clicknum}次点击</li>
                <li><span id="topicCollect">${topic.collectnum}</span>人收藏</li>
                <li><span id="topicthank">${topic.thanknum}</span>人感谢</li>
            </ul>
        </div>
    </div>
    <!--box end-->
    <c:if test="${not empty replyList }">
        <div class="box" style="margin-top:20px;">
            <div class="talk-item muted" style="font-size: 12px">
                    ${fn:length(replyList)}个回复 | 直到 <span id="lastreply">${topic.lastreplytime}</span>
            </div>
            <c:forEach items="${replyList}" var="reply" varStatus="vs">
                <div class="talk-item">
                    <table class="talk-table">
                        <tr>
                            <a name="reply${vs.count}"></a>
                            <td width="50">
                                <img class="avatar" src="${reply.user.avatar}?imageView2/1/w/40/h/40" alt="">
                            </td>
                            <td width="auto">
                                <a href="" style="font-size: 12px">${reply.user.username}</a> <span style="font-size: 12px" class="reply">${reply.creattime}</span>
                                <br>
                                <p style="font-size: 14px">${reply.content}</p>
                            </td>
                            <td width="70" align="right" style="font-size: 12px">
                                <a href="javascript:;" rel="${vs.count}" class="answer" title="回复"><i class="fa fa-reply"></i></a>&nbsp;
                                <span class="badge">${vs.count}</span>
                            </td>
                        </tr>
                    </table>
                </div>
      </c:forEach>
    </div>
    </c:if>
    <c:choose>
        <c:when test="${not empty sessionScope.curr}">
            <div class="box" style="margin:20px 0px;">
                <%--添加毛标记--%>
                    <a  name="reply"></a>
                <div class="talk-item muted" style="font-size: 12px"><i class="fa fa-plus"></i> 添加一条新回复</div>
                <form action="/reply"method="post" style="padding: 15px;margin-bottom:0px;" id="replyForm">
                    <input type="hidden" value="${topic.id}" name="topicid">
                    <textarea name="content" id="editor"></textarea>
                </form>
                <div class="talk-item muted" style="text-align: right;font-size: 12px">
                    <span class="pull-left">请尽量让自己的回复能够对别人有帮助回复</span>
                    <button id ="replyBtn" class="btn btn-primary">发布</button>
                </div>
            </div>
        </c:when>
        <c:otherwise>
             <div class="box" style="margin:20px 0px;">
                <div class="talk-item" >请<a href="/login?redirect=topicdetail?topicid=${topic.id}#reply">登录</a>后再回复</div>
             </div>
        </c:otherwise>
    </c:choose>
</div>
<!--container end-->
<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
<script src="/static/js/editer/scripts/module.min.js"></script>
<script src="/static/js/editer/scripts/hotkeys.min.js"></script>
<script src="/static/js/editer/scripts/uploader.min.js"></script>
<script src="/static/js/editer/scripts/simditor.min.js"></script>
<script src="/static/js/highlight.pack.js"></script>
<script src="//cdn.bootcss.com/moment.js/2.10.6/moment.min.js"></script>
<script src="//cdn.bootcss.com/moment.js/2.10.6/locale/zh-cn.js"></script>
<script>
    $(function(){

        $("#replyBtn").click(function () {
            $("#replyForm").submit();
        })

        <c:if test="${not empty sessionScope.curr}">
            var editor = new Simditor({
                textarea: $('#editor'),
                toolbar:false
                //optional options
            });
        $(".answer").click(function () {
            var count=$(this).attr("rel")
            var html="<a href='#reply"+count+"'>#"+count+"</a>"
            editor.setValue(html+editor.getValue())
            location.href="#reply"
        })
        </c:if>
        hljs.initHighlightingOnLoad();


        $("#topictime").text(moment($("#topictime").text()).fromNow());
        $("#lastreply").text(moment($("#lastreply").text()).format("YYYY年MM月DD日 HH:mm:ss"));
        $(".reply").text(function () {
            var time=$(this).text();
            return moment(time).fromNow();
        });
        $("#collecttopic").click(function () {
            var text="";
            if($(this).text()=="加入收藏"){
                text="collect"
            }else {
                text="uncollect"
            }
            $.post("/collect",{"topicid":${topic.id},"text":text}).done(function (json) {
                if(json.state=="success"){
                    if(text=="collect"){
                        $("#collecttopic").text("取消收藏")
                    }else {
                        $("#collecttopic").text("加入收藏")
                    }
                    $("#topicCollect").text(json.collectnum);
                }
            }).error(function () {
                alert("服务端错误")
            })
        })
        $("#thanktopic").click(function () {
            var action="";
            if($(this).text()=="感谢"){
                action="thank"
            }else{
                action="unthank"
            }
            $.post("/thank",{"topicid":${topic.id},"action":action}).done(function (json) {
                if(json.state=="success"){
                    if(action=="thank"){
                        $("#thanktopic").text("取消感谢")
                    }else {
                        $("#thanktopic").text("感谢")
                    }
                    $("#topicthank").text(json.thanknum)
                }
            }).error(function () {
                alert("服务端错误")
            })
        })


    });
</script>


</body>
</html>
