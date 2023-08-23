package com.github.diegopacheco.hamcrest.test;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class StringMatcherTest {
    @Test
    public void equalsIgnoreCaseTest() {
        String a = "bonus";
        String b = "BONUS";
        assertThat(a, equalToIgnoringCase(b));
    }
}
