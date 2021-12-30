package steps;

import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import java.io.File;
import java.util.List;
import java.util.Map;

public class UserSteps extends TestBase {

    File img = new File("assets/8gAMEy.jpg");

    @And("List of users returned")
    public void listOfUsersReturned() {
        response = request.get("users?page=2");
        stringResponse = response.asString();
        printResponse();
        List<Map<String, String>> data = JsonPath.from(stringResponse).get("data");

        Assert.assertTrue(data.size() > 0);
        String email = data.get(0).get("email");
        System.out.println("-----email is : " + email);
    }

    @Given("User has pet id")
    public void userHasPetId() {
        body.put("petId", 10);
        body.put("additionalMetadata", "add data");
    }

    @When("User send pet data")
    public void userSendPetData() {
        response = request.body(body).multiPart(img).post("pet/10/uploadImage");
        stringResponse = response.asString();
    }

    @Then("Response is printed")
    public void responseIsPrinted() {
        printResponse();
    }
}
