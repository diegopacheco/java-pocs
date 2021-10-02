package com.github.diegopacheco.functional.inter.test;

import com.github.diegopacheco.functional.inter.Generator;
import com.github.diegopacheco.functional.inter.Generators;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GeneratorsTest {

    @Test
    public void testDummyStringGenerator(){
        Generator<String> gen = Generators.dummyStringGenerator();
        String result = gen.generate(10);
        assertNotNull(result);
        assertEquals(10,result.length());
        System.out.println(result);
    }

    @Test
    public void testDummyBooleanGenerator(){
        Generator<Boolean> gen = Generators.booleanGenerator();
        Boolean result = gen.generate(0);
        assertNotNull(result);
        System.out.println(result);
    }

}
