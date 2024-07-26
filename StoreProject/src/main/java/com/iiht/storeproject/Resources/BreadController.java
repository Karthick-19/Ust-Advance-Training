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

import com.iiht.storeproject.Entities.Bread;
import com.iiht.storeproject.Services.BreadService;

@RestController
@RequestMapping("/store/bread")
public class BreadController {
	
	@Autowired
	BreadService bservice;
	
	@GetMapping("/{id}")
	public ResponseEntity<Bread> getbread(@PathVariable long id){
		return ResponseEntity.ok(bservice.fetchBread(id));
	}
	
	@GetMapping()
	public ResponseEntity<List<Bread>> getallbreads(){
		return ResponseEntity.ok(bservice.fetchAllBreads());
	}
	
	@PostMapping()
	public ResponseEntity<Bread> createEgg(@RequestBody Bread bread){
		return ResponseEntity.status(HttpStatus.CREATED).body(bservice.addBread(bread));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBread(@PathVariable long id){
		return ResponseEntity.status(HttpStatus.OK).body(bservice.deleteBread(id));
	}

}
