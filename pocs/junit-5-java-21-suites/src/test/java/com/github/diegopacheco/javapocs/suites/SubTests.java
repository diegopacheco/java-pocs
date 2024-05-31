package com.github.diegopacheco.javapocs.suites;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubTests {

    @Test
    public void testSub(){
        Calculator calc = new Calculator(10,5);
        assertEquals(5,calc.sub());
    }

    @Test
    public void testSubZero(){
        Calculator calc = new Calculator(0,0);
        assertEquals(0,calc.sub());
    }
}
