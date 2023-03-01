package produccion.usecase;
/**
import generic.DomainEvent;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import produccion.domain.AddRawMaterialToRecipeCommand;
import produccion.enums.WeightUnit;
import produccion.events.ProductCreated;
import produccion.events.RawMaterialCreated;
import produccion.gateways.RepositoryDomain;
import produccion.values.Recipe;
import produccion.values.valueObject.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.*;

class AddRawMaterialToRecipeUseCaseTest {
    @Test
    void testAddRawMaterialToRecipe() {
        // Create a mock repository
        RepositoryDomain repositoryMock = Mockito.mock(RepositoryDomain.class);
        Mockito.when(repositoryMock.save(ArgumentMatchers.any(RawMaterialCreated.class))).thenAnswer(invocationOnMock -> {
            // Return the event that was passed as parameter
            return Mono.just((DomainEvent) invocationOnMock.getArgument(0));
        });
        // Create a mock product
        ProductCreated productCreatedEvent = new ProductCreated(new Description("Product"),
                new Recipe(RecipeId.of("RecetaCreada"),
                        new HashSet<RawMaterial>()),new Stock(new HashSet<StockDetail>()),new Information());
        productCreatedEvent.setAggregateRootId("123");
        // Add product to a flux of DomainEvent
        Flux<DomainEvent> productEvents = Flux.just(productCreatedEvent);

        Mockito.when(repositoryMock.findById(Mockito.any())).thenReturn(productEvents);
        // Create use case
        AddRawMaterialToRecipeUseCase addRawMaterialToRecipeUseCase = new AddRawMaterialToRecipeUseCase(repositoryMock);
        // Create command
        AddRawMaterialToRecipeCommand addRawMaterialToRecipeCommand = new AddRawMaterialToRecipeCommand();
        addRawMaterialToRecipeCommand.setProductId("123");
        addRawMaterialToRecipeCommand.setName("Test Raw Material");
        addRawMaterialToRecipeCommand.setQuantity(100);
        addRawMaterialToRecipeCommand.setUnitOfMeasurement(WeightUnit.GRAMS);
        // Execute use case
        Flux<DomainEvent> events = addRawMaterialToRecipeUseCase.apply(Mono.just(addRawMaterialToRecipeCommand));
        // Verify that the "RawMaterialAddedToRecipe" event was saved
        assertEquals(1, events.count().block());
        // Verify that the "findById" method of the repository was called with the correct product id
        Mockito.verify(repositoryMock, Mockito.times(1)).findById("123");

        // Verify that the "saveEvent" method of the repository was called once
        Mockito.verify(repositoryMock, Mockito.times(1)).save(Mockito.any());

        StepVerifier.create(events)
                .expectNextMatches(event -> event.getClass().equals(RawMaterialCreated.class))
                .expectComplete()
                .verify();
    }
}*/