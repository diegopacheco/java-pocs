package com.github.diegopacheco.scannotations.annotations.core.test;

import com.github.diegopacheco.scannotations.annotations.core.AnnotationsDiscovery;
import com.github.diegopacheco.scannotations.annotations.core.Printable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnnotationsDiscoveryTest {

    @Test
    public void testDiscovery(){
        Set<Object> result = AnnotationsDiscovery.getPrintables();
        System.out.println(result);
        assertEquals(3, result.size());
    }

}
