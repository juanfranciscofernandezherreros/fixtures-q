package com.exampleoauth2.demo.domain;

import com.exampleoauth2.demo.dao.FixturesDAO;
import com.exampleoauth2.demo.dto.FixturesDTO;

import java.util.List;

public interface FixturesDomainService {
    List<FixturesDTO> saveAll(List<FixturesDAO> fixturesDAOList);

    void deleteByIds(List<String> matchIds);

    List<FixturesDTO> updateAll(List<FixturesDAO> mapListToDAO);

    FixturesDTO findById(String matchId);
}