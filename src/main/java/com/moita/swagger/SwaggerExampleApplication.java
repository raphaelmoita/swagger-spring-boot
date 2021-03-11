package com.moita.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class SwaggerExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerExampleApplication.class, args);
	}

	@Bean
	public Docket swagger()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.moita.swagger"))
				.build()
				.apiInfo(new ApiInfo(
						"Title-1",
						"description abc",
						"v.1.0",
						"www.moita.com/terms-of-use",
						new Contact("Raphael Moita", "www.moita.com", "raphael.moita@gmail.com"),
						"license-abc",
						"www.license-abc.org",
						Collections.emptyList())
				);
	}

}
