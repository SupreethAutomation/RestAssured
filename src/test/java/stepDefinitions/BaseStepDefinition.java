package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import responseJsonPaths.ResponseJsonPaths;

public class BaseStepDefinition implements ResponseJsonPaths {
    Response objResponse = null;

    @Given("^the api is successfully running$")
    public void the_api_is_successfully_running(DataTable data) throws Throwable {
        RestAssured.basePath = data.raw().get(0).get(0);
        Assert.assertTrue(RestAssured.get().statusCode() >= 200 || RestAssured.get().statusCode() <= 206, "API not running");
    }

    @Then("^Validate that the response is valid and token is generated succesfully$")
    public void validate_that_the_response_is_valid_and_token_is_generated_succesfully(DataTable arg1) throws Throwable {
        objResponse = RegistrationStepDefinition.response;
        Assert.assertTrue(objResponse.body().jsonPath().get(ResponseJsonPaths.registerResponse_token).equals(arg1.raw().get(0).get(0)));
    }
}
