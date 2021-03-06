package com.jaoropeza.albo.library.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;
import java.util.Set;

@Document(collection = "colaborators")
public class Colaborators {
    @Field("colorist")
    private Set<String> colorist;
    @Field("editors")
    private Set<String> editors;
    @Id
    private String id;
    @Field("last_sync")
    private Instant lastSync;
    @Field("writers")
    private Set<String> writers;

    public Colaborators() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Instant getLastSync() {
        return lastSync;
    }

    public void setLastSync(Instant lastSync) {
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
