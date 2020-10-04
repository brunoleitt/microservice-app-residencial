package com.seguro.cotacao;

import com.seguro.core.property.JwtConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan({"com.seguro.core.model"})
@EnableEurekaClient
@EnableJpaRepositories({"com.seguro.core.repository"})
@SpringBootApplication
@ComponentScan("com.seguro")
//@EnableConfigurationProperties(value = JwtConfiguration.class)
public class ResidencialApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResidencialApplication.class, args);
    }
}
