<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Blank Page</title>
    <%@include file="../include/css.jsp"%>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../include/header.jsp"%>
    <jsp:include page="../include/sider.jsp">
        <jsp:param name="menu" value="sys_accounts"/>
    </jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">

        <!-- Main content -->
        <section class="content">
            <div class="box box-solid box-info">
                <div class="box-header with-border">
                    <h3 class="box-title"><i class="fa fa-search"></i></h3>
                </div>
                <div class="box-body">
                    <form class="form-inline">
                        <div class="form-group">
                            <input type="text" placeholder="姓名" class="form-control" name="q_name" value="${q_name}">
                        </div>
                        <div class="form-group">
                            <select name="q_role" class="form-control">
                                <option value=""> --角色--</option>
                                <c:forEach items="${roleList}" var="role">
                                    <option value="${role.id}" ${role.id==q_role ?"selected":""}>${role.viewName}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <button class="btn btn-default">搜索</button>
                    </form>
                </div>
            </div>
            <div class="box box-solid box-info">
                <div class="box-header with-border">
                    <h3 class="box-title"><i class="fa fa-list"></i>  账户管理</h3>
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
                        <tr>
                            <th>姓名</th>
                            <th>角色</th>
                            <th width="100">##</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${page.items}" var="user">
                            <tr>
                                <td>${user.userName}</td>
                                <td>${user.roleNames}</td>
                                <td>
                                    <a href="/user/edit/${user.id}">编辑</a>
                                    <a href="/user/del/${user.id}">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- /.box-body -->
                <div class="box-footer">
                    <nav>
                        <ul id="pagination" class="pull-right" style="margin:5px 0"></ul>
                    </nav>
                </div>
            </div>


        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

</div>

<%@include file="../include/js.jsp"%>
<script src="/static/plugins/jquery.twbsPagination.min.js"></script>
<script>
    $(function(){
        $("#pagination").twbsPagination({
            totalPages:${page .totalPage},
            visiblePages:5,
            first:'首页',
            last:'末页',
            prev:'上一页',
            next:'下一页',
            href: '/user?q_name=${q_name}&q_role=${q_role}&p={{number}}'
        })
    });
</script>
</body>
</html>
