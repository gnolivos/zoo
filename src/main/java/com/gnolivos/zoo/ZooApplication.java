package com.gnolivos.zoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication(scanBasePackages = "com.gnolivos.zoo")
public class ZooApplication {

	@Autowired
	private BuildProperties buildProperties;

	public static void main(String[] args) {
		SpringApplication.run(ZooApplication.class, args);
	}

	@Bean
	OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Microservices application API")
						.version(buildProperties.getVersion())
						.description("Zoo Api")
						.contact(new Contact()
								.name("Gabriel Nolivos")
								.email("gabrieloal8@hotmail.com")
								.url("https://github.com/gnolivos"))
						.termsOfService("http://swagger.io/terms/")
						.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}
}
