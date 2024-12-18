Feature: Checking the Examcenter Login Functionality

  Scenario Outline: Examcenter login test with valid credentials scenario
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage

    Examples: 
      | rownumber |
      |         0 |
      #|         2 |
      #|         3 |
