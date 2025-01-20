package com.github.diegopacheco.sandboxspring.driver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnonymizingCatalogTest {

    @Test
    public void testGetInstance(){
        AnonymizingCatalog instance = AnonymizingCatalog.getInstance();
        assert(instance!=null);
    }

    @Test
    public void testIsAnonymizingField() {
        AnonymizingCatalog catalog = AnonymizingCatalog.getInstance();
        assertFalse(catalog.isAnonymizingField("person", "email"));
    }

    @Test
    public void testApplyStrategy() {
        AnonymizingCatalog catalog = AnonymizingCatalog.getInstance();
        Anonymizing anonymizing = new Anonymizing() {
            @Override
            public Class<? extends java.lang.annotation.Annotation> annotationType() {
                return Anonymizing.class;
            }

            @Override
            public String dbFieldName() {
                return "first_name";
            }

            @Override
            public AnonymizingStrategy strategy() {
                return AnonymizingStrategy.STAR;
            }
        };
        catalog.addAnonymizingField("person", "first_name", anonymizing);
        String result = catalog.applyStrategy("John", "person", "first_name");
        assertEquals("****", result);
    }

    @Test
    public void testAddAnonymizingField() {
        AnonymizingCatalog catalog = AnonymizingCatalog.getInstance();
        Anonymizing anonymizing = new Anonymizing() {
            @Override
            public Class<? extends java.lang.annotation.Annotation> annotationType() {
                return Anonymizing.class;
            }

            @Override
            public String dbFieldName() {
                return "first_name";
            }

            @Override
            public AnonymizingStrategy strategy() {
                return AnonymizingStrategy.STAR;
            }
        };
        catalog.addAnonymizingField("person", "first_name", anonymizing);
        assertTrue(catalog.isAnonymizingField("person", "first_name"));
    }

}
