package com.github.diegopacheco.serdebenchs.messagepack;

import com.github.diegopacheco.serdebenchs.SerdeService;
import com.github.diegopacheco.serdebenchs.model.Person;
import org.msgpack.MessagePack;
import org.msgpack.packer.BufferPacker;
import org.msgpack.unpacker.BufferUnpacker;

public class MessagePackSerdeService implements SerdeService<Person,byte[]> {

    private static MessagePack msgpack = new MessagePack();

    @Override
    public byte[] serialize(Person  p){
        try{
            BufferPacker packer = msgpack.createBufferPacker();
            packer.write(p.getId())
                  .write(p.getName())
                  .write(p.getEmail());
            return packer.toByteArray();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Person deserialize(byte[] data){
        try{
            BufferUnpacker unpacker = msgpack.createBufferUnpacker(data);
            Person p = new Person();
            p.setId(unpacker.readString());
            p.setName(unpacker.readString());
            p.setEmail(unpacker.readString());
            unpacker.close();
            return p;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
