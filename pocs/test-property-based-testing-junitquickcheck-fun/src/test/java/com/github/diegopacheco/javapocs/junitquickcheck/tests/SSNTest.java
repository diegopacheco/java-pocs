package com.github.diegopacheco.javapocs.junitquickcheck.tests;


import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;
import com.github.diegopacheco.javapocs.junitquickcheck.tests.Structured.Matching;

import static org.junit.Assert.*;

@RunWith(JUnitQuickcheck.class)
public class SSNTest {
    @Property
    public void wellFormedSSN(
            @From(Structured.class)
            @Matching("\\d{3}-\\d{2}-\\d{4}") String ssn) {

        String[] pieces = ssn.split("-");
        assertEquals(3, pieces.length);
        for (String each : pieces) {
            for (int i = 0; i < each.length(); ++i)
                assertTrue(Character.isDigit(each.charAt(i)));
        }
    }
}
