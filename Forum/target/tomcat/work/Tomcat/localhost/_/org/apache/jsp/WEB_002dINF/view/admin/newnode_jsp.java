/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-01-06 03:03:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newnode_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/view/admin/../include/admincommon.jsp", Long.valueOf(1483262349976L));
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
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>Title</title>\r\n");
      out.write("    <link href=\"http://cdn.bootcss.com/font-awesome/4.5.0/css/font-awesome.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"/static/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/static/css/sweetalert.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Title</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"navbar navbar-inverse  navbar-static-top\">\r\n");
      out.write("    <div class=\"navbar-inner\">\r\n");
      out.write("        <a class=\"brand\" href=\"/admin/ttl\">BBS 管理系统</a>\r\n");
      out.write("        <ul class=\"nav\">\r\n");
      out.write("            <li class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param._=='0'?'active':''}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><a href=\"/admin/ttl\">首页</a></li>\r\n");
      out.write("            <li class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param._=='1'?'active':''}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><a href=\"/admin/topic\">主题管理</a></li>\r\n");
      out.write("            <li class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param._=='2'?'active':''}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><a href=\"/admin/node\">节点管理</a></li>\r\n");
      out.write("            <li class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param._=='3'?'active':''}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><a href=\"/admin/user\">用户管理</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        <ul class=\"nav pull-right\">\r\n");
      out.write("            <li><a href=\"/admin/logout\">安全退出</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!--header-bar end-->\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("<!--header-bar end-->\r\n");
      out.write("<div class=\"container-fluid\" style=\"margin-top:20px\">\r\n");
      out.write("    <form action=\"\" id=\"nodeForm\">\r\n");
      out.write("        <legend>添加新节点</legend>\r\n");
      out.write("        <label>节点名称</label>\r\n");
      out.write("\r\n");
      out.write("        <input type=\"text\" name=\"node\">\r\n");
      out.write("\r\n");
      out.write("    </form>\r\n");
      out.write("    <div class=\"form-actions\">\r\n");
      out.write("        <button class=\"btn btn-primary\" id=\"nodeBtn\">保存</button>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!--container end-->\r\n");
      out.write("<script src=\"/static/js/jquery-1.11.3.min.js\"></script>\r\n");
      out.write("<script src=\"/static/js/jquery.validate.min.js\"></script>\r\n");
      out.write("<script src=\"/static/js/sweetalert.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("    $(function () {\r\n");
      out.write("        $(\"#nodeBtn\").click(function () {\r\n");
      out.write("            $(\"#nodeForm\").submit();\r\n");
      out.write("        })\r\n");
      out.write("        $(\"#nodeForm\").validate({\r\n");
      out.write("            errorElement:\"span\",\r\n");
      out.write("            errorClass:\"text-error\",\r\n");
      out.write("            rules:{\r\n");
      out.write("                node:{\r\n");
      out.write("                    required:true,\r\n");
      out.write("                    remote:\"/firstnode?nodeid\"\r\n");
      out.write("                }\r\n");
      out.write("            },\r\n");
      out.write("            messages:{\r\n");
      out.write("                node:{\r\n");
      out.write("                    required:\"请输入节点\",\r\n");
      out.write("                    remote:\"该节点以存在\"\r\n");
      out.write("                }\r\n");
      out.write("            },\r\n");
      out.write("            submitHandler:function (form) {\r\n");
      out.write("                var data=$(form).serialize()\r\n");
      out.write("                $.post(\"/firstnode\",data).done(function (data) {\r\n");
      out.write("                    if(data.state==\"success\"){\r\n");
      out.write("                        swal({title:\"添加成功\"},function () {\r\n");
      out.write("                            window.location.href = \"/admin/node\";\r\n");
      out.write("                        });\r\n");
      out.write("                    }else {\r\n");
      out.write("                        swal(data.message);\r\n");
      out.write("                    }\r\n");
      out.write("                }).error(function () {\r\n");
      out.write("                    swal(\"服务器异常\");\r\n");
      out.write("                })\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("        })\r\n");
      out.write("    })\r\n");
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