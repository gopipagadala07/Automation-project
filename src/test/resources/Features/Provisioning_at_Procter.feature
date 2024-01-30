Feature: Checking the Create Users Functionality

  Scenario Outline: Checking the Creation of Examtaker User
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    And Proctor clicks on Administration tab
    Then Proctor is clicks on Examtaker tab
    And Proctor clicks on Add new button on Examtaker tab
    When Proctor Enter the valid Examtaker details from the given Excel sheet at <RowNumber> and save it
    Then Proctor Enter the Examtaker Details from the given Excel sheet at <RowNumber> in search Textbox
    And Proctor clicks on Edit button on Examtaker tab
    And Proctor clicks on Create new Login button on Add/edit Examtaker pop up
    And Proctor clicks on Reset password button on Add/edit Examtaker pop up
    Then Proctor clicks on Editsave button on Add/edit Examtaker pop up

    Examples: 
      | rownumber |  | RowNumber |
      |         1 |  |         0 |
