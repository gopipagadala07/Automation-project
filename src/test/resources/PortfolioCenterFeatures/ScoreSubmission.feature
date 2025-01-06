Feature: Verify the Score Submission Functionality at Admin side

  Scenario Outline: Verify the Score Submission Functionality at Admin side
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    Then the user clicks on Learning and Portfolio Center
    Then the user searches for the course and clicks on it <rownumber1>
    And the user clicks on the assignment then click on Score Student Portfolio button <rownumber1>
    Then Enter the Score and Comments and submit the Score <rownumber1>
    Then the user is awarded the Badge
    And the user clicks on the Assignment and validates the Status and Performance Report.
    Then the user clicks on the Report Card tab and validates the Score in the Report Card <rownumber1>

    Examples: 
      | rownumber | rownumber1 |
      |         1 |          0 |


