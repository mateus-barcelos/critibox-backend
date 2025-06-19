package com.example.screenmatchspring.services;

public interface IDesserializerData {
    <T> T desserializer(String json, Class<T> model);
}
