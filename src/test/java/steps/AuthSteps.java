package steps;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;

public class AuthSteps extends TestBase {
    String email = "eve.holt@reqres.in";
    String password = "pistol";

    @Given("User has valid register data")
    public void userHasValidRegisterData() {
        body.put("email", email);
        body.put("password", password);
    }

    @When("User sends his data")
    public void userSendsHisData() {
        response = request.body(body).post("register");
        stringResponse = response.asString();
    }

    @Then("The token is returned")
    public void theTokenIsReturned() {
        token = JsonPath.from(stringResponse).get("token");
        printResponse();
        printToken();
    }

    @Given("User has {string} and {string}")
    public void userHasAnd(String mail, String pass) {
        body.put("email", mail);
        body.put("password", pass);
    }

    @Then("The error is returned")
    public void theErrorIsReturned() {
        error = JsonPath.from(stringResponse).get("error");
        printError();
    }


}
