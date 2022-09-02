package com.github.diegopacheco.sandboxspring.dao;

import com.github.diegopacheco.sandboxspring.model.Contact;
import com.github.diegopacheco.sandboxspring.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBFeeder {

    @Autowired
    ContactService service;

    public void feedData(){
        for(int i=0;i<10;i++){
            Contact contact = new Contact();
            contact.setEmail("contant_email"+ i + "@gmail.com");
            contact.setName("Person"+i);
            contact.setPhone("415-1234-12"+i);
            service.save(contact);
        }
    }

}
