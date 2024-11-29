C:\Users\GopiPagadala\OneDrive - FocalPointK12, Inc\FPK12 Automation-2024\FPK12ExamCenter\src\test\resources\Files\ControllerTemplate.xlsx
C:\Users\GopiPagadala\OneDrive - FocalPointK12, Inc\FPK12 Automation-2024\FPK12ExamCenter\src\test\resources\Files\Proctor Template.xlsx
C:\Users\GopiPagadala\OneDrive - FocalPointK12, Inc\FPK12 Automation-2024\FPK12ExamCenter\src\test\resources\Files\Exam Takers Template.xlsx
Feature: Checking the bulk upload functionality for All Users

  Scenario Outline: Testing the Controller Bulk Upload Functionality
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    And User clicks on Administration tab
    Then User clicks on Controller tab
    And Create the Bulk controller users Excel Sheet
    Then Click on controller Bulk Upload Icon and Upload the File

    Examples: 
      | rownumber |
      |         0 |

  Scenario Outline: Testing the proctor Bulk Upload Functionality
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    And User clicks on Administration tab
    Then User is on Proctor tab
    And Create the Bulk Proctor users Excel Sheet
    Then Click on Proctor Bulk Upload Icon and Upload the File

    Examples: 
      | rownumber |
      |         0 |

  Scenario Outline: Testing the Examtaker Bulk Upload Functionality
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    And User clicks on Administration tab
    Then User is on Examtaker tab
    And Create the Bulk Examtaker users Excel Sheet
    Then Click on Examtaker Bulk Upload Icon and Upload the File

    Examples: 
      | rownumber |
      |         0 |
