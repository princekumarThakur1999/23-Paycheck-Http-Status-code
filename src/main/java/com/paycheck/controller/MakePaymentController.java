package com.paycheck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.paycheck.model.PaymentDetails;
import com.paycheck.service.MakePaymentService;

@RestController
@RequestMapping("/make")
public class MakePaymentController {
	
	@Autowired
	MakePaymentService paymentservice;
	
	@GetMapping("/info")
	public String paymentInfo() {
		
		//controller to service
		//service to repository
		//Response back to service
		//Response back to controller
		
		//payment response can be inserted, existed and failed
		String response = "existed";
		if(response.equalsIgnoreCase("Inserted")) {
			
			//send response code 201 created.
		}else if(response.equalsIgnoreCase("existed")) {
			
			//send response code 200 
		}else {
			
			//send response code  
		}
		
		return "Successfully payment is done.";
	}
	
	@PostMapping("/payment")
	public ResponseEntity<String> makePayment(){
		
		String response = paymentservice.makePayment();
		
		if(response.equalsIgnoreCase("Success")) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		else if(response.equalsIgnoreCase("Failed")) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		else {
		return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
		}
	}
	
	//Get payment details with custome object
	@GetMapping("/payment/get/payment/{paymentId}")
	public ResponseEntity<PaymentDetails>  getPaymentdetails(@PathVariable String paymentId) {
		
		PaymentDetails paymentdetails = paymentservice.getPaymentData(paymentId);
		
		if(paymentdetails != null) {
			return new ResponseEntity<PaymentDetails>(paymentdetails, HttpStatus.OK);
		}
		return new ResponseEntity<PaymentDetails>(paymentdetails, HttpStatus.NO_CONTENT);
	}
	
	//delete payment details 
		@DeleteMapping("/delete/payment/{paymentId}")
		public ResponseEntity<String>  deletePaymentdetails(@PathVariable String paymentId) {
			
			String result = paymentservice.deletePaymentData(paymentId);
			
			if(result != null) {
				return new ResponseEntity<String>(result, HttpStatus.OK);
			}
			return new ResponseEntity<String>("No Payment is existed", HttpStatus.NO_CONTENT);
		}
		
	//Get payment details and status code should be always single value at any situation
		@GetMapping("/payment/get")
		@ResponseStatus(value = HttpStatus.CREATED) // we can use @ResponseStatus as a ResponseEntity to get http status code
		private String getMoneylocation(){
			
			return "Data is Considered";
		}
}
