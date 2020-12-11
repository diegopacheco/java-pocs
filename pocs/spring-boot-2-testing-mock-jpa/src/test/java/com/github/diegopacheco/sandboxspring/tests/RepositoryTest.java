package com.github.diegopacheco.sandboxspring.tests;

import com.github.diegopacheco.sandboxspring.dao.PetRepository;
import com.github.diegopacheco.sandboxspring.model.Pet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PetRepository repository;

    @Test
    public void testRepositoryDontDoThisAtHomeKids() throws Exception {
        this.entityManager.persist(new Pet("Melina"));
        Pet tigre = this.repository.findByName("Melina");
        assertThat(tigre.getName()).isEqualTo("Melina");
    }


}
