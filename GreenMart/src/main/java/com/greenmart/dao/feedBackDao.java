package com.greenmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.greenmart.model.feedBackModel;


public class feedBackDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	
	public feedBackDao(Connection con) {
		this.con = con;
	}
	
	public boolean insertFeedBack(feedBackModel model) {
		boolean result = false;
		
		try {
			query = "INSERT INTO feedbacks (custID, feedbackText, feedbackDate) VALUES (?,?,?)";
			
			pst = this.con.prepareStatement(query);
			pst.setInt(1, model.getCustID());
			pst.setString(2, model.getText());
			pst.setString(3, model.getDate());
			pst.executeUpdate();
			
			result = true;
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}	
	
}
