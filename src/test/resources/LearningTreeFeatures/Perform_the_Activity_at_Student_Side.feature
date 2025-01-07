Feature: Verify the Activities Creation Functionality

  Scenario Outline: Creating the the Activities
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    And User Click Learning Tree from Left menu
    Then User Saved the Course and Search for the Created Course in Search here Field<rownumber1>
    And User Click on that Course<rownumber1>
    And User go to Learning Tab
    Then User Click on Lunch button for the Assigment Activity

    #Course Designer Community Creation
    Examples: 
      | rownumber | rownumber1 |
      |         3 |          0 |
