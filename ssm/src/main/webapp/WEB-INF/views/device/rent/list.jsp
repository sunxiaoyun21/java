<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>设备租赁</title>
    <%@include file="../../include/css.jsp"%>
    <link rel="stylesheet" href="/static/plugins/datatables/jquery.dataTables.min.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../../include/header.jsp"%>
    <jsp:include page="../../include/sider.jsp">
        <jsp:param name="menu" value="business_device_rent"/>
    </jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Main content -->
        <section class="content">

            <!-- Default box -->
            <div class="box box-primary box-solid">
                <div class="box-header with-border">
                    <h3 class="box-title">租赁合同列表</h3>

                    <div class="box-tools pull-right">
                        <a href="/device/rent/new" class="btn btn-primary"><i class="fa fa-plus"></i></a>
                    </div>
                </div>
                <div class="box-body">
                    <table class="table" id="table">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>流水号</th>
                            <th>租赁公司</th>
                            <th>电话</th>
                            <th>租赁日期</th>
                            <th>归还日期</th>
                            <th>状态</th>
                            <th>租金</th>
                            <th>尾款</th>
                            <th>#</th>
                        </tr>
                        </thead>
                    </table>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

</div>

<%@include file="../../include/js.jsp"%>
<script src="/static/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="/static/plugins/layer/layer.js"></script>
<script>
    $(function () {
        var table= $("#table").DataTable({
            //"lengthMenu":[5,10,15,20],
            "pageLength":25,
            "lengthChange":false,
            "serverSide":true,//表示所有操作都在服务端
            "ajax":{
                "url":"/device/rent/load",
                "type":"get",

            },
            //"order":[[0,'desc']],
            "searching":false,
            "autoWidth":false,
            "ordering":false,
            "columns":[
                {"data":"id","name":"id"},
                {"data":function (row) {
                if(row.serialNumber){
                    return "<a href='/device/rent/"+row.serialNumber+"'>"+row.serialNumber+"</a>"
                }else{
                    return""
                }

                }},
                {"data":"companyName"},
                {"data":"tel"},
                {"data":"rentDate"},
                {"data":"backDate","name":"price"},
                {"data":"state"},
                {"data":"totalPrice"},
                {"data":function () {
                    return ""
                }},
                {"data":function (row) {
                if(row.state){
                    return ""
                }else {
                    return "<a href='javascript:;' class='btn btn-xs btn-default checkBtn' rel='"+row.id+"'><i class='fa fa-check'></i>完成</a>";
                }

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
        //将合同变成完成状态
        $(document).delegate(".checkBtn","click",function () {
           var id=$(this).attr("rel");
           layer.confirm("确定要修改吗？",function (index) {
               $.post("/device/rent/state/change",{"id":id}).done(function (resp) {
                   if(resp.status=="success"){
                       table.ajax.reload()
                   }else {
                       layer.msg(resp.message);
                   }
               }).error(function () {
                   layer.msg("服务器忙，请稍后")
               })
                layer.close(index)
            })
        })
    })
</script>
</body>
</html>
