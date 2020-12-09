package com.github.diegopacheco.sandboxspring.dao;

import com.github.diegopacheco.sandboxspring.model.Thing;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
public class ThingDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void createThing(String name){
        Thing t = new Thing();
        t.setName(name);
        t.setId(1L);

        sessionFactory.getCurrentSession().save(t);
        System.out.println("Record Successfully Inserted In The Database");
    }

    public Thing getThing(Long id){
        return new Thing();
    }

}
