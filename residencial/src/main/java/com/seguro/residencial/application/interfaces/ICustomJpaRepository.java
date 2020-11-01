package com.seguro.residencial.application.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @criado 29/10/2020 - 16:30
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@NoRepositoryBean
public interface ICustomJpaRepository<T, ID> extends JpaRepository<T, ID> {

}
