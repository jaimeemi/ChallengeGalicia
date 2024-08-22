package com.ChallengeGalicia.PathsStations.Objects.Response;

import lombok.Data;

import java.util.List;

@Data
public class DestinationsResponse {

    protected List<Long> path;
    protected double cost;


}
