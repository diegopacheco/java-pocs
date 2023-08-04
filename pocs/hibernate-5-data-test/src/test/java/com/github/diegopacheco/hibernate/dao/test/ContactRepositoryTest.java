package com.github.diegopacheco.hibernate.dao.test;

import com.github.diegopacheco.hibernate.dao.ContactRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


//@ExtendWith(SpringExtension.class)
//@DataJpaTest
/*@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = {
                DBTestConf.class,
                HibernateTestConf.class,
                ContactRepository.class,
        }
)*/
//@DataJpaTest
//@ContextConfiguration(classes=ContactRepository.class)
//@EnableAutoConfiguration
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ContactRepositoryTest {
    @Autowired private ContactRepository contactRepository;

    @Test
    public void injectedComponentsAreNotNullTest(){
        assertThat(contactRepository).isNotNull();
    }
}
