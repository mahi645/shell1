package com.axis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.entity.ProductEntity;
import com.axis.exception.ResourceNotFoundException;
import com.axis.repository.ProductRepository;

@RestController
@RequestMapping("/api/product")

public class ProductController {
	@Autowired
	public ProductRepository productRepository;
	
	//get all products
	@GetMapping("/products")
	public List<ProductEntity> getAllProduct(ProductEntity product){
		return this.productRepository.findAll();
	}
	
	//get product by ID
	@GetMapping("/product/{id}")
	public ProductEntity getProductById(@PathVariable(value="id")  long productId) {
		return this.productRepository.findById(productId)
				.orElseThrow(()->new ResourceNotFoundException("Product not found with the id: "+productId));
	}
	//Adding product
	
	@PostMapping("/product")
	public ProductEntity addProduct(@RequestBody ProductEntity product) {
		return this.productRepository.save(product);
		
		
	}
	//Update Product
	@PutMapping("/product/{id}")
	public ProductEntity updateProduct(@RequestBody ProductEntity product,@PathVariable(value="id") long productId) {
		ProductEntity existing=this.productRepository.findById(productId)
				.orElseThrow(()->new ResourceNotFoundException("product not found with the id: "+productId));
		
		existing.setName(product.getName());
		existing.setNoOfitems(product.getNoOfitems());
		existing.setCost(product.getCost());
		return this.productRepository.save(existing);
		
	}
	//delete prodcut by name
	@DeleteMapping("/product/{id}")
	public ResponseEntity<ProductEntity> deleteProductByName(@PathVariable(value="id")long productId) {
		ProductEntity existing=this.productRepository.findById(productId)
				.orElseThrow(()->new ResourceNotFoundException("product not found with the id: "+productId));
		this.productRepository.delete(existing);
		return ResponseEntity.ok().build();
	}

}
