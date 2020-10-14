package com.seguro.residencial.infra.config.swagger;

import com.seguro.residencial.infra.swagger.BaseSwaggerConfig;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @criado 22/09/2020 - 19:39
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {
    public SwaggerConfig() {
        super("com.seguro.residencial.cotacao.endpoint.controller");
    }
}
