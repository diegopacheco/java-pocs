package com.github.diegopacheco.junit5.features.fun.test;

import com.github.diegopacheco.junit5.features.fun.Doubler;
import org.junit.jupiter.api.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TestFullOfAnnotationTest {

    @BeforeAll
    public static void setup() {
        System.out.println("Doing test setup");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("cleaning up resources...");
    }

    @Test
    @DisplayName("This should look more like BDD style 1 + 2 == 3")
    public void testOnePlusTwo() {
        int result = 1 + 2;
        assertEquals(3, result);
    }

    @Test
    @Disabled
    public void bsTest() {
        System.out.println("I'm disabled!");
    }

    @Test
    void lambdaExpressionsTest() {
        assertTrue(Stream.of(1, 2, 3, 4, 5, 6)
                .mapToInt(i -> i)
                .flatMap(i -> IntStream.of(i * 2))
                .sum() > 20, () -> "Sum should be greater than 20");
    }

    @Test
    void groupAssertionsTest() {
        int[] numbers = {3, 6, 9, 0};
        assertAll("numbers",
                () -> assertEquals(numbers[0], 3),
                () -> assertEquals(numbers[1], 6),
                () -> assertEquals(numbers[2], 9),
                () -> assertEquals(numbers[3], 0)
        );
    }

    @Test
    void exceptionsTest() {
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            Doubler.throwMeExceptionPls();
        });
        assertEquals(exception.getMessage(), "Oopise something went wrong.");
    }

    @TestFactory
    public Stream<DynamicTest> testFactoryTest() {
        return Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .map(number ->
                        DynamicTest.dynamicTest("Test DoubleIt " +  number, () -> {
                            int result = Doubler.doubleIt(number);
                            assertEquals(number*2, result);
                        })
                );
    }

}