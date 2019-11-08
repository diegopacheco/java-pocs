import io.servicetalk.http.netty.HttpServers;

import static io.servicetalk.concurrent.api.Single.succeeded;
import static io.servicetalk.http.api.HttpSerializationProviders.textSerializer;

public final class HelloWorldServer {

    public static void main(String[] args) throws Exception {
        HttpServers.forPort(8080)
                .listenAndAwait((ctx, request, responseFactory) ->
                        succeeded(responseFactory.ok()
                                .payloadBody("Hello World!", textSerializer())))
                .awaitShutdown();
    }
}