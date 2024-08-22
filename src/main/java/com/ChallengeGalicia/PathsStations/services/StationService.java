package com.ChallengeGalicia.PathsStations.services;

import com.ChallengeGalicia.PathsStations.Exceptions.SaveStationException;
import com.ChallengeGalicia.PathsStations.Objects.Request.StationBodyRequest;

public interface StationService {

    boolean saveStation( StationBodyRequest request ) throws SaveStationException;
}
