Feature: Performing Exam at student side

  Scenario Outline: Submitting Exam
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    Then user clicks on Learning and assessment center
    Then user clicks on the classroom name <rownumber1> <rownumber2>
    Then user clicks on benchmarks tab
    And User will launch and submit all Exams

    Examples: 
      | rownumber | rownumber1 | rownumber2 |
      |         3 |          0 |          2 |
