package com.github.diegopacheco.java21.futy.service;

import com.github.diegopacheco.java21.futy.pojo.Person;
import org.apache.fury.Fury;
import org.apache.fury.config.Language;

public class SerializationService {

    private Fury fury;

    public SerializationService(){
        fury = Fury.builder()
                .withLanguage(Language.JAVA)
                .withAsyncCompilation(true)
                .build();
        fury.register(Person.class);
    }

    public byte[] serialize(Object obj){
        return fury.serialize(obj);
    }

    public <T> T deserialize(byte[]  obj, Class<T> clazz){
        return (T) fury.deserialize(obj);
    }

}
