package com.cloudnative.services.products;

import java.util.concurrent.TimeUnit;

import com.cloudnative.services.products.kafka.EventListener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(info =
	@Info(title = "Products API", version = "1.0", description = "Documentation Products API v1.0")
)
public class ProductsApiApplication {

    public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(ProductsApiApplication.class, args);

		EventListener listener = context.getBean(EventListener.class);
		listener.getEventLatch().await(10, TimeUnit.SECONDS);
	}

    @Bean
	public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
		return new OpenAPI()
				.components(new Components())
				.info(new io.swagger.v3.oas.models.info.Info().title("Products API").version(appVersion)
						.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}

}
