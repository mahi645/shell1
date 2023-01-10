package com.axis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.axis.model.Product;

public interface ProductService {
	@Autowired
	public  Product addProduct(Product product);
		// TODO Auto-generated method stu
	public List<Product> getAllProduct();
	public Product getProductById(int id);
	public Product updateProductById(int id,Product produ);
	public String deleteProductById(int id);
	
	
}
