package com.axis.spring.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	ArrayList<String> fruits=new ArrayList<String>();
	public ProductController() {
		fruits.add("apple");
		fruits.add("mango");
		fruits.add("banana");
	}
	@GetMapping("/fruits")
	public List<String> getAllFruits(){
		return fruits;
	}

}
