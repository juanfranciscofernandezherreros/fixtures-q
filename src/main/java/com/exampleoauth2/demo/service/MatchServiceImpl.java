package com.exampleoauth2.demo.service;

import com.exampleoauth2.demo.domain.MatchsDomainService;
import com.exampleoauth2.demo.dto.MatchsDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class MatchServiceImpl implements MatchService{

    @Autowired
    private MatchsDomainService matchsDomainService;
    
    @Override
    public void saveAll(MatchsDTO[] yourInputObject) {
        List<MatchsDTO> matchsDTOList = new ArrayList<>(Arrays.asList(yourInputObject));
        matchsDomainService.saveAll(matchsDTOList);
    }

}
