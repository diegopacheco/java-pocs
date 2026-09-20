package com.github.diegopacheco.java27.pqctls;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class HybridKeyExchangeTest {

    @Test
    void existingCodeGetsQuantumResistantKeyExchangeWithoutAnyChange() throws Exception {
        assertTrue(HybridKeyExchange.quantumResistantByDefault());
        assertEquals("X25519MLKEM768", HybridKeyExchange.defaultNamedGroups().getFirst());
    }

    @Test
    void theClassicGroupsStayAvailableSoHandshakesCanStillFallBack() throws Exception {
        List<String> groups = HybridKeyExchange.defaultNamedGroups();
        assertTrue(groups.contains("x25519"));
        assertTrue(groups.contains("secp256r1"));
        assertTrue(groups.contains("secp384r1"));
    }

    @Test
    void onlyTheFastestHybridSchemeIsOnByDefaultTheOtherTwoAreOptIn() throws Exception {
        assertEquals(List.of("X25519MLKEM768"), HybridKeyExchange.hybridGroupsEnabledByDefault());
        assertEquals(List.of("SecP256r1MLKEM768", "SecP384r1MLKEM1024"),
                HybridKeyExchange.optInHybridSchemes());
    }

    @Test
    void anApplicationCanOptIntoAnotherHybridSchemePerConnection() {
        List<String> chosen = HybridKeyExchange.withPreferredGroups("SecP256r1MLKEM768", "x25519");
        assertEquals(List.of("SecP256r1MLKEM768", "x25519"), chosen);
    }

    @Test
    void bothMlKemParameterSetsBehindTheHybridSchemesArePresent() {
        assertTrue(HybridKeyExchange.supportsMlKem("ML-KEM-768"));
        assertTrue(HybridKeyExchange.supportsMlKem("ML-KEM-1024"));
    }
}
