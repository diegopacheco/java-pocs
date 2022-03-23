package com.github.diegopacheco.java.pocs.reader.test;

import com.github.diegopacheco.java.pocs.annotations.Owner;
import com.github.diegopacheco.java.pocs.catalog.MicroserviceX;
import com.github.diegopacheco.java.pocs.reader.AnnotationReader;
import org.junit.jupiter.api.Test;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ReadAnnotationTest {

    @Test
    public void testReadAnnotation(){
        String value = AnnotationReader.getAnnotationValue(MicroserviceX.class, Owner.class,"email");
        assertEquals("MicroserviceX@dev.com",value);
        System.out.println(value);
    }

    @Test
    public void listAllClasses(){
        Set<Class> clazzes = AnnotationReader.findAllClasses("com.github.diegopacheco.java.pocs.catalog",Owner.class);
        System.out.println(clazzes);
        assertNotNull(clazzes);
    }

}
