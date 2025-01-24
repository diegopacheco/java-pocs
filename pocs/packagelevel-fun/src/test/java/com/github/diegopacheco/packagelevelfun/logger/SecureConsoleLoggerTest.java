package com.github.diegopacheco.packagelevelfun.logger;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class SecureConsoleLoggerTest {

    @Test
    public void testDebugPrint() {
        Map<String, String> data = new HashMap<>();
        data.put("name", "John Doe");
        data.put("ssn", "123-45-6789");
        data.put("email", "john.doe@example.com");

        SecureConsoleLogger.debugPrint(data);

        assertEquals("John Doe", data.get("name"));
        assertEquals("123-45-6789", data.get("ssn"));
        assertEquals("john.doe@example.com", data.get("email"));
    }

    @Test
    public void testExtractRuntimeInfo() {
        StackTraceElement[] stackTraceElements = {
                new StackTraceElement("com.github.diegopacheco.packagelevelfun.logger.SecureConsoleLogger", "debugPrint", "SecureConsoleLogger.java", 25),
                new StackTraceElement("com.github.diegopacheco.packagelevelfun.dao.PersonDAO", "getPersonName", "PersonDAO.java", 10),
                new StackTraceElement("Main", "main", "Main.java", 16)
        };
        List<RuntimeInfo> runtimeInfoList = SecureConsoleLogger.extractRuntimeInfo(stackTraceElements);

        assertNotNull(runtimeInfoList);
        assertFalse(runtimeInfoList.isEmpty());

        RuntimeInfo firstElement = runtimeInfoList.get(0);
        assertEquals("com.github.diegopacheco.packagelevelfun.logger", firstElement.getPackageName());
        assertEquals("SecureConsoleLogger", firstElement.getClassName());
        assertEquals("debugPrint", firstElement.getMethodName());
    }

    @Test
    public void testIsSecure() {
        assertTrue(SecureConsoleLogger.isSecure("com.github.diegopacheco.packagelevelfun.dao.PersonDAO"));
        assertFalse(SecureConsoleLogger.isSecure("com.github.diegopacheco.packagelevelfun.logger.SecureConsoleLogger"));
        assertFalse(SecureConsoleLogger.isSecure("java.lang.String"));
    }
}