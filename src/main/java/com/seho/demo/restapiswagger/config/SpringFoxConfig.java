package com.seho.demo.restapiswagger.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SpringFoxConfig {
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.seho"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo())
				.tags(new Tag("Topic Resource", "Set of endpoints for Creating, Retrieving, Updating and Deleting of Topics.")/*, new Tag("tag2", "Tag 2 description.")*/);
	}

	private ApiInfo getApiInfo() {
		return new ApiInfo("Api swagger 2 documentation", 
				"Demo project for Spring Boot rest api with swagger",
				"1.0",
				"urn:tos",
				new Contact("Seho Kim","https://www.linkedin.com/in/seho-k-8437903b","sehokim.ca@gmail.com"), 
				"Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", 
				Collections.emptyList());
	}
}
