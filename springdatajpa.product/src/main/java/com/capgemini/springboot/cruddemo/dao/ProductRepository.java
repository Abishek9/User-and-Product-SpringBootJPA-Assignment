package com.capgemini.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.springboot.cruddemo.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	// no need to write code
}
