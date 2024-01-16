Feature: Checking the Create Users Functionality

  Scenario Outline: Checking the Creation of Examtaker User
   Given User launch the application with valid URL
    And User enters the credentials from the given admin excel sheet at <rownumber>
    And User clicks on Administration tab
    Then User is clicks on Examtaker tab
    And User clicks on Add new button on Examtaker tab
    When User Enter the valid Examtaker details from the given Excel sheet at <RowNumber> and save it
    Then User Enter the Examtaker Details from the given Excel sheet at <RowNumber> in search Textbox
    And User clicks on Edit button on Examtaker tab
    And user clicks on Create new Login button on Add/edit Examtaker pop up
    And user clicks on Reset password button on Add/edit Examtaker pop up
    Then User clicks on Editsave button on Add/edit Examtaker pop up

    Examples:
      | rownumber |  | RowNumber |
      |         1 |  |         0 |
