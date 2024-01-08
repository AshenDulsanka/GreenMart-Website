package com.greenmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.greenmart.model.UserModel;

public class userDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public userDao(Connection con) {
		this.con = con;
	}
	
	public UserModel userLogin(String email, String password) {
		UserModel user = null;
		try {
			query = "SELECT * FROM customers WHERE email=? AND password=?";
			pst = this.con.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, password);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				user = new UserModel();
				user.setCustID(rs.getInt("custID"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		
		return user;
	}
}
