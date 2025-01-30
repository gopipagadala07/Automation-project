@LearningTreeGroup
Feature: Verify the Student Activities Submission

  Scenario Outline: Student Activities Submission
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    When User Click Learning Tree from Left menu
    Then User Search for the Course in Search here Field<rownumber1>
    And User Click on that CourseName<rownumber1>
    And User go to Learning Tab in community landing page
    Then User Click on Launch button for the All Activities

    Examples: 
      | rownumber | rownumber1 |
      |         3 |          0 |
