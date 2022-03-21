package com.github.diegopacheco.hibernate.dao;

import com.github.diegopacheco.hibernate.model.Contact;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
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
        //TypedQuery<Contact> query = sessionFactory.getCurrentSession().createQuery("from Contact");
        //return query.getResultList();
        return em.createQuery("from Contact").getResultList();
    }

    public Integer count(){
        return jdbcTemplate.queryForObject("Select COUNT(*) from Contact",Integer.class);
    }

}
