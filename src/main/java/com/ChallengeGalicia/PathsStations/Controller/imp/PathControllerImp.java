package com.ChallengeGalicia.PathsStations.Controller.imp;

import com.ChallengeGalicia.PathsStations.Controller.PathController;
import com.ChallengeGalicia.PathsStations.Exceptions.SaveStationException;
import com.ChallengeGalicia.PathsStations.Objects.DTO.GenericResponse;
import com.ChallengeGalicia.PathsStations.Objects.Request.PathRequest;
import com.ChallengeGalicia.PathsStations.Objects.Response.DestinationsResponse;
import com.ChallengeGalicia.PathsStations.Objects.Response.PathResponse;
import com.ChallengeGalicia.PathsStations.services.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@SuppressWarnings("unused")
public class PathControllerImp implements PathController {

    @Autowired
    PathService pathService;

    @Override
    public ResponseEntity<GenericResponse> putPath(Long pathId, PathRequest pathRequest) throws RuntimeException {

        boolean saveStation = false;


        try{
            saveStation = pathService.savePath( pathRequest );

            return new ResponseEntity<>(new GenericResponse("ok"), HttpStatus.OK);

        } catch (SaveStationException ex) {
            System.out.println("Ocurrio un Error durante el proceso. Datos tecnicos: " +
                    ex.getMessage() +
                    ex.getCause());
            return new ResponseEntity<>(new GenericResponse("bad"), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<PathResponse>> getPath() throws RuntimeException {
        List<PathResponse> paths = null;
        try{
            paths = pathService.getPaths();
        }catch(RuntimeException ex){
            System.out.println(ex.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(paths, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<DestinationsResponse>> getDestinations( Long sourceID, Long destinationId ) throws RuntimeException{
        List<DestinationsResponse> response;
        try{
            response = pathService.getDestination(sourceID, destinationId );
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage() + ex.getCause());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
