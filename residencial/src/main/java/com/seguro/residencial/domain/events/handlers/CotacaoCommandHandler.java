package com.seguro.residencial.domain.events.handlers;

import com.seguro.residencial.domain.events.CriacaoCotacaoEvent;
import com.seguro.residencial.domain.interfaces.repository.cotacao.ICotacaoRepository;
import com.seguro.residencial.domain.interfaces.repository.cotacoes.query.ListarContacaoQuery;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import com.seguro.residencial.domain.models.root.cotacoes.TipoCalculo;
import com.seguro.residencial.domain.models.root.cotacoes.TipoVigencia;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @criado 12/10/2020 - 21:43
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Component
@Slf4j
public class CotacaoCommandHandler {

    @Autowired
    private ICotacaoRepository cotacaoRepository;

    @EventHandler
    public void on(CriacaoCotacaoEvent event){
        log.debug("Handling a Bank Account creation command {}", event.getId());

        //TODO valida se as entidade do modelo do contexto de cotação estão valida, caso contrario lança exceção e finaliza a operação
        if(VerificacaoCotacaoValida())
            return;

        persistCotacao(buildQueryCotacao(event));
    }

    private CotacaoRoot buildQueryCotacao(CriacaoCotacaoEvent event){
        CotacaoRoot cotacao = new CotacaoRoot();

        cotacao.setDataCotacao(event.getDataCotacao());
        cotacao.setDataVigenciaInicial(event.getDataVigenciaInicial());
        cotacao.setDataVigenciaFinal(event.getDataVigenciaFinal());

        TipoCalculo tipoCalculo = new TipoCalculo();
        tipoCalculo.setId(1L);
        cotacao.setTipoCalculo(tipoCalculo);

        TipoVigencia tipoVigencia = new TipoVigencia();
        tipoVigencia.setId(1L);
        cotacao.setTipoVigencia(tipoVigencia);

        return cotacao;
    }


    private void persistCotacao(CotacaoRoot cotacao){
        cotacaoRepository.save(cotacao);
    }


    @QueryHandler
    public List<CotacaoRoot> handle(ListarContacaoQuery query) {
        log.debug("Handling FindBankAccountQuery query: {}", query);
        return this.cotacaoRepository.findAll();
    }


    /***
     * Validar se a entidade CotacaoRoot está valida e as demais entidades que pertence ao agregado e faz parte da criacao de cotacao
     */
    public boolean VerificacaoCotacaoValida(){
        return false;
    }

}
