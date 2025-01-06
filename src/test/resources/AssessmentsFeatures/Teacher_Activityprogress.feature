@AssessmentCenterGroup
Feature: Verify the Activity progress from ToDo List at teacher

  Scenario Outline: Validating the Activity progress screen from AC Home tab
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    When Users Click on Assessment Centre tab under Learning in Left menu
    Then Users clicks on the Assessment Centre Course <rownumber1><rownumber>
    When User click on all Quizzes and navigate back
    Then User click on all benchmarks and navigate back

    Examples: 
      | rownumber | rownumber1 |
      |         2 |          0 |
