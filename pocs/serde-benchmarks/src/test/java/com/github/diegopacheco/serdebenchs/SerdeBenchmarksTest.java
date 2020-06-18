package com.github.diegopacheco.serdebenchs;

import com.esotericsoftware.kryo.io.Output;
import com.github.diegopacheco.protobuf.protos.PersonProto;
import com.github.diegopacheco.serdebenchs.model.Person;
import com.github.diegopacheco.serdebenchs.base64.SerdeService;
import com.github.diegopacheco.serdebenchs.base64.SerdeServiceV2;
import com.github.diegopacheco.serdebenchs.kryo.KryoSerdeService;
import com.github.diegopacheco.serdebenchs.protobuf.ProtobufSerdeService;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.util.UUID;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SerdeBenchmarksTest {

    private static Person person;
    private static SerdeService base64SerdeV1;
    private static SerdeServiceV2 base64SerdeV2;
    private static byte[] bytesPersonV1;
    private static byte[] bytesPersonV2;

    private static KryoSerdeService kryoSerdeService;
    private static Output outKryo;

    private static ProtobufSerdeService protoSerdeService;
    private static PersonProto.Person personProto;
    private static ByteArrayOutputStream outProto;

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

    @BeforeAll
    public static void setupKryo(){
        kryoSerdeService = new KryoSerdeService();
        outKryo = kryoSerdeService.serialize(person);
    }

    @BeforeAll
    public static void setupProtobuf(){
        protoSerdeService = new ProtobufSerdeService();
        personProto = PersonProto.Person.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setEmail("diego.pacheco.it@gmail.com")
                .setName("Diego Pacheco")
                .build();
        outProto = protoSerdeService.serialize(personProto);
    }

    @Test
    @Order(1)
    public void base64V1Serialize(){
        long start = System.currentTimeMillis();
        base64SerdeV1.serialize(person);
        long end = System.currentTimeMillis();
        System.out.println("Base64 V1 Serialize: " + (end-start) + " ms");
    }

    @Test
    @Order(2)
    public void base64V1Deserialize(){
        long start = System.currentTimeMillis();
        base64SerdeV1.deserialize(bytesPersonV1);
        long end = System.currentTimeMillis();
        System.out.println("Base64 V1 Deserialize: " + (end-start) + " ms");
    }

    @Test
    @Order(3)
    public void base64V2Serialize(){
        long start = System.currentTimeMillis();
        base64SerdeV2.serialize(person);
        long end = System.currentTimeMillis();
        System.out.println("Base64 V2 Serialize: " + (end-start) + " ms");
    }

    @Test
    @Order(4)
    public void base64V2Deserialize(){
        long start = System.currentTimeMillis();
        base64SerdeV2.deserialize(bytesPersonV2);
        long end = System.currentTimeMillis();
        System.out.println("Base64 V2 Deserialize: " + (end-start) + " ms");
    }

    @Test
    @Order(5)
    public void kryoSerialize(){
        long start = System.currentTimeMillis();
        kryoSerdeService.serialize(person);
        long end = System.currentTimeMillis();
        System.out.println("Kryo V2 Serialize: " + (end-start) + " ms");
    }

    @Test
    @Order(6)
    public void kryoV2Deserialize(){
        long start = System.currentTimeMillis();
        kryoSerdeService.deserialize(outKryo);
        long end = System.currentTimeMillis();
        System.out.println("Kryo V2 Deserialize: " + (end-start) + " ms");
    }

    @Test
    @Order(7)
    public void protobufSerialize(){
        long start = System.currentTimeMillis();
        protoSerdeService.serialize(personProto);
        long end = System.currentTimeMillis();
        System.out.println("Protobuf V2 Serialize: " + (end-start) + " ms");
    }

    @Test
    @Order(8)
    public void protobufDeserialize(){
        long start = System.currentTimeMillis();
        protoSerdeService.deserialize(outProto);
        long end = System.currentTimeMillis();
        System.out.println("Protobuf V2 Deserialize: " + (end-start) + " ms");
    }

}
