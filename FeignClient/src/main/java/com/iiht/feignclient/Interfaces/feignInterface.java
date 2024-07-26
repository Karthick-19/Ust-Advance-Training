package com.iiht.feignclient.Interfaces;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.iiht.feignclient.Models.Product;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(value="feignclient",url="http://localhost:7071/product-service")
public interface feignInterface {
	
	@GetMapping("/products")
	@CircuitBreaker(name="client-cb",fallbackMethod = "generateResponse")
	List<Product> getProducts();
	
	@GetMapping(value="/products-by-id/{id}",produces="application/json")
	Product getProductsById(@PathVariable long id);
	
//	@GetMapping(value="products-bycategory/{category}",produces="application/json")
//	List<Product> getProductsByCategory{
//		@PathVariable("category")
//	}
	
//	String getresponse();
}
