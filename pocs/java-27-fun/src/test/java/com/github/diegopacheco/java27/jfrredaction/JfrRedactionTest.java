package com.github.diegopacheco.java27.jfrredaction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import org.junit.jupiter.api.Test;

class JfrRedactionTest {

    @Test
    void aSecretSystemPropertyNeverReachesTheRecordingFile() throws Exception {
        Map<String, String> properties = JfrRedaction.initialSystemProperties();
        assertEquals(JfrRedaction.REDACTED, properties.get("java27.fun.confidential"));
        assertFalse(properties.containsValue("SECRET_VALUE"));
    }

    @Test
    void propertiesThatDoNotMatchAFilterAreStillRecordedInFull() throws Exception {
        Map<String, String> properties = JfrRedaction.initialSystemProperties();
        assertEquals("PLAIN_VALUE", properties.get("java27.fun.plain"));
    }

    @Test
    void theProcessItselfStillSeesTheRealValueOnlyTheRecordingIsRedacted() throws Exception {
        assertEquals("SECRET_VALUE", System.getProperty("java27.fun.confidential"));
        assertTrue(JfrRedaction.isRedacted("java27.fun.confidential"));
    }

    @Test
    void theBuiltInDefaultFiltersRemainActiveAlongsideTheCustomOne() throws Exception {
        Map<String, String> properties = JfrRedaction.initialSystemProperties();
        assertFalse(properties.isEmpty());
        assertTrue(properties.containsKey("java.vm.version"));
    }
}
