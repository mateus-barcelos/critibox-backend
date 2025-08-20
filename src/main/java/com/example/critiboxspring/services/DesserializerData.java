package com.example.critiboxspring.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DesserializerData implements IDesserializerData {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T desserializer(String json, Class<T> model) {
        try {
            return mapper.readValue(json, model);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
