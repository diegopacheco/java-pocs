package com.github.diegopacheco.javapocs.uuid;

import java.security.SecureRandom;
import java.util.UUID;

public class UUIDUtils {

    public static String uuidMethod1() {
        return UUID.randomUUID().toString();
    }

    public static String uuidMethod2() {
        return UUID.nameUUIDFromBytes(new SecureRandom().generateSeed(16)).toString();
    }

}