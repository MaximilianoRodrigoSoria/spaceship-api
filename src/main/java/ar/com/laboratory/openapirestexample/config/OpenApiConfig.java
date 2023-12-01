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

    @Value("${open.api.context.path}")
    private String contextPath;

    @Value("${info.build.version}")
    private String version;

    @Value("${open.api.contact.info.name}")
    private String contactName;

    @Value("${open.api.contact.info.email}")
    private String contactEmail;

    @Value("${open.api.contact.info.url}")
    private String contactUrl;

    @Value("${open.api.contact.info.title}")
    private String title;

    @Value("${open.api.contact.info.description}")
    private String description;

    @Value("${open.api.server.url}")
    private String hostUrl;

    @Value("${open.api.server.description}")
    private String hostDescription;

    @Value("${open.api.external.doc}")
    private String externalDoc;

    @Bean
    public OpenAPI customOpenAPI(@Value("${info.build.version}") String version) {
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
                        .description("Find more")
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
