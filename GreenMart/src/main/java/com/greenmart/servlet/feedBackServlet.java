package com.greenmart.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greenmart.connection.dbCon;
import com.greenmart.dao.*;
import com.greenmart.model.*;

@WebServlet("/feedBack")
public class feedBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try(PrintWriter out = response.getWriter()){
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();

			UserModel auth = (UserModel) request.getSession().getAttribute("auth");
			
			if(auth != null) {
				String feedbackText = request.getParameter("message");
				feedBackModel feedBack = new feedBackModel();
				feedBack.setCustID(auth.getCustID());
				feedBack.setText(feedbackText);
				feedBack.setDate(formatter.format(date));
				
				feedBackDao fDao = new feedBackDao(dbCon.getConnection());
				boolean result = fDao.insertFeedBack(feedBack);
				if (result) {
                    response.sendRedirect("feedbackConfirm.jsp");
                }
			} else {
				if (auth == null) {
					response.sendRedirect("login.jsp");
				} 
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
