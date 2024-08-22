package com.ChallengeGalicia.PathsStations.Objects.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PathRequest {

    protected long id;

    @NotBlank(message = "La Destinacion No puede estar vacia")
    protected long destination_id;

    @NotBlank(message = "El costo del viaje no puede ser gratuito")
    protected double cost;

}
