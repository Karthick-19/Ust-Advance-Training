package com.iiht.lbservice.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lbservice")
public class TestController {
	
	@Autowired
	Environment env;
	
	@GetMapping
	public String message() {
		return "from port "+env.getProperty("local.server.port");
	}
}
