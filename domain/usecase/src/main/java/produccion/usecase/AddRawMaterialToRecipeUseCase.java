package produccion.usecase;

import generic.DomainEvent;
import produccion.command.AddRawMaterialToRecipeCommand;
import produccion.gateways.EventBus;
import produccion.gateways.RepositoryDomain;
import produccion.values.Product;
import produccion.values.valueObject.ProductId;
import produccion.values.valueObject.Quantity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.image.BufferStrategy;

public class AddRawMaterialToRecipeUseCase extends UseCaseForCommand<AddRawMaterialToRecipeCommand> {

    private RepositoryDomain repository;
    private EventBus bus;

    public AddRawMaterialToRecipeUseCase(RepositoryDomain repository, EventBus bus) {
        this.repository = repository;
        this.bus = bus;
    }

    @Override
    public Flux<DomainEvent> apply(Mono<AddRawMaterialToRecipeCommand> addRawMaterialToRecipeCommandMono) {
        return addRawMaterialToRecipeCommandMono.flatMapMany(command ->  repository.findAllById(command.getProductId())
                        .collectList().flatMapIterable(domainEvents -> {
                            Product product = Product.from(ProductId.of(command.getProductId()), domainEvents);
                            product.addRawMaterial(command.getName(),
                                    new Quantity(command.getQuantity(), command.getUnitOfMeasurement()));
                            return product.getUncommittedChanges();
                        }).flatMap(domainEvent -> repository.save(domainEvent))
        ).map(domainEvent -> {
        bus.publish(domainEvent);
        return domainEvent;
    });

    }
}
