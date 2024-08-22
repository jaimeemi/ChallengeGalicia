package com.ChallengeGalicia.PathsStations.Objects.Request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PathRequest {

    protected long id;

    @Min(value = 1, message = "La Destinacion No puede estar vacia")
    protected long destination_id;

    @Positive(message = "El costo del viaje debe ser positivo")
    @Min(value = 1, message = "El costo del viaje no puede ser gratuito")
    protected double cost;

}
