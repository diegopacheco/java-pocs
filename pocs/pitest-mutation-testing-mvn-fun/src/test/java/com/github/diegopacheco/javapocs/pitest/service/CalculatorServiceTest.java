package com.github.diegopacheco.javapocs.pitest.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

    @Test
    public void testSum(){
        CalculatorService calc = new CalculatorService();
        assertEquals(6,calc.sum(3D,3D));
    }

    @Test
    public void testMul(){
        CalculatorService calc = new CalculatorService();
        assertEquals(6,calc.mul(2d,3D));
    }

    @Test
    public void testDivide(){
        CalculatorService calc = new CalculatorService();
        assertEquals(2,calc.divide(12D,6D));
    }

    @Test
    public void testSub(){
        CalculatorService calc = new CalculatorService();
        assertEquals(6,calc.sub(12D,6D));
    }

}
