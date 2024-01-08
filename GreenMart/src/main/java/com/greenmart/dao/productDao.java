package com.greenmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import com.greenmart.model.*;

public class productDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public productDao(Connection con) {
		this.con = con;
	}
	
	public List<ProductModel> getAllProducts(){
		List<ProductModel> products = new ArrayList<>();
		
		try {
			query = "SELECT * FROM products";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				ProductModel row = new ProductModel();
				row.setProductID(rs.getInt("ProductID"));
				row.setName(rs.getString("name"));
				row.setSize(rs.getString("size"));
				row.setPrice(rs.getDouble("price"));
				row.setImage(rs.getString("image"));
				
				products.add(row);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
        } 
		return products;
	}
	
	public List<CartModel> getCartProducts(ArrayList<CartModel> cartList){
		List<CartModel> products = new ArrayList<CartModel>();
		
		try {
			if(cartList.size() > 0) {
				for(CartModel item:cartList) {
					query = "SELECT * FROM products WHERE ProductID = ?";
					pst = this.con.prepareStatement(query);
					pst.setInt(1, item.getProductID());
					rs = pst.executeQuery();
					
					while(rs.next()) {
						CartModel row = new CartModel();
						row.setProductID(rs.getInt("ProductID"));
						row.setName(rs.getString("name"));
						row.setPrice(rs.getDouble("price") * item.getQuantity());
						row.setQuantity(item.getQuantity());
						products.add(row);
					}
				}
			}
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
//			e.printStackTrace();
		}
		
		return products;
	}
	
	public double getTotalCartPrice(ArrayList<CartModel> cartList) {
		double sum = 0;
		
		try {
			if(cartList.size() > 0) {
				for(CartModel item:cartList) {
					query = "SELECT price FROM products WHERE ProductID = ?";
					pst = this.con.prepareStatement(query);
					pst.setInt(1, item.getProductID());
					rs = pst.executeQuery();
					
					while(rs.next()) {
						sum += rs.getDouble("price") * item.getQuantity();
					}
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return sum;
	}
	
	public ProductModel getProductById(int productId) {
        ProductModel product = null;

        try {
            query = "SELECT * FROM products WHERE ProductID = ?";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, productId);
            rs = pst.executeQuery();

            if (rs.next()) {
                product = new ProductModel();
                product.setProductID(rs.getInt("ProductID"));
                product.setName(rs.getString("name"));
                product.setSize(rs.getString("size"));
                product.setPrice(rs.getDouble("price"));
                product.setImage(rs.getString("image"));
            }

        } catch (Exception e) {
        	e.printStackTrace();
        } 

        return product;
    }
}
