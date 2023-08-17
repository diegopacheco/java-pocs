package com.github.diegopacheco.java.quarkus.qute;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
public class HelloResourceTest {

    @Test
    public void testEndpoint() {
        given()
                .when().get("/hello/")
                .then()
                .statusCode(200)
                .body(containsString("Hello"), containsString("world!"));
    }

}
