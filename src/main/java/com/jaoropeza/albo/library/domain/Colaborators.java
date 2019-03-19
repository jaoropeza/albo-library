package com.jaoropeza.albo.library.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;
import java.util.Set;

@Document(collection = "collaborators")
public class Colaborators {
    @JsonProperty("colorist")
    @Field("colorist")
    private Set<String> colorist;
    @JsonProperty("editors")
    @Field("editors")
    private Set<String> editors;
    @JsonProperty("last_sync")
    @Field("last_sync")
    private Instant lastSync;
    @JsonProperty("writers")
    @Field("writers")
    private Set<String> writers;

    public Instant getLastSync() {
        return lastSync;
    }

    public void setLastSync(Instant lastSync) {
        this.lastSync = lastSync;
    }

    public Set<String> getEditors() {
        return editors;
    }

    public void setEditors(Set<String> editors) {
        this.editors = editors;
    }

    public Set<String> getWriters() {
        return writers;
    }

    public void setWriters(Set<String> writers) {
        this.writers = writers;
    }

    public Set<String> getColorist() {
        return colorist;
    }

    public void setColorist(Set<String> colorist) {
        this.colorist = colorist;
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
