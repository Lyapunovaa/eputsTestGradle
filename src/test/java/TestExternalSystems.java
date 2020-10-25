import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.testng.Assert;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


class TestExternalSystems {
    //  public static final String basePath = "http://backend.dev.tatr.eputs/api/admin";
    String token;

    @BeforeEach
    void getToken() {
        //это точно работает
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

//    @Test
//    void createExternalSystem() {
//
//        baseURI = "http://backend.dev.tatr.eputs/api/admin/external_system";
//        RequestSpecification request = RestAssured.given();
//
//        //TODO придумать как заполнять JSON не в теле теста.
//        JSONObject requestParams = new JSONObject();
//        requestParams.put("email", "Dark@souls.jp");
//        requestParams.put("full_name", "Dark Souls");
//        requestParams.put("login", "DarkSouls");
//        requestParams.put("name", "Тёмные Души");
//        requestParams.put("contact_person_name", "Арториас Путник Бездны");
//        requestParams.put("password", "Qwertyuiop1");
//        requestParams.put("permissions", "[]");
//
//        request.header("Content-Type", "application/json");
//        request.header("Authorization", "Bearer " + token);
//        request.body(requestParams.toJSONString());
//        Response response = request.post();
//
//        int statusCode = response.getStatusCode();
//        Assert.assertEquals(statusCode, 200);
//
//        //TODO дописать проверку в базе.
//    }

    @Test
    void getListOfExternalSystems() {
        baseURI = "http://backend.dev.tatr.eputs/api/admin/external_system/list";
        RequestSpecification request = RestAssured.given();
        request.baseUri(baseURI);
        JSONObject requestParams = new JSONObject();
        requestParams.put("", "");

        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + token);
        request.body(requestParams.toJSONString());

        Response response = request.post();
        int statusCode = response.getStatusCode();
     //   System.out.println(response.body().peek().toString());
     //   System.out.println("----------------------");
     //   System.out.println(response.body().prettyPeek().toString());
        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(response.body().jsonPath().get("success").toString(), "true");
        //TODO дописать проверку в базе.
    }

    @Test
    void blockAndUnblockSystem() {
        /*TODO по хорошему надо получить список систем методом.
        сравнить их с таблицей.
        заблочить одну
        проверить базу и метод что они заблочены
        разблочить и проверить опять */

    }

    @Test
    void editExternalSystem(){
        //todo убрать хардкод.
        int sysId = 1;
        baseURI = "http://backend.dev.tatr.eputs/api/admin/external_system/" + sysId;
    //TODO дописать редактирование
    }

    @Test
    void getExternalSystem(){
        int sysId = 1;
        baseURI = "http://backend.dev.tatr.eputs/api/admin/external_system/" + sysId;

        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + token);

        Response response = request.get();
        int statusCode = response.getStatusCode();
        System.out.println(response.body().prettyPeek().toString());
        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(response.body().jsonPath().get("success").toString(), "true");
    }


}
