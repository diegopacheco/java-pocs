import com.bloomberg.bmq.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class SimpleConsumer {
    static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static void handlePushMessage(PushMessage msg, BlockingQueue<String> receivedMessages) {
        // Get the data in the message.
        StringBuilder contentBuilder = new StringBuilder();
        for (ByteBuffer bb : msg.payload()) {
            // It is safe to convert ByteBuffer payload to String only if it's known that
            // payload represents a valid string
            // (e.g. it doesn't make sense to do this if producer sent a protobuf encoded
            // payload)
            String bufferContent = StandardCharsets.UTF_8.decode(bb).toString();
            contentBuilder.append(bufferContent);
        }

        final String content = contentBuilder.toString();

        // Confirm reception of the messages so that it can be deleted from the queue
        ResultCodes.GenericResult confirmResult = msg.confirm();
        logger.debug("Confirm status: {}", confirmResult);

        try {
            receivedMessages.put(content);
        } catch (InterruptedException e) {
            logger.info("InterruptedException: ", e);
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final Uri uri = new Uri("bmq://bmq.tutorial.hello/queue-simple");
        final Duration TIMEOUT = Duration.ofSeconds(15); // 15 seconds
        final int MSG_TIMEOUT = 60; // 60 seconds

        String brokerUri = System.getenv("BMQ_BROKER_URI");
        if (brokerUri == null) {
            brokerUri = "tcp://localhost:30114";
        }

        final SessionOptions sessionOptions =
                SessionOptions.builder().setBrokerUri(URI.create(brokerUri)).build();
        final AbstractSession session = new Session(sessionOptions, event -> {});

        final BlockingQueue<String> receivedMessages = new LinkedBlockingQueue<String>();

        try {
            logger.info("Starting the session");
            session.start(TIMEOUT);

            logger.info("Create a reader queue [{}]", uri);
            final Queue queue =
                    session.getQueue(
                            uri, // Queue uri
                            QueueFlags.setReader(0), // Queue mode (=READ)
                            event -> {}, // QueueEventHandler
                            null, // AckMessageHandler
                            msg -> { // PushMessageHandler
                                handlePushMessage(msg, receivedMessages);
                            });

            logger.info("Open the queue");
            queue.open(QueueOptions.createDefault(), TIMEOUT);

            logger.info("*** Waiting for messages ({} seconds timeout) ***", MSG_TIMEOUT);
            String part1 = receivedMessages.poll(MSG_TIMEOUT, TimeUnit.SECONDS);
            logger.info("First message: {}", part1 != null ? part1 : "*** timeout ***");

            String part2 = receivedMessages.poll(MSG_TIMEOUT, TimeUnit.SECONDS);
            logger.info("Second message: {}", part2 != null ? part2 : "*** timeout ***");
            logger.info("Close the queue");
            queue.close(TIMEOUT);
        } finally {
            logger.info("Stop the session");
            session.stop(TIMEOUT);
            logger.info("Linger the session");
            session.linger();
        }
    }
}
