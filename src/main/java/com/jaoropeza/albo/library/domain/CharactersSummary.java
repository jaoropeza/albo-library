package com.jaoropeza.albo.library.domain;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

public class CharactersSummary {
    @Field("characters")
    private String character;
    @Field("comics")
    private List<String> comics;

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public List<String> getComics() {
        return comics;
    }

    public void setComics(List<String> comics) {
        this.comics = comics;
    }
}
