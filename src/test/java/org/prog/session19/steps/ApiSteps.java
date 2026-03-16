package org.prog.session19.steps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.prog.session16.dto.ResultsDto;
import org.prog.session19.DataHolder;

public class ApiSteps {

    @Given("I request {int} random people from service as {string}")
    public void requestPeopleFromService(int number, String alias) {
        ResultsDto results = RestAssured
                .given()
                .baseUri("https://randomuser.me/")
                .basePath("/api/")
                .queryParam("noinfo")
                .queryParam("inc", "gender,name,nat")
                .queryParam("results", number)
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .as(ResultsDto.class);
        DataHolder.data.put(alias, results);
    }
}
