Feature: Validating place Api
  Scenario Outline: verify the place successfully added using addplace  API
    Given Add Place payload "<name>" "<address>"
    When User call "AddplaceAPI" with post http request
    Then  Api call is success and status code 200 OK
    And "status" in response body is "OK"
    And "scope" in response body is "APP"


    When User call "DeleteAPI" with post http request


    Examples:
      |name|address|
      |adityahouse|chatrapti|
      |pawars|devnagar|
