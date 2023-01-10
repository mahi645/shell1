package com.axis.controller;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	private static Log logger = LogFactory.getLog(TestController.class);
	
	@GetMapping("/get")
	public String greet() {
		logger.info("this is info");
		logger.error("this is error");
		logger.warn("this is warning");
		return "hello";
	}

}
