package com.exampleoauth2.demo.domain;

import com.exampleoauth2.demo.dao.FixturesDAO;
import com.exampleoauth2.demo.dto.FixturesDTO;
import com.exampleoauth2.demo.mapper.FixturesMapper;
import com.exampleoauth2.demo.repository.FixturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FixturesDomainServiceImpl implements FixturesDomainService {

    @Autowired
    private FixturesRepository fixturesRepository;

    @Autowired
    private FixturesMapper fixturesMapper;

    @Override
    public List<FixturesDTO> saveAll(List<FixturesDAO> fixturesDAOList) {
        return fixturesMapper.mapListToDTO(fixturesRepository.saveAll(fixturesDAOList));
    }
    @Override
    public void deleteByIds(List<String> matchIds) {
        fixturesRepository.deleteByMatchIdIn(matchIds);
    }

    @Override
    public List<FixturesDTO> updateAll(List<FixturesDAO> updatedFixturesList) {
        List<FixturesDAO> updatedEntities = fixturesRepository.saveAll(updatedFixturesList);
        return fixturesMapper.mapListToDTO(updatedEntities);
    }

    @Override
    public FixturesDTO findById(String matchId) {
        Optional<FixturesDAO> optionalFixturesDAO = fixturesRepository.findByMatchId(matchId);
        // Check if a match was found
        if (optionalFixturesDAO.isPresent()) {
            // Map the FixturesDAO to a FixturesDTO and return it
            return fixturesMapper.mapToDTO(optionalFixturesDAO.get());
        } else {
            // Return null or throw an exception, depending on your design
            return null;
        }
    }

}
