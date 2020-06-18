package com.github.diegopacheco.serdebenchs.protobuf;

import com.github.diegopacheco.protobuf.protos.PersonProto;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ProtobufSerdeService {

    public ByteArrayOutputStream serialize(PersonProto.Person  p){
        try{
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            p.writeTo(out);
            return out;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public PersonProto.Person deserialize(ByteArrayOutputStream out){
        try{
            ByteArrayInputStream input = new ByteArrayInputStream(out.toByteArray());
            PersonProto.Person p = PersonProto.Person.newBuilder().mergeFrom(input).build();
            return p;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
