package com.jaoropeza.albo.library.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;
import java.util.List;

@Document("characters")
public class Characters {
    @Field("characters")
    private List<CharactersSummary> characters;
    @Id
    private String id;
    @Field("last_sync")
    private Instant lastSync;

    public Characters() {
    }

    public List<CharactersSummary> getCharacters() {
        return characters;
    }

    public void setCharacters(List<CharactersSummary> characters) {
        this.characters = characters;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getLastSync() {
        return lastSync;
    }

    public void setLastSync(Instant lastSync) {
        this.lastSync = lastSync;
    }
}
