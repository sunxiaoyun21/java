/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2016-12-22 01:37:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.topic;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newtopic_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/view/topic/../include/common.jsp", Long.valueOf(1482288093306L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fotherwise;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fotherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fotherwise.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>发布新主题</title>\r\n");
      out.write("    <link href=\"http://cdn.bootcss.com/font-awesome/4.5.0/css/font-awesome.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"http://cdn.bootcss.com/bootstrap/2.3.1/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/static/css/style.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/static/js/editer/styles/simditor.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"header-bar\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <a href=\"/ttl\" class=\"brand\">\r\n");
      out.write("            <i class=\"fa fa-reddit-alien\"></i>\r\n");
      out.write("        </a>\r\n");
      out.write("        <ul class=\"unstyled inline pull-right\">\r\n");
      out.write("            ");
      if (_jspx_meth_c_005fchoose_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("<!--header-bar end-->\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("    <div class=\"box\">\r\n");
      out.write("        <div class=\"box-header\">\r\n");
      out.write("            <span class=\"title\"><i class=\"fa fa-plus\"></i> 发布新主题</span>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <form action=\"\" id=\"topicForm\" style=\"padding: 20px\">\r\n");
      out.write("            <label class=\"control-label\">主题标题</label>\r\n");
      out.write("            <input name=\"title\" id=\"title\" type=\"text\" style=\"width: 100%;box-sizing: border-box;height: 30px\" placeholder=\"请输入主题标题，如果标题能够表达完整内容，则正文可以为空\">\r\n");
      out.write("            <label class=\"control-label\">正文</label>\r\n");
      out.write("            <textarea name=\"content\" id=\"editor\"></textarea>\r\n");
      out.write("\r\n");
      out.write("            <select name=\"nodeid\" id=\"nodeid\" style=\"margin-top:15px;\">\r\n");
      out.write("                <option value=\"\">请选择节点</option>\r\n");
      out.write("                ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("            </select>\r\n");
      out.write("\r\n");
      out.write("        </form>\r\n");
      out.write("        <div class=\"form-actions\" style=\"text-align: right\">\r\n");
      out.write("            <button id=\"sendBtn\"class=\"btn btn-primary\">发布主题</button>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--box end-->\r\n");
      out.write("</div>\r\n");
      out.write("<!--container end-->\r\n");
      out.write("<script src=\"http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"/static/js/editer/scripts/module.min.js\"></script>\r\n");
      out.write("<script src=\"/static/js/editer/scripts/hotkeys.min.js\"></script>\r\n");
      out.write("<script src=\"/static/js/editer/scripts/uploader.min.js\"></script>\r\n");
      out.write("<script src=\"/static/js/editer/scripts/simditor.min.js\"></script>\r\n");
      out.write("<script src=\"//cdn.bootcss.com/jquery-validate/1.15.0/jquery.validate.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("    $(function () {\r\n");
      out.write("        var editer=new Simditor({\r\n");
      out.write("            textarea:$(\"#editor\")\r\n");
      out.write("        });\r\n");
      out.write("        $(\"#sendBtn\").click(function () {\r\n");
      out.write("            $(\"#topicForm\").submit();\r\n");
      out.write("        });\r\n");
      out.write("        $(\"#topicForm\").validate({\r\n");
      out.write("            errorElement:\"text\",\r\n");
      out.write("            errorClass:\"text-error\",\r\n");
      out.write("            rules:{\r\n");
      out.write("               title:{\r\n");
      out.write("                   required:true\r\n");
      out.write("               },\r\n");
      out.write("                nodeid:{\r\n");
      out.write("                   required:true\r\n");
      out.write("                }\r\n");
      out.write("            },\r\n");
      out.write("            messages:{\r\n");
      out.write("                title:{\r\n");
      out.write("                    required:\"请输入标题\"\r\n");
      out.write("                },\r\n");
      out.write("                nodeid:{\r\n");
      out.write("                    required:\"请选择节点\"\r\n");
      out.write("                }\r\n");
      out.write("            },\r\n");
      out.write("            submitHandler:function (form) {\r\n");
      out.write("                var data=$(form).serialize();\r\n");
      out.write("                $.post(\"/newtopic\",data).done(function (json) {\r\n");
      out.write("                    if(json.state=\"success\"){\r\n");
      out.write("                        alert(\"发帖成功\")\r\n");
      out.write("                        location.href=\"/topicdetail?topicid=\"+json.topic.id;\r\n");
      out.write("                    }else {\r\n");
      out.write("                        alert(\"发帖失败，请稍后重试\")\r\n");
      out.write("                    }\r\n");
      out.write("                }).error(function () {\r\n");
      out.write("                    alert(\"客户端错误\")\r\n");
      out.write("                })\r\n");
      out.write("            }\r\n");
      out.write("        })\r\n");
      out.write("        \r\n");
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

  private boolean _jspx_meth_c_005fchoose_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_005fchoose_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fchoose_005f0.setParent(null);
    int _jspx_eval_c_005fchoose_005f0 = _jspx_th_c_005fchoose_005f0.doStartTag();
    if (_jspx_eval_c_005fchoose_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                ");
        if (_jspx_meth_c_005fwhen_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                ");
        if (_jspx_meth_c_005fotherwise_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_005fchoose_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fchoose_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    // /WEB-INF/view/topic/../include/common.jsp(17,16) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty sessionScope.curr}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
    if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                <li>\r\n");
        out.write("                    <a href=\"/setting\">\r\n");
        out.write("                        <img id=\"navbar-avatar\" src=\"http://ohwn2cnss.bkt.clouddn.com/");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.curr.avatar}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("?imageView2/1/w/30/h/30\" class=\"img-circle\" alt=\"\" >\r\n");
        out.write("                    </a>\r\n");
        out.write("                </li>\r\n");
        out.write("                <li>\r\n");
        out.write("                    <a href=\"/newtopic\"><i class=\"fa fa-plus\"></i></a>\r\n");
        out.write("                </li>\r\n");
        out.write("                <li>\r\n");
        out.write("                    <a href=\"#\"><i class=\"fa fa-bell\"></i></a>\r\n");
        out.write("                </li>\r\n");
        out.write("                <li>\r\n");
        out.write("                    <a href=\"/setting\"><i class=\"fa fa-cog\"></i></a>\r\n");
        out.write("                </li>\r\n");
        out.write("                <li>\r\n");
        out.write("                    <a href=\"/logout\"><i class=\"fa fa-sign-out\"></i></a>\r\n");
        out.write("                </li>\r\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fotherwise_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_005fotherwise_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fotherwise_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    int _jspx_eval_c_005fotherwise_005f0 = _jspx_th_c_005fotherwise_005f0.doStartTag();
    if (_jspx_eval_c_005fotherwise_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                    <li style=\"margin-top: 15px\">\r\n");
        out.write("                        <a href=\"/login\"><i class=\"fa fa-sign-in\"></i></a>\r\n");
        out.write("                    </li>\r\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_c_005fotherwise_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fotherwise_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/view/topic/newtopic.jsp(31,16) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/view/topic/newtopic.jsp(31,16) '${nodeList}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${nodeList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/view/topic/newtopic.jsp(31,16) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("node");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                    <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${node.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${node.nodename}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</option>\r\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}