Feature: Checking the Portfolio Center Course Functionality

  Scenario Outline: Verifying the Portfolio Course Creation Functionality
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    Then the user clicks on Learning and Portfolio Center
    And the user creates a Portfolio Course by providing a Title and Description.
    Then the user searche for the course and clicks on it <rownumber1>
    And The user clicks on the Edit Portfolio Course button and deletes the Portfolio Course.

    Examples: 
      | rownumber | rownumber1 |
      |         1 |          0 |
