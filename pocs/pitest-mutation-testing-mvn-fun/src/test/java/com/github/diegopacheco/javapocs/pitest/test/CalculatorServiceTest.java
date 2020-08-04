package com.github.diegopacheco.javapocs.pitest.test;

import com.github.diegopacheco.javapocs.pitest.service.CalculatorService;
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
        Double a = 0D;
        Double b = 1D;
        assertThrows(
                IllegalArgumentException.class,() -> {
                    calc.divide(a,b);
                }
        );
    }

    @Test
    public void testDivNull(){
        CalculatorService calc = new CalculatorService();
        Double a = null;
        Double b = null;
        assertThrows(
                NullPointerException.class,() -> {
                    calc.divide(a,b);
                }
        );
    }

    @Test
    public void testPlusNull(){
        CalculatorService calc = new CalculatorService();
        Double a = null;
        Double b = null;
        assertThrows(
                NullPointerException.class,() -> {
                    calc.mul(a,b);
                }
        );
    }

    @Test
    public void testSumNull(){
        CalculatorService calc = new CalculatorService();
        Double a = null;
        Double b = null;
        assertThrows(
                NullPointerException.class,() -> {
                    calc.sum(a,b);
                }
        );
    }

    @Test
    public void testSubNull(){
        CalculatorService calc = new CalculatorService();
        Double a = null;
        Double b = null;
        assertThrows(
                NullPointerException.class,() -> {
                    calc.sub(a,b);
                }
        );
    }

}
