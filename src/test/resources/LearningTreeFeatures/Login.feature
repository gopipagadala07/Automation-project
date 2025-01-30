@LearningTreeGroup
Feature: Checking the Login Functionality

  Scenario Outline: Login test with valid credentials scenario
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage

    Examples: 
      | rownumber |
      |         1 |
      |         2 |
      |         3 |
