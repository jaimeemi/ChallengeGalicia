package com.ChallengeGalicia.PathsStations.Objects.DTO;


import com.ChallengeGalicia.PathsStations.Objects.Request.PathRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// No los voy a colocar: necesito que no tenga constructores salvos lo que uso, ya que no son Entities
//@AllArgsConstructor
//@NoArgsConstructor
public class PathDTO {

    //La uso para incrementar el contaro del ID
    private static long contadorPath = 0;

    protected long id;
    protected long destination_id;
    protected double cost;

    public PathDTO(long destination_id, double cost) {
        this.id = ++contadorPath;
        this.destination_id = destination_id;
        this.cost = cost;
    }

    public PathDTO(PathRequest request) {
        this.id = ++contadorPath;
        this.destination_id = request.getDestination_id();
        this.cost = request.getCost();
    }
}
