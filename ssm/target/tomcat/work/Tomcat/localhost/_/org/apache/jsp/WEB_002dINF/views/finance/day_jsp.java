/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-02-26 09:52:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.finance;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class day_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/views/finance/../include/header.jsp", Long.valueOf(1487236959800L));
    _jspx_dependants.put("/WEB-INF/views/finance/../include/css.jsp", Long.valueOf(1487234202145L));
    _jspx_dependants.put("/WEB-INF/views/finance/../include/js.jsp", Long.valueOf(1487234202278L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <title>AdminLTE 2 | Blank Page</title>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Bootstrap 3.3.6 -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/static/bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("<!-- Font Awesome -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/static/dist/css/fontawesome/css/font-awesome.min.css\">\r\n");
      out.write("<!-- Theme style -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/static/dist/css/AdminLTE.min.css\">\r\n");
      out.write("<!-- AdminLTE Skins. Choose a skin from the css/skins\r\n");
      out.write("folder instead of downloading all of them to reduce the load. -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/static/dist/css/skins/_all-skins.min.css\">\r\n");
      out.write("\r\n");
      out.write("<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\r\n");
      out.write("<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/static/plugins/datatables/jquery.dataTables.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/static/plugins/datepicker/datepicker3.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"hold-transition skin-blue sidebar-mini\">\r\n");
      out.write("<!-- Site wrapper -->\r\n");
      out.write("<div class=\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<header class=\"main-header\">\r\n");
      out.write("    <!-- Logo -->\r\n");
      out.write("    <a href=\"../../index2.html\" class=\"logo\">\r\n");
      out.write("        <!-- mini logo for sidebar mini 50x50 pixels -->\r\n");
      out.write("        <span class=\"logo-mini\"><b>S</b>XY</span>\r\n");
      out.write("        <!-- logo for regular state and mobile devices -->\r\n");
      out.write("        <span class=\"logo-lg\"><b>Admin</b>SXY</span>\r\n");
      out.write("    </a>\r\n");
      out.write("    <!-- Header Navbar: style can be found in header.less -->\r\n");
      out.write("    <nav class=\"navbar navbar-static-top\">\r\n");
      out.write("        <!-- Sidebar toggle button-->\r\n");
      out.write("        <a href=\"#\" class=\"sidebar-toggle\" data-toggle=\"offcanvas\" role=\"button\">\r\n");
      out.write("            <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("            <span class=\"icon-bar\"></span>\r\n");
      out.write("            <span class=\"icon-bar\"></span>\r\n");
      out.write("            <span class=\"icon-bar\"></span>\r\n");
      out.write("        </a>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"navbar-custom-menu\">\r\n");
      out.write("            <ul class=\"nav navbar-nav\">\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("</header>");
      out.write("\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../include/sider.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("menu", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("fin_day", request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- Content Wrapper. Contains page content -->\r\n");
      out.write("    <div class=\"content-wrapper\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Main content -->\r\n");
      out.write("        <section class=\"content\">\r\n");
      out.write("            <div class=\"box box-solid box-info\">\r\n");
      out.write("                <div class=\"box-header with-border\">\r\n");
      out.write("                    <h3 class=\"box-title\"><i class=\"fa fa-search\"></i></h3>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"box-body\">\r\n");
      out.write("                    <form class=\"form-inline\">\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <input type=\"text\" placeholder=\"\" class=\"form-control\" name=\"day\"  id=\"date\">\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"box box-solid box-info\">\r\n");
      out.write("                <div class=\"box-header with-border\">\r\n");
      out.write("                    <h3 class=\"box-title\"><i class=\"fa fa-list\"></i> 财务日报</h3>\r\n");
      out.write("                    <div class=\"box-tools pull-right\">\r\n");
      out.write("                        <a href=\"javascript:;\" id=\"exportCsv\" class=\"btn btn-default\"><i class=\"fa fa-file-o\"> 导出Excel</i></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- Default box -->\r\n");
      out.write("                <div class=\"box-body\">\r\n");
      out.write("                    <table class=\"table\" id=\"table\">\r\n");
      out.write("                        <thead>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <th></th>\r\n");
      out.write("                            <th>流水号</th>\r\n");
      out.write("                            <th>创建日期</th>\r\n");
      out.write("                            <th>类型</th>\r\n");
      out.write("                            <th>金额</th>\r\n");
      out.write("                            <th>业务模块</th>\r\n");
      out.write("                            <th>业务流水</th>\r\n");
      out.write("                            <th>状态</th>\r\n");
      out.write("                            <th>备注</th>\r\n");
      out.write("                            <th>##</th>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        </thead>\r\n");
      out.write("                        <tbody></tbody>\r\n");
      out.write("                    </table>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /.box-body -->\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"box\">\r\n");
      out.write("                <div class=\"box-header\">\r\n");
      out.write("                    <h3 class=\"box-title\">今日收支统计</h3>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"box-body\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-md-6\">\r\n");
      out.write("                            <div id=\"inChart\" style=\"width: 100%;height: 300px\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-6\">\r\n");
      out.write("                            <div id=\"outChart\" style=\"width: 100%;height: 300px\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </section>\r\n");
      out.write("        <!-- /.content -->\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- /.content-wrapper -->\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- jQuery 2.2.0 -->\r\n");
      out.write("<script src=\"/static/plugins/jQuery/jQuery-2.2.0.min.js\"></script>\r\n");
      out.write("<!-- Bootstrap 3.3.6 -->\r\n");
      out.write("<script src=\"/static/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("<!-- AdminLTE App -->\r\n");
      out.write("<script src=\"/static/dist/js/app.min.js\"></script>\r\n");
      out.write("<!-- AdminLTE for demo purposes -->\r\n");
      out.write("<script src=\"/static/dist/js/demo.js\"></script>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script src=\"/static/plugins/datatables/jquery.dataTables.min.js\"></script>\r\n");
      out.write("<script src=\"/static/plugins/datepicker/bootstrap-datepicker.js\"></script>\r\n");
      out.write("<script src=\"/static/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js\"></script>\r\n");
      out.write("<script src=\"/static/plugins/moment.js\"></script>\r\n");
      out.write("<script src=\"/static/plugins/layer/layer.js\"></script>\r\n");
      out.write("<script src=\"/static/plugins/echarts.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("    $(function(){\r\n");
      out.write("        $(\"#date\").val(moment().format(\"YYYY-MM-DD\"));\r\n");
      out.write("        var table= $(\"#table\").DataTable({\r\n");
      out.write("            \"pageLength\":50,\r\n");
      out.write("            //\"lengthMenu\":[5,10,15,20],\r\n");
      out.write("            \"serverSide\":true,//表示所有操作都在服务端\r\n");
      out.write("            \"ajax\":{\r\n");
      out.write("                \"url\":\"/finance/day/load\",\r\n");
      out.write("                \"type\":\"get\",\r\n");
      out.write("                \"data\":function (obj){\r\n");
      out.write("                    obj.day=$(\"#date\").val()\r\n");
      out.write("                }\r\n");
      out.write("            },\r\n");
      out.write("            \"order\":[[0,'desc']],\r\n");
      out.write("            \"searching\":false,\r\n");
      out.write("            \"lengthChange\":false,\r\n");
      out.write("            \"ordering\":false,\r\n");
      out.write("            \"columns\":[\r\n");
      out.write("                {\"data\":\"id\"},\r\n");
      out.write("                {\"data\":\"moduleSerialNumber\"},\r\n");
      out.write("                {\"data\":\"createDate\"},\r\n");
      out.write("                {\"data\":\"type\"},\r\n");
      out.write("                {\"data\":\"money\"},\r\n");
      out.write("                {\"data\":\"module\"},\r\n");
      out.write("                {\"data\":\"serialNumber\"},\r\n");
      out.write("                {\"data\":\"state\"},\r\n");
      out.write("                {\"data\":\"remark\"},\r\n");
      out.write("\r\n");
      out.write("                {\"data\":function (row) {\r\n");
      out.write("                    if(row.state==\"未确认\"){\r\n");
      out.write("                        return \"<a href='javascript:;' class='confirm_btn' rel='\"+row.id+\"'><i class='fa fa-check'></i>确认</a>\";\r\n");
      out.write("                    }else {\r\n");
      out.write("                       return \"\"\r\n");
      out.write("                    }\r\n");
      out.write("\r\n");
      out.write("                }}\r\n");
      out.write("\r\n");
      out.write("            ],\r\n");
      out.write("            \"columnDefs\":[\r\n");
      out.write("                {targets:[0],visible:false},\r\n");
      out.write("                {targets:[1,2,6],orderable:false}\r\n");
      out.write("            ],\r\n");
      out.write("            \"language\":{ //定义中文\r\n");
      out.write("                \"search\": \"搜索:\",\r\n");
      out.write("                \"zeroRecords\":    \"没有匹配的数据\",\r\n");
      out.write("                \"lengthMenu\":     \"显示 _MENU_ 条数据\",\r\n");
      out.write("                \"info\":           \"显示从 _START_ 到 _END_ 条数据 共 _TOTAL_ 条数据\",\r\n");
      out.write("                \"infoFiltered\":   \"(从 _MAX_ 条数据中过滤得来)\",\r\n");
      out.write("                \"loadingRecords\": \"加载中...\",\r\n");
      out.write("                \"processing\":     \"处理中...\",\r\n");
      out.write("                \"paginate\": {\r\n");
      out.write("                    \"first\":      \"首页\",\r\n");
      out.write("                    \"last\":       \"末页\",\r\n");
      out.write("                    \"next\":       \"下一页\",\r\n");
      out.write("                    \"previous\":   \"上一页\"\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        $(\"#date\").datepicker({\r\n");
      out.write("            format: \"yyyy-mm-dd\",\r\n");
      out.write("            language: \"zh-CN\",\r\n");
      out.write("            autoclose: true,\r\n");
      out.write("            endDate:moment().format(\"YYYY-MM-DD\"),\r\n");
      out.write("        }).on(\"changeDate\",function (e) {\r\n");
      out.write("            var today=e.format(0,\"yyyy-mm-dd\");\r\n");
      out.write("            table.ajax.reload();\r\n");
      out.write("            loadPie();\r\n");
      out.write("\r\n");
      out.write("        });\r\n");
      out.write("        $(Document).delegate(\".confirm_btn\",\"click\",function (e) {\r\n");
      out.write("            var id=$(this).attr(\"rel\");\r\n");
      out.write("            layer.confirm(\"确定以收（付）款？\",function (index) {\r\n");
      out.write("                $.post(\"/finance/confirm/\"+id).done(function (resp) {\r\n");
      out.write("                    if(resp.status==\"success\"){\r\n");
      out.write("                        layer.msg(\"修改成功\")\r\n");
      out.write("                        table.ajax.reload(false,null);\r\n");
      out.write("                    }\r\n");
      out.write("                }).error(function () {\r\n");
      out.write("                    layer.msg(\"服务器忙，请稍后\")\r\n");
      out.write("                })\r\n");
      out.write("                layer.close(index)\r\n");
      out.write("            })\r\n");
      out.write("        });\r\n");
      out.write("        //导出csv文件\r\n");
      out.write("        $(\"#exportCsv\").click(function () {\r\n");
      out.write("            var day=$(\"#date\").val();\r\n");
      out.write("            window.location.href=\"/finance/day/\"+day+\"/data.xls\";\r\n");
      out.write("        })\r\n");
      out.write("        //echart\r\n");
      out.write("        //jquery转成原生的js\r\n");
      out.write("\r\n");
      out.write("        var inChart=echarts.init($(\"#inChart\")[0]);\r\n");
      out.write("        var outChart=echarts.init($(\"#outChart\")[0]);\r\n");
      out.write("        var option = {\r\n");
      out.write("            title : {\r\n");
      out.write("                left:'center'\r\n");
      out.write("            },\r\n");
      out.write("            tooltip: {},\r\n");
      out.write("            legend:{\r\n");
      out.write("                left:20,\r\n");
      out.write("                orient:'vertical',\r\n");
      out.write("                data:[]\r\n");
      out.write("            },\r\n");
      out.write("            series:[]\r\n");
      out.write("        };\r\n");
      out.write("      /*  var option={\r\n");
      out.write("            title:{\r\n");
      out.write("                left:\"center\",\r\n");
      out.write("            },\r\n");
      out.write("            tooltip:{},\r\n");
      out.write("            legend:{\r\n");
      out.write("                left:20,\r\n");
      out.write("                orient:'vertical',\r\n");
      out.write("                data:[]\r\n");
      out.write("            },\r\n");
      out.write("            series:[]\r\n");
      out.write("        };*/\r\n");
      out.write("        inChart.setOption(option);\r\n");
      out.write("        outChart.setOption(option);\r\n");
      out.write("\r\n");
      out.write("        function loadPie() {\r\n");
      out.write("            //收入统计\r\n");
      out.write("            $.get(\"/finance/day/in/\"+$(\"#date\").val()+\"/pie\").done(function (resp) {\r\n");
      out.write("                if(resp.status == 'success') {\r\n");
      out.write("                    var nameArray = [];\r\n");
      out.write("                    for(var i = 0;i < resp.data.length;i++) {\r\n");
      out.write("                        var obj = resp.data[i];\r\n");
      out.write("                        nameArray.push(obj.name);\r\n");
      out.write("                    }\r\n");
      out.write("                    inChart.setOption({\r\n");
      out.write("                        title:{\r\n");
      out.write("                            text : \"收入统计\"\r\n");
      out.write("                        },\r\n");
      out.write("                        legend:{\r\n");
      out.write("                            data:nameArray\r\n");
      out.write("                        },\r\n");
      out.write("                        series:[{\r\n");
      out.write("                            type:'pie',\r\n");
      out.write("                            name:\"金额\",\r\n");
      out.write("                            data:resp.data\r\n");
      out.write("                        }]\r\n");
      out.write("                    });\r\n");
      out.write("                } else {\r\n");
      out.write("                    layer.msg(resp.message);\r\n");
      out.write("                }\r\n");
      out.write("            }).error(function () {\r\n");
      out.write("                layer.msg(\"服务器忙，请稍后\")\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("            //支出统计\r\n");
      out.write("            $.get(\"/finance/day/out/\"+$(\"#date\").val()+\"/pie\").done(function (resp) {\r\n");
      out.write("                if(resp.status == 'success') {\r\n");
      out.write("                    var nameArray = [];\r\n");
      out.write("                    for(var i = 0;i < resp.data.length;i++) {\r\n");
      out.write("                        var obj = resp.data[i];\r\n");
      out.write("                        nameArray.push(obj.name);\r\n");
      out.write("                    }\r\n");
      out.write("                    outChart.setOption({\r\n");
      out.write("                        title:{\r\n");
      out.write("                            text : \"支出统计\"\r\n");
      out.write("                        },\r\n");
      out.write("                        legend:{\r\n");
      out.write("                            data:nameArray\r\n");
      out.write("                        },\r\n");
      out.write("                        series:[{\r\n");
      out.write("                            type:'pie',\r\n");
      out.write("                            name:\"金额\",\r\n");
      out.write("                            data:resp.data\r\n");
      out.write("                        }]\r\n");
      out.write("                    });\r\n");
      out.write("                } else {\r\n");
      out.write("                    layer.msg(resp.message);\r\n");
      out.write("                }\r\n");
      out.write("            }).error(function () {\r\n");
      out.write("                layer.msg(\"服务器忙，请稍后\")\r\n");
      out.write("            });\r\n");
      out.write("        }\r\n");
      out.write("        loadPie();\r\n");
      out.write("\r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
