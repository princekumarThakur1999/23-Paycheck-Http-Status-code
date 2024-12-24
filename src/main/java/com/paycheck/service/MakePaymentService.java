package com.paycheck.service;

import org.springframework.stereotype.Service;

@Service
public class MakePaymentService {
	
	public String makePayment() {
		
		//status can be success or failed
		
		String paymentStatus = "Failed"; //data from db : just assume
		
		return paymentStatus;
	}
}
