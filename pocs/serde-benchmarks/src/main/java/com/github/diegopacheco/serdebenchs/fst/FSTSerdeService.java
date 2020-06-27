package com.github.diegopacheco.serdebenchs.fst;

import com.github.diegopacheco.serdebenchs.SerdeService;
import com.github.diegopacheco.serdebenchs.model.Person;
import org.nustaq.serialization.FSTConfiguration;

public class FSTSerdeService implements SerdeService<Person,byte[]> {

    private static FSTConfiguration conf = FSTConfiguration.createDefaultConfiguration();

    @Override
    public byte[] serialize(Person p){
        try{
            return conf.asByteArray(p);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Person deserialize(byte[] data){
        try{
            return (Person)conf.asObject(data);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
