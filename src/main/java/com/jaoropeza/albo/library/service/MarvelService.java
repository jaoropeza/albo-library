package com.jaoropeza.albo.library.service;

import com.jaoropeza.albo.library.domain.Colaborators;
import com.jaoropeza.albo.library.domain.marvel.Character;
import com.jaoropeza.albo.library.domain.marvel.*;
import com.jaoropeza.albo.library.repository.ColaboratorsRepository;
import com.jaoropeza.albo.library.service.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Servicio encargado de obtener los datos desde la API de Marvel
 */
@Service
public class MarvelService {

//    private final Logger log = LoggerFactory.getLogger(MarvelService.class);

    private final MarvelClientProxy marvelClientProxy;
    private final ColaboratorsRepository colaboratorsRepository;

    @Autowired
    public MarvelService(MarvelClientProxy marvelClientProxy,
                         ColaboratorsRepository colaboratorsRepository) {
        this.marvelClientProxy = marvelClientProxy;
        this.colaboratorsRepository = colaboratorsRepository;
    }

    /**
     * Método encargado de obtener los personajes y transformarlos a un objeto de la clase Colaborators
     *
     * @return
     */
    public List<Character> getCharacters() {
        CharacterDataWrapper characters = marvelClientProxy.getCharacters(Utils.getApiParameters());
        return characters.getData().getResults();
    }

    /**
     * Método encargado de obtener los personajes y transformarlos a un objeto de la clase Characters
     *
     * @return
     */
    public Colaborators getComics() {
        ComicDataWrapper characters = marvelClientProxy.getComics(Utils.getApiParameters());
        final Map<String, String> params = Utils.getApiParameters();
        params.put("characters", "1009368");
        params.put("limit", "100");
        final ComicDataWrapper comics = marvelClientProxy.getComics(params);
        final List<Comic> results = comics.getData().getResults();
        Colaborators colaborators = new Colaborators();
        Set<String> colorists = new HashSet<>();
        Set<String> writers = new HashSet<>();
        Set<String> editors = new HashSet<>();
        colaborators.setLastSync(Instant.now());
        for (Comic comic : results) {
            for (CreatorSummary creator : comic.getCreators().getItems()) {
                switch (creator.getRole()) {
                    case "colorist":
                        colorists.add(creator.getName());
                        break;
                    case "writer":
                        writers.add(creator.getName());
                        break;
                    case "editor":
                        editors.add(creator.getName());
                        break;
                }
            }
        }
        colaborators.setColorist(colorists);
        colaborators.setWriters(writers);
        colaborators.setEditors(editors);
        Colaborators save = colaboratorsRepository.save(colaborators);
        return save;
    }
}
