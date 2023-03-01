package produccion.usecase;
/**
import generic.DomainEvent;
import produccion.domain.AddStockCommand;
import produccion.gateways.RepositoryDomain;
import produccion.values.Product;
import produccion.values.valueObject.Presentation;
import produccion.values.valueObject.Price;
import produccion.values.valueObject.ProductId;
import produccion.values.valueObject.Quantity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class AddStockUseCase extends UseCaseForCommand<AddStockCommand>{

    private RepositoryDomain repository;

    public AddStockUseCase(RepositoryDomain repository) {
        this.repository = repository;
    }

    @Override
    public Flux<DomainEvent> apply(Mono<AddStockCommand> addStockCommandMono) {
        return addStockCommandMono.flatMapMany(command ->
            repository.findAllById(command.getProductId())
                    .collectList()
                    .flatMapIterable(domainEvents -> {
                        Product product = Product.from(ProductId.of(command.getProductId()), domainEvents);
                        product.addStock(command.getUnits(),
                                new Presentation(
                                        new Quantity(command.getQuantity(), command.getUnitOfMeasurement()),
                                        new Price(command.getPrice(),command.getCurrency())));
                        return product.getUncommittedChanges();
                    }).flatMap(domainEvent -> repository.save((DomainEvent) domainEvent))

        );
    }
}
*/