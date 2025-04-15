Feature: Consumer Signup api
  Scenario: To test the sent OTP API
    Given Consumer user Send and Verify OTP
    Then Get the Logintoken from the response

  Scenario: To test the Login consumer
    Given Login consumer payload
    When User call "ConsumerLogin" with "POST" http request
    Then Api call "ConsumerLogin" is success and status code 201 OK
    Then Get the Logintoken from the response and save in the excel

  Scenario:






