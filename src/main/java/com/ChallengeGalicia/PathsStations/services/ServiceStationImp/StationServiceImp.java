package com.ChallengeGalicia.PathsStations.services.ServiceStationImp;

import com.ChallengeGalicia.PathsStations.Exceptions.SaveStationException;
import com.ChallengeGalicia.PathsStations.Objects.Request.StationBodyRequest;
import com.ChallengeGalicia.PathsStations.Objects.StationsDTO;
import com.ChallengeGalicia.PathsStations.services.StationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationServiceImp implements StationService{


    List<StationsDTO> lsStations;

    @Override
    public boolean saveStation(StationBodyRequest request) throws SaveStationException {

        try{
            StationsDTO peticion = new StationsDTO(request);
            lsStations.add(peticion);
            return true;
        } catch (SaveStationException ex){
            throw new SaveStationException();
        }
    }


}
