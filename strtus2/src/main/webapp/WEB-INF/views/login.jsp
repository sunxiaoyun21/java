<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/20
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/info/css/bootstrap.min.css">
</head>
<body>
    <div class="col-md-7">
        <form action="/login" method="post">
            <div class="form-group">
                <label>姓名</label>
                <input type="text" class="form-control" name="userName">
            </div>
            <div class="form-group">
                <label>密码</label>
                <input type="password" class="form-control" name="password">
            </div>
            <div class="form-group">
              <button class="btn btn-default">保存</button>
            </div>
        </form>
    </div>
</body>
</html>
