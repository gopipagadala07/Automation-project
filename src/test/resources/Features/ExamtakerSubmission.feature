 Feature: Checking the Examtaker Assessment Submission

  Scenario Outline: Checking the Examcenter Examtaker Assessment Submission Functionality
    Given Launch the URL for Examtaker
    And Login with Examtaker credentials from excel sheet <RowNumber>
    Then Search for particular exam and Click on it <RowNumber>
    And Clicks on Launch button
    Then Enter the valid Invigilatory Token <RowNumber>
    And clicks on begin test
    Then Select all Answers
    And submit the Exam
    Then capture the status band
    Then Logout from the Application

    Examples: 
      | RowNumber |
      |         2 |
