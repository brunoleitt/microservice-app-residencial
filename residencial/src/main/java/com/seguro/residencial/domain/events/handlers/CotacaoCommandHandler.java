package com.seguro.residencial.domain.events.handlers;

import com.seguro.residencial.domain.events.CriadaCotacaoEvent;
import com.seguro.residencial.domain.interfaces.repository.cotacao.ICotacaoRepository;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoStatus;
import com.seguro.residencial.domain.models.root.cotacoes.TipoCalculo;
import com.seguro.residencial.domain.models.root.cotacoes.TipoVigencia;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

/**
 * @criado 12/10/2020 - 21:43
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Component
@Slf4j
public class CotacaoCommandHandler {


    private final ICotacaoRepository cotacaoRepository;

    public CotacaoCommandHandler(ICotacaoRepository cotacaoRepository) {
        this.cotacaoRepository = cotacaoRepository;
    }

    @EventHandler
    public void on(CriadaCotacaoEvent event){
        log.debug("Handling a Bank Account creation command {}", event.getId());

        persistCotacao(buildQueryCotacao(event));
    }

    private CotacaoRoot buildQueryCotacao(CriadaCotacaoEvent event){

        TipoCalculo tipoCalculo = new TipoCalculo();
        tipoCalculo.setId(event.getIdTipoCalculo());
        TipoVigencia tipoVigencia = new TipoVigencia();
        tipoVigencia.setId(event.getIdTipoVigencia());

        var cotacao = new CotacaoRoot(event.getCodigoCotacao(), CotacaoStatus.CRIADA.toString(),
                event.getDataCotacao(), event.getDataVigenciaInicial(),
                event.getDataVigenciaFinal(),tipoCalculo,
                tipoVigencia,null,null,null);

        return cotacao;
    }


    private void persistCotacao(CotacaoRoot cotacao){
        cotacaoRepository.save(cotacao);
    }

}
