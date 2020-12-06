package com.seguro.residencial.domain.interfaces.repository.cotacao;

import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * @criado 12/10/2020 - 15:52
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Repository
public interface ICotacaoRepository extends JpaRepository<CotacaoRoot, Long> {
    @Query("select c.codigoCotacao from CotacaoRoot c where c.codigoCotacao = :codigoCotacao")
    Optional<String> consultarCodigoCotacao(String codigoCotacao);

    Optional<CotacaoRoot> findByCodigoCotacao(String codigoCotacao);

}
