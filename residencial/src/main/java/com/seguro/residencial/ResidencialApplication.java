package com.seguro.residencial;

import com.seguro.residencial.infra.config.data.CustomJpaRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
@SpringBootApplication
public class ResidencialApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResidencialApplication.class, args);
    }
}
