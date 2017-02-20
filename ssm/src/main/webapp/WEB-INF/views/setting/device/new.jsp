<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Blank Page</title>
    <%@include file="../../include/css.jsp"%>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../../include/header.jsp"%>
    <jsp:include page="../../include/sider.jsp">
        <jsp:param name="menu" value="sys_device"/>
    </jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">


        <!-- Main content -->
        <section class="content">
            <div class="box box-solid box-info">
                <div class="box-header with-border">
                    <h3 class="box-title">新增设备</h3>

                </div>
                <!-- Default box -->
                <div class="box-body">
                 <form method="post">
                     <div class="form-group">
                         <label>设备名称</label>
                         <input type="text" class="form-control" name="name">
                     </div>
                     <div class="form-group">
                         <label>单位</label>
                         <input type="text" class="form-control" name="unit">
                     </div>
                     <div class="form-group">
                         <label>总数量</label>
                         <input type="text" class="form-control" name="totalNum">
                     </div>
                     <div class="form-group">
                         <label>租赁单价（元/天）</label>
                         <input type="text" class="form-control" name="price">
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

<%@include file="../../include/js.jsp"%>
</body>
</html>
