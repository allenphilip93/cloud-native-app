package com.cloudnative.services.customers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
@EnableEurekaClient
@OpenAPIDefinition(info =
	@Info(title = "Customers API", version = "1.0", description = "Documentation Customers API v1.0")
)
public class CustomersApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomersApplication.class, args);
	}

    @Bean
	public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
		return new OpenAPI()
				.components(new Components())
				.info(new io.swagger.v3.oas.models.info.Info().title("Customers API").version(appVersion)
						.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}

}