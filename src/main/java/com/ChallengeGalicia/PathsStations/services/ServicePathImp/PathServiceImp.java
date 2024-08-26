package com.ChallengeGalicia.PathsStations.services.ServicePathImp;

import com.ChallengeGalicia.PathsStations.Exceptions.SavePathExpcetion;
import com.ChallengeGalicia.PathsStations.Objects.DTO.PathDTO;
import com.ChallengeGalicia.PathsStations.Objects.Request.PathRequest;
import com.ChallengeGalicia.PathsStations.Objects.Response.DestinationsResponse;
import com.ChallengeGalicia.PathsStations.Objects.Response.PathResponse;
import com.ChallengeGalicia.PathsStations.services.PathService;
import com.ChallengeGalicia.PathsStations.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@SuppressWarnings("unused")
public class PathServiceImp implements PathService {

    @Autowired
    private StationService stationService;

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
    public List<DestinationsResponse> getDestination(long getSource_id, long destinationId) {

        return searchBestWays(getSource_id, destinationId);
    }

    public List<DestinationsResponse> searchBestWays(long sourceId, long destinationId) {
        List<Long> estaciones = new ArrayList<>();
        List<PathDTO> paths = lsPath;
        int n = stationService.getStations().size();
        double[] costoMinimo = new double[n];
        Long[] estacionPrevia = new Long[n];
        boolean[] visitado = new boolean[n];

        Arrays.fill(costoMinimo, Double.MAX_VALUE);
        int indiceOrigen = estaciones.indexOf(sourceId);
        costoMinimo[indiceOrigen] = 0.0;

        for (int i = 0; i < n; i++) {
            int actual = -1;
            double minCosto = Double.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (!visitado[j] && costoMinimo[j] < minCosto) {
                    minCosto = costoMinimo[j];
                    actual = j;
                }
            }
            if (actual == -1) break;
            visitado[actual] = true;

            for (PathDTO path : paths) {
                if (path.getSource_id() == estaciones.get(actual) || path.getDestination_id() == estaciones.get(actual)) {
                    long vecinoId = (path.getSource_id() == estaciones.get(actual)) ? path.getDestination_id() : path.getSource_id();
                    int vecinoIndex = estaciones.indexOf(vecinoId);
                    double nuevoCosto = costoMinimo[actual] + path.getCost();

                    if (nuevoCosto < costoMinimo[vecinoIndex]) {
                        costoMinimo[vecinoIndex] = nuevoCosto;
                        estacionPrevia[vecinoIndex] = estaciones.get(actual);
                    }
                }
            }
        }

        List<Long> camino = new ArrayList<>();
        for (long step = destinationId; step != sourceId && estacionPrevia[estaciones.indexOf(step)] != null; step = estacionPrevia[estaciones.indexOf(step)]) {
            camino.add(0, step);
        }
        if (!camino.isEmpty() || sourceId == destinationId) camino.add(0, sourceId);

        // Crear la respuesta de destino utilizando el camino y el costo
        DestinationsResponse response = new DestinationsResponse();
        response.setPath(camino);
        response.setCost( costoMinimo[estaciones.indexOf(destinationId)] );

        // Devolver una lista con la instancia de DestinationsResponse
        return Collections.singletonList(response);
    }



}
