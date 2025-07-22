package com.productcatalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productcatalog.model.Product;
import com.productcatalog.service.ProductService;

@RestController
@RequestMapping("api/products")
//@CrossOrigin(origins = "http://localhost:5173/")
@CrossOrigin
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}

	@GetMapping("category/{categoryId}")
	public List<Product> getAllProductsById(@PathVariable Long categoryId){
		return productService.getProductById(categoryId);
	}


}
