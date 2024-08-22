package com.ChallengeGalicia.PathsStations.ControllerTest;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ControllerInterfaceTest {

    private final String invalidPathRequest = """
            {
                "id": 1,
                "destination_id": 0,
                "cost": 0
            }
        """;

    private final String invalidStationsRequest = "{ "+"name:"+" "+ "}";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void putStation_Fail() throws Exception {

        String response = mockMvc.perform(put("/path/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidPathRequest))
                .andExpect(status().isBadRequest())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertTrue(response.contains("La Destinacion No puede estar vacia"));
        assertTrue(response.contains("El costo del viaje no puede ser gratuito"));
    }


    @Test
    void getPath_Fail() throws Exception {

        String response = mockMvc.perform(put("/stations/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidStationsRequest))
                .andExpect(status().isBadRequest())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertTrue(response.contains("No es posible que la estacion no posea nombre"));
    }

}
