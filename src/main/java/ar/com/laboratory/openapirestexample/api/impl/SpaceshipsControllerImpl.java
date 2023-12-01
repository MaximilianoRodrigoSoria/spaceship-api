package ar.com.laboratory.openapirestexample.api.impl;

import ar.com.laboratory.openapirestexample.api.SpaceshipsController;
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

@RestController
@RequestMapping("/api/v1/spaceship")
@AllArgsConstructor
@Slf4j
public class SpaceshipsControllerImpl implements SpaceshipsController {
    @GetMapping("/{spaceshipId}")
    public ResponseEntity<SpaceshipDTO> findById(@PathVariable("spaceshipId") Long spaceshipId){
        log.info("ID: {}", spaceshipId);
        return ResponseEntity.ok(null);
    }

    @PostMapping
    public ResponseEntity<SpaceshipDTO> registerSpaceship(@RequestBody SpaceshipDTO spaceshipDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.LOCATION, "/spaceships/{id}");
        log.info(spaceshipDTO.toString());
        return new ResponseEntity<>(spaceshipDTO, headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<SpaceshipDTO> replaceOrCreateSpaceship(
            @RequestBody SpaceshipDTO spaceshipDTO, boolean forceCreate) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.LOCATION, "/spaceships/{id}");
        SpaceshipDTO body = new SpaceshipDTO();
        HttpStatus status = forceCreate ? HttpStatus.CREATED : HttpStatus.OK;
        log.info("spaceship: {} force: {}",spaceshipDTO.toString(), forceCreate);
        return new ResponseEntity<>(body, headers, status);
    }

    @GetMapping
    public ResponseEntity<List<SpaceshipDTO>> getSpaceships(
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
            @RequestParam(name = "pageNumber", defaultValue = "1") int pageNumber,
            @RequestParam(name = "orderBy", defaultValue = "ASC") OrderBy orderBy,
            @RequestParam(name = "alias", required = false) String alias,
            @RequestParam(name = "propulsion", required = false) Propulsion propulsion
    ) {
        log.info("pageSize: {} PageNumber: {} OrderBy: {} alias: {} Propulsion: {}",pageSize,pageNumber,orderBy,alias,propulsion);
        List<SpaceshipDTO> spaceships = List.of(new SpaceshipDTO());
        return ResponseEntity.ok(spaceships);
    }

    @DeleteMapping("/{spaceshipId}")
    public ResponseEntity<Void> delete(@PathVariable("spaceshipId") Long spaceshipId){
        log.info("Id: {}",spaceshipId);
        return ResponseEntity.noContent().build();
    }
}
