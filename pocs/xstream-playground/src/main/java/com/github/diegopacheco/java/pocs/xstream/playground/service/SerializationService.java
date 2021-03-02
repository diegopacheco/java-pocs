package com.github.diegopacheco.java.pocs.xstream.playground.service;

import com.github.diegopacheco.java.pocs.xstream.playground.pojos.Author;
import com.github.diegopacheco.java.pocs.xstream.playground.pojos.Book;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;
import java.util.Collection;

public class SerializationService<T> {

    private XStream xstream = new XStream();

    public SerializationService(){
        xstream.addPermission(NoTypePermission.NONE);
        xstream.addPermission(NullPermission.NULL);
        xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
        xstream.allowTypeHierarchy(Collection.class);
        xstream.allowTypesByWildcard(new String[] {
                "com.github.diegopacheco.**"
        });
        xstream.alias("Author", Author.class);
        xstream.processAnnotations(Author.class);
        xstream.processAnnotations(Book.class);
    }

    public T deserialize(String xml){
        return (T)xstream.fromXML(xml);
    }

    public String serialize(T obj){
        return xstream.toXML(obj);
    }

}
