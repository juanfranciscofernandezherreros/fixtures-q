package com.exampleoauth2.demo.domain;

import com.exampleoauth2.demo.dto.MatchsDTO;

import java.util.List;

public interface MatchsDomainService {
    public void saveAll(List<MatchsDTO> yourOutputObject);
}
