package com.seguro.residencial.infra.swagger;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @criado 22/09/2020 - 19:21
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public class BaseSwaggerConfig {

    private final String basePackage;

    public BaseSwaggerConfig(String basePackage) {
        this.basePackage = basePackage;
    }

//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .ignoredParameterTypes()
//                .select()
//                .apis(RequestHandlerSelectors.basePackage(basePackage))
//                .build()
//                .apiInfo(metaData());
//    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Spring Boot Microservices - Seguros")
                .description("Aplicação para modulo de seguro Residencial - Teste de CI/AWS")
                .version("1.0")
                .contact(new Contact("Bruno Leite", "https://github.com/brunoleitt", "brunoleitt@gmail.com"))
                .license("Bruno Leite")
                .licenseUrl("http://brunoleite.seguros")
                .build();
    }
}
