package com.seguro.residencial.core.repository;

import com.seguro.residencial.core.model.ApplicationUser;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @criado 16/09/2020 - 15:55
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public interface ApplicationUserRepository extends PagingAndSortingRepository<ApplicationUser, Long> {

    ApplicationUser findByUsername(String username);
}
