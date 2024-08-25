package com.ChallengeGalicia.PathsStations.Objects.DTO;


import com.ChallengeGalicia.PathsStations.Objects.Request.PathRequest;
import lombok.Data;


@Data
public class PathDTO {

    //La uso para incrementar el contaro del source_id
    private static long contador = 0;

    protected long id;
    protected long source_id;
    protected long destination_id;
    protected double cost;


    public PathDTO(PathRequest request) {
        this.id = ++contador;
        this.source_id = request.getId();
        this.destination_id = request.getDestination_id();
        this.cost = request.getCost();
    }


    public PathDTO(long source_id, long destination_id, double cost) {
        this.id = ++contador;
        this.source_id = source_id;
        this.destination_id = destination_id;
        this.cost = cost;
    }

    public PathDTO(long source_id, double newCost) {
        this.source_id = source_id;
        this.cost = newCost;
    }
}
