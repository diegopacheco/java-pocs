package com.github.diegopacheco.pippo.basic;

import ro.pippo.core.Application;

import java.io.File;

public class BasicApplication extends Application {

    @Override
    protected void onInit() {
        // send 'Hello World' as response
        GET("/", routeContext -> routeContext.send("Hello World"));

        // send a file as response
        GET("/file", routeContext -> routeContext.send(new File("pom.xml")));

        // send a json as response
        GET("/json", routeContext -> {
            Contact contact = createContact();
            routeContext.json().send(contact);
        });

        // send xml as response
        GET("/xml", routeContext -> {
            Contact contact = createContact();
            routeContext.xml().send(contact);
        });

        // send an object and negotiate the Response content-type, default to XML
        GET("/negotiate", routeContext -> {
            Contact contact = createContact();
            routeContext.xml().negotiateContentType().send(contact);
        });

        // send a template with name "hello" as response
        GET("/template", routeContext -> {
            routeContext.setLocal("greeting", "Hello"); // template's model/context
            routeContext.render("hello");
        });
    }

    private Contact createContact() {
        return new Contact()
                .setId(12345)
                .setName("John")
                .setPhone("0733434435")
                .setAddress("Sunflower Street, No. 6");
    }

}