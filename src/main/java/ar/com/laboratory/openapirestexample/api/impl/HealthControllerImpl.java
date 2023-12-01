package ar.com.laboratory.openapirestexample.api.impl;

import ar.com.laboratory.openapirestexample.api.HealthController;
import ar.com.laboratory.openapirestexample.util.Constants;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/health")
@AllArgsConstructor
@Slf4j
public class HealthControllerImpl  implements HealthController {

    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }

}
