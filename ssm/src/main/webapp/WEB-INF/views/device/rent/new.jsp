
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>新增设备租赁合同</title>
    <%@include file="../../include/css.jsp"%>
    <link rel="stylesheet" href="/static/plugins/uploader/webuploader.css">
    <link rel="stylesheet" href="/static/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="/static/plugins/select2/select2.min.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper" id="app">

    <%@include file="../../include/header.jsp"%>
    <jsp:include page="../../include/sider.jsp">
        <jsp:param name="menu" value="business_device_rent"/>
    </jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Main content -->
        <section class="content">

            <!-- Default box -->
            <div class="box">
                <div class="box-header with-border">
                    <h3 class="box-title">新增租赁合同</h3>

                    <div class="box-tools pull-right">
                        <a href="/device/rent" class="btn btn-default btn-sm"><i class="fa fa-reply"></i></a>
                    </div>
                </div>
                <div class="box-body">
                    <div class="row">
                        <div class="col-md-4">
                            <div class="form-group">
                                <label>公司名称</label>
                                <input type="text" class="form-control" id="companyName" tabindex="1">
                            </div>
                            <div class="form-group">
                                <label>联系电话</label>
                                <input type="text" class="form-control" id="tel" tabindex="4">
                            </div>
                            <div class="form-group">
                                <label>租赁日期</label>
                                <input type="text" class="form-control" id="rentDate" readonly>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <label>法人代表</label>
                                <input type="text" class="form-control" id="linkMan" tabindex="2">
                            </div>
                            <div class="form-group">
                                <label>地址</label>
                                <input type="text" class="form-control" id="address" tabindex="5">
                            </div>
                            <div class="form-group">
                                <label>归还日期</label>
                                <input type="text" class="form-control" id="backDate" tabindex="7">
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <label>身份证号</label>
                                <input type="text" class="form-control" id="cardNum" tabindex="3">
                            </div>
                            <div class="form-group">
                                <label>传真</label>
                                <input type="text" class="form-control" id="fax" tabindex="6">
                            </div>
                            <div class="form-group">
                                <label>总天数</label>
                                <input type="text" class="form-control" id="totalDays" readonly>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->

            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">设备列表</h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-default btn-sm" data-toggle="modal" data-target="#myModal"><i class="fa fa-plus"></i></button>
                    </div>
                </div>
                <div class="box-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>设备名称</th>
                            <th>单位</th>
                            <th>租赁单价</th>
                            <th>数量</th>
                            <th>总价</th>
                            <th>#</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td colspan="6">暂无数据</td>
                        </tr>
                        <tr>


                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="box-footer" style="text-align: right">
                    总租赁费 {{total}} 元 预付款 {{preCost}} 元 尾款 {{lastCost}} 元
                </div>
            </div>

            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">合同扫描件</h3>
                </div>
                <div class="box-body">
                    <div id="picker">选择文件</div>
                    <p>注意：上传合同扫描件要求清晰可见 合同必须公司法人签字盖章</p>
                    <ul id="fileList">
                    </ul>
                    <button class="btn btn-primary pull-right" type="button">保存合同</button>
                </div>
            </div>

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <div class="modal fade" id="myModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">选择设备</h4>
                </div>
                <div class="modal-body">
                    <form action="">
                        <div class="form-group">
                            <input type="hidden" id="deviceName">
                            <label>设备名称</label>
                            <select id="deviceId" style="width: 300px;" class="form-control">
                                <option value="">选择设备</option>
                                <c:forEach items="${deviceList}" var="device">
                                    <option value="${device.id}">${device.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>库存数量</label>
                            <input type="text" class="form-control" id="currNum" readonly>
                        </div>
                        <div class="form-group">
                            <label>单位</label>
                            <input type="text" class="form-control" id="unit" readonly>
                        </div>
                        <div class="form-group">
                            <label>租赁单价</label>
                            <input type="text" class="form-control" id="rentPrice" readonly>
                        </div>
                        <div class="form-group">
                            <label>租赁数量</label>
                            <input type="text" class="form-control" id="rentNum">
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary">加入列表</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

</div>

<%@include file="../../include/js.jsp"%>
<script src="/static/plugins/moment.js"></script>
<script src="/static/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="/static/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script src="/static/plugins/select2/select2.full.min.js"></script>
<script>
    $(function () {
        //租赁日期默认今天
        $("#rentDate").val(moment().format("YYYY-MM-DD"))
        //归还日期
        $("#backDate").datepicker({
            format: "yyyy-mm-dd",
            language: "zh-CN",
            autoclose: true,
            startDate:moment().add('1','days').format("YYYY-MM-DD"),
        });
        //添加设备名称时的搜索
        $("#deviceId").select2();
        $("#deviceId").change(function () {
            var id=$(this).val();
            $.get("/device/rent/device.json",{"id":id}).done(function (resp) {
                if(resp.status=="success"){
                    var device=resp.data;
                    $("#currNum").val(device.currentNum);
                    $("#unit").val(device.unit);
                    $("#rentPrice").val(device.price);
                    

                }else {
                    alert(resp.message);
                }
            }).error(function () {
                alert("服务器忙，请稍后")
            })
        })
    })
</script>

</body>
</html>
