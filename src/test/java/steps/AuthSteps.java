package steps;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;

public class AuthSteps extends TestBase {

    @Given("User has valid register data")
    public void userHasValidRegisterData() {
        body.put("userName", "saber2");
        body.put("phone", "0200000000");
        body.put("InvitationCode", "123456789");
        body.put("password", "123456");
        body.put("deviceId", "1");
        body.put("deviceType", "android");
        body.put("projectName", "khadamialeisi");
        body.put("lang", lang);
    }

    @When("User sends his data")
    public void userSendsHisData() {
        response = request.post("RegisterClient");
        stringResponse = response.asString();
        data = JsonPath.from(stringResponse).get("data");
    }

    @Given("User has {string} and {string}")
    public void userHasAnd(String phone, String pass) {
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
    }

    @Then("The response is returned and user saves userId and activation code")
    public void theResponseIsReturnedAndUserSavesUserIdAndActivationCode() {
        if (statusCode == 200) {
            userId = JsonPath.from(stringResponse).get("id");
            code = JsonPath.from(stringResponse).get("code");
            token = JsonPath.from(stringResponse).get("token");
            System.out.println("-----userId is : " + userId);
            System.out.println("-----code is : " + code);
            printToken();
        } else {
            printResponse();
        }
    }

}
