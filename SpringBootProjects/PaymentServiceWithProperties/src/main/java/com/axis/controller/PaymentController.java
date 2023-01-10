package com.axis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment-provider")
public class PaymentController {
	@GetMapping("/payNow/{price}")
	public String payNow(int price) {
		return "Payment with" +price+"is successful";
	}
	@GetMapping("/greet")
	public String greet() {
		return "HEllo Spring";
	}

}
