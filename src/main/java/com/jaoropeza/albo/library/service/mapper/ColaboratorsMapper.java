package com.jaoropeza.albo.library.service.mapper;

import com.jaoropeza.albo.library.domain.Colaborators;
import com.jaoropeza.albo.library.domain.ColaboratorsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ColaboratorsMapper {

    ColaboratorsMapper INSTANCE = Mappers.getMapper(ColaboratorsMapper.class);

    @Mapping(target = "lastSync", source = "lastSync")
    ColaboratorsDTO colaboratorsToColaboratorsDto(Colaborators colaborators);
}
