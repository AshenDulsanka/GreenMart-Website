package com.greenmart.model;

public class feedBackModel {
	private int feedbackID;
	private int custID;
	private String text;
	private String date;
	
	public feedBackModel() {
	}

	public feedBackModel(int feedbackID, int custID, String text, String date) {
		this.feedbackID = feedbackID;
		this.custID = custID;
		this.text = text;
		this.date = date;
	}

	public int getFeedbackID() {
		return feedbackID;
	}

	public void setFeedbackID(int feedbackID) {
		this.feedbackID = feedbackID;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "feedBackModel [feedbackID=" + feedbackID + ", custID=" + custID + ", text=" + text + ", date=" + date
				+ "]";
	}
	
	
}
