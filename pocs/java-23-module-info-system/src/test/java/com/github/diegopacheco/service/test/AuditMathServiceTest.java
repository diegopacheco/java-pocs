package com.github.diegopacheco.service.test;

import com.github.diegopacheco.service.history.AuditMathService;
import com.github.diegopacheco.service.math.Calculator;
import com.github.diegopacheco.service.math.SimpleCalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class AuditMathServiceTest {

    private AuditMathService auditService;

    @BeforeEach
    void setUp() {
        Calculator calculator = new SimpleCalculatorService();
        auditService = new AuditMathService(calculator);
    }

    @Test
    @DisplayName("Test add operation and history recording")
    void testAdd() {
        double result = auditService.add(5, 3);
        assertEquals(8, result, 0.001);

        Map<String, String> history = auditService.getHistory();
        assertTrue(history.containsKey("5.0+3.0"));
        assertEquals("8.0", history.get("5.0+3.0"));
    }

    @Test
    @DisplayName("Test subtract operation and history recording")
    void testSub() {
        double result = auditService.sub(10, 4);
        assertEquals(6, result, 0.001);

        Map<String, String> history = auditService.getHistory();
        assertTrue(history.containsKey("10.0-4.0"));
        assertEquals("6.0", history.get("10.0-4.0"));
    }

    @Test
    @DisplayName("Test multiply operation and history recording")
    void testMul() {
        double result = auditService.mul(7, 6);
        assertEquals(42, result, 0.001);

        Map<String, String> history = auditService.getHistory();
        assertTrue(history.containsKey("7.0*6.0"));
        assertEquals("42.0", history.get("7.0*6.0"));
    }

    @Test
    @DisplayName("Test divide operation and history recording")
    void testDiv() {
        double result = auditService.div(20, 5);
        assertEquals(4, result, 0.001);

        Map<String, String> history = auditService.getHistory();
        assertTrue(history.containsKey("20.0/5.0"));
        assertEquals("4.0", history.get("20.0/5.0"));
    }

    @Test
    @DisplayName("Test power operation and history recording")
    void testPow() {
        double result = auditService.pow(2, 3);
        assertEquals(8, result, 0.001);

        Map<String, String> history = auditService.getHistory();
        assertTrue(history.containsKey("2.0^3.0"));
        assertEquals("8.0", history.get("2.0^3.0"));
    }

    @Test
    @DisplayName("Test square root operation and history recording")
    void testSqrt() {
        double result = auditService.sqrt(16);
        assertEquals(4, result, 0.001);

        Map<String, String> history = auditService.getHistory();
        assertTrue(history.containsKey("sqrt(16.0)"));
        assertEquals("4.0", history.get("sqrt(16.0)"));
    }

    @Test
    @DisplayName("Test sine operation and history recording")
    void testSin() {
        double result = auditService.sin(0);
        assertEquals(0, result, 0.001);

        Map<String, String> history = auditService.getHistory();
        assertTrue(history.containsKey("sin(0.0)"));
        assertEquals("0.0", history.get("sin(0.0)"));
    }

    @Test
    @DisplayName("Test cosine operation and history recording")
    void testCos() {
        double result = auditService.cos(0);
        assertEquals(1, result, 0.001);

        Map<String, String> history = auditService.getHistory();
        assertTrue(history.containsKey("cos(0.0)"));
        assertEquals("1.0", history.get("cos(0.0)"));
    }

    @Test
    @DisplayName("Test tangent operation and history recording")
    void testTan() {
        double result = auditService.tan(0);
        assertEquals(0, result, 0.001);

        Map<String, String> history = auditService.getHistory();
        assertTrue(history.containsKey("tan(0.0)"));
        assertEquals("0.0", history.get("tan(0.0)"));
    }

    @Test
    @DisplayName("Test multiple operations and complete history")
    void testMultipleOperations() {
        auditService.add(1, 2);
        auditService.sub(5, 3);
        auditService.mul(4, 5);

        Map<String, String> history = auditService.getHistory();
        assertEquals(3, history.size());
        assertTrue(history.containsKey("1.0+2.0"));
        assertTrue(history.containsKey("5.0-3.0"));
        assertTrue(history.containsKey("4.0*5.0"));

        assertEquals("3.0", history.get("1.0+2.0"));
        assertEquals("2.0", history.get("5.0-3.0"));
        assertEquals("20.0", history.get("4.0*5.0"));
    }

    @Test
    @DisplayName("Test history is immutable")
    void testHistoryImmutable() {
        auditService.add(1, 1);

        Map<String, String> history = auditService.getHistory();
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            history.put("test", "value");
        });

        assertTrue(exception instanceof UnsupportedOperationException);
    }
}