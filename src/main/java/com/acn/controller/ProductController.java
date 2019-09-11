package com.acn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.acn.model.Product;
import com.acn.repository.ProductRepository;

@RestController
public class ProductController {
	 @Autowired
	 private ProductRepository productRepository;
	
	@PostMapping("/products")
	public void createProducts(@RequestBody Product prod) {
		productRepository.save(prod);
	}

	@GetMapping("/products")
	public Iterable<Product> readProducts() {
		return productRepository.findAll();
	}
	
}
