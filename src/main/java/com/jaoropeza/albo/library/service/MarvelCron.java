package com.jaoropeza.albo.library.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MarvelCron {

    private final Logger log = LoggerFactory.getLogger(MarvelCron.class);

    @Scheduled(cron = "${albo.marvel.sync.cron}")
    public void syncMarvel() {
    }
}
