package Files;

public class Payload {
    public static String AddPlace() {
        return "{\n" +
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
    }

    public static String jiraIssue(String issueName) {
        return "{\n" +
                "    \"fields\": {\n" +
                "        \"project\": {\n" +
                "            \"key\": \"TR\"\n" +
                "        },\n" +
                "        \"summary\": \"" + issueName + "\",\n" +
                "        \"description\": {\n" +
                "            \"type\": \"doc\",\n" +
                "            \"version\": 1,\n" +
                "            \"content\": [\n" +
                "                {\n" +
                "                    \"type\": \"paragraph\",\n" +
                "                    \"content\": [\n" +
                "                        {\n" +
                "                            \"type\": \"text\",\n" +
                "                            \"text\": \"Creating issue type names using the REST API\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        \"issuetype\": {\n" +
                "            \"name\": \"Bug\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
    }

    public static String CoursePrice() {

        return "{\r\n" +
                "  \"dashboard\": {\r\n" +
                "    \"purchaseAmount\": 1162,\r\n" +
                "    \"website\": \"rahulshettyacademy.com\"\r\n" +
                "  },\r\n" +
                "  \"courses\": [\r\n" +
                "    {\r\n" +
                "      \"title\": \"Selenium Python\",\r\n" +
                "      \"price\": 50,\r\n" +
                "      \"copies\": 6\r\n" +
                "    },\r\n" +
                "    {\r\n" +
                "      \"title\": \"Cypress\",\r\n" +
                "      \"price\": 40,\r\n" +
                "      \"copies\": 4\r\n" +
                "    },\r\n" +
                "    {\r\n" +
                "      \"title\": \"RPA\",\r\n" +
                "      \"price\": 45,\r\n" +
                "      \"copies\": 10\r\n" +
                "    },\r\n" +
                "     {\r\n" +
                "      \"title\": \"Appium\",\r\n" +
                "      \"price\": 36,\r\n" +
                "      \"copies\": 7\r\n" +
                "    }\r\n" +
                "    \r\n" +
                "    \r\n" +
                "    \r\n" +
                "  ]\r\n" +
                "}\r\n" +
                "";

    }

    public static String Addbook(String aisle,String isbn ){
        String payload = "{\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\""+isbn+"\",\n" +
                "\"aisle\":\""+aisle+"\",\n" +
                "\"author\":\"John foer\"\n" +
                "}\n";
                return payload;
    }

}



/**
 {

 "dashboard": {

 "purchaseAmount": 910,

 "website": "rahulshettyacademy.com"

 },

 "courses": [

 {

 "title": "Selenium Python",

 "price": 50,

 "copies": 6

 },

 {

 "title": "Cypress",

 "price": 40,

 "copies": 4

 },

 {

 "title": "RPA",

 "price": 45,

 "copies": 10

 }

 ]

 }



 1. Print No of courses returned by API

 2.Print Purchase Amount

 3. Print Title of the first course

 4. Print All course titles and their respective Prices

 5. Print no of copies sold by RPA Course

 6. Verify if Sum of all Course prices matches with Purchase Amount
 */