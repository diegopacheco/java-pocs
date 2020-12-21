package com.github.diegopacheco.java.pocs.spring.testing;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpringReflectionTest {

    @Test
    public void testReflection(){
        Person p = new Person();
        ReflectionTestUtils.setField(p,"name","Diego");
        ReflectionTestUtils.setField(p,"email","mymail@mail.mail");
        assertEquals("Diego",p.getName());
        assertEquals("mymail@mail.mail",p.getEmail());
        System.out.println(p);
    }

}
