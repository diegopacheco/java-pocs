package com.github.diegopacheco.java.pocs.xstream.converter;

import com.github.diegopacheco.java.pocs.xstream.pojos.Contact;
import com.github.diegopacheco.java.pocs.xstream.pojos.Contacts;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PojoToListConverter implements Converter {

    private List<String> canConvertClass;

    public PojoToListConverter() {
        this.canConvertClass = Arrays.asList(Contacts.class.getSimpleName());
    }

    @Override
    public void marshal(Object o, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        System.out.println("here");
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext ctx) {
        Contacts c = new Contacts();
        List<Contact> contacts = new ArrayList<>();
        reader.moveDown();

        Contact contact = new Contact();
        String field = reader.getNodeName();
        String value = reader.getValue();
        writeToPojo(contact,"ID",reader,Integer.class);
        reader.moveUp();

        reader.moveDown();
        field = reader.getNodeName();
        value = reader.getValue();
        writeToPojo(contact,"Name",reader,String.class);
        reader.moveUp();

        reader.moveDown();
        field = reader.getNodeName();
        value = reader.getValue();
        writeToPojo(contact,"Active",reader,Boolean.class);
        reader.moveUp();

        reader.moveDown();
        field = reader.getNodeName();
        value = reader.getValue();
        writeToPojo(contact,"Email",reader,String.class);
        reader.moveUp();

        contacts.add(contact);

        c.setContacts(contacts);
        return c;
    }

    private void writeToPojo(Object pojo, String field, HierarchicalStreamReader reader, Class classType) {
        try {
            Method setter = pojo.getClass().getDeclaredMethod("set" + field, classType);
            Object value = reader.getValue();
            switch (classType.getSimpleName()) {
                case "String":
                    if (null == value) {
                        setter.invoke(pojo, "");
                    } else {
                        setter.invoke(pojo, value);
                    }
                    break;
                case "Integer":
                    if (null == value) {
                        setter.invoke(pojo, 0);
                    } else {
                        setter.invoke(pojo, Integer.parseInt(value.toString()));
                    }
                    break;
                case "Boolean":
                    if (null == value) {
                        setter.invoke(pojo, true);
                    } else {
                        setter.invoke(pojo, Boolean.parseBoolean(value.toString()));
                    }
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean canConvert(Class aClass) {
        return canConvertClass.contains(aClass.getSimpleName());
    }

}