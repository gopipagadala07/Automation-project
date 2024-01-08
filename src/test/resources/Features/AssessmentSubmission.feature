Feature: Checking the Examtaker Assessment Submission

  Scenario Outline: Checking the Examcenter Examtaker Assessment Submission Functionality
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    Then Search for particular exam and Click on it <rownumber>
    And Clicks on Launch button
    Then Enter the valid Invigilatory Token <rownumber>
    And clicks on begin test
    Then Select all Answers
    And submit the Exam
    Then capture the status band
    Then Logout from the Application

    Examples: 
      | rownumber |
      |         2 |
