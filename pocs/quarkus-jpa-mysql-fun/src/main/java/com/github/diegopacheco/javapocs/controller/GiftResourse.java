package com.github.diegopacheco.javapocs.controller;

import com.github.diegopacheco.javapocs.model.Gift;
import com.github.diegopacheco.javapocs.service.SantaClausService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/gift")
public class GiftResourse {

    @Inject
    SantaClausService scs;

    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String save(@PathParam("name") String name) {
        if ("".equals(name)){
            throw new IllegalArgumentException("Name cannot be null nor empty");
        }
        scs.createGift(name);
        return name;
    }

    @GET
    @Path("/all")
    public Gift[] getGifts() {
        return scs.findAll();
    }

}