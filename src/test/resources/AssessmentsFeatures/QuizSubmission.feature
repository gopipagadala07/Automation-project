Feature: Performing Quiz at student side

  Scenario Outline: Submitting Quiz
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    Then user clicks on Learning and assessment center
    Then user clicks on the classroom name <rownumber1> <rownumber2>
    # And user clicks on the Assessment tab
    Then user clicks on Launch icon and complete test

    Examples: 
      | rownumber | rownumber1 | rownumber2 |
      |         3 |          0 |          2 |
