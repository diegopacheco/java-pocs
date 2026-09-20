package com.github.diegopacheco.java27.compactheaders;

import com.sun.management.HotSpotDiagnosticMXBean;
import java.lang.management.ManagementFactory;

public final class CompactObjectHeaders {

    public static boolean enabled() {
        return Boolean.parseBoolean(flag("UseCompactObjectHeaders"));
    }

    public static int headerBits() {
        return enabled() ? 64 : 96;
    }

    public static long headerBytesSavedPerObject() {
        return enabled() ? 4L : 0L;
    }

    private static String flag(String name) {
        return ManagementFactory.getPlatformMXBean(HotSpotDiagnosticMXBean.class)
                .getVMOption(name)
                .getValue();
    }
}
