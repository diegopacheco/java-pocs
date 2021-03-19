package com.github.diegopacheco.java.pocs.xstream.test;

import com.github.diegopacheco.java.pocs.xstream.pojos.Contacts;
import com.github.diegopacheco.java.pocs.xstream.serialization.SerializationService;
import com.github.diegopacheco.java.pocs.xstream.serialization.XStreamSerializationService;
import org.junit.jupiter.api.Test;
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
                "<Active>True</Active>" +
                "<Email>mel@mel.com</Email>" +
                "<SpokenLanguages>Catness</SpokenLanguages>" +
                "<SpokenLanguages>Portuguese</SpokenLanguages>" +
                "</contacts>";
        SerializationService serialization = new XStreamSerializationService();
        Contacts contacts = serialization.deserialize(xml);
        assertNotNull(contacts);
        System.out.println(contacts);
    }

}
