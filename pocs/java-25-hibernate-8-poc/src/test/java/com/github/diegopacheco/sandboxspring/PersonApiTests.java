package com.github.diegopacheco.sandboxspring;

import com.github.diegopacheco.sandboxspring.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.client.RestTestClient;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonApiTests {

    @LocalServerPort
    private int port;

    private RestTestClient client;

    @BeforeEach
    void setup() {
        client = RestTestClient.bindToServer().baseUrl("http://localhost:" + port).build();
    }

    @Test
    void listsAllSeededPeople() {
        Person[] people = client.get().uri("/people").exchange()
                .expectStatus().isOk()
                .expectBody(Person[].class).returnResult().getResponseBody();
        assertThat(people).extracting(Person::getName)
                .contains("Bilbo Baggins", "Gandolph the Grey");
    }

    @Test
    void findsByIdImplicitly() {
        Person person = client.get().uri("/people/1").exchange()
                .expectStatus().isOk()
                .expectBody(Person.class).returnResult().getResponseBody();
        assertThat(person.getName()).isEqualTo("Bilbo Baggins");
    }

    @Test
    void findsByIdentifierExplicitly() {
        Person person = client.get().uri("/people/identifier/2").exchange()
                .expectStatus().isOk()
                .expectBody(Person.class).returnResult().getResponseBody();
        assertThat(person.getName()).isEqualTo("Gandolph the Grey");
    }

    @Test
    void findsByNaturalId() {
        Person person = client.get().uri("/people/natural/{name}", "Bilbo Baggins").exchange()
                .expectStatus().isOk()
                .expectBody(Person.class).returnResult().getResponseBody();
        assertThat(person.getId()).isEqualTo(1);
    }

    @Test
    void findsMultipleByNaturalId() {
        Person[] people = client.post().uri("/people/natural")
                .contentType(MediaType.APPLICATION_JSON)
                .body(List.of("Bilbo Baggins", "Gandolph the Grey"))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Person[].class).returnResult().getResponseBody();
        assertThat(people).extracting(Person::getId).containsExactlyInAnyOrder(1, 2);
    }

    @Test
    void returnsNotFoundForMissingId() {
        client.get().uri("/people/9999").exchange().expectStatus().isNotFound();
    }

    @Test
    void createsAndReadsBack() {
        client.post().uri("/people")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new Person(100, "Samwise Gamgee", "Hobbiton"))
                .exchange()
                .expectStatus().isCreated();

        Person fetched = client.get().uri("/people/natural/{name}", "Samwise Gamgee").exchange()
                .expectStatus().isOk()
                .expectBody(Person.class).returnResult().getResponseBody();
        assertThat(fetched.getId()).isEqualTo(100);
    }
}
