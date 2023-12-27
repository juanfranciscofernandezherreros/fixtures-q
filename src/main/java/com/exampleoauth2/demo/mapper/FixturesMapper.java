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
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(componentModel = "spring")
public interface FixturesMapper {

    FixturesMapper INSTANCE = Mappers.getMapper(FixturesMapper.class);

    @Mappings({
            @Mapping(target = "eventTime", expression = "java(mapToString(fixturesDAO.getEventTime()))")
    })
    FixturesDTO mapToDTO(FixturesDAO fixturesDAO);

    List<FixturesDTO> mapListToDTO(List<FixturesDAO> fixturesDAOList);

    @Mappings({
            @Mapping(target = "eventTime", expression = "java(mapToInstant(fixturesDTO.getEventTime()))")
    })
    FixturesDAO mapToDAO(FixturesDTO fixturesDTO);

    List<FixturesDAO> mapListToDAO(List<FixturesDTO> fixturesDTOList);

    default String mapToString(Instant instant) {
        // Formatea el Instant como String
        return DateTimeFormatter.ISO_INSTANT.format(instant);
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
