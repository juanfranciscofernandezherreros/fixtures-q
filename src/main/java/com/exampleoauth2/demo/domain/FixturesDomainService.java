package com.exampleoauth2.demo.domain;

import com.exampleoauth2.demo.dao.FixturesDAO;
import com.exampleoauth2.demo.dto.FixturesDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface FixturesDomainService {
    List<FixturesDTO> saveAll(List<FixturesDAO> fixturesDAOList);

    void deleteByIds(List<String> matchIds);

    List<FixturesDTO> updateAll(List<FixturesDAO> mapListToDAO);

    FixturesDTO findById(String matchId);

    Page<FixturesDTO> findAllByDynamicCriteria(Map<String, String> queryParams, int page, int size);

    public List<FixturesDTO> getFixturesForToday();
    public List<FixturesDTO> getFixturesForSpecificDates(List<LocalDate> dates);
}