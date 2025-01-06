@ExamCenterGroup
Feature: Checking the Examtaker Assessment Submission

  Scenario Outline: Checking the Examcenter Examtaker Assessment Submission Functionality
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    #And User is on homepage
    Then Search for particular exam and Click on it <rownumber1>
    And Clicks on Launch button
    #Then Enter the valid Invigilatory Token <rownumber1>
    Then Perform and Submit the Test
    Then capture the status band
    Examples: 
      | rownumber | rownumber1 |
      |         3 |          0 |
