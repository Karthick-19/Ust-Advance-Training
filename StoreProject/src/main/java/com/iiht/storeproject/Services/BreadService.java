package com.iiht.storeproject.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.storeproject.Entities.Bread;
import com.iiht.storeproject.Repositories.BreadRepository;

@Service
public class BreadService {
	
	@Autowired
	BreadRepository breadrepo;
	
	public Bread addBread(Bread bread) {
		breadrepo.save(bread);
		return bread;
	}
	
	public List<Bread> fetchAllBreads(){
		List<Bread> breads = breadrepo.findAll();
		return breads;
	}
	
	public Bread fetchBread(long id) {
		Optional<Bread> bread = breadrepo.findById(id);
		return bread.isPresent()?bread.get():null;
		
	}
	
	public String deleteBread(long id) {
		Optional<Bread> bread = breadrepo.findById(id);
		if(bread.isPresent()) {
			breadrepo.deleteById(id);
			return "Item with id: "+id+" deleted";
		}
		return "Item does not exist";
	}

}
