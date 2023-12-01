package ar.com.laboratory.openapirestexample.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class DistanceDTO {
    @Schema(description = "Distance value", example = "10", minimum = "0")
    private long distance;

    @Schema(description = "Distance unit which represents the value", example = "PERSEC", allowableValues = {"ASTRONOMIC_UNIT", "LIGHT_YEAR", "PERSEC"})
    private String unit;
}
