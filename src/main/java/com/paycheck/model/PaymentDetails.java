package com.paycheck.model;

import java.time.LocalDate;

public class PaymentDetails {
	
	private String paymentId;
	private String paymentStatus;
	private String paymentdate;
	public PaymentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getPaymentdate() {
		return paymentdate;
	}
	public void setPaymentdate(String localDate) {
		this.paymentdate = localDate;
	}
}
