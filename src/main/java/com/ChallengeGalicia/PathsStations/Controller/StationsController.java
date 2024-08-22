package com.ChallengeGalicia.PathsStations.Controller;

import com.ChallengeGalicia.PathsStations.Objects.Request.StationBodyRequest;
import com.ChallengeGalicia.PathsStations.Objects.Response.StationResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping(value = "/stations",
        consumes = "application/json",
        produces = "application/json")
public interface StationsController  {

    @PutMapping("/{station_id}")
    ResponseEntity<StationResponse> putStation(
            @PathVariable ("station_id") String stationId,
            @Valid @RequestBody StationBodyRequest stationBody //Uso anotacion para validar el Cuerpo
    ) throws RuntimeException;
}
