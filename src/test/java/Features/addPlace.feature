Feature: Validating place Api
  @Addplace @Regression
  Scenario Outline: verify the place successfully added using addplace  API
    Given Add Place payload "<name>" "<address>"
    When User call "AddPlaceAPI" with "POST" http request
    Then Api call "AddPlaceAPI" is success and status code 200 OK
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify the place id created maps to "<name>" using "GetPlaceAPI"


    Examples:
      |name|address|
      |adityahouse|chatrapti|
     # |pawars|devnagar|

  @Deleteplace @Regression
  Scenario: Verify if the delete place functionality
    Given  Delete place payload
    When User call "DeletePlaceAPI" with "POST" http request
    And "status" in response body is "OK"

