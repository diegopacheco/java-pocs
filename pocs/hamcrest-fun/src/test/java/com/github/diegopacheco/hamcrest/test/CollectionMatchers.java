package com.github.diegopacheco.hamcrest.test;

import org.junit.jupiter.api.Test;

import java.util.*;

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
    public void hasOneItemOnTheArrayTest() {
        String[] hamcrestMatchers = { "apple", "bananas", "orka", "black beans" };
        assertThat(hamcrestMatchers, hasItemInArray("black beans"));
    }

    @Test
    public void mapHasKeyTest() {
        Map<String, String> map = new HashMap<>();
        map.put("rs", "porto alegre");
        map.put("sc", "floripa");
        assertThat(map, hasKey("rs"));
    }

    @Test
    public void hasValueTest() {
        Map<String, String> map = new HashMap<>();
        map.put("rs", "porto alegre");
        map.put("sc", "floripa");
        assertThat(map, hasValue("floripa"));
    }

}
