Feature: Verify the Score Submission at Teacher side

  Scenario Outline: Validate the Score from Overall SpeedGrader
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    When Users Click on Assessment Centre tab in Left menu
    When User Click on Overal Speed Grader
    Then Select Dropdown in Speed Grader <rownumber1><rownumber2>
    And clicks on Score button
    Then Enter the Score and FeedBack
    And submit the Score
    Then capture the status band

    Examples: 
      | rownumber | rownumber1 | rownumber2 |
      |         2 |          0 |          3 |
  #Scenario Outline: Validate the Score from Activity Progress screen
    #Given User launch the application with Valid URL
    #And User able to see all Fields
    #Then User enters the credentials from the excel sheet at <rownumber>
    #When Search for particular Assessment Center Community and Click on it
    #Then Click on Quiz Tab and click on Progress
    #And Click on Score on the Progress Screen
    #Then Enter the Score and FeedBack
    #And submit the Score
    #Then capture the status band
