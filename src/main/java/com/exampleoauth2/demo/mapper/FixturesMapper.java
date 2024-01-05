package com.exampleoauth2.demo.mapper;

import com.exampleoauth2.demo.dao.FixturesDAO;
import com.exampleoauth2.demo.dto.FixturesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(componentModel = "spring")
public interface FixturesMapper {

    FixturesMapper INSTANCE = Mappers.getMapper(FixturesMapper.class);

    @Mappings({
            @Mapping(target = "eventTime", expression = "java(mapToString(fixturesDAO.getEventTime()))")
    })
    @Mapping(source = "fixturesPKDAO.matchId", target = "matchId")
    FixturesDTO mapToDTO(FixturesDAO fixturesDAO);
    List<FixturesDTO> mapListToDTO(List<FixturesDAO> fixturesDAOList);

    @Mappings({
            @Mapping(target = "eventTime", expression = "java(mapToInstant(fixturesDTO.getEventTime()))")
    })
    @Mapping(source = "matchId", target = "fixturesPKDAO.matchId")
    FixturesDAO mapToDAO(FixturesDTO fixturesDTO);

    List<FixturesDAO> mapListToDAO(List<FixturesDTO> fixturesDTOList);

    default String mapToString(Instant instant) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(instant.atZone(ZoneId.of("UTC")));
    }



    default Instant mapToInstant(String dateString) {
        // Parsea el String a Instant
        return Instant.parse(dateString);
    }

    default Page<FixturesDTO> mapToPageDTO(Page<FixturesDAO> fixturesDAOPage) {
        List<FixturesDTO> fixturesDTOList = mapListToDTO(fixturesDAOPage.getContent());
        return new PageImpl<>(fixturesDTOList, fixturesDAOPage.getPageable(), fixturesDAOPage.getTotalElements());
    }
}
