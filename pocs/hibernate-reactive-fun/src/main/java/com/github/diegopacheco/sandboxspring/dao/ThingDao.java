package com.github.diegopacheco.sandboxspring.dao;

import com.github.diegopacheco.sandboxspring.model.Thing;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Component
public class ThingDao {

    private static final EntityManagerFactory emFactory;
    private static final String PERSISTENCE_UNIT_NAME = "ThingPU";

    static {
        emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    private static EntityManager getEntityManager() {
        return emFactory.createEntityManager();
    }

    public void createThing(String name){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        Thing t = new Thing();
        t.setName(name);
        t.setId(1L);
        em.persist(t);
        em.getTransaction().commit();
        em.clear();
        System.out.println("Record Successfully Inserted In The Database");
    }

    public Thing getThing(Long id){
        return null;
    }

}
