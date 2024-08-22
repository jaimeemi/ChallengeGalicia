package com.ChallengeGalicia.PathsStations.services;

import com.ChallengeGalicia.PathsStations.Exceptions.SaveStationException;
import com.ChallengeGalicia.PathsStations.Objects.Request.StationRequest;

public interface StationService {

    boolean saveStation( StationRequest request ) throws SaveStationException;
}
