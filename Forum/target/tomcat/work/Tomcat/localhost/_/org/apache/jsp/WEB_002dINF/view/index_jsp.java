/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2016-12-22 01:37:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/view/include/common.jsp", Long.valueOf(1482288093306L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fotherwise;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fotherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fotherwise.release();
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
      out.write("    <link href=\"http://cdn.bootcss.com/font-awesome/4.5.0/css/font-awesome.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"http://cdn.bootcss.com/bootstrap/2.3.1/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/static/css/style.css\">\r\n");
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
      out.write("\r\n");
      out.write("<!--header-bar end-->\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("    <div class=\"box\">\r\n");
      out.write("        <div class=\"talk-item\">\r\n");
      out.write("            <ul class=\"topic-type unstyled inline\" style=\"margin-bottom:0px;\">\r\n");
      out.write("                <li class=\"active\"><a href=\"\">全部</a></li>\r\n");
      out.write("                <li><a href=\"\">问与答</a></li>\r\n");
      out.write("                <li><a href=\"\">分享</a></li>\r\n");
      out.write("                <li><a href=\"\">Java</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"talk-item\">\r\n");
      out.write("            <table class=\"talk-table\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td width=\"50\">\r\n");
      out.write("                        <img class=\"avatar\" src=\"../../static/img/1.jpg\" alt=\"\" style=\"width:40px;height:40px;\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"80\">\r\n");
      out.write("                        <a href=\"\">xiaoyun</a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"auto\">\r\n");
      out.write("                        <a href=\"#\">如何看待Goole离开大陆市场</a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"50\" align=\"center\">\r\n");
      out.write("                        <span class=\"badge\">12</span>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"talk-item\">\r\n");
      out.write("            <table class=\"talk-table\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td width=\"50\">\r\n");
      out.write("                        <img class=\"avatar\" src=\"../../static/img/1.jpg\" alt=\"\" style=\"width:40px;height:40px;\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"80\">\r\n");
      out.write("                        <a href=\"\">xiaoyun</a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"auto\">\r\n");
      out.write("                        <a href=\"#\">女程序员有歧视</a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"50\" align=\"center\">\r\n");
      out.write("                        <span class=\"badge\">12</span>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"talk-item\">\r\n");
      out.write("            <table class=\"talk-table\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td width=\"50\">\r\n");
      out.write("                        <img class=\"avatar\" src=\"../../static/img/1.jpg\" alt=\"\" style=\"width:40px;height:40px;\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"80\">\r\n");
      out.write("                        <a href=\"\">xiaoyun</a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"auto\">\r\n");
      out.write("                        <a href=\"#\">Python和Ruby哪个语言好</a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"50\" align=\"center\">\r\n");
      out.write("                        <span class=\"badge\">12</span>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"talk-item\">\r\n");
      out.write("            <table class=\"talk-table\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td width=\"50\">\r\n");
      out.write("                        <img class=\"avatar\" src=\"../../static/img/1.jpg\" alt=\"\" style=\"width:40px;height:40px;\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"80\">\r\n");
      out.write("                        <a href=\"\">xiaoyun</a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"auto\">\r\n");
      out.write("                        <a href=\"#\">今年的圣诞如何过</a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"50\" align=\"center\">\r\n");
      out.write("                        <span class=\"badge\">12</span>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"talk-item\">\r\n");
      out.write("            <table class=\"talk-table\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td width=\"50\">\r\n");
      out.write("                        <img class=\"avatar\" src=\"../../static/img/1.jpg\" alt=\"\" style=\"width:40px;height:40px;\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"80\">\r\n");
      out.write("                        <a href=\"\">xiaoyun</a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"auto\">\r\n");
      out.write("                        <a href=\"#\">论坛对于一些90后是听都没听过的东西</a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"50\" align=\"center\">\r\n");
      out.write("                        <span class=\"badge\">12</span>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"talk-item\">\r\n");
      out.write("            <table class=\"talk-table\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td width=\"50\">\r\n");
      out.write("                        <img class=\"avatar\" src=\"../../static/img/1.jpg\" alt=\"\" style=\"width:40px;height:40px;\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"80\">\r\n");
      out.write("                        <a href=\"\">xiaoyun</a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"auto\">\r\n");
      out.write("                        <a href=\"#\">苹果公司越做越烂</a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"50\" align=\"center\">\r\n");
      out.write("                        <span class=\"badge\">12</span>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"talk-item\">\r\n");
      out.write("            <table class=\"talk-table\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td width=\"50\">\r\n");
      out.write("                        <img class=\"avatar\" src=\"../../static/img/1.jpg\" alt=\"\" style=\"width:40px;height:40px;\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"80\">\r\n");
      out.write("                        <a href=\"\">xiaoyun</a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"auto\">\r\n");
      out.write("                        <a href=\"#\">写了一个可以把你网站所有 js 代码格式化成圣诞树的 NodeJS 库： js2image</a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"50\" align=\"center\">\r\n");
      out.write("                        <span class=\"badge\">12</span>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"talk-item\">\r\n");
      out.write("            <table class=\"talk-table\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td width=\"50\">\r\n");
      out.write("                        <img class=\"avatar\" src=\"../../static/img/1.jpg\" alt=\"\" style=\"width:40px;height:40px;\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"80\">\r\n");
      out.write("                        <a href=\"\">xiaoyun</a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"auto\">\r\n");
      out.write("                        <a href=\"#\">王健林和马云PK唱演员，你是怎么看待的</a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"50\" align=\"center\">\r\n");
      out.write("                        <span class=\"badge\">12</span>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"talk-item\">\r\n");
      out.write("            <table class=\"talk-table\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td width=\"50\">\r\n");
      out.write("                        <img class=\"avatar\" src=\"../../static/img/1.jpg\" alt=\"\" style=\"width:40px;height:40px;\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"80\">\r\n");
      out.write("                        <a href=\"\">xiaoyun</a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"auto\">\r\n");
      out.write("                        <a href=\"#\">对于大陆版权我也是没谁了</a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"50\" align=\"center\">\r\n");
      out.write("                        <span class=\"badge\">12</span>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"talk-item\">\r\n");
      out.write("            <table class=\"talk-table\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td width=\"50\">\r\n");
      out.write("                        <img class=\"avatar\" src=\"../../static/img/1.jpg\" alt=\"\" style=\"width:40px;height:40px;\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"80\">\r\n");
      out.write("                        <a href=\"\">xiaoyun</a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"auto\">\r\n");
      out.write("                        <a href=\"#\">网易云音乐的推荐很赞</a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"50\" align=\"center\">\r\n");
      out.write("                        <span class=\"badge\">12</span>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"talk-item\">\r\n");
      out.write("            <table class=\"talk-table\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td width=\"50\">\r\n");
      out.write("                        <img class=\"avatar\" src=\"../../static/img/1.jpg\" alt=\"\" style=\"width:40px;height:40px;\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"80\">\r\n");
      out.write("                        <a href=\"\">xiaoyun</a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"auto\">\r\n");
      out.write("                        <a href=\"#\">e</a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"50\" align=\"center\">\r\n");
      out.write("                        <span class=\"badge\">12</span>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"talk-item\">\r\n");
      out.write("            <table class=\"talk-table\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td width=\"50\">\r\n");
      out.write("                        <img class=\"avatar\" src=\"../../static/img/1.jpg\" alt=\"\" style=\"width:40px;height:40px;\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"80\">\r\n");
      out.write("                        <a href=\"\">xiaoyun</a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"auto\">\r\n");
      out.write("                        <a href=\"#\">如何看待前端</a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"50\" align=\"center\">\r\n");
      out.write("                        <span class=\"badge\">12</span>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"talk-item\">\r\n");
      out.write("            <table class=\"talk-table\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td width=\"50\">\r\n");
      out.write("                        <img class=\"avatar\" src=\"../../static/img/1.jpg\" alt=\"\" style=\"width:40px;height:40px;\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"80\">\r\n");
      out.write("                        <a href=\"\">xiaoyun</a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"auto\">\r\n");
      out.write("                        <a href=\"#\">ajax是主流么</a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"50\" align=\"center\">\r\n");
      out.write("                        <span class=\"badge\">12</span>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"talk-item\">\r\n");
      out.write("            <table class=\"talk-table\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td width=\"50\">\r\n");
      out.write("                        <img class=\"avatar\" src=\"../../static/img/1.jpg\" alt=\"\" style=\"width:40px;height:40px;\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"80\">\r\n");
      out.write("                        <a href=\"\">xiaoyun</a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"auto\">\r\n");
      out.write("                        <a href=\"#\">maven</a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td width=\"50\" align=\"center\">\r\n");
      out.write("                        <span class=\"badge\">12</span>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--box end-->\r\n");
      out.write("</div>\r\n");
      out.write("<!--container end-->\r\n");
      out.write("<div class=\"footer\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        Copyright © 2016 sxy\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
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
    // /WEB-INF/view/include/common.jsp(17,16) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
}
