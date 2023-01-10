package com.axis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment-provider")
public class PaymentCollector {
	
	@GetMapping("/payment/{price}")
	public String paymentNow(@PathVariable int price) {
		return "Payment with "+price+"is successfully";
	}
	@GetMapping("/greet")
	public String greetNow() {
		return "hello Spring ";
				
				
	}
}
