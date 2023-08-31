import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.UUID;

@Path("/")
public class UUIDResource {

        @GET
        @Produces(MediaType.TEXT_PLAIN)
        public String index(){
            return UUID.randomUUID().toString();
        }
}
