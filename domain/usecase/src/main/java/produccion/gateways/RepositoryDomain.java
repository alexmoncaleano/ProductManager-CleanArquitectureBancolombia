package produccion.gateways;

import generic.DomainEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RepositoryDomain {


    Flux<DomainEvent > findAllById(String aggregateRootId);

    Mono<DomainEvent> save(DomainEvent event);
}