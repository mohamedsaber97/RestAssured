package steps;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;

import java.io.File;

public class AuthSteps extends TestBase {

    File img = new File("assets/8gAMEy.jpg");

    @Given("User has valid register data")
    public void userHasValidRegisterData() {
        body.put("userName", "saber2");
        body.put("phone", "0100100101");
        body.put("password", "123456");
        body.put("deviceId", "1");
        body.put("deviceType", "android");
        body.put("projectName", "wasetalsumaili");
        body.put("lang", lang);
        body.put("Lat", "33.123");
        body.put("Lng", "32.123");
        body.put("Location", "elmansoura - istad");
    }

    @When("User sends his register data")
    public void userSendsHisRegisterData() {
        response = request.formParams(body).multiPart(img).when().post("RegisterClient");
        stringResponse = response.asString();
        statusCode = response.getStatusCode();
    }

    @Given("User has {string} and {string} to login")
    public void userHasAndToLogin(String phone, String pass) {
        body.put("phone", phone);
        body.put("password", pass);
        body.put("lang", lang);
        body.put("deviceType", "android");
        body.put("deviceId", "1");
        body.put("typeUser", 1);
        body.put("projectName", "wasetalsumaili");
    }

    @When("User sends his login data")
    public void userSendsHisLoginData() {
        response = request.formParams(body).when().post("login");
        stringResponse = response.asString();
        statusCode = response.getStatusCode();
        token = "Bearer " + JsonPath.from(stringResponse).get("token");
        printToken();
    }


}
