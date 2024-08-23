package com.github.diegopacheco.sandboxspring.test.driver;

import com.github.diegopacheco.sandboxspring.drivers.CatFactsDriver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CatFactsDriverTest {

    @Autowired
    private CatFactsDriver catFactsDriver;

    @Test
    public void testGetFact(){
        String fact = catFactsDriver.getFact();
        assertNotNull(fact);
        System.out.println(fact);
    }
}
