package ar.com.laboratory.openapirestexample.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MaterialDTO {
    @Schema(description = "Material identifier", example = "e344-d43d-d211-d23f")
    private String id;

    @Schema(description = "Material name", example = "Carbon fiber", accessMode = Schema.AccessMode.READ_ONLY)
    private String name;
}
