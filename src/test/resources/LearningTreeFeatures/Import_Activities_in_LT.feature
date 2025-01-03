Feature: Verify the import of Activities in LT
  

  Scenario Outline: Import of Activities in LT
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    And User Click Courses in Left menu
    #Learing Tree Community Creation
    Then User Click on the Create New Course button
    When User Enter the Course Name and Description
    Then User Saved the Course and Search for the Created Course in Search here Field<rownumber1>
    And User Click on that Course<rownumber1>
    When User Search the Learning Objective and Assign it to the Course<rownumber1>
    And User go to Learning Tab
    Then User Publish and Activate all Activity
		#Validate Learnig Tree Community Creation
		Then Validate the imported Activities 
    Examples: 
      | rownumber | rownumber1 |
      |         2 |          0 |
