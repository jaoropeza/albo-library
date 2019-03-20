package com.jaoropeza.albo.library.web.rest;

import com.jaoropeza.albo.library.domain.Characters;
import com.jaoropeza.albo.library.domain.CharactersDTO;
import com.jaoropeza.albo.library.service.CharactersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterResource {

    private final CharactersService charactersService;
    private Logger log = LoggerFactory.getLogger(CharacterResource.class);

    @Autowired
    public CharacterResource(CharactersService charactersService) {
        this.charactersService = charactersService;
    }

    @GetMapping("/marvel/characters/{character}")
    public ResponseEntity<?> getCharacters(@PathVariable String character) {
        return ResponseEntity.ok(charactersService.getCharacters(character));
    }
}
