package steps;

import base.TestBase;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

import static io.restassured.config.EncoderConfig.encoderConfig;


public class Hocks extends TestBase {

    @Before("@sanity or @smoke")
    public void beforeTest() {
        RestAssured.baseURI = baseUrl;
        request = RestAssured.given();
        request.header("Content-Type", "application/json");
    }

    @Before("@functionality")
    public void beforeFun() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/";
        request = RestAssured.given();
    }

    @Before
    public void beforeReg() {
        RestAssured.baseURI = baseUrl;
        request = RestAssured.given().log().all()
                .config(RestAssured.config()
                        .encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .accept("application/json, text/plain, */*");
        request.header("Authorization", "Bearer");
    }
}
