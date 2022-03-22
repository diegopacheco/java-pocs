package com.github.diegopacheco.junit5.testing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringsTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "     "})
    void isBlank(String input) {
        assertTrue(Strings.isBlank(input));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void isBlankNull(String input) {
        assertTrue(Strings.isBlank(input));
    }

}
