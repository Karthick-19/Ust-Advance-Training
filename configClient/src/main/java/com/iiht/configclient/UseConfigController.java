package com.iiht.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/configClient")
public class UseConfigController {
	
	@Value("${server.port.key}")
	String serverPort;
	
	@Value("${spring.application.name}")
	String appName;
	
	@Value("${message}")
	String appMessage;
	
	@Value("${server.status}")
	String status;
	
	@Value("${connected}")
	String connected;
	
	@GetMapping
	public String showProps() {
		return "port = "+serverPort+" AppName "+appName+" Message:"+appMessage+" Server status: "+status+" Connected: "+connected;
	}
}
