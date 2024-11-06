Feature: Verify the Quiz Submission at Student side

  Scenario: Validating the Quiz Submission Functionality at Student side
    #Given User is On Login Page1
    #And User Enters Valid Login Credentials
    When Search for particular Assessment Center Community and Click on it
    Then Go to Quiz Tab and Launch the Quiz
    And clicks on begin test
    Then Select and Enter all Answers
    And submit the Exam
    Then capture the status band
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
