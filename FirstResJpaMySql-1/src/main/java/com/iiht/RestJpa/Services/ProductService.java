package com.iiht.RestJpa.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.RestJpa.Entities.Product;
import com.iiht.RestJpa.Repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepo;
	
	public Product save(Product product) {
		return productRepo.save(product);
	}
	
	public List<Product> getAllProducts(){
		return productRepo.findAll();
	}
	
	public Product getProductById(long id) {
		Optional<Product> product = productRepo.findById(id);
		return product.isPresent()?product.get():null;
	}
	
	public boolean deleteProductById(long id) {
//		productRepo.deleteById(id);
		if(productRepo.findById(id).isPresent()) {
			productRepo.deleteById(id);
			return true;
		}
		return false;
		
	}
	
	public Product updatePrice(long id,double pr) {
		Optional<Product> up = productRepo.findById(id);
		if(up.isPresent()) {
			Product p = up.get();
			p.setPrice(pr);
			return productRepo.save(p);
		}
		return null;

		
	}
}
