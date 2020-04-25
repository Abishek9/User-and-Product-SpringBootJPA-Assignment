package com.capgemini.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springboot.cruddemo.entity.Product;
import com.capgemini.springboot.cruddemo.service.ProductService;
import com.capgemini.springboot.cruddemo.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductRestController {

	private ProductService ProductService;

	@Autowired
	public ProductRestController(ProductService theProductService) {
		ProductService = theProductService;
	}

	// expose "/Products" to return list of Products
	@GetMapping("/Products")
	public List<Product> findAllProducts() {

		return ProductService.findAllProducts();
	}

	// add mapping for GET /Products/{ProductId}
	@GetMapping("/Products/{ProductId}")
	public Product getProduct(@PathVariable int ProductId) {

		Product Product = ProductService.findProductById(ProductId);

		if (Product == null) {
			throw new RuntimeException("Product Id not found:" + ProductId);
		}

		return Product;
	}

	// add mapping for POST /Products - add new Product
	@PostMapping("/Products")
	public Product addProduct(@RequestBody Product Product) {

		// also just in case they pass an id in JSON .... set id to 0
		// this is to force a save of new item .... instead of update
		Product.setProductId(0);

		ProductService.save(Product);

		return Product;
	}

	// add mapping for PUT /Products - update Product
	@PutMapping("/Products")
	public Product updateProduct(@RequestBody Product Product) {

		ProductService.save(Product);
		return Product;
	}

	// add mapping for DELETE /Products/{ProductId} - delete Product
	@DeleteMapping("/Products/{ProductId}")
	public String deleteProduct(@PathVariable int ProductId) {

		Product theProduct = ProductService.findProductById(ProductId);

		// throw exception if null
		if (theProduct == null) {
			throw new RuntimeException("Product Id not found:" + ProductId);
		}
		ProductService.deleteByProductId(ProductId);

		return "Deleted Product id :" + ProductId;

	}
}
