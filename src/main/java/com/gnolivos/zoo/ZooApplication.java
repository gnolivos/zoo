package com.gnolivos.zoo;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.gnolivos.zoo")
public class ZooApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZooApplication.class, args);
	}

	@Bean
	OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Microservices application API")
						.version("1.0.0")
						.description("Zoo Api")
						.contact(new Contact()
								.name("Gabriel Nolivos")
								.email("gabrieloal8@hotmail.com")
								.url("https://github.com/gnolivos"))
						.termsOfService("http://swagger.io/terms/")
						.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}
}
