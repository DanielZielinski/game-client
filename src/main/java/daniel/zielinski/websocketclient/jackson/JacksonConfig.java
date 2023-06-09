package daniel.zielinski.websocketclient.jackson;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {
    @Bean
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }

}

