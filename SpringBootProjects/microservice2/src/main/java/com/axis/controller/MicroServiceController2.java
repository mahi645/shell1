package com.axis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MicroServiceController2 {
	@GetMapping("/greet")
	public String greetMicroService1() {
		return "Hello Micro Service1";
	}
}
