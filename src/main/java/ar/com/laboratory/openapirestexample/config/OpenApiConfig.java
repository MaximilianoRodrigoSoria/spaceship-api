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
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class OpenApiConfig
{

    @Value("${context.path}")
    private String contextPath;

    @Value("${info.build.version}")
    private String version;


    @Bean
    public OpenAPI customOpenAPI(@Value("${info.build.version}") String version) {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("basicScheme", new SecurityScheme().type(SecurityScheme.Type.HTTP)
                                .scheme("basic")))
                .info(new Info()
                        .title("Spaceship reservation API")
                        .description("It is and inventory  of spaceships.")
                        .contact(new Contact().name("Jhon Doe").email("jhondoe@test.com").url("www.test.com"))
                        .version(version)
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .addServersItem(new Server().url("http://localhost:8080".concat(contextPath)).description("Local host"))
                .addServersItem(new Server().url("https://dev.spaceships.com".concat(contextPath)).description("Development environment"))
                /*.tags(List.of(new Tag()
                .name("spaceship reservation")
                .description("Vehicle to travel through spaceships")*/
                .externalDocs(new ExternalDocumentation()
                        .description("Find more")
                        .url("https://info.spaceships.com"));
                 }
    @Bean
    public GroupedOpenApi spaceshipApi() {
        return GroupedOpenApi.builder()
                .group("spaceship-api") // Use a unique group name
                .pathsToMatch("/api/v1/spaceship/**") // Define the paths for this group
                .build();
    }

    @Bean
    public GroupedOpenApi allPlanetApi() {
        return GroupedOpenApi.builder()
                .group("all-api") // Use a unique group name
                .pathsToMatch("/api/**") // Define the paths for this group
                .build();
    }

    @Bean
    public GroupedOpenApi planetGroupApi() {
        return GroupedOpenApi.builder()
                .group("planet-api") // Use a unique group name
                .pathsToMatch("/api/v1/planet/**") // Define the paths for this group
                .build();
    }
}
