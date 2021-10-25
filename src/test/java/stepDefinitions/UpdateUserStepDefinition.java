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
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateUserStepDefinition {
    public static Response response = null;

    @When("^the admin updates the user details$")
    public void the_admin_updates_the_user_details(DataTable arg1) throws Throwable {

        JSONObject jsonObject = (JSONObject) new JSONParser().parse(new FileReader(new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "java" + File.separator + "json" + File.separator + "CreateUser.json")));
        jsonObject.put("name", arg1.raw().get(0).get(1));
        jsonObject.put("job", arg1.raw().get(0).get(2));
        System.out.println(jsonObject.toJSONString());
        response = RestAssured.given().header("Content-Type", "application/json").
                body(jsonObject.toJSONString()).accept(ContentType.JSON).pathParam("user_id", arg1.raw().get(0).get(0)).put("/{user_id}");
    }

    @When("^the admin patches the user details$")
    public void the_admin_patches_the_user_details(DataTable arg1) throws Throwable {
        JSONObject jsonObject = (JSONObject) new JSONParser().parse(new FileReader(new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "java" + File.separator + "json" + File.separator + "CreateUser.json")));
        jsonObject.put("name", arg1.raw().get(0).get(1));
        jsonObject.put("job", arg1.raw().get(0).get(2));
        System.out.println(jsonObject.toJSONString());
        response = RestAssured.given().header("Content-Type", "application/json").
                body(jsonObject.toJSONString()).accept(ContentType.JSON).pathParam("user_id", arg1.raw().get(0).get(0)).patch("/{user_id}");
    }

    @Then("^Validate that the response is valid and new user is updated succesfully$")
    public void validate_that_the_response_is_valid_and_new_user_is_updated_succesfully(DataTable arg1) throws Throwable {
        Assert.assertTrue(response.body().jsonPath().get(ResponseJsonPaths.createUserResponse_name).equals(arg1.raw().get(0).get(0)));
        Assert.assertTrue(response.body().jsonPath().get(ResponseJsonPaths.createUserResponse_job).equals(arg1.raw().get(0).get(1)));
        String updatedDay = response.body().jsonPath().get(ResponseJsonPaths.createUserResponse_updatedAt).toString().substring(0, 10);
        Date objDate = new Date();
        SimpleDateFormat objDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String expectedDate = objDateFormat.format(objDate);
        System.out.println(expectedDate);
        System.out.println(updatedDay);
        Assert.assertTrue(updatedDay.equals(expectedDate));
    }
}
