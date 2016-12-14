/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2016-12-14 01:57:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class upload_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Title</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/js/webupload/webuploader.css\">\r\n");
      out.write("    <link href=\"//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"picker\">选择文件</div><button id=\"starBtn\">开始上传</button>\r\n");
      out.write("<ul id=\"filelist\"></ul>\r\n");
      out.write("\r\n");
      out.write("<script src=\"/js/jquery-3.1.1.min.js\"></script>\r\n");
      out.write("<script src=\"/js/webupload/webuploader.min.js\"></script>\r\n");
      out.write("<script type=\"text/template\" id=\"bar\">\r\n");
      out.write("    <div class=\"progress\">\r\n");
      out.write("        <div class=\"progress-bar\" id=\"{{id}}\" style=\"width:0% ;\">\r\n");
      out.write("            <span class=\"sr-only\"></span>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</script>\r\n");
      out.write("<script>\r\n");
      out.write("    $(function () {\r\n");
      out.write("         var upload=WebUploader.create({\r\n");
      out.write("             //swf文件路径\r\n");
      out.write("             swf:\"/js/webupload/Uploader.swf\",\r\n");
      out.write("             server:\"/upload\",\r\n");
      out.write("             pick:\"#picker\",\r\n");
      out.write("             fileVal:\"file\"\r\n");
      out.write("         })\r\n");
      out.write("        //选择文件放入上传队列，调用一次\r\n");
      out.write("        upload.on(\"fileQueued\", function (file) {\r\n");
      out.write("                var html=\"<li id='\"+file.id+\"'>\"+file.name+\"</li>\"\r\n");
      out.write("               $(\"#filelist\").append($(html));\r\n");
      out.write("        })\r\n");
      out.write("        //文件上传进度,上传过程中调用多次\r\n");
      out.write("        upload.on(\"uploadProgress\",function (file,percentage) {\r\n");
      out.write("            var num=parseInt(percentage*100);\r\n");
      out.write("            var $bar=$(\"#\"+file.id).find(\"#bar_\"+file.id);\r\n");
      out.write("            if(!$bar[0]){\r\n");
      out.write("                var template=$(\"#bar\").html();\r\n");
      out.write("                template=template.replace(\"{{id}}\",\"bar_\"+file.id);\r\n");
      out.write("                $(\"#\"+file.id).append($(template));\r\n");
      out.write("            }else {\r\n");
      out.write("               $bar.css(\"width\",num+\"%\");\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("        })\r\n");
      out.write("        //上传成功\r\n");
      out.write("        upload.on(\"uploadSuccess\",function (file) {\r\n");
      out.write("            $(\"#\"+file.id).css(\"color\",\"green\")\r\n");
      out.write("        })\r\n");
      out.write("        //文件上传失败\r\n");
      out.write("        upload.on(\"uploadError\",function (file) {\r\n");
      out.write("            $(\"#\"+file.id).css(\"color\",\"red\")\r\n");
      out.write("        })\r\n");
      out.write("        //文件上传失败或成功都调用\r\n");
      out.write("        upload.on(\"uploadComplete\",function (file) {\r\n");
      out.write("            $(\"#\"+file.id).find(\"#bar_\"+file.id).parent().remove();\r\n");
      out.write("        })\r\n");
      out.write("        $(\"#starBtn\").click(function () {\r\n");
      out.write("           upload.upload();\r\n");
      out.write("        })\r\n");
      out.write("\r\n");
      out.write("    })\r\n");
      out.write("</script>\r\n");
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
