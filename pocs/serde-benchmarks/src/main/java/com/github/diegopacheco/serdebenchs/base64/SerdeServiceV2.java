package com.github.diegopacheco.serdebenchs.base64;

import java.util.Base64;

public class SerdeServiceV2 {

    public byte[] serialize(Person p){
        try{
            StringBuilder sb = new StringBuilder();
            sb.append(p.getId()).append(",")
                    .append(p.getName()).append(",")
                    .append(p.getEmail());
            return encodeBase64(sb.toString()).getBytes("UTF-8");
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public Person deserialize(byte[] data){
        try{
            Person p = new Person();
            String[] rawData = decodeBase64(new String(data,"UTF-8")).split(",");
            p.setId(rawData[0]);
            p.setName(rawData[1]);
            p.setEmail(rawData[2]);
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
