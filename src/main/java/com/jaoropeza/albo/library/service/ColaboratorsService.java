package com.jaoropeza.albo.library.service;

import com.jaoropeza.albo.library.domain.Colaborators;
import com.jaoropeza.albo.library.domain.ColaboratorsDTO;
import com.jaoropeza.albo.library.repository.ColaboratorsRepository;
import com.jaoropeza.albo.library.service.mapper.ColaboratorsMapper;
import com.jaoropeza.albo.library.service.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColaboratorsService {

    private final ColaboratorsRepository colaboratorsRepository;
    private final ColaboratorsMapper mapper;

    @Autowired
    public ColaboratorsService(ColaboratorsRepository colaboratorsRepository, ColaboratorsMapper mapper) {
        this.colaboratorsRepository = colaboratorsRepository;
        this.mapper = mapper;
    }

    public ColaboratorsDTO getCharacters(final String character) {
        final Colaborators colaborators = colaboratorsRepository.findById(character).orElse(null);
        final ColaboratorsDTO colaboratorsDTO = mapper.colaboratorsToColaboratorsDto(colaborators);
        if (colaborators != null) {
            colaboratorsDTO.setLastSync("Fecha de la última sincronización en: " + Utils.formatInstant(colaborators.getLastSync()));
        }
        return colaboratorsDTO;
    }
}
