package Files;

import io.restassured.path.json.JsonPath;

public class ReusableMethod {
    public static JsonPath rawtoJson(String response){
        JsonPath js = new JsonPath(response);
        return js;
    }
}
