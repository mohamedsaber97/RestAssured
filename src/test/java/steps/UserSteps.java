package steps;

import base.TestBase;
import io.cucumber.java.en.When;

public class UserSteps extends TestBase {

    @When("User get his data")
    public void userGetHisData() {
        response = request.queryParam("lang", lang).when().get("GetDataOfUser");
        stringResponse = response.asString();
        statusCode = response.getStatusCode();
    }
}
