package com.ChallengeGalicia.PathsStations.Controller;

import com.ChallengeGalicia.PathsStations.Objects.DTO.GenericResponse;
import com.ChallengeGalicia.PathsStations.Objects.Request.PathRequest;
import com.ChallengeGalicia.PathsStations.Objects.Response.DestinationsResponse;
import com.ChallengeGalicia.PathsStations.Objects.Response.PathResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/path")
//        consumes = "application/json",
//        produces = "application/json")
public interface PathController {

    @PutMapping("/{path_id}")
    ResponseEntity<GenericResponse> putPath(
            @PathVariable("path_id") Long pathId,
            @Valid @RequestBody PathRequest pathRequest
    ) throws RuntimeException;

    @GetMapping("/")
    ResponseEntity<List<PathResponse>> getPath() throws RuntimeException;

    @GetMapping("/paths/{source_id}/{destination_id}")
    ResponseEntity<List<DestinationsResponse>> getDestinations(
            @PathVariable("source_id") Long sourceID,
            @PathVariable("destination_id") Long destinationId
    ) throws RuntimeException;

}
