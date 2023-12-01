package ar.com.laboratory.openapirestexample.api;

import ar.com.laboratory.openapirestexample.model.SpaceshipDTO;
import ar.com.laboratory.openapirestexample.model.enums.OrderBy;
import ar.com.laboratory.openapirestexample.model.enums.Propulsion;
import ar.com.laboratory.openapirestexample.util.Constants;
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
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@Tag(name="Health controller", description = "Obtain information on the health of the service", externalDocs = @ExternalDocumentation(description = "Find more info about Spaceships", url = "https://example.com/spaceships"))
@Slf4j
public class HealthController {
    @GetMapping(Constants.RESOURCE_HEALTH)
    @Operation(summary = "Obtain information on the health of the service")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK")
    })
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }

}
