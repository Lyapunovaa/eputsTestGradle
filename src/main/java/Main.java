import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jdk.jfr.ContentType;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Main {
    public static void main(String[] args) {

    }

   // public static final String basePath = "http://backend.dev.tatr.eputs/api/admin";


//    public static void getInfoAboutSystem() {
//        long id = 1;
//        given().when().get(basePath).then().log().body();
//    }

//    @Test
//    public void getToken(){
//        baseURI = "http://backend.dev.tatr.eputs/api/auth/login";
//        RequestSpecification request = RestAssured.given();
//
//        JSONObject requestParams = new JSONObject();
//        requestParams.put("login", "test1");
//        requestParams.put("password", "Qwertyuiop1");
//
//        request.header("Content-Type", "application/json");
//        request.body(requestParams.toJSONString());
//        Response response = request.post();
//
//        int statusCode = response.getStatusCode();
//        Assert.assertEquals(statusCode, "200");
//        String token = response.jsonPath().get("access_token");
//
//        System.out.println(token);
//    }
}
