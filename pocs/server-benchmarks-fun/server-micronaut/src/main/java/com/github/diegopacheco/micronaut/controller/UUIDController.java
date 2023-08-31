import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

import java.util.UUID;

@Controller("/uuid")
public class UUIDController {

    @Get("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String index() {
        return UUID.randomUUID().toString();
    }

}
