Feature: Verify the Scoring in LT

  Scenario Outline: Provide the Score for all Activities at Speed Grder and Activities to Garde
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    And User Click Courses in Left menu
    Then User Click on Overal Speed Grader
    When User select All lookups in Activities To Grade screen
    Then provide the score for all Activities


    Examples: 
      | rownumber | rownumber1 | rownumber2 |
      |         2 |          0 |          3 |
