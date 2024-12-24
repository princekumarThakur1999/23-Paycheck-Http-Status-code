package com.paycheck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
