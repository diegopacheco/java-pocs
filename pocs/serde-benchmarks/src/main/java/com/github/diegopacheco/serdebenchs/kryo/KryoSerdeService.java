package com.github.diegopacheco.serdebenchs.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.github.diegopacheco.serdebenchs.SerdeService;
import com.github.diegopacheco.serdebenchs.model.Person;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class KryoSerdeService implements SerdeService<Person,Output> {

    Kryo kryo = new Kryo();

    @Override
    public Output serialize(Person p){
        Output output = new Output(new ByteArrayOutputStream());
        kryo.writeObject(output, p);
        output.close();
        return output;
    }

    @Override
    public Person deserialize(Output out){
        Input input = new Input(new ByteArrayInputStream(out.getBuffer()));
        Person p = kryo.readObject(input, Person.class);
        input.close();
        return p;
    }

}
