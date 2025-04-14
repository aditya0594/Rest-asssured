package RestAssuredPra;

import Files.Payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class complejson {
     public static void main(String[] args){
         JsonPath js = new JsonPath(Payload.CoursePrice());
         // 1. Print No of courses returned by API

        int count =  js.getInt("courses.size()");
         System.out.println("courses count is : " +count);

         // 2 . Print Purchase Amount
         int purchaseAmount = js.getInt("dashboard.purchaseAmount");
         System.out.println("PurchaseAmount is : " + purchaseAmount);

         // 3. Print Title of the first course

         String FirstCourseTitle = js.get("courses[0].title");
         System.out.println("Title of the first course : " + FirstCourseTitle);

         // Print All course titles and their respective Prices
         for(int i = 0 ; i<count; i++){
             String title = js.get("courses["+i+"].title");
             System.out.println("title is : "+ title);
            int price = js.get("courses["+i+"].price");
             System.out.println("Price is : " + price);
         }

        // 5. Print no of copies sold by RPA Course

         for(int k = 0 ; k<count; k++) {
             String title = js.get("courses[" + k + "].title");
             if (title.equals("RPA")) {
                 int copies = js.get("courses[" + k + "].copies");
                 System.out.println("Copies of the courses is : " + copies);
             }
         }

             int sum =0;
             // 6. Verify if Sum of all Course prices matches with Purchase Amount
            for(int j=0;j<count;j++){
                int price = js.get("courses["+j+"].price");
                int copies = js.get("courses[" + j + "].copies");
                sum = sum + price * copies;

            }
         System.out.println("final calculated value is : " + sum);
         Assert.assertEquals(sum,purchaseAmount);
     }
}
