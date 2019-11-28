
import java.util.concurrent.CompletableFuture;

import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.common.HttpStatus;
import com.linecorp.armeria.common.MediaType;
import com.linecorp.armeria.server.Server;
import com.linecorp.armeria.server.ServerBuilder;
import com.linecorp.armeria.server.annotation.Get;
import com.linecorp.armeria.server.annotation.Param;
 
public class ServerMain{
    public static void main(String[] args) throws Exception {
        ServerBuilder sb = Server.builder();
        sb.http(8080);
        sb.service("/", (ctx, res) -> HttpResponse.of("Hello, world!"));
        sb.annotatedService(new Object() {
            @Get("/hello/{name}")
            public HttpResponse hello(@Param("name") String name) {
                return HttpResponse.of(HttpStatus.OK,
                                       MediaType.PLAIN_TEXT_UTF_8,
                                       "Hello, %s!", name);
            }
        });
        Server server = sb.build();
        CompletableFuture<Void> future = server.start();
        future.join();        
    }
}

