import com.bloomberg.bmq.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class SimpleProducer {

    static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static ByteBuffer getBinaryPayload(String payload) {
        // Convert String to ByteBuffer
        byte[] bytes = payload.getBytes(StandardCharsets.UTF_8);
        ByteBuffer bb = ByteBuffer.wrap(bytes);

        return bb;
    }

    public static void main(String[] args) {
        final Uri uri = new Uri("bmq://bmq.tutorial.hello/queue-simple");
        final Duration TIMEOUT = Duration.ofSeconds(15); // 15 seconds

        String brokerUri = System.getenv("BMQ_BROKER_URI");
        if (brokerUri == null) {
            brokerUri = "tcp://localhost:30114";
        }

        final SessionOptions sessionOptions =
                SessionOptions.builder().setBrokerUri(URI.create(brokerUri)).build();
        final AbstractSession session = new Session(sessionOptions, event -> {
        });

        try {
            logger.info("Starting the session");
            session.start(TIMEOUT);

            logger.info("Create a writer queue [{}]", uri);
            final Queue queue =
                    session.getQueue(
                            uri, // Queue uri
                            QueueFlags.setWriter(0), // Queue mode (=WRITE)
                            event -> {
                            }, // QueueEventHandler
                            null, // AckMessageHandler
                            null); // PushMessageHandler

            logger.info("Open the queue");
            queue.open(
                    QueueOptions.createDefault(), // Default queue options
                    TIMEOUT); // Timeout

            logger.info("Post two messages");
            PutMessage put1 =
                    queue.createPutMessage(getBinaryPayload("Hello from BlazingMQ Part 1"));
            queue.post(put1);

            PutMessage put2 =
                    queue.createPutMessage(getBinaryPayload("Hello from BlazingMQ Part 2"));
            queue.post(put2);

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
