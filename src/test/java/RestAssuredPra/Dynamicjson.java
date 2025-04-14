package RestAssuredPra;

import Files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class Dynamicjson {

    @Test(dataProvider = "Booksdata")
    public void addBook(String asle, String isbn){
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().header("Content-Type","text/plain")
                .body(Payload.Addbook(asle,isbn))
                .when().post("/Library/Addbook.php")
                .then().assertThat().log().all().statusCode(200).extract().response().asString();
        JsonPath js = new JsonPath(response);
        String ID = js.getString("ID");
        System.out.println("Extracted Book id is ; " + ID);

    }

    @DataProvider(name="Booksdata")
    public Object[][] getData(){
        // array  = collection of elements
        // multidimensional array = collection of arrays
        // new object[] this is the array and new object[][] this is the multidimensional array
        // syntex is  new object [][]{ {arr1},{arr2}, {arr3}}

        return new Object[][]{
                {"3524534324","sfsdfsdf"},
                {"34256423","sdva56dvsdvc"},
                {"342454533","scescsfhgdfs"}
        };
    }
    @Test
    public void JsonPayloadFile() throws IOException {

        // body method accept string
        // In body : Content of file to String --> content of file convert into SByte --> Byte data to String
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().log().all().header("Content-Type","text/plain")
                .body(new String(Files.readAllBytes(Paths.get("src/main/java/Files/addbook.json"))))
                .when().post("/Library/Addbook.php")
                .then().assertThat().log().all().statusCode(200).extract().response().asString();
        JsonPath jspath = new JsonPath(response);
        System.out.println(jspath.get("ID").toString());  //


    }
}

