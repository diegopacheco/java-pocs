package com.github.diegopacheco.hamcrest.test;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class StringMatcherTest {
    @Test
    public void equalsIgnoreCaseTest() {
        String a = "bonus";
        String b = "BONUS";
        assertThat(a, equalToIgnoringCase(b));
    }

    @Test
    public void emptyOrNullTest() {
        String str = null;
        assertThat(str, isEmptyOrNullString());
    }

    @Test
    public void emptyOrNullTest2() {
        String str = "";
        assertThat(str, isEmptyOrNullString());
    }

    @Test
    public void endsWithTest() {
        String str1 = "calligraphy";
        String str2 = "phy";
        assertThat(str1, endsWith(str2));
    }
}
