package com.iiht.feignclient.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.feignclient.Interfaces.feignInterface;
import com.iiht.feignclient.Models.Product;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/client")
public class FeignController {
	 @Autowired
	 private feignInterface feignclient;
	 
	 @Autowired
	 Environment environment;

	 @CircuitBreaker(name="client-cb",fallbackMethod = "generateResponse")
	 @GetMapping("/allProducts")
	 public List<Product> getAll() {
		  return feignclient.getProducts();

	 }

	 @GetMapping("/products-by-id/{id}")
		public Product getProductById(@PathVariable ("id") int id) {
		   System.out.println(id);
		   return feignclient.getProductsById(id);
	 }

//	 @GetMapping("/products-by-category/{category}")
//		public List<Product> getProductsByCategory(@PathVariable("category") String category){
//		           return feignclient.getProductsByCategory(category);
//	 }
	 
	 public String generateResponse(Throwable throwable) {
		 return "the server is unavailable temporarily";
	 }
	 
	 @GetMapping("/port")
	 public String getPort() {
		 return environment.getProperty("server.port");
	 }
	 
}
