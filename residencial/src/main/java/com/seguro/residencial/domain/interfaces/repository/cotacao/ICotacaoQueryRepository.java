package com.seguro.residencial.domain.interfaces.repository.cotacao;

import com.seguro.residencial.application.interfaces.ICustomJpaRepository;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * @criado 12/10/2020 - 15:52
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Repository
public interface ICotacaoQueryRepository extends ICustomJpaRepository<CotacaoRoot, Long> {

    @Query("select c from CotacaoRoot c " +
            " where c.codigoCotacao = :codigoCotocao")
    Optional<CotacaoRoot> consultarCotacao(String codigoCotocao);

    @Query("select c from CotacaoRoot c left join fetch c.tipoCalculo " +
            "left join fetch c.tipoVigencia")
    List<CotacaoRoot> buscarTodos();

}
