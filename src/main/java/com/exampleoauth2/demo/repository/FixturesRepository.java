package com.exampleoauth2.demo.repository;

import com.exampleoauth2.demo.dao.FixturesDAO;
import com.exampleoauth2.demo.dao.FixturesPKDAO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FixturesRepository extends MongoRepository<FixturesDAO, FixturesPKDAO> {

    List<FixturesDAO> findByEventTimeBetween(LocalDateTime todayStart, LocalDateTime todayEnd);
}