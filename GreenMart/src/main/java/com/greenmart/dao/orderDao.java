package com.greenmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.greenmart.model.*;

public class orderDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public orderDao(Connection con) {
		this.con = con;
	}
	
	public boolean insertOrder(OrderModel model) {
		boolean result = false;
		
		try {
			query = "INSERT INTO orders (productID, custID, quantity, orderDate, orderAmount) VALUES (?,?,?,?,?)";
			
			pst = this.con.prepareStatement(query);
			pst.setInt(1, model.getProductID());
			pst.setInt(2, model.getCustID());
			pst.setInt(3, model.getQuantity());
			pst.setString(4, model.getDate());
			pst.setDouble(5, model.getAmount());
			pst.executeUpdate();
			
			result = true;
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
