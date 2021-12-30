package base;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestBase {
    public static String baseUrl = "https://wasetalsumaili.ip4s.com/api/v1/";
    public static RequestSpecification request;
    public static Response response;
    public static String stringResponse;
    public static String token;
    public static String msg;
    public static int statusCode;
    public static String lang = "ar";
    public static int code;
    public static String userId;
    public static Map<String, Object> body = new HashMap<>();
    public static Map<String, String> data;
    public static List<Map<String, String>> listData;


    public void printResponse() {
        System.out.println("-----response is : " + stringResponse);
    }

    public void printToken() {
        System.out.println("-----token is : " + token);
    }

    public void printMsg() {
        System.out.println("-----error is : " + msg);
    }
}
