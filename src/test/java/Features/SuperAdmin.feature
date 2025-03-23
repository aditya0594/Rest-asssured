Feature: Testcase for the Admin Login and Approval for the Consumer users
  Scenario: To test sent the super admin OTP
    Given Super Admin Login credential for otp
    When User call "SuperAdminOTP" with "POST" http request
    Then Api response success and status code 200
    And Get the generate OTP from the response from the response

  Scenario: To test the Verify super admin OTP
    Given Super Admin login credential for verify otp
    When User call "SuperAdminVerifyOTP" with "POST" http request
    Then Api response success and status code 200
    And Get the AdminToken from the response

  Scenario: To test login of super admin
    Given Super Admin login credential
    When User call "SuperAdminLogin" with "POST" http request
    Then Get the AdminToken from the response and stored on the excel

