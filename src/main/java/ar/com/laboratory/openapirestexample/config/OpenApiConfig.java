package ar.com.laboratory.openapirestexample.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class OpenApiConfig
{



    @Bean
    public OpenAPI customOpenAPI(
            @Value("${open.api.context.path}") String contextPath,
            @Value("${open.api.info.build.version}") String version,
            @Value("${open.api.contact.info.name}") String contactName,
            @Value("${open.api.contact.info.email}") String contactEmail,
            @Value("${open.api.contact.info.url}") String contactUrl,
            @Value("${open.api.contact.info.title}") String title,
            @Value("${open.api.contact.info.description}") String description,
            @Value("${open.api.server.url}") String hostUrl,
            @Value("${open.api.server.description}")String hostDescription,
            @Value("${open.api.external.doc}")String externalDoc,
            @Value("${open.api.external.doc.description}") String externalDocDescription

    ) {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("basicScheme", new SecurityScheme().type(SecurityScheme.Type.HTTP)
                                .scheme("basic")))
                .info(new Info()
                        .title(title)
                        .description(description)
                        .contact(new Contact().name(contactName).email(contactEmail).url(contactUrl))
                        .version(version)
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .addServersItem(new Server().url(hostUrl.concat(contextPath)).description(hostDescription))
                .externalDocs(new ExternalDocumentation()
                        .description(externalDocDescription)
                        .url(externalDoc));
                 }
    @Bean
    public GroupedOpenApi spaceshipApi() {
        return GroupedOpenApi.builder()
                .group("spaceship-api")
                .pathsToMatch("/api/v1/spaceship/**")
                .build();
    }

    @Bean
    public GroupedOpenApi allPlanetApi() {
        return GroupedOpenApi.builder()
                .group("all")
                .pathsToMatch("/api/**")
                .build();
    }

    @Bean
    public GroupedOpenApi planetGroupApi() {
        return GroupedOpenApi.builder()
                .group("health-api")
                .pathsToMatch("/api/v1/health/**")
                .build();
    }
}
