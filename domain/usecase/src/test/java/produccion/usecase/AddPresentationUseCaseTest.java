package produccion.usecase;
/**
import generic.DomainEvent;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import produccion.domain.AddPresentationCommand;
import produccion.enums.Currency;
import produccion.enums.WeightUnit;
import produccion.events.PresentationCreated;
import produccion.events.ProductCreated;
import produccion.gateways.RepositoryDomain;
import produccion.values.Recipe;
import produccion.values.valueObject.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class AddPresentationUseCaseTest {

    @Test
    public void agregarPresentacionDeberiaCrearEventoDeDominio() {
        // Step 1: Create a mock Repository object
        RepositoryDomain repositoryMock = mock(RepositoryDomain.class);
        Mockito.when(repositoryMock.save(Mockito.any())).thenAnswer(invocationOnMock -> {
            // Returns the event passed as a parameter
            return Mono.just((DomainEvent) invocationOnMock.getArgument(0));
        });
        // create event
        ProductCreated product = new ProductCreated(new Description("Test product"),
                new Recipe(RecipeId.of("CreatedRecipe"),
                        new HashSet<RawMaterial>()), new Stock(new HashSet<StockDetail>()), new Information());
        product.setAggregateRootId("123");

        // Add the event to a DomainEvent flux
        Flux<DomainEvent> productoEventos = Flux.just(product);

        // Configure the mock repository behavior
        Mockito.when(repositoryMock.findById(Mockito.any())).thenReturn(productoEventos);

        // Step 2: Create a valid AddPresentationCommand object
        String productId = "123";
        Integer quantity = 10;
        WeightUnit unitOfMeasure = WeightUnit.KILOGRAMS;
        BigDecimal price = BigDecimal.valueOf(10.500);
        Currency currency = Currency.PESO;
        AddPresentationCommand addPresentationCommand = new AddPresentationCommand(productId, quantity, unitOfMeasure, price, currency);

        // Step 3: Create an instance of AddPresentationUseCase
        AddPresentationUseCase addPresentationUseCase = new AddPresentationUseCase(repositoryMock);

        Flux<DomainEvent> eventos = addPresentationUseCase.apply(Mono.just(addPresentationCommand));

        assertEquals(1, eventos.count().block());

        // Verify that the "findByIdReactive" method of the repository was called with the correct product id
        Mockito.verify(repositoryMock, Mockito.times(1)).findById("123");

        // Verify that the "saveEvent" method of the repository was called
        Mockito.verify(repositoryMock, Mockito.times(1)).save(Mockito.any());

        StepVerifier.create(eventos)
                .expectNextMatches(event -> event.getClass().equals(PresentationCreated.class))
                .expectComplete()
                .verify();
    }
}*/