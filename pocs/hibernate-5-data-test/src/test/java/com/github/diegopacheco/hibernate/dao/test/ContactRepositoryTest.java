package com.github.diegopacheco.hibernate.dao.test;

import com.github.diegopacheco.hibernate.config.test.DBTestConf;
import com.github.diegopacheco.hibernate.config.test.HibernateTestConf;
import com.github.diegopacheco.hibernate.dao.ContactDao;
import com.github.diegopacheco.hibernate.dao.ContactRepository;
import com.github.diegopacheco.hibernate.dao.DBFeeder;
import com.github.diegopacheco.hibernate.service.ContactService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@ExtendWith(SpringExtension.class)
//@DataJpaTest
/*@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = {
                //DBTestConf.class,
                //HibernateTestConf.class,
                ContactDao.class,
                //DBFeeder.class,
                ContactService.class
        }
)*/
//@DataJpaTest
/*@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = {
                DBTestConf.class,
                HibernateTestConf.class,
                ContactDao.class,
                ContactService.class
        }
)*/
//@ComponentScan("com.github.diegopacheco")
//@ContextConfiguration(classes={DBTestConf.class,HibernateTestConf.class,ContactRepository.class})
@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED)
//@Import(HibernateTestConf.class)
//@ExtendWith(SpringExtension.class)
//@TestPropertySource(properties = {
//        "spring.jpa.hibernate.ddl-auto=validate"
//})
public class ContactRepositoryTest {
    @Autowired private TestEntityManager entityManager;
    @Autowired private ContactRepository contactRepository;

    @Test
    public void injectedComponentsAreNotNullTest(){
        assertThat(entityManager).isNotNull();
        assertThat(contactRepository).isNotNull();
    }
}
