package com.greenmart.model;

public class ProductModel {
	private int productID;
	private String name;
	private double price;
	private String image;
	private String size;
	
	
	public ProductModel() {
	}


	public ProductModel(int productID, String name, double price, String image, String size) {
		super();
		this.productID = productID;
		this.name = name;
		this.price = price;
		this.image = image;
		this.size = size;
	}


	public int getProductID() {
		return productID;
	}


	public void setProductID(int productID) {
		this.productID = productID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}
	
	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}
	
}
