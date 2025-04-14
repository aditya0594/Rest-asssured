Feature: Test the buy and sell project creation

  Scenario: to create the buy and sell project
    Given Payload for the buy and sell project
    When User call "BuyandSellCreateProject" with "POST" http request
    Then verify the project is created with same name

