package com.jaoropeza.albo.library.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.Set;

public class ColaboratorsDTO {
    @JsonProperty("colorist")
    private Set<String> colorist;
    @JsonProperty("editors")
    private Set<String> editors;
    @JsonProperty("last_sync")
    private String lastSync;
    @JsonProperty("writers")
    private Set<String> writers;

    public ColaboratorsDTO() {
    }

    public Set<String> getColorist() {
        return colorist;
    }

    public void setColorist(Set<String> colorist) {
        this.colorist = colorist;
    }

    public Set<String> getEditors() {
        return editors;
    }

    public void setEditors(Set<String> editors) {
        this.editors = editors;
    }

    public String getLastSync() {
        return lastSync;
    }

    public void setLastSync(String lastSync) {
        this.lastSync = lastSync;
    }

    public Set<String> getWriters() {
        return writers;
    }

    public void setWriters(Set<String> writers) {
        this.writers = writers;
    }

    @Override
    public String toString() {
        return "Colaborators{" +
            "lastSync=" + lastSync +
            ", editors=" + editors +
            ", writers=" + writers +
            ", colorist=" + colorist +
            '}';
    }
}
