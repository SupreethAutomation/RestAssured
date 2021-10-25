package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import responseJsonPaths.ResponseJsonPaths;

import java.io.File;
import java.io.FileReader;

public class CreateUserStepDefinition implements ResponseJsonPaths {
    public static Response response = null;

    @When("^the user creates new Users$")
    public void the_user_creates_new_Users(DataTable arg1) throws Throwable {
        JSONObject jsonObject = (JSONObject) new JSONParser().parse(new FileReader(new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "java" + File.separator + "json" + File.separator + "createUser.json")));
        jsonObject.put("name", arg1.raw().get(0).get(0));
        jsonObject.put("job", arg1.raw().get(0).get(1));
        System.out.println(jsonObject.toJSONString());
        response = RestAssured.given().header("Content-Type", "application/json").
                body(jsonObject.toJSONString()).accept(ContentType.JSON).post();
    }

    @Then("^Validate that the response is valid and new user is created succesfully$")
    public void validate_that_the_response_is_valid_and_new_user_is_created_succesfully(DataTable arg1) throws Throwable {
        Assert.assertTrue(response.body().jsonPath().get(ResponseJsonPaths.createUserResponse_name).equals(arg1.raw().get(0).get(0)));
        Assert.assertTrue(response.body().jsonPath().get(ResponseJsonPaths.createUserResponse_job).equals(arg1.raw().get(0).get(1)));
        Assert.assertTrue(Integer.parseInt((String) response.body().jsonPath().get(ResponseJsonPaths.createUserResponse_id)) > 0);
    }
}
