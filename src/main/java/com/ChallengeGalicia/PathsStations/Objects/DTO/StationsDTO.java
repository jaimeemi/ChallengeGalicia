package com.ChallengeGalicia.PathsStations.Objects.DTO;

import com.ChallengeGalicia.PathsStations.Objects.Request.StationRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// No los voy a colocar: necesito que no tenga constructores salvos lo que uso, ya que no son Entities
//@AllArgsConstructor
//@NoArgsConstructor
public class StationsDTO {

    //La uso para incrementar el contaro del ID
    private static long contadorStation = 0;

    protected Long id;
    protected String name;

    public StationsDTO (StationRequest request){
        this.id = ++contadorStation;
        this.name = request.getName();
    }

    public StationsDTO(String name) {
        this.id = ++contadorStation;
        this.name = name;
    }

}
