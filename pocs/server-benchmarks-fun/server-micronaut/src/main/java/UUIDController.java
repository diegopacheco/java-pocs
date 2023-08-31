import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.UUID;

@Controller("/")
public class UUIDController {

    @Get
    public String index() {
        return UUID.randomUUID().toString();
    }

}
