import com.github.msemys.esjc.EventData;
import com.github.msemys.esjc.EventStore;
import com.github.msemys.esjc.EventStoreBuilder;
import com.github.msemys.esjc.ExpectedVersion;

import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.UUID;

public class Main{
  public static void main(String args[]) throws Exception {

    EventStore eventstore = EventStoreBuilder.newBuilder()
            .clusterNodeUsingGossipSeeds(cluster -> cluster
                    .gossipSeedEndpoints(Arrays.asList(
                            new InetSocketAddress("127.0.0.1", 2113),
                            new InetSocketAddress("127.0.0.1", 2213),
                            new InetSocketAddress("127.0.0.1", 2313))))
            .userCredentials("admin", "changeit")
            .build();
    System.out.println(eventstore);

    eventstore.appendToStream("foo", ExpectedVersion.ANY, Arrays.asList(
            EventData.newBuilder()
                    .type("bar")
                    .data(new byte[]{1, 2, 3, 4, 5})
                    .metadata(new byte[]{6, 7, 8, 9, 0})
                    .build(),
            EventData.newBuilder()
                    .eventId(UUID.randomUUID())
                    .type("baz")
                    .data("dummy content")
                    .build(),
            EventData.newBuilder()
                    .type("qux")
                    .jsonData("{ a : 1 }")
                    .build())
    ).thenAccept(r -> System.out.println(r.logPosition));

    eventstore.readEvent("foo", 1, false).thenAccept(e ->
            System.out.format("id: '%s'; type: '%s'; data: '%s'",
                    e.event.originalEvent().eventId,
                    e.event.originalEvent().eventType,
                    e.event.originalEvent().data));

  }
}
