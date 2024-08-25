package com.ChallengeGalicia.PathsStations.ServicesTest;


import com.ChallengeGalicia.PathsStations.Objects.DTO.PathDTO;
import com.ChallengeGalicia.PathsStations.Objects.Request.PathRequest;
import com.ChallengeGalicia.PathsStations.Objects.Response.PathResponse;
import com.ChallengeGalicia.PathsStations.services.ServicePathImp.PathServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PathServiceTest {

    @InjectMocks
    private PathServiceImp pathServiceImp;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Prueba Grabar Path OK")
    void savePath_OK() {
        PathRequest request = new PathRequest(1L, 2L, 5.0);

        boolean result = pathServiceImp.savePath(request);

        assertTrue(result);
        assertEquals(1, pathServiceImp.getPaths().size());
    }

    @Test
    @DisplayName("Prueba Falla Grabar Path")
    void savePath_FailTest() {
        assertThrows(NullPointerException.class, () -> { pathServiceImp.savePath(null); });
    }

    @Test
    @DisplayName("Prueba Falla Grabar Path")
    void obtenerPaths_OK() {
        PathRequest request1 = new PathRequest(1L, 2L, 5.0);
        PathRequest request2 = new PathRequest(2L, 3L, 10.0);

        pathServiceImp.savePath(request1);
        pathServiceImp.savePath(request2);

        List<PathResponse> paths = pathServiceImp.getPaths();

        assertEquals(2, paths.size());
        assertEquals(2L, paths.get(1).getId());
    }
}
