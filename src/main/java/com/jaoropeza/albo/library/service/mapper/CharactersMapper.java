package com.jaoropeza.albo.library.service.mapper;

import com.jaoropeza.albo.library.domain.Characters;
import com.jaoropeza.albo.library.domain.CharactersDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CharactersMapper {

    CharactersMapper INSTANCE = Mappers.getMapper(CharactersMapper.class);

    @Mapping(target = "lastSync", source = "lastSync")
    CharactersDTO charactersToCharactersDto(Characters characters);

}
