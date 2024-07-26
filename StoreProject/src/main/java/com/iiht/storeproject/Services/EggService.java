package com.iiht.storeproject.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.iiht.storeproject.Entities.Egg;
import com.iiht.storeproject.Repositories.EggRepository;

@Service
public class EggService {
	
	@Autowired
	EggRepository eggrepo;
	
	public Egg addEgg(Egg egg) {
		eggrepo.save(egg);
		return egg;
	}
	
	public List<Egg> fetchAllEggs(){
		List<Egg> eggs = eggrepo.findAll();
		return eggs;
	}
	
	public Egg fetchEgg(long id) {
		Optional<Egg> egg = eggrepo.findById(id);
		return egg.isPresent()?egg.get():null;
		
	}
	
	public String deleteEgg (long id) {
		Optional<Egg> egg = eggrepo.findById(id);
		if(egg.isPresent()) {
			eggrepo.deleteById(id);
			return "Item with id: "+id+" deleted";
		}
		return "Item does not exist";
	}

}
