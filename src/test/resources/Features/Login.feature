Feature: Checking the Examcenter Login Functionality

  @Login
  Scenario Outline: Examcenter login test with valid credentials scenario
    Given User launch the application
    And User able to see all Fields
    Then User enters the credentials from the given excel sheet at <rownumber>
    And User is on homepage

    Examples: 
      | rownumber |
      |         0 |
      |         1 |
      |         2 |
