package com.exampleoauth2.demo.service;

import com.exampleoauth2.demo.dto.FixturesDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface FixtureService {

    List<FixturesDTO> saveAll(List<FixturesDTO> fixturesDTOList);
    void deleteByIds(List<String> matchIds);

    List<FixturesDTO> updateAll(List<FixturesDTO> fixturesList);

    FixturesDTO findMatchByMatchId(String matchId);

    Page<FixturesDTO> findAllByDynamicCriteria(Map<String, String> queryParams, int page, int size);

    public List<FixturesDTO> getFixturesForToday();

    public List<FixturesDTO> getFixturesForSpecificDates(List<LocalDate> dates);

}
