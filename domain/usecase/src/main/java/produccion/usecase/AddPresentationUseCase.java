package produccion.usecase;
/**
import generic.DomainEvent;
import produccion.domain.AddPresentationCommand;
import produccion.gateways.RepositoryDomain;
import produccion.values.Product;
import produccion.values.valueObject.Price;
import produccion.values.valueObject.ProductId;
import produccion.values.valueObject.Quantity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class AddPresentationUseCase extends UseCaseForCommand<AddPresentationCommand> {

    private RepositoryDomain repository;

    public AddPresentationUseCase(RepositoryDomain repositorio) {
        this.repository = repositorio;
    }

    @Override
    public Flux<DomainEvent> apply(Mono<AddPresentationCommand> agregarPreseAddPresentationCommandMono) {
        return agregarPreseAddPresentationCommandMono.flatMapMany(command -> repository.findAllById(command.getProductId())
                .collectList().flatMapIterable(domainEvents -> {
                    Product product = Product.from(ProductId.of(command.getProductId()), domainEvents);
                    product.addPresentation(new Quantity(command.getQuantity(), command.getUnitOfMeasure()),new Price(command.getPrice(),command.getCurrency()));
                    return product.getUncommittedChanges();
                }).flatMap(domainEvent -> repository.save(domainEvent))
        );
    }
}
*/