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

@WebServlet("/quantityincdec")
public class QuantityIncreDecreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		try(PrintWriter out = response.getWriter();){
			String action = request.getParameter("action");
			int productID = Integer.parseInt(request.getParameter("id"));
			
			ArrayList<CartModel> cart_list = (ArrayList<CartModel>)request.getSession().getAttribute("cart-list");
			
			if(action != null && productID >= 1) {
				if(action.equals("inc")) {
					for(CartModel c:cart_list) {
						if(c.getProductID() == productID) {
							int quantity = c.getQuantity();
							quantity++;
							c.setQuantity(quantity);
							response.sendRedirect("ShoppingCart.jsp");
						}
					}
				}
				
				if(action.equals("dec")) {
					for(CartModel c:cart_list) {
						if(c.getProductID() == productID && c.getQuantity() > 1) {
							int quantity = c.getQuantity();
							quantity--;
							c.setQuantity(quantity);
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
