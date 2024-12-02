Feature: Validate the Quiz Creation for Teacher

  Scenario Outline: Checking the Quiz Creation Functionality
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    When user click on Assessment Center tab in Left menu
    And Search for the Particular Course and click on it <rownumber1><rownumber>
    And Go to Assessments tab
    Then Create Child Objectives by Click on Root Goal Level Ellipses
    And Create the Quizzes by using Add new Quiz button<rownumber1>

    #And Compare the Start Date and due Dates in Activity Progress Screen with Tree dates
    #Then Validate the Test tokens with Students data
    Examples: 
      | rownumber | rownumber1 |
      |         2 |          0 |
