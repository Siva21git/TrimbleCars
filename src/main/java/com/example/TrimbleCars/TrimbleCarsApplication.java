package com.example.TrimbleCars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class TrimbleCarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrimbleCarsApplication.class, args);
	}

}
