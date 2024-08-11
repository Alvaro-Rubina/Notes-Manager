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
                        .description("API desarrollada con Spring Boot que permite simular la parte Backend de un gestor de notas, " +
                                "permitiendo llevar un control de los usuarios y sus respectivas notas" +
                                " mediante consultas a una base de datos MySQL.")
                        .contact(new Contact()
                                .name("Alvaro Rubina")
                                .email("alvarorubina132@gmail.com")
                                .url("https://github.com/Alvaro-Rubina")));
    }
}
