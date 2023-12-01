package ar.com.laboratory.openapirestexample.api;


import ar.com.laboratory.openapirestexample.model.SpaceshipDTO;
import ar.com.laboratory.openapirestexample.model.enums.OrderBy;
import ar.com.laboratory.openapirestexample.model.enums.Propulsion;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Tag(name="Spaceship controller", description = "Vehicle to travel through spaceships", externalDocs = @ExternalDocumentation(description = "Find more info about Spaceships", url = "https://example.com/spaceships"))
public interface SpaceshipsController {

    @Operation(summary = "Obtain detailed information about a specific spaceship")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Spaceship not found")
    })
    public ResponseEntity<SpaceshipDTO> findById(@Parameter(description = "Spaceship's identifier", required = true) Long spaceshipId);


    @Operation(summary = "Register a new spaceship to make it available to manage")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    public ResponseEntity<SpaceshipDTO> registerSpaceship(SpaceshipDTO spaceshipDTO);



    @Operation(summary = "Replace whole spaceship's information or create a new one if not found")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    public ResponseEntity<SpaceshipDTO> replaceOrCreateSpaceship(@RequestBody SpaceshipDTO spaceshipDTO, @RequestParam(value = "forceCreate", defaultValue = "false") boolean forceCreate);


    @Operation(summary = "Provide a list of all spaceships")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = SpaceshipDTO.class)))
            )
    })
    public ResponseEntity<List<SpaceshipDTO>> getSpaceships(
            @Parameter(name = "pageSize", description = "Page size for search results", in = ParameterIn.QUERY, schema = @Schema(type = "int"))
            int pageSize,
            @Parameter(name = "pageNumber", description = "Page number.", in = ParameterIn.QUERY, schema = @Schema(type = "int"))
            int pageNumber,
            @Parameter(name = "orderBy", description = "Order of search results.", in = ParameterIn.QUERY, schema = @Schema(type = "string", allowableValues = {"NONE", "ASC", "DESC"}))
           OrderBy orderBy,
            @Parameter(name = "alias", description = "Common name as the spaceship is recognized.", in = ParameterIn.QUERY, schema = @Schema(type = "string"))
            String alias,
            @Parameter(name = "propulsion", description = "Movement mechanism through space.", in = ParameterIn.QUERY, schema = @Schema(type = "string", allowableValues = {"NUCLEAR", "IONIC", "SPACE"}))
            Propulsion propulsion
    );


    @Operation(summary = "Disable a specific spaceship")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Spaceship not found")
    })
    public ResponseEntity<Void> delete(@Parameter(description = "Spaceship identifier", required = true) Long spaceshipId);
}
