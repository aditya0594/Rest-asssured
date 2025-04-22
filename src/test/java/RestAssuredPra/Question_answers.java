package RestAssuredPra;

public class Question_answers {
    /***
     What strategies do you use for debugging failed Rest Assured tests?

     For debugging failed Rest Assured tests, we enable request/response
     logging to capture details and isolate failing tests to run them separately for better analysis.
     Enable Logs: Request/response logging.
     Isolate Tests: Run failing tests separately.

     1. What is Rest Assured, and why is it used?
     Rest Assured is a Java library used for RESTful API testing by simplifying HTTP requests and response validations.
     It integrates with testing frameworks like JUnit and TestNG,
     supporting various authentication methods and content types.
     This versatility ensures efficient and reliable API testing.


     2. How do you add Rest Assured to your project?
     To add Rest Assured to your project, include the dependency in your pom.xml file for Maven.
     This allows you to use Rest Assured for API testing in your project.

     3.Explain the main components of a Rest Assured test script.
     A Rest Assured test script typically includes:

     Request Specification:    Defines the setup for the HTTP request, including the base URL, headers, parameters,
     and authentication details.

     Response:     Captures the response returned by the server after executing the HTTP request,
     allowing access to various aspects such as status codes, headers, and body content.

     Assertions:   Validates the response to ensure it meets the expected criteria,
     such as correct status codes, response times, header values, and content within the response body.

     4. what is the difference between the put and  patch http method

     Both PUT and PATCH are HTTP methods used to update resources on the server, but they differ in how they perform updates.

     PUT – Full Update (Replace)
     Replaces the entire resource with the new data.
     If any field is missing in the request body, it might be removed or reset to default.

     PATCH – Partial Update
     Updates only the specified fields in the resource.
     Other fields are left unchanged.

    5. What is the HEAD, and OPTIONS methods

     HEAD – Just the Headers, No Body
     Like a GET request, but it only returns the headers, not the response body.
     Useful for:
     Checking if a resource exists.
     Checking last-modified, content-length, content-type, etc.

     OPTIONS – What Can I Do Here?
     Returns the allowed HTTP methods and other server capabilities for a given URL or server.
     Helps clients understand what methods are supported (like GET, POST, PUT, etc.)


     6. What is the difference between given(), when(), and then() in Rest Assured?
     1. given(): Used to set up the request by defining preconditions like headers, parameters, cookies, body, or authentication.
     2. when(): Specifies the action, such as triggering the HTTP method (GET, POST, PUT, DELETE) on a specific endpoint.
     3. then(): Validates the response by performing assertions on the status code, headers, body, or other response attributes.


     7. What is the role of baseURI and basePath in Rest Assured?
     In Rest Assured, baseURI specifies the base URL, while basePath defines the endpoint path to be appended to the base URL.

     baseURI: Specifies the base URL.
     basePath: Defines the endpoint path.
     RestAssured.baseURI = "https://api.example.com";

     RestAssured.basePath = "/v1/users";


     8.  How do you set headers in a Rest Assured request?
     We can set headers in a Rest Assured request using .header("HeaderName", "HeaderValue") to add custom headers.
     Example: given().header("Authorization", "Bearer token");


     9. What is the use of RequestSpecification in Rest Assured?
     RequestSpecification in Rest Assured is used to define reusable request setups,
     such as base URI, headers, authentication, or query parameters, which can be applied across multiple tests.
     This reduces redundancy, improves maintainability, and enhances the efficiency of API testing projects.
     */




}
