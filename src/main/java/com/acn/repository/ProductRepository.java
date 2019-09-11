package com.acn.repository;

import org.springframework.data.repository.CrudRepository;

import com.acn.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
