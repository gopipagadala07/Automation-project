Feature: Checking the Create Users Functionality

  Scenario Outline: Verify the Users Creation Functionality with valid Data
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    And User clicks on Administration tab
    #Controller Creation
    Then User clicks on Controller tab
    And User clicks on Add new button
    When User Enter the valid Controller details <rownumber>
    Then User clicks on Save button
    And User Enter the Controller Name in search Textbox
    Then User clicks on Edit button
    And User clicks on Create new Login button on Add/edit pop up
    And User clicks on Reset password button on Add/edit pop up
    Then User clicks on Save button
    #Proctor Creation
    Then User is on Proctor tab
    Then User clicks on Add new button
    When User Enter the valid Proctor details <rownumber> <RowNumber2>
    Then Uszpo6er clicks on Save button
    And User Enter the Proctor Name in search Textbox
    Then User clicks on Edit button
    And User clicks on Create new Login button on Add/edit pop up
    And User clicks on Reset password button on Add/edit pop up
    Then User clicks on Save button
    #ExamTaker Creation
    And User on Examtaker tab
    Then User clicks on Add new button
    When User Enter the valid Examtaker details <rownumber> <RowNumber3>
    Then User clicks on Save button
    And User Enter the ExamTaker Name in search Textbox
    Then User clicks on Edit button
    And User clicks on Create new Login button on Add/edit pop up
    And User clicks on Reset password button on Add/edit pop up
    Then User clicks on Save button
    Then Store the users data in Excel

    Examples: 
      | rownumber | RowNumber1 | RowNumber2 |  | RowNumber3 |
      |         0 |          1 |          2 |  |          3 |
