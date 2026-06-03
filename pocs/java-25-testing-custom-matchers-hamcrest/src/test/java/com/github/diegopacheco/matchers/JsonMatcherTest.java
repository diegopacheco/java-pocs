package com.github.diegopacheco.matchers;

import org.junit.jupiter.api.Test;

import static com.github.diegopacheco.matchers.JsonMatcher.hasElement;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

class JsonMatcherTest {

    private static final String JSON = """
            {
              "person": {
                "name": "Diego",
                "age": 40
              }
            }
            """;

    @Test
    void findsTopLevelElement() {
        assertThat(JSON, hasElement("person"));
    }

    @Test
    void findsNestedElement() {
        assertThat(JSON, hasElement("name"));
    }

    @Test
    void doesNotFindMissingElement() {
        assertThat(JSON, not(hasElement("address")));
    }

    @Test
    void doesNotMatchValueAsElement() {
        assertThat(JSON, not(hasElement("Diego")));
    }
}
