package produccion.api;

import generic.DomainEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import produccion.command.CreateProductCommand;
import produccion.usecase.CreateProductUseCase;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRest {
    @Bean
    public RouterFunction<ServerResponse> routerFunction(CreateProductUseCase useCase) {
        return route(POST("/api/usecase/producto"), request -> {
           /**return useCase.apply(request.bodyToMono(CreateProductCommand.class)).collectList()
                   .flatMap(domainEvent -> ServerResponse.ok().bodyValue(domainEvent));*/

            return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                   .body(BodyInserters.fromPublisher(useCase.apply(request.bodyToMono(CreateProductCommand.class)), DomainEvent.class)
                   );
            });
    }


}
