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

    <!-- =============================================== -->
    <div class="content-wrapper">
        <!-- Main content -->
        <section class="content">
            <div class="box box-solid box-info">
                <div class="box-header with-border">
                    <h3 class="box-title">账户列表</h3>
                    <div class="box-tools pull-right">
                        <a href="/user/new" class="btn"><i class="fa fa-plus"></i></a>
                    </div>
                </div>
                <!-- Default box -->
                <div class="box-body">
                    <c:if test="${not empty message}">
                        <div class="alert alert-success">${message}
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        </div>
                    </c:if>
                    <table class="table">
                        <thead>
                            <th>姓名</th>
                            <th>部门</th>
                            <th width="100">##</th>
                        </thead>
                        <tbody>
                        <c:forEach items="${userList}" var="user">
                            <tr>
                                <td>${user.username}</td>
                                <td>${user.roleNames}</td>
                                <td>
                                    <a href="/user/edit/${user.id}">修改</a>
                                    <a href="/user/del/${user.id}">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>

<%@include file="../include/js.jsp"%>
</body>
</html>
