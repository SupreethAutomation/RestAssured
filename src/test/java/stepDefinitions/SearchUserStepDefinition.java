package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;
import responseJsonPaths.ResponseJsonPaths;

public class SearchUserStepDefinition implements ResponseJsonPaths {
    public static Response response = null;

    @When("^the user searches for the particular user as parameter$")
    public void the_user_searches_for_the_particular_user_as_parameter(DataTable arg1) throws Throwable {
        response = RestAssured.given().accept(ContentType.JSON).pathParam("user_id", arg1.raw().get(0).get(0)).get("/{user_id}");
    }

    @Then("^Validate that the response is valid and new user is searched succesfully$")
    public void validate_that_the_response_is_valid_and_new_user_is_searched_succesfully(DataTable arg1) throws Throwable {

        Assert.assertTrue(response.body().jsonPath().getString(ResponseJsonPaths.createUserResponseData_id).equals(arg1.raw().get(0).get(0)));
        Assert.assertTrue(response.body().jsonPath().get(ResponseJsonPaths.createUserResponseData_email).equals(arg1.raw().get(0).get(1)));
        Assert.assertTrue(response.body().jsonPath().get(ResponseJsonPaths.createUserResponseData_fn).equals(arg1.raw().get(0).get(2)));
        Assert.assertTrue(response.body().jsonPath().get(ResponseJsonPaths.createUserResponseData_ln).equals(arg1.raw().get(0).get(3)));
        Assert.assertTrue(response.body().jsonPath().get(ResponseJsonPaths.createUserResponseData_avatar).equals(arg1.raw().get(0).get(4)));
        Assert.assertTrue(response.body().jsonPath().get(ResponseJsonPaths.createUserResponseSupport_url).equals(arg1.raw().get(0).get(5)));
        Assert.assertTrue(response.body().jsonPath().get(ResponseJsonPaths.createUserResponseSupport_text).equals(arg1.raw().get(0).get(6)));

    }
}
