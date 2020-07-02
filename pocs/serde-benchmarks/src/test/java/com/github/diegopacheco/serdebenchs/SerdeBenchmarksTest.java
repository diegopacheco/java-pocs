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

        for(int i=0;i<100;i++){
            Person personWarm = new Person();
            personWarm.setId(UUID.randomUUID().toString());
            personWarm.setName("Warm up person");
            personWarm.setEmail("someone.someboddy.what@something.com");

            byte[] bytesPersonWarm   = base64SerdeV1.serialize(personWarm);
            base64SerdeV1.deserialize(bytesPersonWarm);
            byte[] bytesPersonWarmV2 = base64SerdeV2.serialize(personWarm);
            base64SerdeV2.deserialize(bytesPersonWarmV2);
        }

    }

    @BeforeAll
    public static void setupKryo(){
        kryoSerdeService = new KryoSerdeService();
        outKryo = kryoSerdeService.serialize(person);

        for(int i=0;i<100;i++){
            Person personWarm = new Person();
            personWarm.setId(UUID.randomUUID().toString());
            personWarm.setName("Warm up person");
            personWarm.setEmail("someone.someboddy.what@something.com");

            Output bytesPersonWarm   = kryoSerdeService.serialize(personWarm);
            kryoSerdeService.deserialize(bytesPersonWarm);
        }

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

        for(int i=0;i<100;i++){
            PersonProto.Person protoWarm = PersonProto.Person.newBuilder()
                    .setId(UUID.randomUUID().toString())
                    .setEmail("someone.someboddy.what@something.com")
                    .setName("Warm up person")
                    .build();

            ByteArrayOutputStream bytesPersonWarm   = protoSerdeService.serialize(protoWarm);
            protoSerdeService.deserialize(bytesPersonWarm);
        }
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

        for(int i=0;i<100;i++){
            PersonIdentifier piWarm = PersonIdentifier.newBuilder()
                    .setId(UUID.randomUUID().toString())
                    .setName("Warm up person")
                    .setEmail("someone.someboddy.what@something.com")
                    .build();
            AvroHttpRequest avroReqWarm = AvroHttpRequest.newBuilder()
                    .setPersonIdentifier(pi)
                    .build();

            byte[] bytesPersonWarm   = avroSerdeServie.serialize(avroReqWarm);
            avroSerdeServie.deserialize(bytesPersonWarm);
        }
    }

    @BeforeAll
    public static void setupMsgPack(){
        msgPackSerdeService = new MessagePackSerdeService();
        outMsgPack = msgPackSerdeService.serialize(person);

        for(int i=0;i<100;i++){
            Person personWarm = new Person();
            personWarm.setId(UUID.randomUUID().toString());
            personWarm.setName("Warm up person");
            personWarm.setEmail("someone.someboddy.what@something.com");

            byte[] bytesPersonWarm   = msgPackSerdeService.serialize(personWarm);
            msgPackSerdeService.deserialize(bytesPersonWarm);
        }
    }

    @BeforeAll
    public static void setupFST(){
        fstSerdeService = new FSTSerdeService();
        fstOut = fstSerdeService.serialize(person);

        for(int i=0;i<100;i++){
            Person personWarm = new Person();
            personWarm.setId(UUID.randomUUID().toString());
            personWarm.setName("Warm up person");
            personWarm.setEmail("someone.someboddy.what@something.com");

            byte[] bytesPersonWarm   = fstSerdeService.serialize(personWarm);
            fstSerdeService.deserialize(bytesPersonWarm);
        }
    }

    @BeforeAll
    public static void setupGson(){
        gsonSerdeService = new GsonSerdeService();
        gsonOut = gsonSerdeService.serialize(person);

        for(int i=0;i<100;i++){
            Person personWarm = new Person();
            personWarm.setId(UUID.randomUUID().toString());
            personWarm.setName("Warm up person");
            personWarm.setEmail("someone.someboddy.what@something.com");

            byte[] bytesPersonWarm   = gsonSerdeService.serialize(personWarm);
            gsonSerdeService.deserialize(bytesPersonWarm);
        }
    }

    @BeforeAll
    public static void setupJackson(){
        jacksonSerdeService = new JacksonSerdeService();
        jacksonOut = jacksonSerdeService.serialize(person);

        for(int i=0;i<100;i++){
            Person personWarm = new Person();
            personWarm.setId(UUID.randomUUID().toString());
            personWarm.setName("Warm up person");
            personWarm.setEmail("someone.someboddy.what@something.com");

            byte[] bytesPersonWarm   = jacksonSerdeService.serialize(personWarm);
            jacksonSerdeService.deserialize(bytesPersonWarm);
        }
    }

    @BeforeAll
    public static void setupStdJava(){
        stdJavaSerializationService = new StdJavaSerializationService();
        stdOut = stdJavaSerializationService.serialize(person);

        for(int i=0;i<100;i++){
            Person personWarm = new Person();
            personWarm.setId(UUID.randomUUID().toString());
            personWarm.setName("Warm up person");
            personWarm.setEmail("someone.someboddy.what@something.com");

            byte[] bytesPersonWarm   = stdJavaSerializationService.serialize(personWarm);
            stdJavaSerializationService.deserialize(bytesPersonWarm);
        }
    }

    @BeforeAll
    public static void setupSnappy(){
        snapppySerdeService = new SnappySerdeService();
        snappyOut = snapppySerdeService.serialize(person);

        for(int i=0;i<100;i++){
            Person personWarm = new Person();
            personWarm.setId(UUID.randomUUID().toString());
            personWarm.setName("Warm up person");
            personWarm.setEmail("someone.someboddy.what@something.com");

            byte[] bytesPersonWarm   = snapppySerdeService.serialize(personWarm);
            snapppySerdeService.deserialize(bytesPersonWarm);
        }
    }

    @BeforeAll
    public static void setupLz4(){
        lz4SerdeService = new Lz4SerdeService();
        resultLz4 = lz4SerdeService.serialize(person);

        for(int i=0;i<100;i++){
            Person personWarm = new Person();
            personWarm.setId(UUID.randomUUID().toString());
            personWarm.setName("Warm up person");
            personWarm.setEmail("someone.someboddy.what@something.com");

            Lz4Result bytesPersonWarm   = lz4SerdeService.serialize(personWarm);
            lz4SerdeService.deserialize(bytesPersonWarm);
        }
    }

    @Test
    @Order(1)
    public void base64V1Serialize(){
        long start = System.nanoTime();
        byte[] result = base64SerdeV1.serialize(person);
        long end = System.nanoTime();
        System.out.println("Base64 V1 Serialize: " + (end-start) + " ns - size: " + result.length + " bytes");
    }

    @Test
    @Order(2)
    public void base64V1Deserialize(){
        long start = System.nanoTime();
        base64SerdeV1.deserialize(bytesPersonV1);
        long end = System.nanoTime();
        System.out.println("Base64 V1 Deserialize: " + (end-start) + " ns");
    }

    @Test
    @Order(3)
    public void base64V2Serialize(){
        long start = System.nanoTime();
        byte[] result = base64SerdeV2.serialize(person);
        long end = System.nanoTime();
        System.out.println("Base64 V2 Serialize: " + (end-start) + " ns - size: " + result.length + " bytes");
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
        long start = System.nanoTime();
        Output result = kryoSerdeService.serialize(person);
        long end = System.nanoTime();
        System.out.println("Kryo Serialize: " + (end-start) + " ns - size: " + result.getBuffer().length + " bytes");
    }

    @Test
    @Order(6)
    public void kryoV2Deserialize(){
        long start = System.nanoTime();
        kryoSerdeService.deserialize(outKryo);
        long end = System.nanoTime();
        System.out.println("Kryo Deserialize: " + (end-start) + " ns");
    }

    @Test
    @Order(7)
    public void protobufSerialize(){
        long start = System.nanoTime();
        ByteArrayOutputStream result = protoSerdeService.serialize(personProto);
        long end = System.nanoTime();
        System.out.println("Protobuf Serialize: " + (end-start)+ " ns - size: " + result.toByteArray().length + " bytes");
    }

    @Test
    @Order(8)
    public void protobufDeserialize(){
        long start = System.nanoTime();
        protoSerdeService.deserialize(outProto);
        long end = System.nanoTime();
        System.out.println("Protobuf Deserialize: " + (end-start) + " ns");
    }

    @Test
    @Order(9)
    public void avroSerialize(){
        long start = System.nanoTime();
        byte[] result = avroSerdeServie.serialize(avroReq);
        long end = System.nanoTime();
        System.out.println("Avro Serialize: " + (end-start) + " ms - size: " + result.length + " bytes");
    }

    @Test
    @Order(10)
    public void avroDeserialize(){
        long start = System.nanoTime();
        avroSerdeServie.deserialize(avroOut);
        long end = System.nanoTime();
        System.out.println("Avro Deserialize: " + (end-start) + " ns");
    }

    @Test
    @Order(11)
    public void msgPackSerialize(){
        long start = System.nanoTime();
        byte[] result = msgPackSerdeService.serialize(person);
        long end = System.nanoTime();
        System.out.println("MessagePack Serialize: " + (end-start) + " ns - size: " + result.length + " bytes");
    }

    @Test
    @Order(12)
    public void msgPackDeserialize(){
        long start = System.nanoTime();
        msgPackSerdeService.deserialize(outMsgPack);
        long end = System.nanoTime();
        System.out.println("MessagePack Deserialize: " + (end-start) + " ms");
    }

    @Test
    @Order(13)
    public void fstSerialize(){
        long start = System.nanoTime();
        byte[] result = fstSerdeService.serialize(person);
        long end = System.nanoTime();
        System.out.println("FST Serialize: " + (end-start) + " ns - size: " + result.length + " bytes");
    }

    @Test
    @Order(14)
    public void fstDeserialize(){
        long start = System.nanoTime();
        fstSerdeService.deserialize(fstOut);
        long end = System.nanoTime();
        System.out.println("FST Deserialize: " + (end-start) + " ns");
    }

    @Test
    @Order(15)
    public void jsonGsonSerialize(){
        long start = System.nanoTime();
        byte[] result = gsonSerdeService.serialize(person);
        long end = System.nanoTime();
        System.out.println("Json/GSON Serialize: " + (end-start) + " ns - size: " + result.length + " bytes");
    }

    @Test
    @Order(16)
    public void jsonGsonDeserialize(){
        long start = System.nanoTime();
        gsonSerdeService.deserialize(gsonOut);
        long end = System.nanoTime();
        System.out.println("Json/GSON Deserialize: " + (end-start) + " ns");
    }

    @Test
    @Order(17)
    public void jsonJacksonSerialize(){
        long start = System.nanoTime();
        byte[] result = jacksonSerdeService.serialize(person);
        long end = System.nanoTime();
        System.out.println("Json/Jackson Serialize: " + (end-start) + " ns - size: " + result.length + " bytes");
    }

    @Test
    @Order(18)
    public void jsonJacksonDeserialize(){
        long start = System.nanoTime();
        jacksonSerdeService.deserialize(jacksonOut);
        long end = System.nanoTime();
        System.out.println("Json/Jackson Deserialize: " + (end-start) + " ns");
    }

    @Test
    @Order(19)
    public void stdJavaSerialize(){
        long start = System.nanoTime();
        byte[] result = stdJavaSerializationService.serialize(person);
        long end = System.nanoTime();
        System.out.println("STD Java Serialize: " + (end-start) + " ns - size: " + result.length + " bytes");
    }

    @Test
    @Order(20)
    public void stdJavaDeserialize(){
        long start = System.nanoTime();
        stdJavaSerializationService.deserialize(stdOut);
        long end = System.nanoTime();
        System.out.println("STD Java Deserialize: " + (end-start) + " ns");
    }

    @Test
    @Order(21)
    public void snappySerialize(){
        long start = System.nanoTime();
        byte[] result = snapppySerdeService.serialize(person);
        long end = System.nanoTime();
        System.out.println("Snappy Serialize: " + (end-start) + " ns - size: " + result.length + " bytes");
    }

    @Test
    @Order(22)
    public void snappyDeserialize(){
        long start = System.nanoTime();
        snapppySerdeService.deserialize(snappyOut);
        long end = System.nanoTime();
        System.out.println("Snappy Deserialize: " + (end-start) + " ns");
    }

    @Test
    @Order(23)
    public void lz4Serialize(){
        long start = System.nanoTime();
        Lz4Result result = lz4SerdeService.serialize(person);
        long end = System.nanoTime();
        System.out.println("LZ4 Serialize: " + (end-start) + " ns - size: " + result.getCompressed().length + " bytes");
    }

    @Test
    @Order(24)
    public void lz4Deserialize(){
        long start = System.nanoTime();
        lz4SerdeService.deserialize(resultLz4);
        long end = System.nanoTime();
        System.out.println("LZ4 Deserialize: " + (end-start) + " ns");
    }

}