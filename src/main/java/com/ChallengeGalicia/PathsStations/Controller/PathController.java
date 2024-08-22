package com.ChallengeGalicia.PathsStations.Controller;

import com.ChallengeGalicia.PathsStations.Objects.Request.PathRequest;
import com.ChallengeGalicia.PathsStations.Objects.Response.PathResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/path",
        consumes = "application/json",
        produces = "application/json")
public interface PathController {

    @PutMapping("/{path_id}")
    ResponseEntity<PathResponse> putPath(
            @PathVariable("path_id") String pathId,
            @Valid @RequestBody PathRequest pathRequest//Uso anotacion para validar el Cuerpo
    ) throws RuntimeException;

}
