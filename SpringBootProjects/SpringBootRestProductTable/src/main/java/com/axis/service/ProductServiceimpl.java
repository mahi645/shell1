package com.axis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.Exception.InvalidNameException;
import com.axis.Exception.ResourceNotFoundException;
import com.axis.model.Product;
import com.axis.repository.ProductRepository;
import com.axis.util.AppConstant;
@Service
public class ProductServiceimpl implements ProductService {
	
	@Autowired
	public ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		if(product.getName()==null) {
			throw new InvalidNameException(AppConstant.InvalidNameMessage);
		}
			
		
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(AppConstant.IdNotFound));
	}

	@Override
	public Product updateProductById(int id, Product produ) {
		// TODO Auto-generated method stub
		Product product=productRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException(AppConstant.IdNotFound));
		product.setName(produ.getName());
		product.setCategory(produ.getCategory());
		return productRepository.save(product);
	}

	@Override
	public String deleteProductById(int id) {
		Product product=productRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException(AppConstant.IdNotFound));
		// TODO Auto-generated method stub
		productRepository.delete(product);
		return AppConstant.DeleteMessage;
	}


}
