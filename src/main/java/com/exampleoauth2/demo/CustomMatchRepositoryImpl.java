package com.exampleoauth2.demo;

import com.exampleoauth2.demo.dto.MatchsDTO;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Repository
public class CustomMatchRepositoryImpl {

    private final MongoTemplate mongoTemplate;

    public CustomMatchRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<MatchsDTO> findAllByDynamicCriteria(Map<String, String> dynamicCriteria) {
        Query query = buildQuery(dynamicCriteria);
        return mongoTemplate.find(query, MatchsDTO.class);
    }

    private Query buildQuery(Map<String, String> dynamicCriteria) {
        Query query = new Query();

        // Verificar si hay dos entradas en el HashMap
        if (dynamicCriteria.size() == 2 && dynamicCriteria.containsKey("homeTeam") && dynamicCriteria.containsKey("awayTeam")) {
            // Obtener los dos valores del Map
            Iterator<String> iterator = dynamicCriteria.values().iterator();
            String teamName1 = iterator.next();
            String teamName2 = iterator.next();
            // Agregar la condición de $or: [ { homeTeam: "Valencia" }, { awayTeam: "Valencia" } ]
            if(teamName1.equals(teamName2)){
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

        } else {
            // Agregar la condición de $and: [ { homeTeam: "Valencia" }, { awayTeam: "Granada" } ]
            for (Map.Entry<String, String> entry : dynamicCriteria.entrySet()) {
                String fieldName = entry.getKey();
                String value = entry.getValue();
                Criteria criteria = Criteria.where(fieldName).is(value);
                query.addCriteria(criteria);
            }
        }

        return query;
    }
}
