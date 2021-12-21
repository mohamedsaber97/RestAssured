package steps;

import base.TestBase;
import io.cucumber.java.Before;
import io.restassured.RestAssured;


public class Hocks extends TestBase {

    @Before
    public void beforeTest() {
        RestAssured.baseURI = baseUrl;
        request = RestAssured.given();
        request.header("Content-Type", "application/json");
    }

}
