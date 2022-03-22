package com.github.diegopacheco.junit5.testing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class MonthsTest {

    @ParameterizedTest
    @EnumSource(Months.class)
    void testAll(Months month) {
        int monthNumber = month.getValue();
        assertTrue(monthNumber >= 1 && monthNumber <= 12);
    }

}
