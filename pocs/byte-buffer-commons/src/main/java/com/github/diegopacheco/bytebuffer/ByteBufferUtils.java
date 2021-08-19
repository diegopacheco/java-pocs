package com.github.diegopacheco.bytebuffer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class ByteBufferUtils {

    public static ByteBuffer stringToBB(String str){
        ByteBuffer bb = ByteBuffer.wrap(str.getBytes(StandardCharsets.UTF_8));
        return  bb;
    }

    public static String bbToString(ByteBuffer bb){
        String str = new String(bb.array());
        return str;
    }

    public static ByteBuffer clone(ByteBuffer original) {
        ByteBuffer clone = ByteBuffer.allocate(original.capacity());
        original.rewind();//copy from the beginning
        clone.put(original);
        original.rewind();
        clone.flip();
        return clone;
    }

}
