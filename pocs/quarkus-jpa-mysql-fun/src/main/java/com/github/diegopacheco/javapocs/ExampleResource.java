package com.github.diegopacheco.javapocs;

import com.github.diegopacheco.javapocs.service.SantaClausService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

    @Inject
    SantaClausService scs;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String save() {
        String gift = "bonbon";
        scs.createGift(gift);
        return gift;
    }

}