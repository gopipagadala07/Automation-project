Feature: Verify the Score Submission at Teacher side

  #Scenario Outline: Validate the Score from Overall SpeedGrader
    #Given User launch the application with Valid URL
    #And User able to see all Fields
    #Then User enters the credentials from the excel sheet at <rownumber>
    #And User is on homepage
    #When Users Click on Assessment Centre tab in Left menu
    #When User Click on Overal Speed Grader
    #Then Select Dropdown in Speed Grader <rownumber1><rownumber2>
    #And clicks on Score button
    #Then Enter the Score and FeedBack and submit the Score
#
    #Then capture the status band
    #Examples: 
      #| rownumber | rownumber1 | rownumber2 |
      #|         2 |          0 |          3 |
#
  #Scenario Outline: Validate the Score from Activity Progress screen
    #Given User launch the application with Valid URL
    #And User able to see all Fields
    #Then User enters the credentials from the excel sheet at <rownumber>
    #And User is on homepage
    #When Users Click on Assessment Centre tab in Left menu
    #Then User click on the Assessment Centre Course <rownumber1><rownumber>
    #And Click on Quiz Tab and click on All
    #Then Provide the Score at Activity Progress screen
#
    #Examples: 
      #| rownumber | rownumber1 |
      #|         2 |          0 |

  Scenario Outline: Validate the Score In Assessment SpeedGrader screen
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    When Users Click on Speed Grader tab in Left menu
    And User click on the Exam
    Then Enter the Score and FeedBack and submit the Score
#Need to Change i-frame webelement while provide score for the Exam
    Examples: 
      | rownumber | 
      |         1 |     
