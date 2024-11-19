Feature: Validate the Quiz Creation for Teacher

  #Scenario: Checking the Quiz Creation Functionality
    #Given User is On Login Page1
    #When User Enters Valid Login Credentials
    #When user click on Assessment Center tab
    #And Search for the Particular Course and click on it
    #And Go to Assessments tab
#Then Create Child Objective by Click on Root Goal Level Ellipses
#And Click on Add new Quiz by click on Goal Level Ellipses
#Then Add any test to the Quiz
#And Enter the Name,Description,Instruction
#Then Select the Start Date and Due Date by using Date Picker icon
#And Handling the Show Answers,Is Override Instructions,Show Test Summary,Show Test Analytics toggles

  Scenario Outline: Checking the Quiz Creation Functionality
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    When user click on Assessment Center tab in Left menu
    And Search for the Particular Course and click on it <rownumber1><rownumber>
    And Go to Assessments tab
    Then Create Child Objective by Click on Root Goal Level Ellipses
    And Click on Add new Quiz by click on Goal Level Ellipses
    Then Add any test to the Quiz <rownumber1>
    And Enter the Name,Description,Instruction
    Then Select the Start Date and Due Date by using Date Picker icon
    And Handling the Show Answers,Is Override Instructions,Show Test Summary,Show Test Analytics toggles
    Then User navigates to Badge tab
    And user added a Badge
    Then User Click on Save button for saving the Quiz
    When User enable the publish toggle at Quiz Level
    Then User Navigate to Activity Progress Screen by click on ellipses
    And Compare the Start Date and due Dates in Activity Progress Screen with Tree dates
    Then Validate the Test tokens with Students data

    Examples: 
      | rownumber | rownumber1 |
      |         2 |          0 |
