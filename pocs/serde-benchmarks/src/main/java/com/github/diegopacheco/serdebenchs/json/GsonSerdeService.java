package com.github.diegopacheco.serdebenchs.json;

import com.github.diegopacheco.serdebenchs.model.Person;
import com.google.gson.Gson;

public class GsonSerdeService {

    private static Gson gson = new Gson();

    public byte[] serialize(Person p){
        try{
            return gson.toJson(p).getBytes("UTF-8");
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public Person deserialize(byte[] data){
        try{
            return gson.fromJson(new String(data,"UTF-8"),Person.class);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
