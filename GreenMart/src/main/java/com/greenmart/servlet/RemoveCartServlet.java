package com.greenmart.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greenmart.model.*;


@WebServlet("/removecart")
public class RemoveCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		try(PrintWriter out = response.getWriter()){
			String productID = request.getParameter("id");
			
			if(productID != null) {
				ArrayList<CartModel> cart_list =  (ArrayList<CartModel>) request.getSession().getAttribute("cart-list");
				
				if(cart_list != null) {
					for(CartModel c:cart_list) {
						if(c.getProductID() == Integer.parseInt(productID)) {
							cart_list.remove(cart_list.indexOf(c));
							break;
						}
					}
					response.sendRedirect("ShoppingCart.jsp");
				}
			} else {
				response.sendRedirect("ShoppingCart.jsp");
			}
		}
	}

}
