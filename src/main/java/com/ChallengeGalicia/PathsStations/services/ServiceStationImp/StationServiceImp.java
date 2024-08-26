package com.ChallengeGalicia.PathsStations.services.ServiceStationImp;

import com.ChallengeGalicia.PathsStations.Exceptions.SaveStationException;
import com.ChallengeGalicia.PathsStations.Objects.Request.StationRequest;
import com.ChallengeGalicia.PathsStations.Objects.DTO.StationsDTO;
import com.ChallengeGalicia.PathsStations.Objects.Response.StationResponse;
import com.ChallengeGalicia.PathsStations.services.StationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@SuppressWarnings("unused")
public class StationServiceImp implements StationService{

    private List<StationsDTO> lsStations = new ArrayList<>();

    public List<StationsDTO> getLsStations() {
        return lsStations;
    }

    @Override
    public boolean saveStation(StationRequest request) throws SaveStationException {

        try{ //Esto es un try solo pensando si se cambia las funciones dentro.
            // Puede que mañana se realice una peticion a un repositorio
            StationsDTO peticion = new StationsDTO(request);
            lsStations.add(peticion);
            return true;
        } catch (SaveStationException ex){
            throw new SaveStationException();
        }
    }

    public List<StationResponse> getStations() {
        List<StationResponse> response = new ArrayList<>();
        for(StationsDTO sr : lsStations){
            response.add( new StationResponse(sr) );
        }
        return response;
    }

}
