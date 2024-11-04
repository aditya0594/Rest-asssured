Feature: Validating place Api
  Scenario Outline: verify the place successfully added using addplace  API
    Given Add Place payload "<name>" "<address>"
    When User call "AddPlaceAPI" with "POST" http request
    Then  Api call is success and status code 200 OK
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify the place id created maps to "<name>" using "GetPlaceAPI"


    Examples:
      |name|address|
      |adityahouse|chatrapti|
     # |pawars|devnagar|
