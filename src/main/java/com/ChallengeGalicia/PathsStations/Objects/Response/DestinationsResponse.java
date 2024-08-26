package com.ChallengeGalicia.PathsStations.Objects.Response;

import com.ChallengeGalicia.PathsStations.Objects.DTO.PathDTO;
import lombok.Data;

import java.util.List;

@Data
public class DestinationsResponse {

    protected List<Long> path;
    protected double cost;

    public DestinationsResponse () {

    }

    public DestinationsResponse (PathDTO pathDTO){
        this.path.add(pathDTO.getSource_id());
        this.path.add(pathDTO.getDestination_id());
        this.cost += pathDTO.getCost();
    }

    public DestinationsResponse (List<PathDTO> pathDTO){
        for (PathDTO p : pathDTO){
            this.path.add(p.getSource_id());
            this.path.add(p.getDestination_id());
            this.cost += p.getCost();
        }
    }


}
