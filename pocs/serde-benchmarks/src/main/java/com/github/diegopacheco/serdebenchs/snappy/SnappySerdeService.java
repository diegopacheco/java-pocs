package com.github.diegopacheco.serdebenchs.snappy;
import com.github.diegopacheco.serdebenchs.SerdeService;
import com.github.diegopacheco.serdebenchs.model.Person;
import org.xerial.snappy.Snappy;

public class SnappySerdeService implements SerdeService<Person,byte[]> {

    @Override
    public byte[] serialize(Person p){
        try{
            return Snappy.compress(personToString(p).getBytes("UTF-8"));
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Person deserialize(byte[] data){
        try{
            return (Person) fromString(Snappy.uncompress(data));
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    private String personToString(Person p){
        StringBuilder sb = new StringBuilder();
        sb.append(p.getId()).append(",")
           .append(p.getName()).append(",")
           .append(p.getEmail()) ;
        return sb.toString();
    }

    private Person fromString(byte[] source){
        try{
            Person p = new Person();
            String data[] = new String(source,"UTF-8").split(",");
            p.setId(data[0]);
            p.setName(data[1]);
            p.setEmail(data[2]);
            return p;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
