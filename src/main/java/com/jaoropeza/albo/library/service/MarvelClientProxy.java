package com.jaoropeza.albo.library.service;

import com.jaoropeza.albo.library.domain.marvel.CharacterDataWrapper;
import com.jaoropeza.albo.library.domain.marvel.ComicDataWrapper;
import com.jaoropeza.albo.library.service.util.Utils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Interface para comunicarse con la API de Marvel
 * <p>
 * Todos los Métodos reciben al menos un Mapa de la forma:
 * <code>
 * Map&lt;String, String&gt:
 * <code/>
 * Con al menos tres elementos:
 * <ul>
 * <li>ts</li>
 * <li>apikey</li>
 * <li>hash</li>
 * <ul>
 * <p>
 * Véase método {@link Utils#getApiParameters()}
 *
 * @see com.jaoropeza.albo.library.service.util.Utils
 */
@FeignClient(
    name = "MarvelAPI",
    url = "https://gateway.marvel.com:443/v1/public"
)
public interface MarvelClientProxy {

    @RequestMapping(method = RequestMethod.GET, value = "/characters")
    CharacterDataWrapper getCharacters(@RequestParam Map<String, String> key);

    @RequestMapping(method = RequestMethod.GET, value = "/characters/{characterId}")
    CharacterDataWrapper getCharactersById(@RequestParam Map<String, String> key, @PathVariable String characterId);

    @RequestMapping(method = RequestMethod.GET, value = "/comics")
    ComicDataWrapper getComics(@RequestParam Map<String, String> parameters);
}
