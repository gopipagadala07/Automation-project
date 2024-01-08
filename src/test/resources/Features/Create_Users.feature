Feature: Checking the Create Users Functionality

  Scenario Outline: Checking the Creation of controller User
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    And User clicks on Administration tab
    Then User clicks on Controller tab
    And User clicks on Add new button on Controller tab
    When User Enter the valid Controller details from the given Excel sheet at <RowNumber1>
    Then User clicks on Save button for controller
    And User Enter the Controller Details from the given Excel sheet at <RowNumber1> in search Textbox
    Then User clicks on Edit button on Controller tab
    And user clicks on Create new Login button on Add/edit controller pop up
    And user clicks on Reset password button on Add/edit controller pop up
    Then User clicks on Editsave button on Add/edit controller pop up

    Examples: 
      | rownumber |  | RowNumber1 |
      |         0 |  |          0 |

  Scenario Outline: Checking the Creation of Proctor User
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    And User clicks on Administration tab
    Then User is on Proctor tab
    And User clicks on Add new button on Proctor tab
    When User Enter the valid Proctor details from the given Excel sheet at <RowNumber2> and save it
    Then User Enter the Proctor Details from the given Excel sheet at <RowNumber2> in search Textbox
    And User clicks on Edit button on Proctor tab
    And user clicks on Create new Login button on Add/edit proctor pop up
    And user clicks on Reset password button on Add/edit proctor pop up
    Then User clicks on Editsave button on Add/edit proctor pop up

    Examples: 
      | rownumber |  | RowNumber2 |
      |         0 |  |          1 |

  Scenario Outline: Checking the Creation of Examtaker User
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    And User clicks on Administration tab
    Given User is on Examtaker tab
    And User clicks on Add new button on Examtaker tab
    When User Enter the valid Examtaker details from the given Excel sheet at <RowNumber3> and save it
    Then User Enter the Examtaker Details from the given Excel sheet at <RowNumber3> in search Textbox
    And User clicks on Edit button on Examtaker tab
    And user clicks on Create new Login button on Add/edit Examtaker pop up
    And user clicks on Reset password button on Add/edit Examtaker pop up
    Then User clicks on Editsave button on Add/edit Examtaker pop up

    Examples: 
      | rownumber |  | RowNumber3 |
      |         0 |  |          2 |
