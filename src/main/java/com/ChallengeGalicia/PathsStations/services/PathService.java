package com.ChallengeGalicia.PathsStations.services;

import com.ChallengeGalicia.PathsStations.Exceptions.SavePathExpcetion;
import com.ChallengeGalicia.PathsStations.Objects.Request.PathRequest;

public interface PathService {

    boolean savePath(PathRequest request) throws SavePathExpcetion;
}
