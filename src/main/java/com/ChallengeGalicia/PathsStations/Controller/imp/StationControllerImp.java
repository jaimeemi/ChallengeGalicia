package com.ChallengeGalicia.PathsStations.Controller.imp;

import com.ChallengeGalicia.PathsStations.Controller.StationsController;
import com.ChallengeGalicia.PathsStations.Objects.Request.StationBodyRequest;
import com.ChallengeGalicia.PathsStations.Objects.Response.StationResponse;
import com.ChallengeGalicia.PathsStations.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StationControllerImp implements StationsController {

    @Autowired
    StationService stationService;

    @Override
    public ResponseEntity<StationResponse> putStation(
            String stationId,
            StationBodyRequest stationBody)
        throws RuntimeException {

        try{
            service.
        } catch (RuntimeException ex) {
            System.out.println("Ocurrio un Error durante el proceso. Datos tecnicos: " +
                    ex.getMessage() +
                    ex.getCause());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
