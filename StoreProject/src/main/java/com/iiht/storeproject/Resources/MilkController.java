package com.iiht.storeproject.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.storeproject.Entities.Milk;
import com.iiht.storeproject.Services.MilkService;

@RestController
@RequestMapping("/store/milk")
public class MilkController {
	
	@Autowired
	MilkService mservice;
	
	@GetMapping("/{id}")
	public ResponseEntity<Milk> getmilk(@PathVariable long id){
		return ResponseEntity.ok(mservice.fetchMilk(id));
	}
	
	@GetMapping()
	public ResponseEntity<List<Milk>> getallmilks(){
		return ResponseEntity.ok(mservice.fetchAllMilks());
	}
	
	@PostMapping()
	public ResponseEntity<Milk> createMilk(@RequestBody Milk milk){
		return ResponseEntity.status(HttpStatus.CREATED).body(mservice.addMilk(milk));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteMilk(@PathVariable long id){
		return ResponseEntity.status(HttpStatus.OK).body(mservice.deleteMilk(id));
	}

}
