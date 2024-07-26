package com.iiht.lbeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LbEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LbEurekaApplication.class, args);
	}

}
