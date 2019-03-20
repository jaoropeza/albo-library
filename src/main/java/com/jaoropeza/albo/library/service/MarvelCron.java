package com.jaoropeza.albo.library.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MarvelCron {

    private final Logger log = LoggerFactory.getLogger(MarvelCron.class);

    private final MarvelService marvelService;

    @Autowired
    public MarvelCron(MarvelService marvelService) {
        this.marvelService = marvelService;
    }

    /**
     * Tarea programada que mantiene actualizados los registros en BD de la biblioteca
     */
    @Scheduled(cron = "0 0 0 * * *")
    public void syncMarvel() {
        log.info("Synchronization process started");
        marvelService.syncLibrary();
        log.info("Synchronization process ended");
    }
}
