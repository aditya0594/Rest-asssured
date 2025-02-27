package RestAssuredTest;

import Files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import java.io.File;
public class jira_issue {
    static String issueID;
    @Test
    public void jireIssue(){
        RestAssured.baseURI = "https://adityapawar180.atlassian.net/";

        String response = RestAssured.given().log().all().header("Content-Type","application/json").header("Authorization","Basic YWRpdHlhcGF3YXIxODBAZ21haWwuY29tOkFUQVRUM3hGZkdGMEJoUDU3ZDRjNHY2cjA4M3A4ZU1XUWhZUUdmTzl2R0JFb1J5TndVMjdUQWRGLXRHN05YZVZ5V1pCdDJGdXpjd2FpbHNkSW1ieUtPaDBoMmplSHRJdTM4RDBoLV9QWjE1RDg2a3pfMEdGc3ZEaGJ0Y1B3eGo4akp5Wm5BOUxDZVNPc0JvUUcxYjV5RkkwVnF6c21BclFQVzNjcEs0TzRabTFIdXdhME1PR21NRT1DNTgxRDhGNQ==")
                .body(Payload.jiraIssue("2"))
                .when().post("rest/api/3/issue")
                .then().assertThat().statusCode(201)
                .extract().response().asString();
        JsonPath js = new JsonPath(response);
        issueID = js.getString("id");
        System.out.println(issueID);

    }
    @Test
    public void issueAttachmentAdd() {
        RestAssured.baseURI = "https://adityapawar180.atlassian.net/";
        RestAssured.given().log().all().header("Authorization","Basic YWRpdHlhcGF3YXIxODBAZ21haWwuY29tOkFUQVRUM3hGZkdGMEJoUDU3ZDRjNHY2cjA4M3A4ZU1XUWhZUUdmTzl2R0JFb1J5TndVMjdUQWRGLXRHN05YZVZ5V1pCdDJGdXpjd2FpbHNkSW1ieUtPaDBoMmplSHRJdTM4RDBoLV9QWjE1RDg2a3pfMEdGc3ZEaGJ0Y1B3eGo4akp5Wm5BOUxDZVNPc0JvUUcxYjV5RkkwVnF6c21BclFQVzNjcEs0TzRabTFIdXdhME1PR21NRT1DNTgxRDhGNQ==")
                .header("X-Atlassian-Token","no-check")
                .multiPart("file",new File("D:\\eclipse-workspace\\RestAssured\\logs\\Files\\code6.txt"))
                .when().post("rest/api/3/issue/"+issueID+"/attachments")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();
    }
}

