package ar.com.laboratory.openapirestexample.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OpenApiConfig
{
    @Bean
    public OpenAPI customOpenAPI(@Value("${info.build.version}") String appVersion) {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("basicScheme", new SecurityScheme().type(SecurityScheme.Type.HTTP)
                                .scheme("basic")))
                .info(new Info()
                        .title("Spaceships")
                        .description("It is and inventory  of spaceships.")
                        .contact(new Contact().name("Jhon Doe").email("jhondoe@test.com").url("www.test.com"))
                        .version(appVersion)
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .addServersItem(new Server().url("http://localhost:8080").description("Local host"))
                .addServersItem(new Server().url("https://dev.spaceships.com").description("Development environment"))
                .tags(List.of(new Tag()
                .name("spaceships")
                .description("Vehicle to travel through spaceships")
                .externalDocs(new ExternalDocumentation()
                        .description("Find more")
                        .url("https://info.spaceships.com"))));
                 }


}
