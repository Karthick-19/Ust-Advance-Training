package com.iiht.storeproject.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.iiht.storeproject.Entities.Milk;
import com.iiht.storeproject.Repositories.MilkRepository;

@Service
public class MilkService {
	
	@Autowired
	MilkRepository milkrepo;
	
	public Milk addMilk(Milk milk) {
		milkrepo.save(milk);
		return milk;
	}
	
	public List<Milk> fetchAllMilks(){
		List<Milk> milks = milkrepo.findAll();
		return milks;
	}
	
	public Milk fetchMilk(long id) {
		Optional<Milk> milk = milkrepo.findById(id);
		return milk.isPresent()?milk.get():null;
		
	}
	
	public String deleteMilk (long id) {
		Optional<Milk> milk = milkrepo.findById(id);
		if(milk.isPresent()) {
			milkrepo.deleteById(id);
			return "Item with id: "+id+" deleted";
		}
		return "Item does not exist";
	}

}
