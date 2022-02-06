package com.github.diegopacheco.bb;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class ByteBufferUtils {

    public static String bbToString(ByteBuffer bb){
        return new String(bb.array(), StandardCharsets.UTF_8);
    }

    public static ByteBuffer stringToBB(String strUtf8){
        return ByteBuffer.wrap(strUtf8.getBytes(StandardCharsets.UTF_8));
    }

}
