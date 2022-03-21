package com.github.diegopacheco.hibernate.test;

import com.github.diegopacheco.hibernate.config.test.DBTestConf;
import com.github.diegopacheco.hibernate.config.test.HibernateTestConf;
import com.github.diegopacheco.hibernate.dao.ContactDao;
import com.github.diegopacheco.hibernate.dao.DBFeeder;
import com.github.diegopacheco.hibernate.service.ContactService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import javax.transaction.Transactional;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = {
                DBTestConf.class,
                HibernateTestConf.class,
                ContactDao.class,
                DBFeeder.class,
                ContactService.class
        }
)
public class ContactDaoTest {

    @Autowired
    ContactDao dao;

    @Autowired
    DBFeeder dbFeeder;

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    public void testInsertAndList(){
        dbFeeder.feedData();
        dao.list().forEach(System.out::println);

        System.out.println("Total records: " + dao.count());
        assertEquals(10,dao.count());
    }

    @Test
    @Transactional
    public void genericListTest(){
        dbFeeder.feedData();

        System.out.println("All Entities");
        Set<EntityType<?>> entities = em.getMetamodel().getEntities();
        assertNotNull(entities);
        for (EntityType e: entities){
            Class clazz = e.getBindableJavaType();
            System.out.println("Entity: " + e.getName() + " class: " + clazz);

            System.out.println("Dynamic Query top 3 from entity: " + e.getName());
            List<Object> result = em.createQuery("from " + e.getName()).setMaxResults(3).getResultList();
            assertNotNull(result);
            result.forEach(System.out::println);
        }
    }



}
