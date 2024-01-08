/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.10
 * Generated at: 2024-01-08 22:12:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.*;
import java.util.*;
import com.greenmart.connection.*;
import com.greenmart.model.*;
import com.greenmart.dao.*;
import com.greenmart.servlet.*;

public final class ShoppingCart_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_packages.add("java.text");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("com.greenmart.model");
    _jspx_imports_packages.add("com.greenmart.dao");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("com.greenmart.connection");
    _jspx_imports_packages.add("com.greenmart.servlet");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	DecimalFormat df = new DecimalFormat("#.##");
	request.setAttribute("df", df);

	UserModel auth = (UserModel) request.getSession().getAttribute("auth");
	if (auth != null){
		request.setAttribute("auth", auth);
	}
	
	ArrayList<CartModel> cart_list = (ArrayList<CartModel>) session.getAttribute("cart-list");
	List<CartModel> cartProduct = null;
	
	double total = 0;
	
	if(cart_list != null){
		productDao pDao = new productDao(dbCon.getConnection());
		cartProduct = pDao.getCartProducts(cart_list);
		total = pDao.getTotalCartPrice(cart_list);
		session.setAttribute("cart-total", total);
		request.setAttribute("cart_list", cart_list);
		request.setAttribute("cartProduct", cartProduct);
		request.setAttribute("total", total);
	}

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>Shopping Cart</title>\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css\" />\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<style type = \"text/css\">\r\n");
      out.write("\t\t\t.table tbody td {\r\n");
      out.write("\t\t\t    vertical-align: middle;\r\n");
      out.write("\t\t\t} \r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t.btn-incre, .btn-decre{\r\n");
      out.write("\t\t\t\tbox-shadow: none;\r\n");
      out.write("\t\t\t\tfont-size: 25px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.table thead th, .table tbody td {\r\n");
      out.write("        \t\ttext-align: center; \r\n");
      out.write("   \t\t\t}\r\n");
      out.write("\r\n");
      out.write("    \t\t.table th, .table td {\r\n");
      out.write("        \t\twhite-space: nowrap;\r\n");
      out.write("    \t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t    .table th:not(:last-child),\r\n");
      out.write("\t\t    .table td:not(:last-child) {\r\n");
      out.write("\t\t        padding-right: 15px; \r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t    .d-flex {\r\n");
      out.write("\t\t        display: flex;\r\n");
      out.write("\t\t    }\r\n");
      out.write("\r\n");
      out.write("\t\t    .justify-content-between {\r\n");
      out.write("\t\t        justify-content: space-between;\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t</style>\r\n");
      out.write("\t\t\r\n");
      out.write("        <!--Favicon-->\r\n");
      out.write("\t\t<link rel=\"icon\" type=\"image/x-icon\" href=\"images/favicon.ico\" />\r\n");
      out.write("\t</head>\r\n");
      out.write("\t\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t<div class = \"container\">\r\n");
      out.write("\t\t\t<div class=\"row mt-3\">\r\n");
      out.write("\t            <div class=\"col-md-6\">\r\n");
      out.write("\t                <h3 class=\"total-price\">Total Price: $ ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ (total > 0) ? df.format(total) : 0 }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</h3>\r\n");
      out.write("\t            </div>\r\n");
      out.write("\t\t\t\t<div class=\"col-md-6\">\r\n");
      out.write("\t\t            <a class=\"btn btn-primary\" href=\"index.jsp\">Home</a>\r\n");
      out.write("\t\t        </div>\r\n");
      out.write("\t\t        <div class=\"col-md-6 d-flex justify-content-end\">\r\n");
      out.write("\t\t        \t<a class=\"btn btn-primary\" href=\"cart-check-out?total=");
      out.print( total );
      out.write("\">Check Out</a>\r\n");
      out.write("\t\t        </div>\r\n");
      out.write("        \t</div>\r\n");
      out.write("\t\t\t<div class=\"mt-3\">\r\n");
      out.write("\t\t\t\t<table class = \"table table-light\">\r\n");
      out.write("\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th scope = \"col\">Name</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th scope = \"col\">Price</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th scope = \"col\">Buy Now</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th scope = \"col\">Cancel</th>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t");
 if (cart_list != null){
							for(CartModel c:cartProduct){
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print( c.getName() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print( df.format(c.getPrice()) );
      out.write("$</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td style=\"padding-left: 15%;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<form method=\"POST\" action=\"\" class=\"form-inline\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type = \"hidden\" name = \"id\" value = \"");
      out.print( c.getProductID() );
      out.write("\" class=\"form-input\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"form-group d-flex justify-content-between\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<a class=\"btn btn-sm btn-decre\" href=\"quantityincdec?action=dec&id=");
      out.print( c.getProductID() );
      out.write("\"><i class=\"fas fa-minus-square\"></i></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"quantity\" style=\"text-align: center;\" class=\"form-control\" value=\"");
      out.print( c.getQuantity() );
      out.write("\" readonly>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<a class=\"btn btn-sm btn-incre\" href=\"quantityincdec?action=inc&id=");
      out.print( c.getProductID() );
      out.write("\"><i class=\"fas fa-plus-square\"></i></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href = \"removecart?id=");
      out.print( c.getProductID() );
      out.write("\" class = \"btn btn-sm btn-danger\">Remove</a> \r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t");
}
						}
					
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</tbody>\t\t\t\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<script src=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/js/all.min.js\"></script>\r\n");
      out.write("\t\t<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\"></script>\r\n");
      out.write("\t\t<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js\"></script>\r\n");
      out.write("\t\t<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js\"></script>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
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
