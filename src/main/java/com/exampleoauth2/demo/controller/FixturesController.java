package com.exampleoauth2.demo.controller;

import com.exampleoauth2.demo.dto.FixturesDTO;
import com.exampleoauth2.demo.dto.MatchsDTO;
import com.exampleoauth2.demo.repository.FixturesRepositoryImpl;
import com.exampleoauth2.demo.service.FixtureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/fixtures")
public class FixturesController {

    @Autowired
    private FixturesRepositoryImpl matchRepository;

    @Autowired
    private FixtureService fixtureService;

    @GetMapping
    public ResponseEntity<List<MatchsDTO>> obtenerPartidosPorFechasYEquipos(@RequestParam Map<String, String> params) {
        Map<String, String> queryParams = new HashMap<>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            queryParams.put(entry.getKey(), entry.getValue());
        }
        List<MatchsDTO> partidos = matchRepository.findAllByDynamicCriteria(queryParams);
        return new ResponseEntity<>(partidos, HttpStatus.OK);
    }

    @GetMapping("{matchId}")
    public ResponseEntity<FixturesDTO> findById(@PathVariable("matchId") String matchId) {
        // Implement the logic to fetch a single match by matchId from your service
        FixturesDTO match = fixtureService.findMatchByMatchId(matchId);
        // Check if a match was found
        if (match != null) {
            // Return a successful response with the match
            return new ResponseEntity<>(match, HttpStatus.OK);
        } else {
            // Return a not found response if no match was found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public ResponseEntity<List<FixturesDTO>> saveAll(@RequestBody List<FixturesDTO> fixturesList) {
        List<FixturesDTO> fixturesDTOList = fixtureService.saveAll(fixturesList);
        return new ResponseEntity<List<FixturesDTO>>(fixturesDTOList, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<List<FixturesDTO>> updateAll(@RequestBody List<FixturesDTO> fixturesList) {
        List<FixturesDTO> fixturesDTOList = fixtureService.updateAll(fixturesList);
        return new ResponseEntity<List<FixturesDTO>>(fixturesDTOList, HttpStatus.OK);
    }

    @DeleteMapping("/deleteByIds")
    public void deleteByIds(@RequestBody List<String> matchIds) {
        fixtureService.deleteByIds(matchIds);
    }


}