package com.sharenow.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.CoreMatchers.equalTo;

public class GetSteps {

    ValidatableResponse response = null;
    private static final String TOKEN = "4c4c444c-v123-4123-s123-4c4c444c4c44";
    private static final String VEHICLE_ID = "WDB111111ZZZ22222";
    private static final String BASE_URL = "https://api.mercedes-benz.com/vehicledata_tryout/v2";

    @Then("response status is {int}")
    public void responseStatusIs(int expectedStatus) {
        response.statusCode(expectedStatus);
    }

    @And("{string} value is {string}")
    public void is(String resource, String resourceValue) {
        response.body(resource + ".value", equalTo(resourceValue));
    }

    @And("{string} timestamp is {long}")
    public void timestampIsL(String resource, long timestamp) {
        response.body(resource + ".timestamp", equalTo(timestamp));
    }

    @Given("I perform GET operation on resource {string}")
    public void i_perform_get_operation(String resource) {
        RequestSpecification httpRequest = getRequestSpecification();

        response = httpRequest.
                pathParams("vehicleId", VEHICLE_ID, "resource", resource).
                when().
                request(Method.GET, "/vehicles/{vehicleId}/resources/{resource}").
                then().
                log().body();
    }

    private RequestSpecification getRequestSpecification() {
        RestAssured.baseURI = BASE_URL;

        return RestAssured.given().
                header(new Header("Authorization", "Bearer " + TOKEN)).
                header("Content-Type", "application/json").
                header("charset", "utf-8");
    }

}
