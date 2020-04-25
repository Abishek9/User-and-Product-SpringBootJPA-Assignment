package com.capgemini.springboot.cruddemo.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.capgemini.springboot.cruddemo.dao.ProductRepository;
import com.capgemini.springboot.cruddemo.entity.Product;




@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	@Autowired
	public ProductServiceImpl(ProductRepository theproductRepository) {
		productRepository = theproductRepository;
	}

	@Override
	public List<Product> findAllProducts() {

		return productRepository.findAll();
	}

	@Override
	public Product findProductById(int productId) {

		Optional<Product> result = productRepository.findById(productId);
		Product book = null;
		if (result.isPresent()) {
			book = result.get();
		} else {
			throw new RuntimeException("Didn't find the Student Id :" + productId);
		}

		return book;
	}

	@Override
	public void save(Product product) {
		productRepository.save(product);
	}

	@Override
	public void deleteByProductId(int productId) {
		productRepository.deleteById(productId);
	}

}
