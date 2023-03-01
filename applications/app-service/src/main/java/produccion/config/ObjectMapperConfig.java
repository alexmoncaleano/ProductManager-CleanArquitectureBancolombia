package produccion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import produccion.serializer.JSONMapper;
import produccion.serializer.JSONMapperImpl;

@Configuration
public class ObjectMapperConfig {

    @Bean
    public JSONMapper getJsonMapper() {
        return new JSONMapperImpl();
    }



}
