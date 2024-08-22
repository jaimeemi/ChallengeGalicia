package com.ChallengeGalicia.PathsStations.services.ServicePathImp;

import com.ChallengeGalicia.PathsStations.Exceptions.SavePathExpcetion;
import com.ChallengeGalicia.PathsStations.Objects.DTO.PathDTO;
import com.ChallengeGalicia.PathsStations.Objects.Request.PathRequest;
import com.ChallengeGalicia.PathsStations.Objects.Response.DestinationsResponse;
import com.ChallengeGalicia.PathsStations.Objects.Response.PathResponse;
import com.ChallengeGalicia.PathsStations.services.PathService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@SuppressWarnings("unused")
public class PathServiceImp implements PathService {

    private List<PathDTO> lsPath = new ArrayList<>();

    @Override
    public boolean savePath(PathRequest request) throws SavePathExpcetion {

        try{
            PathDTO peticion = new PathDTO(request);
            lsPath.add(peticion);
            return true;
        } catch (SavePathExpcetion ex){
            throw new SavePathExpcetion();
        }
    }

    public List<PathResponse> getPaths(){
        List<PathResponse> response = new ArrayList<>();
        for(PathDTO pathDTO : lsPath){
            response.add( new PathResponse(pathDTO) );
        }
        return response;
    }

    ResponseEntity<List<DestinationsResponse>> getDestinations(Long sourceID, Long destinationId ){


        return null;
    }

}
