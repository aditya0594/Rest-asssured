Feature: Consumer Signup api
  Scenario: To test the sent OTP API
    Given Sent otp payload
    When User call "SentOTP" with "POST" http request
    Then Api call "SentOTP" is success and status code 200 OK
    And Get the generate OTP from the response
#    And "status" in response body is "OK"
#    And "scope" in response body is "APP"
#    And verify the place id created maps to "<name>" using "GetPlaceAPI"
  Scenario: To test the Verify OTP API
    Given Sent otp payload
    When User call "SentOTP" with "POST" http request
    Then Api call "SentOTP" is success and status code 200 OK
    And Get the generate OTP from the response