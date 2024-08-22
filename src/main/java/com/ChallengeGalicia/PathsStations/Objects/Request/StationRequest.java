package com.ChallengeGalicia.PathsStations.Objects.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StationRequest {

    protected Long id;

    @NotBlank(message = "No es posible que la estacion no posea nombre")
    protected String name;
}
