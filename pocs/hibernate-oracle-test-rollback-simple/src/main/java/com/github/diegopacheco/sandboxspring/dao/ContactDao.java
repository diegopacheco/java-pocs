package com.github.diegopacheco.sandboxspring.dao;

import com.github.diegopacheco.sandboxspring.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ContactDao {

    @Autowired
    private EntityManager em;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean save(Contact contact){
        //sessionFactory.getCurrentSession().save(contact);
        em.persist(contact);
        return true;
    }

    public List<Contact> list(){
        return em.createQuery("from Contact").getResultList();
    }

    public Integer count(){
        return jdbcTemplate.queryForObject("Select COUNT(*) from Contact",Integer.class);
    }

}