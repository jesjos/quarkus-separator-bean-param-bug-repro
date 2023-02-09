package com.paf.hey;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class HelloControllerTest {
    @Test
    void testHello() {
        given().when()
                .get("/hellos?names=foo,bar,baz")
                .then()
                    .statusCode(200)
                    .body(is("Hello foo|bar|baz"));
    }
}
