package com.github.diegopacheco.javapocs.aeron.ipc;

import io.aeron.Aeron;
import io.aeron.Publication;
import org.agrona.BufferUtil;
import org.agrona.concurrent.UnsafeBuffer;

public class AeronClient {

    private static final UnsafeBuffer BUFFER =
            new UnsafeBuffer(BufferUtil.allocateDirectAligned(256, 64));

    public static void main(String[] args) throws Throwable{
        String channel = "aeron:ipc";
        final Aeron.Context ctx = new Aeron.Context();
        Aeron aeron = Aeron.connect(ctx);

        final Publication publication = aeron.addPublication(channel, 1);
        sentMessage(aeron,publication,"Hello");
    }

    private static void sentMessage(Aeron aeron,Publication publication,String message){
        BUFFER.putBytes(0, message.getBytes());
        final long resultingPosition = publication.offer(BUFFER, 0, message.getBytes().length);
        System.out.println("Publish: " + resultingPosition);
    }
}
