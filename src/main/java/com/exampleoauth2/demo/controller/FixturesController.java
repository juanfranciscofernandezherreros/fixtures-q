package com.exampleoauth2.demo.controller;

import com.exampleoauth2.demo.dto.FixturesDTO;
import com.exampleoauth2.demo.exception.MyEntityNotFoundException;
import com.exampleoauth2.demo.repository.FixturesRepositoryImpl;
import com.exampleoauth2.demo.service.FixtureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/fixtures")
public class FixturesController {

    @Autowired
    private FixtureService fixtureService;

    @GetMapping
    public ResponseEntity<List<FixturesDTO>> getFixtures(@RequestParam(required = false) List<String> dates,
                                                         @RequestParam Map<String, String> params) {
        if (dates != null && !dates.isEmpty()) {
            List<LocalDate> dateObjects = dates.stream()
                    .map(LocalDate::parse)
                    .collect(Collectors.toList());
            List<FixturesDTO> fixtures = fixtureService.getFixturesForSpecificDates(dateObjects);
            return new ResponseEntity<>(fixtures, HttpStatus.OK);
        } else if (params.containsKey("today")) {
            List<FixturesDTO> fixtures = fixtureService.getFixturesForToday();
            return new ResponseEntity<>(fixtures, HttpStatus.OK);
        } else if (params.containsKey("tomorrow")) {
            List<FixturesDTO> fixtures = fixtureService.getFixturesForTomorrow();
            return new ResponseEntity<>(fixtures, HttpStatus.OK);
        } else {
            Page<FixturesDTO> fixtures = fixtureService.findAllByDynamicCriteria(params, 0, 60);
            return new ResponseEntity<>(fixtures.getContent(), HttpStatus.OK);
        }
    }

    @GetMapping("{matchId}")
    public ResponseEntity<FixturesDTO> findById(@PathVariable("matchId") String matchId) {
        try {
            FixturesDTO fixture = fixtureService.findMatchByMatchId(matchId);
            return new ResponseEntity<>(fixture, HttpStatus.OK);
        } catch (MyEntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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