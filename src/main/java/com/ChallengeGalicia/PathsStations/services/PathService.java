package com.ChallengeGalicia.PathsStations.services;

import com.ChallengeGalicia.PathsStations.Exceptions.SavePathExpcetion;
import com.ChallengeGalicia.PathsStations.Objects.Request.PathRequest;
import com.ChallengeGalicia.PathsStations.Objects.Response.DestinationsResponse;
import com.ChallengeGalicia.PathsStations.Objects.Response.PathResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PathService {

    boolean savePath(PathRequest request) throws SavePathExpcetion;

    List<PathResponse> getPaths();

    List<DestinationsResponse> getDestination(long sourceID, long destinationId);
}
