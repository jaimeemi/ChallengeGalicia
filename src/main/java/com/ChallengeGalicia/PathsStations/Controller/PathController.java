package com.ChallengeGalicia.PathsStations.Controller;

import com.ChallengeGalicia.PathsStations.Objects.Request.PathRequest;
import com.ChallengeGalicia.PathsStations.Objects.Response.PathResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/path")
//        consumes = "application/json",
//        produces = "application/json")
public interface PathController {

    @PutMapping("/{path_id}")
    ResponseEntity<PathResponse> putPath(
            @PathVariable("path_id") Long pathId,
            @Valid @RequestBody PathRequest pathRequest
    ) throws RuntimeException;

    @GetMapping("/")
    ResponseEntity<List<PathResponse>> getPath() throws RuntimeException;

}
