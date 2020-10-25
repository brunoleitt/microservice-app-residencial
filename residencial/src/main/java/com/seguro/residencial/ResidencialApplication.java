package com.seguro.residencial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//@EntityScan({"com.seguro.residencial.domain.models.root"})
//@EnableEurekaClient
@EnableJpaRepositories({"com.seguro.residencial.domain.interfaces.repository"})
@SpringBootApplication
//@ComponentScan("com.seguro.residencial.domain")
//@EnableConfigurationProperties(value = JwtConfiguration.class)
public class ResidencialApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResidencialApplication.class, args);
    }
}
