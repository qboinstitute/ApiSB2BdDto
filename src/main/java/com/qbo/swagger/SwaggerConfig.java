package com.qbo.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.*;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.securityContexts(Arrays.asList(securityContext()))
				.securitySchemes(Arrays.asList(apiKey()))
				.select()
				.apis(RequestHandlerSelectors.any())
				.build();
	}
	
	private ApiKey apiKey() {
		return new ApiKey("JWT", "Authorization", "header");
	}
	private List<SecurityReference> listadoSeguridad(){
		AuthorizationScope objauthorizationScope = 
				new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] arrayauthorizationScopes =
				new AuthorizationScope[1];
		arrayauthorizationScopes[0] = objauthorizationScope;
		return Arrays.asList(new SecurityReference("JWT",
				arrayauthorizationScopes));
	}
	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(listadoSeguridad())
				.build();
	}
	
	
	private ApiInfo apiInfo() {
		return new ApiInfo("API Rest QBO Institute", 
				"API Rest para el curso de Spring Boot", 
				"1.0", 
				"Términos y condiciones del Autor", 
				new Contact("Luis Salvatierra", "www.qboinstitute.com", "info@qboinstitute.com"),
				"Licencia Libre", 
				"API Licencia QBO", 
				Collections.emptyList());
	}

}
