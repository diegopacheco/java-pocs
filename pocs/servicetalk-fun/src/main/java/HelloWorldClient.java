import io.servicetalk.http.api.HttpClient;
import io.servicetalk.http.netty.HttpClients;
import java.util.concurrent.CountDownLatch;
import static io.servicetalk.http.api.HttpSerializationProviders.textDeserializer;

public final class HelloWorldClient {

    public static void main(String[] args) throws Exception {
        try (HttpClient client = HttpClients.forSingleAddress("localhost", 8080).build()) {
            CountDownLatch responseProcessedLatch = new CountDownLatch(1);
            client.request(client.get("/sayHello"))
                    .whenFinally(responseProcessedLatch::countDown)
                    .subscribe(resp -> {
                        System.out.println(resp.toString((name, value) -> value));
                        System.out.println(resp.payloadBody(textDeserializer()));
                    });
            responseProcessedLatch.await();
        }
    }
}