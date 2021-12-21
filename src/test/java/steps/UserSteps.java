package steps;

import base.TestBase;
import io.cucumber.java.en.And;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class UserSteps extends TestBase {

    @And("List of users returned")
    public void listOfUsersReturned() {
        response = request.get("users?page=2");
        stringResponse = response.asString();
        printResponse();
        List<Map<String, String>> data = JsonPath.from(stringResponse).get("data");
        status = response.getStatusCode();
        Assert.assertTrue(data.size() > 0);
        Assert.assertEquals(status, 200);
        String email = data.get(0).get("email");
        System.out.println("-----email is : " + email);
    }
}
