package com.github.diegopacheco.pippo.advanced;

import ro.pippo.controller.*;
import ro.pippo.controller.extractor.Header;
import ro.pippo.controller.extractor.Param;
import ro.pippo.controller.extractor.Session;
import ro.pippo.metrics.Metered;
import ro.pippo.metrics.Timed;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/contacts")
public class ContactsController extends Controller {

    private ContactService contactService;

    public ContactsController() {
        contactService = new ContactService();
    }

    @GET
    @Named("index")
//    @Produces(Produces.HTML)
    @Metered
    public void index() {
        // inject "user" attribute in session
        getRouteContext().setSession("user", "decebal");

        // send a template with name "contacts" as response
        getResponse()
                .bind("contacts", contactService.getContacts())
                .render("contacts");
    }

    @GET("/uriFor/{id: [0-9]+}")
    @Named("uriFor")
    @Produces(Produces.TEXT)
    @Timed
    public String uriFor(@Param int id, @Header String host, @Session String user) {
        System.out.println("id = " + id);
        System.out.println("host = " + host);
        System.out.println("user = " + user);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", id);

        String uri = getApplication().getRouter().uriFor("api.get", parameters);

        return "id = " + id + "; uri = " + uri;
    }

    @GET("/api")
    @Named("api.getAll")
    @Produces(Produces.JSON)
    @NoCache
    public List<Contact> getAll() {
        return contactService.getContacts();
    }

    @GET("/api/{id: [0-9]+}")
    @Named("api.get")
    @Produces(Produces.JSON)
    public Contact get(@Param int id) {
        return contactService.getContact(id);
    }

}