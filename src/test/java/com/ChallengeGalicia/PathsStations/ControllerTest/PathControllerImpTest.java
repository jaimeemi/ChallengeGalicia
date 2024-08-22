package com.ChallengeGalicia.PathsStations.ControllerTest;

import com.ChallengeGalicia.PathsStations.Objects.DTO.PathDTO;
import com.ChallengeGalicia.PathsStations.services.StationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

class PathControllerImpTest {

    @Mock
    StationService stationService;

    List<PathDTO> pathDTOList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        pathDTOList.add( new PathDTO( 10, 11, 50 ));
        pathDTOList.add( new PathDTO( 10, 12, 100 ));
        pathDTOList.add( new PathDTO( 10, 13, 60 ));
        pathDTOList.add( new PathDTO( 13, 12, 20 ));
    }

    @Test
    void putPath() {


    }

    @Test
    void getPath() {
    }
}