package com.github.diegopacheco.hibernate.test;

import com.github.diegopacheco.hibernate.config.test.DBTestConf;
import com.github.diegopacheco.hibernate.config.test.HibernateTestConf;
import com.github.diegopacheco.hibernate.dao.ContactDao;
import com.github.diegopacheco.hibernate.dao.DBFeeder;
import com.github.diegopacheco.hibernate.service.ContactService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
            DBTestConf.class,
            HibernateTestConf.class,
            ContactDao.class,
            DBFeeder.class,
            ContactService.class
        },
        initializers = ConfigFileApplicationContextInitializer.class)
@WebIntegrationTest(randomPort = true)
public class ContactDaoTest {

    private DBFeeder dbFeeder;
    private ContactDao dao;

    @Autowired
    public void setDao(ContactDao dao) {
        this.dao = dao;
    }

    @Autowired
    public void setDbFeeder(DBFeeder dbFeeder) {
        this.dbFeeder = dbFeeder;
    }

    @Test
    @Transactional
    public void testList(){
        dbFeeder.feedData();
        dao.list().forEach(System.out::println);

        System.out.println("Total records: " + dao.count());
        assertEquals(new Integer(10),dao.count());
    }

}
