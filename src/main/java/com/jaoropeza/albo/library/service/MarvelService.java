package com.jaoropeza.albo.library.service;

import com.jaoropeza.albo.library.domain.Characters;
import com.jaoropeza.albo.library.domain.CharactersSummary;
import com.jaoropeza.albo.library.domain.Colaborators;
import com.jaoropeza.albo.library.domain.marvel.*;
import com.jaoropeza.albo.library.repository.CharactersRepository;
import com.jaoropeza.albo.library.repository.ColaboratorsRepository;
import com.jaoropeza.albo.library.service.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;

/**
 * Servicio encargado de obtener los datos desde la API de Marvel
 * y almacenarlos en Base de Datos
 */
@Service
public class MarvelService {

    private static final Integer limit = 20;
    private final Logger log = LoggerFactory.getLogger(MarvelService.class);
    private final MarvelClientProxy marvelClientProxy;
    private final ColaboratorsRepository colaboratorsRepository;
    private final CharactersRepository charactersRepository;

    @Autowired
    public MarvelService(MarvelClientProxy marvelClientProxy,
                         ColaboratorsRepository colaboratorsRepository,
                         CharactersRepository charactersRepository) {
        this.marvelClientProxy = marvelClientProxy;
        this.colaboratorsRepository = colaboratorsRepository;
        this.charactersRepository = charactersRepository;
    }

    /**
     * Método encargado de mantener actualizada la biblioteca de Albo.
     */
    public void syncLibrary() {
        for (Map.Entry<String, String> entry : Utils.characters.entrySet()) {
            Instant lastSync = Instant.now();

            Map<String, List<String>> characters = new HashMap<>();

            String character = entry.getKey();
            String id = entry.getValue();

            log.info("Started process sync with Character: {}, ID: {}", character, id);

            Map<String, String> params = Utils.getApiParameters();
            params.put("characters", id);
            params.put("limit", String.valueOf(limit));
            params.put("offset", "0");

            Set<String> colorists = new HashSet<>();
            Set<String> writers = new HashSet<>();
            Set<String> editors = new HashSet<>();

            ComicDataWrapper comics = marvelClientProxy.getComics(params);
            ComicDataContainer data = comics.getData();

            List<Comic> comicsResult = new ArrayList<>(data.getResults());

            int totalPages = data.getTotal() / limit;

            /**
             * Realizamos la llamadas necesarias al API de Marvel
             */
            for (int page = 1; page <= totalPages; page++) {
                params.putAll(Utils.getApiParameters());
                params.put("characters", id);
                params.put("limit", String.valueOf(limit));
                params.put("offset", String.valueOf(page * limit));

                log.info("Request {}", params);
                comics = marvelClientProxy.getComics(params);
                data = comics.getData();

                comicsResult.addAll(data.getResults());
            }

            /**
             * Separamos los datos en "colorist", "writer", "editor".
             */
            for (Comic comic : comicsResult) {
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
                /**
                 * Añadimos el comic al superheroe.
                 */
                for (CharacterSummary characterSummary : comic.getCharacters().getItems()) {
                    String characterName = characterSummary.getName();
                    if (characters.containsKey(characterName)) {
                        List<String> comicsList = characters.get(characterName);
                        comicsList.add(comic.getTitle());
                        characters.put(characterName, comicsList);
                    } else {
                        List<String> list = new ArrayList<>();
                        list.add(comic.getTitle());
                        characters.put(characterName, list);
                    }
                }
            }

            saveColaborators(lastSync, character, colorists, writers, editors);

            saveCharacters(lastSync, character, characters);

            log.info("Ended process sync with Character: {}, ID: {}", character, id);
        }
    }

    /**
     * Guardar Colaborators en Base de Datos
     *
     * @param lastSync
     * @param character
     * @param colorists
     * @param writers
     * @param editors
     */
    private void saveColaborators(Instant lastSync, String character, Set<String> colorists, Set<String> writers, Set<String> editors) {
        Colaborators colaborators = new Colaborators();
        colaborators.setId(character);
        colaborators.setLastSync(lastSync);
        colaborators.setColorist(colorists);
        colaborators.setWriters(writers);
        colaborators.setEditors(editors);
        colaboratorsRepository.save(colaborators);
    }

    /**
     * Guardar Characters en Base de Datos
     *
     * @param lastSync
     * @param character
     * @param characters
     */
    private void saveCharacters(Instant lastSync, String character, Map<String, List<String>> characters) {
        Characters charactersSave = new Characters();
        charactersSave.setId(character);
        charactersSave.setLastSync(lastSync);
        List<CharactersSummary> charactersSummaries = new ArrayList<>();
        for (Map.Entry<String, List<String>> e : characters.entrySet()) {
            String superhero = e.getKey();
            List<String> comicList = e.getValue();
            CharactersSummary charactersSummary = new CharactersSummary();
            charactersSummary.setCharacter(superhero);
            charactersSummary.setComics(comicList);
            charactersSummaries.add(charactersSummary);
        }
        charactersSave.setCharacters(charactersSummaries);

        charactersRepository.save(charactersSave);
    }
}
