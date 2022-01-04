package steps;

import base.TestBase;
import io.cucumber.java.en.Then;

public class SharedSteps extends TestBase {

    @Then("The response and data are returned")
    public void theResponseAndDataAreReturned() {
        if (statusCode == 200) {
            printResponse();
        } else {
            printStatusCode();
            printResponse();
        }
    }

}
