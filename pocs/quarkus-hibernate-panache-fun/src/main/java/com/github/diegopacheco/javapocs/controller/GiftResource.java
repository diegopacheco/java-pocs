package com.github.diegopacheco.javapocs.controller;

import com.github.diegopacheco.javapocs.model.Gift;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/gift")
public class GiftResource {

    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    @Transactional
    public String save(@PathParam("name") String name) {
        Gift g = new Gift();
        g.setName(name);
        g.setActive(true);
        Gift.persist(g);
        return name;
    }

    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Gift> getGifts() {
        return Gift.<Gift>findAll().list();
    }

    @GET
    @Path("/find/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Gift findByName(@PathParam("name") String name) {
        return Gift.findByName(name);
    }

}