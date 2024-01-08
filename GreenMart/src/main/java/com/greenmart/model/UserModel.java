package com.greenmart.model;

public class UserModel {
	private int custID;
	private String password;
	private String name;
	private String email;
	private String address;
	private String contactNo;
		
	public UserModel() {
	}

	public UserModel(int custID, String password, String name, String email, String address, String contactNo) {
		this.custID = custID;
		this.password = password;
		this.name = name;
		this.email = email;
		this.address = address;
		this.contactNo = contactNo;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "UserModel [custID=" + custID + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", address=" + address + ", contactNo=" + contactNo + "]";
	}
	
	

}
