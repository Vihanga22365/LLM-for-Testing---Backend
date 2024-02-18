package com.research.citi.employeemanagement.cucumberglue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class CucumberStepDefinition {

    private String apiEndpoint;
    private String httpMethod;
    private String mandatoryHeaderParams;
    private String nonMandatoryHeaderParams;
    private String mandatoryRequestPayloadParams;
    private String nonMandatoryRequestPayloadParams;
    private Response response;

    @Given("I have set the API endpoint to {string}")
    public void setApiEndpoint(String apiEndpoint) {
        this.apiEndpoint = apiEndpoint;
    }

    @Given("I have set the HTTP method to {string}")
    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    @Given("I have set the mandatory header parameters to {string}")
    public void setMandatoryHeaderParams(String mandatoryHeaderParams) {
        this.mandatoryHeaderParams = mandatoryHeaderParams;
    }

    @Given("I have set the non-mandatory header parameters to {string}")
    public void setNonMandatoryHeaderParams(String nonMandatoryHeaderParams) {
        this.nonMandatoryHeaderParams = nonMandatoryHeaderParams;
    }

    @Given("I have set the mandatory request payload parameters to {string}")
    public void setMandatoryRequestPayloadParams(String mandatoryRequestPayloadParams) {
        this.mandatoryRequestPayloadParams = mandatoryRequestPayloadParams;
    }

    @Given("I have set the non-mandatory request payload parameters to {string}")
    public void setNonMandatoryRequestPayloadParams(String nonMandatoryRequestPayloadParams) {
        this.nonMandatoryRequestPayloadParams = nonMandatoryRequestPayloadParams;
    }

    @When("I make a request to schedule a meeting")
    public void makeRequestToScheduleMeeting() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("countryCode", "US");
        request.header("businessCode", "GCB");
        request.header("uuid", "123456");
        request.body("{ " + mandatoryRequestPayloadParams + ", " + nonMandatoryRequestPayloadParams + " }");
        response = request.post(apiEndpoint);
    }

    @Then("the response status code should be {int}")
    public void verifyResponseStatusCode(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
    }

    @Then("the response message should be {string}")
    public void verifyResponseMessage(String expectedResponseMessage) {
        String actualResponseMessage = response.getBody().asString();
        Assert.assertEquals(expectedResponseMessage, actualResponseMessage);
    }
}
