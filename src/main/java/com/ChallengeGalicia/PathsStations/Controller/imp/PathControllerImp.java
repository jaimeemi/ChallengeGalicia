package com.ChallengeGalicia.PathsStations.Controller.imp;

import com.ChallengeGalicia.PathsStations.Controller.PathController;
import com.ChallengeGalicia.PathsStations.Exceptions.SaveStationException;
import com.ChallengeGalicia.PathsStations.Objects.Request.PathRequest;
import com.ChallengeGalicia.PathsStations.Objects.Response.PathResponse;
import com.ChallengeGalicia.PathsStations.Objects.Response.StationResponse;
import com.ChallengeGalicia.PathsStations.services.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SuppressWarnings("unused")
public class PathControllerImp implements PathController {

    @Autowired
    PathService pathService;

    @Override
    public ResponseEntity<PathResponse> putPath(Long pathId, PathRequest pathRequest) throws RuntimeException {

        boolean saveStation = false;

        pathRequest.setId(pathId);
        try{
            saveStation = pathService.savePath( pathRequest );

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (SaveStationException ex) {
            System.out.println("Ocurrio un Error durante el proceso. Datos tecnicos: " +
                    ex.getMessage() +
                    ex.getCause());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<PathResponse>> getPath() throws RuntimeException {

        List<PathResponse> paths = pathService.getPaths();

        return new ResponseEntity<>(paths, HttpStatus.OK);
    }
}
