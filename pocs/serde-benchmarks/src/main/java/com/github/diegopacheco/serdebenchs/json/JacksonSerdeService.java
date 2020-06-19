package com.github.diegopacheco.serdebenchs.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.diegopacheco.serdebenchs.model.Person;

public class JacksonSerdeService {

    private static ObjectMapper mapper = new ObjectMapper();

    public byte[] serialize(Person p){
        try{
            return mapper.writeValueAsBytes(p);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public Person deserialize(byte[] data){
        try{
            return mapper.readValue(data,Person.class);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
