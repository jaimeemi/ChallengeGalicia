package com.ChallengeGalicia.PathsStations.ControllerTest;

import com.ChallengeGalicia.PathsStations.Objects.DTO.StationsDTO;
import com.ChallengeGalicia.PathsStations.services.StationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

class StationControllerImpTest {


    @Mock
    StationService stationService;

    List<StationsDTO> stationsDTOList = null;

    @BeforeEach
    void setUp() {
        stationsDTOList = new ArrayList<>();
        StationsDTO s1 = new StationsDTO("Barcelona");
        StationsDTO s2 = new StationsDTO("Paris");
        StationsDTO s3 = new StationsDTO("Paris");
        StationsDTO s4 = new StationsDTO("Paris");
        stationsDTOList.add(s1);
        stationsDTOList.add(s2);
        stationsDTOList.add(s3);
        stationsDTOList.add(s4);
    }

    @Test
    void putStation() {
    }

    @Test
    void getPath() {
    }
}