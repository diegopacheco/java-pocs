package com.github.diegopacheco.java27.pqctls;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.crypto.KEM;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;

public final class HybridKeyExchange {

    public static final String PREFERRED = "X25519MLKEM768";

    public static final List<String> HYBRID_SCHEMES =
            List.of("X25519MLKEM768", "SecP256r1MLKEM768", "SecP384r1MLKEM1024");

    public static List<String> defaultNamedGroups() throws NoSuchAlgorithmException {
        return List.of(SSLContext.getDefault().getDefaultSSLParameters().getNamedGroups());
    }

    public static boolean quantumResistantByDefault() throws NoSuchAlgorithmException {
        return PREFERRED.equals(defaultNamedGroups().getFirst());
    }

    public static List<String> hybridGroupsEnabledByDefault() throws NoSuchAlgorithmException {
        return defaultNamedGroups().stream().filter(HYBRID_SCHEMES::contains).toList();
    }

    public static List<String> optInHybridSchemes() throws NoSuchAlgorithmException {
        List<String> enabled = hybridGroupsEnabledByDefault();
        return HYBRID_SCHEMES.stream().filter(scheme -> !enabled.contains(scheme)).toList();
    }

    public static List<String> withPreferredGroups(String... groups) {
        SSLParameters parameters = new SSLParameters();
        parameters.setNamedGroups(groups);
        return List.of(parameters.getNamedGroups());
    }

    public static boolean supportsMlKem(String parameterSet) {
        try {
            KEM.getInstance(parameterSet);
            return true;
        } catch (NoSuchAlgorithmException e) {
            return false;
        }
    }
}
