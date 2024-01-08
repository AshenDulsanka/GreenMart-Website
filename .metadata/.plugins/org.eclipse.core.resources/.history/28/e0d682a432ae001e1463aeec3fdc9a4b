package com.greenmart.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greenmart.model.*;

@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		try(PrintWriter out = response.getWriter()){
			ArrayList<CartModel> cartList = new ArrayList<>();
			
			int productID = Integer.parseInt(request.getParameter("id"));
			CartModel cm = new CartModel();
			cm.setProductID(productID);
			cm.setQuantity(1);
			
			HttpSession session = request.getSession();
			ArrayList<CartModel> cart_list = (ArrayList<CartModel>)session.getAttribute("cart-list");
			
			if(cart_list == null) {
				cartList.add(cm);
				session.setAttribute("cart-list", cartList);
				response.sendRedirect("index.jsp");
			} else {
				cartList = cart_list;
				boolean exist = false;
				
				for(CartModel c:cart_list) {
					if(c.getProductID() == productID) {
						exist = true;
						response.sendRedirect("ShoppingCart.jsp");
					} 				
				}
				
				if(!exist) {
					cartList.add(cm);
					response.sendRedirect("index.jsp");
				}
			}
		}
	}


}
