package com.seguro.residencial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@EntityScan({"com.seguro.core.model"})
//@EnableEurekaClient
//@EnableJpaRepositories({"com.seguro.core.repository"})
@SpringBootApplication
//@ComponentScan("com.seguro.residencial")
//@EnableConfigurationProperties(value = JwtConfiguration.class)
public class ResidencialApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResidencialApplication.class, args);
    }
}
