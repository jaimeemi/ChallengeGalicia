package com.ChallengeGalicia.PathsStations.Objects.DTO;

import com.ChallengeGalicia.PathsStations.Objects.Request.StationRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StationsDTO {

    protected Long id;
    protected String name;

    public StationsDTO (StationRequest request){
        this.name = request.getName();
    }

}
