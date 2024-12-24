package com.paycheck.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.paycheck.model.PaymentDetails;

@Service
public class MakePaymentService {
	
	public String makePayment() {
		
		//status can be success or failed
		
		String paymentStatus = "Failed"; //data from db : just assume
		
		return paymentStatus;
	}

	public PaymentDetails getPaymentData(String paymentId) {
		
		//Geting Payment details from db to repo and repo to service
		boolean isPaymentExists = true; // there should be some validation who will check paymentId. 
	//	boolean isPaymentExists = false; //if exist then true otherwise false
		
		if(isPaymentExists) {
		PaymentDetails paymentdetails = new PaymentDetails();
		paymentdetails.setPaymentId("Paycheck0123");
		paymentdetails.setPaymentStatus("success");
		paymentdetails.setPaymentdate(LocalDate.now().toString());
		
	    return paymentdetails;
		}
		else
			
			return null;
	}
	
	public String deletePaymentData(String paymentId) {
		
		//delete payemntdata from db and fetch data from repo to service layer
		boolean isPaymentExists = false ; // if payment is available in the db
		//boolean isPaymentExists = false	--> if payment is not available in the db						
		
			String result = null;
			if(isPaymentExists) {
				return result = "Delete Successfully"; 
			}
			else {
				 return result;
			}

	}
}
