package com.exampleoauth2.demo.domain;

import com.exampleoauth2.demo.dao.FixturesDAO;
import com.exampleoauth2.demo.dto.FixturesDTO;
import com.exampleoauth2.demo.exception.MyEntityNotFoundException;
import com.exampleoauth2.demo.mapper.FixturesMapper;
import com.exampleoauth2.demo.repository.FixturesRepository;
import com.exampleoauth2.demo.repository.FixturesRepositoryImpl;
import lombok.extern.slf4j.Slf4j;  // Import the slf4j annotation
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j  // Add the slf4j annotation
public class FixturesDomainServiceImpl implements FixturesDomainService {

    @Autowired
    private FixturesRepository fixturesRepository;

    @Autowired
    private FixturesRepositoryImpl fixturesRepositoryImpl;

    @Autowired
    private FixturesMapper fixturesMapper;

    @Override
    public List<FixturesDTO> saveAll(List<FixturesDAO> fixturesDAOList) {
        log.info("Saving list of fixtures...");
        return fixturesMapper.mapListToDTO(fixturesRepository.saveAll(fixturesDAOList));
    }

    @Override
    public void deleteByIds(List<String> matchIds) {
        log.info("Deleting fixtures by matchIds: {}", matchIds);
        fixturesRepository.deleteByMatchIdIn(matchIds);
    }

    @Override
    public List<FixturesDTO> updateAll(List<FixturesDAO> updatedFixturesList) {
        log.info("Updating list of fixtures...");
        List<FixturesDAO> updatedEntities = fixturesRepository.saveAll(updatedFixturesList);
        return fixturesMapper.mapListToDTO(updatedEntities);
    }

    @Override
    public FixturesDTO findById(String matchId) {
        log.info("Finding fixture by matchId: {}", matchId);
        Optional<FixturesDAO> optionalFixturesDAO = fixturesRepository.findByMatchId(matchId);
        // Use orElseThrow to throw EntityNotFoundException if the entity is not present
        FixturesDAO fixturesDAO = optionalFixturesDAO.orElseThrow(() ->
                new MyEntityNotFoundException("Fixtures with matchId " + matchId + " not found"));
        // Map the FixturesDAO to a FixturesDTO and return it
        return fixturesMapper.mapToDTO(fixturesDAO);
    }

    @Override
    public Page<FixturesDTO> findAllByDynamicCriteria(Map<String, String> queryParams, int page, int size) {
        log.info("Finding fixtures by dynamic criteria: {}, page: {}, size: {}", queryParams, page, size);
        return fixturesMapper.mapToPageDTO(fixturesRepositoryImpl.findAllByDynamicCriteriaWithPagination(queryParams, page, size));
    }

    @Override
    public List<FixturesDTO> getFixturesForToday() {
        LocalDateTime todayStart = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
        LocalDateTime todayEnd = LocalDateTime.now().withHour(23).withMinute(59).withSecond(59);
        return fixturesMapper.mapListToDTO(fixturesRepository.findByEventTimeBetween(todayStart, todayEnd));
    }

    @Override
    public List<FixturesDTO> getFixturesForTomorrow() {
        LocalDateTime tomorrowStart = LocalDateTime.now().plusDays(1).withHour(0).withMinute(0).withSecond(0);
        LocalDateTime tomorrowEnd = LocalDateTime.now().plusDays(1).withHour(23).withMinute(59).withSecond(59);
        return fixturesMapper.mapListToDTO(fixturesRepository.findByEventTimeBetween(tomorrowStart, tomorrowEnd));
    }


    @Override
    public List<FixturesDTO> getFixturesForSpecificDates(List<LocalDate> dates) {
        List<FixturesDTO> fixtures = new ArrayList<>();
        for (LocalDate date : dates) {
            LocalDateTime startOfDay = date.atStartOfDay();
            LocalDateTime endOfDay = date.atTime(23, 59, 59);
            fixtures.addAll(fixturesMapper.mapListToDTO(fixturesRepository.findByEventTimeBetween(startOfDay, endOfDay)));
        }
        return fixtures;
    }



}
