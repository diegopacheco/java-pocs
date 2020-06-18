package com.github.diegopacheco.serdebenchs;

import com.github.diegopacheco.serdebenchs.base64.Person;
import com.github.diegopacheco.serdebenchs.base64.SerdeService;
import com.github.diegopacheco.serdebenchs.base64.SerdeServiceV2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class SerdeBenchmarks {

    private static Person person;
    private static SerdeService base64SerdeV1;
    private static SerdeServiceV2 base64SerdeV2;
    private static byte[] bytesPersonV1;
    private static byte[] bytesPersonV2;

    @BeforeAll
    public static void setupBase64(){
        base64SerdeV1 = new SerdeService();
        base64SerdeV2 = new SerdeServiceV2();
        person = new Person();
        person.setId(UUID.randomUUID().toString());
        person.setName("Diego Pacheco");
        person.setEmail("diego.pacheco.it@gmail.com");
        bytesPersonV1 = base64SerdeV1.serialize(person);
        bytesPersonV2 = base64SerdeV2.serialize(person);
    }

    @Test
    public void base64V1Serialize(){
        base64SerdeV1.serialize(person);
    }

    @Test
    public void base64V1Deserialize(){
        base64SerdeV1.deserialize(bytesPersonV1);
    }

    @Test
    public void base64V2Serialize(){
        base64SerdeV2.serialize(person);
    }

    @Test
    public void base64V2Deserialize(){
        base64SerdeV2.deserialize(bytesPersonV2);
    }

}
