package com.github.diegopacheco.serdebenchs;

import com.esotericsoftware.kryo.io.Output;
import com.github.diegopacheco.protobuf.protos.PersonProto;
import com.github.diegopacheco.serdebenchs.avro.AvroHttpRequest;
import com.github.diegopacheco.serdebenchs.avro.AvroSerdeServie;
import com.github.diegopacheco.serdebenchs.avro.PersonIdentifier;
import com.github.diegopacheco.serdebenchs.fst.FSTSerdeService;
import com.github.diegopacheco.serdebenchs.json.GsonSerdeService;
import com.github.diegopacheco.serdebenchs.json.JacksonSerdeService;
import com.github.diegopacheco.serdebenchs.lz4.Lz4Result;
import com.github.diegopacheco.serdebenchs.lz4.Lz4SerdeService;
import com.github.diegopacheco.serdebenchs.messagepack.MessagePackSerdeService;
import com.github.diegopacheco.serdebenchs.model.Person;
import com.github.diegopacheco.serdebenchs.base64.Base64SerdeService;
import com.github.diegopacheco.serdebenchs.base64.SerdeServiceV2;
import com.github.diegopacheco.serdebenchs.kryo.KryoSerdeService;
import com.github.diegopacheco.serdebenchs.protobuf.ProtobufSerdeService;
import com.github.diegopacheco.serdebenchs.snappy.SnappySerdeService;
import com.github.diegopacheco.serdebenchs.std.StdJavaSerializationService;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.util.UUID;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SerdeBenchmarksTest {

    private static Person person;
    private static Base64SerdeService base64SerdeV1;
    private static SerdeServiceV2 base64SerdeV2;
    private static byte[] bytesPersonV1;
    private static byte[] bytesPersonV2;

    private static KryoSerdeService kryoSerdeService;
    private static Output outKryo;

    private static ProtobufSerdeService protoSerdeService;
    private static PersonProto.Person personProto;
    private static ByteArrayOutputStream outProto;

    private static AvroSerdeServie avroSerdeServie;
    private static AvroHttpRequest avroReq;
    private static byte[] avroOut;

    private static MessagePackSerdeService msgPackSerdeService;
    private static byte[] outMsgPack;

    private static FSTSerdeService fstSerdeService;
    private static byte[] fstOut;

    private static GsonSerdeService gsonSerdeService;
    private static byte[] gsonOut;

    private static JacksonSerdeService jacksonSerdeService;
    private static byte[] jacksonOut;

    private static StdJavaSerializationService stdJavaSerializationService;
    private static byte[] stdOut;

    private static SnappySerdeService snapppySerdeService;
    private static byte[] snappyOut;

    private static Lz4SerdeService lz4SerdeService;
    private static Lz4Result resultLz4;

    @BeforeAll
    public static void setupBase64(){
        base64SerdeV1 = new Base64SerdeService();
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

    @BeforeAll
    public static void setupAvro(){
        avroSerdeServie = new AvroSerdeServie();
        PersonIdentifier pi = PersonIdentifier.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setName("Diego Pacheco")
                .setEmail("diego.pacheco.it@gmail.com")
                .build();
        avroReq = AvroHttpRequest.newBuilder()
                .setPersonIdentifier(pi)
                .build();
        avroOut = avroSerdeServie.serialize(avroReq);
    }

    @BeforeAll
    public static void setupMsgPack(){
        msgPackSerdeService = new MessagePackSerdeService();
        outMsgPack = msgPackSerdeService.serialize(person);
    }

    @BeforeAll
    public static void setupFST(){
        fstSerdeService = new FSTSerdeService();
        fstOut = fstSerdeService.serialize(person);
    }

    @BeforeAll
    public static void setupGson(){
        gsonSerdeService = new GsonSerdeService();
        gsonOut = gsonSerdeService.serialize(person);
    }

    @BeforeAll
    public static void setupJackson(){
        jacksonSerdeService = new JacksonSerdeService();
        jacksonOut = jacksonSerdeService.serialize(person);
    }

    @BeforeAll
    public static void setupStdJava(){
        stdJavaSerializationService = new StdJavaSerializationService();
        stdOut = stdJavaSerializationService.serialize(person);
    }

    @BeforeAll
    public static void setupSnappy(){
        snapppySerdeService = new SnappySerdeService();
        snappyOut = snapppySerdeService.serialize(person);
    }

    @BeforeAll
    public static void setupLz4(){
        lz4SerdeService = new Lz4SerdeService();
        resultLz4 = lz4SerdeService.serialize(person);
    }

    @Test
    @Order(1)
    public void base64V1Serialize(){
        long start = System.currentTimeMillis();
        byte[] result = base64SerdeV1.serialize(person);
        long end = System.currentTimeMillis();
        System.out.println("Base64 V1 Serialize: " + (end-start) + " ms - size: " + result.length + " bytes");
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
        byte[] result = base64SerdeV2.serialize(person);
        long end = System.currentTimeMillis();
        System.out.println("Base64 V2 Serialize: " + (end-start) + " ms - size: " + result.length + " bytes");
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
        Output result = kryoSerdeService.serialize(person);
        long end = System.currentTimeMillis();
        System.out.println("Kryo Serialize: " + (end-start) + " ms - size: " + result.getBuffer().length + " bytes");
    }

    @Test
    @Order(6)
    public void kryoV2Deserialize(){
        long start = System.currentTimeMillis();
        kryoSerdeService.deserialize(outKryo);
        long end = System.currentTimeMillis();
        System.out.println("Kryo Deserialize: " + (end-start) + " ms");
    }

    @Test
    @Order(7)
    public void protobufSerialize(){
        long start = System.currentTimeMillis();
        ByteArrayOutputStream result = protoSerdeService.serialize(personProto);
        long end = System.currentTimeMillis();
        System.out.println("Protobuf Serialize: " + (end-start)+ " ms - size: " + result.toByteArray().length + " bytes");
    }

    @Test
    @Order(8)
    public void protobufDeserialize(){
        long start = System.currentTimeMillis();
        protoSerdeService.deserialize(outProto);
        long end = System.currentTimeMillis();
        System.out.println("Protobuf Deserialize: " + (end-start) + " ms");
    }

    @Test
    @Order(9)
    public void avroSerialize(){
        long start = System.currentTimeMillis();
        byte[] result = avroSerdeServie.serialize(avroReq);
        long end = System.currentTimeMillis();
        System.out.println("Avro Serialize: " + (end-start) + " ms - size: " + result.length + " bytes");
    }

    @Test
    @Order(10)
    public void avroDeserialize(){
        long start = System.currentTimeMillis();
        avroSerdeServie.deserialize(avroOut);
        long end = System.currentTimeMillis();
        System.out.println("Avro Deserialize: " + (end-start) + " ms");
    }

    @Test
    @Order(11)
    public void msgPackSerialize(){
        long start = System.currentTimeMillis();
        byte[] result = msgPackSerdeService.serialize(person);
        long end = System.currentTimeMillis();
        System.out.println("MessagePack Serialize: " + (end-start) + " ms - size: " + result.length + " bytes");
    }

    @Test
    @Order(12)
    public void msgPackDeserialize(){
        long start = System.currentTimeMillis();
        msgPackSerdeService.deserialize(outMsgPack);
        long end = System.currentTimeMillis();
        System.out.println("MessagePack Deserialize: " + (end-start) + " ms");
    }

    @Test
    @Order(13)
    public void fstSerialize(){
        long start = System.currentTimeMillis();
        byte[] result = fstSerdeService.serialize(person);
        long end = System.currentTimeMillis();
        System.out.println("FST Serialize: " + (end-start) + " ms - size: " + result.length + " bytes");
    }

    @Test
    @Order(14)
    public void fstDeserialize(){
        long start = System.currentTimeMillis();
        fstSerdeService.deserialize(fstOut);
        long end = System.currentTimeMillis();
        System.out.println("FST Deserialize: " + (end-start) + " ms");
    }

    @Test
    @Order(15)
    public void jsonGsonSerialize(){
        long start = System.currentTimeMillis();
        byte[] result = gsonSerdeService.serialize(person);
        long end = System.currentTimeMillis();
        System.out.println("Json/GSON Serialize: " + (end-start) + " ms - size: " + result.length + " bytes");
    }

    @Test
    @Order(16)
    public void jsonGsonDeserialize(){
        long start = System.currentTimeMillis();
        gsonSerdeService.deserialize(gsonOut);
        long end = System.currentTimeMillis();
        System.out.println("Json/GSON Deserialize: " + (end-start) + " ms");
    }

    @Test
    @Order(17)
    public void jsonJacksonSerialize(){
        long start = System.currentTimeMillis();
        byte[] result = jacksonSerdeService.serialize(person);
        long end = System.currentTimeMillis();
        System.out.println("Json/Jackson Serialize: " + (end-start) + " ms - size: " + result.length + " bytes");
    }

    @Test
    @Order(18)
    public void jsonJacksonDeserialize(){
        long start = System.currentTimeMillis();
        jacksonSerdeService.deserialize(jacksonOut);
        long end = System.currentTimeMillis();
        System.out.println("Json/Jackson Deserialize: " + (end-start) + " ms");
    }

    @Test
    @Order(19)
    public void stdJavaSerialize(){
        long start = System.currentTimeMillis();
        byte[] result = stdJavaSerializationService.serialize(person);
        long end = System.currentTimeMillis();
        System.out.println("STD Java Serialize: " + (end-start) + " ms - size: " + result.length + " bytes");
    }

    @Test
    @Order(20)
    public void stdJavaDeserialize(){
        long start = System.currentTimeMillis();
        stdJavaSerializationService.deserialize(stdOut);
        long end = System.currentTimeMillis();
        System.out.println("STD Java Deserialize: " + (end-start) + " ms");
    }

    @Test
    @Order(21)
    public void snappySerialize(){
        long start = System.currentTimeMillis();
        byte[] result = snapppySerdeService.serialize(person);
        long end = System.currentTimeMillis();
        System.out.println("Snappy Serialize: " + (end-start) + " ms - size: " + result.length + " bytes");
    }

    @Test
    @Order(22)
    public void snappyDeserialize(){
        long start = System.currentTimeMillis();
        snapppySerdeService.deserialize(snappyOut);
        long end = System.currentTimeMillis();
        System.out.println("Snappy Deserialize: " + (end-start) + " ms");
    }

    @Test
    @Order(23)
    public void lz4Serialize(){
        long start = System.currentTimeMillis();
        Lz4Result result = lz4SerdeService.serialize(person);
        long end = System.currentTimeMillis();
        System.out.println("LZ4 Serialize: " + (end-start) + " ms - size: " + result.getCompressed().length + " bytes");
    }

    @Test
    @Order(24)
    public void lz4Deserialize(){
        long start = System.currentTimeMillis();
        lz4SerdeService.deserialize(resultLz4);
        long end = System.currentTimeMillis();
        System.out.println("LZ4 Deserialize: " + (end-start) + " ms");
    }

}