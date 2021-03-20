package com.github.diegopacheco.java.pocs.xstream.serialization;

import com.github.diegopacheco.java.pocs.xstream.pojos.ContactPre;
import com.github.diegopacheco.java.pocs.xstream.pojos.Contacts2;
import com.github.diegopacheco.java.pocs.xstream.pojos.ListOfContacts;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;
import org.scannotation.AnnotationDB;
import org.scannotation.ClasspathUrlFinder;

import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class XStreamSerializationService implements SerializationService {

    private XStream xStream = new XStream();

    public XStreamSerializationService(){
        xStream.addPermission(NoTypePermission.NONE);
        xStream.addPermission(NullPermission.NULL);
        xStream.addPermission(PrimitiveTypePermission.PRIMITIVES);
        xStream.allowTypeHierarchy(Collection.class);
        xStream.allowTypesByWildcard(new String[] {
                "com.github.diegopacheco.**"
        });
        try {
            URL[] urls = ClasspathUrlFinder.findClassPaths();
            AnnotationDB db = new AnnotationDB();
            db.scanArchives(urls);

            Set<String> alias = db.getAnnotationIndex().get(XStreamAlias.class.getName());
            for (String clazz : alias) {
                xStream.processAnnotations(Class.forName(clazz));
            }

            Set<String> converters =
                    db.getClassIndex().keySet().stream().
                            filter( (String clazz) -> clazz.contains("com.github.diegopacheco") ).
                            filter( (String clazz) -> {
                                try {
                                    return Arrays.stream(Class.forName(clazz).getInterfaces()).
                                            filter( (Class clazz2) -> clazz2==Converter.class ).findFirst().isPresent();
                                } catch (Exception e) {
                                    return false;
                                }
                            }
                            ).collect(Collectors.toSet());
            for (String clazz : converters) {
                xStream.registerConverter( (Converter) Class.forName(clazz).
                            getDeclaredConstructor().newInstance());
            }
            //xStream.ignoreUnknownElements();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> T deserialize(String xml) {
        return (T)xStream.fromXML(xml);
    }

    @Override
    public <T> String serialize(T pojo) {
        return xStream.toXML(pojo);
    }

    @Override
    public String preProcess(String xml) {
        xStream.processAnnotations(Contacts2.class);
        xStream.processAnnotations(ContactPre.class);
        xStream.processAnnotations(ListOfContacts.class);
        //xStream.addImplicitCollection(ListOfContacts.class, "ContactPre",ContactPre.class);

        xml = xml.replaceAll("<Contacts2>","<Contacts2><list>");
        xml = xml.replaceAll("<ID>","<ContactPre/><ContactPre><ID>");
        xml = xml.replaceAll("<Contacts2><list><ContactPre/>","<Contacts2><list>");
        xml = xml.replaceAll("</Contacts2>","<ContactPre/></list></Contacts2>");
        return xml;
    }

    @Override
    public <T> String serializePreProcess(T pojo) {
        return null;
    }


}
