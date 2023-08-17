package com.github.diegopacheco.java.quarkus.qute;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
public class ItemsResourceTest {

    @Test
    public void testEndpoint() {
        given()
                .when().get("/items")
                .then()
                .statusCode(200)
                .body(containsString("Apple:"), containsString("<del>30</del> <strong>27.0</strong>"));
    }

}
