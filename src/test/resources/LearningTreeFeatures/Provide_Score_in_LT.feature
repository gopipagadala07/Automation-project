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
    Then User Saved the Course and Search for the Created Course in Search here Field<rownumber1>
    And User Click on that Course<rownumber1>
    When User Search the Learning Objective and Assign it to the Course<rownumber1>
    And User go to Learning Tab
    Then User Publish and Activate all the Activities
    And User go to Member Tab
    Then User Search and added the Student in the Course<rownumber2>

    Examples: 
      | rownumber | rownumber1 | rownumber2 |
      |         2 |          0 |          3 |
