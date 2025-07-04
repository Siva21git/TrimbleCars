package com.example.TrimbleCars.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {
	@Bean
	public OpenAPI trimbleCarsOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Trimble Cars API").version("1.0").description("API for managing car leasing"));
	}

}
