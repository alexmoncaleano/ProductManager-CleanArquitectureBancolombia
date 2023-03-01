package produccion.usecase;
/**
import generic.DomainEvent;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import produccion.domain.AddStockCommand;
import produccion.enums.Currency;
import produccion.enums.WeightUnit;
import produccion.events.ProductCreated;
import produccion.events.StockDetailCreated;
import produccion.gateways.RepositoryDomain;
import produccion.values.Recipe;
import produccion.values.valueObject.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import java.math.BigDecimal;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.*;

class addStockUseCaseTest {

    @Test
    void testAddStockUseCase(){

        //Create a mock repository
        RepositoryDomain repository = Mockito.mock(RepositoryDomain.class);

        //Configure the behavior of the mock repository
        Mockito.when(repository.save(Mockito.any())).thenAnswer(invocationOnMock -> {
            // Return the event that was passed as a parameter
            return Mono.just((DomainEvent) invocationOnMock.getArgument(0));
        });

        // Create a mock product
        ProductCreated productCreatedEvent = new ProductCreated(new Description("Product"),
                new Recipe(RecipeId.of("RecetaCreada"),
                        new HashSet<RawMaterial>()),new Stock(new HashSet<StockDetail>()),new Information());
        productCreatedEvent.setAggregateRootId("123");
        // Add product to a flux of DomainEvent
        Flux<DomainEvent> productEvents = Flux.just(productCreatedEvent);

        Mockito.when(repository.findById(Mockito.any())).thenReturn(productEvents);

        //Create use case
        AddStockUseCase addStockUseCase = new AddStockUseCase(repository);

        //Create Command
        AddStockCommand addStockCommand = new AddStockCommand();
        addStockCommand.setProductId("123");
        addStockCommand.setUnits(5);
        addStockCommand.setQuantity(500);
        addStockCommand.setUnitOfMeasurement(WeightUnit.GRAMS);
        addStockCommand.setPrice(BigDecimal.valueOf(10));
        addStockCommand.setCurrency(Currency.PESO);

        //Execute use case
        Flux<DomainEvent> events = addStockUseCase.apply(Mono.just(addStockCommand));

        assertEquals(1, events.count().block());
        // Verify that the "findById" method of the repository was called with the correct product id
        Mockito.verify(repository, Mockito.times(1)).findById("123");

        // Verify that the "saveEvent" method of the repository was called once
        Mockito.verify(repository, Mockito.times(1)).save(Mockito.any());

        StepVerifier.create(events)
                .expectNextMatches(event -> event.getClass().equals(StockDetailCreated.class))
                .expectComplete()
                .verify();
    }

}*/