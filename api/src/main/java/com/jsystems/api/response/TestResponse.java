package com.jsystems.api.response;

import com.jsystems.api.Specificator;
import com.jsystems.api.models.Person;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TestResponse {

    public static Response responseWithList() {
        return given()
                .spec(Specificator.requestSpecification)
                .when()
                .get("5a6a58222e0000d0377a7789")
                .andReturn();
    }

    public static Response responseWithListByUrl(String url) {
        return RestAssured
                .given()
                .spec(Specificator.requestSpecification)
                .when()
                .get(url)
                .andReturn();
    }

    public static Response responsePost(String url, Person body) {
        return RestAssured
                .given()
                .spec(Specificator.requestSpecification)
                .when()
                .body(body)
                .post(url)
                .andReturn();
    }

    public static Response responseFakeRestApiBook(String url, int id) {
        return RestAssured
                .given()
                .spec(Specificator.requestSpecification)
                .when()
                .get(url, id)
                .andReturn();

    }
}