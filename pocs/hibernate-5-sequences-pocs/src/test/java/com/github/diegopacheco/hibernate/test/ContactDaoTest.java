package com.github.diegopacheco.hibernate.test;

import com.github.diegopacheco.hibernate.config.test.DBTestConf;
import com.github.diegopacheco.hibernate.config.test.HibernateTestConf;
import com.github.diegopacheco.hibernate.dao.ContactDao;
import com.github.diegopacheco.hibernate.dao.DBFeeder;
import com.github.diegopacheco.hibernate.service.ContactService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    @Transactional
    public void testList(){
        dbFeeder.feedData();
        dao.list().forEach(System.out::println);

        System.out.println("Total records: " + dao.count());
        assertEquals(11,dao.count());
    }

}
