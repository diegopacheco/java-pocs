package com.github.diegopacheco.java.pocs.xstream.pojos;

import com.github.diegopacheco.java.pocs.xstream.processor.XmlProcessor;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XStreamAlias("ContactRoot")
public class ContactRoot implements XmlProcessor {

    @XStreamImplicit
    List<ContactItem> ContactItems = new ArrayList<>();

    public ContactRoot() {}

    public ContactRoot(List<ContactItem> ContactItems) {
        this.ContactItems = ContactItems;
    }

    public List<ContactItem> getContactItems() {
        return ContactItems;
    }
    public void setContactItems(List<ContactItem> contactItems) {
        ContactItems = contactItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactRoot that = (ContactRoot) o;
        return Objects.equals(ContactItems, that.ContactItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ContactItems);
    }

    @Override
    public String toString() {
        return "ContactRoot{" +
                "ContactItems=" + ContactItems +
                '}';
    }

    @Override
    public String preDeserialize(String xml) {
        xml = xml.replaceAll("<ID>","</ContactItem>\n<ContactItem><ID>");
        xml = xml.replaceAll("</ContactRoot>","</ContactItem>\n</ContactRoot>");
        xml = xml.replaceAll("<ContactRoot>\n" +
                "    </ContactItem>","<ContactRoot>\n");
        xml = xml.replaceAll("<ContactRoot>\n" +
                "  \n" +
                "    </ContactItem>","<ContactRoot>");
        return xml;
    }

    @Override
    public String postSerialize(String xml) {
        xml = xml.replaceAll("<ContactItem>","");
        xml = xml.replaceAll("</ContactItem>","");
        return xml;
    }

}
