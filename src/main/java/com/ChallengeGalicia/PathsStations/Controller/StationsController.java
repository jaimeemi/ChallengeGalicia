package com.ChallengeGalicia.PathsStations.Controller;

import com.ChallengeGalicia.PathsStations.Objects.DTO.GenericResponse;
import com.ChallengeGalicia.PathsStations.Objects.Request.StationRequest;
import com.ChallengeGalicia.PathsStations.Objects.Response.StationResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(value = "/stations")
//        consumes = "application/json",
//        produces = "application/json")
public interface StationsController  {

    @PutMapping("/{station_id}")
    ResponseEntity<GenericResponse> putStation(
            @PathVariable ("station_id") String stationId,
            @Valid @RequestBody StationRequest stationBody //Uso anotacion para validar el Cuerpo
    ) throws RuntimeException;

    @GetMapping("/")
    ResponseEntity<List<StationResponse>> getPath() throws RuntimeException;

}
