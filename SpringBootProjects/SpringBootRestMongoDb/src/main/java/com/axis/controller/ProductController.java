package com.axis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.model.Product;
import com.axis.service.ProductService;

@RestController
@RequestMapping("/api/product/version2")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@PostMapping
	
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		Product product2=productService.addProduct(product);
		return new ResponseEntity<Product>(product2,HttpStatus.OK);
	}
	@GetMapping
	
	public ResponseEntity<List<Product>> getAllProduct(){
		List<Product> products=productService.getAllProduct();
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id){
		Product products=productService.getProductById(id);
		return new ResponseEntity<Product>(products,HttpStatus.OK);
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable int id,@RequestBody Product product){
		
		return new ResponseEntity<Product>(productService.updateProductById(id, product),HttpStatus.OK);
	}
	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> deleteProduct(int id){
		return new ResponseEntity<String>(productService.deleteProductById(id),HttpStatus.OK);
	}
}
