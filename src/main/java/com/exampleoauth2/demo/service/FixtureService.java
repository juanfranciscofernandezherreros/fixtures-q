package com.exampleoauth2.demo.service;

import com.exampleoauth2.demo.dto.FixturesDTO;
import com.exampleoauth2.demo.dto.MatchsDTO;

import java.util.List;

public interface FixtureService {

    List<FixturesDTO> saveAll(List<FixturesDTO> fixturesDTOList);
    void deleteByIds(List<String> matchIds);

    List<FixturesDTO> updateAll(List<FixturesDTO> fixturesList);

    FixturesDTO findMatchByMatchId(String matchId);
}
