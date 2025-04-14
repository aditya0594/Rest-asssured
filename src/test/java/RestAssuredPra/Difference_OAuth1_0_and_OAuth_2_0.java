package RestAssuredPra;

public class Difference_OAuth1_0_and_OAuth_2_0 {


    /***
     1. Authentication Mechanism & Security Testing
     OAuth 1.0: Uses cryptographic signatures (HMAC-SHA1, RSA-SHA1).
     As a tester, you need to verify if the correct signature is generated,
     ensure the request is properly signed, and check for replay attacks.


     OAuth 2.0: Uses Bearer tokens. You need to test token expiration, token leakage risks,
     and whether the API properly enforces token validation. Since OAuth 2.0 relies on HTTPS,
     you should validate secure transmission (TLS).



     What is the content type in OAuth 2.0?
     The content type in OAuth 2.0 is typically application/json when dealing with JSON payloads.
     However, it can also be application/x-www-form-urlencoded
     when sending data in the body of a POST request, especially during the token exchange process.



     */
}
