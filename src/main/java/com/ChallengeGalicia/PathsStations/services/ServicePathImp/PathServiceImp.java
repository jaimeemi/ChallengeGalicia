package com.ChallengeGalicia.PathsStations.services.ServicePathImp;

import com.ChallengeGalicia.PathsStations.Exceptions.SavePathExpcetion;
import com.ChallengeGalicia.PathsStations.Objects.DTO.PathDTO;
import com.ChallengeGalicia.PathsStations.Objects.Request.PathRequest;
import com.ChallengeGalicia.PathsStations.Objects.Response.DestinationsResponse;
import com.ChallengeGalicia.PathsStations.Objects.Response.PathResponse;
import com.ChallengeGalicia.PathsStations.services.PathService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<DestinationsResponse> getDestination(Long sourceID, Long destinationId) {

        return searchBestWays(sourceID, destinationId);
    }

    private List<DestinationsResponse> searchBestWays(Long sourceID, Long destinationId){
        List<PathDTO> lsDestinos = lsPath.stream().filter(p -> p.getDestination_id() == destinationId).collect(Collectors.toList());
        lsDestinos.stream().filter(p -> p.getSource_id() == sourceID).collect(Collectors.toList());

        return castDTOtoResponse( lsDestinos ) ;
    }

    private List<DestinationsResponse> castDTOtoResponse( List<PathDTO> dtoList){
        List<DestinationsResponse> response = new ArrayList<>();
        for( PathDTO dto : dtoList){
            response.add (new DestinationsResponse( dto ) );
        }
        return response;
    }



}
