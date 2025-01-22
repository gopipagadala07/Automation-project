Feature: Verify the Scoring in LT

  Scenario Outline: Provide the Score for all Activities at Speed Grder and Activities to Garde
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    And User Click Courses in Left menu
    Then User Click on Overal Speed Grader
    When User select All lookups in Activities To Grade screen<rownumber1><rownumber2>
    Then provide the score for all Activities
    When User Close Activity to Grade Screen
    #Then User Saved the Course and Search for the Created Course in Search here Field<rownumber1>
    #And User Click on that Course<rownumber1>
    #Then User Provide the Score in Activity To Grade
    #And User go to Learning Tab
    #Then User Provide the Score in Activity Progress screen<rownumber2>
    #
    
    Examples: 
      | rownumber | rownumber1 | rownumber2 |
      |         2 |          0 |          3 |
