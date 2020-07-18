package com.github.diegopacheco.javapocs.jquik.test;

import static org.assertj.core.api.Assertions.*;
import net.jqwik.api.*;
import org.assertj.core.data.*;

class ExampleBasedTests {

    @Example
    void squareRootOf16is4() {
        assertThat(Math.sqrt(16)).isCloseTo(4.0, Offset.offset(0.01));
    }

    @Example
    boolean add1plu3is4() {
        return (1 + 3) == 4;
    }
}