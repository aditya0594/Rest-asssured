package RestAssuredTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class POST_request {
    @Test
    public void Addapi(){

            String bodystr = "{\n" +
                    "    \"location\": {\n" +
                    "        \"lat\": -38.383494,\n" +
                    "        \"lng\": 33.427362\n" +
                    "    },\n" +
                    "    \"accuracy\": 50,\n" +
                    "    \"name\": \"Frontline house\",\n" +
                    "    \"phone_number\": \"(+91) 983 893 3937\",\n" +
                    "    \"address\": \"29, side layout, cohen 09\",\n" +
                    "    \"types\": [\n" +
                    "        \"shoe park\",\n" +
                    "        \"shop\"\n" +
                    "    ],\n" +
                    "    \"website\": \"http://google.com\",\n" +
                    "    \"language\": \"French-IN\"\n" +
                    "}";
            RestAssured.baseURI ="https://rahulshettyacademy.com";

            RestAssured.given().log().all().queryParam("Key","=qaclick123").header("Content-Type","application/json")
                    .body(bodystr)
                    .when().post("/maps/api/place/add/json")
                    .then().log().all().assertThat().statusCode(200);

        }

    }