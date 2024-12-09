
package com.example.figure.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Vladyslav Gural
 * @version 2024-07-31
 */
public class Util {
    private static final Logger logger = LoggerFactory.getLogger(Util.class);

    private static ObjectMapper mapper = new ObjectMapper().findAndRegisterModules()
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public static String toJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.warn("Utils#toJson failed to make json from object: {}, failed with message: {}",
                    object, e.getMessage(), e);
            return null;
        }
    }

    public static <T> T fromJson(String body, Class<T> c) {
        if (body == null) return null;
        try {
            return mapper.readValue(body, c);
        } catch (JsonProcessingException e) {
            logger.warn("Utils#fromJson failed to make object from json: {}, failed with message: {}",
                    body, e.getMessage(), e);
            return null;
        }
    }
}
