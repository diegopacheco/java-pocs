package com.github.diegopacheco.sandboxspring.driver;

import org.junit.jupiter.api.Test;

public class AnonymizingCatalogTest {

    @Test
    public void testGetInstance(){
        AnonymizingCatalog instance = AnonymizingCatalog.getInstance();
        assert(instance!=null);
    }

}
