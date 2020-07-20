package com.github.diegopacheco.javapocs.aeron.ipc;

import io.aeron.Aeron;
import io.aeron.FragmentAssembler;
import io.aeron.Subscription;
import io.aeron.driver.MediaDriver;
import io.aeron.logbuffer.FragmentHandler;
import org.agrona.concurrent.BackoffIdleStrategy;
import org.agrona.concurrent.IdleStrategy;
import java.util.concurrent.TimeUnit;

public class AeronServer {

    public static void main(String[] args) {
        String channel = "aeron:ipc";
        final MediaDriver driver = MediaDriver.launch();
        final Aeron.Context ctx = new Aeron.Context();
        Aeron aeron = Aeron.connect(ctx.aeronDirectoryName(driver.aeronDirectoryName()));

        final Subscription subscription = aeron.addSubscription(channel, 1);
        final FragmentHandler fragmentHandler = (buffer, offset, length, header) -> {
            final byte[] data = new byte[length];
            buffer.getBytes(offset, data);
            System.out.println(String.format(
                    "Message to stream %d from session %d (%d@%d) <<%s>>",
                    1, header.sessionId(), length, offset, new String(data)));
        };

        FragmentHandler fragmentAssembler = new FragmentAssembler(fragmentHandler);
        final IdleStrategy idleStrategy = new BackoffIdleStrategy(
                100, 10, TimeUnit.MICROSECONDS.toNanos(1), TimeUnit.MICROSECONDS.toNanos(100));

        System.out.println("Waiting for messages... ");
        while (true) {
            final int fragmentsRead = subscription.poll(fragmentHandler, 10);
            idleStrategy.idle(fragmentsRead);
        }
    }

}
