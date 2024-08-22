package com.ChallengeGalicia.PathsStations.Controller.imp;

import com.ChallengeGalicia.PathsStations.Controller.StationsController;
import com.ChallengeGalicia.PathsStations.Exceptions.SaveStationException;
import com.ChallengeGalicia.PathsStations.Objects.DTO.GenericResponse;
import com.ChallengeGalicia.PathsStations.Objects.Request.StationRequest;
import com.ChallengeGalicia.PathsStations.Objects.Response.StationResponse;
import com.ChallengeGalicia.PathsStations.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SuppressWarnings("unused")
public class StationControllerImp implements StationsController {

    @Autowired
    StationService stationService;

    @Override
    public ResponseEntity<GenericResponse> putStation(
            String stationId,
            StationRequest stationBody)
        throws RuntimeException {

        boolean saveStation = false;

        //Armamos 1 Resquest No es lo mejor, Pero tiene posibilidades de Expasion
        //En caso de crecer la cantidad de parametros se crea una nueva clase
        // Aqui en la implementacion del controlador
        //Que se supone sera un objeto para enviarlo al servicio
        stationBody.setId( Long.valueOf(stationId) );
        try{
            saveStation = stationService.saveStation( stationBody );

            return new ResponseEntity<>(new GenericResponse("ok"),HttpStatus.OK);

        } catch (SaveStationException ex) {
            System.out.println("Ocurrio un Error durante el proceso. Datos tecnicos: " +
                    ex.getMessage() +
                    ex.getCause());
            return new ResponseEntity<>(new GenericResponse("bad"), HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<List<StationResponse>> getPath() throws RuntimeException {

        List<StationResponse> stations = stationService.getStations();

        return new ResponseEntity<>(stations, HttpStatus.OK);
    }
}
