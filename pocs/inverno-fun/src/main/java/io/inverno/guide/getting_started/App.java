package io.inverno.guide.getting_started;

import io.inverno.core.annotation.Bean;
import io.inverno.core.v1.Application;
import io.inverno.mod.web.annotation.QueryParam;
import io.inverno.mod.web.annotation.WebController;
import io.inverno.mod.web.annotation.WebRoute;

import java.util.Optional;

@Bean
@WebController
public class App {

    @WebRoute( path = "/hello" )
    public String hello(@QueryParam Optional<String> name) {
        return String.format("Hello, %s!", name.orElse("world"));
    }

    public static void main(String[] args) {
        Application.run(new Getting_started.Builder());
    }
}