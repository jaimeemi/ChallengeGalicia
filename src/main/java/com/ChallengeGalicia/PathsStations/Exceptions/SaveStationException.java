package com.ChallengeGalicia.PathsStations.Exceptions;

public class SaveStationException extends RuntimeException {

    public SaveStationException(){
        super();
        System.out.println("Error durante el proceso de Guardado de la Estacion");
    }

}
