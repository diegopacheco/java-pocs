package com.github.diegopacheco.functional.inter;

import java.util.function.IntConsumer;

public final class Defaults {

    private static final int PORT = 8080;
    private static final int TLS_PORT = 8883;
    private static final int ADMIN_PORT = 9090;

    public static void foreach(IntConsumer consumer){
        consumer.accept(PORT);
        consumer.accept(TLS_PORT);
        consumer.accept(ADMIN_PORT);
    }

}
