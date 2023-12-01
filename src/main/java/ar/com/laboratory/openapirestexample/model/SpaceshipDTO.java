package ar.com.laboratory.openapirestexample.model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;


@Data
public class SpaceshipDTO {

    @Schema(description = "Spaceship identifier", accessMode = Schema.AccessMode.READ_ONLY, example = "2r32-d2454-f23d-23ds")
    private Long id;

    @Schema(description = "Common name as the spaceship is recognized", example = "Cosmos")
    private String alias;

    @Schema(description = "Movement mechanism through space", example = "NUCLEAR", allowableValues = {"NUCLEAR", "IONIC", "SPACE"})
    private String propulsion;

    @Schema(description = "Indicates if the spaceship has an energy barrier to protect it from space particles or meteors", defaultValue = "false")
    private boolean hasShield;

    @Schema(description = "Distance traveled by the spaceship")
    private DistanceDTO distanceTraveled;

    @Schema(description = "Main spaceship materials")
    private List<MaterialDTO> materials;

    @Schema(description = "Date when the spaceship was available to travel", format = "date", example = "2101-12-25", accessMode = Schema.AccessMode.READ_ONLY)
    private String creationDate;

}

