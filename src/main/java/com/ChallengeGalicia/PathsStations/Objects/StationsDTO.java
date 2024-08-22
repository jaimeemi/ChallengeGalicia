package com.ChallengeGalicia.PathsStations.Objects;

import com.ChallengeGalicia.PathsStations.Objects.Request.StationBodyRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StationsDTO {

    protected Long id;
    protected String name;

    public StationsDTO (StationBodyRequest request){
        this.name = request.getName();
    }

}
