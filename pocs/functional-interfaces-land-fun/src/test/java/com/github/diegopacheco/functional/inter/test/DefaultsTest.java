package com.github.diegopacheco.functional.inter.test;

import com.github.diegopacheco.functional.inter.Defaults;
import org.junit.jupiter.api.Test;
import java.util.function.IntConsumer;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DefaultsTest {

    @Test
    public void testForeach(){
        IntConsumer consumer = (int i) -> {
            System.out.println("got " + i);
        };
        Defaults.foreach(consumer);
        Defaults.foreach( (int i) -> assertTrue(i==8080 || i==8883 || i==9090) );
    }

}
