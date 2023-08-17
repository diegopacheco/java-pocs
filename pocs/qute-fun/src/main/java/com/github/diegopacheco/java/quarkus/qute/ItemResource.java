package com.github.diegopacheco.java.quarkus.qute;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateExtension;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Path("items")
public class ItemResource {

    @CheckedTemplate
    static class Templates {
        static native TemplateInstance items(List<Item> items);
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(new BigDecimal(10), "Apple"));
        items.add(new Item(new BigDecimal(16), "Pear"));
        items.add(new Item(new BigDecimal(30), "Orange"));
        return Templates.items(items);
    }

    @TemplateExtension
    static BigDecimal discountedPrice(Item item) {
        return item.price.multiply(new BigDecimal("0.9"));
    }

}