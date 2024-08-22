package com.ChallengeGalicia.PathsStations.Objects.Response;

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
}

