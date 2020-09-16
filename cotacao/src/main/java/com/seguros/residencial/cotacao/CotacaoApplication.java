package com.seguros.residencial.cotacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan({"com.seguro.residencial.core.model"})
@EnableJpaRepositories({"com.seguro.residencial.core.repository"})
public class CotacaoApplication {
    public static void main(String[] args) {
        SpringApplication.run(CotacaoApplication.class, args);
    }
}
