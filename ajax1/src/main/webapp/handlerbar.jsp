<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/14
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button id="btn">button</button>
<div id="result"></div>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="/js/handlebars-v4.0.5.js"></script>
<script id="template" type="text/handlebars">

    <div class="entry">

        <h1>{{title}}</h1>
            <div class="body">
                {{{body}}}
              </div>
              <ul>
                   {{#each data}}
                   <li>{{name}}</li>
                   {{/each}}
              </ul>
              {{#if vip}}
              <div>welcome to china</div>
              {{/if}}
     </div>
</script>
<script>
    $(function () {
        $("#btn").click(function () {
            var source=$("#template").html();
            var tem=Handlebars.compile(source)
            var data={
                "title":"home",
                "body":"<span style='color: red'>helohelo</span>",
                "data":[
                    {"name":"jack"},
                    {"name":"tom"},
                    {"name":"rose"}
                ],
                "vip":false
            };
            var html=tem(data);
            $(html).appendTo($("#result"))
        })

    })
</script>
</body>
</html>
