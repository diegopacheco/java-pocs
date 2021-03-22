package com.github.diegopacheco.java.pocs.xstream.serializationv2;

import com.github.diegopacheco.java.pocs.xstream.processor.XmlProcessor;
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
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class XStreamAdvancedSerializationService implements SerializationService {

    private XStream xStream = new XStream();
    private Map<Class,Boolean> cache = new ConcurrentHashMap<>();

    public XStreamAdvancedSerializationService(){
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
                System.out.println("Support for: " + clazz);
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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public <T> T deserialize(String xml,Class pojoClass) {
        try{
            if (hasProcessor(pojoClass)){
                XmlProcessor pojoProcessor = (XmlProcessor)pojoClass.getDeclaredConstructor().newInstance();
                xml = pojoProcessor.preDeserialize(xml);
            }
            T pojo = (T)xStream.fromXML(xml);
            return pojo;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> String serialize(T pojo) {
        try{
            String xml = xStream.toXML(pojo);
            if (hasProcessor(pojo.getClass())){
                XmlProcessor processor = (XmlProcessor) pojo;
                xml = processor.postSerialize(xml);
            }
            return xml;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    private boolean hasProcessor(Class pojoClass){
        try{
            if (cache.containsKey(pojoClass)){
                return  cache.get(pojoClass);
            }
            Class processorClass = Arrays.stream(pojoClass.getInterfaces()).
                    filter( i -> "XmlProcessor".equals(i.getSimpleName()) ).
                    findFirst().orElse(null);
            if (null!=processorClass){
                cache.put(pojoClass,true);
                return true;
            }
            cache.put(pojoClass,false);
            return false;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
