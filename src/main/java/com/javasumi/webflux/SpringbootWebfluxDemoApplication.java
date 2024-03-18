package com.javasumi.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
// Spring Reactive Web Programming

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
		title = "Spring webflux crud example",
		version = "2.0",
		description = "sample documents"
))
 
public class SpringbootWebfluxDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebfluxDemoApplication.class, args);
	}

}
