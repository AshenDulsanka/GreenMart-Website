package com.greenmart.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.greenmart.connection.dbCon;
import com.greenmart.dao.*;
import com.greenmart.model.*;

@WebServlet("/cart-check-out")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()){
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();

		    double total = Double.parseDouble(request.getParameter("total"));;
			ArrayList<CartModel> cart_list = (ArrayList<CartModel>) request.getSession().getAttribute("cart-list");
			UserModel auth = (UserModel) request.getSession().getAttribute("auth");
			
			if(cart_list != null && auth != null) {
				for(CartModel c:cart_list) {
					productDao dao = new productDao(dbCon.getConnection());
				    ProductModel product = dao.getProductById(c.getProductID());
					if (product != null) {
						OrderModel order = new OrderModel();
						order.setProductID(c.getProductID());
						order.setCustID(auth.getCustID());
						order.setQuantity(c.getQuantity());
						order.setDate(formatter.format(date));
						order.setAmount(product.getPrice() * c.getQuantity());
						
						orderDao oDao = new orderDao(dbCon.getConnection());
						boolean result = oDao.insertOrder(order);
						
						if(!result) break;
					}
				}
				sendEmail(auth.getEmail(), cart_list, total, auth);
				cart_list.clear();
				response.sendRedirect("paypalCheckout.jsp");
				
			} else {
				if (auth == null) {
					response.sendRedirect("login.jsp");
				} else {
					response.sendRedirect("ShoppingCart.jsp");
				}
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void sendEmail(String userEmail, ArrayList<CartModel> cartList, double total, UserModel auth) {
		DecimalFormat df = new DecimalFormat("#.##");
	    // Sender's email and password
	    final String username = "greenmartlankan@gmail.com"; // Replace with your email
	    final String password = "ruzh ajne ddzv iswc"; // Replace with your email password

	    // SMTP server properties
	    Properties props = new Properties();
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", "smtp.gmail.com"); // Replace with your SMTP server
	    props.put("mail.smtp.port", "587"); // Replace with your SMTP server port

	    // Create a session with the SMTP server
	    Session session = Session.getInstance(props, new Authenticator() {
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	        }
	    });

	    try {
	        // Create a default MimeMessage object
	        Message message = new MimeMessage(session);

	        // Set From: header field
	        message.setFrom(new InternetAddress(username));

	        // Set To: header field
	        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail));

	        // Set Subject: header field
	        message.setSubject("Purchase Confirmation");

	        // Set the email body
	        StringBuilder body = new StringBuilder();
	        body.append("Dear ").append(auth.getName()).append(",\n\n");
	        body.append("Thank you for your purchase. \n");

	        body.append("\nTotal Price: $").append(df.format(total));

	        message.setText(body.toString());

	        // Send the message
	        Transport.send(message);

	        System.out.println("Email sent successfully!");

	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
	}
}
