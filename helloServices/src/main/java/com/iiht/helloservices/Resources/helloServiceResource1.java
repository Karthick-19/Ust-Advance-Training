package com.iiht.helloservices.Resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloserviceR1")
public class helloServiceResource1 {
	
	@GetMapping("/hola")
	public ResponseEntity<String> hello(){
		return new ResponseEntity<String>("Hola Amigo",HttpStatus.OK);
	}

}
