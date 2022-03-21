package com.github.diegopacheco.hibernate.test;

import com.github.diegopacheco.hibernate.config.test.DBTestConf;
import com.github.diegopacheco.hibernate.config.test.HibernateTestConf;
import com.github.diegopacheco.hibernate.dao.ContactDao;
import com.github.diegopacheco.hibernate.dao.DBFeeder;
import com.github.diegopacheco.hibernate.service.ContactService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.IdentifiableType;
import javax.persistence.metamodel.Metamodel;
import javax.persistence.metamodel.SingularAttribute;
import javax.transaction.Transactional;
import java.lang.reflect.Field;
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
    public void genericListRemoveInsertQueryByIDTest() throws Exception{
        dbFeeder.feedData();

        System.out.println("All Entities");
        Set<EntityType<?>> entities = em.getMetamodel().getEntities();
        assertNotNull(entities);
        for (EntityType e: entities){
            Class clazz = e.getBindableJavaType();
            System.out.println("Entity: " + e.getName() + " class: " + clazz);

            System.out.println("Entity Fields");
            e.getDeclaredAttributes().forEach(System.out::println);

            System.out.println("Dynamic Query top 3 from entity: " + e.getName());
            List<Object> result = em.createQuery("from " + e.getName()).setMaxResults(3).getResultList();
            assertNotNull(result);
            result.forEach(System.out::println);

            Metamodel m = em.getMetamodel();
            IdentifiableType<?> of = (IdentifiableType<?>) m.managedType(clazz);
            SingularAttribute id = of.getId(of.getIdType().getJavaType());
            System.out.println("ID Discovered: " + id);

            System.out.println("Remove entity and insert it Again! ");
            Object copy = result.get(0);
            em.remove(copy);
            em.flush();

            Field field = copy.getClass().getDeclaredField(id.getName());
            field.setAccessible(true);
            field.set(copy,null);
            em.persist(copy);
            em.flush();

            String jpaQLQuery = "from " + e.getName() + " where " + id.getName() + "=" + field.get(copy);
            result = em.createQuery(jpaQLQuery).getResultList();
            result.forEach(System.out::println);

        }


    }



}
