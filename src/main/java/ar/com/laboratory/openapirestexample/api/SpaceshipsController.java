package ar.com.laboratory.openapirestexample.api;

import ar.com.laboratory.openapirestexample.model.SpaceshipDTO;
import ar.com.laboratory.openapirestexample.util.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@Tag(name="Spaceship controller")
public class SpaceshipsController {
    @GetMapping(Constants.RESOURCE_SPACESHIP +"/{spaceshipId}")
    @Operation(summary = "Obtain detailed information about a specific spaceship")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Spaceship not found")
    })
    public ResponseEntity<SpaceshipDTO> findById(@Parameter(description = "Spaceship's identifier", required = true)
                                                 @PathVariable("spaceshipId") Long spaceshipId){
        return ResponseEntity.ok(null);
    }

    @PostMapping(Constants.RESOURCE_SPACESHIP)
    @Operation(summary = "Register a new spaceship to make it available to manage")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    public ResponseEntity<SpaceshipDTO> registerSpaceship(@RequestBody SpaceshipDTO spaceshipDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.LOCATION, "/spaceships/{id}");
        SpaceshipDTO body = new SpaceshipDTO();
        return new ResponseEntity<>(body, headers, HttpStatus.CREATED);
    }

    @PutMapping(Constants.RESOURCE_SPACESHIP)
    @Operation(summary = "Replace whole spaceship's information or create a new one if not found")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    public ResponseEntity<SpaceshipDTO> replaceOrCreateSpaceship(
            @RequestBody SpaceshipDTO spaceshipDTO,
            @RequestParam(value = "forceCreate", defaultValue = "false") boolean forceCreate) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.LOCATION, "/spaceships/{id}");
        SpaceshipDTO body = new SpaceshipDTO();
        HttpStatus status = forceCreate ? HttpStatus.CREATED : HttpStatus.OK;
        return new ResponseEntity<>(body, headers, status);
    }

    @GetMapping(Constants.RESOURCE_SPACESHIP)
    @Operation(
            summary = "Provide a list of all spaceships",
            tags = "spaceships"
    )
    @ApiResponses(value = {
                         @ApiResponse(responseCode = "200", description = "Ok",
                            content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = SpaceshipDTO.class)))
            )
    })
    public ResponseEntity<List<SpaceshipDTO>> getSpaceships(
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
            @RequestParam(name = "pageNumber", defaultValue = "1") int pageNumber,
            @RequestParam(name = "orderBy", defaultValue = "ASC") String orderBy,
            @RequestParam(name = "alias", required = false) String alias,
            @Parameter(name = "propulsion", description = "Movement mechanism through space.", in = ParameterIn.QUERY, schema = @Schema(type = "string", allowableValues = {"NUCLEAR", "IONIC", "SPACE"}))
            @RequestParam(name = "propulsion", required = false) String propulsion
    ) {
        List<SpaceshipDTO> spaceships = List.of(new SpaceshipDTO());
        return ResponseEntity.ok(spaceships);
    }
}
