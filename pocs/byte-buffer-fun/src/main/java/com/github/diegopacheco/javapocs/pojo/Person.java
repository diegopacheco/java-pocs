package com.github.diegopacheco.javapocs.pojo;

import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;

public class Person {

    private Integer id;
    private String name;
    private byte[] address;

    public Person() {
        super();
    }

    public Person(Integer id, String name, byte[] address) {
        this.id = id;
        this.name = name.substring(0, 5);
        this.address = address;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name.substring(0, 5);
    }

    public byte[] getAddress() {
        return this.address;
    }

    public void setAddress(byte[] address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name) && Arrays.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name);
        result = 31 * result + Arrays.hashCode(address);
        return result;
    }

    @Override
    public String toString() {
        return "Person{"
                + "id=" + id + ", "
                + "name='" + name + "', "
                + "address=" + address + "', "
                + "address=" + utf8String(address) +
                "}";
    }

    public static int getObjectSize(Person p){
        int size =  Integer.BYTES + p.name.length() + p.address.length;
        return size;
    }

    public static int getB64SizeNoPadding(Person p){
        double doubleSize = 1.33*Person.getObjectSize(p);
        return (int)Math.ceil(doubleSize);
    }

    public static String toSerialization(Person p){
        ByteBuffer byteBuffer = ByteBuffer.allocate(getObjectSize(p));
        byteBuffer.putInt(p.getId().byteValue());
        byteBuffer.put(p.getName().getBytes(StandardCharsets.UTF_8));
        byteBuffer.put(p.getAddress());

        StringBuffer sb = new StringBuffer();
        byte[] b64 = encode(byteBuffer.array());
        sb.append(utf8String(b64));
        return sb.toString();
    }

    public static Person fromSerialization(String serialization){
        Person p = new Person();
        byte[] rawData = decode(serialization.getBytes(StandardCharsets.UTF_8));

        byte[] slice = Arrays.copyOfRange(rawData, 0, Integer.BYTES);
        p.setId( ByteBuffer.wrap(slice).getInt() );

        slice = Arrays.copyOfRange(rawData, Integer.BYTES, Integer.BYTES+5);
        p.setName(utf8String(slice));

        slice = Arrays.copyOfRange(rawData, Integer.BYTES+5, rawData.length);
        p.setAddress(slice);

        return p;
    }

    private static byte[] encode(byte[] src){
        try{
            return Base64.getEncoder().encode(src);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    private static byte[] decode(byte[] src){
        try{
            return Base64.getDecoder().decode(src);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    private static String utf8String(byte[] rawData){
        try{
            return new String(rawData,StandardCharsets.UTF_8);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}