package com.github.diegopacheco.javapocs.uuid;

import com.github.f4b6a3.uuid.UuidCreator;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class UUIDUtils {

    private static final long KCLOCK_OFFSET = 0x01b21dd213814000L;
    private static final long KCLOCK_MULTIPLIER_L = 10000L;

    public static String uuidMethod1() {
        return UUID.randomUUID().toString();
    }

    public static String uuidMethod2() {
        return UUID.nameUUIDFromBytes(new SecureRandom().generateSeed(16)).toString();
    }

    public static UUID generateTimeBasedUUID(){
        return UuidCreator.getTimeBased();
    }

    public static String getDatefromUUID(UUID uuid){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(new Date(getUnixTimestampInMillisFromUUIDTimestamp(uuid.timestamp())));
    }

    private static long uuidTimestamp(String strTS){
        long ts = UUID.fromString(strTS).timestamp();
        return getUnixTimestampInMillisFromUUIDTimestamp(ts);
    }

    private static long getUnixTimestampInMillisFromUUIDTimestamp( long uuidTimestamp ) {
        return ( uuidTimestamp - KCLOCK_OFFSET ) / KCLOCK_MULTIPLIER_L;
    }

}