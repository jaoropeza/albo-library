package com.jaoropeza.albo.library.service.util;

import org.springframework.util.DigestUtils;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * Utilidades
 */
public final class Utils {

    private static final String PRIVATE_KEY = "852437e6e5592218af4c9431dfc085d5b8ea9961";
    private static final String PUBLIC_KEY = "4adcbbb52fbdda57d0aac3faefb3bfdf";

    /**
     * Genera el parámetro <code>hash</code> utilizando la llave pública y privada y un time instant
     * utilizando el algoritmo MD5.
     *
     * @param ts EL time instant
     * @return Regresa el hash resultante.
     */
    public static String md5(final String ts) {
        final String input = ts + PRIVATE_KEY + PUBLIC_KEY;
        return DigestUtils.md5DigestAsHex(input.getBytes());
    }

    /**
     * Crea un mapa con los parárametors necesarios para realizar peticiones
     * al API de Marvel
     *
     * @return Un mapa con los parámetros ts, apikey y hash configurados.
     */
    public static Map<String, String> getApiParameters() {
        Map<String, String> key = new HashMap<>();
        final Long epochSecond = Instant.now().getEpochSecond();
        final String ts = epochSecond.toString();
        final String hash = md5(ts);
        key.put("ts", ts);
        key.put("apikey", PUBLIC_KEY);
        key.put("hash", hash);
        return key;
    }
}
