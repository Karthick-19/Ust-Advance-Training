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

import com.iiht.storeproject.Entities.Egg;
import com.iiht.storeproject.Services.EggService;

@RestController
@RequestMapping("/store/egg")
public class EggController {
	
	@Autowired
	EggService eservice;
	
	@GetMapping("/{id}")
	public ResponseEntity<Egg> getegg(@PathVariable long id){
		return ResponseEntity.ok(eservice.fetchEgg(id));
	}
	
	@GetMapping()
	public ResponseEntity<List<Egg>> getalleggs(){
		return ResponseEntity.ok(eservice.fetchAllEggs());
	}
	
	@PostMapping()
	public ResponseEntity<Egg> createEgg(@RequestBody Egg egg){
		return ResponseEntity.status(HttpStatus.CREATED).body(eservice.addEgg(egg));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEgg(@PathVariable long id){
		return ResponseEntity.status(HttpStatus.OK).body(eservice.deleteEgg(id));
	}

}
