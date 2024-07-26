package com.iiht.helloservices.helloservices2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloServiceR2")
public class helloServiceResource2 {
	
	@GetMapping
	public String hello2() {
		return "Vanakkam mapla";
	}
	
	@GetMapping("/squares/{x}")
	public int square(@PathVariable int x) {
		return x*x;
	}

}
