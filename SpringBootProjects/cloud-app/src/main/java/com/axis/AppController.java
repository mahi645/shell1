package com.axis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppController {
	@GetMapping("/helloWorld")
	String gethello() {
		return "hello world";
	}

}
