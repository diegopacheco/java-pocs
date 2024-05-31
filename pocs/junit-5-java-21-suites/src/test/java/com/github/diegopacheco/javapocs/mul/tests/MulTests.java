package com.github.diegopacheco.javapocs.mul.tests;

import com.github.diegopacheco.javapocs.suites.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MulTests {

    @Test
    public void testMul(){
        Calculator calc = new Calculator(10,5);
        assertEquals(50,calc.mul());
    }

    @Test
    public void testMulZero(){
        Calculator calc = new Calculator(0,0);
        assertEquals(0,calc.mul());
    }

}
