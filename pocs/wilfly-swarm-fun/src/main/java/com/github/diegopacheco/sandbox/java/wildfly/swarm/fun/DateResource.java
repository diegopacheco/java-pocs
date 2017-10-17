package com.github.diegopacheco.sandbox.java.wildfly.swarm.fun;

import java.util.Date;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
public class DateResource {

    @GET
    @Produces("text/plain")
    public String hello() {
        return new Date().toString();
    }
}
