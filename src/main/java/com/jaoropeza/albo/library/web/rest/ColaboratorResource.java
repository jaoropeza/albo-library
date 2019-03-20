package com.jaoropeza.albo.library.web.rest;

import com.jaoropeza.albo.library.domain.ColaboratorsDTO;
import com.jaoropeza.albo.library.service.ColaboratorsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ColaboratorResource {
    private final ColaboratorsService colaboratorsService;
    private Logger log = LoggerFactory.getLogger(ColaboratorResource.class);

    @Autowired
    public ColaboratorResource(ColaboratorsService colaboratorsService) {
        this.colaboratorsService = colaboratorsService;
    }

    @GetMapping("/marvel/colaborators/{character}")
    public ResponseEntity<?> getColaborators(@PathVariable String character) {
        return ResponseEntity.ok(colaboratorsService.getCharacters(character));
    }
}
