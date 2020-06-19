package com.github.diegopacheco.serdebenchs.std;

import com.github.diegopacheco.serdebenchs.model.Person;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StdJavaSerializationService {

    public byte[] serialize(Person p){
        try{
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            ObjectOutputStream writer = new ObjectOutputStream(bytes);
            writer.writeObject(p);
            return bytes.toByteArray();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public Person deserialize(byte[] data){
        try{
            ObjectInputStream reader = new ObjectInputStream(new ByteArrayInputStream(data));
            return (Person)reader.readObject();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
