package com.ChallengeGalicia.PathsStations.Objects.DTO;


import com.ChallengeGalicia.PathsStations.Objects.Request.PathRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PathDTO {

    protected long id;
    protected long destination_id;
    protected double cost;

    public PathDTO(PathRequest request) {
        this.destination_id = request.getDestination_id();
        this.cost = request.getCost();
    }
}
