package com.iiht.lbgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class LbGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(LbGatewayApplication.class, args);
	}

}
