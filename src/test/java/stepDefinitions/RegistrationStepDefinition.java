package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;

public class RegistrationStepDefinition {
    public static Response response = null;

    @When("^user registers with the email and password$")
    public void user_registers_with_the_email_and_password(DataTable arg1) throws Throwable {
        JSONObject jsonObject = (JSONObject) new JSONParser().parse(new FileReader(new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "java" + File.separator + "json" + File.separator + "register.json")));
        jsonObject.put("email", arg1.raw().get(0).get(0));
        jsonObject.put("password", arg1.raw().get(0).get(1));
        System.out.println(jsonObject.toJSONString());
        response = RestAssured.given().header("Content-Type", "application/json").
                body(jsonObject.toJSONString()).accept(ContentType.JSON).post();
    }

}
