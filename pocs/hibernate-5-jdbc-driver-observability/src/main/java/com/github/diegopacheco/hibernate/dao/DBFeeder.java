package com.github.diegopacheco.hibernate.dao;

import com.github.diegopacheco.hibernate.model.Contact;
import com.github.diegopacheco.hibernate.service.ContactService;
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

    public long benchmark(int items){
        long init = System.currentTimeMillis();
        for(int i=0;i<items;i++){
            Contact contact = new Contact();
            contact.setEmail("contant_email"+ i + "@gmail.com");
            contact.setName("Person"+i);
            contact.setPhone("415-1234-12"+i);
            service.save(contact);
        }
        long end = System.currentTimeMillis();
        long time = end - init;
        return time;
    }

}
