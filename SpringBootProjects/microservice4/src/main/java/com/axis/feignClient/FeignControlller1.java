package com.axis.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.axis.model.Product;

@FeignClient(name="MICRO-SERVICE-1")
public interface FeignControlller1 {
	@GetMapping("/api/v1/products") 
	List<Product> getAllProducts();

}
