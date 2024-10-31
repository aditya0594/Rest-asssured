package Resources;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {
    RequestSpecification requestspec;
    public RequestSpecification requestspecification() throws IOException {


        // here this printStream is a object which asking for the lRequestLoggingFilter.logRequestTo()
        PrintStream log = new PrintStream(new FileOutputStream("Logging.txt")); // here we are creating the file of logs
        String baseUrl = properties("baseurl").trim();
        System.out.println("this the propertie file value baseuri" + baseUrl);
        requestspec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("Key", "=qaclick123")
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))//this is for the logs in the text file
                .setContentType(ContentType.JSON).build();
        return requestspec;
    }
    public static String properties(String key) throws IOException {
        Properties pro = new Properties();
        FileInputStream fis = new FileInputStream("src/test/java/Resources/global.properties");
        pro.load(fis);
        return pro.get(key).toString();

    }



}
