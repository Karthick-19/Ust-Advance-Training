package com.iiht.helloclient.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/client")
public class clientResource {

	@Autowired
	RestTemplate template;
	
	@GetMapping("/Store")
	public String showItems() {
		String url = "http://localhost:9000/store/Items";
		ResponseEntity<String> response = template.getForEntity(url,String.class);
		return response.toString();
	}
	
	@GetMapping("/service1")
	public String connect() {
		String url = "http://localhost:8089/helloserviceR1/hola";
		ResponseEntity<String> response = template.getForEntity(url, String.class);
		return response.toString();
	}
	
	@GetMapping("/service2")
	public String connect2() {
		String url = "http://localhost:8084/helloServiceR2";
		ResponseEntity<String> response = template.getForEntity(url,String.class);
		return response.toString();
	}
	
	@GetMapping("/service2/{x}")
	public String service2Square(@PathVariable int x) {
		String url = "http://localhost:8089/helloServiceR2/squares/"+x;
		ResponseEntity<String> response = template.getForEntity(url,String.class);
		return response.toString();
		
	}
	
	
}
