package com.github.diegopacheco.hibernate.service;

import com.github.diegopacheco.hibernate.dao.ContactDao;
import com.github.diegopacheco.hibernate.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    ContactDao contactDao;

    public void save(Contact contact){
        if (null==contact) throw new IllegalArgumentException("Contact cannot be null");
        contactDao.save(contact);
    }

    public List<Contact> list(){
        return contactDao.list();
    }

}
