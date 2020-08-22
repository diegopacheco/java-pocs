package com.github.diegopacheco.javapocs.mocks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StupidMapTest {

    @Test
    public void whenMockFinal() {
        StupidMap sm = new StupidMap();
        StupidMap mock = mock(StupidMap.class);
        when(mock.anwserOfTheUniverse()).thenReturn(100);

        System.out.println("mock  == " + mock.anwserOfTheUniverse());
        System.out.println("class == " + sm.anwserOfTheUniverse());
        assertNotEquals(mock.anwserOfTheUniverse(), sm.anwserOfTheUniverse());
    }

}