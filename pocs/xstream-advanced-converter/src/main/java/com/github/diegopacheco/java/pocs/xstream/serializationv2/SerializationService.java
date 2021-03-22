package com.github.diegopacheco.java.pocs.xstream.serializationv2;

public interface SerializationService {
    <T> T deserialize(String xml,Class pojoClass);
    <T> String serialize(T pojo);
}