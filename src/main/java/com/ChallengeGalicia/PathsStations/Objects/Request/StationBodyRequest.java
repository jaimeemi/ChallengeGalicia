package com.ChallengeGalicia.PathsStations.Objects.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StationBodyRequest {

    protected Long id;

    @NotBlank(message = "Name cannot be null or empty")
    protected String name;

}
