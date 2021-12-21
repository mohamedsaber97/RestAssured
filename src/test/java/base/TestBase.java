package base;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class TestBase {
    public static String baseUrl = "https://reqres.in/api/";
    public static RequestSpecification request;
    public static String token;
    public static String error;
    public static Response response;
    public static String stringResponse;
    public static int status;
    public static Map<String, Object> body = new HashMap<>();


    public void printResponse() {
        System.out.println("-----response is : " + stringResponse);
    }

    public void printToken() {
        System.out.println("-----token is : " + token);
    }

    public void printError() {
        System.out.println("-----error is : " + error);
    }
}
