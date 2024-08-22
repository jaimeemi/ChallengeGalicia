package com.ChallengeGalicia.PathsStations.Objects.Response;

import com.ChallengeGalicia.PathsStations.Objects.DTO.StationsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StationResponse {

    protected String name;

    public StationResponse(StationsDTO stationsDTO){
        this.name = stationsDTO.getName();
    }
}
/*
* Este Objeto Se usa para las respuestas. Pensando en el Futuro por si se requiere un EP
* QUe solicite los Datos, No confundir con un DTO, este ultimo es solo para manejo de datos
* Que pueden ser alterados en tiempo de ejecucion
* */