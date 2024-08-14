package org.alvarub.notesmanager.utils.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {

    @Bean
    public OpenAPI api(){
        return new OpenAPI()
                .info(new Info()
                        .title("Notes Manger")
                        .description("API developed with Spring Boot that simulates the backend of a note manager, allowing for the " +
                                "management of users and their notes through queries to a MySQL database")
                        .contact(new Contact()
                                .name("Alvaro Rubina")
                                .email("alvarorubina132@gmail.com")
                                .url("https://github.com/Alvaro-Rubina")));
    }
}
