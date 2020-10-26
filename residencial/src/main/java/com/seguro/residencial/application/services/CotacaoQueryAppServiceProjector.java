package com.seguro.residencial.application.services;

import com.seguro.residencial.application.interfaces.ICotacaoQueryAppService;
import com.seguro.residencial.domain.interfaces.repository.cotacao.ITipoCalculoRepository;
import com.seguro.residencial.domain.interfaces.repository.cotacoes.query.ListarContacaoQuery;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import com.seguro.residencial.domain.models.root.cotacoes.TipoCalculo;
import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @criado 15/10/2020 - 23:57
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Service
public class CotacaoQueryAppServiceProjector implements ICotacaoQueryAppService {

    private final ITipoCalculoRepository iTipoCalculoRepository;
    private final QueryGateway queryGateway;

    public CotacaoQueryAppServiceProjector(ITipoCalculoRepository iTipoCalculoRepository, QueryGateway queryGateway) {
        this.iTipoCalculoRepository = iTipoCalculoRepository;
        this.queryGateway = queryGateway;
    }

    @Override
    public List<TipoCalculo> listarTipoCalculo() {
        return iTipoCalculoRepository.findAll();
    }

    @Override
    public CompletableFuture<CotacaoRoot> listarTodos() throws ExecutionException, InterruptedException {
        return this.queryGateway.query(
                new ListarContacaoQuery(), ResponseTypes.instanceOf(CotacaoRoot.class));
    }
}
