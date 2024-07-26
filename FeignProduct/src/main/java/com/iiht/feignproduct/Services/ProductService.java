package com.iiht.feignproduct.Services;

import java.util.List;

import com.iiht.feignproduct.resource.Product;

public interface ProductService {

	List<Product> findAll();
	Product findById(int id);
	List<Product> findByCategory(String category);
}
