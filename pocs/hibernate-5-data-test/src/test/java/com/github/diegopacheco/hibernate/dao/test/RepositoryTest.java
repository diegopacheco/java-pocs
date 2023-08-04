package com.github.diegopacheco.hibernate.dao.test;

import com.github.diegopacheco.hibernate.dao.ContactRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest(includeFilters = @ComponentScan.Filter(
        type = FilterType.ASSIGNABLE_TYPE,
        classes = {ContactRepository.class}
))
public class RepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    ContactRepository contactRepository;

    @Test
    public void injectedComponentsAreNotNullTest(){
       assertThat(entityManager).isNotNull();
       assertThat(contactRepository).isNotNull();
    }
}

