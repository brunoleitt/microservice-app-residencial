package com.seguro.residencial.domain.interfaces.repository.coberturas;

import com.seguro.residencial.application.interfaces.ICustomJpaRepository;
import com.seguro.residencial.domain.models.root.coberturas.CoberturasPacoteRoot;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @criado 14/11/2020 - 17:16
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Repository
public interface IPacoteCoberturasRespository extends ICustomJpaRepository<CoberturasPacoteRoot, Long> {

    @Query("select p from CoberturasPacoteRoot p inner join p.coberturas c " +
            "where p.tipoRisco.id = :idTipoRisco and p.id = :idPacoteCobertura")
    Optional<CoberturasPacoteRoot> consultarPacoteCoberturas(Long idPacoteCobertura, Long idTipoRisco);

    @Query("select p from CoberturasPacoteRoot p inner join p.coberturaServicos s " +
            "where p.tipoRisco.id = :idTipoRisco and p.id = :idPacoteCobertura")
    Optional<CoberturasPacoteRoot> consultarPacoteServicosCobertura(Long idPacoteCobertura, Long idTipoRisco);

}
