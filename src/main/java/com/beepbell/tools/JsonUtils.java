package com.beepbell.tools;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static String asJsonString(Object o) {
        if (o == null) return null;
        try {
            return OBJECT_MAPPER.writeValueAsString(o);
        } catch (Exception e) {
            throw new JsonException("Serialization failure", e);
        }
    }

    public static <T> T asObject(String json, Class<T> cl) {
        if (json == null) return null;
        try {
            return OBJECT_MAPPER.readValue(json, cl);
        } catch (Exception e) {
            throw new JsonException("Deserialization failure", e);
        }
    }

    public static String readValue(String json, String prop) {
        if (json == null || prop == null) return null;
        String[] props = prop.split("\\.");
        String path = "/" + String.join("/", props);
        try {
            String val = OBJECT_MAPPER.readTree(json).at(path).toString();
            return val.startsWith("\"") && val.endsWith("\"") ?
                    val.substring(1, val.length() - 1) : val;
        } catch (Exception e) {
            throw new JsonException("Invalid json " + json);
        }
    }

    private JsonUtils() {}
}