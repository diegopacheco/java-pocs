package com.github.diegopacheco.design.patterns._extra.tolerant_reader;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class PersonSerializer {

    // Tolerant Reader
    public static PersonV1 readV1(String filename){
        try {
            Map<String, String> map = null;
            try (FileInputStream fileIn = new FileInputStream(filename);
                 ObjectInputStream objIn = new ObjectInputStream(fileIn)) {
                map = (Map<String, String>) objIn.readObject();
            }
            return new PersonV1(map.get("name"), map.get("email"));
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeV1(PersonV1 personV1, String filename){
        try {
            Map<String, String> map = new HashMap<>();
            map.put("name", personV1.getName());
            map.put("email", personV1.getEmail());
            try (FileOutputStream fileOut = new FileOutputStream(filename);
                 ObjectOutputStream objOut = new ObjectOutputStream(fileOut)) {
                objOut.writeObject(map);
            }
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeV2(PersonV2 personV2, String filename){
        try {
            Map<String, String> map = new HashMap<>();
            map.put("name", personV2.getName());
            map.put("email", personV2.getEmail());
            map.put("sex", personV2.getSex());
            map.put("id", personV2.getId().toString());
            try (FileOutputStream fileOut = new FileOutputStream(filename);
                 ObjectOutputStream objOut = new ObjectOutputStream(fileOut)) {
                 objOut.writeObject(map);
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
