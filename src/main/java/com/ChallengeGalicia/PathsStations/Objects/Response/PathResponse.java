package com.ChallengeGalicia.PathsStations.Objects.Response;

import com.ChallengeGalicia.PathsStations.Objects.DTO.PathDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PathResponse {

    protected long id;
    protected double cost;
    protected long destination_id;

    public PathResponse(PathDTO pathDTO){
        this.id = pathDTO.getSource_id();
        this.destination_id = pathDTO.getDestination_id();
        this.cost = pathDTO.getCost();
    }
}

