package com.tests;

import com.SimpleService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleServiceTest{
    
    @Test
    public void testSimpleBiggerThanZero(){
        SimpleService ss = new SimpleService();
        Integer result = ss.goForIt(1);
        Assertions.assertEquals(2, result);
    }

}