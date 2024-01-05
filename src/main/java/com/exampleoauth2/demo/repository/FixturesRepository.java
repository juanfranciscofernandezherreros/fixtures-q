package com.exampleoauth2.demo.repository;

import com.exampleoauth2.demo.dao.FixturesDAO;
import com.exampleoauth2.demo.dto.FixturesDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface FixturesRepository extends MongoRepository<FixturesDAO, String> {

    void deleteByMatchIdIn(List<String> matchIds);
    @Query("{'matchId': { $in: ?0 }}")
    List<FixturesDAO> findAllByMatchIdIn(List<String> matchIds);

    Optional<FixturesDAO> findByMatchId(String matchId);

    List<FixturesDAO> findByEventTimeBetween(LocalDateTime todayStart, LocalDateTime todayEnd);
}