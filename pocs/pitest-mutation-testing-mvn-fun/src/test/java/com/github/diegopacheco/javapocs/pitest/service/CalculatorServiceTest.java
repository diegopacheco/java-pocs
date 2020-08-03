package com.github.diegopacheco.javapocs.pitest.service;

import com.github.diegopacheco.javapocs.pitest.service.CalculatorService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

    @Test
    public void testSum(){
        CalculatorService calc = new CalculatorService();
        assertEquals(6,calc.sum(3,3));
    }

    @Test
    public void testMul(){
        CalculatorService calc = new CalculatorService();
        assertEquals(6,calc.mul(2,3));
    }

    @Test
    public void testSul(){
        CalculatorService calc = new CalculatorService();
        assertEquals(6,calc.sub(12,6));
    }

}
