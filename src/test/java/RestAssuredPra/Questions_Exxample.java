package RestAssuredPra;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Questions_Exxample {


    @Test
    public void GetMethod(){

        // Using the parameter
        HashMap<String,String> param = new HashMap<>();
        param.put("ID","bcwee21d2954426");
        String response = RestAssured.given().baseUri("https://rahulshettyacademy.com").params(param)
                .when().get("/Library/GetBook.php")
                .then().extract().asString();

        // Using the query Parameter
        String response1 = RestAssured.given().baseUri("https://rahulshettyacademy.com").queryParams("ID","bcwee21d2954426")
                .when().get("/Library/GetBook.php")
                .then().extract().asString();

        System.out.println("This is the get response : " + response1);

        //
        String response2 = RestAssured.given().baseUri("https://rahulshettyacademy.com")
                .when().get("/Library/GetBook.php?ID=bcwee21d2954426")
                .then().extract().asString();

        System.out.println("This is the get response : " + response2);
    }



    @Test
    public void authentication(){

        //using the Oauth2
        String response = RestAssured.given().baseUri("https://gorest.co.in").auth().oauth2("d8a3f92f49cc8991933a31574afedcd911913c28c3533da20006941d97407317")
                .body("\t{\n" +
                        "    \"name\": \"Aditya Pawar\",\n" +
                        "    \"email\": \"adityapawar12@yopmail.com\",\n" +
                        "    \"gender\": \"Male\",\n" +
                        "    \"status\": \"Active\"\n" +
                        "    }")
                .when().get("/public/v2/users")
                .then().extract().asString();
        System.out.println("This is response of request  : " + response);

        // using the header
        String response1 = RestAssured.given().baseUri("https://gorest.co.in").header("Authorization","d8a3f92f49cc8991933a31574afedcd911913c28c3533da20006941d97407317")
                .body("\t{\n" +
                        "    \"name\": \"Aditya Pawar\",\n" +
                        "    \"email\": \"adityapawar12@yopmail.com\",\n" +
                        "    \"gender\": \"Male\",\n" +
                        "    \"status\": \"Active\"\n" +
                        "    }")
                .when().get("/public/v2/users")
                .then().extract().asString();
        System.out.println("This is response of request  : " + response1);
    }
}
