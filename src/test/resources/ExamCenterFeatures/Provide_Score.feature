Feature: Checking the Examtaker Assessment Scoring Submission

  Scenario Outline: Provide the Score at Controller side
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber1>
    And User is on homepage
    And User clicks on Administration tab
    Then User clicks on Controller tab
    And User Enter the Controller Name in Search here Textbox <rownumber1>
    Then User select the the Examination from the from the Lookups <rownumber>
    And Enable the Location <rownumber>
    Then User click on Score Exam Tab
    And User select the Examination from the from the Lookups <rownumber>
    Then User select the Location from the from the Lookups <rownumber>
    And User Click on Score button and provide the score

    Examples: 
      | rownumber1 | rownumber  |
      |          1 |          0 |
