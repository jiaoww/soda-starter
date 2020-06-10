package com.sodacar.starter.sms.weimi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Optional;

public class JsonUtils {

    private final static Logger LOGGER = LoggerFactory.getLogger(JsonUtils.class);

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static String toJson(Object value) {

        try {
            return MAPPER.writeValueAsString(value);
        } catch (JsonProcessingException e) {

            LOGGER.error("to json error!", e);
        }
        return null;
    }

    public static <T> T fromJson(Blob blob, TypeReference<T> type) {
        try {
            return MAPPER.readValue(blob.getBinaryStream(), type);
        } catch (IOException | SQLException e) {

            LOGGER.error("from json error!", e);
        }
        return null;
    }

    public static <T> T fromJson(String blob, TypeReference<T> type) {
        try {
            return MAPPER.readValue(blob, type);
        } catch (IOException e) {

            LOGGER.error("from json error!", e);
        }
        return null;
    }

    public static <T> Optional<T> toObject(String json, Class<T> clazz) {

        if (json.equals("")) {
            return Optional.empty();
        }
        try {
            return Optional.of(new ObjectMapper().readValue(json, clazz));
        } catch (Exception e) {
            LOGGER.error("to object error!", e);
        }
        return Optional.empty();
    }
}
