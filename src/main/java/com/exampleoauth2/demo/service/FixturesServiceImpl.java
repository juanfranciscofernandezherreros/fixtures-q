package com.exampleoauth2.demo.service;

import com.exampleoauth2.demo.domain.FixturesDomainService;
import com.exampleoauth2.demo.dto.FixturesDTO;
import com.exampleoauth2.demo.mapper.FixturesMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class FixturesServiceImpl implements FixtureService {

    @Autowired
    private FixturesDomainService fixturesDomainService;
    @Autowired
    private FixturesMapper fixturesMapper;
    
    @Override
    public List<FixturesDTO> saveAll(List<FixturesDTO> fixturesDTOList) {
        return fixturesDomainService.saveAll(fixturesMapper.mapListToDAO(fixturesDTOList));
    }

    @Override
    public void deleteByIds(List<String> matchIds) {
        fixturesDomainService.deleteByIds(matchIds);
    }

    @Override
    public List<FixturesDTO> updateAll(List<FixturesDTO> fixturesList) {
        return fixturesDomainService.updateAll(fixturesMapper.mapListToDAO(fixturesList));
    }

    @Override
    public FixturesDTO findMatchByMatchId(String matchId) {
        return fixturesDomainService.findById(matchId);
    }

    @Override
    public Page<FixturesDTO> findAllByDynamicCriteria(Map<String, String> queryParams,int page, int size) {
        return fixturesDomainService.findAllByDynamicCriteria(queryParams,page,size);
    }

    @Override
    public List<FixturesDTO> getFixturesForToday() {
        return fixturesDomainService.getFixturesForToday();
    }

    @Override
    public List<FixturesDTO> getFixturesForSpecificDates(List<LocalDate> dates) {
        return fixturesDomainService.getFixturesForSpecificDates(dates);
    }


}
