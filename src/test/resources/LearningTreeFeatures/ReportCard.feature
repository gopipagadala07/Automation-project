@LearningTreeGroup
Feature: Verify the Report Card

  Scenario Outline: Verify the Report Card
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    And User Click Courses in Left menu
    Then User Saved the Course and Search for the Created Course in Search here Field<rownumber1>
    And User Click on that Course<rownumber1>
    Then User Click on Report Card Tab
    And User Provide the Comments in Report Card for the Student
    Then User validate the preview of the Activities in the Report card
    And Export the report card and print the Report Table
    
 
    
    Examples: 
      | rownumber | rownumber1 | 
      |         2 |          0 |         
