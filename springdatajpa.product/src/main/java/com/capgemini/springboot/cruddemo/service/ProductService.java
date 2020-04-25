package com.capgemini.springboot.cruddemo.service;

import java.util.List;

import com.capgemini.springboot.cruddemo.entity.Product;

public interface ProductService {

	public List<Product> findAllProducts();

	public Product findProductById(int productId);

	public void save(Product product);

	public void deleteByProductId(int productId);
}
