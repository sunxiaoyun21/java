
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Blank Page</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <%@include file="../include/css.jsp"%>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../include/header.jsp"%>

    <!-- Left side column. contains the sidebar -->
    <%@include file="../include/side.jsp"%>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Main content -->
        <section class="content">
            <div class="box box-solid box-info">
                <div class="box-header with-border">
                    <h3 class="box-title">新建账户</h3>
                    <div class="box-tools pull-right">
                        <a href="/user/new" class="btn"><i class="fa fa-plus"></i></a>
                    </div>
                </div>
                <!-- Default box -->
                <div class="box-body">
                    <form method="post">
                        <div class="form-group">
                            <label>姓名</label>
                            <input type="text" name="username" value="${users.username}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>地址</label>
                            <input type="text" name="address" value="" class="form-control">
                        </div>
                        <div class="form-group">
                            <div>
                                <label>角色</label>
                            </div>

                            <c:forEach items="${roleList}" var="roles">
                                <label class="checkbox-inline">
                                    <input type="checkbox" id="inlineCheckbox1" value="option1">${roles.depname}
                                </label>
                            </c:forEach>
                        </div>
                        <div class="form-group">
                        <div class="form-group">
                            <button class="btn btn-primary">修改</button>
                        </div>
                    </form>
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>

    </section>
</div>
<!-- ./wrapper -->

<%@include file="../include/js.jsp"%>
</body>
</html>
