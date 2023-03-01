package produccion.usecase;

import generic.DomainEvent;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import produccion.command.CreateProductCommand;
import produccion.events.ProductCreated;
import produccion.gateways.EventBus;
import produccion.gateways.RepositoryDomain;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class CreateProductUseCaseTest {
    @Test
    void testCreateProduct() {
        // Create a mock repository
        RepositoryDomain repositoryMock = Mockito.mock(RepositoryDomain.class);

        // Configure the behavior of the mock repository
        Mockito.when(repositoryMock.save(Mockito.any())).thenAnswer(invocationOnMock -> {
            // Return the event that was passed as a parameter
            return Mono.just((DomainEvent) invocationOnMock.getArgument(0));
        });

        EventBus eventBusMock = Mockito.mock(EventBus.class);
        // Create the use case
        CreateProductUseCase createProductUseCase = new CreateProductUseCase(repositoryMock, eventBusMock);

        // Create the command
        CreateProductCommand createProductCommand = new CreateProductCommand();
        createProductCommand.setId("123");
        createProductCommand.setDescription("product");


        // Execute the use case
        Flux<DomainEvent> events = createProductUseCase.apply(Mono.just(createProductCommand));

        StepVerifier.create(events)
                .expectNextMatches(event -> {
                    event.getClass().equals(ProductCreated.class);
                    ProductCreated product = (ProductCreated) event;
                    assertEquals(product.getAggregateName(), createProductCommand.getDescription());
                    return true;
                })
                .expectComplete()
                .verify();


        // Verify that the "saveEvent" method of the repository was called
        //Mockito.verify(repositoryMock, Mockito.times(1)).saveEvent(Mockito.any());
    }

}