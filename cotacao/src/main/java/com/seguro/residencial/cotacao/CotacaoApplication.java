package com.seguro.residencial.cotacao;

import com.seguro.residencial.core.property.JwtConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan({"com.seguro.residencial.core.model"})
@EnableEurekaClient
@EnableJpaRepositories({"com.seguro.residencial.core.repository"})
@SpringBootApplication
@ComponentScan("com.seguro.residencial")
@EnableConfigurationProperties(value = JwtConfiguration.class)
public class CotacaoApplication {
    public static void main(String[] args) {
        SpringApplication.run(CotacaoApplication.class, args);
    }
}
