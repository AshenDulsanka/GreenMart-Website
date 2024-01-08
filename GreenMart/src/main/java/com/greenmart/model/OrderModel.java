package com.greenmart.model;

public class OrderModel extends ProductModel{
	private int orderID;
	private int custID;
	private int quantity;
	private String date;
	private double amount;
	
	public OrderModel() {
		
	}

	public OrderModel(int orderID, int custID, int quantity, String date, double amount) {
		super();
		this.orderID = orderID;
		this.custID = custID;
		this.quantity = quantity;
		this.date = date;
		this.amount = amount;
	}

	public OrderModel(int custID, int quantity, String date, double amount) {
		super();
		this.custID = custID;
		this.quantity = quantity;
		this.date = date;
		this.amount = amount;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "OrderModel [orderID=" + orderID + ", custID=" + custID + ", quantity=" + quantity + ", date=" + date
				+ ", amount=" + amount + "]";
	}
	
	
}
