package com.github.diegopacheco.hibernate.dao;

import com.github.diegopacheco.hibernate.model.Contact;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class ContactDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void save(Contact contact){
        sessionFactory.getCurrentSession().save(contact);
    }

    public List<Contact> list(){
        TypedQuery<Contact> query = sessionFactory.getCurrentSession().createQuery("from Contact");
        return query.getResultList();
    }

    public Integer count(){
        return jdbcTemplate.queryForObject("Select COUNT(*) from Contact",Integer.class);
    }

}
