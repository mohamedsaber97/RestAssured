package steps;

import base.TestBase;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

import static io.restassured.config.EncoderConfig.encoderConfig;

public class Hocks extends TestBase {

    @Before
    public void beforeAll() {
        RestAssured.baseURI = baseUrl;
        request = RestAssured.given().log().all()
                .config(RestAssured.config()
                        .encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .accept("application/json, text/plain, */*");
    }

    @Before("@auth")
    public void beforeAuth() {
        request.header("Authorization", "Bearer");
    }

    @Before("@user")
    public void beforeUser() {
        request.header("Authorization",
                "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
                        ".eyJzdWIiOiIwMTAwMTAwMTAwNTg1NUB5YWhvby5jb20iLCJ1c2VyX2lkIjoiOWNmMTUyMmQtYjli" +
                        "MC00ZTEyLWJjYjMtMDI4YmQ1MjliMTg1IiwidHlwZV91c2VyIjoiMSIsImV4cCI6MTY3MjQwNTkyNCwiaXNzIjoia" +
                        "HR0cDovL3d3dy5zZWN1cml0eS5vcmciLCJhdWQiOiJodHRwOi8vd3d3LnNlY3VyaXR5Lm9yZyJ9.ulO3DiAbZnuqfa394yU5HxBJr86oD8Pw_gMC0aO6VWw");
    }
}
