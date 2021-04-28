package com.cloudnative.services.reviews;

import java.util.concurrent.TimeUnit;

import com.cloudnative.services.reviews.kafka.EventListener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
@EnableEurekaClient
@OpenAPIDefinition(info =
	@Info(title = "Reviews API", version = "1.0", description = "Documentation Reviews API v1.0")
)
public class ReviewsApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(ReviewsApplication.class, args);

		EventListener listener = context.getBean(EventListener.class);
		listener.getEventLatch().await(10, TimeUnit.SECONDS);
	}

    @Bean
	public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
		return new OpenAPI()
				.components(new Components())
				.info(new io.swagger.v3.oas.models.info.Info().title("Reviews API").version(appVersion)
						.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}

}
