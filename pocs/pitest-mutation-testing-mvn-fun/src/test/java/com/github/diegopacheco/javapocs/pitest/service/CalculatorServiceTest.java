package com.github.diegopacheco.javapocs.pitest.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceTest {

    @Test
    public void sumTest(){
        CalculatorService cs = new CalculatorService();
        assertEquals(2D, cs.sum(1D,1D));
    }

    @Test
    public void mulTest(){
        CalculatorService cs = new CalculatorService();
        assertEquals(1D,cs.mul(1D,1D));
    }

    @Test
    public void mulBiggerTest(){
        CalculatorService cs = new CalculatorService();
        assertEquals(500D,cs.mul(5D,100D));
    }

    @Test
    public void subTest(){
        CalculatorService cs = new CalculatorService();
        assertEquals(2D,cs.sub(3D,1D));
    }

    @Test
    public void divTest(){
        CalculatorService cs = new CalculatorService();
        assertEquals(10D,cs.divide(100D,10D));
    }

    @Test
    public void divTestNull(){
        CalculatorService cs = new CalculatorService();
        Double a = null;
        Double b= null;
        assertThrows(NullPointerException.class,() -> cs.divide(a,b)  );
    }

    @Test
    public void subTestZero(){
        CalculatorService cs = new CalculatorService();
        Double a= 0D;
        Double b= 0D;
        assertEquals(0,cs.sub(a,b));
    }

}
