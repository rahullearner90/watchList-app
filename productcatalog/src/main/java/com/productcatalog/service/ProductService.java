package com.productcatalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcatalog.model.Product;
import com.productcatalog.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}

	public List<Product> getProductById(Long id){
		return productRepository.findByCategoryId(id);

	}
}
