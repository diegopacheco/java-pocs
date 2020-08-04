package com.github.diegopacheco.javapocs.pitest.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    public void testDivide(){
        CalculatorService calc = new CalculatorService();
        assertEquals(2,calc.divide(12,6));
    }

    @Test
    public void testSub(){
        CalculatorService calc = new CalculatorService();
        assertEquals(6,calc.sub(12,6));
    }

    @Test
    public void testDivZero(){
        CalculatorService calc = new CalculatorService();
        double a = 0D;
        double b = 1D;
        assertThrows(IllegalArgumentException.class,() -> calc.divide(a,b));
    }

}
