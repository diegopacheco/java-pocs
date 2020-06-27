package com.github.diegopacheco.serdebenchs.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.diegopacheco.serdebenchs.SerdeService;
import com.github.diegopacheco.serdebenchs.model.Person;

public class JacksonSerdeService implements SerdeService<Person,byte[]> {

    private static ObjectMapper mapper = new ObjectMapper();

    @Override
    public byte[] serialize(Person p){
        try{
            return mapper.writeValueAsBytes(p);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Person deserialize(byte[] data){
        try{
            return mapper.readValue(data,Person.class);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
