import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.TestTemplate;
import org.testng.Assert;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class TestExternalSystems {
  //  public static final String basePath = "http://backend.dev.tatr.eputs/api/admin";
    String token;

    @Test
    public void getToken(){
        baseURI = "http://backend.dev.tatr.eputs/api/auth/login";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("login", "test1");
        requestParams.put("password", "Qwertyuiop1");

        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());
        Response response = request.post();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        token = response.jsonPath().get("access_token");
    }

    @Test
    public void getExternalSystem(){

    }
}
