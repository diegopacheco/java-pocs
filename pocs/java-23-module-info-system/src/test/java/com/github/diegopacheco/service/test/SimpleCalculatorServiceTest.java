package com.github.diegopacheco.service.test;

import com.github.diegopacheco.service.math.Calculator;
import com.github.diegopacheco.service.math.SimpleCalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleCalculatorServiceTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new SimpleCalculatorService();
    }

    @Test
    @DisplayName("Test addition of two numbers")
    void testAdd() {
        assertEquals(5, calculator.add(2, 3), 0.001);
        assertEquals(-1, calculator.add(-3, 2), 0.001);
        assertEquals(0, calculator.add(0, 0), 0.001);
    }

    @Test
    @DisplayName("Test subtraction of two numbers")
    void testSub() {
        assertEquals(-1, calculator.sub(2, 3), 0.001);
        assertEquals(-5, calculator.sub(-3, 2), 0.001);
        assertEquals(0, calculator.sub(0, 0), 0.001);
    }

    @Test
    @DisplayName("Test multiplication of two numbers")
    void testMul() {
        assertEquals(6, calculator.mul(2, 3), 0.001);
        assertEquals(-6, calculator.mul(-3, 2), 0.001);
        assertEquals(0, calculator.mul(0, 5), 0.001);
    }

    @Test
    @DisplayName("Test division of two numbers")
    void testDiv() {
        assertEquals(2, calculator.div(6, 3), 0.001);
        assertEquals(-1.5, calculator.div(-3, 2), 0.001);
        assertEquals(Double.POSITIVE_INFINITY, calculator.div(5, 0), 0.001);
    }

    @Test
    @DisplayName("Test power function")
    void testPow() {
        assertEquals(8, calculator.pow(2, 3), 0.001);
        assertEquals(0.25, calculator.pow(2, -2), 0.001);
        assertEquals(1, calculator.pow(5, 0), 0.001);
    }

    @Test
    @DisplayName("Test square root function")
    void testSqrt() {
        assertEquals(2, calculator.sqrt(4), 0.001);
        assertEquals(0, calculator.sqrt(0), 0.001);
        assertEquals(Double.NaN, calculator.sqrt(-1), 0.001);
    }

    @Test
    @DisplayName("Test sine function")
    void testSin() {
        assertEquals(0, calculator.sin(0), 0.001);
        assertEquals(1, calculator.sin(Math.PI/2), 0.001);
        assertEquals(0, calculator.sin(Math.PI), 0.001);
    }

    @Test
    @DisplayName("Test cosine function")
    void testCos() {
        assertEquals(1, calculator.cos(0), 0.001);
        assertEquals(0, calculator.cos(Math.PI/2), 0.001);
        assertEquals(-1, calculator.cos(Math.PI), 0.001);
    }

    @Test
    @DisplayName("Test tangent function")
    void testTan() {
        assertEquals(0, calculator.tan(0), 0.001);
        assertEquals(1, calculator.tan(Math.PI/4), 0.001);
        assertEquals(0, calculator.tan(Math.PI), 0.001);
    }
}