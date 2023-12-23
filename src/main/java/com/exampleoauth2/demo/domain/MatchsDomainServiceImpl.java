package com.exampleoauth2.demo.domain;

import com.exampleoauth2.demo.dto.MatchsDTO;
import com.exampleoauth2.demo.output.YourOutputObject;
import com.exampleoauth2.demo.repository.MatchsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchsDomainServiceImpl implements MatchsDomainService{

    @Autowired
    private MatchsRepository matchsRepository;

    @Override
    public void saveAll(List<MatchsDTO> yourOutputObject) {
        matchsRepository.saveAll(yourOutputObject);
    }
}
