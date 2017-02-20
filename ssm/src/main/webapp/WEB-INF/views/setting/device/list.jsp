<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Blank Page</title>
    <%@include file="../../include/css.jsp"%>
    <link rel="stylesheet" href="/static/plugins/datatables/jquery.dataTables.min.css">
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
                    <h3 class="box-title"><i class="fa fa-search"></i></h3>
                </div>
                <div class="box-body">
                    <form class="form-inline">
                        <div class="form-group">
                            <input type="text" placeholder="设备名称" class="form-control" name="q_device"  id="q_device" value="${q_device}">
                        </div>

                        <button id="searchBtn" class="btn btn-default" type="button">搜索</button>
                    </form>
                </div>
            </div>
            <div class="box box-solid box-info">
                <div class="box-header with-border">
                    <h3 class="box-title"><i class="fa fa-list"></i>  设备管理</h3>
                    <div class="box-tools pull-right">
                        <a href="/setting/device/new" class="btn"><i class="fa fa-plus"></i></a>
                    </div>
                </div>
            <!-- Default box -->
                <div class="box-body">
                    <c:if test="${not empty message}">
                        <div class="alert alert-success">${message}
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        </div>
                    </c:if>
                    <table class="table" id="table">
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>名称</th>
                            <th>单位</th>
                            <th>总数</th>
                            <th>库存</th>
                            <th>价格</th>
                            <th width="100">##</th>
                        </tr>
                        </thead>
                        <tbody></tbody>
                    </table>
                </div>
                <!-- /.box-body -->

            </div>


        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

</div>

<%@include file="../../include/js.jsp"%>

<script src="/static/plugins/datatables/jquery.dataTables.min.js"></script>
<script>
    $(function(){
       var table= $("#table").DataTable({
            "lengthMenu":[5,10,15,20],
            "serverSide":true,//表示所有操作都在服务端
            "ajax":{
                "url":"/setting/device/load",
                "type":"post",
                "data":function (obj){
                    obj.deviceName=$("#q_device").val()
                }
            },
            "order":[[0,'desc']],
           "searching":false,
            "columns":[
                {"data":"id","name":"id"},
                {"data":"name"},
                {"data":"unit"},
                {"data":"totalNum","name":"total_num"},
                {"data":"currentNum","name":"current_num"},
                {"data":"price","name":"price"},
                {"data":function (obj) {
                    return "<a href='javascript:;' rel='"+obj.id+"' class='delLink'>删除</a>";
                }}
            ],
            "columnDefs":[
                {targets:[0],visible:false},
                {targets:[1,2,6],orderable:false}
            ],
            "language":{ //定义中文
                "search": "搜索:",
                "zeroRecords":    "没有匹配的数据",
                "lengthMenu":     "显示 _MENU_ 条数据",
                "info":           "显示从 _START_ 到 _END_ 条数据 共 _TOTAL_ 条数据",
                "infoFiltered":   "(从 _MAX_ 条数据中过滤得来)",
                "loadingRecords": "加载中...",
                "processing":     "处理中...",
                "paginate": {
                    "first":      "首页",
                    "last":       "末页",
                    "next":       "下一页",
                    "previous":   "上一页"
                }
            }
    });
        /*事件委托*/
    $(document).delegate(".delLink","click",function () {
        if(confirm("你确定要删除么？")){
            var id=$(this).attr("rel");
            $.get("/setting/device/"+id+"/del").done(function (data) {
                if(data=="success"){
                    alert("删除成功")
                    //datatables的重新加载
                    table.ajax.reload();
                }
            }).error(function () {
                alert("服务器忙，请稍后")
            })
        }

    })

        //自定义搜索
        $("#searchBtn").click(function () {
           table.draw();//让datatables发出请求
        })
    });
</script>

</body>
</html>
