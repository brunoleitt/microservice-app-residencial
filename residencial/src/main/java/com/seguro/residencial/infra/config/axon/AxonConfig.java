package com.seguro.residencial.infra.config.axon;

import com.seguro.residencial.domain.aggregates.CotacaoAggregate;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @criado 12/10/2020 - 14:24
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
//@Configuration
public class AxonConfig {

//    @Bean
//    EventSourcingRepository<CotacaoAggregate> cotacaoAggregateEventSourcingRepository(EventStore eventStore){
//        EventSourcingRepository<CotacaoAggregate> repository =
//                EventSourcingRepository.builder(CotacaoAggregate.class).eventStore(eventStore).build();
//        return repository;
//    }

}
