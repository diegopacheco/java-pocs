package com.github.diegopacheco.sandboxspring.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CleanTests {

    @Autowired
    private DirtyCalculator calculator;

    @Test
    public void testSumPositives(){
        assertEquals(0, calculator.getResult());
        assertEquals(0, calculator.getVa());
        assertEquals(0, calculator.getVb());

        calculator.setVa(10);
        calculator.setVb(10);
        calculator.sum();

        assertEquals(20, calculator.getResult());
        assertEquals(10, calculator.getVa());
        assertEquals(10, calculator.getVb());
    }

    @Test
    public void testSumNegatives(){
        assertEquals(0, calculator.getResult());
        assertEquals(0, calculator.getVa());
        assertEquals(0, calculator.getVb());

        calculator.setVa(-10);
        calculator.setVb(-5);
        calculator.sum();

        assertEquals(-15, calculator.getResult());
        assertEquals(-10, calculator.getVa());
        assertEquals(-5, calculator.getVb());
    }

}
