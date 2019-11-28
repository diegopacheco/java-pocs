
import java.util.concurrent.CompletableFuture;

import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.server.Server;
import com.linecorp.armeria.server.ServerBuilder;
 
public class ServerMain{
    public static void main(String[] args) throws Exception {
        ServerBuilder sb = Server.builder();
        sb.http(8080);
        sb.service("/", (ctx, res) -> HttpResponse.of("Hello, world!"));
        Server server = sb.build();
        CompletableFuture<Void> future = server.start();
        future.join();        
    }
}

