package com.github.diegopacheco.sandboxspring.service;

import com.github.diegopacheco.sandboxspring.dao.ContactDao;
import com.github.diegopacheco.sandboxspring.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ContactService {

    @Autowired
    ContactDao contactDao;

    @Transactional
    public void save(Contact contact){
        if (null==contact) throw new IllegalArgumentException("Contact cannot be null");
        contactDao.save(contact);
    }

    public List<Contact> list(){
        return contactDao.list();
    }

}
