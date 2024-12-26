Feature: Verify the Grades for Teacher

  Scenario Outline: Checking the Student Reports by Grades
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    And User Click on Assessment Centre tab under Learning in Left menu
    #Activating & deactivating the toggles
    Then User click on the Assessment Centre Course <rownumber1><rownumber>
    #When User navigate to Benchmark tab
    #And activate the toggle and compare the Student status
    #Then capture the Benchmark band
    #Printing the Grades
    Then User navigates to Grade tab
    #And User select the Grades by activity and print
    # When User select the Grades by Standards and print
    #Match the score against the student benchmark
    # Then User stores the student score
    #Matching the Benchmark  Count
    #And User compares the Benchmark Count from Home tab
    #Navigating back to Landing page
    When User navigates back to Assessment landing page

    Examples: 
      | rownumber | rownumber1 |
      |         2 |          0 |
