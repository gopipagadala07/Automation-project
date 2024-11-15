Feature: Verifying the Quiz Submission Functionality

  Scenario Outline: Checking the Quiz Submission with All type of Questions
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber2>
    And User is on homepage
    When user click on Assessment Center tab in Left menu
    And Search for the Particular Course and click on it <rownumber1><rownumber>
    And Go to Assessments tab
    Then Launch the Quiz and Submit the Quiz

    #And User navigate to inside of the Exam by using begin test button
    #Then Select the Answers for All type of Questions
    #And Submit the Exam
    #Then user click on Close icon
    Examples: 
      | rownumber | rownumber1 | rownumber2 |
      |         2 |          0 |          3 |
