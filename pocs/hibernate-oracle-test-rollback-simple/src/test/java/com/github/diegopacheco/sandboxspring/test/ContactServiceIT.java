package com.github.diegopacheco.sandboxspring.test;

import com.github.diegopacheco.sandboxspring.config.DBConf;
import com.github.diegopacheco.sandboxspring.config.HibernateConf;
import com.github.diegopacheco.sandboxspring.dao.ContactDao;
import com.github.diegopacheco.sandboxspring.dao.DBFeeder;
import com.github.diegopacheco.sandboxspring.model.Contact;
import com.github.diegopacheco.sandboxspring.service.ContactService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = {
            ContactDao.class,
            DBFeeder.class,
            ContactService.class,
            DBConf.class,
            HibernateConf.class
        }
)
public class ContactServiceIT {

    @Autowired
    ContactService service;

    @Autowired
    DBFeeder dbFeeder;

    @Test
    @Transactional
    // by default don't even need this annotation:@Rollback and default is true.
    @Rollback(value = true)
    public void testTxInsert10(){
        dbFeeder.feedData();
        List<Contact> result = service.list();
        result.forEach(System.out::println);
        assertNotNull(result);
    }

    @Test
    @Transactional
    // make it not rollback
    @Rollback(value = false)
    public void testTxInsert(){
        Contact c = new Contact();
        c.setName("c1 name");
        c.setEmail("c1@name.com");
        c.setPhone("123456789");
        service.save(c);

        List<Contact> result = service.list();
        result.forEach(System.out::println);
        assertNotNull(result);
    }


}
