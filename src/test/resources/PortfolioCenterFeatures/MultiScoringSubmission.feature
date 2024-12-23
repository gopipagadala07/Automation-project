Feature: Checking the Multi Scoring Portfolio Center Score Submission at Admin side

  Scenario Outline: Verify the Multi Scoring Portfolio Center Score Submission at Admin side
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    Then the user clicks on Learning and Portfolio Center
    Then the user searches for the Multi Scoring Portfolio Course <rownumber1>
    And the user clicks on the Multi Scoring assignment then click on Multi Scoring button <rownumber1>
    Then Enter the Score and submit the Score <rownumber2> <rownumber3> <rownumber4> 
    And the user clicks on the Multi Scoring Assignment and validates the Status and Performance Report.
    

    Examples: 
      | rownumber | rownumber1 | rownumber2 | rownumber3 | rownumber4 |
      |         1 |          0 |          0 |          0 |          0 |
