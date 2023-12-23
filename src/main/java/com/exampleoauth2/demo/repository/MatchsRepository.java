package com.exampleoauth2.demo.repository;

import com.exampleoauth2.demo.dto.MatchsDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchsRepository extends MongoRepository<MatchsDTO, Long> {

}