package com.github.diegopacheco.hamcrest.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CollectionMatchers {
    @Test
    public void emptyListTest() {
        List<String> emptyList = new ArrayList<>();
        assertThat(emptyList, empty());
    }

    @Test
    public void listSizeTest() {
        List<String> hamcrestMatchers = Arrays.asList("collections", "java", "hamcrest", "junit5","good");
        assertThat(hamcrestMatchers, hasSize(5));
    }

    @Test
    public void containsInOrderTest() {
        List<String> hamcrestMatchers = Arrays.asList("first", "second", "third", "forth");
        assertThat(hamcrestMatchers, containsInAnyOrder("first", "second", "third", "forth"));
    }

    @Test
    public void hasOneItemOnTheArray() {
        String[] hamcrestMatchers = { "apple", "bananas", "orka", "black beans" };
        assertThat(hamcrestMatchers, hasItemInArray("black beans"));
    }

}
