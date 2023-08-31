package com.github.diegopacheco.micronaut;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.UUID;

@Controller("/uuid")
public class UUIDController {

    @Get(produces = MediaType.TEXT_PLAIN)
    public String index() {
        return UUID.randomUUID().toString();
    }

}
