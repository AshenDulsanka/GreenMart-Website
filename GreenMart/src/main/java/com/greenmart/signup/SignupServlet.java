package com.greenmart.signup;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greenmart.connection.*;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("name");
		String uemail = request.getParameter("email");
		String upass = request.getParameter("pass");
		String reupass = request.getParameter("re_pass");
		String umobile = request.getParameter("contact");
		String uaddress = request.getParameter("address");
		
		Connection con = null;
		RequestDispatcher dispatcher = null;
		
		if(uname == null || uname.equals("")) {
			request.setAttribute("status", "invalidName");
			dispatcher = request.getRequestDispatcher("signup.jsp");
			dispatcher.forward(request, response);
		}if(uemail == null || uemail.equals("")) {
			request.setAttribute("status", "invalidEmail");
			dispatcher = request.getRequestDispatcher("signup.jsp");
			dispatcher.forward(request, response);
		}if(upass == null || upass.equals("")) {
			request.setAttribute("status", "invalidPassword");
			dispatcher = request.getRequestDispatcher("signup.jsp");
			dispatcher.forward(request, response);
		} else if(!upass.equals(reupass)){
			request.setAttribute("status", "invalidConfirmPassword");
			dispatcher = request.getRequestDispatcher("signup.jsp");
			dispatcher.forward(request, response);
		}if(umobile == null || umobile.equals("")) {
			request.setAttribute("status", "invalidMobile");
			dispatcher = request.getRequestDispatcher("signup.jsp");
			dispatcher.forward(request, response);
		}else if(umobile.length() > 10) {
			request.setAttribute("status", "invalidMobileLength");
			dispatcher = request.getRequestDispatcher("signup.jsp");
			dispatcher.forward(request, response);
		}if(uaddress == null || uaddress.equals("")) {
			request.setAttribute("status", "invalidAddress");
			dispatcher = request.getRequestDispatcher("signup.jsp");
			dispatcher.forward(request, response);
		} 
		
		try {
			con = dbCon.getConnection();
			PreparedStatement pst = con.prepareStatement("INSERT INTO customers(name, email, password, contactNo, address) VALUES (?,?,?,?,?)");
			pst.setString(1, uname);
			pst.setString(2, uemail);
			pst.setString(3, upass);
			pst.setString(4, umobile);
			pst.setString(5, uaddress);
			
			int rowCount = pst.executeUpdate();
			
			dispatcher = request.getRequestDispatcher("signup.jsp");
			
			if (rowCount > 0) {
				request.setAttribute("status", "success");
				
			} else {
				request.setAttribute("status", "failed");
			}
			
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
