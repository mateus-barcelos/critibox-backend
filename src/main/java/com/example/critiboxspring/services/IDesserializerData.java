package com.example.critiboxspring.services;

public interface IDesserializerData {
    <T> T desserializer(String json, Class<T> model);
}
