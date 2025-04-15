Feature: Test the buy and sell project creation

#  Scenario Outline: To create the buy and sell project
#    Given Payload for the buy and sell project "<projectname>"
#    When User call "BuyandSellCreateProject" with "POST" http request
#    Then verify the project is created with same name
#
#    Examples:
#      | projectname         |
#      | Project Alpha       |
#      | Project Beta        |
#      | Project Gamma       |
#      | Solar Initiative    |
#      | Wind Power Project  |

    Scenario: To check the list of project
      Given Payload for project listing
      When User call "MyProjectList" with "POST" http request
      Then Verify that getting projects


#    Scenario: To check the list of project
#      Given Payload for project details
#      When User call "ProjectDetail" with "POST" http request
#      Then Verify that getting projects

