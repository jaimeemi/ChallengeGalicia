package com.ChallengeGalicia.PathsStations.services;

import com.ChallengeGalicia.PathsStations.Exceptions.SaveStationException;
import com.ChallengeGalicia.PathsStations.Objects.Request.StationRequest;
import com.ChallengeGalicia.PathsStations.Objects.Response.StationResponse;

import java.util.List;

public interface StationService {

    boolean saveStation( StationRequest request ) throws SaveStationException;

    List<StationResponse> getStations();
}
