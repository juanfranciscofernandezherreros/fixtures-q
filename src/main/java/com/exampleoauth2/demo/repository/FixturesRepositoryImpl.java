package com.exampleoauth2.demo.repository;

import com.exampleoauth2.demo.dao.FixturesDAO;
import com.exampleoauth2.demo.dto.FixturesDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Repository
public class FixturesRepositoryImpl {
    private final MongoTemplate mongoTemplate;
    public FixturesRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Page<FixturesDAO> findAllByDynamicCriteriaWithPagination(Map<String, String> dynamicCriteria, int page, int size) {
        Query query = buildQuery(dynamicCriteria);
        long count = mongoTemplate.count(query, FixturesDAO.class);
        query.with(PageRequest.of(page, size));
        List<FixturesDAO> resultList = mongoTemplate.find(query, FixturesDAO.class);
        return new PageImpl<>(resultList, PageRequest.of(page, size), count);
    }

    private Query buildQuery(Map<String, String> dynamicCriteria) {
        Query query = new Query();
        // Verificar si hay dos entradas en el HashMap
        if (dynamicCriteria.containsKey("homeTeam") && dynamicCriteria.containsKey("awayTeam")) {
            // Obtener los dos valores del Map
            Iterator<String> iterator = dynamicCriteria.values().iterator();
            String teamName1 = iterator.next();
            String teamName2 = iterator.next();
            if (teamName1.equals(teamName2)) {
                query.addCriteria(new Criteria().orOperator(
                        Criteria.where("homeTeam").is(teamName1),
                        Criteria.where("awayTeam").is(teamName2)
                ));
            } else {
                query.addCriteria(new Criteria().andOperator(
                        Criteria.where("homeTeam").is(teamName1),
                        Criteria.where("awayTeam").is(teamName2)
                ));
            }
        }

        // Verificar si "country" está presente y agregar la condición correspondiente
        if (dynamicCriteria.containsKey("country")) {
            query.addCriteria(Criteria.where("country").is(dynamicCriteria.get("country")));
        }

        // Verificar si "league" está presente y agregar la condición correspondiente
        if (dynamicCriteria.containsKey("league")) {
            query.addCriteria(Criteria.where("league").is(dynamicCriteria.get("league")));
        }

        return query;
    }

}
