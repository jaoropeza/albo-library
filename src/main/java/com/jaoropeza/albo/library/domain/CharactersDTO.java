package com.jaoropeza.albo.library.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CharactersDTO {
    private List<CharactersSummary> characters;
    @JsonProperty("last_sync")
    private String lastSync;

    public CharactersDTO() {
    }

    public List<CharactersSummary> getCharacters() {
        return characters;
    }

    public void setCharacters(List<CharactersSummary> characters) {
        this.characters = characters;
    }

    public String getLastSync() {
        return lastSync;
    }

    public void setLastSync(String lastSync) {
        this.lastSync = lastSync;
    }
}
