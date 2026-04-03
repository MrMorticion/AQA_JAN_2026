package org.prog.session16.page;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class RestLocationTaskTests {

    @Test
    public void testApiCallWithLocation() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://randomuser.me/");
        requestSpecification.basePath("/api/");
        requestSpecification.queryParam("noinfo");
        requestSpecification.queryParam("inc", "gender,name,nat,location");

        Response response = requestSpecification.get();
        response.prettyPrint();

        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);
        validatableResponse.contentType(ContentType.JSON);

        validatableResponse.body("results[0].gender", Matchers.equalTo("female"));
        validatableResponse.body("results[0].location.street.number", Matchers.notNullValue());
        validatableResponse.body("results[0].location.street.name", Matchers.not(Matchers.isEmptyOrNullString()));
    }

    @Test
    public void testApiCallWithLocationShortStyle() {
        RestAssured
                .given()
                .baseUri("https://randomuser.me/")
                .basePath("/api/")
                .queryParam("noinfo")
                .queryParam("inc", "gender,name,nat,location")
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("results[0].gender", Matchers.equalTo("female"))
                .body("results[0].location.street.number", Matchers.notNullValue())
                .body("results[0].location.street.name", Matchers.not(Matchers.isEmptyOrNullString()));
    }
}