package produccion.usecase;

import generic.DomainEvent;
import produccion.command.CreateProductCommand;
import produccion.gateways.EventBus;
import produccion.gateways.RepositoryDomain;
import produccion.values.Product;
import produccion.values.valueObject.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashSet;

public class CreateProductUseCase extends UseCaseForCommand<CreateProductCommand> {
    private RepositoryDomain repository;
    private final EventBus bus;

    public CreateProductUseCase(RepositoryDomain repository, EventBus bus) {
        this.repository = repository;
        this.bus = bus;
    }

    @Override
    public Flux<DomainEvent> apply(Mono<CreateProductCommand> createProductCommandMono) {
        return createProductCommandMono.flatMapIterable(createProductCommand -> {
            Product product = new Product(ProductId.of(createProductCommand.getId()),
                    new Description(createProductCommand.getDescription()),
                    new Recipe(),
                    new Stock(new HashSet<StockDetail>()),
                    new Information(new HashSet<Presentation>()));

            return product.getUncommittedChanges();
            }).flatMap(domainEvent -> {
            return repository.save(domainEvent);
        }).map(domainEvent -> {
            bus.publish(domainEvent);
            return domainEvent;
        });
    }
}
