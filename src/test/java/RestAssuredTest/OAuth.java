package RestAssuredTest;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pojo.Api;
import pojo.GetCourse;

import java.util.List;

public class OAuth {

    public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

        String response = RestAssured.given()
                        .formParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                        .formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
                        .formParams("grant_type", "client_credentials")
                        .formParams("scope", "trust")
                        .when().log().all()
                        .post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();

        System.out.println(response);
        JsonPath jsonPath = new JsonPath(response);
        String accessToken = jsonPath.getString("access_token");
        System.out.println(accessToken);
         GetCourse gc = RestAssured.given()
                .queryParams("access_token", accessToken)
                .when()
                .get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
                        .as(GetCourse.class);
        System.out.println("Linked link for the pojo class " + gc.getLinkedIn());
        System.out.println("Instructor name is : " + gc.getInstructor());

        if (gc != null && gc.getCourses() != null && gc.getCourses().getApi() != null) {
            System.out.println("Course of value according to the Index:  " + gc.getCourses().getApi().get(1).getCourseTitle());
        } else {
            System.out.println("Courses or API list is null or empty.");
        }

        List<Api> listAPI = gc.getCourses().getApi();
        for(int i=0;i<listAPI.size();i++){
            String value = listAPI.get(i).getCourseTitle();
            String price = listAPI.get(i).getPrice();

           if(value.equals("SoapUI Webservices testing")){
               System.out.println("This is the price of search course title : " + price );
            }
        }



    }
}

