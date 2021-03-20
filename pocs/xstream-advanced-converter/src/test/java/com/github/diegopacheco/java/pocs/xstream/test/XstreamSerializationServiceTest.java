package com.github.diegopacheco.java.pocs.xstream.test;

import com.github.diegopacheco.java.pocs.xstream.pojos.ContactItem;
import com.github.diegopacheco.java.pocs.xstream.pojos.ContactRoot;
import com.github.diegopacheco.java.pocs.xstream.pojos.Contacts;
import com.github.diegopacheco.java.pocs.xstream.serialization.SerializationService;
import com.github.diegopacheco.java.pocs.xstream.serialization.XStreamSerializationService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class XstreamSerializationServiceTest {

    @Test
    public void testComplexXMLDeserialize(){
        String xml = "<contacts>" +
                "<ID>1</ID>" +
                "<Name>Diego</Name>" +
                "<Active>True</Active>" +
                "<Email>diego@diego.com</Email>" +
                "<SpokenLanguages>Portuguese</SpokenLanguages>" +
                "<SpokenLanguages>English</SpokenLanguages>" +
                "<ID>2</ID>" +
                "<Name>Gandalf</Name>" +
                "<Active>True</Active>" +
                "<Email>gan@white.com</Email>" +
                "<SpokenLanguages>Catness</SpokenLanguages>" +
                "<SpokenLanguages>Portuguese</SpokenLanguages>" +
                "<ID>3</ID>" +
                "<Name>Melina</Name>" +
                "<Email>mel@mel.com</Email>" +
                "<SpokenLanguages>Catness</SpokenLanguages>" +
                "<SpokenLanguages>Portuguese</SpokenLanguages>" +
                "</contacts>";
        SerializationService serialization = new XStreamSerializationService();
        Contacts contacts = serialization.deserialize(xml);
        assertNotNull(contacts);
        System.out.println(contacts);

        String xmlAgain = serialization.serialize(contacts);
        assertNotNull(xmlAgain);
        System.out.println(xmlAgain);
    }

    @Test
    public void testPreProcess(){

        ContactRoot tempRoot = new ContactRoot();

        List<ContactItem> ContactItems = new ArrayList<>();
        ContactItem tempItem = new ContactItem();
        tempItem.setID(1);
        tempItem.setActive(true);
        tempItem.setEmail("e@e.com");
        tempItem.setName("e");
        tempItem.setSpokenLanguages(Arrays.asList("a","b"));
        ContactItems.add(tempItem);

        tempItem = new ContactItem();
        tempItem.setID(2);
        tempItem.setActive(true);
        tempItem.setEmail("f@f.com");
        tempItem.setName("f");
        tempItem.setSpokenLanguages(Arrays.asList("a","b"));
        ContactItems.add(tempItem);

        tempItem = new ContactItem();
        tempItem.setID(3);
        tempItem.setActive(true);
        tempItem.setEmail("g@g.com");
        tempItem.setName("g");
        tempItem.setSpokenLanguages(Arrays.asList("a","b"));
        ContactItems.add(tempItem);

        tempRoot.setContactItems(ContactItems);

        SerializationService ser = new XStreamSerializationService();
        String tempXml =  ser.serialize(tempRoot);
        System.out.println(tempXml);
        ContactRoot r2 = ser.deserialize(tempXml);
        System.out.println(r2);

        /*
        String xml = "<ContactRoot>" +
                "<ID>1</ID>" +
                "<Name>Diego</Name>" +
                "<Active>True</Active>" +
                "<Email>diego@diego.com</Email>" +
                "<SpokenLanguages>Portuguese</SpokenLanguages>" +
                "<SpokenLanguages>English</SpokenLanguages>" +
                "<ID>2</ID>" +
                "<Name>Gandalf</Name>" +
                "<Active>True</Active>" +
                "<Email>gan@white.com</Email>" +
                "<SpokenLanguages>Catness</SpokenLanguages>" +
                "<SpokenLanguages>Portuguese</SpokenLanguages>" +
                "<ID>3</ID>" +
                "<Name>Melina</Name>" +
                "<Email>mel@mel.com</Email>" +
                "<SpokenLanguages>Catness</SpokenLanguages>" +
                "<SpokenLanguages>Portuguese</SpokenLanguages>" +
                "</ContactRoot>";
        SerializationService serialization = new XStreamSerializationService();
        String preProcessedXML = serialization.preProcess(xml);
        System.out.println(preProcessedXML);
        ContactRoot c = serialization.deserialize(preProcessedXML);
        System.out.println(c);

         */
    }

}
