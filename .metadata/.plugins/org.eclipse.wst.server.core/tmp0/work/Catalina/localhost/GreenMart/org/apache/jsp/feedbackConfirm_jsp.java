/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.10
 * Generated at: 2024-01-08 21:46:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class feedbackConfirm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>Feedback Form</title>\r\n");
      out.write("\t\t<style>\r\n");
      out.write("\r\n");
      out.write("            @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');\r\n");
      out.write("\t\t\t*{\r\n");
      out.write("\t\t\t\tmargin:0;\r\n");
      out.write("\t\t\t\tpadding:0;\r\n");
      out.write("                font-family: 'Poppins', sans-serif;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tbody{\r\n");
      out.write("\t\t\t\tdisplay:flex;\r\n");
      out.write("\t\t\t\tmin-height:100vh;\r\n");
      out.write("\t\t\t\talign-items:center;\r\n");
      out.write("\t\t\t\tjustify-content:center;\r\n");
      out.write("\t\t\t\tbackground: #c8efd1;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.box{\r\n");
      out.write("\t\t\t\theight:380px;\r\n");
      out.write("\t\t\t\twidth:400px;\r\n");
      out.write("\t\t\t\tbackground:#101012;\r\n");
      out.write("\t\t\t\tpadding:20px;\r\n");
      out.write("                box-shadow: 4px 4px 2px #fdd01c;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.box div{\r\n");
      out.write("\t\t\t\tcolor:#ffe400;\r\n");
      out.write("\t\t\t\tfont-size:30px;\r\n");
      out.write("\t\t\t\tfont-family:sans-serif;\r\n");
      out.write("\t\t\t\tfont-weight:800;\r\n");
      out.write("\t\t\t\ttext-align:center;\r\n");
      out.write("\t\t\t\tpadding:20px 0;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.btn{\r\n");
      out.write("\t\t\t\tborder-radius:20px;\r\n");
      out.write("\t\t\t\tcolor:#fff;\r\n");
      out.write("\t\t\t\tmargin-top:18px;\r\n");
      out.write("\t\t\t\tpadding:10px;\r\n");
      out.write("\t\t\t\tbackground-color:#47c35a;\r\n");
      out.write("\t\t\t\tfont-size:18px;\r\n");
      out.write("\t\t\t\tborder:none;\r\n");
      out.write("\t\t\t\tcursor:pointer;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</style>\r\n");
      out.write("\t\t\r\n");
      out.write("        <!--Favicon-->\r\n");
      out.write("\t\t<link rel=\"icon\" type=\"image/x-icon\" href=\"images/favicon.ico\" />\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<div class=\"box\">\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<h1>Thank You</h1><br>\r\n");
      out.write("\t\t\t\t<h5>Your feedback has been submitted. We shall take it into consideration to improve our website.</h5>\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn\">\r\n");
      out.write("\t\t\t\t\t<a href=\"index.jsp\"style = 'color: white; text-decoration: none;'>Home</a>\r\n");
      out.write("\t\t\t\t</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}