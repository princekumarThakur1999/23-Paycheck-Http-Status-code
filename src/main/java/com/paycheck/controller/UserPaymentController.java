package com.paycheck.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserPaymentController {
	
	//Header Attribute got from client in the Request
	@GetMapping("/info")
	public String getUserInfo(@RequestHeader("User-Access") String userAccess ) {
		
		String userDetails = "This is a User access details : " + userAccess;
		
		return userDetails;
	}
	
	@GetMapping("/details")
	public String getUserDetails(@RequestHeader(value = "User-Access", required = false, defaultValue = "Prince jymar") String userAccess,
								@RequestParam("location") String location) {
		
		String userDetails = "This is a User access details : " + userAccess + " & User location is " + location;
		
		return userDetails;
	}
	
	//Header Attribute send to Response Header
	@GetMapping("/information")
	public ResponseEntity<Map<String,String>> getUserIdentify(){
		
		//send info to service layer then Repo layer
		//get data from repo to service then controller layer
		
		//create Custom Header
		HttpHeaders header = new HttpHeaders();
		header.add("Custom-Header", "this a custom header");
		
		//Create Json response body
		Map<String, String> response = new HashMap<>();
		response.put("Key", "Value");
		response.put("Name", "Prince kumar Thakur");
		response.put("Contact", "+91 9131331059");
		response.put("location", "Hyderabad");
		
		return new ResponseEntity<>(response, header, HttpStatus.CREATED);
	}
	
	//Consume All HTTP Header from HTTP Request
	@GetMapping("/header-info")
	public Map<String, String> getAllHeader(HttpServletRequest request){
		
		Map<String, String> headerMap = new HashMap<>();
		
		//collecting all headernames
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			
			String headerName = headerNames.nextElement();
			headerMap.put(headerName, request.getHeader(headerName)); // putting value from HttpservletRequest and collecting header key value data
		}
		
		return headerMap;
	}
}
