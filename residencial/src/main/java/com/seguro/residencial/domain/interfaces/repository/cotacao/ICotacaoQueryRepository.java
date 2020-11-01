package com.seguro.residencial.domain.interfaces.repository.cotacao;

import com.seguro.residencial.application.interfaces.ICustomJpaRepository;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

/**
 * @criado 12/10/2020 - 15:52
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Repository
public interface ICotacaoQueryRepository extends ICustomJpaRepository<CotacaoRoot, Long> {


}
