import io.pravega.client.ClientConfig;
import io.pravega.client.EventStreamClientFactory;
import io.pravega.client.admin.ReaderGroupManager;
import io.pravega.client.admin.StreamManager;
import io.pravega.client.stream.*;
import io.pravega.client.stream.impl.UTF8StringSerializer;

import java.net.URI;

public class Main {
    public static void main(String args[]) {
        StreamConfiguration streamConfig = StreamConfiguration.builder()
                .scalingPolicy(ScalingPolicy.fixed(1))
                .build();

        URI controllerURI = URI.create("tcp://localhost:9090");

        try (StreamManager streamManager = StreamManager.create(controllerURI)) {
            streamManager.createScope("examples");
            streamManager.createStream("examples", "helloStream", streamConfig);
        }

        try (EventStreamClientFactory clientFactory = EventStreamClientFactory.withScope("examples",
                ClientConfig.builder().controllerURI(controllerURI).build());
             EventStreamWriter<String> writer = clientFactory.createEventWriter("helloStream",
                     new UTF8StringSerializer(), EventWriterConfig.builder().build())) {
            writer.writeEvent("helloRoutingKey", "hello world!"); // write an event.
        }

        try (ReaderGroupManager readerGroupManager = ReaderGroupManager.withScope("examples", controllerURI)) {
            ReaderGroupConfig readerGroupConfig = ReaderGroupConfig.builder()
                    .stream(Stream.of("examples", "helloStream"))
                    .disableAutomaticCheckpoints()
                    .build();
            readerGroupManager.createReaderGroup("readerGroup", readerGroupConfig);
        }

        try (EventStreamClientFactory clientFactory = EventStreamClientFactory.withScope("examples",
                ClientConfig.builder().controllerURI(controllerURI).build());
             EventStreamReader<String> reader = clientFactory.createReader("reader",
                     "readerGroup",
                     new UTF8StringSerializer(),
                     ReaderConfig.builder().build())) {
            String event = reader.readNextEvent(5000).getEvent();
            System.out.println(event);
        }
    }
}
