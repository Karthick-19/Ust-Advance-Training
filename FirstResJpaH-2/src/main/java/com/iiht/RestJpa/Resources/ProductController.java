package com.iiht.RestJpa.Resources;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.RestJpa.Entities.Product;
import com.iiht.RestJpa.Services.ProductService;

@RestController
@RequestMapping("api/products/")
public class ProductController {
	
	@Autowired
	ProductService productService;

	@PostMapping("createProduct")
	public ResponseEntity<Product> createProduct(@RequestBody Product productReq){
		Product createdProduct = productService.save(productReq);
		return new ResponseEntity<Product>(createdProduct,HttpStatus.CREATED);
	}
	
	@GetMapping("allProducts")
	public ResponseEntity<?> getProducts(){
		return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
	}
	
	@GetMapping("singleProduct/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Long id){
		Product singleP = productService.getProductById(id);
		return new ResponseEntity<Product>(singleP,HttpStatus.OK);
	}
	
	@DeleteMapping("deleteProduct/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id){
		if(productService.deleteProductById(id)) {
		return new ResponseEntity<String>("Product deleted\nProduct id: "+id,HttpStatus.OK);
	}
		return new ResponseEntity<String>("Product does not exist",HttpStatus.CONFLICT);
	}
	
	@PutMapping("updateProduct/{id}")
	public ResponseEntity<Product> updatePrice(@RequestBody HashMap<String,Double> map,@PathVariable long id){
		Product ubody = productService.updatePrice(id, map.get("price"));
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(ubody);
	}

}
