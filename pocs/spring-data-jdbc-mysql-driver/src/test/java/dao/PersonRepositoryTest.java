package dao;

import com.github.diegopacheco.sandboxspring.Application;
import com.github.diegopacheco.sandboxspring.dao.PersonRepository;
import com.github.diegopacheco.sandboxspring.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

@SpringBootTest(classes = Application.class)
@ActiveProfiles("test")
@Sql(scripts = "/test-data.sql")
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testFindByFirstName() {
        List<Person> people = personRepository.findByFirstName("Diego");
        assertThat(people).hasSize(1);
        assertThat(people.getFirst().getLastName()).isEqualTo("*******");
    }

    @Test
    public void testUpdateByFirstName() {
        boolean updated = personRepository.updateByFirstName(2L, "Johnny");
        assertThat(updated).isTrue();

        Person person = personRepository.findById(2L).orElse(null);
        assertThat(person).isNotNull();
        assertThat(person.getFirstName()).isEqualTo("**hnny");
    }
}