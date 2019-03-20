package com.jaoropeza.albo.library.service;

import com.jaoropeza.albo.library.domain.Characters;
import com.jaoropeza.albo.library.domain.CharactersDTO;
import com.jaoropeza.albo.library.repository.CharactersRepository;
import com.jaoropeza.albo.library.service.mapper.CharactersMapper;
import com.jaoropeza.albo.library.service.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharactersService {

    private final CharactersRepository charactersRepository;
    private final CharactersMapper mapper;

    @Autowired
    public CharactersService(CharactersRepository charactersRepository, CharactersMapper mapper) {
        this.charactersRepository = charactersRepository;
        this.mapper = mapper;
    }

    public CharactersDTO getCharacters(final String character) {
        final Characters characters = charactersRepository.findById(character).orElse(null);
        final CharactersDTO charactersDTO = mapper.charactersToCharactersDto(characters);
        if (characters != null) {
            charactersDTO.setLastSync("Fecha de la última sincronización en: " + Utils.formatInstant(characters.getLastSync()));
        }
        return charactersDTO;
    }
}
