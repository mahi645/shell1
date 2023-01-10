package com.axis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController

public class ShoppingController {

	@Autowired
	private RestTemplate template;
	
	@GetMapping("/amazon-payment/{price}")
	public String invokePaymentService(@PathVariable int price) {
		String url="http://localhost:8090/payment-provider/payment/"+price;
		//String url2="http://localhost:8090/payment-provider/greet";
		return template.getForObject(url, String.class);
	}
	@GetMapping("/greets")
	public String greet1() {
		return "Shopping Service";
	}
}
