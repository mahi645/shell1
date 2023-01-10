package com.axis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.feignClient.FeignControlller1;
import com.axis.model.Product;

@RestController
@RequestMapping("/api/v2")
public class TestControler {
	@Autowired 
	FeignControlller1 feignController;
	
	@GetMapping("/greet")
	public String greet() {
		return "Hello microservice4";
	}
	@GetMapping("/api/v1/products")
	public List<Product> getAllProducts(){
		return feignController.getAllProducts();
	}

}
