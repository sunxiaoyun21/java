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
    <%@include file="../include/sider.jsp"%>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">


        <!-- Main content -->
        <section class="content">
            <div class="box box-solid box-info">
                <div class="box-header with-border">
                    <h3 class="box-title">添加用户</h3>
                    <div class="box-tools pull-right">
                        <a href="/user/new" class="btn"><i class="fa fa-plus"></i></a>
                    </div>
                </div>
                <!-- Default box -->
                <div class="box-body">
                 <form method="post">
                     <div class="form-group">
                         <label>账号</label>
                         <input type="text" class="form-control" name="userName">
                     </div>
                     <div class="form-group">
                         <label>密码(默认000000)</label>
                         <input type="password" value="000000" class="form-control" name="password">
                     </div>
                     <div class="form-group">
                         <label>角色</label>
                         <div>
                             <c:forEach items="${roleList}" var="role">
                                 <label class="checkbox-inline">
                                     <input type="checkbox" name="roleIds" value="${role.id}"> ${role.viewName}
                                 </label>
                             </c:forEach>
                         </div>
                     </div>
                     <div class="form-group">
                         <button class="btn btn-success">保存</button>
                     </div>
                 </form>
                </div>
                <!-- /.box-body -->
                <div class="box-footer">

                </div>
            </div>


        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

</div>

<%@include file="../include/js.jsp"%>
</body>
</html>
