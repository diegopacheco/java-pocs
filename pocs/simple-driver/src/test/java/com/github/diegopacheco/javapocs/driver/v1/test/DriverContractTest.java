package com.github.diegopacheco.javapocs.driver.v1.test;

import com.github.diegopacheco.javapocs.driver.v1.contract.FactsContract;
import com.github.diegopacheco.javapocs.driver.v1.impl.FactsImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class DriverContractTest {

    @Test
    public void testCallDriver(){
        FactsContract driver = new FactsImpl();
        driver.getFacts().forEach(System.out::println);
        assertNotNull(driver.getFacts());
    }

}
