package com.seguro.residencial.application.services;

import com.seguro.residencial.application.interfaces.ICotacaoQueryAppService;
import com.seguro.residencial.domain.models.root.cotacao.Cotacao;
import com.seguro.residencial.domain.querys.cotacao.FindCotacaoQuery;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.Message;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static com.seguro.residencial.application.services.ServiceUtils.formatUuid;

/**
 * @criado 15/10/2020 - 23:57
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Service
public class CotacaoQueryAppServiceImpl implements ICotacaoQueryAppService {

    private final QueryGateway queryGateway;
    private final EventStore eventStore;

    public CotacaoQueryAppServiceImpl(QueryGateway queryGateway, EventStore eventStore) {
        this.queryGateway = queryGateway;
        this.eventStore = eventStore;
    }

    @Override
    public CompletableFuture<Cotacao> findById(String idCotacao) {
        return this.queryGateway.query(
                new FindCotacaoQuery(idCotacao),
                ResponseTypes.instanceOf(Cotacao.class)
        );
    }

    public List<Object> listEventsForAccount(String accountId) {
        return this.eventStore
                .readEvents(formatUuid(accountId).toString())
                .asStream()
                .map(Message::getPayload)
                .collect(Collectors.toList());
    }

}
