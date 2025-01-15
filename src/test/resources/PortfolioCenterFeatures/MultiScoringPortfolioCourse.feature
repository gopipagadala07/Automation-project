@PortfolioCenterGroup
Feature: Checking the Multi Scoring Portfolio Center Course Functionality

  Scenario Outline: Verifying the Multi Scoring Portfolio Center Course Functionality
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    Then the user clicks on Learning and Portfolio Center
    And the user creates a Multi Scoring Portfolio Course by entering the Title and Description
    Then the user searches for the Multi Scoring Portfolio Course and clicks on it <rownumber1>
    And the user clicks on the Add Portfolio Assignment button
    Then the user enters the Assignment Name, Description, and Add Multi Standards <rownumber1> <rownumber1> <rownumber1>
    And the user added the Badge
    Then the user clicks on the Save button
    And the user navigates to the Members tab, searches for the username in the Search Here field using row <rownumber2>
    And assign the user to the assignment
    Then the user navigates to the Portfolio tab,

    Examples: 
      | rownumber | rownumber1 | rownumber2 |
      |         1 |          0 |          3 |
