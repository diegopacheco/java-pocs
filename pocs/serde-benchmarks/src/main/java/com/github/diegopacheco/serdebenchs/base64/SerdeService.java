package com.github.diegopacheco.serdebenchs.base64;

import java.util.Base64;

public class SerdeService {

    public byte[] serialize(Person p){
        try{
            StringBuilder sb = new StringBuilder();
            sb.append(encodeBase64(p.getId())).append(",")
                    .append(encodeBase64(p.getName())).append(",")
                    .append(encodeBase64(p.getEmail()));
            return sb.toString().getBytes("UTF-8");
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public Person deserialize(byte[] data){
        try{
            Person p = new Person();
            String[] rawData = new String(data,"UTF-8").split(",");
            p.setId(decodeBase64(rawData[0]));
            p.setName(decodeBase64(rawData[1]));
            p.setEmail(decodeBase64(rawData[2]));
            return p;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    private String encodeBase64(String data){
        try{
            return new String(Base64.getEncoder().encode(data.getBytes("UTF-8")),"UTF-8");
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    private String decodeBase64(String data){
        try{
            return new String(Base64.getDecoder().decode(data.getBytes("UTF-8")),"UTF-8");
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
