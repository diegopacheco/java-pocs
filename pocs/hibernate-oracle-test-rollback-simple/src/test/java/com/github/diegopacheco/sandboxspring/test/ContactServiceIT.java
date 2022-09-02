package com.github.diegopacheco.sandboxspring.test;

import com.github.diegopacheco.sandboxspring.dao.ContactDao;
import com.github.diegopacheco.sandboxspring.dao.DBFeeder;
import com.github.diegopacheco.sandboxspring.model.Contact;
import com.github.diegopacheco.sandboxspring.service.ContactService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = {
            ContactDao.class,
            DBFeeder.class,
            ContactService.class
        }
)
public class ContactServiceIT {

    @Autowired
    ContactService service;

    @Autowired
    DBFeeder dbFeeder;

    @Test
    @Transactional
    public void testTxInsert(){
        dbFeeder.feedData();
        List<Contact> result = service.list();
        result.forEach(System.out::println);
        assertNotNull(result);
    }

}
