package com.seguro.residencial.domain.interfaces.repository.cotacao;

import com.seguro.residencial.domain.interfaces.repository.CustomJpaRepository;
import com.seguro.residencial.domain.models.root.cotacoes.StatusCotacao;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @criado 23/11/2020 - 15:01
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Repository
public interface IStatusCotacao extends CustomJpaRepository<StatusCotacao, Long> {
    Optional<StatusCotacao> findByDescricao(String descricao);
}
