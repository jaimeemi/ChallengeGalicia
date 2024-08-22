package com.ChallengeGalicia.PathsStations.Exceptions;

public class SavePathExpcetion extends RuntimeException {

    public SavePathExpcetion(){
        super();
        System.out.println("Error durante el proceso de Guardado de la Recorrido");
    }
}
