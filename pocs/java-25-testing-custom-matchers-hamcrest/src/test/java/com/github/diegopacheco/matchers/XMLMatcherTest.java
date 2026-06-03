package com.github.diegopacheco.matchers;

import org.junit.jupiter.api.Test;

import static com.github.diegopacheco.matchers.XMLMatcher.hasElement;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

class XMLMatcherTest {

    private static final String XML = """
            <people>
              <person>
                <name>Diego</name>
              </person>
            </people>
            """;

    @Test
    void findsRootElement() {
        assertThat(XML, hasElement("people"));
    }

    @Test
    void findsNestedElement() {
        assertThat(XML, hasElement("person"));
    }

    @Test
    void doesNotFindMissingElement() {
        assertThat(XML, not(hasElement("address")));
    }
}
