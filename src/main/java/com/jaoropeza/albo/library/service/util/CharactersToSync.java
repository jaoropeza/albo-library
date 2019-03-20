package com.jaoropeza.albo.library.service.util;

public enum CharactersToSync {
    IRON_MAN(1009368),
    CAPTAIN_AMERICA(1009220);

    private final int id;

    CharactersToSync(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
