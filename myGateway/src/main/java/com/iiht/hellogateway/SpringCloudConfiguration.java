package com.iiht.hellogateway;

//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfiguration {

	//@Bean
//	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
//		return builder.routes().route(
//				"helloserviceR1",
//				r -> r.path("/helloserviceR1/**").
//				filters(f -> f.addResponseHeader("Password","Ok bro")).
//				uri("http://localhost:8083")).
//				build();
//	}
}
