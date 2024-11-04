package Resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {
    public static RequestSpecification requestspec;
    public RequestSpecification requestspecification() throws IOException {

        if(requestspec == null) {
            // here this printStream is a object which asking for the lRequestLoggingFilter.logRequestTo()
            PrintStream log = new PrintStream(new FileOutputStream("Logging.txt")); // here we are creating the file of logs
            requestspec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                    //.addQueryParam("Key", "qaclick123")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))//this is for the logs in the text file
                    .setContentType(ContentType.JSON).build();
            return requestspec;
        }
        return requestspec;
    }
    public static String properties(String key) throws IOException {
        Properties pro = new Properties();
        FileInputStream fis = new FileInputStream("src/test/java/Resources/global.properties");
        pro.load(fis);
        return pro.get(key).toString();

    }
    public String getJsonPath(String response, String key){
        String resp = response.toString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }



}
